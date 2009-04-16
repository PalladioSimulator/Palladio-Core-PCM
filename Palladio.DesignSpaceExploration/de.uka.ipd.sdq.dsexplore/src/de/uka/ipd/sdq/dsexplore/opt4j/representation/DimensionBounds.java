/**
 * 
 */
package de.uka.ipd.sdq.dsexplore.opt4j.representation;

import org.opt4j.genotype.Bounds;

import de.uka.ipd.sdq.pcm.designdecision.DoubleRange;
import de.uka.ipd.sdq.pcm.designdecision.Problem;

class DimensionBounds implements Bounds<Double> {
	

	private Problem problem;

	public DimensionBounds(Problem problem){
		this.problem = problem;
		
	}

	@Override
	public Double getLowerBound(int index) {
		DoubleRange range = (DoubleRange)this.problem.getDesigndecision().get(index).getDomain();
		return range.isLowerBoundIncluded() ? range.getFrom() : range.getFrom() + Double.MIN_VALUE;
	}

	@Override
	public Double getUpperBound(int index) {
		DoubleRange range = (DoubleRange)this.problem.getDesigndecision().get(index).getDomain();
		return range.isUpperBoundIncluded() ? range.getTo() : range.getTo() - Double.MIN_VALUE;
	}

	public int numberOfDimensions() {
		//here, the sizes of the arrays have to be the same!
		return this.problem.getDesigndecision().size();
	}

}