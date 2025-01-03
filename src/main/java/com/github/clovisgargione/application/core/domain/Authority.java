package com.github.clovisgargione.application.core.domain;

import com.github.clovisgargione.application.core.enums.AuthorityName;

public class Authority {

	private String id;
	
    private AuthorityName name;

	public Authority() {
		super();
	}

	public Authority(String id, AuthorityName name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public AuthorityName getName() {
		return name;
	}

	public void setName(AuthorityName name) {
		this.name = name;
	}
}
