package de.uka.ipd.sdq.TimerMeter.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * TODO make this a unit test
 * @author Michael
 *
 */
public class CommonUtilitiesTest {
	
	public static void main(String[] args){
		CommonUtilitiesTest cute = new CommonUtilitiesTest();
//		BasicConfigurator.configure();
		System.out.println("Addition test: "+cute.testAddition());
		System.out.println("Accuracy computation test: "+cute.testGetAccuracyFromClusters());
	}

	/**
	 * The logger instance (log4j) as a supplement to <code>e</code> and <code>o</code>.
	 */
	private Logger logger;
	
	public CommonUtilitiesTest() {
		super();
		logger = Logger.getLogger(this.getClass().getCanonicalName());
	}
	
	private boolean testAddition(){
		Map<Integer,Double> src = new HashMap<Integer, Double>();
		Map<Integer,Double> dst = new HashMap<Integer, Double>();
		src.put(0,1d);
		src.put(1,2d);
		
		dst.put(1,3d);//note the different addition order!
		dst.put(0,4d);//note the different addition order!
		
		Map<Integer,Double> res = CommonUtilities.addSameKeyedMaps(5,src,6,dst);
		System.out.println("res: "+res);
		if(res.get(0).equals(29D) && res.get(1).equals(28D)){//note that the "D" suffix is needed, as .equals(29) returns false...
			return true; 
		}else{
			return false;
		}
	}
	
	private boolean testGetAccuracyFromClusters(){
		MeasurementGroupsCluster mgc1 = new MeasurementGroupsCluster(100L,1);
		MeasurementGroupsCluster mgc2 = new MeasurementGroupsCluster(201L,2);
		MeasurementGroupsCluster mgc3 = new MeasurementGroupsCluster(300L,3);
		mgc3.addData(301L,4);
		MeasurementGroupsCluster mgc4 = new MeasurementGroupsCluster(400L,5);
		mgc4.addData(401L,6);
		List<MeasurementGroupsCluster> list = new ArrayList<MeasurementGroupsCluster>();
		list.add(mgc1); list.add(mgc2); list.add(mgc3); list.add(mgc4);
		long computed = CommonUtilities.computeAccuracyFromClusters(list, true);
		long expected = 100;
		if(computed == expected){
			return true;
		}else{
			logger.error("Computed="+computed+", expected="+expected+".");
			return false;
		}
	}
}
