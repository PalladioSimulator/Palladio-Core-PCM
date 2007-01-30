package transformation;

import java.net.URL;
import java.util.*;
import java.awt.*;
import transformation.gui.*;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.openarchitectureware.workflow.*;
import org.openarchitectureware.workflow.monitor.NullProgressMonitor;

/**
 * user defined properties are in the file Transformation.properties <p>
 * standard properties are coded here
 */
public class TransformationRunner implements Runnable {

	/**
	 * print warnings and logging information
	 */
	private static Logger logger;
	private String workflowFile;

	Map<String, String> properties = new HashMap<String, String>();
	Map<String, Object> slotContents = new HashMap<String, Object>();

	/**
	 * {@link #main(String[])} is a class method and can be called without an instance. 
	 * All static variables are initialized in this block. 
	 */
	static {
		logger = Logger.getLogger("TransformationRunner");
		logger.setLevel(Level.INFO);
	}
	public TransformationRunner() {
		// empty
	}

	public void setWorkflowFile(String file) {
		workflowFile = "workflows/" + file + ".oaw";
		log("set workflow file to: " + workflowFile);
	}

	/**
	 * @param name name of the model file(s) without suffix
	 * insert all properties representing file names via this method
	 */
	public void setModelFile(String name) {
		properties.put("modelFile.assembly", name + ".assembly");
		properties.put("modelFile.system", name + ".system");
		properties.put("modelFile.repository", name + ".repository");
		properties.put("modelFile.allocation", name + ".allocation");
		properties.put("modelFile.usagemodel", name + ".usagemodel");
	}

	public void setModelName(String name) {
		properties.put("modelName", quote(name));
	}

	public void setBasePackage(String name) {
		properties.put("basePackage", quote(name));
	}

	public void run() {
		ClassLoader cl = this.getClass().getClassLoader();
		URL osFile = cl.getResource(workflowFile);
		log("read oAW-Workflow from the file: " + osFile.getPath());
		// start with relative path
		new WorkflowRunner().run(workflowFile, new NullProgressMonitor(), 
				properties, slotContents);
	}

	/*
	 * @param args name of the oAW-Workflow(s) to run
	 */
	public static void main(String[] args) {
		assert(args.length>=1);
		// iterate over args -> start multiple workflows in sequence
		Frame starter = new RunnerFrame();
		starter.pack();
		starter.setVisible(true);
		if (true) return;
		TransformationRunner runner = new TransformationRunner();
		for (String file: args) {
			runner.setWorkflowFile(file);
			runner.run();
		}
		log("run all workflows");
	}

	/**
	 * used for logging, 
	 * @param msg logging message to print
	 */
	private static void log(String msg) {
		logger.log(Priority.INFO, msg);
	}

	/**
	 * @param text text to quote
	 * @return text that starts and ends with quotation marks
	 */
	private String quote(String text) {
		return "\"" + text + "\"";
	}
}