package de.uka.ipd.sdq.workflow.mdsd.emf.qvtr.internal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.InvalidRegistryObjectException;
import org.eclipse.core.runtime.Platform;

import de.uka.ipd.sdq.workflow.mdsd.Activator;
import de.uka.ipd.sdq.workflow.mdsd.emf.qvtr.AbstractQVTREngine;
import de.uka.ipd.sdq.workflow.mdsd.emf.qvtr.QVTREngine;
import de.uka.ipd.sdq.workflow.mdsd.emf.qvtr.QVTREngineFactory;

/**
 * This class enumerates all registered {@link QVTREngine}s.
 * This class provides access to the extension point.
 * 
 * @author Thomas Schuischel
 *
 */
public final class QVTREngines {

	/**
	 * Name of the extension point node engine.
	 */
	private static final String TAG_ENGINE = "engine";
	/**
	 * Name of the extension point string attribute id.
	 */
	private static final String ATT_ID = "id";
	/**
	 * Name of the extension point string attribute name.
	 */
	private static final String ATT_NAME = "name";
	/**
	 * Name of the extension point class attribute factory.
	 */
	private static final String ATT_CLASS = "factory";

	
	/**
	 * A configurable element containing the engine configuration.
	 */
	private final IConfigurationElement configElement;
	
	/**
	 * The id of the engine.
	 */
	private final String id;
	/**
	 * The name of the engine.
	 */
	private final String name;
	/**
	 * The factory for creating an new engine.
	 */
	private QVTREngineFactory factory;

	/**
	 * A cache of enumerated engines.
	 */
	private static QVTREngines[] cachedEngines;
	
	
	/**
	 * A log4j logger for this class.
	 */
	private static Logger logger = Logger.getLogger(QVTREngines.class);
	

	/**
	 * Returns the id of the engine.
	 * 
	 * @return id of engine
	 */
	public String getId() {
		return id;
	}

	/**
	 * Returns the name of the engine.
	 * 
	 * @return name of engine
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns a new instance of the engine.
	 * 
	 * @return instance of the engine.
	 */
	public AbstractQVTREngine newQVTREngine() {
		QVTREngineFactory engineFactory = getFactory();
		if (engineFactory == null) {
			return null;
		}
		return engineFactory.createEngine();
	}

	/**
	 * Returns the factory for this engine.
	 * 
	 * @return factory for this engine
	 */
	private QVTREngineFactory getFactory() {
		if (factory != null) {
			return factory;
		}
		
		try {
			factory = (QVTREngineFactory) configElement.createExecutableExtension(ATT_CLASS);
		} catch (Exception e) {
			logger.error("Failed to instantiate factory: "
            + configElement.getAttribute(ATT_CLASS) + " in type: " + id
            + " in plugin: "
            + configElement.getDeclaringExtension().getNamespaceIdentifier(), e);
		}
		return factory;
	}


	/**
	 * Dispose of any OS resources.
	 */
	private void dispose() {
		if (factory == null) {
			return;
		}
		factory.dispose();
		factory = null;
	}
 
	/////////////////////////////////////////////////////////////////////
	
	/**
	 * Parses a single configurable Element  from the extension point.
	 * 
	 * @param configurationElement 	the configurable element for this engine
	 */
	private QVTREngines(final IConfigurationElement configurationElement) {
		this.configElement = configurationElement;
		id = getAttribute(configurationElement, ATT_ID, null);
		name = getAttribute(configurationElement, ATT_NAME, id);
		getAttribute(configurationElement, ATT_CLASS, null);
	}
	
	/**
	 * Parses an attribute for this engine.
	 * 
	 * @param configElement 	the configurable element for this engine
	 * @param name				the name of the attribute
	 * @param defaultValue		the default value if the attribute is empty
	 * 
	 * @return the value of the attribute or if empty the default value
	 */
	private static String getAttribute(final IConfigurationElement configElement, final String name, 
			final String defaultValue) {
		String value = configElement.getAttribute(name);
		if (value != null) {
			return value;
		}
		if (defaultValue != null) {
			return defaultValue;
		}
		
		throw new IllegalArgumentException("missing " + name + " attribute");
	
	}
		
	/////////////////////////////////////////////////////////////////////
	
	/**
	 * Collects all available QVT-R engines.
	 * 
	 * @return array of {@link QVTREngine}s
	 */
	public static QVTREngines[] getAllEngines() {
		if (cachedEngines != null) {
			return cachedEngines;
		}

		try {
			IExtension[] extensions = Platform.getExtensionRegistry()
			.getExtensionPoint(Activator.PLUGIN_ID, "qvtrengine")
			.getExtensions();
			List<QVTREngines> found = new ArrayList<QVTREngines>();
			for (int i = 0; i < extensions.length; i++) {
				IConfigurationElement[] configElements = extensions[i].getConfigurationElements();
				for (int j = 0; j < configElements.length; j++) {
					QVTREngines proxy = parseEngineConfiguration(configElements[j]);
					if (proxy != null) {
						found.add(proxy);
					}
				}
			}
			cachedEngines = (QVTREngines[]) found.toArray(new QVTREngines[found.size()]);
		} catch (InvalidRegistryObjectException e) {
			logger.error(e);
		}
		return cachedEngines;
	}
	
	/**
	 * Returns the registered engine for a configuration element.
	 * 
	 * @param configElement a configurable element
	 * @return a engine configuration
	 */
	private static QVTREngines parseEngineConfiguration(final IConfigurationElement configElement) {
		
		if (!configElement.getName().equals(TAG_ENGINE)) {
			return null;
		} 
		
		try { 
			return new QVTREngines(configElement); 
		} catch (Exception e) {
			String name = configElement.getAttribute(ATT_NAME);
			if (name == null) {
				name = "[missing name attribute]";
			}
			String msg = "Failed to load QVTREngine named "
				+ name
				+ " in "
				+ configElement.getDeclaringExtension().getNamespaceIdentifier();
			logger.error(msg, e);
			return null;
		}
	}	

	
	/**
	 * A map of registered engines.
	 */
	private static Map<String, QVTREngines> enginesMap = null;

	/**
	 * Answer the engine configuration that has the specified identifier.
	 * 
	 * @param id
	 *           the identifier
	 * @return the type or <code>null</code> if none
	 */
	public static QVTREngines getType(final String id) {
		if (enginesMap == null) {
			if (cachedEngines == null) {
				getAllEngines();
			}
			enginesMap = new HashMap<String, QVTREngines>(cachedEngines.length);
			for (int i = 0; i < cachedEngines.length; i++) {
				QVTREngines eachType = cachedEngines[i];
				enginesMap.put(eachType.getId(), eachType);
			}
		}
		return enginesMap.get(id);
	}

	/**
	 * Dispose of any OS resources. Must be called by the plugin before shutdown.
	 */
	public static void disposeEngines() {
		if (cachedEngines == null) {
			return;
		}
		for (int i = 0; i < cachedEngines.length; i++) {
			cachedEngines[i].dispose();
		}
		cachedEngines = null;
	}
}
