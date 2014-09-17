package org.palladiosimulator.protocom.framework.java.ee.modules;


/**
 * The Module class is the common base class for modules.
 * A module represents an entity (e.g., component) that can be started by a user.
 *
 * @author Christian Klaussner
 */
public abstract class Module {
	private String id;
	private String name, displayName;
	private boolean started;

	/**
	 * Constructs a new Module object.
	 * @param id the ID of the module
	 * @param name the name of the module
	 * @param permanent true if the module is permanent, otherwise false
	 */
	public Module(String id, String name) {
		this.id = id;
		this.name = name;
	}

	/**
	 * Gets the ID of the module.
	 * @return the ID of the module
	 */
	public String getId() {
		return id;
	}

	/**
	 * Gets the name of the module.
	 * @return the name of the module
	 */
	public String getName() {
		return name;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}

	/**
	 * Checks whether the module is started.
	 * @return true if the module is started, otherwise false
	 */
	public boolean isStarted() {
		return started;
	}

	/**
	 * Sets the started state of the module.
	 * @param started true if the module is started, otherwise false
	 */
	public void setStarted(boolean started) {
		this.started = started;
	}

	/**
	 * Starts the module.
	 * @param location the location of the module
	 * @throws ModuleStartException when the module could not be started
	 */
	public abstract void start(String location) throws ModuleStartException;
}
