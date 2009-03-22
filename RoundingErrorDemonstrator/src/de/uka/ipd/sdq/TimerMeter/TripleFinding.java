package de.uka.ipd.sdq.TimerMeter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import de.uka.ipd.sdq.TimerMeter.util.ComparableDistanceTuplesKeyValuePair;
import de.uka.ipd.sdq.TimerMeter.util.ComparableTriplesKey;
import de.uka.ipd.sdq.TimerMeter.util.ComparableValueTriplesKeyValuePair;


public class TripleFinding {
	public static void main(String[] args){
		
		TripleFinding ofn = new TripleFinding();
//		ofn.testCastingAndRoundingInJava();
//		ofn.testTripleDetectionInDistances();
		boolean verboseLogging = false;
		ofn.run(verboseLogging);
	}
	
	private void printInitialResults(
			boolean verbose, 
			List<Long[]> triples_values,
			List<Long[]> tuples_distances, 
			List<Double> accuracies_values,
			List<Double> accuracies_distances) {
		Long[] longs;
		Iterator<Double> iterAccuracies_distances = accuracies_distances.iterator();
		Iterator<Double> iterAccuracies_values = accuracies_values.iterator();
		Iterator<Long[]> iterTuples_distances = tuples_distances.iterator();
		Iterator<Long[]> iterTriples_values = triples_values.iterator();
		int i=0;
		Double accur = 0D;
//		TODO record actual double resolutions:
		for (; iterTriples_values.hasNext();) {
			longs = iterTriples_values.next();
			accur = iterAccuracies_values.next();
			if(longs==null 
					|| longs[0]==null
					|| longs[1]==null
					|| longs[2]==null
					|| longs[0].equals(0)
					|| longs[1].equals(0)
					|| longs[2].equals(0)
					){
				if(verbose) System.out.println("No triple for accuracy "+accur+" at position "+i);
			}else{
				System.out.println("Triple at for accuracy "+accur+" position "+i+": "+Arrays.toString(longs));
			}
			i++;
		}
		i=0;
//		TODO record actual double resolutions:
		for (; iterTuples_distances.hasNext();) {
			longs = iterTuples_distances.next();
			accur = iterAccuracies_distances.next();
			if(longs==null 
					|| longs[0]==null
					|| longs[1]==null
//					|| longs[2]==null
					|| longs[0].equals(0)
					|| longs[1].equals(0)
//					|| longs[2].equals(0)
					){
				if(verbose) System.out.println("Expensive distance computation: " +
						"No triple for accuracy "+accur+" at position "+i);
			}else{
				System.out.println("Expensive distance computation: " +
						"Triple at for accuracy "+accur+" position "+i+": "+Arrays.toString(longs));
			}
			i++;
		}
	}

	/**
	 * TODO use full power of returned {@link ComparableValueTriplesKeyValuePair}, incl. index
	 * @param verbose
	 */
	public void run(boolean verbose){
		final double startingTimerAccuracyIncl = 1.40D;
		final double endingTimerAccuracyExcl   = 2.10D;
		final double timerAccuracyIncrease     = 0.05D;
		final int nrOfVielfaches               = 1000;
		
		double timerAccuracy=startingTimerAccuracyIncl;
		
		//KEY:{accuracy,tripleLocationType,tripleLocation}, VALUE: triple (or null if none found)
		//example: <{1.49,0/*0 means "in values"; use 1 for "in distances"*/,0 /*means at the first location*/},{1,2,3}> 
//		SortedMap<ComparableTriplesKey,Long[]> totalTriples = new TreeMap<ComparableTriplesKey,Long[]>();
		
		List<Long[]> triples_values = new ArrayList<Long[]>();
		List<Long[]> tuples_distances = new ArrayList<Long[]>();
		List<Double> accuracies_values = new ArrayList<Double>();
		List<Double> accuracies_distances = new ArrayList<Double>();
		SortedSet<Long> set = null;
		Long[] longs;
		ComparableTriplesKey totalTriplesKey;
		while(timerAccuracy < endingTimerAccuracyExcl){
			totalTriplesKey = new ComparableTriplesKey();
			totalTriplesKey.setAccuracy(timerAccuracy);
			
			set = new TreeSet<Long>();
			longs = this.searchForTriplesInValues(true, timerAccuracy, nrOfVielfaches, false, set).getTriple();//TODO use index!
			triples_values.add(longs);
			accuracies_values.add(timerAccuracy);
			if(longs==null 
					|| longs[0]==null
					|| longs[1]==null
					|| longs[2]==null
					|| longs[0].equals(0)
					|| longs[1].equals(0)
					|| longs[2].equals(0)
					){
				longs = searchForTuplesInDistances(timerAccuracy,set,true).getTuple();//TODO use index!
				tuples_distances.add(longs);
				accuracies_distances.add(timerAccuracy);
				if(longs==null 
						|| longs[0]==null
						|| longs[1]==null
						|| longs[2]==null
						|| longs[0].equals(0)
						|| longs[1].equals(0)
						|| longs[2].equals(0)
						){
					if(verbose) System.out.println("Expensive distance computation: No triple for accuracy "+timerAccuracy);
				}else{
					totalTriplesKey.setFromDistancesNotFromValues(true);
				}
			}else{
				totalTriplesKey.setFromDistancesNotFromValues(false);
			}
			//TODO 
			//totalTriplesKey.setIndexOfTriple(-1);
//TODO			if(longs!=null){
//TODO				totalTriples.put(totalTriplesKey, longs);
//TODO			}
			
			timerAccuracy+=timerAccuracyIncrease;
//			if(set!= null && set.size()>0){System.out.println("Set size: "+set.size());}
		}
		printInitialResults(verbose, triples_values, tuples_distances, accuracies_values,accuracies_distances);
		
//TODO		Iterator<ComparableTriplesKey> totalTriplesKeysIter = totalTriples.keySet().iterator();
//TODO		Long[] totalTriplesValue;
//TODO		while(totalTriplesKeysIter.hasNext()){
//TODO			totalTriplesKey = totalTriplesKeysIter.next();
//TODO			totalTriplesValue = totalTriples.get(totalTriplesKey);
//TODO			System.out.println(totalTriplesKey+": "+Arrays.toString(totalTriplesValue));
//TODO		}
	}

