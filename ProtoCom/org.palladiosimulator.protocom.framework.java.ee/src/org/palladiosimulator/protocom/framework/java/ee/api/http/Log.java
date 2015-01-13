package org.palladiosimulator.protocom.framework.java.ee.api.http;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

@Path("/log")
public class Log {
	@PUT
	@Path("enable")
	public void enableLog() {
		Logger.getRootLogger().setLevel(Level.INFO);
	}

	@PUT
	@Path("disable")
	public void disableLog() {
		Logger.getRootLogger().setLevel(Level.OFF);
	}
}
