package io.github.com.salesse.MiniMarket.core.gateways;

import io.github.com.salesse.MiniMarket.core.entities.Role;

public interface RoleGateway {

	Role findByName(String name);
}
