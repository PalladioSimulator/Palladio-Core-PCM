/*
 * $Id$
 * 
 * $Log$
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
 * - prediction of time consuption using density functions
 *
 */


using Palladio.FiniteStateMachines;

namespace Palladio.RegularExpressions.Tests
{
	/// <summary>
	/// Description of TestCMBuilder.	
	/// </summary>
	public class TestBuilder : Helper
	{
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
	}
}