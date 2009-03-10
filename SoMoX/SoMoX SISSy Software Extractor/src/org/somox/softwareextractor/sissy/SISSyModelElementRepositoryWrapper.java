package org.somox.softwareextractor.sissy;

import org.somox.extractor.ArtifactWrapper;

import de.fzi.sissy.metamod.ModelElementRepository;

/**
 * Wrapper for the SISSy Model Element Repository as a result of a software extraction
 *
 * @author Benjamin Klatt
 *
 */
public class SISSyModelElementRepositoryWrapper implements ArtifactWrapper {

	// ---------------------------------
	// Static Data Fields
	// ---------------------------------

	/** The static counter for the elements */
	private static int elementCounter = 0;

	// ---------------------------------
	// Data fields
	// ---------------------------------

	/** The id to identify the extractor that has produced this artifact */
	private String extractorId = null;

	/** The identifier for the artifact itself */
	private String elementId = null;

	/** The wrapped model element repository */
	private ModelElementRepository modelElementRepository = null;

	// ---------------------------------
	// Constructor
	// ---------------------------------

	/**
	 * @return the modelElementRepository
	 */
	public ModelElementRepository getModelElementRepository() {
		return modelElementRepository;
	}

	/**
	 * Constructor requiring
	 * @param extractorId				The identifier for the software extractor
	 * @param modelElementRepository	The model repository to wrap
	 */
	public SISSyModelElementRepositoryWrapper(	String extractorId,
												ModelElementRepository modelElementRepository) {
		this.extractorId = extractorId;
		this.elementId = SISSyModelElementRepositoryWrapper.getUniqueElementId();
		this.modelElementRepository = modelElementRepository;
	}

	// ---------------------------------
	// Business Methods
	// ---------------------------------

	// ---------------------------------
	// Helper Methods
	// ---------------------------------

	/**
	 * Get a unique id for this element
	 * @return	A unique element id
	 */
	private static synchronized String getUniqueElementId(){
		return new String(""+(elementCounter++));
	}

	// ---------------------------------
	// Getters / Setters
	// ---------------------------------

	@Override
	public Object getArtefact() {
		return this.modelElementRepository;
	}

	@Override
	public String getExtractorId() {
		return this.extractorId;
	}

	@Override
	public String getId() {
		return this.elementId;
	}
}
