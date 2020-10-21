
package com.github.schuettec.commandchain;

public class ReplaceStringCommand implements Command<ObjectToOperateOn> {

	private String find;
	private String replace;

	public static ReplaceStringCommand replaceCommand(String find, String replace) {
		return new ReplaceStringCommand(find, replace);
	}

	protected ReplaceStringCommand(String find, String replace) {
		super();
		this.find = find;
		this.replace = replace;
	}

	@Override
	public void execute(ObjectToOperateOn input) throws RuntimeException {
		String string = input.getString();
		string = string.replaceAll(find, replace);
		input.setString(string);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((find == null) ? 0 : find.hashCode());
		result = prime * result + ((replace == null) ? 0 : replace.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReplaceStringCommand other = (ReplaceStringCommand) obj;
		if (find == null) {
			if (other.find != null)
				return false;
		} else if (!find.equals(other.find))
			return false;
		if (replace == null) {
			if (other.replace != null)
				return false;
		} else if (!replace.equals(other.replace))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("Command to replace '%s' by '%s'.", find, replace);
	}

}
