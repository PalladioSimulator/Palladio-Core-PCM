package de.uka.ipd.sdq.TimerMeter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

	class Timer{
		public static long timer(){
			return System.nanoTime();
		}
	}
public class QESTPaperCodeChecker {
	
	class Cluster{
		  long firstElement=-1, secondElement=-1;
		  int firstElementFrequency, secondElementFrequency;
		}
	public double timerMeter(//MK added
		int numberOfMeasurements, //MK added
		int numberOfWorkIncreaseSteps, //MK added
		int workIncreaseStepSize){ //MK added
		List<Long> results = new ArrayList<Long>();//MK 2 classes imported
		int i = 0; int k = 0;
		long globalVariable=0;  //public (globally visible) variable
		long start, finish, diff;     //for timer values
		int workAmount=0; // between timer invocations

		/*[...]*/ //perform warmup to trigger JITting of methods //MK wrapped in /* */

		// A. compute timer method invocation costs
		while(i<numberOfMeasurements){
		  start = Timer.timer();
		  finish = Timer.timer();
		  results.add(finish-start);
		  i++;
		}
		Collections.sort(results);
		int len = results.size();
		long minimumTimerInvocationCost = results.get(0);
		long medianTimerInvocationCost = results.get(len/2);
		long maximumTimerInvocationCost = results.get(len-1);
		Map<Long,Integer> frequencies; //MK imported
		frequencies = new TreeMap<Long,Integer>();
		/*[...]*/ //fill 'frequencies' Map using 'results' List //MK wrapped with /* */

		// B. further measurement data for computing accuracy
		while(k<numberOfWorkIncreaseSteps){
		  workAmount += workIncreaseStepSize;
		  i=0; 
		  while(i<numberOfMeasurements){
		    start = Timer.timer();
		    for(int a=0; a<workAmount; a++){
		      globalVariable++;
		    }
		    finish = Timer.timer();
		    diff = finish-start;
		    if(frequencies.containsKey(diff)){
		      /*[...]*/ //increase the frequency of value 'diff'//MK wrapped with /* */
		    }else{
		      frequencies.put(diff,1);// evaluated later
		    }
		    i++;
		  }
		  k++;
		}
		/*[...]*/ // read the global variable //MK wrapped with /* */

		// C. compute clusters from values/frequencies  
		List<Cluster> clusters = new ArrayList<Cluster>(); 
		Iterator<Long> iter = frequencies.keySet().iterator();
		long newValue;
		long currValue = iter.next();
		int currFreq = frequencies.get(currValue);
		Cluster currCluster = new Cluster();
		currCluster.firstElement = currValue;
		currCluster.firstElementFrequency = currFreq;
		boolean clusterOpen = true;
		while(iter.hasNext()){
		  newValue = iter.next();
		  if((newValue-currValue)>1){
		    if(clusterOpen) clusters.add(currCluster);
		    currCluster = new Cluster();
		    currCluster.firstElement = newValue;
		    currCluster.firstElementFrequency = 
		        frequencies.get(newValue);
		    clusterOpen = true;
		  }else{ 
		    if(clusterOpen){
		      currCluster.secondElement = newValue;
		      currCluster.secondElementFrequency = 
		          frequencies.get(newValue);
		      clusters.add(currCluster);
		      clusterOpen = false;
		    }else{
		      currCluster = new Cluster();
		      currCluster.firstElement = newValue;
		      currCluster.firstElementFrequency = 
		          frequencies.get(newValue);
		      clusterOpen = true;
		    }
		  }
		}    

		// D. compute accuracy from the first two clusters
//		    (this is a simplified view of the algorithm)
		Cluster clusterA = clusters.get(0);
		Cluster clusterB = clusters.get(1);
		double accuracy, clusterCenterA, clusterCenterB;
		if(clusterA.secondElement != -1){
		  clusterCenterA = (clusterA.firstElement+
		     clusterA.secondElement)/2;
		}else{clusterCenterA=clusterA.firstElement;}
		if(clusterB.secondElement != -1){
		  clusterCenterB = (clusterB.firstElement+
		     clusterB.secondElement)/2;
		}else{clusterCenterB=clusterB.firstElement;}
		accuracy = clusterCenterB - clusterCenterA;
		return accuracy; // MK not in the original algorithm
	}//added
}
