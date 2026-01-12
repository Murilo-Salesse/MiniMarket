package io.github.com.salesse.MiniMarket.infrastructure.dtos.requests;

import java.util.Set;

import jakarta.validation.constraints.NotEmpty;

public class UpdateUserRolesRequest {

	@NotEmpty(message = "Informe ao menos uma role")
	private Set<String> roles;

	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}
}
