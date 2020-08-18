package vip.efactory.embp.example.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vip.efactory.embp.base.service.impl.BaseServiceImpl;
import vip.efactory.embp.example.entity.SysRole;
import vip.efactory.embp.example.entity.SysRoleMenu;
import vip.efactory.embp.example.mapper.SysRoleMapper;
import vip.efactory.embp.example.mapper.SysRoleMenuMapper;
import vip.efactory.embp.example.service.SysRoleService;

import java.util.List;

/**
 * 服务实现类
 */
@Service
@RequiredArgsConstructor
public class SysRoleServiceImpl extends BaseServiceImpl<SysRole, SysRoleMapper> implements SysRoleService {

    private final SysRoleMenuMapper sysRoleMenuMapper;

    /**
     * 通过用户ID，查询角色信息
     *
     * @param userId
     * @return
     */
    @Override
    public List findRolesByUserId(Integer userId) {
        return baseMapper.listRolesByUserId(userId);
    }

    /**
     * 通过角色ID，删除角色,并清空角色菜单缓存
     *
     * @param id
     * @return
     */
    @Override
    @CacheEvict(value = "MENU_DETAILS", allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public Boolean removeRoleById(Integer id) {
        sysRoleMenuMapper.delete(Wrappers.<SysRoleMenu>update().lambda().eq(SysRoleMenu::getRoleId, id));
        return this.removeById(id);
    }

}
