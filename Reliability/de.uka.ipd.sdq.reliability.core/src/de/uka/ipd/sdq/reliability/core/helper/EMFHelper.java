package de.uka.ipd.sdq.reliability.core.helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.query.conditions.eobjects.EObjectCondition;
import org.eclipse.emf.query.conditions.eobjects.EObjectTypeRelationCondition;
import org.eclipse.emf.query.conditions.eobjects.TypeRelation;
import org.eclipse.emf.query.statements.FROM;
import org.eclipse.emf.query.statements.IQueryResult;
import org.eclipse.emf.query.statements.SELECT;
import org.eclipse.emf.query.statements.WHERE;

import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;
import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;
import de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.pcm.system.SystemPackage;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;

/**
 * Provides utility functions for EMF models.
 * 
 * @author brosch, martens
 * 
 */
public class EMFHelper {

    /**
     * Log4J logging support.
     */
    private static Logger logger = Logger.getLogger(EMFHelper.class.getName());

    /**
     * Retrieves all model elements of a given EMF type under some root element.
     * 
     * @param root
     *            the root element
     * @param type
     *            the type of objects to find
     * @return all objects of the given type or a sub type
     */
    public EList<EObject> getElements(final EObject root, final EClass type) {

        // Prepare the result list:
        EList<EObject> resultList = new BasicEList<EObject>();

        // Search for elements that have the same type of a sub type of the
        // given type:
        EObjectCondition hasCompatibleType = new EObjectTypeRelationCondition(type,
                TypeRelation.SAMETYPE_OR_SUBTYPE_LITERAL);

        // Perform an EMF Model Query:
        IQueryResult queryResult = new SELECT(new FROM(root), new WHERE(hasCompatibleType)).execute();

        // Fill the resulting list:
        for (Object result : queryResult) {
            resultList.add((EObject) result);
        }

        // Return the result:
        return resultList;
    }

    /**
     * Save the given EObject to the file given by filename.
     * 
     * @param modelToSave
     *            The EObject to save
     * @param fileName
     *            The filename where to save.
     */
    public static void saveToXMIFile(final EObject modelToSave, final String fileName) {

        logger.debug("Saving " + modelToSave.toString() + " to " + fileName);

        // Create a resource set.
        ResourceSet resourceSet = new ResourceSetImpl();

        // Register the default resource factory -- only needed for stand-alone!
        resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
                .put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());

        URI fileURI = URI.createFileURI(new File(fileName).getAbsolutePath());
        Resource resource = resourceSet.createResource(fileURI);
        resource.getContents().add(modelToSave);

        try {
            resource.save(Collections.EMPTY_MAP);
        } catch (FileNotFoundException e) {
            if (fileName.length() > 250) {
                // try again with a shorter filename
                saveToXMIFile(modelToSave,
                        fileName.substring(0, fileName.indexOf("-")) + "-shortened-" + fileName.hashCode());
            }
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        // logger.debug("Saved " + fileURI);
    }

    /**
     * 
     * @param fileName
     * @param eNamespaceURI
     * @param ePackage
     * @return
     */
    public static EObject loadFromXMIFile(final String fileName, final String eNamespaceURI, final EPackage ePackage) {

        // Create a resource set to hold the resources.
        ResourceSet resourceSet = new ResourceSetImpl();

        // Register the appropriate resource factory to handle all file
        // extensions.
        resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
                .put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());

        // Register the package to ensure it is available during loading.
        resourceSet.getPackageRegistry().put(eNamespaceURI, ePackage);

        // Register standard PCM packages to ensure they are available during loading:
        registerPackages(resourceSet);

        // Load the file contents:
        return loadXMI(fileName, resourceSet);
    }

    /**
     * 
     * @param fileName
     *            the filename specifying the file to load from
     * @return The EObject loaded from the file
     */
    public static EObject loadFromXMIFile(final String fileName) {

        // Create a resource set to hold the resources.
        ResourceSet resourceSet = new ResourceSetImpl();

        // Register the appropriate resource factory to handle all file
        // extensions.
        resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
                .put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());

        // Register standard PCM packages to ensure they are available during loading:
        registerPackages(resourceSet);

        // Load the file contents:
        return loadXMI(fileName, resourceSet);
    }

    /**
     * 
     * @param fileName
     * @param resourceSet
     * @return
     */
    private static EObject loadXMI(final String fileName, ResourceSet resourceSet) {
        // Construct the URI for the instance file.
        // The argument is treated as a file path only if it denotes an existing
        // file. Otherwise, it's directly treated as a URL.
        File file = new File(fileName);
        URI uri = file.isFile() ? URI.createFileURI(file.getAbsolutePath()) : URI.createURI(fileName);

        Resource resource = null;
        // Demand load resource for this file.
        try {
            resource = resourceSet.getResource(uri, true);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
        EObject eObject = (EObject) resource.getContents().iterator().next();
        return EcoreUtil.getRootContainer(eObject);
    }

    /**
     * Copied From de.uka.ipd.sdq.pcmsolver.models.PCMInstance.
     * 
     * @param resourceSet
     *            The resource set to register all contained model packages with.
     */
    private static void registerPackages(final ResourceSet resourceSet) {

        resourceSet.getPackageRegistry().put(AllocationPackage.eNS_URI, AllocationPackage.eINSTANCE);
        resourceSet.getPackageRegistry().put(ParameterPackage.eNS_URI, ParameterPackage.eINSTANCE);
        resourceSet.getPackageRegistry().put(ResourceenvironmentPackage.eNS_URI, ResourceenvironmentPackage.eINSTANCE);
        resourceSet.getPackageRegistry().put(ResourcetypePackage.eNS_URI, ResourcetypePackage.eINSTANCE);
        resourceSet.getPackageRegistry().put(RepositoryPackage.eNS_URI, RepositoryPackage.eINSTANCE);
        resourceSet.getPackageRegistry().put(SeffPackage.eNS_URI, SeffPackage.eINSTANCE);
        resourceSet.getPackageRegistry().put(SystemPackage.eNS_URI, SystemPackage.eINSTANCE);
        resourceSet.getPackageRegistry().put(UsagemodelPackage.eNS_URI, UsagemodelPackage.eINSTANCE);
    }
}
