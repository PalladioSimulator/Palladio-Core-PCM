/*
 * $Id$
 * 
 * $Log$
 * Revision 1.1  2005/08/12 07:59:20  helgeh
 * Initial impot after refactoring.
 *
 * Math:
 * - Added DiscretePDFunction.
 * - Added Fast Fourier Transformation and FourierFunction.
 * - Changed operations of DiscreteFunction. The operations are independent of the sampling rate. For a probability density  function the sum of function values is a value in [0,1].
 * - Added to interface IDiscreteFunction: Sum,ExpandDomainPo2, Crop, NumberOfNullValues, AdjustSamplingRate,  FunctionWithNValues, ToFile, ValueAt, DismissValuesSmalerThanN, ValueOf, MaximumDataValue
 * - Altered MEthods: ExpandDomain, Scale, GetScaled, Convolution, Add
 *
 * FSMTransformer:
 * - Method SEFFValidity added.
 * - The Method FSMWithIntermediateState now returns a FSM, where all time consumption is contained by the input symbols of the  transitions.
 *
 * WebserverSeffFactory:
 * - All service effect automaton are now IFiniteStateMachines. No use of the PAlladio.ComponentModel.
 *
 * WebserverAnalyser:
 * - Data class for configuration added.
 * - ConfigReader added.
 *
 * RegExASTVisitor:
 * - There are now two visitors. One for the calculation in time domain and one for the calculation in frequency domain.
 *
 * RegularExpressions:
 * - No changes.
 *
 * XmlSeffParser:
 * - Data class for configuration added.
 * - ConfigReader added.
 *
 * PerformanceCalculator:
 * - Added interface IPerformanceCalculator. Added CalculatorFactory.
 *
 * Unit Tests added.
 * Updated documentation.
 *
 * Revision 1.2  2005/07/07 08:56:49  helgeh
 * *** empty log message ***
 *
 * Revision 1.1  2005/06/03 09:33:42  helgeh
 * *** empty log message ***
 *
 * Revision 1.1  2005/05/18 21:35:08  helgeh
 * *** empty log message ***
 *
 * Revision 1.1  2005/03/16 11:55:26  helgeh
 * initial checkin
 *
 * Revision 1.1  2004/12/15 00:05:14  sliver
 * initial checkin after some major refactorings
 *
 * Revision 1.2  2004/11/08 03:50:06  sliver
 * *** empty log message ***
 *
 * Revision 1.1  2004/11/04 08:52:14  sliver
 * added regular expressions
 *
 * Revision 1.1  2004/10/25 07:07:21  sliver
 * implementation of
 * - functions discrete, including convolution
 * - path segmentation of FSMs
 * - prediction of time consumption using density functions
 *
 */


using Palladio.FiniteStateMachines;
using Palladio.Performance.Attributes;

namespace Palladio.RegularExpressions.Tests
{
	/// <summary>
	/// Description of TestCMBuilder.	
	/// </summary>
	public class TestBuilder : Helper
	{
		/// <summary>
		/// A
		/// </summary>
		/// <returns></returns>
		public static IFiniteStateMachine CreateTestMarkovModel()
		{
			IEditableFiniteStateMachine editFSM = FSMFactory.CreateEmptyFSM();

			InputSymbolHash ih = FSMFactory.CreateInputFromList("a", "b", "c", "d");
			editFSM.AddInputSymbols(ih.StoredInputs);

			StateHash sh;
			sh = CreateStates("1", "2", "3", "4", "5");
			editFSM.AddStates(sh.StoredStates);
			editFSM.StartState = sh["1"];
			editFSM.FinalStates = new IState[] {sh["5"]};
			editFSM.AddTransitions(CreateTransition(sh["1"], ih["a"], sh["2"]));
			editFSM.AddTransitions(CreateTransition(sh["2"], ih["b"], sh["1"]));
			editFSM.AddTransitions(CreateTransition(sh["1"], ih["c"], sh["3"]));
			editFSM.AddTransitions(CreateTransition(sh["2"], ih["a"], sh["4"]));
			editFSM.AddTransitions(CreateTransition(sh["3"], ih["d"], sh["5"]));
			editFSM.AddTransitions(CreateTransition(sh["4"], ih["d"], sh["5"]));
			return editFSM;
		}

