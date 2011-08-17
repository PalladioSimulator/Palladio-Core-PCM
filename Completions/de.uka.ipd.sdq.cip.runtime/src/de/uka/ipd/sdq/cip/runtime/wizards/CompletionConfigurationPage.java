package de.uka.ipd.sdq.cip.runtime.wizards;


import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import de.uka.ipd.sdq.cip.completions.RegisteredCompletion;
import de.uka.ipd.sdq.cip.configuration.TransformationType;
import de.uka.ipd.sdq.cip.configuration.Transformation.TransformationQVTType;
import de.uka.ipd.sdq.cip.runtime.dialogs.CompletionConfigurationWidget;
import de.uka.ipd.sdq.cip.runtime.wizards.CompletionConfigNode.FeatureConfig;
import de.uka.ipd.sdq.cip.runtime.wizards.CompletionConfigNode.UserDefined;
import de.uka.ipd.sdq.cip.runtime.wizards.CompletionConfigNode.UserDefinedID;

public class CompletionConfigurationPage extends WizardPage {

	private CompletionConfigurationWidget completionConfigurationWidget = null;

	protected CompletionConfigurationPage(String pageName) {
		super(pageName);
		completionConfigurationWidget = new CompletionConfigurationWidget();
	}

	@Override
	public void createControl(Composite parent) {
		Composite mainComponent = new Composite(parent, SWT.NONE);
		
		completionConfigurationWidget.createControl(mainComponent);
		
		setControl(mainComponent);

	}
	
	public boolean canFinish() {
		CompletionSelectionPage prevpage = (CompletionSelectionPage) getWizard().getPreviousPage(this);
		Object element = prevpage.getSelection();
		if(element instanceof RegisteredCompletion) {
			if(getFile1Text() != null)
				return true;
		}
		if(element instanceof UserDefined) {
			UserDefined userDefined = (UserDefined) element; 
			if(userDefined.getID() == UserDefinedID.ANNOTATED) {
				if(getFile1Text() != null && getFile2Text() != null && getFile3Text() != null)
					return true;
			}
			else {
				if(getFile1Text() != null)
					return true;
			}
		}
		return false;
	}
	
	@Override
	public void setVisible(boolean visible) {
		CompletionSelectionPage prevpage = (CompletionSelectionPage) getWizard().getPreviousPage(this);
		Object element = prevpage.getSelection();
		
		TransformationType type = TransformationType.NONE;
		TransformationQVTType qvtType = TransformationQVTType.QVTR;
		
		if(element instanceof RegisteredCompletion) {
			type = TransformationType.REGISTERED;
		}
		else if(element instanceof FeatureConfig)
		{
			type = TransformationType.FEATURE;
		}
		else if(element instanceof UserDefined) {
			UserDefined userDefined = (UserDefined) element; 
			if(userDefined.getID() == UserDefinedID.ANNOTATED) {
				type = TransformationType.ANNOTATED;
			}
			else if(userDefined.getID() == UserDefinedID.PLAIN) {
				type = TransformationType.PLAIN;
			}
			// QVTO completion
			else if(userDefined.getID() == UserDefinedID.PLAINQVTO) {
				type = TransformationType.PLAIN;
				qvtType = TransformationQVTType.QVTO;
				
			}
			else if(userDefined.getID() == UserDefinedID.FEATURECONFIG) {
				type = TransformationType.FEATURE;
			}
		}
		
		completionConfigurationWidget.setVisible(type,qvtType);
		
		super.setVisible(visible);
	}
	
	public String getFile1Text() {
		return completionConfigurationWidget.getFile1Text();
	}
	
	public String getFile2Text() {
		return completionConfigurationWidget.getFile2Text();
	}

	public String getFile3Text() {
		return completionConfigurationWidget.getFile3Text();
	}
	
	
	

}
