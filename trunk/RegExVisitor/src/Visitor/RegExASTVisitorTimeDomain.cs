using System.Diagnostics;
using Palladio.Performance.Attributes;
using Palladio.Performance.Math;
using Palladio.RegularExpressions;

namespace Palladio.Performance.RegExVisitor.Visitor
{
	/// <summary>
	/// Visits each node of the abstract syntax tree of a regular expression 
	/// and determins its total time consumption. The Computation of the time consumption uses
	/// vector-multiplication for all computations.
	/// 
	/// Therefore, serveral requirements must be fullfilled:
	///  - each input symbol must contain a RandomVariable attribute.
	///  - each input symbol must contain a ProbabilityAttribute
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/08/12 07:59:20  helgeh
	/// Initial impot after refactoring.
	///
	/// Math:
	/// - Added DiscretePDFunction.
	/// - Added Fast Fourier Transformation and FourierFunction.
	/// - Changed operations of DiscreteFunction. The operations are independent of the sampling rate. For a probability density  function the sum of function values is a value in [0,1].
	/// - Added to interface IDiscreteFunction: Sum,ExpandDomainPo2, Crop, NumberOfNullValues, AdjustSamplingRate,  FunctionWithNValues, ToFile, ValueAt, DismissValuesSmalerThanN, ValueOf, MaximumDataValue
	/// - Altered MEthods: ExpandDomain, Scale, GetScaled, Convolution, Add
	///
	/// FSMTransformer:
	/// - Method SEFFValidity added.
	/// - The Method FSMWithIntermediateState now returns a FSM, where all time consumption is contained by the input symbols of the  transitions.
	///
	/// WebserverSeffFactory:
	/// - All service effect automaton are now IFiniteStateMachines. No use of the PAlladio.ComponentModel.
	///
	/// WebserverAnalyser:
	/// - Data class for configuration added.
	/// - ConfigReader added.
	///
	/// RegExASTVisitor:
	/// - There are now two visitors. One for the calculation in time domain and one for the calculation in frequency domain.
	///
	/// RegularExpressions:
	/// - No changes.
	///
	/// XmlSeffParser:
	/// - Data class for configuration added.
	/// - ConfigReader added.
	///
	/// PerformanceCalculator:
	/// - Added interface IPerformanceCalculator. Added CalculatorFactory.
	///
	/// Unit Tests added.
	/// Updated documentation.
	///
	/// 
	/// </pre>
	/// </remarks>
	public class RegExASTVisitorTimeDomain : AbstractRegExASTVisitor
	{
		/// <summary>
		/// Constructor that also starts the visitor. The Visitor walks through the AST in depth-first order.
		/// </summary>
		/// <param name="node">The root node of the abstract syntax tree.</param>
		/// <param name="epsilon">A threashhold for the computation of the loop.</param>
		public RegExASTVisitorTimeDomain(IRegEx node, double epsilon) : base(epsilon)
		{
			Visit(node);
    		this.Random = RandomVariable.GetAttribute(node);
		}

		/// <summary>
		/// Computes the weighted sum of the two alternatives.
		/// </summary>
		/// <param name="alternative"></param>
		public override void VisitIAlternative(IAlternative alternative)
		{
			Visit(alternative.AlternativeOne);
			Visit(alternative.AlternativeTwo);

			ProbabilityAttribute p1 = ProbabilityAttribute.GetAttribute(alternative.AlternativeOne);
			ProbabilityAttribute p2 = ProbabilityAttribute.GetAttribute(alternative.AlternativeTwo);

			RandomVariable r1 = (RandomVariable) RandomVariable.GetAttribute(alternative.AlternativeOne).Clone();
			RandomVariable r2 = (RandomVariable) RandomVariable.GetAttribute(alternative.AlternativeTwo).Clone();

			double pSum = p1.Probability + p2.Probability; // probability of the alternative
			if (pSum != 0)
			{
				r1.ProbabilityDensityFunction.Scale(p1.Probability/pSum);
				r2.ProbabilityDensityFunction.Scale(p2.Probability/pSum);
			}
			else
			{
				r1.ProbabilityDensityFunction.Scale(0);
				r2.ProbabilityDensityFunction.Scale(0);
			}

			AdjustSamplingRate(ref r1, ref r2);

			IDiscreteFunction result = r1.ProbabilityDensityFunction.Add(r2.ProbabilityDensityFunction);

			ProbabilityAttribute.SetAttribute(alternative, pSum);
			RandomVariable.SetAttribute(alternative, new RandomVariable(result));
		}

