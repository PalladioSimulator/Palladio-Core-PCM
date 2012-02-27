/**
 * 
 */
package de.uka.ipd.sdq.dsexplore.opt4j.representation;

import org.opt4j.genotype.Bounds;

import de.uka.ipd.sdq.pcm.designdecision.ContinuousRangeDegree;
import de.uka.ipd.sdq.pcm.designdecision.DecisionSpace;
import de.uka.ipd.sdq.pcm.designdecision.DegreeOfFreedomInstance;
import de.uka.ipd.sdq.pcm.designdecision.DiscreteRangeDegree;
import de.uka.ipd.sdq.pcm.designdecision.ClassDegree;

@Deprecated
class DimensionBounds implements Bounds<Double> {
	

	protected DecisionSpace problem;

	public DimensionBounds(DecisionSpace problem){
		this.problem = problem;
		
	}

	@Override
	public Double getLowerBound(int index) {
		if (DiscreteRangeDegree.class.isInstance(this.problem.getDegreesOfFreedom().get(index))){
			return this.getLowerIntBound(index);
		} else if (ContinuousRangeDegree.class.isInstance(this.problem.getDegreesOfFreedom().get(index)) ){
			return this.getLowerDoubleBound(index);
		} else if (ClassDegree.class.isInstance(this.problem.getDegreesOfFreedom().get(index))){
			return this.getLowerEnumerationBound(index);
		} else 
			throw new RuntimeException("Design decision not supported: "+this.problem.getDegreesOfFreedom().get(index).getClass().getName());
	}

	@Override
	public Double getUpperBound(int index) {
		if (DiscreteRangeDegree.class.isInstance(this.problem.getDegreesOfFreedom().get(index))){
			return this.getUpperIntBound(index);
		} else if (ContinuousRangeDegree.class.isInstance(this.problem.getDegreesOfFreedom().get(index)) ){
			return this.getUpperDoubleBound(index);
		} else if (ClassDegree.class.isInstance(this.problem.getDegreesOfFreedom().get(index))){
			return this.getUpperEnumerationBound(index);
		} else 
			throw new RuntimeException("Design decision not supported: "+this.problem.getDegreesOfFreedom().get(index).getClass().getName());
	}
	

	private Double getLowerEnumerationBound(int index) {
		//Lower bound for enumeration types is always 0.
		return 0.0;
	}
	
	private Double getUpperEnumerationBound(int index) {
		int upperEnumerationBound = 0;
		DegreeOfFreedomInstance degree = this.problem.getDegreesOfFreedom().get(index);
		if (ClassDegree.class.isInstance(degree)){
			upperEnumerationBound = ((ClassDegree)degree).getClassDesignOptions().size()-1;
		} else {
			throw new RuntimeException("Domain of design decision not supported: "+this.problem.getDegreesOfFreedom().get(index).getClass().getName());
		}
		
		return new Double(upperEnumerationBound);
	}
	
	private Double getLowerDoubleBound(int index) {
		ContinuousRangeDegree range = (ContinuousRangeDegree)this.problem.getDegreesOfFreedom().get(index);
		return range.isLowerBoundIncluded() ? range.getFrom() : range.getFrom() + Double.MIN_VALUE;
	}

	private Double getUpperDoubleBound(int index) {
		ContinuousRangeDegree range = (ContinuousRangeDegree)this.problem.getDegreesOfFreedom().get(index);
		return range.isUpperBoundIncluded() ? range.getTo() : range.getTo() - Double.MIN_VALUE;
	}
	
	private Double getLowerIntBound(int index) {
		DiscreteRangeDegree range = (DiscreteRangeDegree)this.problem.getDegreesOfFreedom().get(index);
		return Double.valueOf(range.isLowerBoundIncluded() ? range.getFrom() : range.getFrom() + 1);
	}

	private Double getUpperIntBound(int index) {
		DiscreteRangeDegree range = (DiscreteRangeDegree)this.problem.getDegreesOfFreedom().get(index);
		return Double.valueOf(range.isUpperBoundIncluded() ? range.getTo() : range.getTo() - 1);
	}

	public int numberOfDimensions() {
		//here, the sizes of the arrays have to be the same!
		return this.problem.getDegreesOfFreedom().size();
	}
	
	public boolean isInteger(int index){
		return (
				ClassDegree.class.isInstance(this.problem.getDegreesOfFreedom().get(index))
				|| DiscreteRangeDegree.class.isInstance(this.problem.getDegreesOfFreedom().get(index)));
	}
	
	public boolean isEnum(int index){
		return (
				ClassDegree.class.isInstance(this.problem.getDegreesOfFreedom().get(index))
				);
	}

	/**
	 * Checks whether a single gene is within the bounds specified for the given index
	 * @param doubleGene
	 * @param index
	 * @return
	 */
	public boolean isValidGene(Double doubleGene, int index) {
		if (doubleGene.isNaN() || doubleGene.isInfinite()
			|| doubleGene < this.getLowerBound(index)
			|| doubleGene > this.getUpperBound(index))
			return false;
		return true;
	}

}