	/**
	 * TODO insert GC trigger
	 * @param accuracy
	 * @param setOfValues set of values for which distances are computed; must be non-null and of length 3 or greater
	 * @param searchImmediateDistancesOnly
	 * @return the found triple (with metadata), or null if non found
	 */
	public ComparableDistanceTuplesKeyValuePair searchForTuplesInDistances(
			Double accuracy,
			SortedSet<Long> setOfValues,
			boolean searchImmediateDistancesOnly) {
		if(setOfValues==null || setOfValues.size()<3){
			System.out.println("Input parameter null or too short (<3 elements)");
			return null;
		}
		Long[] setAsArray = setOfValues.toArray(new Long[]{});
		SortedSet<Long> distances = new TreeSet<Long>();
		int added=0;
		if(searchImmediateDistancesOnly){
			for(int i=0; i<setOfValues.size()-1;i++){
				if(distances.add(setAsArray[i+1]-setAsArray[i])) added++; //TODO estimate the number of distances?
			}
		}else{
			for(int i=0; i<setOfValues.size()-1;i++){
				for(int j=i+1; j<setOfValues.size(); j++){
					if(distances.add(setAsArray[j]-setAsArray[i])) added++; //TODO estimate the number of distances?
				}
			}
		}
		Long[] retTuple = null;
		Iterator<Long> iterator = distances.iterator();
		Long a=0L;
		Long b=0L;
//		int indexOfTuple = -1;
		boolean tripleFound = false;
		if(iterator.hasNext()){
			a=iterator.next();
			if(iterator.hasNext()){
//				int idx=0;
				b=iterator.next();

				do {
					if(a+1==b/* && b+1==c*/){
						tripleFound=true;
						retTuple = new Long[]{a,b};//TODO fixme: two distances 
//						indexOfTriple = idx;
					}
					a=b;
					b=iterator.next();
//					idx++;
				}while(iterator.hasNext() && !tripleFound);
			}else{
				System.err.println("Only 1 distance - not enough for searching for tuples");
			}
		}else{
			System.err.println("0 distances - not enough for searching for tuples");
		}
			
		ComparableDistanceTuplesKeyValuePair ctkvp = new ComparableDistanceTuplesKeyValuePair();
		ctkvp.setAccuracy(accuracy);
//		ctkvp.setFromDistancesNotFromValues(true);
//		ctkvp.setIndexOfTriple(indexOfTriple);
//		ctkvp.setTriple(retTriple);
		if(tripleFound){
			ctkvp.setFirstDistance(retTuple[0]);
			ctkvp.setSecondDistance(retTuple[1]);
		}else{
			ctkvp.setFirstDistance(Long.MIN_VALUE);
			ctkvp.setSecondDistance(Long.MIN_VALUE);
		}
		return ctkvp;
	}
	
