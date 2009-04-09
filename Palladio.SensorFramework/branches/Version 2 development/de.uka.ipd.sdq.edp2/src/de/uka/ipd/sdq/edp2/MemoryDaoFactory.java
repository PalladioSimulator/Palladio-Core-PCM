package de.uka.ipd.sdq.edp2;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MemoryDaoFactory implements DaoFactory {
	/** Logger for this class. */
	private static final Logger logger = Logger.getLogger(MemoryDaoFactory.class.getCanonicalName());
	
	/** Map containing the existing MemoryDaoFactories. */
	
	public static ConcurrentMap<String, DaoFactory> existingMemoryDaoFactories =  
		new ConcurrentHashMap<String, DaoFactory>(); 

	/** Domain which is handled by this instance of the memory dao factory. */
	private String domain = null;

	public MemoryDaoFactory(String domain) {
		if (existingMemoryDaoFactories.containsKey(domain)) {
			logger.log(Level.SEVERE, "There is already an existing MemoryDaoFactory instance for " 
					+ domain + ".");
			throw new IllegalArgumentException();
		} else {
			existingMemoryDaoFactories.put(domain, this);
		}
		this.domain = domain;
	}
	
	@Override
	public BinaryMeasurementsDao<Double> createDoubleMeasurementsDao(String uuid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExperimentGroupDao createExperimentGroupDao(String uuid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JScienceXmlMeasurementsDao createJScienceXmlMeasurementsDao(
			String uuid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BinaryMeasurementsDao<Long> createLongMeasurementsDao(String uuid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NominalMeasurementsDao createNominalMeasurementsDao(String uuid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DaoRegistry getDaoRegistry() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DescriptionsDao createDescriptionsDao(String uuid) {
		// TODO Auto-generated method stub
		return null;
	}

}
