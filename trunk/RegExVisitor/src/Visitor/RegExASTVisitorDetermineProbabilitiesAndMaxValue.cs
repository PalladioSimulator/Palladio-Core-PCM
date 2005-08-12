using Palladio.Performance.Attributes;
using Palladio.Performance.Math;
using Palladio.Performance.RegExVisitor.Visitor;
using Palladio.RegularExpressions;

namespace Palladio.Performance.RegExVisitor.Visitor
{
	/// <summary>
	/// Visits each node of the abstract syntax tree of a regular expression 
	/// and determines the probability for each expression. Also the maximum x-value of the result
	/// is calculated 
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
	internal class RegExASTVisitorDetermineProbabilitiesAndMaxValue : AbstractRegExASTVisitor
	{
		#region data

		private long samplingrate=0;
		private long maxTime;

		#endregion data

		#region properties

		/// <summary>
		/// Maximum execution time of the result of the calculation.
		/// </summary>
		public long MaxTime
		{
			get { return maxTime; }
		}

		/// <summary>
		/// Samplingrate of the result of the calculation.
		/// </summary>
		public long Samplingrate
		{
			get { return samplingrate; }
		}

		#endregion

		/// <summary>
		/// Constructor that also starts the visitor.
		/// </summary>
		/// <param name="node">Regular expression.</param>
		/// <param name="epsilon">Precision of the loop calculation.</param>
		public RegExASTVisitorDetermineProbabilitiesAndMaxValue(IRegEx node, double epsilon) : base(epsilon)
		{
			Visit(node);
			this.maxTime = DetermineMaxTime(node);
		}


		public override void VisitIAlternative(IAlternative alternative)
		{
			Visit(alternative.AlternativeOne);
			Visit(alternative.AlternativeTwo);

			ProbabilityAttribute pa1 = 
				ProbabilityAttribute.GetAttribute(alternative.AlternativeOne);
			ProbabilityAttribute pa2 = 
				ProbabilityAttribute.GetAttribute(alternative.AlternativeTwo);

			alternative.Attributes.Add(ProbabilityAttribute.AttributeType,
				new ProbabilityAttribute(pa1.Probability+pa2.Probability));
		}

		public override void VisitISequence(ISequence sequence)
		{
			Visit(sequence.Predecessor);
			Visit(sequence.Successor);

			ProbabilityAttribute pa1 = 
				ProbabilityAttribute.GetAttribute(sequence.Predecessor);
			ProbabilityAttribute pa2 = 
				ProbabilityAttribute.GetAttribute(sequence.Successor);

			sequence.Attributes.Add(ProbabilityAttribute.AttributeType,
				new ProbabilityAttribute(pa1.Probability*pa2.Probability));

		}

		public override void VisitISymbol(ISymbol symbol)
		{
			RandomVariable rand = RandomVariable.GetAttribute(symbol);
			if(Samplingrate==0) samplingrate = rand.ProbabilityDensityFunction.SamplingRate;
			samplingrate = 
				MathTools.GCD(Samplingrate, rand.ProbabilityDensityFunction.SamplingRate);
		}

		public override void VisitILoop(ILoop loop)
		{
			Visit(loop.InnerExpression);

			ProbabilityAttribute innerExpressionProbability = ProbabilityAttribute.GetAttribute(loop.InnerExpression);
			ValidateLoopProbability(innerExpressionProbability.Probability);

			// actually this is not a probability, since we neglected the
			// probability of leaving the loop. However, the later multiplications
			// fix this problem, because a loop is ever a part of a sequence.
			double ploop = 1/(1 - innerExpressionProbability.Probability);

			ProbabilityAttribute.SetAttribute(loop, ploop);
		}

	}
}
