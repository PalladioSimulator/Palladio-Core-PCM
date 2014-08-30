package org.palladiosimulator.protocom.framework.java.ee.prototype;

public class System {
	private String name;
	private String className;

	public System(String name, String className) {
		this.name = name;
		this.className = className;
	}

	public String getName() {
		return name;
	}

	public String getClassName() {
		return className;
	}
}
