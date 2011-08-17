package de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes;

import java.io.Serializable;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

import org.apache.log4j.Logger;

/**This class stores the information necessary to display a histogram.
 * The histogram can be visualized using the information about the bucket
 * width and the probability for the buckets. 
 * TODO it is neither checked not documented how elements represent the 
 * buckets (by the center?), and whether equidistance between bucket 
 * identifiers is maintained. 
 * TODO add compareTo and equals to this type
 * TODO no checking for duplicates is performed 
 * @author groenda, Michael Kuperberg
 */
public class Histogram implements Comparable<Histogram>, Serializable{
	/** The logger used by this class. */
	private Logger logger;
	
	/** 
	 * The default width for histogram classes 
	 * Note that given the MAXIMUM_NUMBER_OF_BUCKETS, 
	 * the range of the histogram is already given, 
	 * and can be increased only by changing the bucket width,
	 * since the maximum number of buckets is fixed. 
	 * */
	public static final double DEFAULT_BUCKET_WIDTH = 1D;//TODO compare to default width in Histogram.class

	/** 
	 * The maximum number of buckets to show when initialising the diagram. 
	 * The user can decide to show more - TODO explain WHERE!
	 * Note that this restriction implies that showing 
	 * empty "in-between" buckets is not a good idea. 
	 * */
	public static final double MAXIMUM_NUMBER_OF_BUCKETS = 100;

	/**
	 * For serialization
	 */
	private static final long serialVersionUID = 1L;
	
	/** List of the entities, that describe the probability for each of the buckets 
	 * TODO this should be made a SortedSet (
	 * @see HistogramBucketInformation
	 */
	protected SortedSet<HistogramBucketInformation> bucketInformation;
	
	/**
	 * At the initialisation...
	 */
	private double sumOfProbabilities = 0.0D;
	
	/** 
	 * Contains the width of each bucket of the histogram. 
	 * TODO check that this constraint indeed applies
	 */
	protected double bucketWidth;
	
	/** title/name of the histogram */
	private String title;
	
	/**
	 * Current visualisation often set the x axis annotation to "time". 
	 * Introducing this field allows for flexibility. 
	 */
	private String xAxisAnnotation = "";

	/**Creates a new histogram without buckets and with default bucket width.
	 * @param title Title or name of the histogram.
	 */
	public Histogram(String title) {
		this(title, DEFAULT_BUCKET_WIDTH);
	}

	/**Creates a new histogram without buckets and with default bucket width.
	 * @param title Title or name of the histogram.
	 * @param xAxisAnnotation Annotation to be used for the x axis. 
	 */
	public Histogram(String title, String xAxisAnnotation) {
		this(title, DEFAULT_BUCKET_WIDTH, xAxisAnnotation);
	}

	/**Creates a new histogram without buckets.
	 * @param title Title or name of the histogram.
	 * @param bucketWidth Width of a bucket of the histogram.
	 */
	public Histogram(String title, double bucketWidth) {
		this(title,bucketWidth,null);
	}

	/**Creates a new histogram without buckets.
	 * @param title Title or name of the histogram.
	 * @param bucketWidth Width of a bucket of the histogram.
	 * @param xAxisAnnotation Annotation to be used for the x axis. 
	 */
	public Histogram(String title, double bucketWidth, String xAxisAnnotation) {
		super();
		this.logger =Logger.getLogger(this.getClass().getName());
		this.bucketInformation = new TreeSet<HistogramBucketInformation>();
		this.title = title;
		this.setBucketWidth(bucketWidth);///
		this.sumOfProbabilities = 0.0D;
		this.setXAxisAnnotation(xAxisAnnotation);
	}

	/**Adds a new bucket to the histogram. Made synchronized because 
	 * concurrent changes to bucketWidth are undesirable. 
	 * TODO no integrity check or duplicate check is done
	 * TODO no relation check to bucketWidth is done
	 * TODO no check for maximum number of buckets is done (!!!)
	 * @param entity information about the bucket.
	 */
	public synchronized boolean addEntity(HistogramBucketInformation entity){
		if(this.bucketInformation.size() == MAXIMUM_NUMBER_OF_BUCKETS){
			/*throw new RuntimeException*/logger.error("Histogram is full, " +
					"HistogramBucketInformation " + entity+
					" cannot be added to Histogram");
			//TODO consider throwing a RuntimeException here...
			//TODO recalculation (changing bucket width) is complicated
			return false;
		}
		if(entity == null){
			/*throw new RuntimeException*/logger.error("Null-valued " +
					"HistogramBucketInformation " +
					"cannot be added to Histogram");
			return false;
		}
		if(entity.getProbability()<0.0D){//should not happen at all, given the checks in the bucket
			/*throw new RuntimeException*/logger.error("HistogramBucketInformation with " +
					"sub-zero probability " +
					"("+entity.getProbability()+") cannot be added to Histogram");
			return false;
		}
//		if(entity.getProbability()==Double.NaN){//does NOT work!!!
		if(Double.compare(entity.getProbability(),Double.NaN)==0){//does work
			/*throw new RuntimeException*/logger.error("HistogramBucketInformation with " +
					"NaN-valued probability " +
					"("+entity.getProbability()+") cannot be added to Histogram");
			return false;
		}
		if(sumOfProbabilities+entity.getProbability()>1.0D){
			/*throw new RuntimeException*/logger.error("HistogramBucketInformation with " +
					"probability" + entity.getProbability()+
					" cannot be added to Histogram, " +
					"as the sum of probabilities would be >1, namely "+
					(sumOfProbabilities+entity.getProbability()));
			return false;
		}
//		boolean lowerNeighborFound = false;
//		boolean upperNeighborFound = false;
//		boolean sameValueFound = false;
		double currentValue;
		double valueToInsert = entity.getValue();
		Iterator<HistogramBucketInformation> iter = bucketInformation.iterator();
		boolean continueSearch = iter.hasNext();
		HistogramBucketInformation bucket;
		while(continueSearch){
			bucket = iter.next();
			currentValue = bucket.getValue();
			if(Math.abs(valueToInsert - currentValue) < bucketWidth){
				continueSearch=false;
				/*throw new RuntimeException*/logger.error("skipped inserting a new bucket " +
						"that would overlap an existing bucket: "+
						entity+" would overlap "+bucket+" given the bucket width of "+bucketWidth);
				return false;
			}else{
				//everything is fine
				continueSearch = iter.hasNext();
			} 
		}
		bucketInformation.add(entity);
		sumOfProbabilities += entity.getProbability();
		return true;
	}
	
