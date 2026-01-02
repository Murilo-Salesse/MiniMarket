package io.github.com.salesse.MiniMarket.infrastructure.dtos.responses;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StoreResponse {

	private UUID id;
	private String name;
	private String cnpj;
	private String address;
	private String phone;

	public StoreResponse() {
		super();
	}

	public StoreResponse(UUID id, String name, String cnpj, String address, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.cnpj = cnpj;
		this.address = address;
		this.phone = phone;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
