package de.uka.ipd.sdq.BySuite.deprecated;

import java.util.Comparator;

import de.uka.ipd.sdq.BySuite.counting.SortableFrequency;


public class SortableFrequencyComparator implements //TODO find out why SortableFrequencyComparator<SortableFrequency> resulted in hiding and errors...
		Comparator<SortableFrequency> {

	public static void main(String args[]){
		SortableFrequencyComparator sfc = new SortableFrequencyComparator();
		sfc.testSimple();
	}
	
	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	public int compare(SortableFrequency o1, SortableFrequency o2) {//TODO replace through calls to compareTo of SortableFrequency
		return(o1.compareTo(o2));
//		double o1frequency = o1.getAverageFrequency();
//		double o2frequency = o2.getAverageFrequency();
//		if(o1frequency<o2frequency){
////			System.out.println(o1+" < "+o2);
//			return -1;
//		}else if(o1frequency>o2frequency){
////			System.out.println(o1+" > "+o2);
//			return 1;
//		}else if(Math.abs(o1frequency-o2frequency)<=SortableFrequency.getEpsilon()){
////			System.out.println(o1+" = "+o2);
//			return 0;
//		}else{
//			System.err.println("Should not happen: could not compare "+o1+" and "+o2);
//			return Integer.MIN_VALUE;
//		}
	}

	private void testSimple() {
		SortableFrequency center = new SortableFrequency("Center",1,2.0304050607D);
		if(this.compare(center,center)!=0){
			System.err.println("center should be equal to itself");
		}

		SortableFrequency centerMinusOneAndAHalfEpsilon = new SortableFrequency("Center-1.5e",1,2.0304050607D-1.5*SortableFrequency.epsilon);
		SortableFrequency centerMinusEpsilon = new SortableFrequency("Center-e",1,2.0304050607D-SortableFrequency.epsilon);
		SortableFrequency centerMinusHalfEpsilon = new SortableFrequency("Center-e/2",1,2.0304050607D-SortableFrequency.epsilon/2);
		SortableFrequency centerPlusHalfEpsilon = new SortableFrequency("Center+e/2",1,2.0304050607D+SortableFrequency.epsilon/2);
		SortableFrequency centerPlusEpsilon = new SortableFrequency("Center+e",1,2.0304050607D+SortableFrequency.epsilon);
		SortableFrequency centerPlusOneAndAHalfEpsilon = new SortableFrequency("Center+1.5e",1,2.0304050607D+1.5*SortableFrequency.epsilon);

		if(this.compare(center,centerMinusOneAndAHalfEpsilon)!=1){
			System.err.println("center should be greater then itself-1.5e");
		}
//		if(this.compare(center,centerMinusEpsilon)!=1){
		if(this.compare(center,centerMinusEpsilon)!=0){
//			System.err.println("center should be greater then itself-e");
			System.err.println("center should be equal to itself-e");
		}
		if(this.compare(center,centerMinusHalfEpsilon)!=0){
			System.err.println("center should be greater then itself-0.5e");
		}
		if(this.compare(center,centerPlusHalfEpsilon)!=0){
			System.err.println("center should be equal to itself+0.5e");
		}
//		if(this.compare(center,centerPlusEpsilon)!=-1){
		if(this.compare(center,centerPlusEpsilon)!=0){
//			System.err.println("center should be smaller then itself+e");
			System.err.println("center should be equal to itself+e");
		}
		if(this.compare(center,centerPlusOneAndAHalfEpsilon)!=-1){
			System.err.println("center should be smaller then itself+1.5e");
		}
		
	}

//	@Override
//	public int compare(SortableFrequency arg0, SortableFrequency arg1) {
//		if(arg0.get

}
