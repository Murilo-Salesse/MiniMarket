package io.github.com.salesse.MiniMarket.infrastructure.security;

import java.util.Map;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class SecurityExceptionHandler {

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<?> handleAccessDenied() {
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
            .body(Map.of(
                "error", "Acesso negado",
                "message", "Você não tem permissão para acessar este recurso"
            ));
    }
    
    @ExceptionHandler(AuthorizationDeniedException.class)
    public ResponseEntity<?> handleAuthorizationDenied() {
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
            .body(Map.of(
                "error", "Acesso negado",
                "message", "Você não tem permissão para acessar este recurso"
            ));
    }
}
