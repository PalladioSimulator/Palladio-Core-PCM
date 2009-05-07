/**
 * The parts operating on the PCM side are gathered here. 
 */
package de.uka.ipd.sdq.code2model.pcm;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.Bundle;

import de.uka.ipd.sdq.code2model.Helpers;
import de.uka.ipd.sdq.code2model.wrappers.Method;
import de.uka.ipd.sdq.code2model.wrappers.Method.MethodParameter;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.Parameter;
import de.uka.ipd.sdq.pcm.repository.PrimitiveDataType;
import de.uka.ipd.sdq.pcm.repository.PrimitiveTypeEnum;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.ProvidesComponentType;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.RepositoryFactory;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceRepository;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceType;
import de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;

/**
 * Encapsulates a {@link Repository}, along with methods to create elements and
 * store them in the repository.
 * <p>
 * At instantiation, the repository is pre-loaded with some elements:
 * <ul>
 * <li>a CPU {@link ResourceType}</li>
 * <li>an I/O {@link ResourceType}</li>
 * <li>a 'graphical output' {@link ResourceType}</li>
 * <li>the {@link PrimitiveDataType}s boolean, int, long, double, char, byte,
 * String (can be retrieved with {@link #getPrimitiveDataType(String)})</li>
 * </ul>
 * </p>
 * 
 * @author thomas
 */
public class Code2ModelRepository {
	private static final String PLUGIN_ID = "de.uka.ipd.sdq.code2model";
	private static final String RESOURCETYPE_FILE = "pcm" + "/" + "Java2PCM.resourcetype";
	//private static final String RESOURCETYPE_FILE = "pcm" + File.separator + "Java2PCM.resourcetype";
	private static final String CPU_RESOURCETYPE_NAME = "CPU";
	private static final String IO_RESOURCETYPE_NAME = "IO";
	private static final String OUTPUT_RESOURCETYPE_NAME = "OUTPUT";
	
	private Repository repository;
	private RepositoryFactory repositoryFactory;
	private ResourceRepository resourcetypeRepository;
	private Hashtable<String, PrimitiveDataType> primitiveTypes;
	private Logger logger;
	private HashMap<Method, Signature> methodsToSignatures = 
			new HashMap<Method, Signature>();
	private HashMap<String, BasicComponent> componentsByName = 
			new HashMap<String, BasicComponent>();

	public static ProcessingResourceType CPU_RESOURCETYPE;
	public static ProcessingResourceType IO_RESOURCETYPE;
	public static ProcessingResourceType OUTPUT_RESOURCETYPE;

	public Code2ModelRepository() {
		logger = Logger.getLogger(this.getClass());
		
		this.repositoryFactory = RepositoryFactory.eINSTANCE;
		this.primitiveTypes = new Hashtable<String, PrimitiveDataType>();
		this.repository = this.repositoryFactory.createRepository();
		
		createInitialResources();
		createPrimitiveDatatypes();
	}

	/**
	 * Create the resources to be associated later to internal actions.
	 * <p>
	 * So far, the resources created are:
	 * <ul>
	 * <li>CPU, written to {@link #CPU_RESOURCETYPE}</li>
	 * <li>Hard disk, written to {@link #IO_RESOURCETYPE}</li>
	 * <li>Console (for System.out output), written to
	 * {@link #OUTPUT_RESOURCETYPE}</li>
	 * </ul>
	 * </p>
	 */
	private void createInitialResources() {
		ResourceSet resourceSet = createResourceSetForResourcetypeRepository();
		
		this.resourcetypeRepository = (ResourceRepository) 
				loadFromXMIFile(RESOURCETYPE_FILE, resourceSet);
		for (ResourceType type : this.resourcetypeRepository
				.getAvailableResourceTypes_ResourceRepository()) {
			String name = type.getEntityName();
			if (name.equals(CPU_RESOURCETYPE_NAME)) {
				CPU_RESOURCETYPE = (ProcessingResourceType) type;
			} else if (name.equals(IO_RESOURCETYPE_NAME)) {
				IO_RESOURCETYPE = (ProcessingResourceType) type;
			} else if (name.equals(OUTPUT_RESOURCETYPE_NAME)) {
				OUTPUT_RESOURCETYPE = (ProcessingResourceType) type;
			}
		}
	}
    
    /**
     * Load an XMI file, such as a resourcetype repository.
     * 
     * @param fileName the path to the file, relative inside Eclipse
     * @return the corresponding {@link EObject}
     */
    private EObject loadFromXMIFile(String fileName, ResourceSet resourceSet) {
		URI fileURI = getURIForPluginOwnedFile(fileName);

		Resource resource = null;
		try {
			resource = resourceSet.getResource(fileURI, true);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}

		EObject eObject = (EObject) resource.getContents().iterator().next();
		return EcoreUtil.getRootContainer(eObject);
	}

