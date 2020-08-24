package vip.efactory.embp.example.service.impl;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vip.efactory.common.base.utils.R;
import vip.efactory.embp.base.service.impl.BaseObservable;
import vip.efactory.embp.base.service.impl.BaseServiceImpl;
import vip.efactory.embp.example.dto.UserDTO;
import vip.efactory.embp.example.dto.UserInfo;
import vip.efactory.embp.example.entity.SysRole;
import vip.efactory.embp.example.entity.SysUser;
import vip.efactory.embp.example.entity.SysUserRole;
import vip.efactory.embp.example.mapper.SysUserMapper;
import vip.efactory.embp.example.service.SysMenuService;
import vip.efactory.embp.example.service.SysRoleService;
import vip.efactory.embp.example.service.SysUserRoleService;
import vip.efactory.embp.example.service.SysUserService;
import vip.efactory.embp.example.vo.MenuVO;
import vip.efactory.embp.example.vo.UserVO;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Slf4j
@Service
@RequiredArgsConstructor
public class SysUserServiceImpl extends BaseServiceImpl<SysUser, SysUserMapper> implements SysUserService {
    static final String STATUS_NORMAL = "0";

    private final SysMenuService sysMenuService;

    private final SysRoleService sysRoleService;

    private final SysUserRoleService sysUserRoleService;

    /**
     * 保存用户信息
     *
     * @param userDto DTO 对象
     * @return success/fail
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean saveUser(UserDTO userDto) {
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(userDto, sysUser);
        sysUser.setDelFlag(STATUS_NORMAL);
        sysUser.setPassword(userDto.getPassword());
        baseMapper.insert(sysUser);
        List<SysUserRole> userRoleList = userDto.getRole().stream().map(roleId -> {
            SysUserRole userRole = new SysUserRole();
            userRole.setUserId(sysUser.getUserId());
            userRole.setRoleId(roleId);
            return userRole;
        }).collect(Collectors.toList());
        return sysUserRoleService.saveBatch(userRoleList);
    }

    /**
     * 通过查用户的全部信息
     *
     * @param sysUser 用户
     * @return
     */
    @Override
    public UserInfo getUserInfo(SysUser sysUser) {
        UserInfo userInfo = new UserInfo();
        userInfo.setSysUser(sysUser);
        // 设置角色列表 （ID）
        List<Integer> roleIds = sysRoleService.findRolesByUserId(sysUser.getUserId()).stream().map(SysRole::getRoleId)
                .collect(Collectors.toList());
        userInfo.setRoles(ArrayUtil.toArray(roleIds, Integer.class));

        // 设置权限列表（menu.permission）
        Set<String> permissions = new HashSet<>();
        roleIds.forEach(roleId -> {
            List<String> permissionList = sysMenuService.findMenuByRoleId(roleId).stream()
                    .filter(menuVo -> StringUtils.isNotEmpty(menuVo.getPermission())).map(MenuVO::getPermission)
                    .collect(Collectors.toList());
            permissions.addAll(permissionList);
        });
        userInfo.setPermissions(ArrayUtil.toArray(permissions, String.class));
        return userInfo;
    }

    /**
     * 分页查询用户信息（含有角色信息）
     *
     * @param page    分页对象
     * @param userDTO 参数列表
     * @return
     */
    @Override
    @Cacheable(value = "USER_DETAILS")
    public IPage getUserWithRolePage(Page page, UserDTO userDTO) {
        return baseMapper.getUserVosPage(page, userDTO);
    }

    /**
     * 通过ID查询用户信息
     *
     * @param id 用户ID
     * @return 用户信息
     */
    @Override
    public UserVO getUserVoById(Integer id) {
        return baseMapper.getUserVoById(id);
    }

    /**
     * 删除用户
     *
     * @param sysUser 用户
     * @return Boolean
     */
    @Override
    @CacheEvict(value = "USER_DETAILS", key = "#sysUser.username")
    public Boolean removeUserById(SysUser sysUser) {
        sysUserRoleService.removeRoleByUserId(sysUser.getUserId());
        this.removeById(sysUser.getUserId());
        return Boolean.TRUE;
    }

    @Override
    @CacheEvict(value = "USER_DETAILS", key = "#userDto.username")
    public R updateUserInfo(UserDTO userDto) {
        UserVO userVO = baseMapper.getUserVoByUsername(userDto.getUsername());

        SysUser sysUser = new SysUser();
        sysUser.setPassword(userDto.getNewpassword1());
        sysUser.setPhone(userDto.getPhone());
        sysUser.setUserId(userVO.getUserId());
        sysUser.setAvatar(userDto.getAvatar());
        return R.ok(this.updateById(sysUser));
    }

    @Override
    @CacheEvict(value = "USER_DETAILS", key = "#userDto.username")
    public Boolean updateUser(UserDTO userDto) {
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(userDto, sysUser);
        sysUser.setUpdateTime(LocalDateTime.now());

        if (StrUtil.isNotBlank(userDto.getPassword())) {
            sysUser.setPassword(userDto.getPassword());
        }
        this.updateById(sysUser);

        sysUserRoleService
                .remove(Wrappers.<SysUserRole>update().lambda().eq(SysUserRole::getUserId, userDto.getUserId()));
        userDto.getRole().forEach(roleId -> {
            SysUserRole userRole = new SysUserRole();
            userRole.setUserId(sysUser.getUserId());
            userRole.setRoleId(roleId);
            userRole.insert();
        });
        return Boolean.TRUE;
    }

    // 联动清除本地的缓存！
    @Override
    @CacheEvict(value = "USER_DETAILS",allEntries = true)
    public void update(BaseObservable o, Object arg) {
        log.info("联动清除user缓存信息.....");
    }
}
