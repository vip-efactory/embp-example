package vip.efactory.embp.example.service.impl;

import org.springframework.stereotype.Service;
import vip.efactory.embp.base.service.impl.BaseServiceImpl;
import vip.efactory.embp.example.entity.SysUserRole;
import vip.efactory.embp.example.mapper.SysUserRoleMapper;
import vip.efactory.embp.example.service.SysUserRoleService;

/**
 * 用户角色表 服务实现类
 *
 * @author dbdu
 */
@Service
public class SysUserRoleServiceImpl extends BaseServiceImpl<SysUserRole, SysUserRoleMapper> implements SysUserRoleService {

    /**
     * 根据用户Id删除该用户的角色关系
     *
     * @param userId 用户ID
     * @return boolean
     * @author 寻欢·李
     * @date 2017年12月7日 16:31:38
     */
    @Override
    public Boolean removeRoleByUserId(Integer userId) {
        return baseMapper.deleteByUserId(userId);
    }

}
