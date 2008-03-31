package de.uka.ipd.sdq.capra.simulator;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;

import de.uka.ipd.sdq.scheduler.LoggingWrapper;
import de.uka.ipd.sdq.sensorframework.dao.file.FileDAOFactory;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;

public abstract class AbstractSim {

	protected static String directory;
	protected static long duration;
	protected static IDAOFactory factory;
	protected static long delay = 0;
	protected static int demand = 250;
	protected static String capra_file = "scenario.capra";
	protected static String library_file = "library.scheduler";
	protected static String scheduler_file = "scenario.scheduler";
	protected static String summary_file = null;
	protected static boolean debug = false;
	protected static String name = "Test";

	protected static void initialize(String[] args) {
		CommandLine cmdLine = getCommandLine(args);
		directory = cmdLine.getOptionValue("D");
		duration = Long.parseLong(cmdLine.getOptionValue("m")) * 1000;
		if (cmdLine.hasOption("c")) {
			capra_file = cmdLine.getOptionValue("c");
		}
		if (cmdLine.hasOption("l")) {
			library_file = cmdLine.getOptionValue("l");
		}
		if (cmdLine.hasOption("s")) {
			scheduler_file = cmdLine.getOptionValue("s");
		}
		if (cmdLine.hasOption("u")) {
			summary_file = cmdLine.getOptionValue("u");
		}
		if (cmdLine.hasOption("v")) {
			delay = Long.parseLong(cmdLine.getOptionValue("v"));
		}
		if (cmdLine.hasOption("d")) {
			demand = Integer.parseInt(cmdLine.getOptionValue("d"));
		}
		if (cmdLine.hasOption("n")) {
			name = cmdLine.getOptionValue("n");
		}
		debug = cmdLine.hasOption("g");
		factory = new FileDAOFactory(1, directory);

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
			if (!(cmdLine.hasOption("m") && cmdLine.hasOption("D")
					&& cmdLine.hasOption("c") && cmdLine.hasOption("l") && cmdLine
					.hasOption("s"))) {
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
		options.addOption("D", "directory", true,
				"main directory for the simulation");
		options.addOption("c", "capra", true, "name of the capra file");
		options.addOption("l", "library", true,
				"name of the scheduler library file");
		options.addOption("s", "scheduler", true,
				"name of the scheduler description file");
		options.addOption("m", "simulation-period", true,
				"simulated period in seconds");
		options.addOption("v", "delay", true,
				"delay of the generated closed workload");
		options.addOption("d", "demand", true, "generated resource demand");
		options.addOption("g", "debug", false,
				"enable debug output of the simulation");
		options.addOption("u", "summary", true,
				"generate summary report of for the simulation");
		options.addOption("n", "name", true, "name of the simulation run");
	}
}
