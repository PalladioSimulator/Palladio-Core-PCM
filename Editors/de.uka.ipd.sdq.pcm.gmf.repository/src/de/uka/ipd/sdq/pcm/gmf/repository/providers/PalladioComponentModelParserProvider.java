/*
 *Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.providers;

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
import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.BasicComponentEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.CompleteComponentTypeEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.CompositeComponentEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.EventGroupEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.EventTypeEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.InfrastructureInterfaceEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.InfrastructureSignatureEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.OperationInterfaceEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.OperationSignatureEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.PassiveResourceEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ProvidesComponentTypeEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ResourceDemandingSEFFEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.SubSystemEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.VariableCharacterisationEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.parsers.MessageFormatParser;
import de.uka.ipd.sdq.pcm.gmf.repository.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;

/**
 * @generated
 */
public class PalladioComponentModelParserProvider extends AbstractProvider implements IParserProvider {

    /**
     * @generated
     */
    private IParser operationInterfaceEntityName_5108Parser;

    /**
     * @generated
     */
    private IParser getOperationInterfaceEntityName_5108Parser() {
        if (operationInterfaceEntityName_5108Parser == null) {
            EAttribute[] features = new EAttribute[] { EntityPackage.eINSTANCE.getNamedElement_EntityName() };
            MessageFormatParser parser = new MessageFormatParser(features);
            operationInterfaceEntityName_5108Parser = parser;
        }
        return operationInterfaceEntityName_5108Parser;
    }

    /**
     * @generated
     */
    private IParser eventGroupEntityName_5109Parser;

    /**
     * @generated
     */
    private IParser getEventGroupEntityName_5109Parser() {
        if (eventGroupEntityName_5109Parser == null) {
            EAttribute[] features = new EAttribute[] { EntityPackage.eINSTANCE.getNamedElement_EntityName() };
            MessageFormatParser parser = new MessageFormatParser(features);
            eventGroupEntityName_5109Parser = parser;
        }
        return eventGroupEntityName_5109Parser;
    }

    /**
     * @generated
     */
    private IParser basicComponentEntityName_5102Parser;

    /**
     * @generated
     */
    private IParser getBasicComponentEntityName_5102Parser() {
        if (basicComponentEntityName_5102Parser == null) {
            EAttribute[] features = new EAttribute[] { EntityPackage.eINSTANCE.getNamedElement_EntityName() };
            MessageFormatParser parser = new MessageFormatParser(features);
            basicComponentEntityName_5102Parser = parser;
        }
        return basicComponentEntityName_5102Parser;
    }

    /**
     * @generated
     */
    private IParser compositeComponentEntityName_5103Parser;

    /**
     * @generated
     */
    private IParser getCompositeComponentEntityName_5103Parser() {
        if (compositeComponentEntityName_5103Parser == null) {
            EAttribute[] features = new EAttribute[] { EntityPackage.eINSTANCE.getNamedElement_EntityName() };
            MessageFormatParser parser = new MessageFormatParser(features);
            compositeComponentEntityName_5103Parser = parser;
        }
        return compositeComponentEntityName_5103Parser;
    }

    /**
     * @generated
     */
    private IParser completeComponentTypeEntityName_5104Parser;

    /**
     * @generated
     */
    private IParser getCompleteComponentTypeEntityName_5104Parser() {
        if (completeComponentTypeEntityName_5104Parser == null) {
            EAttribute[] features = new EAttribute[] { EntityPackage.eINSTANCE.getNamedElement_EntityName() };
            MessageFormatParser parser = new MessageFormatParser(features);
            completeComponentTypeEntityName_5104Parser = parser;
        }
        return completeComponentTypeEntityName_5104Parser;
    }

    /**
     * @generated
     */
    private IParser providesComponentTypeEntityName_5105Parser;

    /**
     * @generated
     */
    private IParser getProvidesComponentTypeEntityName_5105Parser() {
        if (providesComponentTypeEntityName_5105Parser == null) {
            EAttribute[] features = new EAttribute[] { EntityPackage.eINSTANCE.getNamedElement_EntityName() };
            MessageFormatParser parser = new MessageFormatParser(features);
            providesComponentTypeEntityName_5105Parser = parser;
        }
        return providesComponentTypeEntityName_5105Parser;
    }

    /**
     * @generated
     */
    private IParser subSystemEntityName_5107Parser;

    /**
     * @generated
     */
    private IParser getSubSystemEntityName_5107Parser() {
        if (subSystemEntityName_5107Parser == null) {
            EAttribute[] features = new EAttribute[] { EntityPackage.eINSTANCE.getNamedElement_EntityName() };
            MessageFormatParser parser = new MessageFormatParser(features);
            subSystemEntityName_5107Parser = parser;
        }
        return subSystemEntityName_5107Parser;
    }

    /**
     * @generated
     */
    private IParser infrastructureInterfaceEntityName_5110Parser;

    /**
     * @generated
     */
    private IParser getInfrastructureInterfaceEntityName_5110Parser() {
        if (infrastructureInterfaceEntityName_5110Parser == null) {
            EAttribute[] features = new EAttribute[] { EntityPackage.eINSTANCE.getNamedElement_EntityName() };
            MessageFormatParser parser = new MessageFormatParser(features);
            infrastructureInterfaceEntityName_5110Parser = parser;
        }
        return infrastructureInterfaceEntityName_5110Parser;
    }

