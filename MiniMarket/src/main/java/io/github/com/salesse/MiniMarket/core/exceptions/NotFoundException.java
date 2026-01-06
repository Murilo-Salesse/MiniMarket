package io.github.com.salesse.MiniMarket.core.exceptions;

public class NotFoundException extends RuntimeException{
	 private static final long serialVersionUID = 1L;

	 public NotFoundException(String message) {
	        super(message);
	    }
}
