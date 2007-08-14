/**
 * 
 */
package de.uka.ipd.sdq.sensorfactory.dao.db4o;

import java.util.HashMap;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.io.CachedIoAdapter;
import com.db4o.io.RandomAccessFileAdapter;

import de.uka.ipd.sdq.sensorfactory.dao.db4o.entities.ExperimentRunImpl;
import de.uka.ipd.sdq.sensorfactory.dao.db4o.util.PersistedLinkedList;
import de.uka.ipd.sdq.sensorfactory.dao.db4o.util.PersistedLinkedListMarshaller;
import de.uka.ipd.sdq.sensorfactory.dao.db4o.util.PersistedLinkedListTranslator;
import de.uka.ipd.sdq.sensorfactory.entities.dao.IDAOFactory;
import de.uka.ipd.sdq.sensorfactory.entities.dao.IExperimentDAO;
import de.uka.ipd.sdq.sensorfactory.entities.dao.IExperimentRunDAO;
import de.uka.ipd.sdq.sensorfactory.entities.dao.IMeasurementDAO;
import de.uka.ipd.sdq.sensorfactory.entities.dao.ISensorDAO;
import de.uka.ipd.sdq.sensorfactory.entities.dao.IStateDAO;

/**
 * @author Snowball
 *
 */
public class DB4ODAOFactory implements IDAOFactory {

	private IExperimentDAO experimentDAO;
	private IExperimentRunDAO experimentRunDAO;
	private IMeasurementDAO measurementDAO;
	private ISensorDAO sensorDAO;
	private IStateDAO stateDAO;
	private String filename;
	private ObjectContainer db;
	private IDGenerator idGen;
	private long id;
	
	public static HashMap<ObjectContainer, IDAOFactory> factoryRegistry = new HashMap<ObjectContainer, IDAOFactory>();

	public DB4ODAOFactory(long id, String filename) {
		this.filename = filename;
		this.id = id;
		Db4o.configure().objectClass(ExperimentRunImpl.class).maximumActivationDepth(3);
		//Db4o.configure().objectClass(PersistedLinkedList.class).
		//	translate(new PersistedLinkedListTranslator());
		//Db4o.configure().objectClass(PersistedLinkedList.class).
		//	marshallWith(new PersistedLinkedListMarshaller());
		
		RandomAccessFileAdapter delegateAdapter = new RandomAccessFileAdapter();
		Db4o.configure().io(new CachedIoAdapter(delegateAdapter));		
		this.db=Db4o.openFile(filename);
		if (db.query(IDGenerator.class).size() > 0)
			idGen = db.query(IDGenerator.class).get(0);
		else
			idGen = new IDGenerator();
		this.factoryRegistry.put(db,this);
	}
	
	public DB4ODAOFactory(String result) {
		this(-1l,result);
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.sensorfactory.entities.dao.IDAOFactory#createExperimentDAO()
	 */
	public IExperimentDAO createExperimentDAO() {
		if (this.experimentDAO == null)
			this.experimentDAO = new DB4OExperimentDAO(this,db,idGen); 
		return this.experimentDAO;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.sensorfactory.entities.dao.IDAOFactory#createExperimentRunDAO()
	 */
	public IExperimentRunDAO createExperimentRunDAO() {
		if (this.experimentRunDAO == null)
			this.experimentRunDAO = new DB4OExperimentRunDAO(this,db,idGen); 
		return this.experimentRunDAO;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.sensorfactory.entities.dao.IDAOFactory#createMeasurementDAO()
	 */
	public IMeasurementDAO createMeasurementDAO() {
		if (this.measurementDAO == null)
			this.measurementDAO = new DB4OMeasurementDAO(this,db,idGen); 
		return this.measurementDAO;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.sensorfactory.entities.dao.IDAOFactory#createSensorDAO()
	 */
	public ISensorDAO createSensorDAO() {
		if (this.sensorDAO == null)
			this.sensorDAO = new DB4OSensorDAO(this,db,idGen);
		return this.sensorDAO;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.sensorfactory.entities.dao.IDAOFactory#createStateDAO()
	 */
	public IStateDAO createStateDAO() {
		if (this.stateDAO == null)
			this.stateDAO = new DB4OStateDAO(this,db,idGen); 
		return this.stateDAO;
	}

	public String getDescription() {
		return "A datasource based on the DB4O Object Data Base";
	}

	public String getFileName() {
		return "Object Database " + filename;
	}

	public String getName() {
		return "DB Datasource";
	}

	public void finalizeAndClose() {
		db.set(idGen);
		db.close();
	}

	public long getID() {
		return this.id;
	}

	public void setID(int i) {
		this.id = i;
	}

	public String getPersistendInfo() {
		return filename;
	}
}
