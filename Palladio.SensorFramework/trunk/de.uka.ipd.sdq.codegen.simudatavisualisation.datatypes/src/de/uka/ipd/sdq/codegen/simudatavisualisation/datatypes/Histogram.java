package de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes;

import java.util.ArrayList;
import java.util.List;

/**This class stores the information necessary to display a histogram.
 * The histogram can be visualized using the information about the bucket
 * width and the probability for the buckets.
 * @author groenda
 */
public class Histogram {
	/** The default width for histogram classes */
	public static final double DEFAULT_BUCKET_WIDTH = 1.0;
	
	/** List of the entities, that describe the probability for each of the buckets 
	 * @see HistogramBucketInformation
	 */
	protected List<HistogramBucketInformation> bucketInformation;
	
	/** Contains the width of each bucket of the histogram. */
	protected double bucketWidth;
	
	/** title/name of the histogram */
	private String title;

	/**Creates a new histogram without buckets and default bucket width.
	 * @param title Title od name of the histogram.
	 */
	public Histogram(String title) {
		this(title, DEFAULT_BUCKET_WIDTH);
	}

	/**Creates a new histogram without buckets.
	 * @param title Title or name of the histogram.
	 * @param bucketWidth Width of a bucket of the histogram.
	 */
	public Histogram(String title, double bucketWidth) {
		this.bucketInformation = new ArrayList<HistogramBucketInformation>();
		this.title = title;
		this.bucketWidth = bucketWidth;
	}

	/**Adds a new bucket to the histogram.
	 * @param entity information about the bucket.
	 */
	public void addEntity(HistogramBucketInformation entity){
		bucketInformation.add(entity);
	}
	
	/**Removes a bucket from the histogram.
	 * @param entity bucket to remove.
	 */
	public void removeEntity(HistogramBucketInformation entity){
		bucketInformation.remove(entity);
	}

	/**Returns the list of the buckets and their respective probability.
	 * @return the list of the entities.
	 */
	public List<HistogramBucketInformation> getBucketInformation() {
		return bucketInformation;
	}

	/**Receives the title or name of the histogram.
	 * @return Title or name of the histogram.
	 */
	public String getTitle() {
		return title;
	}

	/**Sets the title or name of the histogram.
	 * @param title The new title.
	 */
	public void setTitle(String title) {
		this.title=title;
	}

	/**Receives the bucket width of the histogram.
	 * @return the bucket width.
	 */
	public double getBucketWidth() {
		return bucketWidth;
	}

	/**Sets the bucket width of the histogram.
	 * @param bucketWidth the new bucket width.
	 */
	public void setBucketWidth(double bucketWidth) {
		this.bucketWidth = bucketWidth;
	}
	
}
