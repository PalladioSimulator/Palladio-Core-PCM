package de.uka.ipd.sdq.cip.runtime.dialogs;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import de.uka.ipd.sdq.cip.configuration.Transformation;
import de.uka.ipd.sdq.cip.configuration.TransformationType;
import de.uka.ipd.sdq.cip.configuration.Transformation.TransformationQVTType;
import de.uka.ipd.sdq.cip.runtime.ConstantsContainer;


public class CompletionConfigurationWidget {

	private FileSelectionWidget file1;
	private FileSelectionWidget file2;
	private FileSelectionWidget file3;
	
	public void createControl(Composite mainComponent) {
		GridLayout mainlayout = new GridLayout();
		mainComponent.setLayout(mainlayout);
		
		file1 = new FileSelectionWidget(mainComponent, SWT.NONE);
		GridData gd = new GridData();
		gd.grabExcessHorizontalSpace = true;
		gd.grabExcessVerticalSpace = false;
		gd.verticalAlignment = SWT.FILL;
		gd.horizontalAlignment = SWT.FILL;
		file1.setLayoutData(gd);
		
		file2 = new FileSelectionWidget(mainComponent, SWT.NONE);
		gd = new GridData();
		gd.grabExcessHorizontalSpace = true;
		gd.grabExcessVerticalSpace = false;
		gd.verticalAlignment = SWT.FILL;
		gd.horizontalAlignment = SWT.FILL;
		file2.setLayoutData(gd);
	
		file3 = new FileSelectionWidget(mainComponent, SWT.NONE);
		gd = new GridData();
		gd.grabExcessHorizontalSpace = true;
		gd.grabExcessVerticalSpace = false;
		gd.verticalAlignment = SWT.FILL;
		gd.horizontalAlignment = SWT.FILL;
		file3.setLayoutData(gd);
		
	}
	
	public void setVisible(TransformationType type, TransformationQVTType qvtType) {
		
		file2.setVisible(false);
		file3.setVisible(false);
		
		if(type == TransformationType.FEATURE) {
			file1.setCaption(ConstantsContainer.FEATURECONFIG_FILE_CAPTION);
			file1.setFileExtensions(ConstantsContainer.FEATURECONFIG_FILE_EXTENSIONS);
		}
		else if(type == TransformationType.REGISTERED) {
			file1.setCaption(ConstantsContainer.MARK_MODEL_CAPTION);
			file1.setFileExtensions(null);
		}
		else if(type == TransformationType.ANNOTATED) {
			file1.setCaption(ConstantsContainer.COMPLETION_FILE_CAPTION);
			file1.setFileExtensions(ConstantsContainer.COMPLETION_FILE_EXTENSIONS_QVTR);
			file2.setVisible(true);
			file2.setCaption(ConstantsContainer.MARK_MODEL_CAPTION);
			file2.setFileExtensions(null);
			file3.setVisible(true);
			file3.setCaption(ConstantsContainer.MARK_METAMODEL_CAPTION);
			file3.setFileExtensions(null);
		}
		else if(type == TransformationType.PLAIN) {
			file1.setCaption(ConstantsContainer.COMPLETION_FILE_CAPTION);
			if(qvtType == TransformationQVTType.QVTR) {
				file1.setFileExtensions(ConstantsContainer.COMPLETION_FILE_EXTENSIONS_QVTR);
			} else {
				file1.setFileExtensions(ConstantsContainer.COMPLETION_FILE_EXTENSIONS_QVTO);
				file2.setVisible(true);
				file2.setCaption(ConstantsContainer.OPTIONAL_MODEL_CAPTION);
				file2.setFileExtensions(null);
			}
		}
	}
	
	public void setTransformation(Transformation transformation) {
		if(transformation.getType() == TransformationType.FEATURE) {
			file1.setText(transformation.getFeatureFileURI());
		}
		else if(transformation.getType() == TransformationType.REGISTERED) {
			file1.setText(transformation.getConfigFileURI());
		}
		else if(transformation.getType() == TransformationType.ANNOTATED) {
			file1.setText(transformation.getQVTFileURI());
			file2.setText(transformation.getConfigFileURI());
			file3.setText(transformation.getMetamodelFileURI());
		}
		else if(transformation.getType() == TransformationType.PLAIN) {
			file1.setText(transformation.getQVTFileURI());
			file2.setText(transformation.getOptionalModelFileURI());
		}
		
		setVisible(transformation.getType(), transformation.getQVTType());
	}
	
	public void getTransformation(Transformation transformation) {
		if(transformation.getType() == TransformationType.FEATURE) {
			transformation.setFeatureFileURI(file1.getText());
		}
		else if(transformation.getType() == TransformationType.REGISTERED) {
			transformation.setConfigFileURI(file1.getText());
		}
		else if(transformation.getType() == TransformationType.ANNOTATED) {
			transformation.setQVTFileURI(file1.getText());
			transformation.setConfigFileURI(file2.getText());
			transformation.setMetamodelFileURI(file3.getText());
		}
		else if(transformation.getType() == TransformationType.PLAIN) {
			transformation.setQVTFileURI(file1.getText());
			transformation.setOptionalModelFileURI(file2.getText());
		}
	}
	
	public String getFile1Text() {
		return file1.getText();
	}
	
	public String getFile2Text() {
		return file2.getText();
	}

	public String getFile3Text() {
		return file3.getText();
	}
}
