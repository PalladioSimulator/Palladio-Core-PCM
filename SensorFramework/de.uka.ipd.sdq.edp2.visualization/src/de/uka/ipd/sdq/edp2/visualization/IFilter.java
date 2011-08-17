package de.uka.ipd.sdq.edp2.visualization;


/**
 * Class, which identifies the {@link AbstractTransformation} as a Filter.
 * @author Dominik Ernst, Roland Richter
 */
public abstract class  IFilter extends AbstractTransformation {
	
	/**
	 * Default, empty constructor
	 */
	public IFilter(){
		
	}
	
	/**
	 * Default constructor with source parameter.
	 * @param source the attached source
	 */
	public IFilter(IDataSource source){
		super(source);
	}
}
