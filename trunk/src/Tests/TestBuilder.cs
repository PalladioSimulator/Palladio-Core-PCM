/*
 * $Id$
 * 
 * $Log$
 * Revision 1.1  2004/10/25 07:07:21  sliver
 * implementation of
 * - functions discrete, including convolution
 * - path segmentation of FSMs
 * - prediction of time consuption using density functions
 *
 */


using Palladio.ComponentModel;
using Palladio.FiniteStateMachines;

namespace Palladio.Reliability.Tests
{
	/// <summary>
	/// Description of TestCMBuilder.	
	/// </summary>
	public class TestBuilder : Helper
	{
		public static IFiniteStateMachine CreateTestFSM1()
		{
			IEditableFiniteStateMachine editFSM = FSMFactory.CreateEmptyFSM();

			ISignature[] sigs = ComponentFactory.CreateSignatureArray("a", "b", "c", "d", "e");
			IInput[] inputs = FSMFactory.CreateInputFromList((IMatchable[]) sigs).StoredInputs;
			editFSM.AddInputSymbols(inputs);

			StateHash sh;
			sh = CreateStates("1", "2", "3", "4", "5");
			editFSM.AddStates(sh.StoredStates);
			editFSM.StartState = sh["1"];
			editFSM.FinalStates = new IState[] {sh["3"], sh["5"]};
			editFSM.AddTransitions(CreateTransition(sh["1"], sigs[0], sh["2"], 0.2));
			editFSM.AddTransitions(CreateTransition(sh["1"], sigs[1], sh["2"], 0.7));
			editFSM.AddTransitions(CreateTransition(sh["1"], sigs[2], sh["4"], 0.1));
			editFSM.AddTransitions(CreateTransition(sh["2"], sigs[0], sh["3"], 1.0));
			editFSM.AddTransitions(CreateTransition(sh["3"], sigs[4], sh["1"], 0.5));
			editFSM.AddTransitions(CreateTransition(sh["3"], sigs[3], sh["4"], 0.3));
			editFSM.AddTransitions(CreateTransition(sh["4"], sigs[3], sh["5"], 1.0));
			editFSM.AddTransitions(CreateTransition(sh["5"], sigs[4], sh["2"], 0.4));
			return editFSM;
		}

		public static IFiniteStateMachine CreateTestMarkovModel0()
		{
			IEditableFiniteStateMachine editFSM = FSMFactory.CreateEmptyFSM();

			InputSymbolHash ih = FSMFactory.CreateInputFromList("a", "b", "c", "d");
			editFSM.AddInputSymbols(ih.StoredInputs);

			StateHash sh;
			sh = CreateStates("1", "2", "3", "4");
			editFSM.AddStates(sh.StoredStates);
			editFSM.StartState = sh["1"];
			editFSM.FinalStates = new IState[] {sh["4"]};
			editFSM.AddTransitions(CreateTransition(sh["1"], ih["a"], sh["2"], 0.5));
			editFSM.AddTransitions(CreateTransition(sh["2"], ih["b"], sh["1"], 1.0));
			editFSM.AddTransitions(CreateTransition(sh["1"], ih["d"], sh["4"], 0.5));
			return editFSM;
		}

		public static IFiniteStateMachine CreateTestMarkovModel1()
		{
			IEditableFiniteStateMachine editFSM = FSMFactory.CreateEmptyFSM();

			InputSymbolHash ih = FSMFactory.CreateInputFromList("a", "b", "c", "d");
			editFSM.AddInputSymbols(ih.StoredInputs);

			StateHash sh;
			sh = CreateStates("1", "2", "3", "4");
			editFSM.AddStates(sh.StoredStates);
			editFSM.StartState = sh["1"];
			editFSM.FinalStates = new IState[] {sh["4"]};
			editFSM.AddTransitions(CreateTransition(sh["1"], ih["a"], sh["2"], 0.3));
			editFSM.AddTransitions(CreateTransition(sh["2"], ih["b"], sh["1"], 1.0));
			editFSM.AddTransitions(CreateTransition(sh["1"], ih["c"], sh["3"], 0.4));
			editFSM.AddTransitions(CreateTransition(sh["3"], ih["b"], sh["1"], 1.0));
			editFSM.AddTransitions(CreateTransition(sh["1"], ih["d"], sh["4"], 0.3));
			return editFSM;
		}

