using System.Diagnostics;
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
	/// done in the time domain.
	/// </summary>
	internal class CalculatorTimeDomain : IPerformanceCalculator
	{
		/// <summary>
		/// Precision for the calculation of the loop.
		/// </summary>
		private double epsilon;

		/// <summary>
		/// Takes a service effect automaton as input and calculates the time consumption
		/// of the service.
		/// /// </summary>
		/// <param name="fsm">A Service effect automaton with QMLAttributes or RandomVariables
		/// for each transition and each time consuming state.</param>
		/// <returns>A RandomVariable that contains the time consumption of the specified service.</returns>
		public RandomVariable CalculatePerformance(IFiniteStateMachine fsm) 
		{
			IFiniteStateMachine validSeff = FSMTransformer.FSMTransformer.SEFFValidity(fsm);

			IFiniteStateMachine decoratedFSM = 
				FSMTransformer.FSMTransformer.FSMWithIntermediateState(validSeff);

    		IRegEx regex = FSMToRegexConverter.Convert(decoratedFSM);
			Debug.WriteLine("Regular Expression\n"+regex.ToString());

			IRegExASTVisitor visitor = new RegExASTVisitorTimeDomain(regex,epsilon);
			return 	visitor.Random;
		}

		/// <summary>
		/// Constructor.
		/// </summary>
		/// <param name="epsilon">Precision for the calculation of the loop.</param>
		public CalculatorTimeDomain(double epsilon)
		{
			this.epsilon=epsilon;
		}
	}
}
