package de.uka.ipd.sdq.reliability.solver.helper;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.WriterAppender;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;

public class LoggingHelper {

    /**
     * The singleton instance.
     */
    private static LoggingHelper singletonInstance = null;

    /**
     * Retrieves the singleton instance.
     * 
     * @return the singleton instance
     */
    public static LoggingHelper getSingletonInstance() {
        if (singletonInstance == null) {
            singletonInstance = new LoggingHelper();
        }
        return singletonInstance;
    }

    /**
     * Private constructor.
     * 
     * Prohibits external object creation.
     */
    private LoggingHelper() {
    }

    /**
     * Creates a new message console for the SimuService, or references an existing one.
     * 
     * @return the message console for the SimuService
     */
    private MessageConsole createOrReferenceMessageConsole() {

        // The name of the console:
        String SimuServiceConsoleName = "PCM Reliability Solver: Markov Comparison";

        // If the console already exists, return a reference to the existing
        // console:
        for (IConsole console : ConsolePlugin.getDefault().getConsoleManager().getConsoles()) {
            if (console.getName().equals(SimuServiceConsoleName)) {
                return (MessageConsole) console;
            }
        }

        // Create a new console:
        MessageConsole console = new MessageConsole(SimuServiceConsoleName, null);
        ConsolePlugin.getDefault().getConsoleManager().addConsoles(new IConsole[] {
            console
        });
        return console;
    }

    /**
     * Initializes the logging functionality.
     * 
     */
    public void initializeLogging() {

        // Retrieve a message console for the logging:
        MessageConsole console = createOrReferenceMessageConsole();
        console.activate();
        console.clearConsole();
        MessageConsoleStream stream = console.newMessageStream();

        // Configure log4j:
        PatternLayout myLayout = new PatternLayout("[%-10t] %-5p: %m%n");
        WriterAppender writerAppender = new WriterAppender(myLayout, stream);
        BasicConfigurator.resetConfiguration();
        BasicConfigurator.configure(writerAppender);
        Logger.getRootLogger().setLevel(Level.INFO);
    }
}
