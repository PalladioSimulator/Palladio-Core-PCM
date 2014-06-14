package org.palladiosimulator.protocom.framework.utils;

import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**
 * Command line parser for ProtoCom. See
 * @url{https://sdqweb.ipd.kit.edu/wiki/ProtoCom} for parameter descriptions.
 */
public class CommandLineParser {
	protected static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getRootLogger();

	public static RunProperties parseCommandLine(String[] arguments) {
		RunProperties runProps = null;
		Options o = new Options();
		addOptions(o);

		boolean parserError = false;
		try {
			runProps = new RunProperties(new GnuParser().parse(o, arguments), o);
		} catch (ParseException e) {
			logger.error("Unable to start execution\n" + e.getMessage() + "\n");
			parserError = true;
		}

		if (parserError || runProps.hasOption('h') || !runProps.hasOption('d') || !runProps.hasOption('n') || !runProps.hasOption('m') || !runProps.hasOption('s')) {
			new HelpFormatter().printHelp("Main", "ProtoCom: Prototype runner\n", o,
					"For documentation consult https://sdqweb.ipd.kit.edu/wiki/ProtoCom");
			System.exit(-1);
		}
		return runProps;
	}

	@SuppressWarnings("static-access")
	private static void addOptions(Options o) {
		o.addOption("h", "help", false, "Show this help");
		o.addOption("D", "debug", false, "Print debug information. Turn off for real experiments!");
		o.addOption("P", "passive", false, "Make server passive, no load drivers are started. No warmup runs are executed, either.");
		o.addOption("W", "warmup only", false,
				"Execute a number of runs equal to the warmup runs configuration. Depending on configuration, the inner times might be measured.");

		o.addOption(OptionBuilder.hasArg().withArgName("propertyFile").withLongOpt("propFile")
				.withDescription("Property file used to set default commandline parameters. Defaults can be overwritten by additional parameters.").create("f"));
		o.addOption(OptionBuilder.hasArg().withArgName("dataDirectory").withLongOpt("dataDir")
				.withDescription("Datadirectory used by the FileStorage Sensor DAO to store the measured times [mandatory].").create('d'));
		o.addOption(OptionBuilder.hasArg().withArgName("user count").withLongOpt("threadcount")
				.withDescription("Override usage scenario population (only for closed workloads).").create("c"));
		o.addOption(OptionBuilder.hasArg().withArgName("max measurements").withLongOpt("maxmeasurement").withDescription("Maximum measurements to take [mandatory]")
				.create("m"));
		o.addOption(OptionBuilder.hasArg().withArgName("warmup runs").withLongOpt("warmup").withDescription("Warmup runs before measuring (default: 1000).")
				.create("u"));
		o.addOption(OptionBuilder.hasArg().withArgName("calibrationPath").withLongOpt("storeCalPath")
				.withDescription("Path to the directory where the calibration is stored [mandatory]").create("s"));
		o.addOption(OptionBuilder.hasArg().withArgName("ip").withLongOpt("remoteAddr").withDescription("Remote address of the RMI registry.").create('R'));

		o.addOption(OptionBuilder.hasArg().withArgName("port").withLongOpt("remotePort").withDescription("IP port of the RMI registry (default: 1099).").create('O'));

		o.addOption(OptionBuilder.hasArg().withArgName("seed").withLongOpt("randomGenerator").withDescription("Seed for the StoEx random generator.")
				.create('E'));
		o.addOption(OptionBuilder.hasArg().withLongOpt("name").withDescription("Name of the experiment for use in the stored data [mandatory].").create('n'));

		o.addOption(OptionBuilder.hasArgs().withLongOpt("cpuStrategy").withArgName("CPU Strategy")
				.withDescription("CPU calibration strategy: primes, count_numbers, fft, fibonacci, mandelbrot, sortarray, void, wait (default: Fibonacci).")
				.create('p'));
		o.addOption(OptionBuilder.hasArgs().withLongOpt("hddStrategy").withArgName("HDD Strategy")
				.withDescription("HDD calibration strategy: largeChunks (default: LargeChunks).").create('H'));
		o.addOption(OptionBuilder.hasArgs().withLongOpt("accuracy").withArgName("Accuracy")
				.withDescription("Accuracy of CPU and HDD calibration: LOW, MEDIUM, or HIGH (default: MEDIUM). ").create('a'));
		
		// Web UI
		o.addOption(OptionBuilder
			.withLongOpt("web")
			.withDescription("Start web server for configuration through a browser")
			.create()
		);
	}
}