	private ResourceSet createResourceSetForResourcetypeRepository() {
		// Create a resource set to hold the resources.
		ResourceSet resourceSet = new ResourceSetImpl();

		// Register the appropriate resource factory to handle all file
		// extensions.
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put(Resource.Factory.Registry.DEFAULT_EXTENSION,
						new XMIResourceFactoryImpl());

		// Register the package to ensure it is available during loading.
		resourceSet.getPackageRegistry().put(ResourcetypePackage.eNS_URI,
				ResourcetypePackage.eINSTANCE);
		return resourceSet;
	}

	/**
	 * Get an URI with an absolute path for a file belonging to the own plug-in.
	 * 
	 * @param fileName
	 *            the path to the plug-in file
	 * @return an absolute URI to the file
	 */
	private URI getURIForPluginOwnedFile(String fileName) {
		URI fileURI = URI.createPlatformPluginURI(PLUGIN_ID + "/" + RESOURCETYPE_FILE, true);
		logger.info("Using resource type file " + fileURI);
		return fileURI;
	}

	/**
	 * Create all primitive data types possible in the PCM and register them.
	 * <p>
	 * They can then easily be retrieved by name with
	 * {@link #getPrimitiveDataType(String)}.
	 * </p>
	 * <p>
	 * The types are currently:
	 * <ul>
	 * <li>boolean</li>
	 * <li>int</li>
	 * <li>long</li>
	 * <li>double</li>
	 * <li>char</li>
	 * <li>byte</li>
	 * <li>String</li>
	 * </ul>
	 * </p>
	 */
	private void createPrimitiveDatatypes() {
		String[] typeNames = { "boolean", "int", "long", "double", "char",
				"byte", "String" };
		PrimitiveTypeEnum[] enums = { PrimitiveTypeEnum.BOOL,
				PrimitiveTypeEnum.INT, PrimitiveTypeEnum.LONG,
				PrimitiveTypeEnum.DOUBLE, PrimitiveTypeEnum.CHAR,
				PrimitiveTypeEnum.BYTE, PrimitiveTypeEnum.STRING };

		for (int i = 0; i < typeNames.length; i++) {
			PrimitiveDataType pType = this.repositoryFactory
					.createPrimitiveDataType();
			pType.setType(enums[i]);
			this.primitiveTypes.put(typeNames[i], pType);
			pType.setRepository_DataType(this.repository);
		}
	}
	
	/**
	 * Create a new {@link BasicComponent}. An interface with the same name is
	 * looked up and, if present, provided by the new component.
	 * 
	 * @param name
	 *            the name of the component
	 */
	public ProvidesComponentType createComponent(String name) {
		if (this.componentsByName.get(name) != null) {
			logger.info("Request to create component " + name + ", already exists");
			return null;
		}
		logger.info("New component: " + name);		
		
		BasicComponent comp = repositoryFactory.createBasicComponent();
		this.componentsByName.put(name, comp);

		String simpleName = Helpers.getSimpleNameFromQualified(name);
		comp.setEntityName(simpleName);

		Interface myProvidedIFace = getInterface(name);
		if (myProvidedIFace != null) {
			letComponentProvideInterface(comp, myProvidedIFace);
		}
		
		comp.setRepository_ProvidesComponentType(repository);
		return comp;
	}

	/**
	 * Connect the given component and interface by letting the the component
	 * provide the interface.
	 * 
	 * @param comp
	 *            the component
	 * @param myProvidedIFace
	 *            the interface to be provided
	 */
	private void letComponentProvideInterface(BasicComponent comp,
			Interface myProvidedIFace) {
		ProvidedRole pr = repositoryFactory.createProvidedRole();
		pr.setEntityName(myProvidedIFace.getEntityName());
		pr.setProvidedInterface__ProvidedRole(myProvidedIFace);
		pr.setProvidingEntity_ProvidedRole(comp);
	}

	/**
	 * Add a signature to the given interface.
	 * 
	 * @param method
	 *            the wrapped {@link Method} to represent in the signature
	 * @param ifaceName
	 *            the interface to add the signature to
	 */
	public void addSignature(Method method) {
		String interfaceName = method.getQualifiedDeclaringClassName();
		Interface iface = getInterface(interfaceName);
		if (iface == null) {
			logger.info("No interface named " + interfaceName + 
					" found for Method " + method + ", adding it.");
			iface = addInterface(interfaceName);
		} else {
			for (Signature s : iface.getSignatures__Interface()) {
				Method m = new Method(s);
				if (method.equals(m)) {
					logger.info("Method " + m + " is already in interface " 
							+ interfaceName);
					return;
				}
			}
		}
		logger.info("Creating a signature for method " + method + 
				" in " + interfaceName);
		Signature sig = createSignature(method);
		iface.getSignatures__Interface().add(sig);
	}


	/**
	 * Get the interface with the given name from the repository.
	 * 
	 * @param ifaceName
	 *            the interface name
	 * @return the interface, or null if none of that name is present
	 */
	private Interface getInterface(String ifaceName) {
		for (Interface i : repository.getInterfaces__Repository()) {
			if (ifaceName.equals(i.getEntityName())) {
				return i;
			}
		}
		return null;
	}