		public static IFiniteStateMachine CreateTestMarkovModel2()
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

		public static IFiniteStateMachine CreateTestFSMCompositional()
		{
			IEditableFiniteStateMachine editFSM = FSMFactory.CreateEmptyFSM();

			ISignature[] sigs = ComponentFactory.CreateSignatureArray("a", "b", "c", "d", "e");
			IInput[] srvs = FSMFactory.CreateInputFromList((IMatchable[]) sigs).StoredInputs;
			IInput callReturn = FSMFactory.CreateDefaultInput("return");

			editFSM.AddInputSymbols(srvs);
			editFSM.AddInputSymbols(callReturn);

			StateHash sh;
			sh = CreateStates("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18");
			editFSM.AddStates(sh.StoredStates);

			editFSM.StartState = sh["01"];
			editFSM.FinalStates = new IState[] {sh["13"]};

			// Provides
			editFSM.AddTransitions(CreateTransition(sh["01"], srvs[4], sh["02"], 0.4));
			editFSM.AddTransitions(CreateTransition(sh["01"], srvs[0], sh["08"], 0.6));
			editFSM.AddTransitions(CreateTransition(sh["13"], srvs[3], sh["14"], 0.5));
			editFSM.AddTransitions(CreateTransition(sh["04"], callReturn, sh["01"], 0.4));
			editFSM.AddTransitions(CreateTransition(sh["12"], callReturn, sh["13"], 0.5));
			editFSM.AddTransitions(CreateTransition(sh["18"], callReturn, sh["13"], 0.5));

			// E
			editFSM.AddTransitions(CreateTransition(sh["02"], srvs[0], sh["05"], 1.0));
			editFSM.AddTransitions(CreateTransition(sh["07"], srvs[1], sh["06"], 1.0));
			editFSM.AddTransitions(CreateTransition(sh["04"], srvs[2], sh["03"], 0.6));
			editFSM.AddTransitions(CreateTransition(sh["05"], callReturn, sh["07"], 1.0));
			editFSM.AddTransitions(CreateTransition(sh["06"], callReturn, sh["04"], 1.0));
			editFSM.AddTransitions(CreateTransition(sh["03"], callReturn, sh["02"], 1.0));


			// D 1
			editFSM.AddTransitions(CreateTransition(sh["08"], srvs[3], sh["09"], 0.3));
			editFSM.AddTransitions(CreateTransition(sh["08"], srvs[0], sh["10"], 0.7));
			editFSM.AddTransitions(CreateTransition(sh["12"], srvs[1], sh["11"], 0.5));
			editFSM.AddTransitions(CreateTransition(sh["09"], callReturn, sh["08"], 1.0));
			editFSM.AddTransitions(CreateTransition(sh["10"], callReturn, sh["12"], 1.0));
			editFSM.AddTransitions(CreateTransition(sh["11"], callReturn, sh["08"], 1.0));

			// D 2
			editFSM.AddTransitions(CreateTransition(sh["14"], srvs[3], sh["15"], 0.3));
			editFSM.AddTransitions(CreateTransition(sh["14"], srvs[0], sh["16"], 0.7));
			editFSM.AddTransitions(CreateTransition(sh["18"], srvs[1], sh["17"], 0.5));
			editFSM.AddTransitions(CreateTransition(sh["15"], callReturn, sh["14"], 1.0));
			editFSM.AddTransitions(CreateTransition(sh["16"], callReturn, sh["18"], 1.0));
			editFSM.AddTransitions(CreateTransition(sh["17"], callReturn, sh["14"], 1.0));
			return editFSM;
		}

