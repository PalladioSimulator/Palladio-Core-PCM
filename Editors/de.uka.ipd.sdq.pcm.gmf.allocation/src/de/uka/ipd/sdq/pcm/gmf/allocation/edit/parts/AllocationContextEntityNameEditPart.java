/*
 * Copyright 2007, SDQ, IPD, U KA
 */
package de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts;

/**
 * @generated
 */
public class AllocationContextEntityNameEditPart extends org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart implements org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart {

			/**
 * @generated
 */
	public static final int VISUAL_ID = 5006;

		/**
 * @generated
 */
	private org.eclipse.gef.tools.DirectEditManager manager;

	/**
 * @generated
 */
	private org.eclipse.gmf.runtime.common.ui.services.parser.IParser parser;

		/**
 * @generated
 */
 	private java.util.List<?> parserElements;
	
	/**
 * @generated
 */
	private String defaultText;	

	/**
 * @generated
 */
	private org.eclipse.gmf.runtime.diagram.ui.label.ILabelDelegate labelDelegate;
	
		/**
 * @generated
 */
	public AllocationContextEntityNameEditPart(org.eclipse.gmf.runtime.notation.View view) {
		super(view);
	}
	
		/**
 * @generated
 */
	protected void createDefaultEditPolicies() {
			super.createDefaultEditPolicies();
	installEditPolicy(org.eclipse.gef.EditPolicy.SELECTION_FEEDBACK_ROLE, new de.uka.ipd.sdq.pcm.gmf.allocation.edit.policies.PalladioComponentModelTextSelectionEditPolicy());
	installEditPolicy(org.eclipse.gef.EditPolicy.DIRECT_EDIT_ROLE, new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LabelDirectEditPolicy());
	installEditPolicy(org.eclipse.gef.EditPolicy.PRIMARY_DRAG_ROLE, new de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationEditPart.NodeLabelDragPolicy());
			}
	
			/**
 * @generated
 */
	protected String getLabelTextHelper(org.eclipse.draw2d.IFigure figure) {
		if (figure instanceof org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel) {
			return ((org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel) figure).getText();
		} 		else if (figure instanceof org.eclipse.draw2d.Label) {
			return ((org.eclipse.draw2d.Label) figure).getText();
		} else {
			return getLabelDelegate().getText();
		} 
	}
	
		/**
 * @generated
 */
	protected void setLabelTextHelper(org.eclipse.draw2d.IFigure figure, String text) {
		if (figure instanceof org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel) {
			((org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel) figure).setText(text);
		} 		else if (figure instanceof org.eclipse.draw2d.Label) {
			((org.eclipse.draw2d.Label) figure).setText(text);
		} else {
			getLabelDelegate().setText(text);
		}
	}
	
		/**
 * @generated
 */
	protected org.eclipse.swt.graphics.Image getLabelIconHelper(org.eclipse.draw2d.IFigure figure) {
		if (figure instanceof org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel) {
			return ((org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel) figure).getIcon();
		} 		else if (figure instanceof org.eclipse.draw2d.Label) {
			return ((org.eclipse.draw2d.Label) figure).getIcon();
		} else {
			return getLabelDelegate().getIcon(0);
		}
	}
	
		/**
 * @generated
 */
	protected void setLabelIconHelper(org.eclipse.draw2d.IFigure figure, org.eclipse.swt.graphics.Image icon) {
		if (figure instanceof org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel) {
			((org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel) figure).setIcon(icon);
			return;
		} 		else if (figure instanceof org.eclipse.draw2d.Label) {
			((org.eclipse.draw2d.Label) figure).setIcon(icon);
			return;
		} else {
			getLabelDelegate().setIcon(icon, 0);
		}
	}
	
		/**
 * @generated
 */
	public void setLabel(		org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel
	 figure) {
		unregisterVisuals();
		setFigure(figure);
		defaultText = getLabelTextHelper(figure);
		registerVisuals();
		refreshVisuals();
	}
	
		/**
 * @generated
 */
	@SuppressWarnings("rawtypes")
	protected java.util.List getModelChildren() {
		return java.util.Collections.EMPTY_LIST;
	}
	
		/**
 * @generated
 */
	public org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart getChildBySemanticHint(String semanticHint) {
		return null;
	}
	
		/**
 * @generated
 */
	protected org.eclipse.emf.ecore.EObject getParserElement() {
		return resolveSemanticElement();
	}
	
