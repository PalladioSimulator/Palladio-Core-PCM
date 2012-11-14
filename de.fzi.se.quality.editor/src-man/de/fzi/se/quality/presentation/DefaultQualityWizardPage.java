/**
 * 
 */
package de.fzi.se.quality.presentation;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Listener;

import swing2swt.layout.FlowLayout;
import de.fzi.se.quality.qualityannotation.PCMRECategory;
import de.fzi.se.quality.qualityannotation.PCMRERequestCategory;
import de.fzi.se.quality.qualityannotation.QualityAnnotationFactory;
import de.fzi.se.quality.qualityannotation.REPrecision;

/**Wizard page which allows to set precision defaults for all categories of the PCM.
 * @author groenda
 *
 */
public class DefaultQualityWizardPage extends WizardPage implements Listener, ModifyListener {
	/** EMF factory for quality annotations. */
	private static final QualityAnnotationFactory qaFactory= QualityAnnotationFactory.eINSTANCE;
	
	/** Call parameters for calls to business interfaces. */
	private PrecisionGroup businessInterfaceCP;
	/** Number of Calls for calls to business interfaces. */
	private PrecisionGroup businessInterfaceNoC;
	/** Call parameters for calls to infrastructure interfaces. */
	private PrecisionGroup infrastructureInterfaceCP;
	/** Number of Calls for calls to infrastructure interfaces. */
	private PrecisionGroup infrastructureInterfaceNoC;
	/** Call parameters for calls to resource interfaces. */
	private PrecisionGroup resourceInterfaceCP;
	/** Number of Calls for calls to resource interfaces. */
	private PrecisionGroup resourceInterfaceNoC;
	/** (Direct) Resource demands. */
	private PrecisionGroup resourceDemandNoC;
	/** Number of Calls for calls to internal resource demanding specificaitons. */
	private PrecisionGroup internalNoC;
	/** Call parameters for calls to internal resource demanding specificaitons. */
	private PrecisionGroup internalCP;
	
