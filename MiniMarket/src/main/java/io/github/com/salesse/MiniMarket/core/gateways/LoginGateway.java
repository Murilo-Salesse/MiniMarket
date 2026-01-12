package io.github.com.salesse.MiniMarket.core.gateways;

import io.github.com.salesse.MiniMarket.core.entities.User;

public interface LoginGateway {
    User findByEmail(String email);
}
