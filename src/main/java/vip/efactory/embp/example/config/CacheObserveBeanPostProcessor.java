package vip.efactory.embp.example.config;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import vip.efactory.embp.example.service.impl.SysMenuServiceImpl;
import vip.efactory.embp.example.service.impl.SysRoleServiceImpl;
import vip.efactory.embp.example.service.impl.SysUserServiceImpl;

import javax.annotation.PostConstruct;

/**
 * Description: 统一处理缓存观察者模式的。避免局部处理的循环引用
 *
 * @Author dbdu
 * @Date 2020-08-24
 */
@AllArgsConstructor
@Component
@Slf4j
public class CacheObserveBeanPostProcessor {
    // menu ，user，role组件的缓存处理
    SysMenuServiceImpl sysMenuServiceImpl;
    SysUserServiceImpl sysUserServiceImpl;
    SysRoleServiceImpl sysRoleServiceImpl;


    private void init4menu() {
        log.info("开始注册menu的观察者...");
        sysMenuServiceImpl.registObservers(sysUserServiceImpl, sysRoleServiceImpl);
    }

    private void init4role() {
        log.info("开始注册role的观察者...");
        sysRoleServiceImpl.registObservers(sysUserServiceImpl);
    }

    @PostConstruct
    private void initCacheObserve() {
        init4menu();
        init4role();
    }
}
