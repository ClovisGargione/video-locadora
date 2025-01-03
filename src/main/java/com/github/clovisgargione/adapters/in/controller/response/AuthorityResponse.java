package com.github.clovisgargione.adapters.in.controller.response;

import com.github.clovisgargione.adapters.out.repository.enums.AuthorityName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorityResponse {

	private String id;
	
	private AuthorityName name;
}
