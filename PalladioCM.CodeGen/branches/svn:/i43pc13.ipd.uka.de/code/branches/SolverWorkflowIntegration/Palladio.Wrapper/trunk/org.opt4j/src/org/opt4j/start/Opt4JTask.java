package org.opt4j.start;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.opt4j.config.Task;
import org.opt4j.config.TaskStateListener;
import org.opt4j.core.Genotype;
import org.opt4j.core.Phenotype;
import org.opt4j.core.optimizer.Control;
import org.opt4j.core.optimizer.ControlListener;
import org.opt4j.core.optimizer.Executer;
import org.opt4j.core.optimizer.Optimizer;
import org.opt4j.core.optimizer.OptimizerIterationListener;
import org.opt4j.core.problem.Creator;
import org.opt4j.core.problem.Decoder;
import org.opt4j.core.problem.Evaluator;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * The {@code Opt4JTask} executes one optimization process.
 * 
 * @author lukasiewycz
 * @see Task
 * 
 */
public class Opt4JTask extends Task implements ControlListener,
		OptimizerIterationListener {

	protected Optimizer optimizer = null;

	protected Injector injector = null;

	protected final boolean closeOnStop;

	protected boolean isClosed = false;

	protected boolean initializing = false;

	/**
	 * Constructs a {@code Opt4JTask}.
	 * 
	 */
	@Inject
	public Opt4JTask() {
		this(true);
	}

	/**
	 * Constructs a {@code Opt4JTask}.
	 * 
	 * @param closeOnStop
	 *            close automatically after optimization
	 */
	public Opt4JTask(boolean closeOnStop) {
		this.closeOnStop = closeOnStop;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.config.Task#execute()
	 */
	@Override
	public void execute() throws Exception {
		open();
		check(injector);

		Control control = injector.getInstance(Control.class);
		optimizer = injector.getInstance(Optimizer.class);
		stateChanged();
		control.addListener(this);
		optimizer.addOptimizerIterationListener(this);

		Executer executer = injector.getInstance(Executer.class);
		executer.execute();

		if (closeOnStop) {
			close();
		}
	}

	/**
	 * Close the task.
	 */
	public synchronized void close() {
		optimizer = null;
		injector = null;
		isClosed = true;
	}

	/**
	 * Initialize a task manually before executing it. This enables to get
	 * instances of classes before the optimization starts.
	 */
	public synchronized void open() {
		if (injector == null && !isClosed) {
			if (!isInit) {
				throw new RuntimeException(
						"Task is not initialized. Call method init(modules) first.");
			}
			injector = Guice.createInjector(modules);
		}
	}

	/**
	 * Returns the current iteration.
	 * 
	 * @return the current iteration
	 */
	public int getIteration() {
		Optimizer optimizer = getOptimizer();
		if (optimizer == null) {
			return 0;
		}
		return optimizer.getIteration();
	}

	/**
	 * Returns the instance of the given class.
	 * 
	 * @param <O>
	 *            the type of class
	 * @param type
	 *            the class
	 * @return the instance of the class
	 */
	public <O> O getInstance(Class<O> type) {
		Injector injector = getInjector();
		if (injector == null) {
			return null;
		}
		return injector.getInstance(type);
	}

	protected Injector getInjector() {
		return injector;
	}

	protected Optimizer getOptimizer() {
		return optimizer;
	}

	/**
	 * Checks for configuration errors in the {@code Injector}.
	 * 
	 * @param injector
	 *            the injector
	 */
	private void check(Injector injector) {

		Creator<?> creator = null;
		Decoder<?, ?> decoder = null;
		Evaluator<?> evaluator = null;

		try {
			creator = injector.getInstance(Creator.class);
			decoder = injector.getInstance(Decoder.class);
			evaluator = injector.getInstance(Evaluator.class);
		} catch (Exception e) {
			throw new RuntimeException("Problem configuration Exception: \n"
					+ e.getLocalizedMessage(), e);
		}
		try {
			injector.getInstance(Optimizer.class);
		} catch (Exception e) {
			throw new RuntimeException("Optimizer configuration Exception: \n"
					+ e.getLocalizedMessage(), e);
		}

		try {

			Type creatorType0 = getType(Creator.class, creator, "G");
			Type decoderType0 = getType(Decoder.class, decoder, "G");
			Type decoderType1 = getType(Decoder.class, decoder, "P");
			Type evaluatorType0 = getType(Evaluator.class, evaluator, "P");

			Class<?> creatorGenotype = toClass(creatorType0);
			Class<?> decoderGenotype = toClass(decoderType0);
			Class<?> decoderPhenotype = toClass(decoderType1);
			Class<?> evaluatorPhenotype = toClass(evaluatorType0);

			if (creatorGenotype == null) {
				creatorGenotype = Genotype.class;
			}
			if (decoderGenotype == null) {
				decoderGenotype = Genotype.class;
			}
			if (decoderPhenotype == null) {
				decoderPhenotype = Phenotype.class;
			}
			if (evaluatorPhenotype == null) {
				evaluatorPhenotype = Phenotype.class;
			}

			boolean a = decoderGenotype.isAssignableFrom(creatorGenotype);
			boolean b = evaluatorPhenotype.isAssignableFrom(decoderPhenotype);

			if (!a) {
				throw new IllegalArgumentException("Creator("
						+ creator.getClass() + ") and Decoder("
						+ decoder.getClass()
						+ ") are not compatible. Creator creates \""
						+ creatorGenotype + "\", Decoder decodes \""
						+ decoderGenotype + "\".");
			}
			if (!b) {
				throw new IllegalArgumentException("Decoder("
						+ decoder.getClass() + ") and Evaluator("
						+ evaluator.getClass()
						+ ") are not compatible. Decoder decodes \""
						+ decoderPhenotype + "\", Evaluator evaluates \""
						+ evaluatorPhenotype + "\".");
			}
		} catch (NullPointerException e) {
			// TODO
		}
	}

	private Class<?> toClass(Type type) {
		if (type instanceof Class) {
			return (Class<?>) type;
		} else if (type instanceof ParameterizedType) {
			return (Class<?>) ((ParameterizedType) type).getRawType();
		} else {
			return null;
		}
	}

	/**
	 * Returns the type of the generic of the interface of an class for an
	 * object.
	 * 
	 * @param clazz
	 *            the interface with the undefined generic
	 * @param object
	 *            the current implementation of the interface
	 * @param variable
	 *            the identifier
	 * @return the implemented type of the generic
	 */
	private Type getType(Class<?> clazz, Object object, String variable) {
		return getType(clazz, variable, getTypes(object.getClass()));
	}

	private Type getType(Class<?> clazz, String variable,
			Map<Type, ParameterizedType> map) {

		// get first
		ParameterizedType ptype = map.get(clazz);
		if (ptype == null) {
			return null;
		}

		Type type = null;
		for (int j = 0; j < ptype.getActualTypeArguments().length; j++) {
			TypeVariable<?> v = (TypeVariable<?>) clazz.getTypeParameters()[j];
			if (v.getName().equals(variable)) {
				type = ptype.getActualTypeArguments()[j];
			}
		}

		while (type instanceof TypeVariable) {
			TypeVariable<?> var = (TypeVariable<?>) type;
			ParameterizedType paramType = map.get(var.getGenericDeclaration());
			Class<?> freeType = (Class<?>) paramType.getRawType();

			int size = freeType.getTypeParameters().length;

			for (int j = 0; j < size; j++) {
				TypeVariable<?> f = freeType.getTypeParameters()[j];
				if (f.equals(var)) {
					type = paramType.getActualTypeArguments()[j];
					break;
				}
			}
		}

		return type;
	}

	private Map<Type, ParameterizedType> getTypes(Class<?> clazz) {
		Collection<Class<?>> classes = getAllClasses(clazz);
		Collection<ParameterizedType> paramTypes = getParameterizedTypes(classes);

		Map<Type, ParameterizedType> map = new HashMap<Type, ParameterizedType>();

		for (ParameterizedType p : paramTypes) {
			map.put(p.getRawType(), p);
		}

		return map;
	}

	private Collection<Class<?>> getAllClasses(final Class<?> clazz) {
		Collection<Class<?>> set = new HashSet<Class<?>>();
		if (clazz != null && !clazz.equals(Object.class)) {
			set.add(clazz);

			Class<?> superclass = clazz.getSuperclass();
			set.addAll(getAllClasses(superclass));

			for (Class<?> inf : clazz.getInterfaces()) {
				set.addAll(getAllClasses(inf));
			}
		}
		return set;
	}

	private Collection<ParameterizedType> getParameterizedTypes(
			Collection<Class<?>> classes) {
		Collection<ParameterizedType> paramTypes = new HashSet<ParameterizedType>();

		for (Class<?> clazz : classes) {

			Type type = clazz.getGenericSuperclass();

			if (type instanceof ParameterizedType) {
				ParameterizedType p = (ParameterizedType) type;
				paramTypes.add(p);
			}

			for (Type t : clazz.getGenericInterfaces()) {
				if (t instanceof ParameterizedType) {
					ParameterizedType p = (ParameterizedType) t;
					paramTypes.add(p);
				}
			}
		}

		return paramTypes;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.opt4j.core.optimizer.ControlListener#stateChanged(org.opt4j.core.
	 * optimizer.Control.State)
	 */
	public void stateChanged(org.opt4j.core.optimizer.Control.State state) {
		stateChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.opt4j.core.optimizer.OptimizerIterationListener#iterationComplete
	 * (org.opt4j.core.optimizer.Optimizer, int)
	 */
	@Override
	public void iterationComplete(Optimizer optimizer, int iteration) {
		stateChanged();
	}

	/**
	 * Calls the listeners that listen to the state of this task.
	 */
	private void stateChanged() {
		for (TaskStateListener listener : listeners) {
			listener.stateChanged(this);
		}
	}

}
