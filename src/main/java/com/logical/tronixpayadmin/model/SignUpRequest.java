package com.logical.tronixpayadmin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SignUpRequest {
    private String adminName;

    private String email;

    private String password;
	
}
