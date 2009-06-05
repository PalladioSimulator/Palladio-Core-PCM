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
package org.opt4j.start;

import java.io.Serializable;
import java.lang.annotation.Annotation;

import org.opt4j.config.Property;
import org.opt4j.config.PropertyModule;
import org.opt4j.core.IndividualStateListener;
import org.opt4j.core.optimizer.OptimizerIterationListener;
import org.opt4j.core.optimizer.OptimizerStateListener;
import org.opt4j.gui.IndividualMouseListener;
import org.opt4j.gui.ToolBarService;

import com.google.inject.AbstractModule;
import com.google.inject.BindingAnnotation;
import com.google.inject.Scope;
import com.google.inject.Scopes;
import com.google.inject.binder.ConstantBindingBuilder;
import com.google.inject.multibindings.Multibinder;

/**
 * The {@code Opt4JModule} is the superclass for all modules.
 * 
 * @author lukasiewycz
 * 
 */
public abstract class Opt4JModule extends AbstractModule {

	/**
	 * The singleton scope.
	 */
	public static Scope SINGLETON = Scopes.SINGLETON;

	/**
	 * Bind a value.
	 * 
	 * @param annotation
	 *            the type of annotation of the value
	 * @return the constant binding builder that allows a binding
	 */
	public ConstantBindingBuilder bindConstant(
			Class<? extends Annotation> annotation) {
		return bindConstant().annotatedWith(annotation);
	}

	/**
	 * Bind a value.
	 * 
	 * @param annotation
	 *            the annotation of the value
	 * @return the constant binding builder that allows a binding
	 */
	public ConstantBindingBuilder bindConstant(Annotation annotation) {
		return bindConstant().annotatedWith(annotation);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.inject.AbstractModule#configure()
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected void configure() {
		config();

		/**
		 * Configure injected constants.
		 */
		PropertyModule module = new PropertyModule(this);
		for (Property property : module.getProperties()) {
			for (Annotation annotation : property.getAnnotations()) {
				if (annotation.annotationType().getAnnotation(
						BindingAnnotation.class) != null) {
					Class<?> type = property.getType();
					Object value = property.getValue();

					ConstantBindingBuilder builder = bindConstant(annotation);
					if (type.equals(Integer.TYPE)) {
						builder.to((Integer) value);
					} else if (type.equals(Long.TYPE)) {
						builder.to((Long) value);
					} else if (type.equals(Double.TYPE)) {
						builder.to((Double) value);
					} else if (type.equals(Float.TYPE)) {
						builder.to((Float) value);
					} else if (type.equals(Byte.TYPE)) {
						builder.to((Byte) value);
					} else if (type.equals(Short.TYPE)) {
						builder.to((Short) value);
					} else if (type.equals(Boolean.TYPE)) {
						builder.to((Boolean) value);
					} else if (type.equals(Character.TYPE)) {
						builder.to((Character) value);
					} else if (type.equals(String.class)) {
						builder.to((String) value);
					} else if (type.equals(Class.class)) {
						builder.to((Class<?>) value);
					} else if (value instanceof Enum<?>) {
						builder.to((Enum) value);
					}
				}
			}
		}

		multi(OptimizerStateListener.class);
		multi(OptimizerIterationListener.class);
		multi(IndividualStateListener.class);
		multi(ToolBarService.class);
		multi(IndividualMouseListener.class);
	}

	protected void multi(Class<?> clazz) {
		Multibinder.newSetBinder(binder(), clazz);
	}

	/**
	 * Configure the module.
	 */
	protected abstract void config();

	/**
	 * The {@code ConstantImpl} is the implementation of the {@code Constant}
	 * annotation.
	 * 
	 * @author lukasiewycz
	 * 
	 */
	static class ConstantImpl implements Serializable, Constant {

		private final String value;
		private final Class<?> namespace;

		/**
		 * Constructs a {@code ConstantImpl}.
		 * 
		 * @param value
		 *            the value
		 * @param namespace
		 *            the namespace
		 */
		ConstantImpl(String value, Class<?> namespace) {
			this.value = value;
			this.namespace = namespace;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.opt4j.start.Constant#value()
		 */
		@Override
		public String value() {
			return value;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.opt4j.start.Constant#namespace()
		 */
		public Class<?> namespace() {
			return namespace;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {
			return ((127 * "value".hashCode()) ^ value.hashCode())
					+ ((127 * "namespace".hashCode()) ^ namespace.hashCode());
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(Object o) {
			if (o == null || !(o instanceof Constant)) {
				return false;
			}

			Constant other = (Constant) o;
			return (value.equals(other.value()) && namespace.equals(other
					.namespace()));
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.annotation.Annotation#annotationType()
		 */
		@Override
		public Class<? extends Annotation> annotationType() {
			return Constant.class;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#toString()
		 */
		public String toString() {
			return "@" + Constant.class.getName() + "(value=" + value
					+ ", namespace" + namespace.getName() + ")";
		}

		private static final long serialVersionUID = 0;
	}

	/**
	 * Bind a constant.
	 * 
	 * @param value
	 *            the value from the {@link Constant} annotation with an empty
	 *            namespace
	 * @return the constant binding builder that allows a binding
	 */
	public ConstantBindingBuilder bindConstant(String value) {
		return bindConstant(value, Object.class);
	}

	/**
	 * Bind a constant.
	 * 
	 * @param value
	 *            the value from the {@link Constant}
	 * @param namespace
	 *            the namespace from the {@link Constant}
	 * @return the constant binding builder that allows a binding
	 */
	public ConstantBindingBuilder bindConstant(String value, Class<?> namespace) {
		assert (namespace != null);
		Constant c = new ConstantImpl(value, namespace);
		return bindConstant(c);
	}

	/**
	 * Bind an {@code OptimizerStateListener}.
	 * 
	 * @param optimizerStateListener
	 *            the listener to be bound
	 */
	public void bindOptimizerStateListener(
			Class<? extends OptimizerStateListener> optimizerStateListener) {

		Multibinder<OptimizerStateListener> multibinder = Multibinder
				.newSetBinder(binder(), OptimizerStateListener.class);
		multibinder.addBinding().to(optimizerStateListener);

	}

	/**
	 * Bind an {@code OptimizerIterationListener}.
	 * 
	 * @param optimizerIterationListener
	 *            the listener to be bound
	 */
	public void bindOptimizerIterationListener(
			Class<? extends OptimizerIterationListener> optimizerIterationListener) {

		Multibinder<OptimizerIterationListener> multibinder = Multibinder
				.newSetBinder(binder(), OptimizerIterationListener.class);
		multibinder.addBinding().to(optimizerIterationListener);

	}

	/**
	 * Bind an {@code IndividualStateListener}.
	 * 
	 * @param individualStateListener
	 *            the listener to be bound
	 */
	public void bindIndividualStateListener(
			Class<? extends IndividualStateListener> individualStateListener) {

		Multibinder<IndividualStateListener> multibinder = Multibinder
				.newSetBinder(binder(), IndividualStateListener.class);
		multibinder.addBinding().to(individualStateListener);

	}

}
