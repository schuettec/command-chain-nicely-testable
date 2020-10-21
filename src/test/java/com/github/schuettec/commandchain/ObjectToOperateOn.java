
package com.github.schuettec.commandchain;

public class ObjectToOperateOn {

	private String string;

	public ObjectToOperateOn(String string) {
		super();
		this.string = string;
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	@Override
	public String toString() {
		return "ObjectToOperateOn [string=" + string + "]";
	}

}
