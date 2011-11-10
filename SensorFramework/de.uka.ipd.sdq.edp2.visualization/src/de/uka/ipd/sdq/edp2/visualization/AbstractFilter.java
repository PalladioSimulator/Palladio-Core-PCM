package de.uka.ipd.sdq.edp2.visualization;


/**
 * Class, which identifies the {@link AbstractTransformation} as a Filter.
 * @author Dominik Ernst, Roland Richter
 */
public abstract class  AbstractFilter extends AbstractTransformation {
	
	/**
	 * Default, empty constructor
	 */
	public AbstractFilter(){
		
	}
	
	/**
	 * Default constructor with source parameter.
	 * @param source the attached source
	 */
	public AbstractFilter(AbstractDataSource source){
		super(source);
	}
}
