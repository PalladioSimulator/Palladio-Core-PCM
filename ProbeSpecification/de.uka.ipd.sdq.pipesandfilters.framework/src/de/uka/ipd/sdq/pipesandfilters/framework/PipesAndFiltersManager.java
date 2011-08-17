package de.uka.ipd.sdq.pipesandfilters.framework;

import java.util.Vector;

import de.uka.ipd.sdq.pipesandfilters.framework.exceptions.PipesAndFiltersException;

/**
 * 
 * A PipesAndFilterManager should be used to build and organize the pipes and
 * filters structure. Filters and Recorders can be added and connected. The
 * Manager will make sure that all pipe elements are connected in a valid way
 * and that data is transmitted correctly through the pipes.
 * 
 * @author Baum
 * 
 */

public class PipesAndFiltersManager {
	private Vector<PipeElement> elements = new Vector<PipeElement>();
	private PipeElement startElement;

	/**
	 * The constructor of the PipesAndFiltersManager. A first pipe element hast
	 * to be passed to the constructor and will be set as front element of the
	 * pipe.
	 * 
	 * @param startElement
	 *            An element of the pipes and filters structure. It will be set
	 *            as default start element.
	 */
	public PipesAndFiltersManager(PipeElement startElement) {
		elements.add(startElement);
		this.startElement = startElement;
	}

	/**
	 * Adds any pipe element to the pipes and filters structure.
	 * 
	 * @param e
	 *            The element to be added.
	 * @throws PipesAndFiltersException
	 */
	public void addElement(PipeElement e) throws PipesAndFiltersException {
		if (!elements.contains(e)) {
			elements.add(e);
		} else {
			throw new PipesAndFiltersException(
					"Pipe element has already been added before.");
		}
	}

	/**
	 * Adds a directed connection (pipe) from the element in the first argument
	 * to that one in the second argument. The method will check that neither
	 * the maximum out-degree of the first element nor the maximum in-degree of
	 * the second element are exceeded.
	 * 
	 * @param from
	 *            The element of the pipes and filters structure sending data
	 *            through this connection.
	 * @param to
	 *            The element of the pipes and filters structure receiving data
	 *            through this connection.
	 * @throws PipesAndFiltersException
	 */
	public void addConnection(PipeElement from, PipeElement to)
			throws PipesAndFiltersException {
		if (elements.contains(from) && elements.contains(to)) {
			if (from.outDegree + 1 > from.MAX_OUT_DEGREE) {
				throw new PipesAndFiltersException(
						"Elements cannot be connected because the element \"from\" has reached maximum number of outputs.");
			} else if (to.inDegree + 1 > to.MAX_IN_DEGREE) {
				throw new PipesAndFiltersException(
						"Elements cannot be connected because the element \"to\" has reached maximum number of inputs.");
			} else {
				from.outDegree++;
				to.inDegree++;
				from.addObserver(to);
			}
		} else {
			throw new RuntimeException(
					"At least one element has not been added to the Manager.");
		}
	}

	/**
	 * Sets the start element of the pipes and filters structure, i.e. the
	 * element the processed data is directly passed to.
	 * 
	 * @param e
	 *            The new start element of the pipes and filters structure.
	 */
	public void setStartElement(PipeElement e) {
		if (elements.contains(e)) {
			this.startElement = e;
		} else {
			throw new RuntimeException(
					"Element has not been added to the Manager.");
		}
	}

	/**
	 * Returns the start element of the filter chain.
	 * 
	 * @return The start element of the pipes and filters structure.
	 */
	public PipeElement getStartElement() {
		return startElement;
	}

	/**
	 * Initializes all pipe elements
	 * 
	 * @param metaData
	 *            The initializing meta data
	 */
	public void initialize(MetaDataInit metaData) {
		for (PipeElement e : elements) {
			e.initialize(metaData);
		}
	}

	/**
	 * Injects data into the pipes and filters structure. The data is passed to
	 * the start element.
	 * 
	 * @param data
	 *            The data to be processed by the pipes and filters.
	 */
	public void processData(PipeData data) {
		startElement.processData(data);
	}

	/**
	 * Tells all pipe elements to stop operating data.
	 */
	public void flush() {
		startElement.flush();
	}

}
