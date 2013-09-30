
/*
 * Copyright 2007, SDQ, IPD, U KA
 */
package de.uka.ipd.sdq.pcm.gmf.allocation.parsers;

/**
 * @generated
 */
public class MessageFormatParser extends de.uka.ipd.sdq.pcm.gmf.allocation.parsers.AbstractParser {

	/**
 * @generated
 */
	private String defaultPattern;

	/**
 * @generated
 */
	private String defaultEditablePattern;

	/**
 * @generated
 */
	private java.text.MessageFormat viewProcessor;

	/**
 * @generated
 */
	private java.text.MessageFormat editorProcessor;

	/**
 * @generated
 */
	private java.text.MessageFormat editProcessor;

	/**
 * @generated
 */
	public MessageFormatParser(org.eclipse.emf.ecore.EAttribute[] features) {
		super(features);
	}

	/**
 * @generated
 */
	public MessageFormatParser(org.eclipse.emf.ecore.EAttribute[] features, org.eclipse.emf.ecore.EAttribute[] editableFeatures) {
		super(features, editableFeatures);
	}

	/**
 * @generated
 */
	protected String getDefaultPattern() {
		if (defaultPattern == null) {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < features.length; i++) {
				if (i > 0) {
					sb.append(' ');
				}
				sb.append('{');
				sb.append(i);
				sb.append('}');
			}
			defaultPattern = sb.toString();
		}
		return defaultPattern;
	}

	/**
 * @generated
 */
	public void setViewPattern(String viewPattern) {
		super.setViewPattern(viewPattern);
		viewProcessor = null;
	}

	/**
 * @generated
 */
	public void setEditorPattern(String editorPattern) {
		super.setEditorPattern(editorPattern);
		editorProcessor = null;
	}

	/**
 * @generated
 */
	protected java.text.MessageFormat getViewProcessor() {
		if (viewProcessor == null) {
			viewProcessor = new java.text.MessageFormat(getViewPattern() == null ? getDefaultPattern() : getViewPattern());
		}
		return viewProcessor;
	}

	/**
 * @generated
 */
	protected java.text.MessageFormat getEditorProcessor() {
		if (editorProcessor == null) {
			editorProcessor = new java.text.MessageFormat(getEditorPattern() == null ? getDefaultEditablePattern() : getEditorPattern());
		}
		return editorProcessor;
	}
	/**
 * @generated
 */
	protected String getDefaultEditablePattern() {
		if (defaultEditablePattern == null) {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < editableFeatures.length; i++) {
				if (i > 0) {
					sb.append(' ');
				}
				sb.append('{');
				sb.append(i);
				sb.append('}');
			}
			defaultEditablePattern = sb.toString();
		}
		return defaultEditablePattern;
	}
	/**
 * @generated
 */
	public void setEditPattern(String editPattern) {
		super.setEditPattern(editPattern);
		editProcessor = null;
	}

	/**
 * @generated
 */
	protected java.text.MessageFormat getEditProcessor() {
		if (editProcessor == null) {
			editProcessor = new java.text.MessageFormat(getEditPattern() == null ? getDefaultEditablePattern() : getEditPattern());
		}
		return editProcessor;
	}

	/**
 * @generated
 */
	public String getEditString(org.eclipse.core.runtime.IAdaptable adapter, int flags) {
		org.eclipse.emf.ecore.EObject element =	(org.eclipse.emf.ecore.EObject) adapter.getAdapter(org.eclipse.emf.ecore.EObject.class);
		return getEditorProcessor().format(getEditableValues(element), new StringBuffer(),	new java.text.FieldPosition(0)).toString();
	}

	/**
 * @generated
 */
	public org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus isValidEditString(org.eclipse.core.runtime.IAdaptable adapter, String editString) {
		java.text.ParsePosition pos = new java.text.ParsePosition(0);
		Object[] values = getEditProcessor().parse(editString, pos);
		if (values == null) {
			return new org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus(
					de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelAllocationDiagramEditorPlugin.ID,
					org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus.UNEDITABLE,
					org.eclipse.osgi.util.NLS.bind(
							de.uka.ipd.sdq.pcm.gmf.allocation.part.Messages.MessageFormatParser_InvalidInputError,
							new Integer(pos.getErrorIndex())));
		}
		return validateNewValues(values);
	}

	/**
 * @generated
 */
	public org.eclipse.gmf.runtime.common.core.command.ICommand getParseCommand(org.eclipse.core.runtime.IAdaptable adapter, String newString, int flags) {
		Object[] values = getEditProcessor().parse(newString, new java.text.ParsePosition(0));
		return getParseCommand(adapter, values, flags);
	}

	/**
 * @generated
 */
	public String getPrintString(org.eclipse.core.runtime.IAdaptable adapter, int flags) {
		org.eclipse.emf.ecore.EObject element = (org.eclipse.emf.ecore.EObject) adapter.getAdapter(org.eclipse.emf.ecore.EObject.class);
		return getViewProcessor().format(getValues(element), new StringBuffer(), new java.text.FieldPosition(0)).toString();
	}




}
