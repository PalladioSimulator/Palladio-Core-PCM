/*
 * Copyright 2009, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.resource.providers;

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
import org.palladiosimulator.pcm.core.entity.EntityPackage;
import org.palladiosimulator.pcm.resourceenvironment.ResourceenvironmentPackage;

import de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.CommunicationLinkResourceSpecificationFailureProbabilityEditPart;
import de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.LinkingResourceEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.ProcessingResourceSpecificationMTTFEditPart;
import de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.ProcessingResourceSpecificationMTTREditPart;
import de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.ProcessingResourceSpecificationNumberOfReplicasEditPart;
import de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.ResourceContainerEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.ResourceContainerEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.resource.parsers.MessageFormatParser;
import de.uka.ipd.sdq.pcm.gmf.resource.part.PalladioComponentModelVisualIDRegistry;

/**
 * @generated
 */
public class PalladioComponentModelParserProvider extends AbstractProvider implements IParserProvider {

    /**
     * @generated
     */
    private IParser resourceContainerEntityName_5019Parser;

    /**
     * @generated
     */
    private IParser getResourceContainerEntityName_5019Parser() {
        if (resourceContainerEntityName_5019Parser == null) {
            EAttribute[] features = new EAttribute[] { EntityPackage.eINSTANCE.getNamedElement_EntityName() };
            MessageFormatParser parser = new MessageFormatParser(features);
            resourceContainerEntityName_5019Parser = parser;
        }
        return resourceContainerEntityName_5019Parser;
    }

    /**
     * @generated
     */
    private IParser linkingResourceEntityName_5024Parser;

    /**
     * @generated
     */
    private IParser getLinkingResourceEntityName_5024Parser() {
        if (linkingResourceEntityName_5024Parser == null) {
            EAttribute[] features = new EAttribute[] { EntityPackage.eINSTANCE.getNamedElement_EntityName() };
            MessageFormatParser parser = new MessageFormatParser(features);
            linkingResourceEntityName_5024Parser = parser;
        }
        return linkingResourceEntityName_5024Parser;
    }

    /**
     * @generated
     */
    private IParser processingResourceSpecificationMTTF_5013Parser;

    /**
     * @generated
     */
    private IParser getProcessingResourceSpecificationMTTF_5013Parser() {
        if (processingResourceSpecificationMTTF_5013Parser == null) {
            EAttribute[] features = new EAttribute[] { ResourceenvironmentPackage.eINSTANCE
                    .getProcessingResourceSpecification_MTTF() };
            MessageFormatParser parser = new MessageFormatParser(features);
            parser.setViewPattern("MTTF: {0,number,#.#}"); //$NON-NLS-1$
            parser.setEditorPattern("MTTF: {0,number,#.#}"); //$NON-NLS-1$
            parser.setEditPattern("MTTF: {0,number,#.#}"); //$NON-NLS-1$
            processingResourceSpecificationMTTF_5013Parser = parser;
        }
        return processingResourceSpecificationMTTF_5013Parser;
    }

    /**
     * @generated
     */
    private IParser processingResourceSpecificationMTTR_5014Parser;

    /**
     * @generated
     */
    private IParser getProcessingResourceSpecificationMTTR_5014Parser() {
        if (processingResourceSpecificationMTTR_5014Parser == null) {
            EAttribute[] features = new EAttribute[] { ResourceenvironmentPackage.eINSTANCE
                    .getProcessingResourceSpecification_MTTR() };
            MessageFormatParser parser = new MessageFormatParser(features);
            parser.setViewPattern("MTTR: {0,number,#.#}"); //$NON-NLS-1$
            parser.setEditorPattern("MTTR: {0,number,#.#}"); //$NON-NLS-1$
            parser.setEditPattern("MTTR: {0,number,#.#}"); //$NON-NLS-1$
            processingResourceSpecificationMTTR_5014Parser = parser;
        }
        return processingResourceSpecificationMTTR_5014Parser;
    }

    /**
     * @generated
     */
    private IParser processingResourceSpecificationNumberOfReplicas_5016Parser;

