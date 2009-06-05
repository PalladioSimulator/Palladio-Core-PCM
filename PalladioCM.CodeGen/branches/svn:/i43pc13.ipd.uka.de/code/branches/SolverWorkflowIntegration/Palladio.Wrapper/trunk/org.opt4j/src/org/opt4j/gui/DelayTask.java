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
package org.opt4j.gui;

/**
 * The {@code DelayTask} executes tasks immediately or delayed if they arrive
 * too close (delay). If they arrive way too close, some tasks will be dropped.
 * 
 * @author lukasiewycz, reimann
 * 
 */
public class DelayTask {

	private final long delay;
	private DelayThread thread = null;
	Thread task = null;

	private class DelayThread extends Thread {
		@Override
		public void run() {
			while (getTask() != null) {
				getTaskAndSetToNull().start();
				try {
					sleep(delay);
				} catch (InterruptedException e) {
				}
			}
		}
	}

	/**
	 * Constructs a {@code DelayTask}.
	 * 
	 * @param delay
	 *            the minimum delay between two tasks
	 */
	public DelayTask(long delay) {
		super();
		assert (delay >= 0);
		this.delay = delay;
	}

	/**
	 * Executes the task.
	 * 
	 * @param task
	 *            the task to be executed
	 */
	public synchronized void execute(final Thread task) {
		if (thread == null || !thread.isAlive()) {
			updateTask(task);
			thread = new DelayThread();
			thread.start();
		} else {
			updateTask(task);
		}
	}

	/**
	 * Synchronized update of the task.
	 * 
	 * @param task
	 *            the task to execute
	 */
	protected synchronized void updateTask(Thread task) {
		this.task = task;
	}

	/**
	 * Synchronized getter for the task.
	 * 
	 * @return the task
	 */
	protected synchronized Thread getTask() {
		return task;
	}

	/**
	 * Synchronized getter for the task that sets the task to {@code null}.
	 * 
	 * @return the task
	 */
	protected synchronized Thread getTaskAndSetToNull() {
		Thread t = task;
		task = null;
		return t;
	}

}
