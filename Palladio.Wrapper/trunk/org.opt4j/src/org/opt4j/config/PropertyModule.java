/**
 * Opt4J is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or (at your
 * option) any later version.
 * 
 * Opt4J is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with Opt4J. If not, see http://www.gnu.org/licenses/. 
 */

package org.opt4j.config;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.opt4j.config.annotations.Ignore;
import org.opt4j.config.annotations.Info;
import org.opt4j.config.annotations.Order;
import org.opt4j.config.annotations.Required;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import com.google.inject.Binder;
import com.google.inject.Module;

/**
 * The {@code PropertyModule} is a decorator for a {@code Module} that enables
 * property methods.
 * 
 * @author lukasiewycz
 * 
 */
@Ignore
@SuppressWarnings("serial")
public final class PropertyModule implements Module, Serializable {

	protected final Module module;

	protected final List<Property> properties = new ArrayList<Property>();

	/**
	 * Converts a String to an element of a given enumeration.
	 * 
	 * @param name
	 *            the name of the element
	 * @param type
	 *            the enumeration type
	 * @return the element of the enumeration
	 */
	@SuppressWarnings("unchecked")
	public static Object toEnumElement(String name, Class<? extends Enum> type) {
		for (Enum e : type.getEnumConstants()) {
			if (e.name().equalsIgnoreCase(name)) {
				return e;
			}
		}
		return null;
	}