		/// <summary>
		/// B
		/// </summary>
		/// <returns></returns>
		public static IFiniteStateMachine CreateTestMeltingFSM()
		{
			IEditableFiniteStateMachine editFSM = FSMFactory.CreateEmptyFSM();

			InputSymbolHash ih = FSMFactory.CreateInputFromList("a", "b", "c", "d", "e", "f");
			editFSM.AddInputSymbols(ih.StoredInputs);

			StateHash sh;
			sh = CreateStates("1", "2", "3");
			editFSM.AddStates(sh.StoredStates);
			editFSM.StartState = sh["1"];
			editFSM.FinalStates = new IState[] {sh["3"]};
			editFSM.AddTransitions(CreateTransition(sh["1"], ih["a"], sh["2"]));
			editFSM.AddTransitions(CreateTransition(sh["1"], ih["b"], sh["2"]));
			editFSM.AddTransitions(CreateTransition(sh["1"], ih["c"], sh["2"]));
			editFSM.AddTransitions(CreateTransition(sh["1"], ih["d"], sh["3"]));
			editFSM.AddTransitions(CreateTransition(sh["1"], ih["e"], sh["3"]));
			editFSM.AddTransitions(CreateTransition(sh["2"], ih["f"], sh["3"]));
			return editFSM;
		}

		/// <summary>
		/// C
		/// </summary>
		/// <returns></returns>
		public static IFiniteStateMachine CreateTestRegexFSMSimple()
		{
			IEditableFiniteStateMachine editFSM = FSMFactory.CreateEmptyFSM();

			InputSymbolHash ih = FSMFactory.CreateInputFromList("a", "b", "c");
			editFSM.AddInputSymbols(ih.StoredInputs);

			StateHash sh;
			sh = CreateStates("1", "2");
			editFSM.AddStates(sh.StoredStates);
			editFSM.StartState = sh["1"];
			editFSM.FinalStates = new IState[] {sh["2"]};
			editFSM.AddTransitions(CreateTransition(sh["1"], ih["a"], sh["1"]));
			editFSM.AddTransitions(CreateTransition(sh["1"], ih["b"], sh["1"]));
			editFSM.AddTransitions(CreateTransition(sh["1"], ih["c"], sh["2"]));
			return editFSM;
		}

		/// <summary>
		/// D
		/// </summary>
		/// <returns></returns>
		public static IFiniteStateMachine CreateTestRegexFSMComplex()
		{
			IEditableFiniteStateMachine editFSM = FSMFactory.CreateEmptyFSM();

			InputSymbolHash ih = FSMFactory.CreateInputFromList("a", "b", "c", "d", "e", "f", "g", "h", "i");
			editFSM.AddInputSymbols(ih.StoredInputs);

			StateHash sh;
			sh = CreateStates("1", "2", "3", "4");
			editFSM.AddStates(sh.StoredStates);
			editFSM.StartState = sh["1"];
			editFSM.FinalStates = new IState[] {sh["4"]};
			editFSM.AddTransitions(CreateTransition(sh["1"], ih["e"], sh["1"]));
			editFSM.AddTransitions(CreateTransition(sh["1"], ih["c"], sh["2"]));
			editFSM.AddTransitions(CreateTransition(sh["1"], ih["a"], sh["3"]));
			editFSM.AddTransitions(CreateTransition(sh["2"], ih["d"], sh["1"]));
			editFSM.AddTransitions(CreateTransition(sh["2"], ih["f"], sh["4"]));
			editFSM.AddTransitions(CreateTransition(sh["3"], ih["b"], sh["1"]));
			editFSM.AddTransitions(CreateTransition(sh["3"], ih["h"], sh["4"]));
			editFSM.AddTransitions(CreateTransition(sh["4"], ih["i"], sh["3"]));
			editFSM.AddTransitions(CreateTransition(sh["4"], ih["g"], sh["2"]));
			return editFSM;
		}

