package vip.efactory.embp.example.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vip.efactory.common.base.bean.ObserveData;
import vip.efactory.common.base.bean.OperateTypeEnum;
import vip.efactory.common.base.utils.R;
import vip.efactory.embp.base.service.impl.BaseServiceImpl;
import vip.efactory.embp.example.dto.MenuTree;
import vip.efactory.embp.example.entity.SysMenu;
import vip.efactory.embp.example.entity.SysRoleMenu;
import vip.efactory.embp.example.mapper.SysMenuMapper;
import vip.efactory.embp.example.mapper.SysRoleMenuMapper;
import vip.efactory.embp.example.service.SysMenuService;
import vip.efactory.embp.example.vo.MenuVO;
import vip.efactory.embp.example.vo.TreeUtil;

import java.util.List;

/**
 * 菜单权限表 服务实现类
 */
@Service
@RequiredArgsConstructor
public class SysMenuServiceImpl extends BaseServiceImpl<SysMenu, SysMenuMapper> implements SysMenuService {
    /**
     * 菜单树根节点
     */
    static final Integer MENU_TREE_ROOT_ID = -1;

    /**
     * 菜单
     */
    static final String MENU = "0";

    private final SysRoleMenuMapper sysRoleMenuMapper;

    @Override
    @Cacheable(value = "MENU_DETAILS", key = "#roleId  + '_menu'", unless = "#result == null")
    public List<MenuVO> findMenuByRoleId(Integer roleId) {
        return baseMapper.listMenusByRoleId(roleId);
    }

    /**
     * 级联删除菜单
     *
     * @param id 菜单ID
     * @return true成功, false失败
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    @CacheEvict(value = "MENU_DETAILS", allEntries = true)
    public R removeMenuById(Integer id) {
        // 查询父节点为当前节点的节点
        List<SysMenu> menuList = this.list(Wrappers.<SysMenu>query().lambda().eq(SysMenu::getParentId, id));

        if (CollUtil.isNotEmpty(menuList)) {
            return R.error("菜单含有下级不能删除");
        }

        sysRoleMenuMapper.delete(Wrappers.<SysRoleMenu>query().lambda().eq(SysRoleMenu::getMenuId, id));
        // 删除当前菜单及其子菜单
        return R.ok(this.removeById(id));
    }

    @Override
    @CacheEvict(value = "MENU_DETAILS", allEntries = true)
    public Boolean updateMenuById(SysMenu sysMenu) {
        boolean ret = this.updateById(sysMenu);
        if (ret) {
            // 不传递数据
//            notifyOthers(null);
            // 传递数据
            ObserveData data = new ObserveData("SysMenu", OperateTypeEnum.UPDATE.getCode(), sysMenu.getMenuId().toString());
            notifyOthers(data);
        }
        return ret;
    }

    /**
     * 构建树查询 1. 不是懒加载情况，查询全部 2. 是懒加载，根据parentId 查询 2.1 父节点为空，则查询ID -1
     *
     * @param lazy     是否是懒加载
     * @param parentId 父节点ID
     * @return
     */
    @Override
    public List<MenuTree> treeMenu(boolean lazy, Integer parentId) {
        if (!lazy) {
            return TreeUtil.buildTree(
                    baseMapper.selectList(Wrappers.<SysMenu>lambdaQuery().orderByAsc(SysMenu::getSort)),
                    MENU_TREE_ROOT_ID);
        }

        Integer parent = parentId == null ? MENU_TREE_ROOT_ID : parentId;
        return TreeUtil.buildTree(
                baseMapper.selectList(
                        Wrappers.<SysMenu>lambdaQuery().eq(SysMenu::getParentId, parent).orderByAsc(SysMenu::getSort)),
                parent);
    }
}
