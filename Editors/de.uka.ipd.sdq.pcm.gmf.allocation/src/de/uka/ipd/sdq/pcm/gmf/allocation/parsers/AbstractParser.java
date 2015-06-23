/*
 * Copyright 2007, SDQ, IPD, U KA
 */
package de.uka.ipd.sdq.pcm.gmf.allocation.parsers;

/**
 * @generated
 */
public abstract class AbstractParser implements org.eclipse.gmf.runtime.common.ui.services.parser.IParser {

	/**
 * @generated
 */
	protected final org.eclipse.emf.ecore.EAttribute[] features;

	/**
 * @generated
 */
	protected final org.eclipse.emf.ecore.EAttribute[] editableFeatures;

	/**
 * @generated
 */
	private String viewPattern;

	/**
 * @generated
 */
	private String editorPattern;

	/**
 * @generated
 */
	private String editPattern;

	/**
 * @generated
 */
	public AbstractParser(org.eclipse.emf.ecore.EAttribute[] features) {
		if (features == null || java.util.Arrays.asList(features).contains(null)) {
			throw new IllegalArgumentException();
		}
		this.editableFeatures = this.features = features;
	}

	/**
 * @generated
 */
	public AbstractParser(org.eclipse.emf.ecore.EAttribute[] features,
			org.eclipse.emf.ecore.EAttribute[] editableFeatures) {
		if (features == null || java.util.Arrays.asList(features).contains(null)) {
			throw new IllegalArgumentException();
		}
		this.features = features;
		if (editableFeatures == null || java.util.Arrays.asList(editableFeatures).contains(null)) {
			throw new IllegalArgumentException();
		}
		this.editableFeatures = editableFeatures;
	}

	/**
 * @generated
 */
	public String getViewPattern() {
		return viewPattern;
	}

	/**
 * @generated
 */
	public void setViewPattern(String viewPattern) {
		this.viewPattern = viewPattern;
	}

	/**
 * @generated
 */
	public String getEditorPattern() {
		return editorPattern;
	}

	/**
 * @generated
 */
	public void setEditorPattern(String editorPattern) {
		this.editorPattern = editorPattern;
	}

	/**
 * @generated
 */
	public String getEditPattern() {
		return editPattern;
	}

	/**
 * @generated
 */
	public void setEditPattern(String editPattern) {
		this.editPattern = editPattern;
	}

	/**
 * @generated
 */
	public boolean isAffectingEvent(Object event, int flags) {
		if (event instanceof org.eclipse.emf.common.notify.Notification) {
			return isAffectingFeature(((org.eclipse.emf.common.notify.Notification) event).getFeature());
		}
		return false;
	}

	/**
 * @generated
 */
	protected boolean isAffectingFeature(Object feature) {
		for (int i = 0; i < features.length; i++) {
			if (features[i] == feature) {
				return true;
			}
		}
		return false;
	}

	/**
 * @generated
 */
	public org.eclipse.jface.text.contentassist.IContentAssistProcessor getCompletionProcessor(
			org.eclipse.core.runtime.IAdaptable element) {
		return null;
	}

	/**
 * @generated
 */
	protected Object[] getValues(org.eclipse.emf.ecore.EObject element) {
		Object[] values = new Object[features.length];
		for (int i = 0; i < features.length; i++) {
			values[i] = getValue(element, features[i]);
		}
		return values;
	}

	/**
 * @generated
 */
	protected Object[] getEditableValues(org.eclipse.emf.ecore.EObject element) {
		Object[] values = new Object[editableFeatures.length];
		for (int i = 0; i < editableFeatures.length; i++) {
			values[i] = getValue(element, editableFeatures[i]);
		}
		return values;
	}

	/**
 * @generated
 */
	protected Object getValue(org.eclipse.emf.ecore.EObject element, org.eclipse.emf.ecore.EAttribute feature) {
		Object value = element.eGet(feature);
		Class iClass = feature.getEAttributeType().getInstanceClass();
		if (String.class.equals(iClass)) {
			if (value == null) {
				value = "";  //$NON-NLS-1$
			}
		}
		return value;
	}

