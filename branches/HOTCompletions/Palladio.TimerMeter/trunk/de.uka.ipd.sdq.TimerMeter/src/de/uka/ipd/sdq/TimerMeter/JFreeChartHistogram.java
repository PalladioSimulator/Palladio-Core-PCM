package de.uka.ipd.sdq.TimerMeter;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class JFreeChartHistogram extends JApplet {

    /**
	 * 
	 */
	private static final long serialVersionUID = -415125857073882722L;

	/**
     * Constructs the demo applet.
     */
    public JFreeChartHistogram(JPanel p) {
    	// Send the applet an init() message.
    	this.init();

    	// Construct a JFrame.
    	final JFrame frame =
    		new JFrame("TimeresolutionRetriever");

    	// Transfer the applet's context pane to the JFrame.
    	frame.setContentPane(this.getContentPane());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTabbedPane tabs = new JTabbedPane();
        tabs.add("Chart Rdtsc", p);
        getContentPane().add(tabs);


    	// Set the size of the frame.
    	// To pack the frame as tightly as possible
    	// replace the setSize() message with the following.
    	// frame.pack();
    	frame.setSize(1024, 768);

    	// Set the location of the frame.
    	frame.setLocation(50, 50);

    	// Show the frame.
    	frame.setVisible(true);

    	// Invoke the applet's start() method.
    	// This line can be omitted if the applet
    	// does not define a start method.
    	this.start();

    }
    
    
}
