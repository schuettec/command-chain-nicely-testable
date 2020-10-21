package com.github.schuettec.commandchain;

public interface Command<I> {

	void execute(I input) throws RuntimeException;

}
