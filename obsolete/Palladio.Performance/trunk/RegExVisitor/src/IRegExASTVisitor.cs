using Palladio.Performance.Attributes;
using Palladio.RegularExpressions;

namespace Palladio.Performance.RegExVisitor
{
	/// <summary>
	/// Interface for regular expression abstract syntax tree visitor.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2005/12/04 18:41:21  helgeh
	/// - Simplified DiscreteFourierFunction.Calculate LoopLimit
	/// - added new attribute MaximumExecutionTimeAttribute
	/// - replaced AbstractRegExASTVisitor.DetermineMaxTime by  a new visitor RegExASTVisitorDetermineMaxTime
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
	public interface IRegExASTVisitor
	{

		/// <summary>
		/// The <c>RandomVariable</c> contains the result of the calculation after the visitor was started.
		/// </summary>
		RandomVariable Random
		{
			get;
		}

		/// <summary>
		/// Visits the alternative
		/// </summary>
		/// <param name="alternative"></param>
		void VisitIAlternative(IAlternative alternative);

		/// <summary>
		/// Visits the Sequence.
		/// </summary>
		/// <param name="sequence"></param>
		void VisitISequence(ISequence sequence);

		/// <summary>
		/// Visits the symbol.
		/// </summary>
		/// <param name="symbol"></param>
		void VisitISymbol(ISymbol symbol);

		/// <summary>
		///  Visits the loop.
		/// </summary>
		/// <param name="loop"></param>
		void VisitILoop(ILoop loop);
	}
}
