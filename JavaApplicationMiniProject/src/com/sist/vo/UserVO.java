package com.sist.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserVO {
	private String id, password,name, adr1,adr2,sex,email,image;
	private int birth;
	private boolean admin;
}
