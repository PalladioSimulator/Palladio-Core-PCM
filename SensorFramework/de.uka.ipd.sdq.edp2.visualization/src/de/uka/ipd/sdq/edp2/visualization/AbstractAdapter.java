package de.uka.ipd.sdq.edp2.visualization;
/**
 * Marker class for {@link AbstractTransformation}s, which are Adapters, i.e. that implement a semantic transformation.
 * @author Dominik Ernst
 *
 */
public abstract class AbstractAdapter extends AbstractTransformation {
	
	/**
	 * Empty default constructor.
	 */
	public AbstractAdapter(){
		
	}
	
	/**
	 * Constructor with source parameter.
	 * @param source the attached source
	 */
	public AbstractAdapter(AbstractDataSource source){
		super(source);
	}
	
}
