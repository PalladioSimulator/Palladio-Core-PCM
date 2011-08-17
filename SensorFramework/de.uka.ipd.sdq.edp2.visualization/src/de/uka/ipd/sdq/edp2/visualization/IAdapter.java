package de.uka.ipd.sdq.edp2.visualization;
/**
 * Marker class for {@link AbstractTransformation}s, which are Adapters, i.e. that implement a semantic transformation.
 * @author Dominik Ernst
 *
 */
public abstract class IAdapter extends AbstractTransformation {
	
	/**
	 * Empty default constructor.
	 */
	public IAdapter(){
		
	}
	
	/**
	 * Constructor with source parameter.
	 * @param source the attached source
	 */
	public IAdapter(IDataSource source){
		super(source);
	}
	
}
