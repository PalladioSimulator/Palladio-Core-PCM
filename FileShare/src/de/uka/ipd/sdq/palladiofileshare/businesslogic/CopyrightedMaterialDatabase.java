package de.uka.ipd.sdq.palladiofileshare.businesslogic;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.palladiofileshare.businesslogic.util.Util;

public class CopyrightedMaterialDatabase {
		
	private static Logger logger = Logger.getLogger(CopyrightedMaterialDatabase.class);
	private static CopyrightedMaterialDatabase singleton;
	private static final int numberOfCopyrightedMaterials = 1000000;
	private static Set<Integer> copyrightedHashs;
	
	private CopyrightedMaterialDatabase() {
		logger.debug("Init CopyrightedMaterialDatabase start");
		copyrightedHashs = new HashSet<Integer>();
		copyrightedHashs = Util.initHashSetWithInteger(numberOfCopyrightedMaterials);
		logger.debug("Init CopyrightedMaterialDatabase end");
	}
	
	public static CopyrightedMaterialDatabase getSingleton() {
		if(singleton == null) {
			singleton = new CopyrightedMaterialDatabase();
		} 
		return singleton;		
	}

	public boolean isCopyrightedMaterial(byte[] hash) {	
		return copyrightedHashs.contains(Util.createIntegerHash(hash));		
	}
}
