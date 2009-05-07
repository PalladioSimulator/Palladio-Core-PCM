package de.uka.ipd.sdq.benchmarks.concurrency.client;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;

import de.uka.ipd.sdq.benchmarks.concurrency.workload.ILoadDriver;
import de.uka.ipd.sdq.measurement.strategies.activeresource.cpu.AbstractDemandStrategy;
import de.uka.ipd.sdq.sensorframework.dao.file.FileDAOFactory;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;
import de.uka.ipd.sdq.sensorframework.util.ExperimentManager;

public abstract class AbstractBenchmark {

	protected enum Scenarios {
		scaled, heavy, heavyLinux, noboost, semaphore, network, linux
	}

	protected static String directory;
	protected static long duration;
	protected static IDAOFactory factory;
	protected static int number_of_processors = 1;
	protected static int number_of_tasks = 1;
	protected static List<Scenarios> scenarioList = new ArrayList<Scenarios>();
	protected static long delay = 0;
	protected static int demand = 250;
	protected static int max_repetitions = -1;
	protected static boolean useMemory = false;



	protected static void initialize(String[] args) {
		CommandLine cmdLine = getCommandLine(args);
		directory = cmdLine.getOptionValue("D");
		duration = Long.parseLong(cmdLine.getOptionValue("m")) * 1000;
		if (cmdLine.hasOption("p")) {
			number_of_processors = Integer
					.parseInt(cmdLine.getOptionValue("p"));
		}
		if (cmdLine.hasOption("t")) {
			number_of_tasks = Integer.parseInt(cmdLine.getOptionValue("t"));
		}
		if (cmdLine.hasOption("s")) {
			for (String str : cmdLine.getOptionValues("s")) {
				scenarioList.add(Scenarios.valueOf(str));
			}
		}
		if (cmdLine.hasOption("v")) {
			delay = Long.parseLong(cmdLine.getOptionValue("v"));
		}
		if (cmdLine.hasOption("d")) {
			demand = Integer.parseInt(cmdLine.getOptionValue("d"));
		}
		if (cmdLine.hasOption("r")) {
			max_repetitions = (int) (duration * number_of_processors)
					/ (demand * number_of_tasks);
		}
		if (cmdLine.hasOption("C")) {
			AbstractDemandStrategy.setConfigPath(cmdLine.getOptionValue("C"));
		}
		useMemory = cmdLine.hasOption("u");
		factory = new FileDAOFactory(1, directory);

		Thread.currentThread().setPriority(Thread.MAX_PRIORITY);

	}

	protected static void close() {
		factory.finalizeAndClose();
		System.exit(0);
	}

	protected static void run(ILoadDriver driver, String measurement_name) {
		System.out.println(measurement_name);
		ExperimentManager manager = new ExperimentManager(measurement_name,
				factory);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long start = System.nanoTime();
		driver.start();
		try {
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.stop();
		long stop = System.nanoTime();

		driver.store(manager);
		manager.close();
		System.out.println("finished test after "
				+ ((stop - start) / 1000000000) + " sec.");
	}

	private static CommandLine getCommandLine(String[] args) {
		CommandLine cmdLine = null;
		try {
			cmdLine = new PosixParser().parse(options, args);
			if (!(cmdLine.hasOption("m") && cmdLine.hasOption("D"))) {
				cmdLine = null;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (cmdLine == null) {
			HelpFormatter formatter = new HelpFormatter();
			formatter.printHelp("SimpleBenchmark", options);
			System.exit(-1);
		}
		return cmdLine;
	}

	protected static Options options = new Options();

	static {
		options.addOption("D", "directory", true,
				"target directory for the measurement results");
		options.addOption("m", "measurement-period", true,
				"measurement period in seconds");
		options.addOption("p", "num-processors", true,
				"the system's number of processors");
		options.addOption("t", "num-tasks", true,
				"number of tasks for the scaled workload");
		options.addOption("v", "delay", true,
				"delay of the generated closed workload");
		options.addOption("d", "demand", true, "generated resource demand");
		options.addOption("r", "repetitions", false,
				"limit the maximum number of repetitions for each task");
		options.addOption("C", "configuration", true,
				"path to the configuration files");
		options.addOption("u", "use-memory", false,
		"use a memory intensive demand");

		OptionBuilder.hasArgs();
		OptionBuilder.withArgName("scenarios");
		OptionBuilder.withDescription("scenarios that shall be benchmarked");
		OptionBuilder.withValueSeparator(',');
		Option o = OptionBuilder.create("s");
		options.addOption(o);
	}
}