	/**
 * @generated
 */
	protected org.eclipse.gmf.runtime.common.core.command.ICommand getParseCommand(
			org.eclipse.core.runtime.IAdaptable adapter, Object[] values, int flags) {
		if (values == null || validateNewValues(values).getCode() !=
				org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus.EDITABLE) {
			return org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand.INSTANCE;
		}
		org.eclipse.emf.ecore.EObject element =
				(org.eclipse.emf.ecore.EObject) adapter.getAdapter(org.eclipse.emf.ecore.EObject.class);
		org.eclipse.emf.transaction.TransactionalEditingDomain editingDomain =
				org.eclipse.emf.transaction.util.TransactionUtil.getEditingDomain(element);
		if (editingDomain == null) {
			return org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand.INSTANCE;
		}
		org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand command =
				new org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand(
						editingDomain, "Set Values");  //$NON-NLS-1$
		for (int i = 0; i < values.length; i++) {
			command.compose(getModificationCommand(element, editableFeatures[i], values[i]));
		}
		return command;
	}

	/**
 * @generated
 */
	protected org.eclipse.gmf.runtime.common.core.command.ICommand getModificationCommand(
			org.eclipse.emf.ecore.EObject element, org.eclipse.emf.ecore.EAttribute feature, Object value) {
		value = getValidNewValue(feature, value);
		if (value instanceof InvalidValue) {
			return org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand.INSTANCE;
		}
		org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest request =
				new org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest(element, feature, value);
		return new org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand(request);
	}

	/**
 * @generated
 */
	protected org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus validateNewValues(Object[] values) {
		if (values.length != editableFeatures.length) {
			return org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus.UNEDITABLE_STATUS;
		}
		for (int i = 0; i < values.length; i++) {
			Object value = getValidNewValue(editableFeatures[i], values[i]);
			if (value instanceof InvalidValue) {
				return new org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus(
						de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelAllocationDiagramEditorPlugin.ID,
						org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus.UNEDITABLE,
						value.toString());
			}
		}
		return org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus.EDITABLE_STATUS;
	}

