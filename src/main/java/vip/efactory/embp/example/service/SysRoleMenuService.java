package vip.efactory.embp.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import vip.efactory.embp.base.service.IBaseService;
import vip.efactory.embp.example.entity.SysRoleMenu;

/**
 * 角色菜单表 服务类
 */
public interface SysRoleMenuService extends IBaseService<SysRoleMenu> {

	/**
	 * 更新角色菜单
	 * @param role
	 * @param roleId 角色
	 * @param menuIds 菜单ID拼成的字符串，每个id之间根据逗号分隔
	 * @return
	 */
	Boolean saveRoleMenus(String role, Integer roleId, String menuIds);

}
