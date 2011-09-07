package de.uka.ipd.sdq.edp2.visualization;

import java.util.HashMap;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.ui.IElementFactory;

import de.uka.ipd.sdq.edp2.visualization.datasource.EDP2Source;
import de.uka.ipd.sdq.edp2.visualization.datasource.EDP2SourceFactory;

/**
 * A class, which connects the different {@link IElementFactory}s. Uses
 * extension points to retrieve pairs of adapters and factories. TODO add
 * filters OR make this class superfluous by direct persistence of elements as
 * BASE64 strings in a global factory for all transformations/sources.
 * 
 * @author Dominik Ernst
 * 
 */
public class FactoryConnector implements IAdapterFactory {

	/**
	 * Logger for this class.
	 */
	private final static Logger logger = Logger
			.getLogger(FactoryConnector.class.getCanonicalName());
	/**
	 * ID of the extension point for filters.
	 */
	private static final String FILTER_EXTENSION_POINT_ID = "de.uka.ipd.sdq.edp2.visualization.filter";
	/**
	 * ID of the extension point for adapters.
	 */
	private final static String ADAPTER_EXTENSION_POINT_ID = "de.uka.ipd.sdq.edp2.visualization.adapter";
	/**
	 * The "class" attribute's element name in the extension point.
	 */
	private final static String CLASS_ATTRIBUTE = "class";
	/**
	 * The "factory" attribute's element name in the extension point.
	 */
	private final static String FACTORY_ATTRIBUTE = "factory";


	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.core.runtime.IAdapterFactory#getAdapter(java.lang.Object,
	 * java.lang.Class)
	 */
	@Override
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		
		HashMap<IAdapter, IElementFactory> adapterFactoryMap = getAdapterFactoryMap();
		HashMap<IFilter, IElementFactory> filterFactoryMap = getFilterFactoryMap();
		Set<IAdapter> adapterKeys = adapterFactoryMap.keySet();
		Set<IFilter> filterKeys = filterFactoryMap.keySet();
		
		IElementFactory resultingFactory = null;
		
		// find the adapter or filter in the maps and set the return to the corresponding
		// factory
		for (IAdapter adapter : adapterKeys) {
			// compare string representations of objects
			if (adapter.getClass().getCanonicalName().equals(
					adaptableObject.toString())) {
				resultingFactory = adapterFactoryMap.get(adapter);
			}
		}
		for (IFilter filter : filterKeys) {
			// compare string representations of objects
			if (filter.getClass().getCanonicalName().equals(
					adaptableObject.toString())) {
				resultingFactory = filterFactoryMap.get(filter);
			}
		}
		
		// check if the special case holds, i.e. the previous element in the
		// chain is the EDP2Source
		if (adaptableObject.equals(EDP2Source.class.getCanonicalName()))
			resultingFactory = new EDP2SourceFactory();

		return resultingFactory;
	}
	
	/**
	 * Gets all registered Filters ({@link IFilter}) and their corresponding
	 * Factories({@link IElementFactory}).
	 * 
	 * @return a map of {@link IFilter} - {@link IElementFactory} combinations.
	 */
	public HashMap<IFilter, IElementFactory> getFilterFactoryMap() {
		HashMap<IFilter, IElementFactory> filterFactoryMap = new HashMap<IFilter, IElementFactory>();
		// checks the extension registry for all registered adapters and adds
		// them to the list
		final IConfigurationElement[] filterExtensions = Platform
				.getExtensionRegistry().getConfigurationElementsFor(
						FILTER_EXTENSION_POINT_ID);
		for (IConfigurationElement e : filterExtensions) {
			Object filter = null;
			Object factory = null;
			try {
				factory = e
						.createExecutableExtension(FACTORY_ATTRIBUTE);
				filter = e.createExecutableExtension(CLASS_ATTRIBUTE);
				filterFactoryMap.put((IFilter) filter,
						(IElementFactory) factory);
			} catch (CoreException e1) {
				logger
						.log(Level.SEVERE,
								"Error in creating an Object referenced in an extension.");
				throw new RuntimeException();
			}
		}
		return filterFactoryMap;
	}

	/**
	 * Gets all registered Adapters ({@link IAdapter}) and their corresponding
	 * Factories({@link IElementFactory}).
	 * 
	 * @return a map of {@link IAdapter} - {@link IElementFactory} combinations.
	 */
	public HashMap<IAdapter, IElementFactory> getAdapterFactoryMap() {
		HashMap<IAdapter, IElementFactory> adapterFactoryMap = new HashMap<IAdapter, IElementFactory>();
		// checks the extension registry for all registered adapters and adds
		// them to the list
		final IConfigurationElement[] adapterExtensions = Platform
				.getExtensionRegistry().getConfigurationElementsFor(
						ADAPTER_EXTENSION_POINT_ID);
		for (IConfigurationElement e : adapterExtensions) {
			Object adapter = null;
			Object factory = null;
			try {
				factory = e
						.createExecutableExtension(FACTORY_ATTRIBUTE);
				adapter = e.createExecutableExtension(CLASS_ATTRIBUTE);
				adapterFactoryMap.put((IAdapter) adapter,
						(IElementFactory) factory);
			} catch (CoreException e1) {
				logger
						.log(Level.SEVERE,
								"Error in creating an Object referenced in an extension.");
				throw new RuntimeException();
			}
		}
		return adapterFactoryMap;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.IAdapterFactory#getAdapterList()
	 */
	@Override
	public Class[] getAdapterList() {
		Class[] supportedAdapters = new Class[1];
		supportedAdapters[0] = IElementFactory.class;

		return supportedAdapters;
	}
}
