/*
 *Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.providers;

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
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.AssemblyContextEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ComposedProvidingRequiringEntityEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.EventChannelEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.InfrastructureProvidedRoleEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.InfrastructureRequiredRoleEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.OperationProvidedRoleEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.OperationProvidedRoleEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.OperationRequiredRoleEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.OperationRequiredRoleEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.SinkRoleEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.SourceRoleEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.parsers.MessageFormatParser;
import de.uka.ipd.sdq.pcm.gmf.composite.part.PalladioComponentModelVisualIDRegistry;

/**
 * @generated
 */
public class PalladioComponentModelParserProvider extends AbstractProvider implements IParserProvider {

    /**
     * @generated
     */
    private IParser composedProvidingRequiringEntityEntityName_5012Parser;

    /**
     * @generated
     */
    private IParser getComposedProvidingRequiringEntityEntityName_5012Parser() {
        if (composedProvidingRequiringEntityEntityName_5012Parser == null) {
            EAttribute[] features = new EAttribute[] { EntityPackage.eINSTANCE.getNamedElement_EntityName() };
            MessageFormatParser parser = new MessageFormatParser(features);
            composedProvidingRequiringEntityEntityName_5012Parser = parser;
        }
        return composedProvidingRequiringEntityEntityName_5012Parser;
    }

    /**
     * @generated
     */
    private IParser assemblyContextEntityName_5009Parser;

    /**
     * @generated
     */
    private IParser getAssemblyContextEntityName_5009Parser() {
        if (assemblyContextEntityName_5009Parser == null) {
            EAttribute[] features = new EAttribute[] { EntityPackage.eINSTANCE.getNamedElement_EntityName() };
            MessageFormatParser parser = new MessageFormatParser(features);
            assemblyContextEntityName_5009Parser = parser;
        }
        return assemblyContextEntityName_5009Parser;
    }

    /**
     * @generated
     */
    private IParser operationProvidedRoleEntityName_5007Parser;

    /**
     * @generated
     */
    private IParser getOperationProvidedRoleEntityName_5007Parser() {
        if (operationProvidedRoleEntityName_5007Parser == null) {
            EAttribute[] features = new EAttribute[] { EntityPackage.eINSTANCE.getNamedElement_EntityName() };
            MessageFormatParser parser = new MessageFormatParser(features);
            operationProvidedRoleEntityName_5007Parser = parser;
        }
        return operationProvidedRoleEntityName_5007Parser;
    }

    /**
     * @generated
     */
    private IParser operationRequiredRoleEntityName_5008Parser;

    /**
     * @generated
     */
    private IParser getOperationRequiredRoleEntityName_5008Parser() {
        if (operationRequiredRoleEntityName_5008Parser == null) {
            EAttribute[] features = new EAttribute[] { EntityPackage.eINSTANCE.getNamedElement_EntityName() };
            MessageFormatParser parser = new MessageFormatParser(features);
            operationRequiredRoleEntityName_5008Parser = parser;
        }
        return operationRequiredRoleEntityName_5008Parser;
    }

    /**
     * @generated
     */
    private IParser sourceRoleEntityName_5015Parser;

    /**
     * @generated
     */
    private IParser getSourceRoleEntityName_5015Parser() {
        if (sourceRoleEntityName_5015Parser == null) {
            EAttribute[] features = new EAttribute[] { EntityPackage.eINSTANCE.getNamedElement_EntityName() };
            MessageFormatParser parser = new MessageFormatParser(features);
            sourceRoleEntityName_5015Parser = parser;
        }
        return sourceRoleEntityName_5015Parser;
    }

    /**
     * @generated
     */
    private IParser sinkRoleEntityName_5016Parser;

    /**
     * @generated
     */
    private IParser getSinkRoleEntityName_5016Parser() {
        if (sinkRoleEntityName_5016Parser == null) {
            EAttribute[] features = new EAttribute[] { EntityPackage.eINSTANCE.getNamedElement_EntityName() };
            MessageFormatParser parser = new MessageFormatParser(features);
            sinkRoleEntityName_5016Parser = parser;
        }
        return sinkRoleEntityName_5016Parser;
    }

    /**
     * @generated
     */
    private IParser infrastructureProvidedRoleEntityName_5017Parser;