	/**
	 * Create a new interface and let the given component provide it.
	 * 
	 * @param component
	 *            the name of the component to provide it
	 * @param interfaceName
	 *            the name of the new interface
	 */
	public Interface addInterface(String interfaceName) {
		Interface newInterface = repositoryFactory.createInterface();
		newInterface.setEntityName(interfaceName);
		newInterface.setRepository_Interface(repository);
		
		// If a component of the same name exists, we connect automagically.
		BasicComponent comp = getComponent(interfaceName);
		if (comp != null) {
			letComponentProvideInterface(comp, newInterface);
		}
		
		return newInterface;
	}
	
	public void createRequiredRoleForExternalCall(Method calledMethod, 
												  String callingClassName) {
		Signature sig = getSignature(calledMethod);
		Interface requiredInterface = sig.getInterface_Signature();
		BasicComponent component = getComponent(callingClassName);
		
		if (requiredInterface == null) {
			logger.error("createRequiredRoleForExternalCall: no interface " +
					"found for method " + calledMethod);
			return;
		}
		if (component == null) {
			component = (BasicComponent) createComponent(callingClassName);
		}
		
		for (RequiredRole r : component.getRequiredRoles_InterfaceRequiringEntity()) {
			if (r.getRequiredInterface__RequiredRole().equals(requiredInterface)) {
				logger.info("Component " + component.getEntityName() + 
						" already requires " + requiredInterface.getEntityName());
			}
			return;
		}
		
		RequiredRole rr = repositoryFactory.createRequiredRole();
		rr.setRequiredInterface__RequiredRole(requiredInterface);
		rr.setRequiringEntity_RequiredRole(component);
		rr.setEntityName(callingClassName + " requiring " + requiredInterface.getEntityName());
	}

	/**
	 * Retrieve a component by fully qualified name.
	 * 
	 * @param compName the name of the component
	 * @return the component
	 */
	public BasicComponent getComponent(String compName) {
		return this.componentsByName.get(compName);
	}

	/**
	 * Retrieve the primitive data type with the given name.
	 * 
	 * @param typeName
	 *            the name of the type
	 * @return the {@link PrimitiveDataType}
	 */
	public PrimitiveDataType getPrimitiveDataType(String typeName) {
		return this.primitiveTypes.get(typeName);
	}

	/**
	 * Save the repository, and thus the created {@link ResourceDemandingSEFF}s,
	 * to an XML file using Eclipse's EMF framework.
	 * 
	 * @param repositoryURI
	 *            the URI of the file to be saved to
	 * @param repositoryName
	 *            the name of the repository
	 */
	public void save(URI fileURI, String repositoryName) throws IOException {
		logger.info("Saving repositories to " + fileURI.toFileString());

		ResourceSet resourceSet = getResourceSetForURI();

		this.repository.setEntityName(repositoryName);
		URI repositoryURI = fileURI;
		repositoryURI = repositoryURI.appendFileExtension("repository");
		// Create a resource for this file.
		Resource resource = resourceSet.createResource(repositoryURI);
		// Add object to the contents.
		resource.getContents().add(this.repository);
		resource.save(Collections.EMPTY_MAP);
	}

	private ResourceSet getResourceSetForURI() {
		ResourceSet resourceSet = new ResourceSetImpl();
		// Register the default resource factory -- only needed for stand-alone!
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put(Resource.Factory.Registry.DEFAULT_EXTENSION,
						new XMIResourceFactoryImpl());
		return resourceSet;
	}

	/**
	 * Create a new {@link Parameter}.
	 * 
	 * @return the created parameter
	 */
	private Parameter createParameter(String name, String type) {
		Parameter param = this.repositoryFactory.createParameter();
		param.setParameterName(name);
		PrimitiveDataType t = this.primitiveTypes.get(type);
		if (t == null) {
			t = this.primitiveTypes.get("String");
		}
		param.setDatatype__Parameter(t);
		return param;
	}

	/**
	 * Create a method signature without parameters, given the method name and
	 * the return type.
	 * 
	 * @param calledMethod
	 *            the method to create the signature for
	 * @return the created signature
	 */
	private Signature createSignature(Method calledMethod) {
		Signature sig = this.repositoryFactory.createSignature();
		sig.setServiceName(calledMethod.getMethodName());

		String returnType = calledMethod.getReturnType();		
		if ((returnType != null) && (!returnType.equals("void"))) {
			PrimitiveDataType dt = this.primitiveTypes.get(returnType);
			sig.setReturntype__Signature(dt);
		}
		
		for (MethodParameter p : calledMethod) {
			Parameter param = createParameter(p.getName(), p.getType());
			sig.getParameters__Signature().add(param);
		}

		this.methodsToSignatures.put(calledMethod, sig);
		
		return sig;
	}

	/**
	 * Get the signature for the given method.
	 * 
	 * @param method the method
	 * @return the signature for the method
	 */
	public Signature getSignature(Method method) {
		System.out.println("Getting method " + method);
		Signature sig =  this.methodsToSignatures.get(method);
		// Perhaps the method is defined in one of the analyzed classes, but we
		// haven't been there yet.
		if (sig == null) {
			System.out.println("Adding it.");
			addSignature(method);
		}
		return this.methodsToSignatures.get(method);
	}

}
