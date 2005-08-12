using Palladio.Performance.Attributes;
using Palladio.Performance.Math;
using Palladio.RegularExpressions;

namespace Palladio.Performance.RegExVisitor.Visitor
{
	/// <summary>
	/// Visits each node of the abstract syntax tree of a regular expression 
	/// and determines its total time consumption. The calculation of the performance
	/// uses the fourier transformation. 
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
	public class RegExASTVisitorFrequencyDomain : AbstractRegExASTVisitor
	{
		/// <summary>
		/// Sampling Rate of the result.
		/// </summary>
		private long samplingrate;

		/// <summary>
		/// Maximum x-value of the result.
		/// </summary>
		private long maxTime;

		/// <summary>
		/// Constructor that also starts the visitor. The Visitor walks through the AST in depth-first order.
		/// </summary>
		/// <param name="node">The root node of the abstract syntax tree.</param>
		/// <param name="epsilon">Precision of the loop calculation.</param>
		public RegExASTVisitorFrequencyDomain(IRegEx node, double epsilon) : base(epsilon)
		{
			DetermineMaxTimeAndSamplingRate(node, epsilon);

			AddFourierAttributes(node);

			Visit(node);

			this.Random = GetPDF(node);
		}

		/// <summary>
		/// Returns the calculated result.
		/// </summary>
		/// <param name="node">Regular expression  of the service.</param>
		/// <returns>Result of the calculation.</returns>
		private RandomVariable GetPDF(IRegEx node)
		{
			IFourierFunction fourierResult = FourierAttribute.GetAttribute(node).Function;
			IDiscreteFunction timeResult = MathTools.DiscreteFunctions.DiscreteValuePDFunction(fourierResult);
	
			return new RandomVariable(timeResult);
		}

		/// <summary>
		/// Starts a visitor, that computes the probabilities of each expression and determines the maximum
		/// x-value of the resulting function.
		/// </summary>
		/// <param name="node">Regular expression.</param>
		/// <param name="epsilon">Precision of the loop calculation.</param>
		private void DetermineMaxTimeAndSamplingRate(IRegEx node, double epsilon)
		{
			RegExASTVisitorDetermineProbabilitiesAndMaxValue visitor = 
				new RegExASTVisitorDetermineProbabilitiesAndMaxValue(node,epsilon);
	
			this.maxTime=visitor.MaxTime;
			this.samplingrate=visitor.Samplingrate;
		}

		/// <summary>
		/// Computes the weighted sum of the two alternatives.
		/// </summary>
		/// <param name="alternative"></param>
		public override void VisitIAlternative(IAlternative alternative)
		{
			Visit(alternative.AlternativeOne);
			Visit(alternative.AlternativeTwo);

			IFourierFunction f1 = FourierAttribute.GetAttribute(alternative.AlternativeOne).Function;
			IFourierFunction f2 = FourierAttribute.GetAttribute(alternative.AlternativeTwo).Function;

			double p1 = ProbabilityAttribute.GetAttribute(alternative.AlternativeOne).Probability;
			double p2 = ProbabilityAttribute.GetAttribute(alternative.AlternativeTwo).Probability;

			double pSum = p1 + p2;
			IFourierFunction result = f1.GetScaled(p1/pSum).Add(f2.GetScaled(p2/pSum));

			alternative.Attributes.Add(FourierAttribute.AttributeType,
				new FourierAttribute(result));
		}

		/// <summary>
		/// Computes the convolution of the predecessor und the successor of the sequence.
		/// </summary>
		/// <param name="sequence"></param>
		public override void VisitISequence(ISequence sequence)
		{
			Visit(sequence.Predecessor);
			Visit(sequence.Successor);

			IFourierFunction f1 = FourierAttribute.GetAttribute(sequence.Predecessor).Function;
			IFourierFunction f2 = FourierAttribute.GetAttribute(sequence.Successor).Function;

			IFourierFunction result = f1.Multiply(f2);

			sequence.Attributes.Add(FourierAttribute.AttributeType,
				new FourierAttribute(result));
		}



		/// <summary>
		///  Calculates the loop limit. 
		/// </summary>
		/// <param name="loop"></param>
		public override void VisitILoop(ILoop loop)
		{
			Visit(loop.InnerExpression);

			ProbabilityAttribute pin = ProbabilityAttribute.GetAttribute(loop.InnerExpression);
			FourierAttribute fa = FourierAttribute.GetAttribute(loop.InnerExpression);
			IFourierFunction result = fa.Function.ComputeLoopLimit(pin.Probability);
			loop.Attributes.Add(FourierAttribute.AttributeType,new FourierAttribute(result));
		}



		/// <summary>
		/// Nothing has to be done when a Symbol is visited. A Symbol must have a RandomVariable.
		/// </summary>
		/// <param name="symbol"></param>
		public override void VisitISymbol(ISymbol symbol)
		{
		}


		/// <summary>
		/// Creates Fourier Attributes for each symbol.
		/// </summary>
		/// <param name="node"></param>
		private void AddFourierAttributes(IRegEx node)
		{
			if(node is ISymbol)
			{
				IDiscretePDFunction pdf = RandomVariable.GetAttribute(node).ProbabilityDensityFunction;
				pdf.AdjustSamplingRate(this.samplingrate);
				pdf.ExpandDomainPo2(0,this.maxTime);
				IFourierFunction ff = 
					MathTools.DiscreteFunctions.DiscreteFourierFunction(pdf);
				node.Attributes.Add(FourierAttribute.AttributeType,new FourierAttribute(ff));
			}
			if(node is ISequence)
			{
				ISequence seq = (ISequence) node;
				AddFourierAttributes(seq.Predecessor);
				AddFourierAttributes(seq.Successor);
			}
			if(node is IAlternative)
			{
				IAlternative alt = (IAlternative) node;
				AddFourierAttributes(alt.AlternativeOne);
				AddFourierAttributes(alt.AlternativeTwo);
			}
			if(node is ILoop)
			{
				ILoop loop = (ILoop) node;
				AddFourierAttributes(loop.InnerExpression);
			}
		}
	}
}