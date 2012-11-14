/*
 *Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.providers;

import java.text.FieldPosition;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

import de.uka.ipd.sdq.pcm.gmf.usage.part.PalladioComponentModelUsageDiagramEditorPlugin;

/**
 * The Class PalladioComponentModelStructuralFeaturesParser.
 *
 * @generated
 */
public class PalladioComponentModelStructuralFeaturesParser extends PalladioComponentModelAbstractParser {

    /** The features. @generated */
    private List features;

    /**
     * Instantiates a new palladio component model structural features parser.
     *
     * @param features the features
     * @generated
     */
    public PalladioComponentModelStructuralFeaturesParser(List features) {
        this.features = features;
    }

    /**
     * Gets the string by pattern.
     *
     * @param adapter the adapter
     * @param flags the flags
     * @param pattern the pattern
     * @param processor the processor
     * @return the string by pattern
     * @generated
     */
    protected String getStringByPattern(IAdaptable adapter, int flags, String pattern, MessageFormat processor) {
        EObject element = (EObject) adapter.getAdapter(EObject.class);
        List values = new ArrayList(features.size());
        for (Iterator it = features.iterator(); it.hasNext();) {
            EStructuralFeature feature = (EStructuralFeature) it.next();
            Object value = element.eGet(feature);
            value = getValidValue(feature, value);
            values.add(value);
        }
        return processor.format(values.toArray(new Object[values.size()]), new StringBuffer(), new FieldPosition(0))
                .toString();
    }

    /**
     * Validate values.
     *
     * @param values the values
     * @return the i parser edit status
     * @generated
     */
    protected IParserEditStatus validateValues(Object[] values) {
        if (values.length != features.size()) {
            return ParserEditStatus.UNEDITABLE_STATUS;
        }
        for (int i = 0; i < values.length; i++) {
            Object value = getValidNewValue((EStructuralFeature) features.get(i), values[i]);
            if (value instanceof InvalidValue) {
                return new ParserEditStatus(PalladioComponentModelUsageDiagramEditorPlugin.ID,
                        IParserEditStatus.UNEDITABLE, value.toString());
            }
        }
        return ParserEditStatus.EDITABLE_STATUS;
    }

    /**
     * Gets the parses the command.
     *
     * @param adapter the adapter
     * @param values the values
     * @return the parses the command
     * @generated
     */
    public ICommand getParseCommand(IAdaptable adapter, Object[] values) {
        EObject element = (EObject) adapter.getAdapter(EObject.class);
        if (element == null) {
            return UnexecutableCommand.INSTANCE;
        }
        TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(element);
        if (editingDomain == null) {
            return UnexecutableCommand.INSTANCE;
        }
        CompositeTransactionalCommand command = new CompositeTransactionalCommand(editingDomain, "Set Values"); //$NON-NLS-1$
        for (int i = 0; i < values.length; i++) {
            EStructuralFeature feature = (EStructuralFeature) features.get(i);
            command.compose(getModificationCommand(element, feature, values[i]));
        }
        return command;
    }

    /**
     * Checks if is affecting event.
     *
     * @param event the event
     * @param flags the flags
     * @return true, if is affecting event
     * @generated
     */
    public boolean isAffectingEvent(Object event, int flags) {
        if (event instanceof Notification) {
            Object feature = ((Notification) event).getFeature();
            if (features.contains(feature)) {
                return true;
            }
        }
        return false;
    }
}
