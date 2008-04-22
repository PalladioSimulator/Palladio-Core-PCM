package de.uka.ipd.sdq.palladiofileshare.businesslogic;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.palladiofileshare.businesslogic.util.Util;

/**
 * @author Klaus Krogmann
 *
 */
public class CopyrightedMaterialDatabase {
		
	private static Set<Integer> copyrightedHashs;
	private static Logger logger = Logger.getLogger(CopyrightedMaterialDatabase.class);
	private static final int numberOfCopyrightedMaterials = 10*1000;
	private static CopyrightedMaterialDatabase singleton;
	
	public static CopyrightedMaterialDatabase getSingleton() {
		if(singleton == null) {
			singleton = new CopyrightedMaterialDatabase();
		} 
		return singleton;		
	}
	
	private CopyrightedMaterialDatabase() {
		logger.debug("Init CopyrightedMaterialDatabase start");
		copyrightedHashs = new HashSet<Integer>();
		copyrightedHashs = Util.initHashSetWithInteger(numberOfCopyrightedMaterials);
		logger.debug("Init CopyrightedMaterialDatabase end");
	}

	public boolean isCopyrightedMaterial(byte[] hash) {	
		return copyrightedHashs.contains(Util.createIntegerHash(hash));		
	}
}
