package de.uka.ipd.sdq.palladiofileshare.businesslogic;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.palladiofileshare.businesslogic.util.Util;

public class CopyrightedMaterialDatabase {
		
	private static Logger logger = Logger.getLogger(CopyrightedMaterialDatabase.class);
	private static CopyrightedMaterialDatabase singleton;
	private static final int numberOfCopyrightedMaterials = 100000;
	private Set<byte[]> copyrightedHashs;
	
	private CopyrightedMaterialDatabase() {
		logger.debug("Init CopyrightedMaterialDatabase start");
		this.copyrightedHashs = new HashSet<byte[]>();
		copyrightedHashs = Util.initHashSetWithHashs(numberOfCopyrightedMaterials);
		logger.debug("Init CopyrightedMaterialDatabase end");
	}
	
	public static CopyrightedMaterialDatabase getSingleton() {
		if(singleton == null) {
			singleton = new CopyrightedMaterialDatabase();
		} 
		return singleton;		
	}

	public boolean isCopyrightedMaterial(byte[] hash) {	
		return this.copyrightedHashs.contains(hash);		
	}
}
