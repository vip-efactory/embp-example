package vip.efactory.embp.example.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import vip.efactory.embp.example.entity.SysUser;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserDTO extends SysUser {

	/**
	 * 角色ID
	 */
	private List<Integer> role;

	private Integer deptId;

	/**
	 * 新密码
	 */
	private String newpassword1;

}
