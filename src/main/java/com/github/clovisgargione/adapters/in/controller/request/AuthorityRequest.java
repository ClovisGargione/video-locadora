package com.github.clovisgargione.adapters.in.controller.request;

import com.github.clovisgargione.adapters.out.repository.enums.AuthorityName;

import lombok.Data;

@Data
public class AuthorityRequest {

	private AuthorityName name;
	
	public AuthorityRequest() {
		
	}

	public AuthorityRequest(AuthorityName name) {
		super();
		this.name = name;
	}
}
