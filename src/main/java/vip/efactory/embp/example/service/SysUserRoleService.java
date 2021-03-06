package vip.efactory.embp.example.service;

import vip.efactory.embp.base.service.IBaseService;
import vip.efactory.embp.example.entity.SysUserRole;

/**
 * 用户角色表 服务类
 */
public interface SysUserRoleService extends IBaseService<SysUserRole> {

    /**
     * 根据用户Id删除该用户的角色关系
     *
     * @param userId 用户ID
     * @return boolean
     * @author 寻欢·李
     * @date 2017年12月7日 16:31:38
     */
    Boolean removeRoleByUserId(Integer userId);

}
