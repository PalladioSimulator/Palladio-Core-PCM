/**
 * 
 */
package de.uka.ipd.sdq.dsexplore.opt4j.representation;

import java.util.Enumeration;

import org.opt4j.genotype.Bounds;

import de.uka.ipd.sdq.pcm.designdecision.ContinuousRangeDegree;
import de.uka.ipd.sdq.pcm.designdecision.DegreeOfFreedom;
import de.uka.ipd.sdq.pcm.designdecision.DiscreteRangeDegree;
import de.uka.ipd.sdq.pcm.designdecision.EnumerationDegree;
import de.uka.ipd.sdq.pcm.designdecision.Problem;

class DimensionBounds implements Bounds<Double> {
	

	protected Problem problem;

	public DimensionBounds(Problem problem){
		this.problem = problem;
		
	}

	@Override
	public Double getLowerBound(int index) {
		if (DiscreteRangeDegree.class.isInstance(this.problem.getDesigndecision().get(index))){
			return this.getLowerIntBound(index);
		} else if (ContinuousRangeDegree.class.isInstance(this.problem.getDesigndecision().get(index)) ){
			return this.getLowerDoubleBound(index);
		} else if (EnumerationDegree.class.isInstance(this.problem.getDesigndecision().get(index))){
			return this.getLowerEnumerationBound(index);
		} else 
			throw new RuntimeException("Design decision not supported: "+this.problem.getDesigndecision().get(index).getClass().getName());
	}

	@Override
	public Double getUpperBound(int index) {
		if (DiscreteRangeDegree.class.isInstance(this.problem.getDesigndecision().get(index))){
			return this.getUpperIntBound(index);
		} else if (ContinuousRangeDegree.class.isInstance(this.problem.getDesigndecision().get(index)) ){
			return this.getUpperDoubleBound(index);
		} else if (EnumerationDegree.class.isInstance(this.problem.getDesigndecision().get(index))){
			return this.getUpperEnumerationBound(index);
		} else 
			throw new RuntimeException("Design decision not supported: "+this.problem.getDesigndecision().get(index).getClass().getName());
	}
	

	private Double getLowerEnumerationBound(int index) {
		//Lower bound for enumeration types is always 0.
		return 0.0;
	}
	
	private Double getUpperEnumerationBound(int index) {
		int upperEnumerationBound = 0;
		DegreeOfFreedom degree = this.problem.getDesigndecision().get(index);
		if (EnumerationDegree.class.isInstance(degree)){
			upperEnumerationBound = ((EnumerationDegree)degree).getDomainOfEntities().size()-1;
		} else {
			throw new RuntimeException("Domain of design decision not supported: "+this.problem.getDesigndecision().get(index).getClass().getName());
		}
		
		return new Double(upperEnumerationBound);
	}
	
	private Double getLowerDoubleBound(int index) {
		ContinuousRangeDegree range = (ContinuousRangeDegree)this.problem.getDesigndecision().get(index);
		return range.isLowerBoundIncluded() ? range.getFrom() : range.getFrom() + Double.MIN_VALUE;
	}

	private Double getUpperDoubleBound(int index) {
		ContinuousRangeDegree range = (ContinuousRangeDegree)this.problem.getDesigndecision().get(index);
		return range.isUpperBoundIncluded() ? range.getTo() : range.getTo() - Double.MIN_VALUE;
	}
	
	private Double getLowerIntBound(int index) {
		DiscreteRangeDegree range = (DiscreteRangeDegree)this.problem.getDesigndecision().get(index);
		return Double.valueOf(range.isLowerBoundIncluded() ? range.getFrom() : range.getFrom() + 1);
	}

	private Double getUpperIntBound(int index) {
		DiscreteRangeDegree range = (DiscreteRangeDegree)this.problem.getDesigndecision().get(index);
		return Double.valueOf(range.isUpperBoundIncluded() ? range.getTo() : range.getTo() - 1);
	}

	public int numberOfDimensions() {
		//here, the sizes of the arrays have to be the same!
		return this.problem.getDesigndecision().size();
	}
	
	public boolean isInteger(int index){
		return (
				EnumerationDegree.class.isInstance(this.problem.getDesigndecision().get(index))
				|| DiscreteRangeDegree.class.isInstance(this.problem.getDesigndecision().get(index)));
	}
	
	public boolean isEnum(int index){
		return (
				EnumerationDegree.class.isInstance(this.problem.getDesigndecision().get(index))
				);
	}

}