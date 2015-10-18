package edu.kit.ipd.sdq.eventsim.measurement.probe;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.osgi.framework.Bundle;
import org.osgi.framework.wiring.BundleWiring;

import edu.kit.ipd.sdq.eventsim.measurement.ProbeConfiguration;
import edu.kit.ipd.sdq.eventsim.measurement.MeasuringPoint;
import edu.kit.ipd.sdq.eventsim.measurement.annotation.Probe;

/**
 * A factory for instances of {@link IProbe}. Maintains a map that maps (element, property)-pairs to probes; each
 * mapping expresses that the probe is capable to measure the specified property for the specified element. Mappings are
 * created by searching the classpath for classes annotated with {@link Probe}.
 * 
 * @author Philipp Merkle
 *
 * @param <C>
 */
public class ProbeFactory<C extends ProbeConfiguration> {

	private static final Logger log = Logger.getLogger(ProbeFactory.class);

	private Map<MeasuredElementAndProperty, Class<? extends AbstractProbe<?, ?, C>>> probesMap = new HashMap<>();

	private C configuration;

	public ProbeFactory(C configuration, Bundle bundle) {
		this.configuration = configuration;

		findProbesByAnnotationAndPopulateProbesMap(bundle);
	}

	@SuppressWarnings("unchecked")
	public <E, T> IProbe<E, T> create(E element, String property, Object... measurementContexts) {
		// try finding a probe capable of probing elements of the given type.
		// start with the most specific element type.
		Class<? extends AbstractProbe<?, ?, C>> probeClass = probesMap.get(new MeasuredElementAndProperty(
				getInstanceClass(element), property));
		// if no probe is responsible for elements of the given type, try finding a probe for a supertype.
		if (probeClass == null) {
			// TODO make sure to return probe for most specific (!) super type.
			for (Class<?> c : allSupertypes(element)) {
				probeClass = probesMap.get(new MeasuredElementAndProperty(c, property));
				if (probeClass != null) {
					break;
				}
			}
		}

		if (probeClass == null) {
			log.error(String.format("No probe has been found capable of measuring property \"%s\" for elements of "
					+ "type %s", element.getClass(), property));
			return IProbe.nullProbe(element, property, measurementContexts);
		}

		AbstractProbe<?, ?, C> p = null;
		try {
			Constructor<? extends AbstractProbe<?, ?, C>> c = probeClass.getConstructor(MeasuringPoint.class,
					configuration.getClass());
			p = c.newInstance(new MeasuringPoint<E>(element, property, measurementContexts), configuration);
			log.debug("Created probe " + p + " (element=" + element + ", property=" + property + ")");
		} catch (InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException
				| IllegalArgumentException | InvocationTargetException e) {
			log.error("Exception while invoking probe constructor.", e);
			return IProbe.nullProbe(element, property, measurementContexts);
		}

		return (IProbe<E, T>) p;
	}

	@SuppressWarnings("unchecked")
	private void findProbesByAnnotationAndPopulateProbesMap(Bundle bundle) {
		Collection<String> classesInLocalBundle = bundle.adapt(BundleWiring.class).listResources("", "*.class",
				BundleWiring.FINDENTRIES_RECURSE + BundleWiring.LISTRESOURCES_LOCAL);

		for (String classString : classesInLocalBundle) {
			URL classURL = bundle.getEntry(classString);
			if (classURL != null) {
				String className = classURL.getPath().replaceAll("/", ".").replace(".class", "").replace(".bin.", "");

				Class<?> clazz = null;
				try {
					clazz = bundle.loadClass(className);
				} catch (ClassNotFoundException e) {
					log.error("Local bundle classloader could not find class " + className);
				}

				Probe a = clazz.getAnnotation(Probe.class);
				if (a != null) {
					if (AbstractProbe.class.isAssignableFrom(clazz)) {
						// the following cast is safe
						probesMap.put(new MeasuredElementAndProperty(a.type(), a.property()),
								(Class<? extends AbstractProbe<?, ?, C>>) clazz);
					} else {
						log.error(String.format("Class %s carries the %s annotation but does not extend %s.",
								className, Probe.class.getSimpleName(), AbstractProbe.class));
					}
				}
			} else {
				log.debug("Could not locate resource " + classString + " in local bundle");
			}
		}
	}

	private <E> Class<?> getInstanceClass(E element) {
		if (EObject.class.isInstance(element)) {
			return ((EObject) element).eClass().getInstanceClass();
		} else {
			return element.getClass();
		}
	}

	private <E> List<Class<?>> allSupertypes(E element) {
		List<Class<?>> superTypes = new ArrayList<>();
		if (EObject.class.isInstance(element)) {
			for (EClass c : ((EObject) element).eClass().getEAllSuperTypes()) {
				superTypes.add(c.getInstanceClass());
			}
		} else {
			throw new UnsupportedOperationException();
			// TODO implementation for regular objects
		}
		return superTypes;
	}

	private class MeasuredElementAndProperty {

		private Class<?> measuredElement;

		private String measuredProperty;

		public MeasuredElementAndProperty(Class<?> measuredElement, String measuredProperty) {
			this.measuredElement = measuredElement;
			this.measuredProperty = measuredProperty;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((measuredElement == null) ? 0 : measuredElement.hashCode());
			result = prime * result + ((measuredProperty == null) ? 0 : measuredProperty.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			@SuppressWarnings("unchecked")
			MeasuredElementAndProperty other = (MeasuredElementAndProperty) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (measuredElement == null) {
				if (other.measuredElement != null)
					return false;
			} else if (!measuredElement.equals(other.measuredElement))
				return false;
			if (measuredProperty == null) {
				if (other.measuredProperty != null)
					return false;
			} else if (!measuredProperty.equals(other.measuredProperty))
				return false;
			return true;
		}

		private ProbeFactory<C> getOuterType() {
			return ProbeFactory.this;
		}

	}

}
