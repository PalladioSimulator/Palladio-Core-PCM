using System;
using Palladio.Performance.Attributes;
using Palladio.Performance.RegExVisitor;
using Palladio.RegularExpressions;

namespace Palladio.Performance.RegExVisitor.Visitor
{
	/// <summary>
	/// Abstract class for RegExASTVisitor.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.3  2005/12/04 18:41:21  helgeh
	/// - Simplified DiscreteFourierFunction.Calculate LoopLimit
	/// - added new attribute MaximumExecutionTimeAttribute
	/// - replaced AbstractRegExASTVisitor.DetermineMaxTime by  a new visitor RegExASTVisitorDetermineMaxTime
	///
	/// Revision 1.2  2005/10/11 22:05:14  helgeh
	/// - Added NUnit project and NDoc documentation.
	/// - fixed a bug in AdjustSamplingRate
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
	public abstract class AbstractRegExASTVisitor : ReflectionBasedVisitor.ReflectionBasedVisitor, IRegExASTVisitor
	{

		#region Data

		/// <summary>
		/// The result of the calculation.
		/// </summary>
		RandomVariable rand;

		/// <summary>
		/// Precision for calculating the loop limit.
		/// </summary>
		double epsilon;

		#endregion

		#region Properties

		/// <summary>
		/// The result of the calculation.
		/// </summary>
		public RandomVariable Random
		{
			get
			{
				return this.rand;
			}

			set
			{
				this.rand=value;
			}
		}

		/// <summary>
		/// Precision for calculating the loop limit.
		/// </summary>
		public double Epsilon
		{
			get
			{
				return this.epsilon;
			}
		}

		#endregion Properties

		#region Constructor

		/// <summary>
		/// Constructor.
		/// </summary>
		/// <param name="epsilon">Precision for calculating the loop limit.</param>
		public AbstractRegExASTVisitor(double epsilon) : base(false)
		{
			this.epsilon=epsilon;
		}

		#endregion Constructor

		#region Methods

		/// <summary>
		/// The probability of reiterating the loop must be a value in [0,1[. IF the probability is out of range,
		/// an exception is thrown.
		/// </summary>
		/// <param name="probability">Probability of reiterating the loop.</param>
		public void ValidateLoopProbability(double probability)
		{
			if (System.Math.Round(probability,2) >= 1)
				throw new ApplicationException("The probability of the inner loop expression must be a value" +
					" in [0,1[.");
		}


		/// <summary>
		/// For a given loop probability and an epsilon the function returns the number of loop
		/// iterations, so the total probability of the loop is 1-epsilon.
		/// </summary>
		/// <param name="loopProbability">Probability of entering the loop.</param>
		/// <returns></returns>
		public int DetermineNumberOfIterationsForLoop(double loopProbability)
		{
			int iterations=0;
			double sum = 0;
			while(sum<(1-epsilon))
			{
				sum += (1-loopProbability)*System.Math.Pow(loopProbability,iterations);
				iterations++;
			}
			return iterations-1;
		}

		#endregion Methods

		#region ReflectionBasedVisitor

		/// <summary>
		/// The default function which is called if no "VisitTYPE" method is found
		/// by the reflection API
		/// </summary>
		/// <param name="o">The object calling the unknown visitor function</param>
		public override void VisitObject(object o)
		{
			Console.WriteLine("Unkown object type: " + o.GetType().ToString());
		}

		#endregion ReflectionBasedVisitor

		#region Abstract Methods

		/// <summary>
		/// Visits the alternative.
		/// </summary>
		/// <param name="alternative"></param>
		public abstract void VisitIAlternative(IAlternative alternative);

		/// <summary>
		/// Visits the sequence.
		/// </summary>
		/// <param name="sequence"></param>
		public abstract void VisitISequence(ISequence sequence);

		/// <summary>
		/// Visits the symbol.
		/// </summary>
		/// <param name="symbol"></param>
		public abstract void VisitISymbol(ISymbol symbol);

		/// <summary>
		///  Visits the loop. 
		/// </summary>
		/// <param name="loop"></param>
		public abstract void VisitILoop(ILoop loop);

		#endregion Abstract Methods
	}
}
