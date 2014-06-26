package de.uka.ipd.sdq.experimentautomation.application.utils;

import java.io.File;

import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osgi.framework.Bundle;

import de.uka.ipd.sdq.experimentautomation.application.ConfigurationModel;
import de.uka.ipd.sdq.experimentautomation.experiments.PCMModelFiles;
import de.uka.ipd.sdq.identifier.Identifier;

public class PCMModelHelper {

    public static EObject findModelElementById(ResourceSet rs, String id) {
        TreeIterator<?> i = EcoreUtil.getAllContents(rs, true);
        while (i.hasNext()) {
            Object o = i.next();
            if (Identifier.class.isInstance(o)) {
                Identifier identifyable = (Identifier) o;
                if (identifyable.getId().equals(id)) {
                    return (EObject) identifyable;
                }
            }
        }
        return null;
    }

    /**
     * Creates a copy of the files referenced by the given model.
     * 
     * @param model
     * @return the locations of the copied files
     */
    private static PCMModelFiles createTemporaryCopy(PCMModelFiles model, URI destDirUri) {
        // create the temporary directory
        // URI tmpDirUri = createTemporaryDirectory("expaut" + System.currentTimeMillis());

        // copy model files to the temporary directory
        String[] modelPaths = { model.getAllocationFile(), model.getRepositoryFile(),
                model.getResourceenvironmentFile(), model.getSystemFile(), model.getUsagemodelFile() };
        // PCMModel result = ExperimentsFactory.eINSTANCE.createPCMModel();
        PCMModelFiles result = (PCMModelFiles) EcoreUtil.copy(model);
        for (String path : modelPaths) {
            File modelFile = new File(path);
            if (!modelFile.exists() || modelFile.isDirectory()) {
                throw new RuntimeException("Could not find file " + modelFile.toString() + ".");
            }
            String fileName = modelFile.getName();
            URI fileUri = URI.createURI(fileName);
            URI absoluteFileUri = fileUri.resolve(destDirUri);

            // copy file
            File inputFile = modelFile;
            File outputFile = new File(absoluteFileUri.toFileString());
            FileHelper.copyFile(inputFile, outputFile);

            setFileLocation(result, outputFile);
        }
        return result;
    }

    public static PCMModelFiles createTemporaryCopy(PCMModelFiles model, Bundle bundle, Path experimentsLocation,
            Path variationsLocation) {
        // create the temporary directory
        URI tmpDirUri = createTemporaryDirectory("expaut" + System.currentTimeMillis());

        // copy experiment model files to temporary directory
        Path[] modelPaths = { experimentsLocation, variationsLocation };
        Path[] outputPaths = new Path[2];
        for (int i = 0; i < modelPaths.length; i++) {
            Path p = modelPaths[i];
            File modelFile = new File(p.toOSString());
            if (!modelFile.exists() || modelFile.isDirectory()) {
                throw new RuntimeException("Could not find file " + modelFile.toString() + ".");
            }

            String fileName = modelFile.getName();
            URI fileUri = URI.createURI(fileName);
            URI absoluteFileUri = fileUri.resolve(tmpDirUri);

            // copy file
            File inputFile = modelFile;
            File outputFile = new File(absoluteFileUri.toFileString());
            FileHelper.copyFile(inputFile, outputFile);

            outputPaths[i] = new Path(outputFile.getPath());
        }

        // copy PCM model files to temporary directory
        ConfigurationModel config = ConfigurationModel.loadFromBundle(bundle, experimentsLocation, variationsLocation);
        PCMModelFiles modelCopy = createTemporaryCopy(model, tmpDirUri);

        ConfigurationModel result = ConfigurationModel.loadFromBundle(bundle, outputPaths[0], outputPaths[1]);
        // result.getExperiments().setInitialModel(pcmmodel);

        return modelCopy;
    }

    public static PCMModelFiles copyToExperimentFolder(PCMModelFiles model, Path experimentsLocation, Path variationsLocation, URI experimentFolderUri) {
		PCMModelFiles modelCopy = copyToExperimentFolder(model, experimentFolderUri);

		// copy experiment model files to temporary directory
		Path[] modelPaths = { experimentsLocation, variationsLocation };
		Path[] outputPaths = new Path[2];
		for (int i = 0; i < modelPaths.length; i++) {
			Path p = modelPaths[i];
			File modelFile = new File(p.toOSString());
			if (!modelFile.exists() || modelFile.isDirectory()) {
				throw new RuntimeException("Could not find file " + modelFile.toString() + ".");
			}

			String fileName = modelFile.getName();
			URI fileUri = URI.createURI(fileName);
			URI absoluteFileUri = fileUri.resolve(experimentFolderUri);

			// copy file
			File inputFile = modelFile;
			File outputFile = new File(absoluteFileUri.toFileString());
			FileHelper.copyFile(inputFile, outputFile);

			outputPaths[i] = new Path(outputFile.getPath());
		}

		return modelCopy;
	}

	public static PCMModelFiles copyToExperimentFolder(PCMModelFiles model, URI experimentFolderUri) {
		// create experiment folder if it does not exit yet
		File f = new File(experimentFolderUri.toFileString());
		if (!f.exists()) {
			f.mkdir();
		}

		// copy PCM model files to temporary directory
		// ConfigurationModel config = ConfigurationModel.loadFromBundle(bundle,
		// experimentsLocation, variationsLocation);
		PCMModelFiles modelCopy = createTemporaryCopy(model, experimentFolderUri);

        // ConfigurationModel result = ConfigurationModel.loadFromBundle(bundle, outputPaths[0],
		// outputPaths[1]);
		// result.getExperiments().setInitialModel(pcmmodel);

		return modelCopy;
	}

    private static URI createTemporaryDirectory(String folderName) {
        String tmpDir = System.getProperty("java.io.tmpdir");
        File tmpDirFile = new File(tmpDir + File.separator + folderName);
        tmpDirFile.mkdir();
        URI tmpDirUri = URI.createFileURI(tmpDirFile.getPath() + "/");
        return tmpDirUri;
    }

    private static void setFileLocation(PCMModelFiles model, File temporaryFile) {
        String[] fileSegments = temporaryFile.getName().split("\\.");
        String fileExtension = fileSegments[fileSegments.length - 1];

        if (fileExtension.equalsIgnoreCase("allocation")) {
            model.setAllocationFile(temporaryFile.getPath());
        } else if (fileExtension.equalsIgnoreCase("repository")) {
            model.setRepositoryFile(temporaryFile.getPath());
        } else if (fileExtension.equalsIgnoreCase("resourceenvironment")) {
            model.setResourceenvironmentFile(temporaryFile.getPath());
        } else if (fileExtension.equalsIgnoreCase("system")) {
            model.setSystemFile(temporaryFile.getPath());
        } else if (fileExtension.equalsIgnoreCase("usagemodel")) {
            model.setUsagemodelFile(temporaryFile.getPath());
        } else {
            throw new RuntimeException("Unexpected file extension: " + fileExtension);
        }
    }

}
