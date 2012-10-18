/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.edit.parts;

import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.gef.AccessibleEditPart;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gef.requests.SelectionRequest;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.LabelDirectEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ListItemComponentEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramColorRegistry;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.diagram.ui.tools.DragEditPartsTrackerEx;
import org.eclipse.gmf.runtime.diagram.ui.tools.TextDirectEditManager;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.viewers.ICellEditorValidator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.accessibility.AccessibleEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;

import de.uka.ipd.sdq.pcm.dialogs.OpenStoExDialog;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.policies.PalladioComponentModelTextNonResizableEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.policies.PalladioComponentModelTextSelectionEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.policies.VariableCharacterisation4ItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.gmf.seff.providers.PalladioComponentModelElementTypes;
import de.uka.ipd.sdq.pcm.gmf.seff.providers.PalladioComponentModelParserProvider;
import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation;
import de.uka.ipd.sdq.pcm.stochasticexpressions.PCMStoExPrettyPrintVisitor;
import de.uka.ipd.sdq.stoex.Expression;

/**
 * The Class VariableCharacterisation4EditPart.
 *
 * @generated
 */
public class VariableCharacterisation4EditPart extends CompartmentEditPart implements ITextAwareEditPart {

    /** The Constant VISUAL_ID. @generated */
    public static final int VISUAL_ID = 3048;

    /** The manager. @generated */
    private DirectEditManager manager;

    /** The parser. @generated */
    private IParser parser;

    /** The parser elements. @generated */
    private List parserElements;

    /** The default text. @generated */
    private String defaultText;

    /**
     * Instantiates a new variable characterisation4 edit part.
     *
     * @param view the view
     * @generated
     */
    public VariableCharacterisation4EditPart(View view) {
        super(view);
    }

    /**
     * Gets the drag tracker.
     *
     * @param request the request
     * @return the drag tracker
     * @generated
     */
    @Override
    public DragTracker getDragTracker(Request request) {
        if (request instanceof SelectionRequest && ((SelectionRequest) request).getLastButtonPressed() == 3) {
            return null;
        }
        return new DragEditPartsTrackerEx(this);
    }

