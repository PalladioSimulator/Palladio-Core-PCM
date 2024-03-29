/*
 * generated by Xtext 2.24.0
 */
package org.palladiosimulator.pcm.stoex.ui.contentassist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.palladiosimulator.commons.stoex.services.StoexContext;
import org.palladiosimulator.commons.stoex.services.StoexContextProvider;
import org.palladiosimulator.pcm.parameter.CharacterisedVariable;
import org.palladiosimulator.pcm.repository.CollectionDataType;
import org.palladiosimulator.pcm.repository.CompositeDataType;
import org.palladiosimulator.pcm.repository.DataType;
import org.palladiosimulator.pcm.repository.EventType;
import org.palladiosimulator.pcm.repository.InnerDeclaration;
import org.palladiosimulator.pcm.repository.OperationSignature;
import org.palladiosimulator.pcm.repository.Parameter;
import org.palladiosimulator.pcm.repository.Signature;
import org.palladiosimulator.pcm.seff.AbstractAction;
import org.palladiosimulator.pcm.seff.ExternalCallAction;
import org.palladiosimulator.pcm.seff.ServiceEffectSpecification;
import org.palladiosimulator.pcm.usagemodel.AbstractUserAction;
import org.palladiosimulator.pcm.usagemodel.EntryLevelSystemCall;

import com.google.inject.Inject;

import de.uka.ipd.sdq.stoex.NamespaceReference;
import de.uka.ipd.sdq.stoex.RandomVariable;
import de.uka.ipd.sdq.stoex.VariableReference;

/**
 * See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#content-assist on how to
 * customize the content assistant.
 */
public class PCMStoexProposalProvider extends AbstractPCMStoexProposalProvider {

    @Inject
    private StoexContextProvider contextProvider;

    @Override
    public void completeCharacterisedVariable_Id_Variable(EObject model, Assignment assignment,
            ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        super.completeCharacterisedVariable_Id_Variable(model, assignment, context, acceptor);
        getReferenceableVariableCompletions(context.getResource(), context).forEach(acceptor::accept);
    }

    @Override
    public void complete_VariableReference(EObject model, RuleCall ruleCall, ContentAssistContext context,
            ICompletionProposalAcceptor acceptor) {
        super.complete_VariableReference(model, ruleCall, context, acceptor);
        if (lastKeywordWasStop(context)) {
            acceptor.accept(createCompletionProposal("BYTESIZE",
                    "BYTESIZE - Characterise the memory footprint in bytes", null, context));
            acceptor.accept(createCompletionProposal("NUMBER_OF_ELEMENTS",
                    "NUMBER_OF_ELEMENTS - Characterise the number of elements of a collection datatype", null,
                    context));
            acceptor.accept(createCompletionProposal("STRUCTURE",
                    "STRUCTURE - Characterise the structure of a datastructure", null, context));
            acceptor.accept(createCompletionProposal("VALUE", "VALUE - Characterise the actual value of a variable",
                    null, context));
            acceptor
                .accept(createCompletionProposal("TYPE", "TYPE - Characterise the type of a variable", null, context));
        }
    }

    @Override
    public void complete_NamespaceReference(EObject model, RuleCall ruleCall, ContentAssistContext context,
            ICompletionProposalAcceptor acceptor) {
        super.complete_NamespaceReference(model, ruleCall, context, acceptor);

        var currentNode = Optional.ofNullable(context.getCurrentNode());
        var currentSemantic = Optional.ofNullable(context.getCurrentNode())
            .map(INode::getSemanticElement);
        var currentCharacterisedVariable = cast(currentSemantic, CharacterisedVariable.class);
        var currentVariableReference = cast(currentSemantic, VariableReference.class);
        var previousText = currentNode.map(INode::getPreviousSibling)
            .map(INode::getText);
        var stoexContext = contextProvider.getContext(context.getResource());

        // get full qualified name of current reference
        List<String> referenceParts = new ArrayList<>();
        if (currentCharacterisedVariable.isPresent() && previousText.isPresent()) {
            // current text ends with dot -> use previousText
            referenceParts = Arrays.asList(previousText.get()
                .split("\\."));
        } else if (currentVariableReference.isPresent()) {
            // we are in the middle of building a namespace reference -> use semantic element
            EObject current = currentVariableReference.get();
            while (current.eContainer() instanceof NamespaceReference) {
                current = current.eContainer();
                referenceParts.add(((NamespaceReference) current).getReferenceName());
            }
            Collections.reverse(referenceParts);
        }

        // construct completions based on data type of reference
        if (!referenceParts.isEmpty()) {
            String parameterName = referenceParts.get(0);
            Collection<Parameter> parameters = findServiceParameters(stoexContext);
            Optional<Parameter> parameter = parameters.stream()
                .filter(p -> p.getParameterName()
                    .equals(parameterName))
                .findFirst();
            if (parameter.isEmpty()) {
                return;
            }

            DataType currentDataType = parameter.get()
                .getDataType__Parameter();
            for (int i = 1; i < referenceParts.size(); ++i) {
                String part = referenceParts.get(i);
                if (currentDataType instanceof CollectionDataType && "INNER".equals(part)) {
                    currentDataType = ((CollectionDataType) currentDataType).getInnerType_CollectionDataType();
                } else if (currentDataType instanceof CompositeDataType) {
                    currentDataType = ((CompositeDataType) currentDataType).getInnerDeclaration_CompositeDataType()
                        .stream()
                        .filter(d -> part.equals(d.getEntityName()))
                        .map(InnerDeclaration::getDatatype_InnerDeclaration)
                        .findFirst()
                        .orElse(null);
                } else {
                    currentDataType = null;
                }
            }

            if (currentDataType instanceof CollectionDataType) {
                acceptor.accept(createCompletionProposal("INNER", "INNER - inner data type", null, context));
            } else if (currentDataType instanceof CompositeDataType) {
                ((CompositeDataType) currentDataType).getInnerDeclaration_CompositeDataType()
                    .stream()
                    .map(InnerDeclaration::getEntityName)
                    .forEach(name -> acceptor
                        .accept(createCompletionProposal(name, name + " - inner declaration", null, context)));
            }
        }

    }