    /**
     * @generated
     */
    private IParser getProcessingResourceSpecificationNumberOfReplicas_5016Parser() {
        if (processingResourceSpecificationNumberOfReplicas_5016Parser == null) {
            EAttribute[] features = new EAttribute[] { ResourceenvironmentPackage.eINSTANCE
                    .getProcessingResourceSpecification_NumberOfReplicas() };
            MessageFormatParser parser = new MessageFormatParser(features);
            parser.setViewPattern("Number of Replicas: {0}"); //$NON-NLS-1$
            parser.setEditorPattern("Number of Replicas: {0}"); //$NON-NLS-1$
            parser.setEditPattern("Number of Replicas: {0}"); //$NON-NLS-1$
            processingResourceSpecificationNumberOfReplicas_5016Parser = parser;
        }
        return processingResourceSpecificationNumberOfReplicas_5016Parser;
    }

    /**
     * @generated
     */
    private IParser resourceContainerEntityName_5025Parser;

    /**
     * @generated
     */
    private IParser getResourceContainerEntityName_5025Parser() {
        if (resourceContainerEntityName_5025Parser == null) {
            EAttribute[] features = new EAttribute[] { EntityPackage.eINSTANCE.getNamedElement_EntityName() };
            MessageFormatParser parser = new MessageFormatParser(features);
            resourceContainerEntityName_5025Parser = parser;
        }
        return resourceContainerEntityName_5025Parser;
    }

    /**
     * @generated
     */
    private IParser communicationLinkResourceSpecificationFailureProbability_5020Parser;

    /**
     * @generated
     */
    private IParser getCommunicationLinkResourceSpecificationFailureProbability_5020Parser() {
        if (communicationLinkResourceSpecificationFailureProbability_5020Parser == null) {
            EAttribute[] features = new EAttribute[] { ResourceenvironmentPackage.eINSTANCE
                    .getCommunicationLinkResourceSpecification_FailureProbability() };
            MessageFormatParser parser = new MessageFormatParser(features);
            parser.setViewPattern("{0}"); //$NON-NLS-1$
            parser.setEditorPattern("{0}"); //$NON-NLS-1$
            parser.setEditPattern("{0}"); //$NON-NLS-1$
            communicationLinkResourceSpecificationFailureProbability_5020Parser = parser;
        }
        return communicationLinkResourceSpecificationFailureProbability_5020Parser;
    }

    /**
     * @generated
     */
    protected IParser getParser(int visualID) {
        switch (visualID) {
        case ResourceContainerEntityNameEditPart.VISUAL_ID:
            return getResourceContainerEntityName_5019Parser();
        case LinkingResourceEntityNameEditPart.VISUAL_ID:
            return getLinkingResourceEntityName_5024Parser();
        case ProcessingResourceSpecificationMTTFEditPart.VISUAL_ID:
            return getProcessingResourceSpecificationMTTF_5013Parser();
        case ProcessingResourceSpecificationMTTREditPart.VISUAL_ID:
            return getProcessingResourceSpecificationMTTR_5014Parser();
        case ProcessingResourceSpecificationNumberOfReplicasEditPart.VISUAL_ID:
            return getProcessingResourceSpecificationNumberOfReplicas_5016Parser();
        case ResourceContainerEntityName2EditPart.VISUAL_ID:
            return getResourceContainerEntityName_5025Parser();
        case CommunicationLinkResourceSpecificationFailureProbabilityEditPart.VISUAL_ID:
            return getCommunicationLinkResourceSpecificationFailureProbability_5020Parser();
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

        /**
         * @generated
         */
        private final IElementType elementType;

        /**
         * @generated
         */
        public HintAdapter(IElementType type, EObject object, String parserHint) {
            super(object, parserHint);
            assert type != null;
            elementType = type;
        }

        /**
         * @generated
         */
        public Object getAdapter(Class adapter) {
            if (IElementType.class.equals(adapter)) {
                return elementType;
            }
            return super.getAdapter(adapter);
        }
    }

}
