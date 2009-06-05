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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.google.inject.Inject;
import com.google.inject.Module;
import com.google.inject.Provider;
import com.google.inject.Singleton;

/**
 * The {@code ExecutionEnvironment} for {@code Tasks}. The environment starts
 * and monitors {@code Tasks}. {@code Tasks} are not submitted directly, instead
 * a collection of {@code Modules} is submitted and a {@code Task} is created.
 * The {@code ExecutionEnvironment} is processing the {@code Tasks}
 * sequentially.
 * 
 * @author lukasiewycz
 * @see Task
 * 
 */
@Singleton
public class ExecutionEnvironment implements TaskStateListener {

	protected final Provider<Task> taskProvider;

	protected final ExecutorService executor;

	protected List<Task> tasks = new ArrayList<Task>();

	protected Set<TaskListener> listeners = new CopyOnWriteArraySet<TaskListener>();

	/**
	 * Constructs a {@code ExecutionEnvironment}
	 * 
	 * @param taskProvider
	 *            the task provider
	 */
	@Inject
	public ExecutionEnvironment(Provider<Task> taskProvider) {
		this.taskProvider = taskProvider;
		this.executor = Executors.newFixedThreadPool(1);
	}

	/**
	 * Executes the specified modules: A {@code Task} is created and submitted.
	 * 
	 * @param modules
	 *            the collection of modules for a {@code Task}
	 */
	public void execute(Collection<Module> modules) {

		final Task task = taskProvider.get();
		task.addStateListener(this);
		task.init(modules);

		addTask(task);

		Thread thread = new Thread() {
			@Override
			public void run() {
				Future<Void> future = executor.submit(task);
				try {
					future.get();
				} catch (InterruptedException e) {
				} catch (ExecutionException e) {
				}
			}
		};
		thread.start();
	}

	/**
	 * Adds a {@code Tasks} and calls the listeners.
	 * 
	 * @param task
	 *            the task to add
	 */
	protected void addTask(final Task task) {
		tasks.add(task);
		for (TaskListener listener : listeners) {
			listener.added(task);
		}
	}

	/**
	 * Adds a {@code TaskListener}.
	 * 
	 * @param listener
	 *            the listener to be added
	 */
	public void addListener(TaskListener listener) {
		listeners.add(listener);
	}

	/**
	 * Removes a {@code TaskListener}.
	 * 
	 * @param listener
	 *            the listener to be removed
	 */
	public void removeListener(TaskListener listener) {
		listeners.remove(listener);
	}

	/**
	 * Returns the list of all {@code Tasks}.
	 * 
	 * @return the list of all {@code Tasks}
	 */
	public List<Task> getTasks() {
		return tasks;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.opt4j.config.TaskStateListener#stateChanged(org.opt4j.config.Task)
	 */
	public void stateChanged(Task task) {
		for (TaskListener listener : listeners) {
			listener.stateChanged(task);
		}
	}

}