    /**
     * Creates the default edit policies.
     *
     * @generated
     */
    @Override
    protected void createDefaultEditPolicies() {
        super.createDefaultEditPolicies();
        installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new VariableCharacterisation4ItemSemanticEditPolicy());
        installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new PalladioComponentModelTextNonResizableEditPolicy());
        installEditPolicy(EditPolicy.COMPONENT_ROLE, new ListItemComponentEditPolicy());
        installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new LabelDirectEditPolicy());
        installEditPolicy(EditPolicyRoles.OPEN_ROLE, new OpenStoExDialog());
    }

    /**
     * Gets the label text helper.
     *
     * @param figure the figure
     * @return the label text helper
     * @generated
     */
    protected String getLabelTextHelper(IFigure figure) {
        if (figure instanceof WrappingLabel) {
            return ((WrappingLabel) figure).getText();
        } else {
            return ((Label) figure).getText();
        }
    }

    /**
     * Sets the label text helper.
     *
     * @param figure the figure
     * @param text the text
     * @generated
     */
    protected void setLabelTextHelper(IFigure figure, String text) {
        if (figure instanceof WrappingLabel) {
            ((WrappingLabel) figure).setText(text);
        } else {
            ((Label) figure).setText(text);
        }
    }

    /**
     * Gets the label icon helper.
     *
     * @param figure the figure
     * @return the label icon helper
     * @generated
     */
    protected Image getLabelIconHelper(IFigure figure) {
        if (figure instanceof WrappingLabel) {
            return ((WrappingLabel) figure).getIcon();
        } else {
            return ((Label) figure).getIcon();
        }
    }

    /**
     * Sets the label icon helper.
     *
     * @param figure the figure
     * @param icon the icon
     * @generated
     */
    protected void setLabelIconHelper(IFigure figure, Image icon) {
        if (figure instanceof WrappingLabel) {
            ((WrappingLabel) figure).setIcon(icon);
        } else {
            ((Label) figure).setIcon(icon);
        }
    }

    /**
     * Sets the label.
     *
     * @param figure the new label
     * @generated
     */
    public void setLabel(IFigure figure) {
        unregisterVisuals();
        setFigure(figure);
        defaultText = getLabelTextHelper(figure);
        registerVisuals();
        refreshVisuals();
    }

    /**
     * Gets the model children.
     *
     * @return the model children
     * @generated
     */
    @Override
    protected List getModelChildren() {
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the child by semantic hint.
     *
     * @param semanticHint the semantic hint
     * @return the child by semantic hint
     * @generated
     */
    @Override
    public IGraphicalEditPart getChildBySemanticHint(String semanticHint) {
        return null;
    }

    /**
     * Gets the parser element.
     *
     * @return the parser element
     * @generated
     */
    protected EObject getParserElement() {
        return resolveSemanticElement();
    }

    /**
     * Gets the label icon.
     *
     * @return the label icon
     * @generated
     */
    protected Image getLabelIcon() {
        EObject parserElement = getParserElement();
        if (parserElement == null) {
            return null;
        }
        return PalladioComponentModelElementTypes.getImage(parserElement.eClass());
    }

    
    /**
     * Gets the label text.
     *
     * @return the label text
     * @generated not
     */
    protected String getLabelText() {
        String text = null;
        VariableCharacterisation vc = (VariableCharacterisation) this.resolveSemanticElement();
        if (vc != null) {
            text = vc.getType().getLiteral() + " = ";
            if (vc.getSpecification_VariableCharacterisation() != null) {
                Expression expression = vc.getSpecification_VariableCharacterisation().getExpression();
                if (expression != null) {
                    text += new PCMStoExPrettyPrintVisitor().prettyPrint(expression);
                }
            } else {
                text = null;
            }
        }
        if (text == null || text.length() == 0) {
            text = defaultText;
        }
        return text;
    }

    /**
     * Sets the label text.
     *
     * @param text the new label text
     * @generated
     */
    @Override
    public void setLabelText(String text) {
        setLabelTextHelper(getFigure(), text);
        Object pdEditPolicy = getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
        if (pdEditPolicy instanceof PalladioComponentModelTextSelectionEditPolicy) {
            ((PalladioComponentModelTextSelectionEditPolicy) pdEditPolicy).refreshFeedback();
        }
        Object sfEditPolicy = getEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE);
        if (sfEditPolicy instanceof PalladioComponentModelTextSelectionEditPolicy) {
            ((PalladioComponentModelTextSelectionEditPolicy) sfEditPolicy).refreshFeedback();
        }
    }

    /**
     * Gets the edits the text.
     *
     * @return the edits the text
     * @generated
     */
    @Override
    public String getEditText() {
        if (getParserElement() == null || getParser() == null) {
            return ""; //$NON-NLS-1$
        }
        return getParser().getEditString(new EObjectAdapter(getParserElement()), getParserOptions().intValue());
    }

    /**
     * Checks if is editable.
     *
     * @return true, if is editable
     * @generated
     */
    protected boolean isEditable() {
        return false;
    }

    /**
     * Gets the edits the text validator.
     *
     * @return the edits the text validator
     * @generated
     */
    @Override
    public ICellEditorValidator getEditTextValidator() {
        return new ICellEditorValidator() {

            @Override
            public String isValid(final Object value) {
                if (value instanceof String) {
                    final EObject element = getParserElement();
                    final IParser parser = getParser();
                    try {
                        IParserEditStatus valid = (IParserEditStatus) getEditingDomain().runExclusive(
                                new RunnableWithResult.Impl() {

                                    @Override
                                    public void run() {
                                        setResult(parser.isValidEditString(new EObjectAdapter(element), (String) value));
                                    }
                                });
                        return valid.getCode() == ParserEditStatus.EDITABLE ? null : valid.getMessage();
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
     * Gets the completion processor.
     *
     * @return the completion processor
     * @generated
     */
    @Override
    public IContentAssistProcessor getCompletionProcessor() {
        if (getParserElement() == null || getParser() == null) {
            return null;
        }
        return getParser().getCompletionProcessor(new EObjectAdapter(getParserElement()));
    }

    /**
     * Gets the parser options.
     *
     * @return the parser options
     * @generated
     */
    @Override
    public ParserOptions getParserOptions() {
        return ParserOptions.NONE;
    }

    /**
     * Gets the parser.
     *
     * @return the parser
     * @generated
     */
    @Override
    public IParser getParser() {
        if (parser == null) {
            parser = PalladioComponentModelParserProvider
                    .getParser(
                            PalladioComponentModelElementTypes.VariableCharacterisation_3048,
                            getParserElement(),
                            PalladioComponentModelVisualIDRegistry
                                    .getType(de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableCharacterisation4EditPart.VISUAL_ID));
        }
        return parser;
    }

    /**
     * Gets the manager.
     *
     * @return the manager
     * @generated
     */
    protected DirectEditManager getManager() {
        if (manager == null) {
            setManager(new TextDirectEditManager(this, TextDirectEditManager.getTextCellEditorClass(this),
                    PalladioComponentModelEditPartFactory.getTextCellEditorLocator(this)));
        }
        return manager;
    }

    /**
     * Sets the manager.
     *
     * @param manager the new manager
     * @generated
     */
    protected void setManager(DirectEditManager manager) {
        this.manager = manager;
    }

    /**
     * Perform direct edit.
     *
     * @generated
     */
    protected void performDirectEdit() {
        getManager().show();
    }

    /**
     * Perform direct edit.
     *
     * @param eventLocation the event location
     * @generated
     */
    protected void performDirectEdit(Point eventLocation) {
        if (getManager().getClass() == TextDirectEditManager.class) {
            ((TextDirectEditManager) getManager()).show(eventLocation.getSWTPoint());
        }
    }

    /**
     * Perform direct edit.
     *
     * @param initialCharacter the initial character
     * @generated
     */
    private void performDirectEdit(char initialCharacter) {
        if (getManager() instanceof TextDirectEditManager) {
            ((TextDirectEditManager) getManager()).show(initialCharacter);
        } else {
            performDirectEdit();
        }
    }

    /**
     * Perform direct edit request.
     *
     * @param request the request
     * @generated
     */
    @Override
    protected void performDirectEditRequest(Request request) {
        final Request theRequest = request;
        try {
            getEditingDomain().runExclusive(new Runnable() {

                @Override
                public void run() {
                    if (isActive() && isEditable()) {
                        if (theRequest.getExtendedData().get(RequestConstants.REQ_DIRECTEDIT_EXTENDEDDATA_INITIAL_CHAR) instanceof Character) {
                            Character initialChar = (Character) theRequest.getExtendedData().get(
                                    RequestConstants.REQ_DIRECTEDIT_EXTENDEDDATA_INITIAL_CHAR);
                            performDirectEdit(initialChar.charValue());
                        } else if ((theRequest instanceof DirectEditRequest) && (getEditText().equals(getLabelText()))) {
                            DirectEditRequest editRequest = (DirectEditRequest) theRequest;
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
     * Refresh visuals.
     *
     * @generated
     */
    @Override
    protected void refreshVisuals() {
        super.refreshVisuals();
        refreshLabel();
        refreshFont();
        refreshFontColor();
        refreshUnderline();
        refreshStrikeThrough();
    }

    /**
     * Refresh label.
     *
     * @generated
     */
    protected void refreshLabel() {
        setLabelTextHelper(getFigure(), getLabelText());
        setLabelIconHelper(getFigure(), getLabelIcon());
        Object pdEditPolicy = getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
        if (pdEditPolicy instanceof PalladioComponentModelTextSelectionEditPolicy) {
            ((PalladioComponentModelTextSelectionEditPolicy) pdEditPolicy).refreshFeedback();
        }
        Object sfEditPolicy = getEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE);
        if (sfEditPolicy instanceof PalladioComponentModelTextSelectionEditPolicy) {
            ((PalladioComponentModelTextSelectionEditPolicy) sfEditPolicy).refreshFeedback();
        }
    }

    /**
     * Refresh underline.
     *
     * @generated
     */
    protected void refreshUnderline() {
        FontStyle style = (FontStyle) getFontStyleOwnerView().getStyle(NotationPackage.eINSTANCE.getFontStyle());
        if (style != null && getFigure() instanceof WrappingLabel) {
            ((WrappingLabel) getFigure()).setTextUnderline(style.isUnderline());
        }
    }

    /**
     * Refresh strike through.
     *
     * @generated
     */
    protected void refreshStrikeThrough() {
        FontStyle style = (FontStyle) getFontStyleOwnerView().getStyle(NotationPackage.eINSTANCE.getFontStyle());
        if (style != null && getFigure() instanceof WrappingLabel) {
            ((WrappingLabel) getFigure()).setTextStrikeThrough(style.isStrikeThrough());
        }
    }

    /**
     * Refresh font.
     *
     * @generated
     */
    @Override
    protected void refreshFont() {
        FontStyle style = (FontStyle) getFontStyleOwnerView().getStyle(NotationPackage.eINSTANCE.getFontStyle());
        if (style != null) {
            FontData fontData = new FontData(style.getFontName(), style.getFontHeight(), (style.isBold() ? SWT.BOLD
                    : SWT.NORMAL) | (style.isItalic() ? SWT.ITALIC : SWT.NORMAL));
            setFont(fontData);
        }
    }

    /**
     * Sets the font color.
     *
     * @param color the new font color
     * @generated
     */
    @Override
    protected void setFontColor(Color color) {
        getFigure().setForegroundColor(color);
    }

    /**
     * Adds the semantic listeners.
     *
     * @generated not
     */
    @Override
    protected void addSemanticListeners() {
        VariableCharacterisation characterisation = (VariableCharacterisation) resolveSemanticElement();
        addListenerFilter("SemanticModel", this, characterisation.getSpecification_VariableCharacterisation());
        addListenerFilter("SemanticModel2", this, characterisation);
    }

    /**
     * Removes the semantic listeners.
     *
     * @generated not
     */
    @Override
    protected void removeSemanticListeners() {
        removeListenerFilter("SemanticModel");
        removeListenerFilter("SemanticModel2");
    }

    /**
     * Gets the accessible edit part.
     *
     * @return the accessible edit part
     * @generated
     */
    @Override
    protected AccessibleEditPart getAccessibleEditPart() {
        if (accessibleEP == null) {
            accessibleEP = new AccessibleGraphicalEditPart() {

                @Override
                public void getName(AccessibleEvent e) {
                    e.result = getLabelTextHelper(getFigure());
                }
            };
        }
        return accessibleEP;
    }

    /**
     * Gets the font style owner view.
     *
     * @return the font style owner view
     * @generated
     */
    private View getFontStyleOwnerView() {
        return getPrimaryView();
    }

    /**
     * Adds the notational listeners.
     *
     * @generated
     */
    @Override
    protected void addNotationalListeners() {
        super.addNotationalListeners();
        addListenerFilter("PrimaryView", this, getPrimaryView()); //$NON-NLS-1$
    }

    /**
     * Removes the notational listeners.
     *
     * @generated
     */
    @Override
    protected void removeNotationalListeners() {
        super.removeNotationalListeners();
        removeListenerFilter("PrimaryView"); //$NON-NLS-1$
    }

    /**
     * Handle notification event.
     *
     * @param event the event
     * @generated not
     */
    @Override
    protected void handleNotificationEvent(Notification event) {
        Object feature = event.getFeature();
        if (NotationPackage.eINSTANCE.getFontStyle_FontColor().equals(feature)) {
            Integer c = (Integer) event.getNewValue();
            setFontColor(DiagramColorRegistry.getInstance().getColor(c));
        } else if (NotationPackage.eINSTANCE.getFontStyle_Underline().equals(feature)) {
            refreshUnderline();
        } else if (NotationPackage.eINSTANCE.getFontStyle_StrikeThrough().equals(feature)) {
            refreshStrikeThrough();
        } else if (NotationPackage.eINSTANCE.getFontStyle_FontHeight().equals(feature)
                || NotationPackage.eINSTANCE.getFontStyle_FontName().equals(feature)
                || NotationPackage.eINSTANCE.getFontStyle_Bold().equals(feature)
                || NotationPackage.eINSTANCE.getFontStyle_Italic().equals(feature)) {
            refreshFont();
        } else {
            refreshLabel();
        }
        super.handleNotificationEvent(event);
    }

    /**
     * Creates the figure.
     *
     * @return the i figure
     * @generated
     */
    @Override
    protected IFigure createFigure() {
        IFigure label = createFigurePrim();
        defaultText = getLabelTextHelper(label);
        return label;
    }

    /**
     * Creates the figure prim.
     *
     * @return the i figure
     * @generated
     */
    protected IFigure createFigurePrim() {
        return new WrappingLabel();
    }
}
