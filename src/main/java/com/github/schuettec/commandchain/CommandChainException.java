package com.github.schuettec.commandchain;

public class CommandChainException extends RuntimeException {

	public CommandChainException() {
		super();
	}

	public CommandChainException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CommandChainException(String message, Throwable cause) {
		super(message, cause);
	}

	public CommandChainException(String message) {
		super(message);
	}

	public CommandChainException(Throwable cause) {
		super(cause);
	}
}