		/// <summary>
		/// Computes the convolution of the predecessor und the successor of the sequence.
		/// If the two functions do not have the same sampling rate, the samplingrate must be adjusted.
		/// </summary>
		/// <param name="sequence"></param>
		public override void VisitISequence(ISequence sequence)
		{
			Visit(sequence.Predecessor);
			Visit(sequence.Successor);

			RandomVariable r1 = RandomVariable.GetAttribute(sequence.Predecessor);
			RandomVariable r2 = RandomVariable.GetAttribute(sequence.Successor);
			
			ProbabilityAttribute p1 = ProbabilityAttribute.GetAttribute(sequence.Predecessor);
			ProbabilityAttribute p2 = ProbabilityAttribute.GetAttribute(sequence.Successor);

			ProbabilityAttribute.SetAttribute(sequence, p1.Probability*p2.Probability);

			AdjustSamplingRate(ref r1, ref r2);

			RandomVariable result = new RandomVariable(
				MathTools.DiscreteFunctions.DiscreteValuePDFunction(
					r1.ProbabilityDensityFunction.Convolution(r2.ProbabilityDensityFunction)));

			RandomVariable.SetAttribute(sequence, result);
		}


		/// <summary>
		///  Calculates the loop limit. The calculation will abort if the the maximum value of the i-th 
		///  iteration is smaller than <c>epsilon</c>.
		/// </summary>
		/// <param name="loop"></param>
		public override void VisitILoop(ILoop loop)
		{
			Visit(loop.InnerExpression);

			ProbabilityAttribute innerExpressionProbability = ProbabilityAttribute.GetAttribute(loop.InnerExpression);
			IDiscreteFunction innerExpressionPDF = 
				RandomVariable.GetAttribute(loop.InnerExpression).ProbabilityDensityFunction;

			// actually this is not a probability, since we neglected the
			// probability of leaving the loop. However, the later multiplications
			// fix this problem, because a loop is ever a part of a sequence.
			double ploop = 1/(1 - innerExpressionProbability.Probability);
			ProbabilityAttribute.SetAttribute(loop, ploop);

			double p = innerExpressionProbability.Probability; // probability of reiterating the loop.
			ValidateLoopProbability(p);

			IDiscreteFunction summand = MathTools.DiscreteFunctions.DiracDeltaFunction();
			summand.AdjustSamplingRate(innerExpressionPDF.SamplingRate);

			IDiscreteFunction loopLimit = MathTools.DiscreteFunctions.ConstantFunction(0);
			loopLimit.AdjustSamplingRate(innerExpressionPDF.SamplingRate);

			int iterations = DetermineNumberOfIterationsForLoop(p);
			for(int i=0; i<=iterations;i++)
			{
				double scalefactor = (1-p)*System.Math.Pow(p,i);
				loopLimit = loopLimit.Add(summand.GetScaled(scalefactor));
				summand = summand.Convolution(innerExpressionPDF);
			}

			RandomVariable resultRV = new RandomVariable(loopLimit);
			RandomVariable.SetAttribute(loop, resultRV);

			Debug.WriteLine("Loop calculation for p=" + p + " with " + iterations + " iterations.");
		}



		/// <summary>
		/// Nothing has to be done when a Symbol is visited. A Symbol must have a RandomVariable.
		/// </summary>
		/// <param name="symbol"></param>
		public override void VisitISymbol(ISymbol symbol)
		{
		}

		/// <summary>
		/// Adjusts the samplingrate of both <c>RandomVariable</c> to the same value.
		/// </summary>
		/// <param name="r1"></param>
		/// <param name="r2"></param>
		private void AdjustSamplingRate(ref RandomVariable r1, ref RandomVariable r2)
		{
			RandomVariable.AdjustSamplingRate(ref r1, ref r2);
		}
	}
}