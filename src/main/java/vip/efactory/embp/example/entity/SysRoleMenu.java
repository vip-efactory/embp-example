package vip.efactory.embp.example.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import vip.efactory.embp.base.entity.BaseEntity;

/**
 * 角色菜单表
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysRoleMenu extends BaseEntity<SysRoleMenu> {

    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     */
    @ApiModelProperty(value = "角色id")
    private Integer roleId;

    /**
     * 菜单ID
     */
    @ApiModelProperty(value = "菜单id")
    private Integer menuId;

}
