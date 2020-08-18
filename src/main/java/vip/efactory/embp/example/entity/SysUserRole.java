package vip.efactory.embp.example.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import vip.efactory.embp.base.entity.BaseEntity;

/**
 * 用户角色表
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysUserRole extends BaseEntity<SysUserRole> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户id")
    private Integer userId;

    /**
     * 角色ID
     */
    @ApiModelProperty(value = "角色id")
    private Integer roleId;

}
