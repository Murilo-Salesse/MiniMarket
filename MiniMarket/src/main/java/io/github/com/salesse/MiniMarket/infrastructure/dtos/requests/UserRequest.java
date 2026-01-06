package io.github.com.salesse.MiniMarket.infrastructure.dtos.requests;

import java.util.UUID;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserRequest {

	@NotBlank(message = "Nome deve ser preenchido")
	@Size(min = 4, message = "Nome deve ter no mínimo 4 caracteres")
	private String name;

	@NotNull(message = "ID da loja deve ser informado")
	private UUID storeId;

	@NotBlank(message = "Email deve ser preenchido")
	@Email(message = "Email inválido")
	private String email;

	@NotBlank(message = "Telefone deve ser preenchido")
	private String phone;

	@NotBlank(message = "Senha deve ser preenchida")
	@Size(min = 6, message = "Senha deve ter no mínimo 6 caracteres")
	private String password;

	public UserRequest() {
		super();
	}

	public UserRequest(
			@NotBlank(message = "Nome deve ser preenchido") @Size(min = 4, message = "Nome deve ter no mínimo 4 caracteres") String name,
			@NotNull(message = "ID da loja deve ser informado") UUID storeId,
			@NotBlank(message = "Email deve ser preenchido") @Email(message = "Email inválido") String email,
			@NotBlank(message = "Telefone deve ser preenchido") String phone,
			@NotBlank(message = "Senha deve ser preenchida") @Size(min = 6, message = "Senha deve ter no mínimo 6 caracteres") String password) {
		super();
		this.name = name;
		this.storeId = storeId;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UUID getStoreId() {
		return storeId;
	}

	public void setStoreId(UUID storeId) {
		this.storeId = storeId;
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