package de.uka.ipd.sdq.workflow;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;

public class ExecutionTimeLoggingProgressMonitor extends SubProgressMonitor {

	public ExecutionTimeLoggingProgressMonitor(IProgressMonitor monitor,
			int ticks) {
		super(monitor, ticks);
	}

	double startTime = 0;
	private String taskName;
	Logger logger = Logger.getLogger(ExecutionTimeLoggingProgressMonitor.class);
	private int totalWork;
	private int completedWork;

	/**
	 * @param name
	 * @param totalWork
	 * @see org.eclipse.core.runtime.IProgressMonitor#beginTask(java.lang.String, int)
	 */
	public void beginTask(String name, int totalWork) {
		this.startTime = System.nanoTime();
		this.taskName = name;
		this.totalWork = totalWork;
		this.completedWork = 0;
		super.beginTask(name, totalWork);
	}

	/**
	 * 
	 * @see org.eclipse.core.runtime.IProgressMonitor#done()
	 */
	public void done() {
		double endTime = System.nanoTime();
		super.done();
		logger.info("Task "+taskName+" completed in "+(endTime-startTime)/Math.pow(10, 9)+" seconds");
	}

	/**
	 * @param work
	 * @see org.eclipse.core.runtime.IProgressMonitor#internalWorked(double)
	 */
	public void internalWorked(double work) {
		super.internalWorked(work);
	}

	/**
	 * @return
	 * @see org.eclipse.core.runtime.IProgressMonitor#isCanceled()
	 */
	public boolean isCanceled() {
		return super.isCanceled();
	}

	/**
	 * @param value
	 * @see org.eclipse.core.runtime.IProgressMonitor#setCanceled(boolean)
	 */
	public void setCanceled(boolean value) {
		super.setCanceled(value);
	}

	/**
	 * @param name
	 * @see org.eclipse.core.runtime.IProgressMonitor#setTaskName(java.lang.String)
	 */
	public void setTaskName(String name) {
		taskName=name;
		super.setTaskName(name);
	}

	/**
	 * @param name
	 * @see org.eclipse.core.runtime.IProgressMonitor#subTask(java.lang.String)
	 */
	public void subTask(String name) {
		super.subTask(name);
	}

	/**
	 * @param work
	 * @see org.eclipse.core.runtime.IProgressMonitor#worked(int)
	 */
	public void worked(int work) {
		super.worked(work);
	}

}
