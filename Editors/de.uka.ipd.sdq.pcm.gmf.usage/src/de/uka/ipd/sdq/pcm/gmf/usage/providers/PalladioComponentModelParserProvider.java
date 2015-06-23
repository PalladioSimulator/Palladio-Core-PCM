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
import org.eclipse.gmf.tooling.runtime.parsers.EnumParser;

import org.palladiosimulator.pcm.core.entity.EntityPackage;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.BranchTransitionBranchProbabilityEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ClosedWorkloadPopulationEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.DelayEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.UsageScenarioLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.VariableCharacterisationEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.parsers.MessageFormatParser;
import de.uka.ipd.sdq.pcm.gmf.usage.part.PalladioComponentModelVisualIDRegistry;
import org.palladiosimulator.pcm.parameter.ParameterPackage;
import org.palladiosimulator.pcm.usagemodel.UsagemodelPackage;

/**
 * @generated
 */
public class PalladioComponentModelParserProvider extends AbstractProvider implements IParserProvider {

    /**
     * @generated
     */
    private IParser usageScenarioEntityName_5017Parser;

    /**
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

    /**
     * @generated
     */
    private IParser variableCharacterisation_3013Parser;

    /**
     * @generated
     */
    private IParser getVariableCharacterisation_3013Parser() {
        if (variableCharacterisation_3013Parser == null) {
            EAttribute editableFeature = ParameterPackage.eINSTANCE.getVariableCharacterisation_Type();
            EnumParser parser = new EnumParser(editableFeature);
            variableCharacterisation_3013Parser = parser;
        }
        return variableCharacterisation_3013Parser;
    }

    /**
     * @generated
     */
    private IParser branchTransitionBranchProbability_5007Parser;

    /**
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

    /**
     * @generated
     */
    private IParser delayEntityName_5018Parser;

    /**
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

    /**
     * @generated
     */
    private IParser closedWorkloadPopulation_5013Parser;

    /**
     * @generated
     */
    private IParser getClosedWorkloadPopulation_5013Parser() {
        if (closedWorkloadPopulation_5013Parser == null) {
            EAttribute[] features = new EAttribute[] { UsagemodelPackage.eINSTANCE.getClosedWorkload_Population() };
            MessageFormatParser parser = new MessageFormatParser(features);
            parser.setViewPattern("Population: {0}"); //$NON-NLS-1$
            parser.setEditorPattern("Population: {0}"); //$NON-NLS-1$
            parser.setEditPattern("{0}"); //$NON-NLS-1$
            closedWorkloadPopulation_5013Parser = parser;
        }
        return closedWorkloadPopulation_5013Parser;
    }

    /**
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
     * @generated
     */
    public static IParser getParser(IElementType type, EObject object, String parserHint) {
        return ParserService.getInstance().getParser(new HintAdapter(type, object, parserHint));
    }

    /**
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
     * @generated
     */
    private static class HintAdapter extends ParserHintAdapter {

        /** The element type. */
        private final IElementType elementType;

        /**
         * Instantiates a new hint adapter.
         * 
         * @param type
         *            the type
         * @param object
         *            the object
         * @param parserHint
         *            the parser hint
         */
        public HintAdapter(IElementType type, EObject object, String parserHint) {
            super(object, parserHint);
            assert type != null;
            elementType = type;
        }

        /**
         * Gets the adapter.
         * 
         * @param adapter
         *            the adapter
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
