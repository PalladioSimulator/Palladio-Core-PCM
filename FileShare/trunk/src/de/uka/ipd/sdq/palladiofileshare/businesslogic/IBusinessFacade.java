package de.uka.ipd.sdq.palladiofileshare.businesslogic;

/**
 * @author Klaus Krogmann
 *
 */
public interface IBusinessFacade {
	public abstract void uploadFiles(
			long uploadId,
			byte[][] inputFiles, 
			String[] inputFileIds, 
			int[] fileTypes,
			boolean measure,
			boolean monitor);
}