    /**
     * @generated
     */
    private IParser operationSignature_3106Parser;

    /**
     * @generated
     */
    private IParser getOperationSignature_3106Parser() {
        if (operationSignature_3106Parser == null) {
            EAttribute[] features = new EAttribute[] { EntityPackage.eINSTANCE.getNamedElement_EntityName() };
            MessageFormatParser parser = new MessageFormatParser(features);
            operationSignature_3106Parser = parser;
        }
        return operationSignature_3106Parser;
    }

    /**
     * @generated
     */
    private IParser eventType_3107Parser;

    /**
     * @generated
     */
    private IParser getEventType_3107Parser() {
        if (eventType_3107Parser == null) {
            EAttribute[] features = new EAttribute[] { EntityPackage.eINSTANCE.getNamedElement_EntityName() };
            MessageFormatParser parser = new MessageFormatParser(features);
            eventType_3107Parser = parser;
        }
        return eventType_3107Parser;
    }

    /**
     * @generated
     */
    private IParser resourceDemandingSEFF_3102Parser;

    /**
     * @generated
     */
    private IParser getResourceDemandingSEFF_3102Parser() {
        if (resourceDemandingSEFF_3102Parser == null) {
            EAttribute[] features = new EAttribute[] { SeffPackage.eINSTANCE.getServiceEffectSpecification_SeffTypeID() };
            MessageFormatParser parser = new MessageFormatParser(features);
            resourceDemandingSEFF_3102Parser = parser;
        }
        return resourceDemandingSEFF_3102Parser;
    }

    /**
     * @generated
     */
    private IParser passiveResource_3103Parser;

    /**
     * @generated
     */
    private IParser getPassiveResource_3103Parser() {
        if (passiveResource_3103Parser == null) {
            EAttribute[] features = new EAttribute[] { EntityPackage.eINSTANCE.getNamedElement_EntityName() };
            MessageFormatParser parser = new MessageFormatParser(features);
            passiveResource_3103Parser = parser;
        }
        return passiveResource_3103Parser;
    }

    /**
     * @generated
     */
    private IParser variableCharacterisation_3105Parser;

    /**
     * @generated
     */
    private IParser getVariableCharacterisation_3105Parser() {
        if (variableCharacterisation_3105Parser == null) {
            EAttribute editableFeature = ParameterPackage.eINSTANCE.getVariableCharacterisation_Type();
            EnumParser parser = new EnumParser(editableFeature);
            variableCharacterisation_3105Parser = parser;
        }
        return variableCharacterisation_3105Parser;
    }

    /**
     * @generated
     */
    private IParser infrastructureSignature_3108Parser;

    /**
     * @generated
     */
    private IParser getInfrastructureSignature_3108Parser() {
        if (infrastructureSignature_3108Parser == null) {
            EAttribute[] features = new EAttribute[] { EntityPackage.eINSTANCE.getNamedElement_EntityName() };
            MessageFormatParser parser = new MessageFormatParser(features);
            infrastructureSignature_3108Parser = parser;
        }
        return infrastructureSignature_3108Parser;
    }

    /**
     * @generated
     */
    protected IParser getParser(int visualID) {
        switch (visualID) {
        case OperationInterfaceEntityNameEditPart.VISUAL_ID:
            return getOperationInterfaceEntityName_5108Parser();
        case EventGroupEntityNameEditPart.VISUAL_ID:
            return getEventGroupEntityName_5109Parser();
        case BasicComponentEntityNameEditPart.VISUAL_ID:
            return getBasicComponentEntityName_5102Parser();
        case CompositeComponentEntityNameEditPart.VISUAL_ID:
            return getCompositeComponentEntityName_5103Parser();
        case CompleteComponentTypeEntityNameEditPart.VISUAL_ID:
            return getCompleteComponentTypeEntityName_5104Parser();
        case ProvidesComponentTypeEntityNameEditPart.VISUAL_ID:
            return getProvidesComponentTypeEntityName_5105Parser();
        case SubSystemEntityNameEditPart.VISUAL_ID:
            return getSubSystemEntityName_5107Parser();
        case InfrastructureInterfaceEntityNameEditPart.VISUAL_ID:
            return getInfrastructureInterfaceEntityName_5110Parser();
        case OperationSignatureEditPart.VISUAL_ID:
            return getOperationSignature_3106Parser();
        case EventTypeEditPart.VISUAL_ID:
            return getEventType_3107Parser();
        case ResourceDemandingSEFFEditPart.VISUAL_ID:
            return getResourceDemandingSEFF_3102Parser();
        case PassiveResourceEditPart.VISUAL_ID:
            return getPassiveResource_3103Parser();

        case VariableCharacterisationEditPart.VISUAL_ID:
            return getVariableCharacterisation_3105Parser();
        case InfrastructureSignatureEditPart.VISUAL_ID:
            return getInfrastructureSignature_3108Parser();
        }
        return null;
    }

    /**
     * Utility method that consults ParserService
     * 
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

        private final IElementType elementType;

        public HintAdapter(IElementType type, EObject object, String parserHint) {
            super(object, parserHint);
            assert type != null;
            elementType = type;
        }

        public Object getAdapter(Class adapter) {
            if (IElementType.class.equals(adapter)) {
                return elementType;
            }
            return super.getAdapter(adapter);
        }
    }
}
