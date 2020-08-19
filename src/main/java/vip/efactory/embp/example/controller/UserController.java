package vip.efactory.embp.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import vip.efactory.common.base.utils.R;
import vip.efactory.embp.base.controller.BaseController;
import vip.efactory.embp.example.dto.UserDTO;
import vip.efactory.embp.example.entity.SysUser;
import vip.efactory.embp.example.service.SysUserService;

import javax.validation.Valid;
import java.io.Serializable;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Api(value = "user", tags = "用户管理模块")
public class UserController extends BaseController<SysUser, SysUserService> {
//
//    /**
//     * 分页查询用户
//     *
//     * @param page    参数集
//     * @param userDTO 查询参数列表
//     * @return 用户集合
//     */
//    @GetMapping("/page")
//    public R getUserPage(Page page, UserDTO userDTO) {
//        return R.ok(entityService.getUserWithRolePage(page, userDTO));
//    }
//
//    /**
//     * 获取指定用户全部信息
//     *
//     * @return 用户信息
//     */
//    @GetMapping("/info/{username}")
//    public R info(@PathVariable String username) {
//        SysUser user = entityService.getOne(Wrappers.<SysUser>query().lambda().eq(SysUser::getUsername, username));
//        if (user == null) {
//            return R.error(String.format("用户信息为空 %s", username));
//        }
//        return R.ok(entityService.getUserInfo(user));
//    }
//
//    /**
//     * 通过ID查询用户信息
//     *
//     * @param id ID
//     * @return 用户信息
//     */
//    @GetMapping("/{id}")
//    public R user(@PathVariable Integer id) {
//        return R.ok(entityService.getUserVoById(id));
//    }

//    /**
//     * 根据用户名查询用户信息
//     *
//     * @param username 用户名
//     * @return
//     */
//    @GetMapping("/details/{username}")
//    public R user(@PathVariable String username) {
//        SysUser condition = new SysUser();
//        condition.setUsername(username);
//        return R.ok(entityService.getOne(new QueryWrapper<>(condition)));
//    }
//
//    /**
//     * 添加用户
//     *
//     * @param userDto 用户信息
//     * @return success/false
//     */
//    @PostMapping
//    public R save(@RequestBody UserDTO userDto) {
//        return R.ok(entityService.saveUser(userDto));
//    }
//
//    /**
//     * 修改个人信息
//     *
//     * @param userDto userDto
//     * @return success/false
//     */
//    @PutMapping("/update")
//    public R update(@RequestBody UserDTO userDto) {
//        return entityService.updateUserInfo(userDto);
//    }
//
//    /**
//     * 删除用户信息
//     *
//     * @param id ID
//     * @return R
//     */
//    @DeleteMapping("/{id}")
//    public R userDel(@PathVariable Integer id) {
//        SysUser sysUser = entityService.getById(id);
//        return R.ok(entityService.removeUserById(sysUser));
//    }
//
//    /**
//     * 更新用户信息，有角色关联处理
//     *
//     * @param userDto 用户信息
//     * @return R
//     */
//    @PutMapping
//    public R updateUser(@RequestBody UserDTO userDto) {
//        return R.ok(entityService.updateUser(userDto));
//    }

    @Override
    @GetMapping("/page")
    public R getByPage(Page page) {
        return super.getByPage(page);
    }

    @Override
    @GetMapping("/{id}")
    public R getById(@PathVariable("id") Serializable entityId) {
        return super.getById(entityId);
    }

    @Override
    @PostMapping
    public R save(@RequestBody SysUser entity) {
        return super.save(entity);
    }

    @Override
    @PutMapping
    public R updateById(@RequestBody SysUser entity) {
        return super.updateById(entity);
    }

    @Override
    @DeleteMapping("/{id}")
    public R deleteById(@PathVariable("id") Serializable entityId) {
        return super.deleteById(entityId);
    }
}
