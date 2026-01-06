package io.github.com.salesse.MiniMarket.infrastructure.dtos.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserUpdateRequest {

	@NotBlank(message = "Nome deve ser preenchido")
	@Size(min = 4, message = "Nome deve ter no mínimo 4 caracteres")
	private String name;

	@NotBlank(message = "Email deve ser preenchido")
	@Email
	private String email;

	@NotBlank(message = "Telefone deve ser preenchido")
	@NotBlank
	private String phone;

	@NotBlank(message = "Senha deve ser preenchida")
	@NotBlank
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