	/**
 * @generated
 */
	protected Object getValidNewValue(org.eclipse.emf.ecore.EAttribute feature, Object value) {
		org.eclipse.emf.ecore.EClassifier type = feature.getEType();
		if (type instanceof org.eclipse.emf.ecore.EDataType) {
			Class iClass = type.getInstanceClass();
			if (Boolean.TYPE.equals(iClass)) {
				if (value instanceof Boolean) {
					// ok
				} else if (value instanceof String) {
					value = Boolean.valueOf((String) value);
				} else {
					value = new InvalidValue(org.eclipse.osgi.util.NLS.bind(de.uka.ipd.sdq.pcm.gmf.allocation.part.Messages.AbstractParser_UnexpectedValueType, iClass.getName()));
				}
			} else if (Character.TYPE.equals(iClass)) {
				if (value instanceof Character) {
					// ok
				} else if (value instanceof String) {
					String s = (String) value;
					if (s.length() == 0) {
						value = null;
					} else {
						value = new Character(s.charAt(0));
					}
				} else {
					value = new InvalidValue(org.eclipse.osgi.util.NLS.bind(de.uka.ipd.sdq.pcm.gmf.allocation.part.Messages.AbstractParser_UnexpectedValueType, iClass.getName()));
				}
			} else if (Byte.TYPE.equals(iClass)) {
				if (value instanceof Byte) {
					// ok
				} else if (value instanceof Number) {
					value = new Byte(((Number) value).byteValue());
				} else if (value instanceof String) {
					String s = (String) value;
					if (s.length() == 0) {
						value = null;
					} else {
						try {
							value = Byte.valueOf(s);
						} catch (NumberFormatException nfe) {
							value = new InvalidValue(org.eclipse.osgi.util.NLS.bind(de.uka.ipd.sdq.pcm.gmf.allocation.part.Messages.AbstractParser_WrongStringConversion, iClass.getName()));
						}
					}
				} else {
					value = new InvalidValue(org.eclipse.osgi.util.NLS.bind(de.uka.ipd.sdq.pcm.gmf.allocation.part.Messages.AbstractParser_UnexpectedValueType, iClass.getName()));
				}
			} else if (Short.TYPE.equals(iClass)) {
				if (value instanceof Short) {
					// ok
				} else if (value instanceof Number) {
					value = new Short(((Number) value).shortValue());
				} else if (value instanceof String) {
					String s = (String) value;
					if (s.length() == 0) {
						value = null;
					} else {
						try {
							value = Short.valueOf(s);
						} catch (NumberFormatException nfe) {
							value = new InvalidValue(org.eclipse.osgi.util.NLS.bind(de.uka.ipd.sdq.pcm.gmf.allocation.part.Messages.AbstractParser_WrongStringConversion, iClass.getName()));
						}
					}
				} else {
					value = new InvalidValue(org.eclipse.osgi.util.NLS.bind(de.uka.ipd.sdq.pcm.gmf.allocation.part.Messages.AbstractParser_UnexpectedValueType, iClass.getName()));
				}
			} else if (Integer.TYPE.equals(iClass)) {
				if (value instanceof Integer) {
					// ok
				} else if (value instanceof Number) {
					value = new Integer(((Number) value).intValue());
				} else if (value instanceof String) {
					String s = (String) value;
					if (s.length() == 0) {
						value = null;
					} else {
						try {
							value = Integer.valueOf(s);
						} catch (NumberFormatException nfe) {
							value = new InvalidValue(org.eclipse.osgi.util.NLS.bind(de.uka.ipd.sdq.pcm.gmf.allocation.part.Messages.AbstractParser_WrongStringConversion, iClass.getName()));
						}
					}
				} else {
					value = new InvalidValue(org.eclipse.osgi.util.NLS.bind(de.uka.ipd.sdq.pcm.gmf.allocation.part.Messages.AbstractParser_UnexpectedValueType, iClass.getName()));
				}
			} else if (Long.TYPE.equals(iClass)) {
				if (value instanceof Long) {
					// ok
				} else if (value instanceof Number) {
					value = new Long(((Number) value).longValue());
				} else if (value instanceof String) {
					String s = (String) value;
					if (s.length() == 0) {
						value = null;
					} else {
						try {
							value = Long.valueOf(s);
						} catch (NumberFormatException nfe) {
							value = new InvalidValue(org.eclipse.osgi.util.NLS.bind(de.uka.ipd.sdq.pcm.gmf.allocation.part.Messages.AbstractParser_WrongStringConversion, iClass.getName()));
						}
					}
				} else {
					value = new InvalidValue(org.eclipse.osgi.util.NLS.bind(de.uka.ipd.sdq.pcm.gmf.allocation.part.Messages.AbstractParser_UnexpectedValueType, iClass.getName()));
				}
			} else if (Float.TYPE.equals(iClass)) {
				if (value instanceof Float) {
					// ok
				} else if (value instanceof Number) {
					value = new Float(((Number) value).floatValue());
				} else if (value instanceof String) {
					String s = (String) value;
					if (s.length() == 0) {
						value = null;
					} else {
						try {
							value = Float.valueOf(s);
						} catch (NumberFormatException nfe) {
							value = new InvalidValue(org.eclipse.osgi.util.NLS.bind(de.uka.ipd.sdq.pcm.gmf.allocation.part.Messages.AbstractParser_WrongStringConversion, iClass.getName()));
						}
					}
				} else {
					value = new InvalidValue(org.eclipse.osgi.util.NLS.bind(de.uka.ipd.sdq.pcm.gmf.allocation.part.Messages.AbstractParser_UnexpectedValueType, iClass.getName()));
				}
			} else if (Double.TYPE.equals(iClass)) {
				if (value instanceof Double) {
					// ok
				} else if (value instanceof Number) {
					value = new Double(((Number) value).doubleValue());
				} else if (value instanceof String) {
					String s = (String) value;
					if (s.length() == 0) {
						value = null;
					} else {
						try {
							value = Double.valueOf(s);
						} catch (NumberFormatException nfe) {
							value = new InvalidValue(org.eclipse.osgi.util.NLS.bind(de.uka.ipd.sdq.pcm.gmf.allocation.part.Messages.AbstractParser_WrongStringConversion, iClass.getName()));
						}
					}
				} else {
					value = new InvalidValue(org.eclipse.osgi.util.NLS.bind(de.uka.ipd.sdq.pcm.gmf.allocation.part.Messages.AbstractParser_UnexpectedValueType, iClass.getName()));
				}
			} else if (type instanceof org.eclipse.emf.ecore.EEnum) {
				if (value instanceof String) {
					org.eclipse.emf.ecore.EEnumLiteral literal =
							((org.eclipse.emf.ecore.EEnum) type).getEEnumLiteralByLiteral((String) value);
					if (literal == null) {
						value = new InvalidValue(org.eclipse.osgi.util.NLS.bind(de.uka.ipd.sdq.pcm.gmf.allocation.part.Messages.AbstractParser_UnknownLiteral, value));
					} else {
						value = literal.getInstance();
					}
				} else {
					value = new InvalidValue(org.eclipse.osgi.util.NLS.bind(de.uka.ipd.sdq.pcm.gmf.allocation.part.Messages.AbstractParser_UnexpectedValueType, String.class.getName()));
				}
			}
		}
		return value;
	}

	/**
 * @generated
 */
	protected class InvalidValue {

		/**
 * @generated
 */
		private String description;

		/**
 * @generated
 */
		public InvalidValue(String description) {
			this.description = description;
		}

		/**
 * @generated
 */
		public String toString() {
			return description;
		}
	}
	}
