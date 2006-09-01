using System;
using Palladio.FiniteStateMachines;
using Palladio.Performance.Attributes;
using Palladio.Performance.PerformanceCalculator;
using Palladio.Performance.RegExVisitor;
using Palladio.Performance.RegExVisitor.Visitor;
using Palladio.RegularExpressions;
using Palladio.RegularExpressions.GNFA;

namespace Palladio.Performance.Calculator
{
	/// <summary>
	/// This class provides the performance calculation for a service effect automaton. The calculation is 
	/// done in the frequency domain.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log: Calculator.cs,v $
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
	internal class Calculator : IPerformanceCalculator
	{
		/// <summary>
		/// Precision for the calculation of the loop.
		/// </summary>
		private double epsilon;

		/// <summary>
		/// True := calculation in frequency domain, False := calculation in time domain
		/// </summary>
		private bool frequencyDomain;

		/// <summary>
		/// Constructor.
		/// </summary>
		/// <param name="epsilon">Precision for the calculation of the loop.</param>
		/// <param name="frequencyDomain">true: Calculation in frequency domain. false: Calclation in time domain.</param>
		public Calculator(double epsilon, bool frequencyDomain)
		{
			this.epsilon=epsilon;
			this.frequencyDomain=frequencyDomain;
		}

		/// <summary>
		/// This method takes a service effect automaton as input and calculates the time consumption of the
		/// service.
		/// /// </summary>
		/// <param name="fsm">A Service effect automaton with QMLAttributes or RandomVariables for each transition
		/// and each time consuming state.</param>
		/// <returns>A RandomVariable that contains the time consumption of the specified service.</returns>
		public RandomVariable CalculatePerformance(IFiniteStateMachine fsm) 
		{
			Measurement.Measure.Hrt.Start();
			Measurement.Measure.Hrt.Stop();
			IFiniteStateMachine validSeff = FSMTransformer.FSMTransformer.SEFFValidity(fsm);

			IFiniteStateMachine decoratedFSM = FSMTransformer.FSMTransformer.FSMWithIntermediateState(validSeff);

			IRegEx regex = FSMToRegexConverter.Convert(decoratedFSM);
			Console.WriteLine("Regular Expression\n" + regex.ToString());

			IRegExASTVisitor visitor;

			if(frequencyDomain)
			{
				visitor = new RegExASTVisitorFrequencyDomain(regex,epsilon);
			} else
			{
				visitor = new RegExASTVisitorTimeDomain(regex,epsilon);
			}
				
			Measurement.Measure.Hrt.Stop();
			Console.WriteLine(Measurement.Measure.GetTimeHrt());
			return visitor.Random;
		}
	}
}