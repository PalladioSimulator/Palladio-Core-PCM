package org.palladiosimulator.pcm.stoex.ui.contentassist;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.extensions.InjectionExtension;
import org.eclipse.xtext.ui.testing.ContentAssistProcessorTestBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.palladiosimulator.commons.stoex.services.StoexContext;
import org.palladiosimulator.commons.stoex.services.StoexContextProvider;
import org.palladiosimulator.pcm.seff.ResourceDemandingSEFF;
import org.palladiosimulator.pcm.stoex.ui.tests.PCMStoexUiInjectorProvider;
import org.palladiosimulator.pcm.usagemodel.ScenarioBehaviour;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;

import de.uka.ipd.sdq.stoex.RandomVariable;
import de.uka.ipd.sdq.stoex.analyser.visitors.TypeEnum;

@ExtendWith(InjectionExtension.class)
@InjectWith(PCMStoexUiInjectorProvider.class)
public class PCMStoexProposalProviderTest {

    @Inject
    private Injector injector;

    @Inject
    private Provider<XtextResourceSet> resourceSetProvider;

    @Inject
    private FileExtensionProvider fileExtensionProvider;

    private ContentAssistProcessorTestBuilder builder;
    private RandomVariable randomVariable;
    private TypeEnum expectedType;

    public PCMStoexProposalProviderTest() {
        super();
    }

    @BeforeEach
    public void setup() throws Exception {
        builder = new ContentAssistProcessorTestBuilder(injector, this::getAdaptedResourceFor);
        randomVariable = null;
        expectedType = null;
    }

    @Test
    public void testSuggestSignatureParameters() throws Exception {
        ResourceDemandingSEFF seff = ModelCreator.createSeffWithOneInternalAction();
        this.randomVariable = findSelfOrChild(seff, RandomVariable.class);
        builder = builder.insert("param");
        builder.assertProposal("paramSimple");
        builder.assertProposal("paramNested");
        builder.assertProposal("paramCollection");
        builder.assertProposal("paramCollectionOfComposite");
    }
    
    @Test
    public void testCompositeDataType() throws Exception {
        ResourceDemandingSEFF seff = ModelCreator.createSeffWithOneInternalAction();
        this.randomVariable = findSelfOrChild(seff, RandomVariable.class);
        builder = builder.insert("paramNested.");
        builder.assertProposal("foo1");
        builder.assertProposal("foo2");
        builder.assertProposal("foo3");
    }
    
    @Test
    public void testCompositeDataTypeTypedIncomplete() throws Exception {
        ResourceDemandingSEFF seff = ModelCreator.createSeffWithOneInternalAction();
        this.randomVariable = findSelfOrChild(seff, RandomVariable.class);
        builder = builder.insert("paramNested.fo");
        builder.assertProposal("foo1");
        builder.assertProposal("foo2");
        builder.assertProposal("foo3");
    }
    
    @Test
    public void testNestedDataTypes() throws Exception {
        ResourceDemandingSEFF seff = ModelCreator.createSeffWithOneInternalAction();
        this.randomVariable = findSelfOrChild(seff, RandomVariable.class);
        var foo1 = builder.insert("paramNested.foo1.");
        foo1.assertProposal("foo1_1_1");
        var foo2 = builder.insert("paramNested.foo2.");
        foo2.assertProposal("foo2_1_1");
        var foo3 = builder.insert("paramNested.foo3.");
        foo3.assertProposal("INNER");
    }
    
    @Test
    public void testNestedDataTypesTypedIncomplete() throws Exception {
        ResourceDemandingSEFF seff = ModelCreator.createSeffWithOneInternalAction();
        this.randomVariable = findSelfOrChild(seff, RandomVariable.class);
        var foo1 = builder.insert("paramNested.foo1.f");
        foo1.assertProposal("foo1_1_1");
        var foo2 = builder.insert("paramNested.foo2.f");
        foo2.assertProposal("foo2_1_1");
        var foo3 = builder.insert("paramNested.foo3.I");
        foo3.assertProposal("INNER");
    }
    
