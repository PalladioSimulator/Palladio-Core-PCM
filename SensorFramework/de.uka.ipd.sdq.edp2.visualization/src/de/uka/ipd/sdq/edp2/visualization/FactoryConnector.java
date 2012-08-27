package de.uka.ipd.sdq.edp2.visualization;

import java.util.HashMap;
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
 * extension points to retrieve pairs of adapters and factories.
 * 
 * @author Dominik Ernst
 * 
 */
public class FactoryConnector implements IAdapterFactory {

	/**
	 * Singleton instance of {@link FactoryConnector}.
	 */
	public static FactoryConnector instance = new FactoryConnector();
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
	 * ID of the extension point for data sinks.
	 */
	private static final String SINK_EXTENSION_POINT_ID = "de.uka.ipd.sdq.edp2.visualization.datasink";
	/**
	 * The "class" attribute's element name in the extension point.
	 */
	private final static String CLASS_ATTRIBUTE = "class";
	/**
	 * The "factory" attribute's element name in the extension point.
	 */
	private final static String FACTORY_ATTRIBUTE = "factory";

	private static HashMap<AbstractAdapter, IElementFactory> adapterFactoryMap;
	private static HashMap<AbstractFilter, IElementFactory> filterFactoryMap;
	private static HashMap<IDataSink, IElementFactory> sinkFactoryMap;
	
	private FactoryConnector(){
		adapterFactoryMap = getAdapterFactoryMap();
		filterFactoryMap = getFilterFactoryMap();
		sinkFactoryMap = getSinkFactoryMap();
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.core.runtime.IAdapterFactory#getAdapter(java.lang.Object,
	 * java.lang.Class)
	 */
	@Override
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		
		IElementFactory resultingFactory = null;
		
		// find the adapter or filter in the maps and set the return to the corresponding
		// factory
		for (AbstractAdapter adapter : adapterFactoryMap.keySet()) {
			// compare string representations of objects
			if (adapter.getClass().getCanonicalName().equals(
					adaptableObject.toString())) {
				resultingFactory = adapterFactoryMap.get(adapter);
			}
		}
		for (AbstractFilter filter : filterFactoryMap.keySet()) {
			// compare string representations of objects
			if (filter.getClass().getCanonicalName().equals(
					adaptableObject.toString())) {
				resultingFactory = filterFactoryMap.get(filter);
			}
		}
		
		for (IDataSink sink : sinkFactoryMap.keySet()) {
			// compare string representations of objects
			if (sink.getClass().getCanonicalName().equals(
					adaptableObject.toString())) {
				resultingFactory = sinkFactoryMap.get(sink);
			}
		}
		
		// check if the special case holds, i.e. the previous element in the
		// chain is the EDP2Source
		if (adaptableObject.toString().equals(EDP2Source.class.getCanonicalName()))
			resultingFactory = new EDP2SourceFactory();

		return resultingFactory;
	}
	
	/**
	 * Gets all registered Filters ({@link AbstractFilter}) and their corresponding
	 * Factories({@link IElementFactory}).
	 * 
	 * @return a map of {@link AbstractFilter} - {@link IElementFactory} combinations.
	 */
	private static HashMap<AbstractFilter, IElementFactory> getFilterFactoryMap() {
		HashMap<AbstractFilter, IElementFactory> filterFactoryMap = new HashMap<AbstractFilter, IElementFactory>();
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
				filterFactoryMap.put((AbstractFilter) filter,
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
	 * Gets all registered Adapters ({@link AbstractAdapter}) and their corresponding
	 * Factories({@link IElementFactory}).
	 * 
	 * @return a map of {@link AbstractAdapter} - {@link IElementFactory} combinations.
	 */
	private static HashMap<AbstractAdapter, IElementFactory> getAdapterFactoryMap() {
		HashMap<AbstractAdapter, IElementFactory> adapterFactoryMap = new HashMap<AbstractAdapter, IElementFactory>();
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
				adapterFactoryMap.put((AbstractAdapter) adapter,
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
	
	/**
	 * Gets all registered editor inputs ({@link IDataSink}) and their corresponding
	 * Factories({@link IElementFactory}).
	 * 
	 * @return a map of {@link IDataSink} - {@link IElementFactory} combinations.
	 */
	private static HashMap<IDataSink, IElementFactory> getSinkFactoryMap() {
		HashMap<IDataSink, IElementFactory> sinkFactoryMap = new HashMap<IDataSink, IElementFactory>();
		// checks the extension registry for all registered adapters and adds
		// them to the list
		final IConfigurationElement[] sinkExtensions = Platform
				.getExtensionRegistry().getConfigurationElementsFor(
						SINK_EXTENSION_POINT_ID);
		for (IConfigurationElement e : sinkExtensions) {
			Object sink = null;
			Object factory = null;
			try {
				factory = e
						.createExecutableExtension(FACTORY_ATTRIBUTE);
				sink = e.createExecutableExtension(CLASS_ATTRIBUTE);
				sinkFactoryMap.put((IDataSink) sink,
						(IElementFactory) factory);
			} catch (CoreException e1) {
				logger
						.log(Level.SEVERE,
								"Error in creating an Object referenced in an extension.");
				throw new RuntimeException();
			}
		}
		return sinkFactoryMap;
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

	/**
	 * @return the singleton instance
	 */
	public static FactoryConnector getInstance() {
		return instance;
	}
}
