package com.github.clovisgargione.adapters.in.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginUsuarioRequest {

	private String email;
    
    private String password;
}