    @Test
    public void testCollectionDataType() throws Exception {
        ResourceDemandingSEFF seff = ModelCreator.createSeffWithOneInternalAction();
        this.randomVariable = findSelfOrChild(seff, RandomVariable.class);
        builder = builder.insert("paramCollection.");
        builder.assertProposal("INNER");
    }
    
    @Test
    public void testCollectionDataTypeOfComposite() throws Exception {
        ResourceDemandingSEFF seff = ModelCreator.createSeffWithOneInternalAction();
        this.randomVariable = findSelfOrChild(seff, RandomVariable.class);
        builder = builder.insert("paramCollectionOfComposite.INNER.");
        builder.assertProposal("foo1");
        builder.assertProposal("foo2");
    }

    @Test
    public void testSuggestVariableCharacterisations() throws Exception {
        ResourceDemandingSEFF seff = ModelCreator.createSeffWithOneInternalAction();
        this.randomVariable = findSelfOrChild(seff, RandomVariable.class);
        builder = builder.insert("paramSimple.");
        builder.assertProposal("BYTESIZE");
        builder.assertProposal("NUMBER_OF_ELEMENTS");
        builder.assertProposal("STRUCTURE");
        builder.assertProposal("TYPE");
        builder.assertProposal("VALUE");
    }

    @Test
    public void testSuggestForReturnVariableCharacterisation() throws Exception {
        ResourceDemandingSEFF seff = ModelCreator.createSeffWithOneExternalCallAction();
        this.randomVariable = findSelfOrChild(seff, RandomVariable.class);
        builder = builder.insert("");
        builder.assertProposal("paramFoo");
        builder.assertProposal("paramBar");
        builder.assertProposal("RETURN");
    }
    
    @Test
    public void testSuggestForOutputVariableCharacterisationOfELSC() throws Exception {
        ScenarioBehaviour sb = ModelCreator.createScenarioBehaviorWithOneEntryLevelSystemCall();
        this.randomVariable = findSelfOrChild(sb, RandomVariable.class);
        builder = builder.insert("");
        builder.assertProposal("RETURN");
    }
    
    protected interface StoexContextProviderAdapterMock extends Adapter, StoexContextProvider {

    }

    protected XtextResource getAdaptedResourceFor(InputStream stream) {
        XtextResource r = getResourceFor(stream);
        StoexContextProviderAdapterMock adapter = new StoexContextProviderAdapterMock() {

            @Override
            public void notifyChanged(Notification notification) {
            }

            @Override
            public Notifier getTarget() {
                return null;
            }

            @Override
            public void setTarget(Notifier newTarget) {
            }

            @Override
            public boolean isAdapterForType(Object type) {
                return StoexContextProvider.class == type;
            }

            @Override
            public StoexContext getContext(Resource resource) {
                return new StoexContext() {

                    @Override
                    public Optional<TypeEnum> getExpectedType() {
                        return Optional.ofNullable(expectedType);
                    }

                    @Override
                    public Optional<RandomVariable> getContainer() {
                        return Optional.ofNullable(randomVariable);
                    }
                };
            }

        };
        r.eAdapters()
            .add(adapter);
        return r;
    }

    protected XtextResource getResourceFor(InputStream stream) {
        XtextResourceSet resourceSet = resourceSetProvider.get();
        try {
            URI resourceUri = URI.createURI("Test." + fileExtensionProvider.getPrimaryFileExtension());
            Resource resource = resourceSet.createResource(resourceUri);
            resource.load(stream, null);
            return (XtextResource) resource;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected static <T extends EObject> T findSelfOrChild(EObject element, Class<T> clz) {
        if (clz.isInstance(element)) {
            return clz.cast(element);
        }
        for (TreeIterator<EObject> iter = element.eAllContents(); iter.hasNext();) {
            var current = iter.next();
            if (clz.isInstance(current)) {
                return clz.cast(current);
            }
        }
        return null;
    }
}
