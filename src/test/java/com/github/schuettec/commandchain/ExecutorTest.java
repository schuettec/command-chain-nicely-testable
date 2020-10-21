package com.github.schuettec.commandchain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class ExecutorTest {

	@Test
	public void executorExample() {
		Executor<ObjectToOperateOn> executionPlan = Executor.operateOn(ObjectToOperateOn.class)
				.execute(ReplaceStringCommand.replaceCommand("forename", "Eduard"))
				.execute(ReplaceStringCommand.replaceCommand("name", "Earthling")).build();

		String message = "Hallo forename name! Welcome on earth!";
		ObjectToOperateOn obj = new ObjectToOperateOn(message);

		executionPlan.execute(obj);

		assertEquals("Hallo Eduard Earthling! Welcome on earth!", obj.getString());

		List<Command<ObjectToOperateOn>> commands = executionPlan.getCommands();
		assertThat(commands).containsExactlyInAnyOrder(ReplaceStringCommand.replaceCommand("forename", "Eduard"),
				ReplaceStringCommand.replaceCommand("name", "Earthling"));

	}

}
