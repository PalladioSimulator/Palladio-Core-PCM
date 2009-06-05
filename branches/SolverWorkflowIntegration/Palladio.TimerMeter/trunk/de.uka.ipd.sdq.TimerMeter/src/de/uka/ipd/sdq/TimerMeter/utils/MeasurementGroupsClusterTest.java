package de.uka.ipd.sdq.TimerMeter.utils;

public class MeasurementGroupsClusterTest {
	public static void main(String[] args){
		MeasurementGroupsClusterTest mgct = new MeasurementGroupsClusterTest();
		System.out.println("Testing result: "+mgct.test());
	}
	
	private boolean test(){
		MeasurementGroupsCluster mgc = new MeasurementGroupsCluster();
		mgc.addData(10L,11); //110
		mgc.addData(12L,12); //144+110=254
		mgc.addData(11L,13); //143+254=397
		mgc.addData(10L,14); //140+397=537
		System.out.println("Cluster: "+mgc);
		System.out.println("Cluster group size maximum: "+mgc.getClusterGroupSizeMaximum());
		System.out.println("Cluster group size mean: "+mgc.getClusterGroupSizeMean());
		System.out.println("Cluster group size median: "+mgc.getClusterGroupSizeMedian());
		System.out.println("Cluster group size minimum: "+mgc.getClusterGroupSizeMinimum());
		System.out.println("Cluster group size sum: "+mgc.getClusterGroupSizeSum());
		System.out.println("Cluster value maximum: "+mgc.getClusterValueMaximum());
		System.out.println("Cluster value mean: "+mgc.getClusterValueMean());
		System.out.println("Cluster value median: "+mgc.getClusterValueMedian());
		System.out.println("Cluster value minimum: "+mgc.getClusterValueMinimum());
		System.out.println("Cluster value sum: "+mgc.getClusterValueSum());

		if(        mgc.getClusterGroupSizeMaximum()==25
				&& new Double(mgc.getClusterGroupSizeMean()).equals(50D/3D)
				&& mgc.getClusterGroupSizeMedian()==13
				&& mgc.getClusterGroupSizeMinimum()==12
				&& mgc.getClusterGroupSizeSum()==50
				&& mgc.getClusterValueMaximum()==12L
				&& new Double(mgc.getClusterValueMean()).equals(537D/50D)
				&& (	new Double(mgc.getClusterValueMedian()).equals(10D)
					 || new Double(mgc.getClusterValueMedian()).equals(10.5D)
					 || new Double(mgc.getClusterValueMedian()).equals(11D))
				&& mgc.getClusterValueMinimum()==10
				&& mgc.getClusterValueSum()==537){
			return true;
		}else{
			return false;
		}
	}
}