	/**
	 * @param roundInsteadOfTruncating
	 * @param timerAccuracy
	 * @param numberOfVielfaches
	 * @param verboseLogging
	 * @param setOfCreatedValues
	 * @return found triple (with metadata), or null if none found
	 */
	public ComparableValueTriplesKeyValuePair searchForTriplesInValues(
			boolean roundInsteadOfTruncating,
			double timerAccuracy, 
			int numberOfVielfaches,
			boolean verboseLogging,
			SortedSet<Long> setOfCreatedValues){
		System.out.println("Starting with accuracy "+timerAccuracy+", " +
				"computing "+numberOfVielfaches+" Vielfaches");
		final double s;
		if(timerAccuracy<=0D){
			System.err.println("Timer accuracy below or equal to zero not supported.");
			return null;
		}else{
			s=timerAccuracy;
		}
		if(numberOfVielfaches<=0){
			System.err.println("numberOfVielfaches below or equal to zero not supported.");
			return null;
		}
		
		//note that here, assignment is already prepared for shifting in the loop
		Double a;//smallest
		Double b=1*s;//middle
		Double c=2*s;//largest
		Long j;
		Long k;
		Long l;
		if(roundInsteadOfTruncating){
			k =Math.round(b);
		}else{
			k =b.longValue();
		}
		if(roundInsteadOfTruncating){
			l =Math.round(c);
		}else{
			l =c.longValue();
		}
		setOfCreatedValues.add(k);
		setOfCreatedValues.add(l);
		
		boolean tripleFound = false;
		Long[] triple = null;
		int i=0; 
		int idx=-1;
		while(i<numberOfVielfaches && !tripleFound){
			a=b;
			b=c;
			c=c+s;
			j=new Long(k);
			k=new Long(l);
			if(roundInsteadOfTruncating){
				l = new Long(Math.round(c));
			}else{
				l = new Long(c.longValue());
			}
			setOfCreatedValues.add(l);
			if(verboseLogging){
				System.out.println("" +
						"a="+a+", b="+b+", c="+c+"; " +
						"j="+j+", k="+k+", l="+l+"; " +
						"i="+i+".");
			}
			if(j+1==k && k+1==l){
				tripleFound = true;
				triple = new Long[]{j,k,l};
				idx = i;
			}
			i++;
		}
		if(verboseLogging) System.out.println("Triple: "+Arrays.toString(triple)+", set size: "+setOfCreatedValues.size()+".");
		ComparableValueTriplesKeyValuePair ctkvp = new ComparableValueTriplesKeyValuePair();
		ctkvp.setAccuracy(timerAccuracy);
//		ctkvp.setFromDistancesNotFromValues(false);
		ctkvp.setIndexOfTriple(idx);
		ctkvp.setTriple(triple);
		return ctkvp;
	}
		
	public void testCastingAndRoundingInJava(){
		double test1 = 1.45D;
		System.out.println(test1+" after casting to long: "+(long) test1);
		System.out.println(test1+" after rounding (to long): "+Math.round(test1));
		double test2 = 1.55D;
		System.out.println(test2+" after casting to long: "+(long) test2);
		System.out.println(test2+" after rounding (to long): "+Math.round(test2));
	}

	/**
	 * SHould find triple (2,3,4) of distances
	 * TODO rethink
	 */
	public void testTripleDetectionInDistances() {
//		SortedSet<Long> testSet = new TreeSet<Long>();
////		testSet.add(2); //2.12
//		testSet.add(4L);//4.24
//		testSet.add(6L);//6.36
//		testSet.add(8L);//8.48
//		testSet.add(11L);//10.60
////		testSet.add(14);
//		Long[] testResult = this.searchForTuplesInDistances(2.12D,testSet,false).getTuple();
//		if(testResult!=null
//				 && testResult[0].equals(2L)
//				 && testResult[1].equals(3L)
//				 && testResult[2].equals(4L)
//				 ){
//			System.out.println("Test succeeded: " +
//					"found distance triple (2,3,4) in the data set (4,6,8,11)");
//		}else{
//			System.err.println("Test failed: " +
//					"did not find distance triple (2,3,4) in the data set (4,6,8,11)");
//		}
//		testResult = this.searchForTuplesInDistances(2.12D,testSet,true).getTriple();
//		if(testResult!=null
//				 && testResult[0].equals(2L)
//				 && testResult[1].equals(3L)
//				 && testResult[2].equals(4L)){
//			System.out.println("Test succeeded: " +
//					"found distance triple (2,3,4) in the data set (4,6,8,11)");
//		}else{
//			System.err.println("Test failed: " +
//					"did not find distance triple (2,3,4) in the data set (4,6,8,11)");
//		}
//		
	}
}
