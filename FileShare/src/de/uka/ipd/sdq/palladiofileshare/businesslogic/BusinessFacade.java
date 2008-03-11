package de.uka.ipd.sdq.palladiofileshare.businesslogic;

import java.io.InputStream;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.palladiofileshare.businesslogic.storage.Storage;
import de.uka.ipd.sdq.palladiofileshare.businesslogic.storage.StorageFile;

public class BusinessFacade {
	
	public static Logger logger = Logger.getLogger("BusinessFacade");
	private CopyrightedMaterialDatabase copyDB;
	private Storage storageSubSystem;
	
	public BusinessFacade() {
		this.copyDB = new CopyrightedMaterialDatabase();
	}

	public void uploadFile(InputStream[] inputStream, FileType fileType) {
		byte[] fileHash;
		InputStream currentInputStream;
		
		for(int x = 0; x < inputStream.length; x++) {
			currentInputStream = inputStream[x];
			
			if(fileType != FileType.Archive)
			{
				compress(currentInputStream);
				fileHash = md5(currentInputStream);				
			} else {
				fileHash = md5(currentInputStream);
				compress(currentInputStream);
			}	
			
			if(isCopyrightedMaterial(fileHash)) {
				//reject file // do not store
			} else {
				storageSubSystem.storeFile(new StorageFile(null, fileHash));
			}
		}
	}
	
	private byte[] md5(InputStream inputStream) {		
		return null;
	}

	private void compress(InputStream inputStream) {
		
	}
	
	private boolean isCopyrightedMaterial(byte[] hash) {
		return this.copyDB.isCopyrightedMaterial(hash);		
	}
	

}
