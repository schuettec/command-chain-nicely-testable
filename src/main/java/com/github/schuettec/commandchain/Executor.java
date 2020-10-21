package com.github.schuettec.commandchain;

import static java.util.Objects.requireNonNull;

import java.util.LinkedList;
import java.util.List;

public class Executor<I> implements Command<I> {

	private List<Command<I>> commandChain;

	private Executor(List<Command<I>> commandChain) {
		super();
		this.commandChain = commandChain;
	}

	public static <I> ExecutorBuilder<I> operateOn(Class<I> inputType) {
		return new ExecutorBuilder<I>();
	}

	static class ExecutorBuilder<I> {
		private List<Command<I>> commandChain;

		private ExecutorBuilder() {
			super();
			this.commandChain = new LinkedList<>();
		}

		public ExecutorBuilder<I> execute(Command<I> commandToAdd) {
			this.commandChain.add(commandToAdd);
			return this;
		}

		public Executor<I> build() {
			return new Executor<I>(commandChain);
		}
	}

	@Override
	public void execute(I input) {
		requireNonNull(input, "Input must not be null.");
		commandChain.stream().forEach(command -> {
			try {
				command.execute(input);
			} catch (RuntimeException e) {
				throw e;
			} catch (Exception e) {
				throw new CommandChainException("Unexpected exception thrown while executing command chain.", e);
			}
		});
	}

	public List<Command<I>> getCommands() {
		return new LinkedList<>(commandChain);
	}

}
