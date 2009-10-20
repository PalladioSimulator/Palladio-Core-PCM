package de.uka.ipd.sdq.palladiofileshare.businesslogic.storage;

/**
 * @author Klaus Krogmann
 *
 */
public interface IStorage {

	public abstract long storeFile(
			byte[] stream, 
			byte[] fileHash, 
			boolean measure);

}