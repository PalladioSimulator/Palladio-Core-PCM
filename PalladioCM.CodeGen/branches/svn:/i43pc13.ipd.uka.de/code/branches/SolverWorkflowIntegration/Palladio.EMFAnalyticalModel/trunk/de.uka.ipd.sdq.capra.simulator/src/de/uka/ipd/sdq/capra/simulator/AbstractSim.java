package de.uka.ipd.sdq.capra.simulator;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;

import de.uka.ipd.sdq.scheduler.LoggingWrapper;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;

public abstract class AbstractSim {

	protected static long duration = 0;
	protected static IDAOFactory factory = null;
	protected static boolean debug = false;
	protected static String experiment_file;

	protected static void initialize(String[] args) {
		CommandLine cmdLine = getCommandLine(args);
		duration = Long.parseLong(cmdLine.getOptionValue("m")) * 1000;
		experiment_file = cmdLine.getOptionValue("e");
		debug = cmdLine.hasOption("g");
		if (debug) {
			LoggingWrapper.activate();
		} else {
			LoggingWrapper.deactivate();
		}
	}

	protected static void close() {
		factory.finalizeAndClose();
		System.exit(0);
	}

	private static CommandLine getCommandLine(String[] args) {
		CommandLine cmdLine = null;
		try {
			cmdLine = new PosixParser().parse(options, args);
			if (!(cmdLine.hasOption("m") && cmdLine.hasOption("e"))){
				cmdLine = null;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (cmdLine == null) {
			HelpFormatter formatter = new HelpFormatter();
			formatter.printHelp("CapraSim", options);
			System.exit(-1);
		}
		return cmdLine;
	}

	protected static Options options = new Options();

	static {
		options.addOption("e", "experiment", true, "name of the experiment file");
		options.addOption("m", "simulation-period", true,
				"simulated period in seconds");
		options.addOption("g", "debug", false,
				"enable debug output of the simulation");
	}
}
