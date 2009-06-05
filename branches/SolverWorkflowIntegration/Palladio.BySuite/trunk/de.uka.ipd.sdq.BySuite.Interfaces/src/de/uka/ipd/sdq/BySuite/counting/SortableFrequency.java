/**
 * 
 */
package de.uka.ipd.sdq.BySuite.counting;

/**
 * A frequency of an executions of an instruction or of invocations of a  
 * method, accross (unnamed, unidentified) executions of an embodying entity. 
 * @author Michael
 */
public class SortableFrequency implements Comparable<SortableFrequency>{

	public static final double epsilon = 0.001;

	public static double getEpsilon() {
		return epsilon;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//TODO add tests
	} 
	
	private String ID;
	private int numberOfSources;
	private long sumOfAbsoluteOccurencies;
	private double sumOfRelativeFrequencies; //for sorting
	
	public SortableFrequency() {
		super();
		ID=null;
		numberOfSources=0;
		sumOfAbsoluteOccurencies = 0L;
		sumOfRelativeFrequencies = 0D;
	}
	
	public SortableFrequency(String ID, long absoluteOccurences, double relativeFrequency) {
		super();
		this.ID = ID;
		this.numberOfSources = 1;
		this.sumOfAbsoluteOccurencies = absoluteOccurences;
		this.sumOfRelativeFrequencies = relativeFrequency;
	}
	
	public synchronized void addData(long additionalOccurences, double additionalFrequency) throws Exception{
		if(additionalOccurences<0 || additionalFrequency<0 ){
			throw new Exception("Adding negative frequency " +
					"or negative number of occurences " +
					"to a SortableFrequency is not allowed");
		}
		numberOfSources++;
		this.sumOfAbsoluteOccurencies +=additionalOccurences;
		this.sumOfRelativeFrequencies +=additionalFrequency;
	}

	@Override
	public int compareTo(SortableFrequency o) {//note that absolute occurences are ignored
		if(this.getAverageFrequency().doubleValue() < o.getAverageFrequency().doubleValue()){
//			System.out.println(this+"<"+o);
			return -1;
		}else if(this.getAverageFrequency().doubleValue() > o.getAverageFrequency().doubleValue()){
//			System.out.println(this+">"+o);
			return 1;
		}else{
//			System.out.println(this+"="+o);
			if(this.getNumberOfSources() < o.getNumberOfSources()){
//				System.out.println(this+"<"+o);
				return -1;
			}else if(this.getNumberOfSources() > o.getNumberOfSources()){
//				System.out.println(this+">"+o);
				return 1;
			}else{
				return this.getID().compareTo(o.getID());
			}
		}
	}
	
	public boolean equals(SortableFrequency sf){
		if(		   sf.ID.equals(this.ID) 
				&& sf.numberOfSources==this.numberOfSources
				&& sf.sumOfAbsoluteOccurencies==this.sumOfAbsoluteOccurencies
				&& sf.sumOfRelativeFrequencies==this.sumOfRelativeFrequencies){
			return true;
		}else{
			return false;
		}
	}
	
	public Double getAverageFrequency() {
		if(numberOfSources==0){
			return null;
		}else{
			return this.sumOfRelativeFrequencies/this.numberOfSources;
		}
	}
	
	//	public void setID(String iD) {
//		ID = iD;
//	}
	public String getID() {
		return ID;
	}
//	public void setValue(Double value) {
//		this.sumOfFrequencyValues = value;
//	}
//	public Double getValue() {
//		return sumOfFrequencyValues;
//	}
	
	public int getNumberOfSources() {
		return numberOfSources;
	}
	public long getSumOfAbsoluteOccurencies() {
		return sumOfAbsoluteOccurencies;
	}

	public Double getSumOfFrequencyValues() {
		return sumOfRelativeFrequencies;
	}

	public double getSumOfRelativeFrequencies() {
		return sumOfRelativeFrequencies;
	}

	public String toString(){
		return new String(this.ID+":"+
				this.getAverageFrequency()+
				"(="+this.sumOfRelativeFrequencies+"/"+this.numberOfSources+
				";#="+this.getSumOfAbsoluteOccurencies()+";e="+epsilon+")");
	}

	public boolean valueEquals(SortableFrequency next) {
		if(Math.abs(this.getAverageFrequency()-next.getAverageFrequency())<epsilon){
			return true;
		}else{
			return false;
		}
	}

}
