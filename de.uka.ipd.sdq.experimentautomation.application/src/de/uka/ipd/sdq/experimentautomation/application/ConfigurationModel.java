package de.uka.ipd.sdq.experimentautomation.application;

import java.io.File;
import java.net.URL;
import java.util.Collection;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osgi.framework.Bundle;

import de.uka.ipd.sdq.experimentautomation.experiments.ExperimentRepository;
import de.uka.ipd.sdq.experimentautomation.experiments.ExperimentsPackage;
import de.uka.ipd.sdq.experimentautomation.experiments.PCMModelFiles;
import de.uka.ipd.sdq.experimentautomation.variation.VariationPackage;
import de.uka.ipd.sdq.experimentautomation.variation.VariationRepository;

public class ConfigurationModel {

    private static final Logger logger = Logger.getLogger(ConfigurationModel.class);

    private ExperimentRepository experimentRepository;
    private VariationRepository variations;

    private Bundle bundle;
    private IPath experimentsLocation;

    private ConfigurationModel(ExperimentRepository experiments, VariationRepository variations, Bundle bundle,
            IPath experimentsLocation) {
        this.experimentRepository = experiments;
        this.variations = variations;
        this.bundle = bundle;
        this.experimentsLocation = experimentsLocation;
    }

    public ExperimentRepository getExperiments() {
        return experimentRepository;
    }

    public VariationRepository getVariations() {
        return variations;
    }

    public static ConfigurationModel loadFromBundle(Bundle bundle, IPath experimentsLocation, IPath variationsLocation) {
        final ResourceSet resourceSet = new ResourceSetImpl();
        ExperimentRepository experiments = (ExperimentRepository) loadResourceFromBundle(resourceSet, bundle,
                experimentsLocation, ExperimentsPackage.eINSTANCE.getExperimentRepository());
        VariationRepository variations = (VariationRepository) loadResourceFromBundle(resourceSet, bundle,
                variationsLocation, VariationPackage.eINSTANCE.getVariationRepository());

        return new ConfigurationModel(experiments, variations, bundle, experimentsLocation);
    }

    private static <T extends EClass> EObject loadResourceFromBundle(ResourceSet resourceSet, Bundle bundle,
            IPath modelLocation, T expectedType) {
        logger.debug("Loading resource " + modelLocation.toString() + " from bundle");
        URI modelUri = URI.createFileURI(modelLocation.toOSString());//absolutePathToBundleURI(bundle, modelLocation);
        Resource r = resourceSet.getResource(modelUri, true);

        EObject o = r.getContents().get(0);
        if (expectedType.isInstance(o)) {
            return o;
        } else {
            throw new RuntimeException("The root element of the loaded resource is not of the expected type "
                    + expectedType.getName());
        }
    }

    private static URI absolutePathToBundleURI(Bundle bundle, IPath modelLocation) {
        // create URI pointing to the model file contained in the bundle
        URL bundleUrl = FileLocator.find(bundle, modelLocation, null);
        URI bundleUri = URI.createURI(bundleUrl.toExternalForm());
        return bundleUri;
    }

    public void setPCMModel(PCMModelFiles pcm) {
        final ResourceSet resourceSet = new ResourceSetImpl();
        ExperimentRepository experimentRepository = (ExperimentRepository) loadResourceFromBundle(resourceSet, bundle,
                experimentsLocation, ExperimentsPackage.eINSTANCE.getExperimentRepository());

        // tell Ecore where to find the PCM partial models by overwriting the relative path with
        // the absolute path to the temporary folder.
        String[] modelFilePaths = { pcm.getAllocationFile(), pcm.getRepositoryFile(), pcm.getResourceenvironmentFile(),
                pcm.getSystemFile(), pcm.getUsagemodelFile() };
        for (String path : modelFilePaths) {
            File modelFile = new File(path);
            if (!modelFile.exists() || modelFile.isDirectory()) {
                throw new RuntimeException("Could not find file " + modelFile.toString()
                        + ". Check your configuration model.");
            }
            String fileName = modelFile.getName();
            URI absoluteFileUri = URI.createFileURI(modelFile.getPath());

            URL bundleBaseUrl = bundle.getEntry("/");
            URI bundleRelativeFileUri = URI.createURI(bundleBaseUrl.toExternalForm() + "config/" + fileName);
            resourceSet.getURIConverter().getURIMap().put(bundleRelativeFileUri, absoluteFileUri);
        }

        // resolve all references...
        EcoreUtil.resolveAll(resourceSet);

        // ...and check, whether there are unresolved references
        Map<EObject, Collection<Setting>> map = EcoreUtil.UnresolvedProxyCrossReferencer.find(resourceSet);
        for (EObject o : map.keySet()) {
            logger.warn("There are unresolved references: " + o);
        }

        // EcoreUtil.replace(this.experimentRepository, experimentRepository);

        this.experimentRepository = experimentRepository;
    }

}
