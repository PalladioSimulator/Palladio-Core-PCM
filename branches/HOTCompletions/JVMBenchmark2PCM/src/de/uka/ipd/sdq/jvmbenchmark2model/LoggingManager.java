/**
 * 
 */
package de.uka.ipd.sdq.jvmbenchmark2model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;

import de.uka.ipd.sdq.jvmbenchmark2model.preferences.JvmBenchmark2ModelPreferences;

/**
 * Encapsulates the application's logging.
 * <p>
 * The configuration is based on a config file. Methods to set and get its
 * location are provided. The default location is taken from the default
 * preferences.
 * </p>
 * <p>
 * A basic default configuration is provided. If the file set in the preferences
 * does not exist when logging is initialized, it is created with this default
 * configuration.
 * </p>
 * 
 * @author thomas
 */
public class LoggingManager {
	private static final String LOGFILE_NAME = "JvmBenchmark2PCM.log";
	private static final String PLACEHOLDER = "PLACEHOLDER";
	
	/**
	 * The content of the default log4j configuration file. It is <em>not</em>
	 * final because if the project name is known,
	 * {@link #initializeLogging(String)} is called, which replaces the value of
	 * {@link #LOGFILE_NAME} in this string with an absolute path to the project
	 * plus {@link #LOGFILE_NAME}, so that the log file ends up in the analysed
	 * project.
	 */
	private static String LOG4J_DEFAULT_PROPERTIES = "" +
	"# Set root logger level to INFO and its only appender to A1.\n" +
	"log4j.rootLogger=INFO, A1\n\n" +
	"log4j.appender.A1=org.apache.log4j.RollingFileAppender\n" +
	"log4j.appender.A1.File=" + 
	PLACEHOLDER + "\n" + 
	"# A1 uses PatternLayout.\n" + 
	"log4j.appender.A1.layout=org.apache.log4j.PatternLayout\n" + 
	"log4j.appender.A1.layout.ConversionPattern=%-4r [%t] %-5p %c{1} %x - %m%n\n";
	

	
	/**
	 * Initialize the logging subsystem. Must be called once, before the first
	 * logging call.
	 */
	public static void initializeLogging() {
		//TODO: re-enable; did not work on Win --> so disabled
		/*MessageConsole myConsole = getConsole();
		MessageConsoleStream out = myConsole.newMessageStream();
		
		String logConfigFile = getConfigFileLocation();
		out.println("Logging: reading configuration from " + logConfigFile);
		
		File confFile = new File(logConfigFile);
		if (!confFile.exists()) {
			out.println("Logging: config file does not exist, " +
						"writing default configuration.");
			writeDefaultConfigFile(confFile);
		}
		
		PropertyConfigurator.configureAndWatch(logConfigFile);*/
		Properties properties = new Properties();			
		properties.setProperty("log4j.rootLogger", "ALL, A1");
		properties.setProperty("log4j.appender.A1", "org.apache.log4j.ConsoleAppender");
		properties.setProperty("log4j.appender.A1.layout", "org.apache.log4j.PatternLayout");
		properties.setProperty("log4j.appender.A1.layout.ConversionPattern", "%-5p [%t] (%F:%M:%L) %-5r - %m%n");
		PropertyConfigurator.configure(properties);		
	}

	/**
	 * Initialize the logging subsystem. Must be called once, before the first
	 * logging call.
	 * <p>
	 * This initializer takes an Eclipse project name, out of which the absolute
	 * path to the log file <code>/path/to/project/{@link #LOGFILE_NAME}</code>
	 * is constructed.
	 * </p>
	 * 
	 * @param project
	 *            the name of the project (and thus its directory)
	 */
	public static void initializeLogging(String project) {
		String workspace = ResourcesPlugin.getWorkspace().getRoot()
				.getLocation().toOSString();
		// TODO this is not OS-independent!
		String fullLogfilePath = workspace + File.separator + project + File.separator + LOGFILE_NAME;
		LOG4J_DEFAULT_PROPERTIES = LOG4J_DEFAULT_PROPERTIES.replaceFirst(
				PLACEHOLDER, fullLogfilePath);

		initializeLogging();
		
				
	}

	/**
	 * Get the path to the logging configuration file.
	 * 
	 * @return the path as String
	 */
	private static String getConfigFileLocation() {
		String logConfigDir = Activator.getDefault().getPreferenceStore()
				.getString(JvmBenchmark2ModelPreferences.log4jConfigDir);
		IPath confFilePath = new Path(logConfigDir);
		confFilePath = confFilePath.append(JvmBenchmark2ModelPreferences.LOG4J_CONFIGFILE_NAME);
		String logConfigFile = confFilePath.toOSString();
		return logConfigFile;
	}
	
	/**
	 * Write a basic default configuration to a given configuration file.
	 * 
	 * @param destinationFile
	 *            the destination File
	 */
	private static void writeDefaultConfigFile(File destinationFile) {
		try {
			destinationFile.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			FileWriter writer = new FileWriter(destinationFile);
			writer.write(LOG4J_DEFAULT_PROPERTIES);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Get an Eclipse console to display the initial messages, before log4j is
	 * loaded.
	 * <p>
	 * <code>System.out</code> does not work with plugins, it goes to the OS
	 * console - if any - Eclipse was started from. The code is taken from <a
	 * href="http://wiki.eclipse.org/index.php/FAQ_How_do_I_write_to_the_console_from_a_plug-in%3F">the
	 * Eclipse wiki</a>.
	 * </p>
	 * 
	 * @return
	 */
	private static MessageConsole getConsole() {
		ConsolePlugin plugin = ConsolePlugin.getDefault();
		IConsoleManager conMan = plugin.getConsoleManager();

		MessageConsole myConsole = new MessageConsole("code2model console", null);
		conMan.addConsoles(new IConsole[]{myConsole});
		return myConsole;
	}

}
