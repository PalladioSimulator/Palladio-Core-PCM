package mediastorerepository.impl;

import java.util.Date;

import de.uka.ipd.sdq.sensorframework.SensorFrameworkDataset;
import de.uka.ipd.sdq.sensorframework.dao.file.FileDAOFactory;
import de.uka.ipd.sdq.sensorframework.entities.Experiment;
import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;
import mediarepository.entities.DBID3v1;

public class WebGUI implements mediastorerepository.impl.IWebGUI {
	
	private static final double SECONDS_SCALE = Math.pow(10, 9);
	private static final int maxCount = 20000;
	static SensorFrameworkDataset dataset = SensorFrameworkDataset.singleton();
	private static IDAOFactory daoFactory;
	private static Experiment exp;
	private static TimeSpanSensor tss;
	private static ExperimentRun expRun;
	
	static {
		daoFactory = new FileDAOFactory("C:/temp/data");
		exp = daoFactory.createExperimentDAO().addExperiment("Server");
		expRun = daoFactory.createExperimentRunDAO().addExperimentRun(new Date().toString());
		exp.addExperimentRun(expRun);
		tss = exp.addTimeSpanSensor("Overall RT");
	}
	
    protected mediastorerepository.impl.ports.IHTTP_WebGUI m_portIHTTP = new mediastorerepository.impl.ports.IHTTP_WebGUI(this);
    protected mediastorerepository.impl.contexts.IWebGUIContext myContext = null;
	private static boolean saved = false;
	private static int count = 0;

    public mediastorerepository.IHTTP getPortIHTTP() {
        return m_portIHTTP;
    }

    public void setContext(
        mediastorerepository.impl.contexts.IWebGUIContext myContext) {
        this.myContext = myContext;
    }

    public byte[][] iHTTP_downloadHTTP(int[] desiredFiles) {
        /*PROTECTED REGION ID(downloadHTTP__RLTSs6YFEduWZfldHy3B1Q__O42SdKYGEduWZfldHy3B1Q) ENABLED START*/
        byte[][]result = myContext.getRoleIMediaStore().downloadFromDB(desiredFiles);

    	return result;
        /*PROTECTED REGION END*/
    }

    public byte[][] iHTTP_queryFileByField(String queryString, int fieldID) {
        /*PROTECTED REGION ID(queryFileByField__RLTSs6YFEduWZfldHy3B1Q__O42SdKYGEduWZfldHy3B1Q) ENABLED START*/
    	byte[][] result = myContext.getRoleIMediaStore()
                        .queryAndGetFromDB(queryString, fieldID);
    	return result;
        /*PROTECTED REGION END*/
    }

	@Override
	public DBID3v1[] iHTTP_queryID3(int[] id) {
		return myContext.getRoleIMediaStore().queryID3(id);
//		long start = System.nanoTime();
//		DBID3v1[] result = myContext.getRoleIMediaStore().queryID3(id);
//		long end = System.nanoTime();
//		if (count  < maxCount){
//			expRun.addTimeSpanMeasurement(tss, System.nanoTime(), (end-start)/SECONDS_SCALE);
//			count++;
//		} else {
//			if (!saved ){
//				daoFactory.createExperimentDAO().store(exp);
//				daoFactory.finalizeAndClose();
//				saved = true;
//			}
//		}
//		//System.out.println(end-start);
//		return result;
	}
}
