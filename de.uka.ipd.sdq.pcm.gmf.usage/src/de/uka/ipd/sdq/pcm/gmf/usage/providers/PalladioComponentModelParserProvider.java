/*
 *Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.BranchTransitionBranchProbabilityEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ClosedWorkloadPopulationEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.DelayEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.UsageScenarioLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.VariableCharacterisationEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.parsers.MessageFormatParser;
import de.uka.ipd.sdq.pcm.gmf.usage.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;

/**
 * The Class PalladioComponentModelParserProvider.
 *
 * @generated
 */
public class PalladioComponentModelParserProvider extends AbstractProvider implements IParserProvider {

    /** The usage scenario entity name_5017 parser. @generated */
    private IParser usageScenarioEntityName_5017Parser;

    /**
     * Gets the usage scenario entity name_5017 parser.
     *
     * @return the usage scenario entity name_5017 parser
     * @generated
     */
    private IParser getUsageScenarioEntityName_5017Parser() {
        if (usageScenarioEntityName_5017Parser == null) {
            EAttribute[] features = new EAttribute[] { EntityPackage.eINSTANCE.getNamedElement_EntityName() };
            MessageFormatParser parser = new MessageFormatParser(features);
            usageScenarioEntityName_5017Parser = parser;
        }
        return usageScenarioEntityName_5017Parser;
    }

    /** The variable characterisation_3013 parser. @generated */
    private IParser variableCharacterisation_3013Parser;

    /**
     * Gets the variable characterisation_3013 parser.
     *
     * @return the variable characterisation_3013 parser
     * @generated
     */
    private IParser getVariableCharacterisation_3013Parser() {
        if (variableCharacterisation_3013Parser == null) {
            EAttribute[] features = new EAttribute[] { ParameterPackage.eINSTANCE.getVariableCharacterisation_Type() };
            MessageFormatParser parser = new MessageFormatParser(features);
            parser.setViewPattern("{0} = {1}"); //$NON-NLS-1$
            parser.setEditorPattern("{0} = {1}"); //$NON-NLS-1$
            parser.setEditPattern("{0} = {1}"); //$NON-NLS-1$
            variableCharacterisation_3013Parser = parser;
        }
        return variableCharacterisation_3013Parser;
    }

    /** The branch transition branch probability_5007 parser. @generated */
    private IParser branchTransitionBranchProbability_5007Parser;

    /**
     * Gets the branch transition branch probability_5007 parser.
     *
     * @return the branch transition branch probability_5007 parser
     * @generated
     */
    private IParser getBranchTransitionBranchProbability_5007Parser() {
        if (branchTransitionBranchProbability_5007Parser == null) {
            EAttribute[] features = new EAttribute[] { UsagemodelPackage.eINSTANCE
                    .getBranchTransition_BranchProbability() };
            MessageFormatParser parser = new MessageFormatParser(features);
            branchTransitionBranchProbability_5007Parser = parser;
        }
        return branchTransitionBranchProbability_5007Parser;
    }

    /** The delay entity name_5018 parser. @generated */
    private IParser delayEntityName_5018Parser;

    /**
     * Gets the delay entity name_5018 parser.
     *
     * @return the delay entity name_5018 parser
     * @generated
     */
    private IParser getDelayEntityName_5018Parser() {
        if (delayEntityName_5018Parser == null) {
            EAttribute[] features = new EAttribute[] { EntityPackage.eINSTANCE.getNamedElement_EntityName() };
            MessageFormatParser parser = new MessageFormatParser(features);
            delayEntityName_5018Parser = parser;
        }
        return delayEntityName_5018Parser;
    }

    /** The closed workload population_5013 parser. @generated */
    private IParser closedWorkloadPopulation_5013Parser;

    /**
     * Gets the closed workload population_5013 parser.
     *
     * @return the closed workload population_5013 parser
     * @generated
     */
    private IParser getClosedWorkloadPopulation_5013Parser() {
        if (closedWorkloadPopulation_5013Parser == null) {
            EAttribute[] features = new EAttribute[] { UsagemodelPackage.eINSTANCE.getClosedWorkload_Population() };
            MessageFormatParser parser = new MessageFormatParser(features);
            parser.setViewPattern("Population: {0}"); //$NON-NLS-1$
            parser.setEditorPattern("{0}"); //$NON-NLS-1$
            parser.setEditPattern("{0}"); //$NON-NLS-1$
            closedWorkloadPopulation_5013Parser = parser;
        }
        return closedWorkloadPopulation_5013Parser;
    }

    /**
     * Gets the parser.
     *
     * @param visualID the visual id
     * @return the parser
     * @generated
     */
    protected IParser getParser(int visualID) {
        switch (visualID) {
        case UsageScenarioLabelEditPart.VISUAL_ID:
            return getUsageScenarioEntityName_5017Parser();
        case VariableCharacterisationEditPart.VISUAL_ID:
            return getVariableCharacterisation_3013Parser();
        case BranchTransitionBranchProbabilityEditPart.VISUAL_ID:
            return getBranchTransitionBranchProbability_5007Parser();
        case DelayEntityNameEditPart.VISUAL_ID:
            return getDelayEntityName_5018Parser();
        case ClosedWorkloadPopulationEditPart.VISUAL_ID:
            return getClosedWorkloadPopulation_5013Parser();
        }
        return null;
    }

    /**
     * Utility method that consults ParserService.
     *
     * @param type the type
     * @param object the object
     * @param parserHint the parser hint
     * @return the parser
     * @generated
     */
    public static IParser getParser(IElementType type, EObject object, String parserHint) {
        return ParserService.getInstance().getParser(new HintAdapter(type, object, parserHint));
    }

    /**
     * Gets the parser.
     *
     * @param hint the hint
     * @return the parser
     * @generated
     */
    public IParser getParser(IAdaptable hint) {
        String vid = (String) hint.getAdapter(String.class);
        if (vid != null) {
            return getParser(PalladioComponentModelVisualIDRegistry.getVisualID(vid));
        }
        View view = (View) hint.getAdapter(View.class);
        if (view != null) {
            return getParser(PalladioComponentModelVisualIDRegistry.getVisualID(view));
        }
        return null;
    }

    /**
     * Provides.
     *
     * @param operation the operation
     * @return true, if successful
     * @generated
     */
    public boolean provides(IOperation operation) {
        if (operation instanceof GetParserOperation) {
            IAdaptable hint = ((GetParserOperation) operation).getHint();
            if (PalladioComponentModelElementTypes.getElement(hint) == null) {
                return false;
            }
            return getParser(hint) != null;
        }
        return false;
    }

    /**
     * The Class HintAdapter.
     *
     * @generated
     */
    private static class HintAdapter extends ParserHintAdapter {

        /** The element type. */
        private final IElementType elementType;

        /**
         * Instantiates a new hint adapter.
         *
         * @param type the type
         * @param object the object
         * @param parserHint the parser hint
         */
        public HintAdapter(IElementType type, EObject object, String parserHint) {
            super(object, parserHint);
            assert type != null;
            elementType = type;
        }

        /**
         * Gets the adapter.
         *
         * @param adapter the adapter
         * @return the adapter
         * @see org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter#getAdapter(java.lang.Class)
         */
        public Object getAdapter(Class adapter) {
            if (IElementType.class.equals(adapter)) {
                return elementType;
            }
            return super.getAdapter(adapter);
        }
    }
}
