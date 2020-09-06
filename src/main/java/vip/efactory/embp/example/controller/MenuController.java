package vip.efactory.embp.example.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import vip.efactory.common.base.utils.R;
import vip.efactory.embp.base.controller.BaseController;
import vip.efactory.embp.example.entity.SysMenu;
import vip.efactory.embp.example.service.SysMenuService;

import javax.validation.Valid;
import java.io.Serializable;


@RestController
@RequiredArgsConstructor
@RequestMapping("/menu")
@Api(value = "menu", tags = "菜单管理模块")
public class MenuController extends BaseController<SysMenu, SysMenuService> {

//    /**
//     * 返回树形菜单集合
//     *
//     * @param lazy     是否是懒加载
//     * @param parentId 父节点ID
//     * @return 树形菜单
//     */
//    @GetMapping(value = "/tree")
//    public R getTree(boolean lazy, Integer parentId) {
//        return R.ok(entityService.treeMenu(lazy, parentId));
//    }
//
//    /**
//     * 返回角色的菜单集合
//     *
//     * @param roleId 角色ID
//     * @return 属性集合
//     */
//    @GetMapping("/tree/{roleId}")
//    public R getRoleTree(@PathVariable Integer roleId) {
//        return R.ok(
//                entityService.findMenuByRoleId(roleId).stream().map(MenuVO::getMenuId).collect(Collectors.toList()));
//    }
//
//    /**
//     * 通过ID查询菜单的详细信息
//     *
//     * @param id 菜单ID
//     * @return 菜单详细信息
//     */
//    @GetMapping("/{id}")
//    public R getById(@PathVariable Integer id) {
//        return R.ok(entityService.getById(id));
//    }
//
//    /**
//     * 新增菜单
//     *
//     * @param sysMenu 菜单信息
//     * @return 含ID 菜单信息
//     */
//    @Override
//    @PostMapping
//    public R save(@Valid @RequestBody SysMenu sysMenu) {
//        entityService.save(sysMenu);
//        return R.ok(sysMenu);
//    }
//
//    /**
//     * 删除菜单
//     *
//     * @param id 菜单ID
//     * @return success/false
//     */
//    @DeleteMapping("/{id}")
//    public R removeById(@PathVariable Integer id) {
//        return entityService.removeMenuById(id);
//    }
//
    /**
     * 更新菜单
     *
     * @param sysMenu
     * @return
     */
    @PutMapping
    public R update(@Valid @RequestBody SysMenu sysMenu) {
        return R.ok(entityService.updateMenuById(sysMenu));
    }

    // CRUD 模板方法 开始 //
    @Override
    @GetMapping("/page")
    public R getByPage(Page page) {
        return super.getByPage(page);
    }

    @PostMapping(value = "/advanced/query")
    @Override
    public R advancedQuery(@RequestBody SysMenu entity) {
        return R.ok(entityService.advancedQuery(entity));
    }

    /**
     * 多字段模糊查询
     * @param q 要查询的值
     * @param fields 要模糊查询的字段，多个字段逗号分隔
     * @return R
     */
    @PostMapping(value = "/multi/query")
    @Override
    public R queryMultiField(@RequestParam("q") String q, @RequestParam("fields") String fields) {
        return super.queryMultiField(q, fields);
    }

    @Override
    @GetMapping("/{id}")
    public R getById(@PathVariable("id") Serializable entityId) {
        return super.getById(entityId);
    }

    @Override
    @PostMapping
    public R save(@RequestBody SysMenu entity) {
        return super.save(entity);
    }

//    @Override
//    @PutMapping
//    public R updateById(@RequestBody SysMenu entity) {
//        return super.updateById(entity);
//    }

    @Override
    @DeleteMapping("/{id}")
    public R deleteById(@PathVariable("id") Serializable entityId) {
        return super.deleteById(entityId);
    }
    // CRUD 模板方法 结束 //


}
