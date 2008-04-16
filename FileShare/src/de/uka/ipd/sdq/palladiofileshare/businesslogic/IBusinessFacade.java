package de.uka.ipd.sdq.palladiofileshare.businesslogic;

/**
 * @author Klaus Krogmann
 *
 */
public interface IBusinessFacade {
	public abstract void uploadFiles(
			long uploadId,
			byte[][] inputFiles, 
			int[] fileTypes,
			boolean measure);
}