		public static IFiniteStateMachine CreateTestFSM_D()
		{
			IEditableFiniteStateMachine editFSM = FSMFactory.CreateEmptyFSM();

			ISignature[] sigs = ComponentFactory.CreateSignatureArray("a", "b", "c");
			IInput[] srvs = FSMFactory.CreateInputFromList((IMatchable[]) sigs).StoredInputs;
			IInput callReturn = FSMFactory.CreateDefaultInput("return");

			editFSM.AddInputSymbols(srvs);
			editFSM.AddInputSymbols(callReturn);

			StateHash sh;
			sh = CreateStates("01", "02", "03", "04", "05");
			editFSM.AddStates(sh.StoredStates);

			editFSM.StartState = sh["01"];
			editFSM.FinalStates = new IState[] {sh["05"]};
			editFSM.AddTransitions(CreateTransition(sh["01"], srvs[2], sh["02"], 0.3));
			editFSM.AddTransitions(CreateTransition(sh["01"], srvs[0], sh["03"], 0.7));
			editFSM.AddTransitions(CreateTransition(sh["05"], srvs[1], sh["04"], 0.5));
			editFSM.AddTransitions(CreateTransition(sh["02"], callReturn, sh["01"], 1.0));
			editFSM.AddTransitions(CreateTransition(sh["03"], callReturn, sh["05"], 1.0));
			editFSM.AddTransitions(CreateTransition(sh["04"], callReturn, sh["01"], 1.0));
			return editFSM;
		}

		public static IFiniteStateMachine CreateTestFSM_E()
		{
			IEditableFiniteStateMachine editFSM = FSMFactory.CreateEmptyFSM();

			ISignature[] sigs = ComponentFactory.CreateSignatureArray("a", "b", "c");
			IInput[] srvs = FSMFactory.CreateInputFromList((IMatchable[]) sigs).StoredInputs;
			IInput callReturn = FSMFactory.CreateDefaultInput("return");

			editFSM.AddInputSymbols(srvs);
			editFSM.AddInputSymbols(callReturn);

			StateHash sh;
			sh = CreateStates("01", "02", "03", "04", "05", "06");
			editFSM.AddStates(sh.StoredStates);

			editFSM.StartState = sh["01"];
			editFSM.FinalStates = new IState[] {sh["03"]};
			editFSM.AddTransitions(CreateTransition(sh["01"], srvs[0], sh["04"], 1.0));
			editFSM.AddTransitions(CreateTransition(sh["06"], srvs[1], sh["05"], 1.0));
			editFSM.AddTransitions(CreateTransition(sh["03"], srvs[2], sh["02"], 0.6));
			editFSM.AddTransitions(CreateTransition(sh["04"], callReturn, sh["06"], 1.0));
			editFSM.AddTransitions(CreateTransition(sh["05"], callReturn, sh["03"], 1.0));
			editFSM.AddTransitions(CreateTransition(sh["02"], callReturn, sh["01"], 1.0));
			return editFSM;
		}

		public static IFiniteStateMachine CreateTestFSMProvides()
		{
			IEditableFiniteStateMachine editFSM = FSMFactory.CreateEmptyFSM();

			ISignature[] sigs = ComponentFactory.CreateSignatureArray("d", "e");
			IInput[] srvs = FSMFactory.CreateInputFromList((IMatchable[]) sigs).StoredInputs;
			IInput callReturn = FSMFactory.CreateDefaultInput("return");

			editFSM.AddInputSymbols(srvs);
			editFSM.AddInputSymbols(callReturn);

			StateHash sh;
			sh = CreateStates("01", "02", "03", "04", "05");
			editFSM.AddStates(sh.StoredStates);

			editFSM.StartState = sh["01"];
			editFSM.FinalStates = new IState[] {sh["04"]};
			editFSM.AddTransitions(CreateTransition(sh["01"], srvs[0], sh["02"], 0.4));
			editFSM.AddTransitions(CreateTransition(sh["01"], srvs[1], sh["03"], 0.6));
			editFSM.AddTransitions(CreateTransition(sh["04"], srvs[1], sh["05"], 0.5));
			editFSM.AddTransitions(CreateTransition(sh["02"], callReturn, sh["01"], 1.0));
			editFSM.AddTransitions(CreateTransition(sh["03"], callReturn, sh["04"], 1.0));
			editFSM.AddTransitions(CreateTransition(sh["05"], callReturn, sh["04"], 1.0));
			return editFSM;
		}

	}
}