	/**
	 * Constructs a {@code PropertyModule} that decorates a {@code Module}.
	 * 
	 * @param module
	 *            the decorated {@code Module}
	 */
	public PropertyModule(Module module) {
		super();
		this.module = module;

		if (module instanceof PropertyModule) {
			throw new IllegalArgumentException(
					"PropertyModule can not decorate a PropertyModule");
		}

		// search all bean methods and their annotations
		Map<String, Method> getters = new HashMap<String, Method>();
		Map<String, Method> setters = new HashMap<String, Method>();
		Map<String, Class<?>> types = new HashMap<String, Class<?>>();
		Map<String, Collection<Annotation>> annotations = new HashMap<String, Collection<Annotation>>();

		for (Method method : module.getClass().getMethods()) {
			String name = method.getName();

			boolean get = name.startsWith("get");
			boolean is = name.startsWith("is");

			try {

				if (get || is) {

					if (get) {
						name = name.substring(3);
					} else if (is) {
						name = name.substring(2);
					}

					// this is a get method, search for a corresponding setter
					Class<?> type = method.getReturnType();
					Method setter = module.getClass().getMethod("set" + name,
							type);

					// first letter to lower case
					char[] letters = name.toCharArray();
					letters[0] = Character.toLowerCase(letters[0]);
					name = new String(letters);

					Collection<Annotation> a = new HashSet<Annotation>();

					Class<?> clazz = module.getClass();
					while (!clazz.equals(Object.class)) {
						try {
							Field field = clazz.getDeclaredField(name);
							for (Annotation annotation : field.getAnnotations()) {
								a.add(annotation);
							}
							break;
						} catch (NoSuchFieldException e) {
						}
						clazz = clazz.getSuperclass();
					}

					for (Annotation annotation : method.getAnnotations()) {
						a.add(annotation);
					}
					for (Annotation annotation : setter.getAnnotations()) {
						a.add(annotation);
					}

					getters.put(name, method);
					setters.put(name, setter);
					types.put(name, type);
					annotations.put(name, a);
				}

			} catch (SecurityException e) {
				// if the setter is not public
			} catch (NoSuchMethodException e) {
				// if the setter does not exist
			}
		}

		// construct the properties
		for (String name : getters.keySet()) {
			Method getter = getters.get(name);
			Method setter = setters.get(name);
			Class<?> type = types.get(name);
			Collection<Annotation> anno = annotations.get(name);

			Property property = new Property(module, name, type, getter,
					setter, anno);
			properties.add(property);
		}

		// interpret the annotations of the properties
		for (String name : getters.keySet()) {
			Collection<Annotation> a = annotations.get(name);
			Property property = getProperty(name);

			for (Annotation annotation : a) {

				if (annotation instanceof Info) {

					Info info = (Info) annotation;
					property.setInfo(info.value());

				} else if (annotation instanceof Order) {

					Order order = (Order) annotation;
					property.setOrder(order.value());

				} else if (annotation instanceof Required) {

					Required required = (Required) annotation;

					Property p = getProperty(required.property());
					Class<?> type = p.getType();

					if (type.isEnum()) {

						String[] values = required.elements();
						Collection<Object> elements = new HashSet<Object>();

						for (String value : values) {
							elements.add(toEnumElement(value, type
									.asSubclass(Enum.class)));
						}

						Requirement requirement = new EnumRequirement(p,
								elements);
						property.addRequirement(requirement);

					} else if (type.equals(Boolean.TYPE)) {

						boolean value = required.value();

						Requirement requirement = new BooleanRequirement(p,
								value);
						property.addRequirement(requirement);

					}

				}
			}
		}

		// sort the properties
		Collections.sort(properties, new Comparator<Property>() {

			public int compare(Property arg0, Property arg1) {
				int value0 = arg0.getOrder();
				int value1 = arg1.getOrder();

				int diff = value0 - value1;

				if (diff != 0) {
					return diff;
				}

				boolean r0 = false;
				for (Requirement requirement : arg0.getRequirements()) {
					if (requirement.getProperty().equals(arg1)) {
						r0 = true;
					}
				}

				boolean r1 = false;
				for (Requirement requirement : arg1.getRequirements()) {
					if (requirement.getProperty().equals(arg0)) {
						r1 = true;
					}
				}

				if (r0) {
					return 1;
				} else if (r1) {
					return -1;
				}

				String s0 = arg0.getName();
				String s1 = arg1.getName();

				if (!arg0.getRequirements().isEmpty()) {
					s0 = arg0.getRequirements().iterator().next().getProperty()
							.getName();
				}
				if (!arg1.getRequirements().isEmpty()) {
					s1 = arg1.getRequirements().iterator().next().getProperty()
							.getName();
				}

				return s0.compareTo(s1);

			}

		});

		for (Iterator<Property> it = properties.iterator(); it.hasNext();) {
			Property property = it.next();
			Ignore ignore = property.getAnnotation(Ignore.class);
			if (ignore != null) {
				it.remove();
			}
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.inject.Module#configure(com.google.inject.Binder)
	 */
	public void configure(Binder binder) {
		module.configure(binder);
	}

	/**
	 * Returns the decorated {@code Module}.
	 * 
	 * @return the module
	 */
	public Module getModule() {
		return module;
	}

	/**
	 * Returns the {@code Property} with the specified {@code name}.
	 * 
	 * @param name
	 *            the name of the property
	 * @return the {@code Property} with the specified {@code name}
	 */
	public Property getProperty(String name) {
		for (Property property : properties) {
			if (property.getName().equals(name)) {
				return property;
			}
		}
		return null;
	}

	/**
	 * Returns the properties.
	 * 
	 * @return the properties
	 */
	public List<Property> getProperties() {
		return properties;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String s = "Module " + module.getClass().getName() + " ";
		for (Property property : properties) {
			s += property.getName() + "=\"" + property.getValue() + "\" ";
		}

		return s;
	}

	/**
	 * Configures a {@code PropertyModule} with an XML {@code Node}.
	 * 
	 * @param node
	 *            the configuration as XML {@code Node}
	 */
	public void setConfiguration(Node node) {
		JNode xode = new JNode(node);

		Map<String, String> values = new HashMap<String, String>();

		List<JNode> propertyNodes = xode.getChildren("property");
		for (JNode propertyNode : propertyNodes) {
			String key = propertyNode.getAttribute("name");
			String value = null;
			if (propertyNode.hasText()) {
				value = propertyNode.getText();
			} else if (propertyNode.hasAttribute("value")) {
				value = propertyNode.getAttribute("value");
			}
			values.put(key, value);
		}

		for (Property property : properties) {
			String key = property.getName();
			if (values.containsKey(key)) {
				String value = values.get(key);
				try {
					property.setValue(value);
				} catch (InvocationTargetException e) {
					System.err.println("Failed to assign value to property: "
							+ key + "=" + value);
				}
			}
		}
	}

	/**
	 * Returns the configuration of the {@code PropertyModule} as XML {@code
	 * Node}.
	 * 
	 * @param document
	 *            the XML document
	 * @return the configuration as XML {@code Node}
	 */
	public Node getConfiguration(Document document) {
		JNode node = new JNode(document, "module");
		node.setAttribute("class", module.getClass().getName());

		for (Property property : properties) {
			try {
				JNode p = node.appendChild("property");

				String name = property.getName();
				Object value = property.getValue();

				p.setAttribute("name", name);
				if (value != null) {
					if (value instanceof Class) {
						p.setText(((Class<?>) value).getCanonicalName());
					} else {
						p.setText(value.toString());
					}
				}

			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			}

		}
		return node.getNode();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#clone()
	 */
	@Override
	public PropertyModule clone() {
		try {
			Module module = this.module.getClass().newInstance();
			PropertyModule propertyModule = new PropertyModule(module);
			for (Property p : getProperties()) {
				Property property = propertyModule.getProperty(p.getName());
				property.setValue(p.getValue());
			}
			return propertyModule;
		} catch (IllegalAccessException e) {
			throw new IllegalArgumentException(e);
		} catch (InstantiationException e) {
			throw new IllegalArgumentException(e);
		} catch (InvocationTargetException e) {
			throw new IllegalArgumentException(e);
		}
	}

	/**
	 * Writes the object information to an output the stream
	 * 
	 * @param out
	 *            the output stream
	 * @throws IOException
	 */
	private void writeObject(ObjectOutputStream out) throws IOException {
		out.writeObject(module.getClass().toString());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return module.getClass().hashCode();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		PropertyModule other = (PropertyModule) obj;
		return module.getClass().equals(other.module.getClass());
	}

}
