package de.uka.ipd.sdq.palladiofileshare.businesslogic.storage;

public class StorageFile {
	private byte[] stream;
	private byte[] fileHash;

	public StorageFile(byte[] stream, byte[] fileHash) {
		this.stream = stream;
		this.fileHash = fileHash;
	}

	public byte[] getStream() {
		return stream;
	}

	public void setStream(byte[] stream) {
		this.stream = stream;
	}

	public byte[] getFileHash() {
		return fileHash;
	}

	public void setFileHash(byte[] fileHash) {
		this.fileHash = fileHash;
	}
}