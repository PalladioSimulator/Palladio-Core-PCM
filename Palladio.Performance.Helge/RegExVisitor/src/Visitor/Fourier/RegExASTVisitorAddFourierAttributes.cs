using System;
using Palladio.Performance.Attributes;
using Palladio.Performance.Math;
using Palladio.RegularExpressions;

namespace Palladio.Performance.RegExVisitor.Visitor
{
	/// <summary>
	/// Visits each node of the abstract syntax tree of a regular expression 
	/// and adds FourierFunctions to the symbols.
	/// 
	/// Therefore, each input symbol must contain a RandomVariable attribute.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log: RegExASTVisitorAddFourierAttributes.cs,v $
	/// Revision 1.1  2005/10/11 22:31:12  helgeh
	/// *** empty log message ***
	///
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
	public class RegExASTVisitorAddFourierAttributes : ReflectionBasedVisitor.ReflectionBasedVisitor
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
		/// Constructor.
		/// </summary>
		/// <param name="maxtime"></param>
		/// <param name="samplingrate"></param>
		public RegExASTVisitorAddFourierAttributes(long samplingrate, long maxtime) : base(false)
		{
			this.samplingrate=samplingrate;
			this.maxTime=maxtime;
		}

		/// <summary>
		/// Visits each alternative.
		/// </summary>
		/// <param name="alternative"></param>
		public  void VisitIAlternative(IAlternative alternative)
		{
			Visit(alternative.AlternativeOne);
			Visit(alternative.AlternativeTwo);
		}

		/// <summary>
		/// Visits predecessor and successor.
		/// </summary>
		/// <param name="sequence"></param>
		public  void VisitISequence(ISequence sequence)
		{
			Visit(sequence.Predecessor);
			Visit(sequence.Successor);
		}

		/// <summary>
		///  Visits inner loop. 
		/// </summary>
		/// <param name="loop"></param>
		public  void VisitILoop(ILoop loop)
		{
			Visit(loop.InnerExpression);
		}



		/// <summary>
		/// Converts the RandomVariable to a FourierFunction.
		/// </summary>
		/// <param name="symbol"></param>
		public  void VisitISymbol(ISymbol symbol)
		{
			IDiscretePDFunction pdf = RandomVariable.GetAttribute(symbol).ProbabilityDensityFunction;
			pdf.AdjustSamplingRate(this.samplingrate);
			pdf.ExpandDomainPo2(0,this.maxTime);
			IFourierFunction ff = 
				MathTools.DiscreteFunctions.DiscreteFourierFunction(pdf);
			symbol.Attributes.Add(FourierAttribute.AttributeType,new FourierAttribute(ff));
		}

		public override void VisitObject(object o)
		{
			throw new NotImplementedException();
		}
	}
}