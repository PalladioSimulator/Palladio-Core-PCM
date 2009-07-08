package org.somox.metrics.init;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMLParserPoolImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;

import de.fzi.gast.accesses.provider.accessesItemProviderAdapterFactory;
import de.fzi.gast.annotations.provider.annotationsItemProviderAdapterFactory;
import de.fzi.gast.core.Root;
import de.fzi.gast.core.provider.coreItemProviderAdapterFactory;
import de.fzi.gast.functions.provider.functionsItemProviderAdapterFactory;
import de.fzi.gast.statements.provider.statementsItemProviderAdapterFactory;
import de.fzi.gast.types.GASTClass;
import de.fzi.gast.types.provider.typesItemProviderAdapterFactory;
import de.fzi.gast.variables.provider.variablesItemProviderAdapterFactory;


/**
 * Initialization class for the metrics.
 * 
 * Classes are extracted from the Resource and "bundled" with their inner classes.
 * 
 * @author Grischa Liebel
 *
 */
public class Initialization {
	//private EditingDomain editingDomain;
	private ComposedAdapterFactory adapterFactory;
	
	private XMLResource resource;
	
	private Root root = null;
	
	private EList<GASTClass> classList;
	
	/**
	 * Class lists are extracted from the resource at the given URI
	 * 
	 * @param uri The URI of the model file
	 * @return a list of class lists. Each class list contains one outer class and its inner classes
	 */
	public List<List<GASTClass>> extractLists (URI uri) {
		initializeEditingDomain();
		createResource(uri);
		return extractClasses();		
	}
	
	/**
	 * Returns the root object of the given modell
	 * @return the root object
	 */
	public Root getRoot () {
		return root;
	}
	
	/**
	 * Extracts all outer classes with their inner classes 
	 * 
	 * @return a list of class lists. Every list element is a list containing one outer and all of its inner classes
	 */
	private List<List<GASTClass>> extractClasses () {
		EList<EObject> contents = resource.getContents();
		
		for (EObject current : contents) {
			if (current instanceof Root) {
				root = (Root)current;
			}
		}
		if (root != null) {
			classList = root.getAllNormalClasses();
		}
		
		
		return addInnerClasses(classList);
	}
	
	/**
	 * Adds all inner classes to the given outer classes
	 * 
	 * @param elements A list of ModelElements
	 * @return a list of lists of GASTClasses
	 */
	private List<List<GASTClass>> addInnerClasses (EList<GASTClass> elements) {
		List<List<GASTClass>> elementList = new LinkedList<List<GASTClass>>();
		
		if (elements != null && elements.size() > 0) {
			for (GASTClass element : elements) {
				elementList.add(getInnerClasses(element));
			}
		}
		
		return elementList;
	}
	
	/**
	 * Returns a list of the given class itself and all of its inner classes
	 * 
	 * @param element A GASTClass object
	 * @return a list containing the given class plus all inner classes
	 */
	private List<GASTClass> getInnerClasses (GASTClass element) {
		List<GASTClass> currentList = new LinkedList<GASTClass>();
		currentList.add(element);
		
		EList<GASTClass> innerClasses = element.getInnerClasses();
		
		if (innerClasses != null) {
			for (GASTClass current : innerClasses) {
				System.out.println("INNER " + current.isInner());
			}
			currentList.addAll(innerClasses);
		}
		for (GASTClass innerClass : innerClasses) {
			currentList.addAll(getInnerClasses(innerClass));
		}
		
		return currentList;
	}
	
	/**
	 * Creates a resource from a given URI
	 * 
	 * @param fileURI The model URI
	 */
	private void createResource(URI fileURI) {
		
		// setup resource
		resource = new XMLResourceImpl(fileURI);

		Map<Object, Object> loadOptions = ((XMLResourceImpl)resource).getDefaultLoadOptions();
		loadOptions.put(XMLResource.OPTION_DEFER_ATTACHMENT, Boolean.TRUE);
		loadOptions.put(XMLResource.OPTION_DEFER_IDREF_RESOLUTION, Boolean.TRUE);
		loadOptions.put(XMLResource.OPTION_USE_DEPRECATED_METHODS, Boolean.TRUE);
		loadOptions.put(XMLResource.OPTION_USE_PARSER_POOL, new XMLParserPoolImpl());
		loadOptions.put(XMLResource.OPTION_USE_XML_NAME_TO_FEATURE_MAP, new HashMap<Object,Object>());

		// DIESE ZEILE MACHT VERMUTLICH DEN UNTERSCHIED!
		((ResourceImpl)resource).setIntrinsicIDToEObjectMap(new HashMap<String,EObject>());

		/*
		 * load GAST
		 */
		try {
			resource.load(loadOptions);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Register the default resource factory -- only needed for stand-alone!
//		editingDomain.getResourceSet().getResourceFactoryRegistry().getExtensionToFactoryMap().put(
//				Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
//		
//		//Try to load the resource through the editingDomain.
//		resource = null;
//		try {
//			resource = editingDomain.getResourceSet().getResource(fileURI, true);
//		}
//		catch (Exception e) {
//			resource = editingDomain.getResourceSet().getResource(fileURI, false);
//		}
		System.out.println("Resource \"" + fileURI.lastSegment() + "\" loaded: " + resource.isLoaded() + "\n");
	}
	
	
	/**
	 * Initializes the editing domain
	 */
	private void initializeEditingDomain () {
		adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new statementsItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new coreItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new annotationsItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new typesItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new functionsItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new accessesItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new variablesItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

		//BasicCommandStack commandStack = new BasicCommandStack();

		//editingDomain = new AdapterFactoryEditingDomain(adapterFactory, commandStack, new HashMap<Resource, Boolean>());
	}

}