    /**
     * @generated
     */
    private IParser getInfrastructureProvidedRoleEntityName_5017Parser() {
        if (infrastructureProvidedRoleEntityName_5017Parser == null) {
            EAttribute[] features = new EAttribute[] { EntityPackage.eINSTANCE.getNamedElement_EntityName() };
            MessageFormatParser parser = new MessageFormatParser(features);
            infrastructureProvidedRoleEntityName_5017Parser = parser;
        }
        return infrastructureProvidedRoleEntityName_5017Parser;
    }

    /**
     * @generated
     */
    private IParser infrastructureRequiredRoleEntityName_5018Parser;

    /**
     * @generated
     */
    private IParser getInfrastructureRequiredRoleEntityName_5018Parser() {
        if (infrastructureRequiredRoleEntityName_5018Parser == null) {
            EAttribute[] features = new EAttribute[] { EntityPackage.eINSTANCE.getNamedElement_EntityName() };
            MessageFormatParser parser = new MessageFormatParser(features);
            infrastructureRequiredRoleEntityName_5018Parser = parser;
        }
        return infrastructureRequiredRoleEntityName_5018Parser;
    }

    /**
     * @generated
     */
    private IParser operationProvidedRoleEntityName_5013Parser;

    /**
     * @generated
     */
    private IParser getOperationProvidedRoleEntityName_5013Parser() {
        if (operationProvidedRoleEntityName_5013Parser == null) {
            EAttribute[] features = new EAttribute[] { EntityPackage.eINSTANCE.getNamedElement_EntityName() };
            MessageFormatParser parser = new MessageFormatParser(features);
            operationProvidedRoleEntityName_5013Parser = parser;
        }
        return operationProvidedRoleEntityName_5013Parser;
    }

    /**
     * @generated
     */
    private IParser operationRequiredRoleEntityName_5014Parser;

    /**
     * @generated
     */
    private IParser getOperationRequiredRoleEntityName_5014Parser() {
        if (operationRequiredRoleEntityName_5014Parser == null) {
            EAttribute[] features = new EAttribute[] { EntityPackage.eINSTANCE.getNamedElement_EntityName() };
            MessageFormatParser parser = new MessageFormatParser(features);
            operationRequiredRoleEntityName_5014Parser = parser;
        }
        return operationRequiredRoleEntityName_5014Parser;
    }

    /**
     * @generated
     */
    private IParser eventChannelEntityName_5019Parser;

    /**
     * @generated
     */
    private IParser getEventChannelEntityName_5019Parser() {
        if (eventChannelEntityName_5019Parser == null) {
            EAttribute[] features = new EAttribute[] { EntityPackage.eINSTANCE.getNamedElement_EntityName() };
            EAttribute[] editableFeatures = new EAttribute[] { EntityPackage.eINSTANCE.getNamedElement_EntityName() };
            MessageFormatParser parser = new MessageFormatParser(features, editableFeatures);
            eventChannelEntityName_5019Parser = parser;
        }
        return eventChannelEntityName_5019Parser;
    }

    /**
     * @generated
     */
    protected IParser getParser(int visualID) {
        switch (visualID) {
        case ComposedProvidingRequiringEntityEntityNameEditPart.VISUAL_ID:
            return getComposedProvidingRequiringEntityEntityName_5012Parser();
        case AssemblyContextEntityNameEditPart.VISUAL_ID:
            return getAssemblyContextEntityName_5009Parser();
        case OperationProvidedRoleEntityNameEditPart.VISUAL_ID:
            return getOperationProvidedRoleEntityName_5007Parser();
        case OperationRequiredRoleEntityNameEditPart.VISUAL_ID:
            return getOperationRequiredRoleEntityName_5008Parser();
        case SourceRoleEntityNameEditPart.VISUAL_ID:
            return getSourceRoleEntityName_5015Parser();
        case SinkRoleEntityNameEditPart.VISUAL_ID:
            return getSinkRoleEntityName_5016Parser();
        case InfrastructureProvidedRoleEntityNameEditPart.VISUAL_ID:
            return getInfrastructureProvidedRoleEntityName_5017Parser();
        case InfrastructureRequiredRoleEntityNameEditPart.VISUAL_ID:
            return getInfrastructureRequiredRoleEntityName_5018Parser();
        case OperationProvidedRoleEntityName2EditPart.VISUAL_ID:
            return getOperationProvidedRoleEntityName_5013Parser();
        case OperationRequiredRoleEntityName2EditPart.VISUAL_ID:
            return getOperationRequiredRoleEntityName_5014Parser();
        case EventChannelEntityNameEditPart.VISUAL_ID:
            return getEventChannelEntityName_5019Parser();
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
