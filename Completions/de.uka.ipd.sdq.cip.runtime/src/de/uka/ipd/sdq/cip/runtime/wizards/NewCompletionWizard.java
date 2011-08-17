package de.uka.ipd.sdq.cip.runtime.wizards;

import org.eclipse.jface.wizard.Wizard;

import de.uka.ipd.sdq.cip.completions.RegisteredCompletion;
import de.uka.ipd.sdq.cip.configuration.Transformation;
import de.uka.ipd.sdq.cip.configuration.TransformationType;
import de.uka.ipd.sdq.cip.configuration.Transformation.TransformationQVTType;
import de.uka.ipd.sdq.cip.ConstantsContainer;
import de.uka.ipd.sdq.cip.runtime.RunConfigImages;
import de.uka.ipd.sdq.cip.runtime.wizards.CompletionConfigNode.FeatureConfig;
import de.uka.ipd.sdq.cip.runtime.wizards.CompletionConfigNode.UserDefined;
import de.uka.ipd.sdq.cip.runtime.wizards.CompletionConfigNode.UserDefinedID;

public class NewCompletionWizard extends Wizard {
	
	private CompletionSelectionPage completionSelectionPage;
	private CompletionConfigurationPage completionConfigurationPage;
	private Transformation transformation = null;
	
	public NewCompletionWizard() {
		transformation = new Transformation();
	}
	
	@Override
	public boolean performFinish() {
		
		transformation.setEnabled(true);
		
		Object element = completionSelectionPage.getSelection();
		if(element instanceof FeatureConfig) {
			FeatureConfig featureConfig = (FeatureConfig) element;
			transformation.setType(TransformationType.FEATURE);
			transformation.setQVTType(TransformationQVTType.QVTR);
			transformation.setFeatureFileURI(featureConfig.getFileURI());
		}
		else if(element instanceof RegisteredCompletion) {
			RegisteredCompletion completion = (RegisteredCompletion) element;
			transformation.setType(TransformationType.REGISTERED);
			transformation.setCompletion(completion.getId());
			if(completion.containsCategory(ConstantsContainer.MARK_COMPLETION))
				transformation.setConfigFileURI(completionConfigurationPage.getFile1Text());
		}
		else if(element instanceof UserDefined) {
			UserDefined userDefined = (UserDefined) element; 
			if(userDefined.getID() == UserDefinedID.ANNOTATED) {
				transformation.setType(TransformationType.ANNOTATED);
				transformation.setQVTType(TransformationQVTType.QVTR);
				transformation.setQVTFileURI(completionConfigurationPage.getFile1Text());
				transformation.setConfigFileURI(completionConfigurationPage.getFile2Text());
				transformation.setMetamodelFileURI(completionConfigurationPage.getFile3Text());
			}
			else if(userDefined.getID() == UserDefinedID.PLAIN) {
				transformation.setType(TransformationType.PLAIN);
				transformation.setQVTType(TransformationQVTType.QVTR);
				transformation.setQVTFileURI(completionConfigurationPage.getFile1Text());
			}
			else if(userDefined.getID() == UserDefinedID.PLAINQVTO) {
				transformation.setType(TransformationType.PLAIN);
				transformation.setQVTType(TransformationQVTType.QVTO);
				transformation.setQVTFileURI(completionConfigurationPage.getFile1Text());
				transformation.setOptionalModelFileURI(completionConfigurationPage.getFile2Text());
			}
			else if(userDefined.getID() == UserDefinedID.FEATURECONFIG) {
				transformation.setType(TransformationType.FEATURE);
				transformation.setQVTType(TransformationQVTType.QVTR);
				transformation.setFeatureFileURI(completionConfigurationPage.getFile1Text());
			}
		}
		return true;
	}
	
	@Override
	public void addPages() {
		setDefaultPageImageDescriptor(RunConfigImages.getChiliIconDescriptor());
		completionSelectionPage = new CompletionSelectionPage("CompletionType");
		completionSelectionPage.setTitle("Select Completion Type");
		completionSelectionPage.setDescription("Select a Completion type and configure it.");
		addPage(completionSelectionPage);
		completionConfigurationPage = new CompletionConfigurationPage("CompletionConfiguration");
		completionConfigurationPage.setTitle("Set Completion Configuration");
		completionConfigurationPage.setDescription("Add configuration files to the completion.");
		addPage(completionConfigurationPage);
	}

	@Override
	public boolean canFinish() {
		if(completionSelectionPage.canFinish())
			return true;
		if(completionConfigurationPage.canFinish())
			return true;
		return false;
	}

	public Transformation getTransformation() {
		return transformation;
	}

}
