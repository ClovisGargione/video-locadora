package com.github.clovisgargione.adapters.in.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenResponse {

	private String token;

    private long expiresIn;
}
