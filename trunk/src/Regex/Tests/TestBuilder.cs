/*
 * $Id$
 * 
 * $Log$
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


using System;
using Palladio.ComponentModel;
using Palladio.FiniteStateMachines;

namespace Palladio.Reliability.Regex.Tests
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
			editFSM.AddTransitions(CreateTransition(sh["1"], ih["a"], sh["2"], 0.7));
			editFSM.AddTransitions(CreateTransition(sh["2"], ih["b"], sh["1"], 0.6));
			editFSM.AddTransitions(CreateTransition(sh["1"], ih["c"], sh["3"], 0.3));
			editFSM.AddTransitions(CreateTransition(sh["2"], ih["a"], sh["4"], 0.4));
			editFSM.AddTransitions(CreateTransition(sh["3"], ih["d"], sh["5"], 1.0));
			editFSM.AddTransitions(CreateTransition(sh["4"], ih["d"], sh["5"], 1.0));
			return editFSM;
		}

		public static IFiniteStateMachine CreateTestMeltingFSM()
		{
			IEditableFiniteStateMachine editFSM = FSMFactory.CreateEmptyFSM();

			InputSymbolHash ih = FSMFactory.CreateInputFromList("a", "b", "c", "d","e","f");
			editFSM.AddInputSymbols(ih.StoredInputs);

			StateHash sh;
			sh = CreateStates("1", "2", "3");
			editFSM.AddStates(sh.StoredStates);
			editFSM.StartState = sh["1"];
			editFSM.FinalStates = new IState[] {sh["3"]};
			editFSM.AddTransitions(CreateTransition(sh["1"], ih["a"], sh["2"], 0.1));
			editFSM.AddTransitions(CreateTransition(sh["1"], ih["b"], sh["2"], 0.2));
			editFSM.AddTransitions(CreateTransition(sh["1"], ih["c"], sh["2"], 0.3));
			editFSM.AddTransitions(CreateTransition(sh["1"], ih["d"], sh["3"], 0.1));
			editFSM.AddTransitions(CreateTransition(sh["1"], ih["e"], sh["3"], 0.4));
			editFSM.AddTransitions(CreateTransition(sh["2"], ih["f"], sh["3"], 1.0));
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
			editFSM.AddTransitions(CreateTransition(sh["1"], ih["a"], sh["1"], 0.3));
			editFSM.AddTransitions(CreateTransition(sh["1"], ih["b"], sh["1"], 0.4));
			editFSM.AddTransitions(CreateTransition(sh["1"], ih["c"], sh["2"], 0.3));
			return editFSM;
		}
	}
}