		/**
 * @generated
 */
	protected org.eclipse.swt.graphics.Image getLabelIcon() {
				org.eclipse.emf.ecore.EObject parserElement = getParserElement();
		if (parserElement == null) {
			return null;
		}
		return de.uka.ipd.sdq.pcm.gmf.allocation.providers.PalladioComponentModelElementTypes.getImage(parserElement.eClass());
			}
	
		/**
 * @generated
 */
	protected String getLabelText() {
		String text = null;
		org.eclipse.emf.ecore.EObject parserElement = getParserElement();
		if (parserElement != null && getParser() != null) {
			text = getParser().getPrintString(
				new org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter(parserElement),
				getParserOptions().intValue());
		}
		if (text == null || text.length() == 0) {
			text = defaultText;
		}
		return text;
	}
	
		/**
 * @generated
 */
	public void setLabelText(String text) {
		setLabelTextHelper(getFigure(), text);
		refreshSelectionFeedback();
	}
	
		/**
 * @generated
 */
	public String getEditText() {
		if (getParserElement() == null || getParser() == null) {
			return "";  //$NON-NLS-1$
		}
		return getParser().getEditString(
			new org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter(getParserElement()),
			getParserOptions().intValue());
	}
	
		/**
 * @generated
 */
	protected boolean isEditable() {
				return getParser() != null;
			}
	
		/**
 * @generated
 */
	public org.eclipse.jface.viewers.ICellEditorValidator getEditTextValidator() {
		return new org.eclipse.jface.viewers.ICellEditorValidator() {

			public String isValid(final Object value) {
				if (value instanceof String) {
					final org.eclipse.emf.ecore.EObject element = getParserElement();
					final org.eclipse.gmf.runtime.common.ui.services.parser.IParser parser = getParser();
					try {
						org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus valid =
							(org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus) getEditingDomain().runExclusive(
								new org.eclipse.emf.transaction.RunnableWithResult.Impl<org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus>() {

							public void run() {
								setResult(parser.isValidEditString(new org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter(element), (String) value));
							}
						});
						return valid.getCode() == org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus.EDITABLE ? null : valid.getMessage();
					} catch (InterruptedException ie) {
						ie.printStackTrace();
					}
				}

				// shouldn't get here
				return null;
			}
		};
	}
	
		/**
 * @generated
 */
	public org.eclipse.jface.text.contentassist.IContentAssistProcessor getCompletionProcessor() {
		if (getParserElement() == null || getParser() == null) {
			return null;
		}
		return getParser().getCompletionProcessor(new org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter(getParserElement()));
	}
	
		/**
 * @generated
 */
	public org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions getParserOptions() {
		return org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions.NONE;
	}
	
		/**
 * @generated
 */
	public org.eclipse.gmf.runtime.common.ui.services.parser.IParser getParser() {
		if (parser == null) {
			parser = de.uka.ipd.sdq.pcm.gmf.allocation.providers.PalladioComponentModelParserProvider.getParser(de.uka.ipd.sdq.pcm.gmf.allocation.providers.PalladioComponentModelElementTypes.AllocationContext_3002, getParserElement(), de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelVisualIDRegistry.getType(de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationContextEntityNameEditPart.VISUAL_ID));
		}
		return parser;
	}
	
		/**
 * @generated
 */
	protected org.eclipse.gef.tools.DirectEditManager getManager() {
		if (manager == null) {
			setManager(new org.eclipse.gmf.tooling.runtime.directedit.TextDirectEditManager2(this,
				null,
				de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.PalladioComponentModelEditPartFactory.getTextCellEditorLocator(this)));
		}
		return manager;
	}
	
		/**
 * @generated
 */
	protected void setManager(org.eclipse.gef.tools.DirectEditManager manager) {
		this.manager = manager;
	}
	
		/**
 * @generated
 */
	protected void performDirectEdit() {
		getManager().show();
	}
	
		/**
 * @generated
 */
	protected void performDirectEdit(org.eclipse.draw2d.geometry.Point eventLocation) {
		if (getManager().getClass() == org.eclipse.gmf.tooling.runtime.directedit.TextDirectEditManager2.class) {
			((org.eclipse.gmf.tooling.runtime.directedit.TextDirectEditManager2) getManager()).show(eventLocation.getSWTPoint());
		}
	}

