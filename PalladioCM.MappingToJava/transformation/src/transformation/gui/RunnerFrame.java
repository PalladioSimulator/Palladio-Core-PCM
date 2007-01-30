package transformation.gui;

import transformation.*;
import transformation.util.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class RunnerFrame extends Frame implements ActionListener {

	// field to pass data
	private static final long serialVersionUID = 1L;
	private final String PROPERTIES_FILE = "gui.properties";
	private TransformationRunner runner;
	private Properties properties = new Properties();

	// GUI
	private Panel workflowData = new Panel(new GridLayout(0, 1));
	private CheckboxGroup workflowCheckboxGroup = new CheckboxGroup();

	private Panel modelInfo = new Panel();
	private TextArea descriptionText = new TextArea();

	private Panel modelData = new Panel(new GridLayout(0, 2));
	private TextField filenameText = new TextField();
	private TextField modelnameText = new TextField();
	private TextField basepackageText = new TextField();

	private Panel buttons = new Panel(new GridLayout(1, 0));
	private Button startButton = new Button("start transformation");
	private Button cancelButton = new Button("cancel");

	private MenuBar mbar = new MenuBar();
	private MenuItem helpItem = new MenuItem("Help");
	private MenuItem aboutItem = new MenuItem("About");
	private Menu helpMenu = new Menu("Help");

	/**
	 * This is the default constructor
	 */
	public RunnerFrame() {
		super();
		initializeFrame();
		initializeFields();
		runner = new TransformationRunner();
	}

	/**
	 * This method initializes this object
	 */
	private void initializeFrame() {
		//title and menu
		setTitle("Transformation from PCM to J2EE & EJB 3");
		helpMenu.add(helpItem);
		helpMenu.addSeparator();
		helpMenu.add(aboutItem);
		aboutItem.addActionListener(this);
		mbar.setHelpMenu(helpMenu);
		setMenuBar(mbar);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				e.getWindow().dispose();
				exit(0);
			}
		});

		workflowData.add(new Label("Select the workflow to start"));
		workflowData.add(new Checkbox("Repository", false, workflowCheckboxGroup));
		workflowData.add(new Checkbox("System", false, workflowCheckboxGroup));
		workflowData.add(new Checkbox("Usagemodel", false, workflowCheckboxGroup));
		add(workflowData, BorderLayout.WEST);

		modelInfo.add(descriptionText);
		add(modelInfo, BorderLayout.CENTER);

		// Model to transform
		modelData.add(new Label("filename (without suffix)"));
		modelData.add(filenameText);
		modelData.add(new Label("modelname"));
		modelData.add(modelnameText);
		modelData.add(new Label("basepackage"));
		modelData.add(basepackageText);
		add(modelData, BorderLayout.EAST);

		buttons.add(startButton);
		buttons.add(cancelButton);
		add(buttons, BorderLayout.SOUTH);
		startButton.addActionListener(this);
	}

	private void initializeFields() {
		PropertiesReader reader = new PropertiesReader(PROPERTIES_FILE);
		properties.putAll(reader.readProperties(null));
		filenameText.setText((String)properties.get("filename"));
		modelnameText.setText((String)properties.get("modelname"));
		basepackageText.setText((String)properties.get("basepackage"));
	}

	private void exit(int returncode) {
		properties.put("filename", filenameText.getText());
		properties.put("modelname", modelnameText.getText());
		properties.put("basepackage", basepackageText.getText());
		PropertiesWriter writer = new PropertiesWriter(PROPERTIES_FILE);
		writer.setHeader("# Properties for the \n" +
		"# PCM-to-J2EE Transformation's GUI");
		writer.write(properties);
		System.exit(returncode);
	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source==startButton) {
			runner.setModelFile(filenameText.getText());
			runner.setModelName(modelnameText.getText());
			runner.setBasePackage(basepackageText.getText());
			runner.setWorkflowFile(workflowCheckboxGroup.getSelectedCheckbox().getLabel());
			runner.run();
		}
		else if (source==cancelButton) {
			exit(0);
		}
		else if (source==aboutItem) {
			final Dialog aboutDialog = new Dialog(this, "About this program", true);
			Button button = new Button("OK");
			Label aboutText = new Label("PCM -> J2EE Version 5 & EJB 3.0 \n" +
					"Diplomarbeit: \n" +
					"von Reiner Schaudel" +
					"WS 2006/07");
			aboutDialog.add(aboutText, BorderLayout.CENTER);
			aboutDialog.add(button, BorderLayout.SOUTH);
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					aboutDialog.dispose();
				}
			});
			aboutDialog.pack();
			aboutDialog.setVisible(true);
		}
	}
}