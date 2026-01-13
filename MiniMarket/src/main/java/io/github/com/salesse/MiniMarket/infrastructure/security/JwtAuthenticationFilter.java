package io.github.com.salesse.MiniMarket.infrastructure.security;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import io.github.com.salesse.MiniMarket.core.gateways.TokenGateway;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	private final TokenGateway tokenGateway;

	public JwtAuthenticationFilter(TokenGateway tokenGateway) {
		this.tokenGateway = tokenGateway;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String authHeader = request.getHeader("Authorization");

		if (authHeader == null || !authHeader.startsWith("Bearer ")) {
			filterChain.doFilter(request, response);
			return;
		}

		String token = authHeader.substring(7);
		if (!tokenGateway.isTokenValid(token)) {
			filterChain.doFilter(request, response);
			return;
		}

		String userId = tokenGateway.getUserIdFromToken(token);
		List<String> roles = tokenGateway.getRolesFromToken(token);

		String storeId = tokenGateway.getStoreIdFromToken(token).orElse(null);

		
		List<GrantedAuthority> authorities = roles.stream()
				.map(role -> (GrantedAuthority) new SimpleGrantedAuthority("ROLE_" + role)).toList();

		Authentication authentication = new UsernamePasswordAuthenticationToken(userId, null, authorities);

		((AbstractAuthenticationToken) authentication).setDetails(
			    storeId != null ? UUID.fromString(storeId) : null
			);
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		filterChain.doFilter(request, response);
	}
}