	/**Create a new instance.
	 * @param pageName Name of the page.
	 */
	public DefaultQualityWizardPage(String pageName) {
		super(pageName);
		setMessage("Select the default precision for each category.");
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createControl(Composite parent) {
		final ScrolledComposite scl = new ScrolledComposite(parent, SWT.H_SCROLL | SWT.V_SCROLL);
		setControl(scl);
		Composite root = new Composite(scl, SWT.V_SCROLL);
		scl.setContent(root);
		root.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		Group grpBI = new Group(root, SWT.NONE);
		grpBI.setText("Business Interfaces");
		grpBI.setLayout(new RowLayout(SWT.HORIZONTAL));
		businessInterfaceNoC = new PrecisionGroup("Number of Calls", this);
		businessInterfaceNoC.createGroup(grpBI);
		businessInterfaceCP = new PrecisionGroup("Call Parameters", this);
		businessInterfaceCP.createGroup(grpBI);
		
		Group grpII = new Group(root, SWT.NONE);
		grpII.setText("Infrastructure Interfaces");
		grpII.setLayout(new RowLayout(SWT.HORIZONTAL));
		infrastructureInterfaceNoC = new PrecisionGroup("Number of Calls", this);
		infrastructureInterfaceNoC.createGroup(grpII);
		infrastructureInterfaceCP = new PrecisionGroup("Call Parameters", this);
		infrastructureInterfaceCP.createGroup(grpII);
		
		Group grpRI = new Group(root, SWT.NONE);
		grpRI.setText("Resource Interfaces");
		grpRI.setLayout(new RowLayout(SWT.HORIZONTAL));
		resourceInterfaceNoC = new PrecisionGroup("Number of Calls", this);
		resourceInterfaceNoC.createGroup(grpRI);
		resourceInterfaceCP = new PrecisionGroup("Call Parameters", this);
		resourceInterfaceCP.createGroup(grpRI);
		
		Group grpRD = new Group(root, SWT.NONE);
		grpRD.setText("Resource Demands");
		grpRD.setLayout(new RowLayout(SWT.HORIZONTAL));
		resourceDemandNoC = new PrecisionGroup("Number of Calls", this);
		resourceDemandNoC.createGroup(grpRD);
		
		Group grpI = new Group(root, SWT.NONE);
		grpI.setText("Internal");
		grpI.setLayout(new RowLayout(SWT.HORIZONTAL));
		internalNoC = new PrecisionGroup("Number of Calls", this);
		internalNoC.createGroup(grpI);
		internalCP = new PrecisionGroup("Call Parameters", this);
		internalCP.createGroup(grpI);

		root.setSize(root.computeSize(SWT.DEFAULT, SWT.DEFAULT));
	}
	
	@Override
	public String getErrorMessage() {
		if (businessInterfaceCP.getErrorMessage() != null) {
			return businessInterfaceCP.getErrorMessage();
		}
		if (businessInterfaceNoC.getErrorMessage() != null) {
			return businessInterfaceNoC.getErrorMessage();
		}
		if (infrastructureInterfaceCP.getErrorMessage() != null) {
			return infrastructureInterfaceCP.getErrorMessage();
		}
		if (infrastructureInterfaceNoC.getErrorMessage() != null) {
			return infrastructureInterfaceNoC.getErrorMessage();
		}
		if (resourceInterfaceCP.getErrorMessage() != null) {
			return resourceInterfaceCP.getErrorMessage();
		}
		if (resourceInterfaceNoC.getErrorMessage() != null) {
			return resourceInterfaceNoC.getErrorMessage();
		}
		if (resourceDemandNoC.getErrorMessage() != null) {
			return resourceDemandNoC.getErrorMessage();
		}
		if (internalCP.getErrorMessage() != null) {
			return internalCP.getErrorMessage();
		}
		if (internalNoC.getErrorMessage() != null) {
			return internalNoC.getErrorMessage();
		}
		return null;
	}
	
	@Override
	public boolean isPageComplete() {
		return businessInterfaceNoC.isValid() & businessInterfaceCP.isValid()
				& infrastructureInterfaceNoC.isValid()
				& infrastructureInterfaceCP.isValid()
				& resourceInterfaceNoC.isValid()
				& resourceInterfaceCP.isValid() & resourceDemandNoC.isValid();
	}
	
	@Override
	public void dispose() {
		businessInterfaceNoC.dispose();
		businessInterfaceCP.dispose();
		infrastructureInterfaceNoC.dispose();
		infrastructureInterfaceCP.dispose();
		resourceInterfaceNoC.dispose();
		resourceInterfaceCP.dispose();
		resourceDemandNoC.dispose();
		internalNoC.dispose();
		internalCP.dispose();
		super.dispose();
	}
	
	/**Returns a new required element instance according to the selection.
	 * @param category The category for which the element is requested.
	 * @return The required element.
	 */
	public PCMRECategory getRequiredElement(PCMRERequestCategory category) {
		/** Resulting category. */
		PCMRECategory result;
		result = qaFactory.createPCMRECategory();
		result.setCategory(category);
		/** Resulting precision. */
		REPrecision precision;
		precision = qaFactory.createREPrecision();
		result.setPrecision(precision);
		switch (category) {
			case COMPONENT_INTERNAL:
				precision.setDefaultPrecisionNumberOfCalls(internalNoC.getPrecision());
				precision.setDefaultPrecisionCallParameter(internalCP.getPrecision());
				break;
			case COMPONENT:
				precision.setDefaultPrecisionNumberOfCalls(businessInterfaceNoC.getPrecision());
				precision.setDefaultPrecisionCallParameter(businessInterfaceCP.getPrecision());
				break;
			case INFRASTRUCTURE:
				precision.setDefaultPrecisionNumberOfCalls(infrastructureInterfaceNoC.getPrecision());
				precision.setDefaultPrecisionCallParameter(infrastructureInterfaceCP.getPrecision());
				break;
			case RESOURCE:
				precision.setDefaultPrecisionNumberOfCalls(resourceInterfaceNoC.getPrecision());
				precision.setDefaultPrecisionCallParameter(resourceInterfaceCP.getPrecision());
				break;
			case RESOURCE_DEMAND:
				precision.setDefaultPrecisionNumberOfCalls(resourceDemandNoC.getPrecision());
				precision.setDefaultPrecisionCallParameter(qaFactory.createNoPrecision());
				break;
			default:
				throw new IllegalStateException("Category type unknown.");
		}
		return result;
	}

	/**Validates the input and sets an appropriate error message.
	 */
	protected void validate() {
		String errorMessage = getErrorMessage(); 
		setErrorMessage(errorMessage);
		setPageComplete(errorMessage == null);
	}
	
	@Override
	public void handleEvent(Event event) {
		validate();
	}

	@Override
	public void modifyText(ModifyEvent e) {
		validate();
	}
	
}