	@Override
	public int compareTo(Histogram o) {//TODO ignores the name of the histogram and xAxisLabels
		//by construction, bucketInformation cannot be null
		int widthCmp = Double.compare(this.getBucketWidth(), o.getBucketWidth());
		int myNrOfBuckets = this.getNumberOfBuckets(); 
		int hisNrOfBuckets = o.getNumberOfBuckets(); 
		if(widthCmp!=0 ){
			return widthCmp;
		}else if(myNrOfBuckets>hisNrOfBuckets){
			return 1;
		}else if(myNrOfBuckets<hisNrOfBuckets){
			return -1;
		}else{
			Iterator<HistogramBucketInformation> myIter = this.getBucketInformation().iterator();
			Iterator<HistogramBucketInformation> hisIter = o.getBucketInformation().iterator();
			HistogramBucketInformation myBucket;
			HistogramBucketInformation hisBucket;
			int bucketComp;
			while(myIter.hasNext()){
				myBucket = myIter.next();
				hisBucket = hisIter.next();
				bucketComp = myBucket.compareTo(hisBucket);
				if(bucketComp==0){
					//continue
				}else{
					return bucketComp;
				}
			}
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {//TODO consider xAxisLabel, too
		Histogram other;
		if(obj instanceof Histogram){
			other = (Histogram) obj;
			if(this.compareTo(other)==0){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}

	/**
	 * Needed because a SortedSet (surpisingly) does not offer a get(int index) method. 
	 * Expensive because the conversion to array is performed each time the method 
	 * is called. Could be made cheaper by caching the array.  
	 * @param i
	 * @return
	 */
	public HistogramBucketInformation getBucket(int i){
		if(i<0 || i>=this.getNumberOfBuckets()){
			return null;
		}else{
			return this.getBucketInformation().toArray(new HistogramBucketInformation[]{})[i];
		}
	}

	/**Returns the list of the buckets and their respective probability.
	 * @return the list of the entities.
	 */
	public SortedSet<HistogramBucketInformation> getBucketInformation() {
		return bucketInformation;
	}

	/**Receives the bucket width of the histogram.
	 * @return the bucket width.
	 */
	public double getBucketWidth() {
		return bucketWidth;
	}

	public int getNumberOfBuckets(){
		return this.getBucketInformation().size();
	}
	
	
	/**Receives the title or name of the histogram.
	 * @return Title or name of the histogram.
	 */
	public String getTitle() {
		return title;
	}
	
	/**Removes a bucket from the histogram.
	 * @param entity bucket to remove.
	 */
	public synchronized boolean removeEntity(HistogramBucketInformation entity){
		if(entity!=null && bucketInformation.contains(entity)){
			sumOfProbabilities -= entity.getProbability();
			return bucketInformation.remove(entity);
		}else{
			return false;
		}
		
	}
	
	/**Sets the bucket width of the histogram.
	 * Made private because it needs to be set in relation to MAXIMUM_NUMBER_OF_BUCKETS...
	 * @param bucketWidth the new bucket width.
	 */
	private void setBucketWidth(double bucketWidth) {
		this.bucketWidth = bucketWidth;
	}

	/**Sets the title or name of the histogram.
	 * @param title The new title.
	 */
	public void setTitle(String title) {
		this.title=title;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("bucketWidth="+bucketWidth+", " +
				"sum of probabilities=" + sumOfProbabilities+", "+
				bucketInformation.size()+" bucket(s): \n");
		for(HistogramBucketInformation bucket : bucketInformation){
			sb.append("\t"+bucket+"\n");
		}
		return sb.toString();
	}

	/**
	 * @param xAxisAnnotation the xAxisAnnotation to set
	 */
	public void setXAxisAnnotation(String xAxisAnnotation) {
		if(xAxisAnnotation==null){
			logger.debug("passed xAxisAnnotation is null - leaving to default");
		}else if(xAxisAnnotation.length()==0){
			logger.debug("passed xAxisAnnotation is an empty String - leaving to default");
		}else{
			this.xAxisAnnotation = xAxisAnnotation;
		}
	}

	/**
	 * @return the xAxisAnnotation
	 */
	public String getXAxisAnnotation() {
		return xAxisAnnotation;
	}

}
