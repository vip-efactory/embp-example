package vip.efactory.embp.example.service;

import vip.efactory.common.base.utils.R;
import vip.efactory.embp.base.service.IBaseService;
import vip.efactory.embp.example.dto.MenuTree;
import vip.efactory.embp.example.entity.SysMenu;
import vip.efactory.embp.example.vo.MenuVO;

import java.util.List;

/**
 * 菜单权限表 服务类
 */
public interface SysMenuService extends IBaseService<SysMenu> {

    /**
     * 通过角色编号查询URL 权限
     *
     * @param roleId 角色ID
     * @return 菜单列表
     */
    List<MenuVO> findMenuByRoleId(Integer roleId);

    /**
     * 级联删除菜单
     *
     * @param id 菜单ID
     * @return true成功, false失败
     */
    R removeMenuById(Integer id);

    /**
     * 更新菜单信息
     *
     * @param sysMenu 菜单信息
     * @return 成功、失败
     */
    Boolean updateMenuById(SysMenu sysMenu);

    /**
     * 构建树
     *
     * @param lazy     是否是懒加载
     * @param parentId 父节点ID
     * @return
     */
    List<MenuTree> treeMenu(boolean lazy, Integer parentId);


}
