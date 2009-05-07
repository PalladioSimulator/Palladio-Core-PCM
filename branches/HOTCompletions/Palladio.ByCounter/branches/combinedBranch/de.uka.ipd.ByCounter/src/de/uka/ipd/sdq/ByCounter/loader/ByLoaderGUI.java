package de.uka.ipd.sdq.ByCounter.loader;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Enumeration;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.ByCounter.instrumentation.InstrumentationParameters;
import de.uka.ipd.sdq.ByCounter.utils.Barrier;
import de.uka.ipd.sdq.ByCounter.utils.MethodDescriptor;

/**
 * Graphical user interface for the selection of methods to instrument.
 * 
 * @author Martin Krogmann
 * @author Michael Kuperberg
 * @since 0.9
 * @version 0.9
 *
 */
public class ByLoaderGUI extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3895045635925689009L;
	private Barrier byCounterBarrier;
	private static Logger log = Logger.getLogger(ByLoaderGUI.class);

	/**
	 * Constructs the gui. Call <code>createAndShowGUI()</code> to display it.
	 * @param bcft The {@link ByClassFileTransformer} that is informed of the 
	 * methods to instrument selected using this interface.
	 * @param barrier The barrier that is released when the user selects 
	 * 'start'.
	 */
	public ByLoaderGUI(Barrier barrier) {
		super("ByCounter - Loader");
		this.byCounterBarrier = barrier;
		setNativeLookAndFeel();
	}

	final static int maxGap = 20;
	JButton startButton;
	DefaultListModel methodListModel;
	JList methodList;
	JButton addButton;
	JButton removeButton;
	JButton exitButton;
	JTextField methodDescriptorFieldClass;
	JTextField methodDescriptorFieldSignature;
	JCheckBox optArrayParameterCheckBox;
	JCheckBox optHighRegistersCheckBox;
	JCheckBox optResultLogCheckBox;
	JTextField optResultLogFileTextField;
	ButtonGroup optPrecisionGroup;
	JRadioButton optPrecisionLong;
	JRadioButton optPrecisionInt;
	JCheckBox optInstrumentFromFS;
	
	JTree classSelectionTree;
	TreeModel classSelectionTreeModel;

	public void addComponentsToPane(final Container pane) {
		JPanel controls = new JPanel();
		controls.setLayout(new GridBagLayout());
		
		startButton = new JButton("Start Application");
		methodListModel = new DefaultListModel();
		methodListModel.add(0, new MethodDescriptor("spec.benchmarks.compress.Compressor",
				"public void compress()"));
		methodList = new JList(methodListModel);
		// make sure only one item can be selected at a time
		methodList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		addButton = new JButton("Add");
		removeButton = new JButton("Remove");
		exitButton = new JButton("Exit");
		methodDescriptorFieldClass = new JTextField();
		methodDescriptorFieldSignature = new JTextField();
		// setup the tree view for the selection of classes
		DefaultMutableTreeNode classSelectionTreeRoot = new DefaultMutableTreeNode("root");
		generateClassTree(classSelectionTreeRoot);
		classSelectionTreeModel = new DefaultTreeModel(classSelectionTreeRoot);
		classSelectionTree = new JTree(classSelectionTreeModel);
		
		// reusable constraint variable to setup all controls
		GridBagConstraints c = new GridBagConstraints();

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 2;
		c.weightx = 0.5;
		controls.add(new JLabel("Please specify the methods to instrument."), c);
		
		
		optInstrumentFromFS = new JCheckBox("Use instrumented files from filesystem. (Ignores all of the following options)", false);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy++;
		c.gridwidth = 2;
		controls.add(optInstrumentFromFS, c);
		
		
		// Methoddescriptor group:
		JPanel methodDescriptorPanel = new JPanel();
		methodDescriptorPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Method descriptor (all classes fully qualified):"),
                BorderFactory.createEmptyBorder(5,5,5,5)));
		methodDescriptorPanel.setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy++;
		methodDescriptorPanel.add(new JLabel("Class:"), c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy++;
		methodDescriptorPanel.add(methodDescriptorFieldClass, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy++;
		methodDescriptorPanel.add(new JLabel("Method signature:"), c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy++;
		methodDescriptorPanel.add(methodDescriptorFieldSignature, c);
		JScrollPane treeScroller = new JScrollPane(classSelectionTree);
		treeScroller.setMinimumSize(new Dimension(590, 200));
		//c.fill = GridBagConstraints.HORIZONTAL;
		//c.gridx = 0;
		//c.gridy++;
		//methodDescriptorPanel.add(treeScroller, c);
		controls.add(methodDescriptorPanel, c);
		
		// the methods to instrument list and label:
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy++;
		controls.add(new JLabel("The following methods will be instrumented:"), c);
		
		JScrollPane listScroller = new JScrollPane(methodList);
		listScroller.setMinimumSize(new Dimension(590, 200));
		c.fill = GridBagConstraints.BOTH;
		c.weighty = 0.5;
		c.gridx = 0;
		c.gridy++;
		c.gridwidth = 2;
		controls.add(listScroller, c);
		c.weighty = 0;
		
		// add and remove buttons:
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy++;
		c.gridwidth = 1;
		addButton.setMnemonic('a');
		controls.add(addButton, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		removeButton.setMnemonic('r');
		controls.add(removeButton, c);
		

		// Options:
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy++;
		c.gridwidth = 2;
		JPanel optionsPanel = new JPanel();
        optionsPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Options"),
                BorderFactory.createEmptyBorder(5,5,5,5)));
        optionsPanel.setLayout(new BoxLayout(optionsPanel,
                BoxLayout.PAGE_AXIS));
        
        optArrayParameterCheckBox = new JCheckBox("Use array parameter recording", false);
        optHighRegistersCheckBox = new JCheckBox("Use high registers as counters", true);
        optionsPanel.add(optArrayParameterCheckBox);
        optionsPanel.add(optHighRegistersCheckBox);
        
        optPrecisionGroup = new ButtonGroup();
        optPrecisionInt = new JRadioButton("Use int counter precision.", false);
        optPrecisionLong = new JRadioButton("Use long counter precision.", true);
        optPrecisionGroup.add(optPrecisionInt);
        optPrecisionGroup.add(optPrecisionLong);
        optionsPanel.add(optPrecisionInt);
        optionsPanel.add(optPrecisionLong);
        
        optResultLogCheckBox = new JCheckBox("Write results to log file(s).", false);
        optResultLogCheckBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					optResultLogFileTextField.setEnabled(true);
					optResultLogFileTextField.setEditable(true);
				} else if (e.getStateChange() == ItemEvent.DESELECTED) {
					optResultLogFileTextField.setEnabled(false);
					optResultLogFileTextField.setEditable(false);
				}
			}
        	
        });
        optResultLogFileTextField = new JTextField(
        		InstrumentationParameters.RESULT_LOG_DEFAULT_FILENAME);
        optResultLogFileTextField.setEnabled(false);
        optResultLogFileTextField.setEditable(false);
        optionsPanel.add(optResultLogCheckBox);
        optionsPanel.add(optResultLogFileTextField);
        
        controls.add(optionsPanel, c);
		

        // start and exit buttons
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy++;
		c.gridwidth = 1;
		exitButton.setMnemonic('x');
		controls.add(exitButton, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		startButton.setMnemonic('s');
		controls.add(startButton, c);


		// Process selection change in method list
		methodList.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				int index = methodList.getSelectedIndex();
				if(index >= 0) {
					MethodDescriptor d = 
						(MethodDescriptor)methodListModel.getElementAt(index);
					methodDescriptorFieldClass.setText(
							d.getCanonicalClassName());
//					methodDescriptorFieldSignature.setText(
//							".." + d.getMethodName() + "..");
				}
			}
			
		});
		
		// Process the start button press
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// make sure ByCounter can continue
				byCounterBarrier.release();
				setVisible(false);
			}
		});
		// Process the add button press
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(methodDescriptorFieldClass.getText().length() > 0
						&& methodDescriptorFieldSignature.getText().length() > 0) {
					MethodDescriptor d = new MethodDescriptor(
							methodDescriptorFieldClass.getText(), 
							methodDescriptorFieldSignature.getText());
					if(d.getDescriptor() != null) {
						methodListModel.addElement(d);
					} else {
						log.error("Invalid method descriptor");
					}
				} else {
					log.error("Empty field.");
					// TODO: display a messsage
				}
			}
			
		});
		// Process the remove button press
		removeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = methodList.getSelectedIndex();
				if(index >= 0) {
					methodListModel.removeElementAt(index);
				}
			}
			
		});
		// Process the exit button press
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			
		});
		pane.add(controls);
	}

	/**
	 * Generates a tree of all found packages and their classes.
	 * @param root The root element to which the tree is added.
	 * @param prefix The package prefix in which the packages/classes are
	 * searched.
	 */
	private void generateClassTree(DefaultMutableTreeNode root) {
		Package[] packages = null;
		packages = Package.getPackages();
		Enumeration<URL> ress = null;;
		try {
			ress = ClassLoader.getSystemClassLoader().getSystemResources("de");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0; i < packages.length; i++) {
			
		}
		ress.hashCode();
		ArrayList<URL> stuff = new ArrayList<URL>();
		while(ress.hasMoreElements()) {
			stuff.add(ress.nextElement());
		}
		Comparator<Package> packageComparator = new Comparator<Package>() {
			@Override
			public int compare(Package p1, Package p2) {
				return p1.getName().compareTo(p2.getName());
			}
		};
		Arrays.sort(packages, packageComparator);
			
		DefaultMutableTreeNode node = null;
		for(int i = 0; i < packages.length; i++) {
			node = new DefaultMutableTreeNode(packages[i]);
			root.add(node);
		}
	}

	/**
	 * Gets the {@link InstrumentationParameters} as specified in the gui.
	 * @return Returns null, if instrumented files from the filesystem shall 
	 * be used.
	 * Otherwise the methods to instrument and instrumentation options as 
	 * {@link InstrumentationParameters}.
	 */
	public synchronized InstrumentationParameters getInstrumentationParameters() {
		
		if(optInstrumentFromFS.isSelected()) {
			return null;
		}
		
		InstrumentationParameters params;
		ArrayList<MethodDescriptor> methods = 
			new ArrayList<MethodDescriptor>(methodListModel.getSize());
		for(int i = 0; i < methodListModel.getSize(); i++) {
			methods.add((MethodDescriptor)methodListModel.elementAt(i));
		}
		params = new InstrumentationParameters(methods);
		
		// set options
		// precision:
		int precision = InstrumentationParameters.COUNTER_PRECISION_LONG;
		if(optPrecisionInt.isSelected()) {
			precision = InstrumentationParameters.COUNTER_PRECISION_INT;
		} else if(optPrecisionLong.isSelected()) {
			precision = InstrumentationParameters.COUNTER_PRECISION_LONG;
		}
		params.setCounterPrecision(precision);
		
		// use of result log:
		if(optResultLogCheckBox.isSelected()) {
			params.setUseResultCollector(false);
		} else {
			params.setUseResultCollector(true);
			params.setResultLogFileName(optResultLogFileTextField.getText());
		}
		
		// record array params
		params.setUseArrayParameterRecording(
				optArrayParameterCheckBox.isSelected());
		// use high registers
		params.setUseHighRegistersForCounting(
				optHighRegistersCheckBox.isSelected());
		
//		params.setStartLine(startLine);
//		params.setStopLine(stopLine);
		
		
		return params;
	}

	/**
	 * Create the GUI and show it.  For thread safety,
	 * this method is invoked from the
	 * event dispatch thread.
	 */
	public void createAndShowGUI() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Set up the content pane.
		this.addComponentsToPane(this.getContentPane());
		//Display the window.
		this.pack();
		this.setVisible(true);
	}
	
	/**
	 * Sets the swing applications look and feel to native.
	 */
	public static void setNativeLookAndFeel() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.out.println("Error setting native LAF: " + e);
		}
	}


	/**
	 * Main method used for development purposes.
	 * 
	 * @param args
	 *            Not used.
	 */
	public static void main(String[] args) {
		//Schedule a job for the event dispatch thread:
		//creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				(new ByLoaderGUI(null)).createAndShowGUI();
			}
		});
	}
}