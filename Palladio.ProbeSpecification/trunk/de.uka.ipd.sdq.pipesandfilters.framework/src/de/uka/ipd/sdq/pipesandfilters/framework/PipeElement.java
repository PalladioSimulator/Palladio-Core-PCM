package de.uka.ipd.sdq.pipesandfilters.framework;

import java.util.Observable;
import java.util.Observer;

/**
 * This abstract class is the super class of any elements the pipe may consist
 * of, namely any filters or and recorders.
 * 
 * @author Baum
 * 
 */
public abstract class PipeElement extends Observable implements Observer {

	protected final int MAX_IN_DEGREE;
	protected final int MAX_OUT_DEGREE;
	protected int inDegree = 0;
	protected int outDegree = 0;

	/**
	 * The Constructor of a pipe element.
	 * 
	 * @param MAX_IN_DEGREE
	 *            The maximum in degree (i.e. the maximum number of
	 *            predecessors) of the pipe element in the filter chain.
	 * @param MAX_OUT_DEGREE
	 *            The maximum out degree (i.e. the maximum number of successors)
	 *            of the pipe element in the filter chain.
	 */
	protected PipeElement(int MAX_IN_DEGREE, int MAX_OUT_DEGREE) {
		this.MAX_IN_DEGREE = MAX_IN_DEGREE;
		this.MAX_OUT_DEGREE = MAX_OUT_DEGREE;
	}

	/**
	 * This method should be called once at the start of the experiment to
	 * initialize the pipe. Filters are responsible of forwarding the passed
	 * parameter to their successive pipe element.
	 * 
	 * @param metaData
	 *            The initializing meta data.
	 */
	protected abstract void initialize(MetaDataInit metaData);

	/**
	 * This method notifies a pipe element of the end of the current experiment
	 * run. A pipe element may need this notification to perform terminal
	 * operations. Filters are responsible of forwarding the method call to
	 * their successive pipe elements.
	 * 
	 */
	protected abstract void flush();

	/**
	 * The actual task of a pipe element during an experiment run is called via
	 * this method. Filters are responsible of forwarding the data to their
	 * successive pipe element.
	 * 
	 * @param data
	 *            The measured data to be handled by the pipe element.
	 */
	protected abstract void processData(final PipeData data);

	/**
	 * Forwards data to all successive elements.
	 * 
	 * @param data
	 *            The data to be forwarded.
	 */
	protected void forwardData(PipeData data) {
		setChanged();
		notifyObservers(data);
	}

	/**
	 * Forwards the notification to flush to all successive elements.
	 */
	protected void forwardFlush() {
		setChanged();
		notifyObservers("flush");
	}

	/**
	 * On update, the incoming Object is checked. If it contains a data element,
	 * the data is processed. If it contains a String holding a flush command,
	 * the flush method is called.
	 */
	@Override
	public void update(Observable o, Object arg) {
		if (arg instanceof PipeData) {
			processData((PipeData) arg);
		} else if (arg instanceof String && arg.equals("flush")) {
			flush();
		}
	}
}
