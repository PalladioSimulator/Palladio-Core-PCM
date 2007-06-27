package de.uka.ipd.sdq.dialogs.parameters;

import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.dialogs.datatype.PalladioDataTypeDialog;
import de.uka.ipd.sdq.pcm.repository.CompositeDataType;
import de.uka.ipd.sdq.pcm.repository.InnerDeclaration;
import de.uka.ipd.sdq.pcm.repository.Parameter;
import de.uka.ipd.sdq.pcm.repository.Signature;

/** @author roman */
public class UpDownButtonsValidator {

	private static UpDownButtonsValidator singelton = null;
	private CreateEditorContents contents;
	
	private UpDownButtonsValidator() {
	}
	
	public void validate(int elementIndex, int maxIndex) throws Exception{
		if (contents == null)
			throw new Exception("CreateEditorContents is not set!");
		
		if (elementIndex > 0 && elementIndex < maxIndex - 1){
			contents.setUpItemsEnabled(true);
			contents.setDownItemsEnabled(true);
		} else if (elementIndex == 0){
			contents.setUpItemsEnabled(false);
			contents.setDownItemsEnabled(true);
		} else if (elementIndex == maxIndex - 1){
			contents.setDownItemsEnabled(false);
			contents.setUpItemsEnabled(true);
		}else {
			contents.setDownItemsEnabled(true);
			contents.setUpItemsEnabled(true);
		}
	}

	/** Validate selection from table viewer */
	public void validateSelection(Object selection) {
		if (selection == null) {
			contents.setDeleteItemsEnabled(false);
			contents.setDownItemsEnabled(false);
			contents.setUpItemsEnabled(false);
		} else if (selection instanceof Parameter) {
			Parameter parameter = (Parameter) selection;
			try {
				UpDownButtonsValidator.getSingelton().validateParameter(
						parameter);
				contents.setDeleteItemsEnabled(true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (selection instanceof InnerDeclaration) {
			InnerDeclaration declaration = (InnerDeclaration) selection;
			try {
				UpDownButtonsValidator.getSingelton().validateInnerDeclaration(
						declaration);
				contents.setDeleteItemsEnabled(true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Validate (Enabled/Unenabled) up-, down-button in the ParameterDialog.
	 * Call if selection instanceof Parameter.
	 */
	public void validateParameter(Parameter parameter) throws Exception {
		Signature signature = parameter.getSignature_Parameter();
		EList<Parameter> parameters = signature.getParameters__Signature();
		validate(parameters.indexOf(parameter), parameters.size());

	}
	
	/**
	 * Validate (Enabled/Unenabled) up-, down-button in the DataTypeDialog. Call
	 * if selection instanceof InnerDeclaration.
	 */
	public void validateInnerDeclaration(InnerDeclaration declaration)
			throws Exception {
		if (declaration.eContainer() instanceof CompositeDataType) {
			CompositeDataType dataType = (CompositeDataType) declaration
					.eContainer();
			EList<InnerDeclaration> declarations = dataType
					.getInnerDeclaration_CompositeDataType();
			validate(declarations.indexOf(declaration), declarations.size());
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean validdateDeclarationInnerDataType(InnerDeclaration declaration, PalladioDataTypeDialog dialog){
		if (declaration.getDatatype_InnerDeclaration() == null) {
			dialog.setErrorMessage(dialog.ERROR_MSG_INNER_TYPE);
			return false;
		}
		if (declaration.getEntityName().equals("")) {
			dialog.setErrorMessage(dialog.ERROR_MSG_INNER_NAME);
			return false;
		}
		return true;
	}
	
	public static UpDownButtonsValidator getSingelton() {
		if (singelton == null)
			singelton = new UpDownButtonsValidator();
		return singelton;
	}

	public void setContents(CreateEditorContents contents) {
		this.contents = contents;
	}
}