		/// <summary>
		/// E
		/// </summary>
		/// <returns></returns>
		public static IFiniteStateMachine CreateTestRegexFSM1()
		{
			IEditableFiniteStateMachine editFSM = FSMFactory.CreateEmptyFSM();

			InputSymbolHash ih = FSMFactory.CreateInputFromList("a", "b", "c", "d", "e", "f");
			editFSM.AddInputSymbols(ih.StoredInputs);

			StateHash sh;
			sh = CreateStates("1", "2", "3");
			editFSM.AddStates(sh.StoredStates);
			editFSM.StartState = sh["1"];
			editFSM.FinalStates = new IState[] {sh["3"]};
			editFSM.AddTransitions(CreateTransition(sh["1"], ih["e"], sh["1"]));
			editFSM.AddTransitions(CreateTransition(sh["1"], ih["a"], sh["2"]));
			editFSM.AddTransitions(CreateTransition(sh["1"], ih["c"], sh["3"]));
			editFSM.AddTransitions(CreateTransition(sh["2"], ih["b"], sh["1"]));
			editFSM.AddTransitions(CreateTransition(sh["2"], ih["f"], sh["3"]));
			editFSM.AddTransitions(CreateTransition(sh["3"], ih["d"], sh["1"]));
			return editFSM;
		}

		/// <summary>
		/// IFiniteStateMachine with Attributes.
		/// </summary>
		/// <returns></returns>
		public static IFiniteStateMachine CreateTestFSMWithAttributes()
		{
			IEditableFiniteStateMachine editFSM = FSMFactory.CreateEmptyFSM();

			InputSymbolHash ih = FSMFactory.CreateInputFromList("a", "b", "c", "d", "e", "f");
			editFSM.AddInputSymbols(ih.StoredInputs);

			StateHash sh;
			sh = CreateStates("1", "2", "3");
			editFSM.AddStates(sh.StoredStates);
			editFSM.StartState = sh["1"];
			editFSM.FinalStates = new IState[] {sh["3"]};
			editFSM.AddTransitions(CreateTransition(sh["1"], ih["e"], sh["1"]));
			editFSM.AddTransitions(CreateTransition(sh["1"], ih["a"], sh["2"]));
			editFSM.AddTransitions(CreateTransition(sh["1"], ih["c"], sh["3"]));
			editFSM.AddTransitions(CreateTransition(sh["2"], ih["b"], sh["1"]));
			editFSM.AddTransitions(CreateTransition(sh["2"], ih["f"], sh["3"]));
			editFSM.AddTransitions(CreateTransition(sh["3"], ih["d"], sh["1"]));

			foreach(IState state in editFSM.States)
			{
				state.Attributes.Add(RandomVariable.AttributeType,new RandomVariable());
			}
			foreach(ITransition transition in editFSM.Transitions)
			{
				transition.Attributes.Add(RandomVariable.AttributeType,new RandomVariable());
			}

			return editFSM;
		}

		/// <summary>
		/// IFiniteStateMachine with Attributes.
		/// </summary>
		/// <returns></returns>
		public static IFiniteStateMachine CreateLoopFSM()
		{
			IEditableFiniteStateMachine editFSM = FSMFactory.CreateEmptyFSM();

			InputSymbolHash ih = FSMFactory.CreateInputFromList("a");
			editFSM.AddInputSymbols(ih.StoredInputs);

			StateHash sh;
			sh = CreateStates("1");
			editFSM.AddStates(sh.StoredStates);
			editFSM.StartState = sh["1"];
			editFSM.FinalStates = new IState[] {sh["1"]};
			editFSM.AddTransitions(CreateTransition(sh["1"], ih["a"], sh["1"]));
			return editFSM;
		}

	}
}