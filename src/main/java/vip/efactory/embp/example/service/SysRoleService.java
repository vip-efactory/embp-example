package vip.efactory.embp.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import vip.efactory.embp.base.service.IBaseService;
import vip.efactory.embp.example.entity.SysRole;

import java.util.List;

/**
 * 服务类
 */
public interface SysRoleService extends IBaseService<SysRole> {

	/**
	 * 通过用户ID，查询角色信息
	 * @param userId
	 * @return
	 */
	List<SysRole> findRolesByUserId(Integer userId);

	/**
	 * 通过角色ID，删除角色
	 * @param id
	 * @return
	 */
	Boolean removeRoleById(Integer id);

}
