package com.logical.tronixpayadmin.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignInResponse {
	public boolean result;
	public String message;
	public int adminId;
	public String email;
	public String password;
	public String profileImgUrl;
	public String token;
}
