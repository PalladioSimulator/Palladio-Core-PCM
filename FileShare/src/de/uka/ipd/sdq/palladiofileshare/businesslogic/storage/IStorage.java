package de.uka.ipd.sdq.palladiofileshare.businesslogic.storage;

public interface IStorage {

	public abstract void storeFile(byte[] stream, byte[] fileHash);

}