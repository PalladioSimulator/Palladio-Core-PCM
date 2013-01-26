/*
 *Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.providers;

import java.text.FieldPosition;
import java.text.MessageFormat;
import java.util.Collections;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;

import de.uka.ipd.sdq.pcm.gmf.composite.part.PalladioComponentModelComposedStructureDiagramEditorPlugin;

/**
 * The Class PalladioComponentModelStructuralFeatureParser.
 * 
 * @generated
 */
public class PalladioComponentModelStructuralFeatureParser extends PalladioComponentModelAbstractParser {

    /** The Constant DEFAULT_PROCESSOR. @generated */
    public static final MessageFormat DEFAULT_PROCESSOR = new MessageFormat("{0}"); //$NON-NLS-1$

    /** The feature. @generated */
    private EStructuralFeature feature;

    /**
     * Instantiates a new palladio component model structural feature parser.
     * 
     * @param feature
     *            the feature
     * @generated
     */
    public PalladioComponentModelStructuralFeatureParser(EStructuralFeature feature) {
        this.feature = feature;
    }

    /**
     * Gets the view processor.
     * 
     * @return the view processor
     * @generated
     */
    protected MessageFormat getViewProcessor() {
        MessageFormat processor = super.getViewProcessor();
        return processor == null ? DEFAULT_PROCESSOR : processor;
    }

    /**
     * Gets the edits the processor.
     * 
     * @return the edits the processor
     * @generated
     */
    protected MessageFormat getEditProcessor() {
        MessageFormat processor = super.getEditProcessor();
        return processor == null ? DEFAULT_PROCESSOR : processor;
    }

    /**
     * Gets the domain element.
     * 
     * @param element
     *            the element
     * @return the domain element
     * @generated
     */
    protected EObject getDomainElement(EObject element) {
        return element;
    }

    /**
     * Gets the string by pattern.
     * 
     * @param adapter
     *            the adapter
     * @param flags
     *            the flags
     * @param pattern
     *            the pattern
     * @param processor
     *            the processor
     * @return the string by pattern
     * @generated
     */
    protected String getStringByPattern(IAdaptable adapter, int flags, String pattern, MessageFormat processor) {
        EObject element = (EObject) adapter.getAdapter(EObject.class);
        element = getDomainElement(element);
        return getStringByPattern(element, feature, processor);
    }

    /**
     * Gets the string by pattern.
     * 
     * @param element
     *            the element
     * @param feature
     *            the feature
     * @param processor
     *            the processor
     * @return the string by pattern
     * @generated
     */
    protected String getStringByPattern(EObject element, EStructuralFeature feature, MessageFormat processor) {
        Object value = element == null ? null : element.eGet(feature);
        value = getValidValue(feature, value);
        return processor.format(new Object[] { value }, new StringBuffer(), new FieldPosition(0)).toString();
    }

    /**
     * Validate values.
     * 
     * @param values
     *            the values
     * @return the i parser edit status
     * @generated
     */
    protected IParserEditStatus validateValues(Object[] values) {
        if (values.length > 1) {
            return ParserEditStatus.UNEDITABLE_STATUS;
        }
        Object value = values.length == 1 ? values[0] : null;
        value = getValidNewValue(feature, value);
        if (value instanceof InvalidValue) {
            return new ParserEditStatus(PalladioComponentModelComposedStructureDiagramEditorPlugin.ID,
                    IParserEditStatus.UNEDITABLE, value.toString());
        }
        return ParserEditStatus.EDITABLE_STATUS;
    }

    /**
     * Gets the parses the command.
     * 
     * @param adapter
     *            the adapter
     * @param values
     *            the values
     * @return the parses the command
     * @generated
     */
    public ICommand getParseCommand(IAdaptable adapter, Object[] values) {
        EObject element = (EObject) adapter.getAdapter(EObject.class);
        element = getDomainElement(element);
        if (element == null) {
            return UnexecutableCommand.INSTANCE;
        }
        TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(element);
        if (editingDomain == null) {
            return UnexecutableCommand.INSTANCE;
        }
        Object value = values.length == 1 ? values[0] : null;
        ICommand command = getModificationCommand(element, feature, value);
        return new CompositeTransactionalCommand(editingDomain, command.getLabel(), Collections.singletonList(command));
    }

    /**
     * Checks if is affecting event.
     * 
     * @param event
     *            the event
     * @param flags
     *            the flags
     * @return true, if is affecting event
     * @generated
     */
    public boolean isAffectingEvent(Object event, int flags) {
        if (event instanceof Notification) {
            return isAffectingFeature(((Notification) event).getFeature());
        }
        return false;
    }

    /**
     * Checks if is affecting feature.
     * 
     * @param eventFeature
     *            the event feature
     * @return true, if is affecting feature
     * @generated
     */
    protected boolean isAffectingFeature(Object eventFeature) {
        return feature == eventFeature;
    }
}
