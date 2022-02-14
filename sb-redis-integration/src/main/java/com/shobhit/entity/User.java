package com.shobhit.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String HASH = "User";

	private int userId;
	private String userName;
	private String password;
	private boolean admin;
}