		/**
 * @generated
 */
	private void performDirectEdit(char initialCharacter) {
		if (getManager() instanceof org.eclipse.gmf.runtime.diagram.ui.tools.TextDirectEditManager) {
			((org.eclipse.gmf.runtime.diagram.ui.tools.TextDirectEditManager) getManager()).show(initialCharacter);
		} else // 
		if (getManager() instanceof org.eclipse.gmf.tooling.runtime.directedit.TextDirectEditManager2) {
			((org.eclipse.gmf.tooling.runtime.directedit.TextDirectEditManager2) getManager()).show(initialCharacter);
		} else //
		{
			performDirectEdit();
		}
	}
	
	
		/**
 * @generated
 */
	protected void performDirectEditRequest(org.eclipse.gef.Request request) {
		final org.eclipse.gef.Request theRequest = request;
		try {
			getEditingDomain().runExclusive(new Runnable() {

				public void run() {
					if (isActive() && isEditable()) {
												if (theRequest.getExtendedData().get(org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants.REQ_DIRECTEDIT_EXTENDEDDATA_INITIAL_CHAR) instanceof Character) {
							Character initialChar = (Character) theRequest.getExtendedData().get(org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants.REQ_DIRECTEDIT_EXTENDEDDATA_INITIAL_CHAR);
							performDirectEdit(initialChar.charValue());
						} else  if ((theRequest instanceof org.eclipse.gef.requests.DirectEditRequest) && (getEditText().equals(getLabelText()))) {
							org.eclipse.gef.requests.DirectEditRequest editRequest = (org.eclipse.gef.requests.DirectEditRequest) theRequest;
							performDirectEdit(editRequest.getLocation());
						} else {
							performDirectEdit();
						}
					}
				}
			});
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
		/**
 * @generated
 */
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshLabel();
		refreshFont();
		refreshFontColor();
		refreshUnderline();
		refreshStrikeThrough();
			}
	
		/**
 * @generated
 */
	protected void refreshLabel() {
		setLabelTextHelper(getFigure(), getLabelText());
		setLabelIconHelper(getFigure(), getLabelIcon());
		refreshSelectionFeedback();
	}
	
		/**
 * @generated
 */
	protected void refreshUnderline() {
		org.eclipse.gmf.runtime.notation.FontStyle style =
			(org.eclipse.gmf.runtime.notation.FontStyle) getFontStyleOwnerView().getStyle(
				org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getFontStyle());
		if (style != null && getFigure() instanceof org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel) {
			((org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel) getFigure()).setTextUnderline(style.isUnderline());
		}
	}
	
		/**
 * @generated
 */
	protected void refreshStrikeThrough() {
		org.eclipse.gmf.runtime.notation.FontStyle style =
			(org.eclipse.gmf.runtime.notation.FontStyle) getFontStyleOwnerView().getStyle(
				org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getFontStyle());
		if (style != null && getFigure() instanceof org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel) {
			((org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel) getFigure()).setTextStrikeThrough(style.isStrikeThrough());
		}
	}
	
		/**
 * @generated
 */
	protected void refreshFont() {
		org.eclipse.gmf.runtime.notation.FontStyle style =
			(org.eclipse.gmf.runtime.notation.FontStyle) getFontStyleOwnerView().getStyle(
				org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getFontStyle());
		if (style != null) {
			org.eclipse.swt.graphics.FontData fontData = new org.eclipse.swt.graphics.FontData(
				style.getFontName(), style.getFontHeight(),
				(style.isBold() ? org.eclipse.swt.SWT.BOLD : org.eclipse.swt.SWT.NORMAL) |
				(style.isItalic() ? org.eclipse.swt.SWT.ITALIC : org.eclipse.swt.SWT.NORMAL));
			setFont(fontData);
		}
	}
	
		/**
 * @generated
 */
	private void refreshSelectionFeedback() {
		requestEditPolicyFeedbackRefresh(org.eclipse.gef.EditPolicy.PRIMARY_DRAG_ROLE);
		requestEditPolicyFeedbackRefresh(org.eclipse.gef.EditPolicy.SELECTION_FEEDBACK_ROLE);
	}
	
	/**
 * @generated
 */
	private void requestEditPolicyFeedbackRefresh(String editPolicyKey) {
		Object editPolicy = getEditPolicy(editPolicyKey);
		if (editPolicy instanceof org.eclipse.gmf.tooling.runtime.edit.policies.labels.IRefreshableFeedbackEditPolicy) {
			((org.eclipse.gmf.tooling.runtime.edit.policies.labels.IRefreshableFeedbackEditPolicy)editPolicy).refreshFeedback();
		}
	}
	
		/**
 * @generated
 */
	protected void setFontColor(org.eclipse.swt.graphics.Color color) {
		getFigure().setForegroundColor(color);
	}
	
		/**
 * @generated
 */
	protected void addSemanticListeners() {
		if (getParser() instanceof org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser) {
			org.eclipse.emf.ecore.EObject element = resolveSemanticElement();
			parserElements = ((org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser) getParser()).getSemanticElementsBeingParsed(element);
			for (int i = 0; i < parserElements.size(); i++) {
				addListenerFilter("SemanticModel" + i, this, (org.eclipse.emf.ecore.EObject) parserElements.get(i));  //$NON-NLS-1$
			}
		} else {
			super.addSemanticListeners();
		}
	}
	
		/**
 * @generated
 */
	protected void removeSemanticListeners() {
		if (parserElements != null) {
			for (int i = 0; i < parserElements.size(); i++) {
				removeListenerFilter("SemanticModel" + i);  //$NON-NLS-1$
			}
		} else {
			super.removeSemanticListeners();
		}
	}
	
		/**
 * @generated
 */
	protected org.eclipse.gef.AccessibleEditPart getAccessibleEditPart() {
		if (accessibleEP == null) {
			accessibleEP = new AccessibleGraphicalEditPart() {

				public void getName(org.eclipse.swt.accessibility.AccessibleEvent e) {
					e.result = getLabelTextHelper(getFigure());
				}
			};
		}
		return accessibleEP;
	}
	
		/**
 * @generated
 */
	 private org.eclipse.gmf.runtime.notation.View getFontStyleOwnerView() {
				return getPrimaryView();
			 }
		
	

  	/**
 * @generated
 */
	private org.eclipse.gmf.runtime.diagram.ui.label.ILabelDelegate getLabelDelegate(){
		if (labelDelegate == null){
			org.eclipse.draw2d.IFigure label = getFigure();
      		if (label instanceof org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel){
        		labelDelegate = new org.eclipse.gmf.runtime.diagram.ui.label.WrappingLabelDelegate((org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel)label);
      		}       		else {
        		labelDelegate = new org.eclipse.gmf.tooling.runtime.draw2d.labels.SimpleLabelDelegate((org.eclipse.draw2d.Label)label);
      		}
    	}
		return labelDelegate;
	}
    
  	/**
 * @generated
 */
	@Override
	public Object getAdapter(Class key) {
		if (org.eclipse.gmf.runtime.diagram.ui.label.ILabelDelegate.class.equals(key)){
			return getLabelDelegate();
		}
		return super.getAdapter(key);
	}

		/**
 * @generated
 */
	protected void addNotationalListeners() {
		super.addNotationalListeners();
		addListenerFilter("PrimaryView", this, getPrimaryView());  //$NON-NLS-1$
	}

	/**
 * @generated
 */
	protected void removeNotationalListeners() {
		super.removeNotationalListeners();
		removeListenerFilter("PrimaryView");  //$NON-NLS-1$
	}
	
			
		/**
 * @generated
 */
	protected void handleNotificationEvent(org.eclipse.emf.common.notify.Notification event) {
			Object feature = event.getFeature();
			if (org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getFontStyle_FontColor().equals(feature)) {
		Integer c = (Integer) event.getNewValue();
		setFontColor(org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramColorRegistry.getInstance().getColor(c));
	} else if (org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getFontStyle_Underline().equals(feature)) {
		refreshUnderline();
	} else if (org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getFontStyle_StrikeThrough().equals(feature)) {
		refreshStrikeThrough();
	} else if (org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getFontStyle_FontHeight().equals(feature) ||
			org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getFontStyle_FontName().equals(feature) ||
			org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getFontStyle_Bold().equals(feature) ||
			org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getFontStyle_Italic().equals(feature)) {
		refreshFont();
	} else {
		if (getParser() != null && getParser().isAffectingEvent(event, getParserOptions().intValue())) {
			refreshLabel();
		}
		if (getParser() instanceof org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser) {
			org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser modelParser =
				(org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser) getParser();
			if (modelParser.areSemanticElementsAffected(null, event)) {
				removeSemanticListeners();
				if (resolveSemanticElement() != null) {
					addSemanticListeners();
				}
				refreshLabel();
			}
		}
	}
	super.handleNotificationEvent(event);
	}
	
		/**
 * @generated
 */
	protected org.eclipse.draw2d.IFigure createFigure() {
		// Parent should assign one using setLabel() method
		return null;
	}
	
	}
