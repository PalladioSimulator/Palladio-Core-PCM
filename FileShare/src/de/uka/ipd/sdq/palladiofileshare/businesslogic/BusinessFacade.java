package de.uka.ipd.sdq.palladiofileshare.businesslogic;

import java.io.InputStream;

public class BusinessFacade {
	
	private CopyrightedMaterialDatabase copyDB;
	
	public BusinessFacade() {
		this.copyDB = new CopyrightedMaterialDatabase();
	}

	public void uploadFile(InputStream[] inputStream, FileType fileType) {
		byte[] fileHash;
		
		if(fileType != FileType.Archive)
		{
			compress(null);
			fileHash = md5(null);
			
		} else {
			fileHash = md5(null);
			compress(null);
		}	
		
		if(isCopyrightedMaterial(fileHash)) {
			//reject file // do not store
		} else {
			//store file
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
