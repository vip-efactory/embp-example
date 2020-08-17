package vip.efactory.embp.example.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import vip.efactory.embp.example.entity.SysRole;


@Data
@EqualsAndHashCode(callSuper = true)
public class RoleDTO extends SysRole {

	/**
	 * 角色部门Id
	 */
	private Integer roleDeptId;

	/**
	 * 部门名称
	 */
	private String deptName;

}