    protected <T> Optional<T> cast(Optional<?> optional, Class<T> clazz) {
        return optional.filter(clazz::isInstance)
            .map(clazz::cast);
    }

    protected boolean lastKeywordWasStop(ContentAssistContext context) {
        return Optional.ofNullable(context.getLastCompleteNode())
            .map(INode::getGrammarElement)
            .filter(Keyword.class::isInstance)
            .map(Keyword.class::cast)
            .map(Keyword::getValue)
            .map("."::equals)
            .orElse(false);
    }

    protected Collection<ICompletionProposal> getReferenceableVariableCompletions(Resource resource,
            ContentAssistContext cac) {
        Collection<ICompletionProposal> proposals = new ArrayList<>();
        StoexContext context = contextProvider.getContext(resource);
        Optional<RandomVariable> container = context.getContainer();

        findServiceParameters(context).stream()
            .map(Parameter::getParameterName)
            .map(name -> createCompletionProposal(name, name + " - Signature Parameter", null, cac))
            .forEach(proposals::add);

        // test if we can add the RETURN variable
        Optional<EntryLevelSystemCall> elscAction = container
            .flatMap(c -> findSelfOrParentOfType(c, AbstractUserAction.class))
            .filter(EntryLevelSystemCall.class::isInstance)
            .map(EntryLevelSystemCall.class::cast);
        if (elscAction.isPresent() && container.isPresent()) {
            EntryLevelSystemCall elsc = elscAction.get();
            RandomVariable rv = container.get();
            boolean isOutputCharacterisation = elsc.getOutputParameterUsages_EntryLevelSystemCall()
                .stream()
                .anyMatch(vu -> EcoreUtil.isAncestor(vu, rv));
            if (isOutputCharacterisation) {
                proposals.add(createCompletionProposal("RETURN", "RETURN - Call Result", null, cac));
            }
        }
        Optional<ExternalCallAction> ecaAction = container
                .flatMap(c -> findSelfOrParentOfType(c, AbstractAction.class))
                .filter(ExternalCallAction.class::isInstance)
                .map(ExternalCallAction.class::cast);
            if (ecaAction.isPresent() && container.isPresent()) {
                ExternalCallAction eca = ecaAction.get();
                RandomVariable rv = container.get();
                boolean isOutputCharacterisation = eca.getReturnVariableUsage__CallReturnAction()
                    .stream()
                    .anyMatch(vu -> EcoreUtil.isAncestor(vu, rv));
                if (isOutputCharacterisation) {
                    proposals.add(createCompletionProposal("RETURN", "RETURN - Call Result", null, cac));
                }
            }

        // we could also list all available variables (SetVariableAction, outputs of
        // EntryLevelSystemCall)

        return proposals;
    }

    protected Collection<Parameter> findServiceParameters(StoexContext context) {
        Collection<Parameter> parameters = new ArrayList<>();

        Optional<Signature> signature = context.getContainer()
            .flatMap(c -> findSelfOrParentOfType(c, ServiceEffectSpecification.class))
            .map(ServiceEffectSpecification::getDescribedService__SEFF);

        // parameters of OperationSignature can always be referenced
        Optional<OperationSignature> operationalSignature = signature.filter(OperationSignature.class::isInstance)
            .map(OperationSignature.class::cast);
        operationalSignature.map(OperationSignature::getParameters__OperationSignature)
            .ifPresent(parameters::addAll);

        // parameter of EventType can always be referenced
        Optional<EventType> eventType = signature.filter(EventType.class::isInstance)
            .map(EventType.class::cast);
        eventType.map(EventType::getParameter__EventType)
            .ifPresent(parameters::add);

        return parameters;
    }

    @SuppressWarnings("unchecked")
    protected static <T> Optional<T> findSelfOrParentOfType(EObject self, Class<T> wantedType) {
        EObject current = self;
        while (current != null) {
            if (wantedType.isInstance(current)) {
                return Optional.of((T) current);
            }
            current = current.eContainer();
        }
        return Optional.empty();
    }

}
