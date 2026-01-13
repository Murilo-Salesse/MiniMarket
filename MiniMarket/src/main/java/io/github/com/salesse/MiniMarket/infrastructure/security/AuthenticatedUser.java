package io.github.com.salesse.MiniMarket.infrastructure.security;

import java.util.UUID;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public final class AuthenticatedUser {

    private AuthenticatedUser() {}

    public static UUID getUserId() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth == null || !auth.isAuthenticated()) {
            return null;
        }

        return UUID.fromString(auth.getName());
    }

    public static UUID getStoreId() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth == null || !auth.isAuthenticated()) {
            return null;
        }

        Object storeId = auth.getDetails();
        return storeId instanceof UUID ? (UUID) storeId : null;
    }
}