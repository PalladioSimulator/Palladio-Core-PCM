/*
 * $Id$
 * 
 * $Log$
 * Revision 1.1  2004/10/25 07:07:22  sliver
 * implementation of
 * - functions discrete, including convolution
 * - path segmentation of FSMs
 * - prediction of time consuption using density functions
 *
 */
using System;
using NUnit.Framework;
using Palladio.FiniteStateMachines;
#if TEST

namespace Palladio.Reliability.Paths.Tests
{
	/// <summary>
	/// </summary>
	[TestFixture]
	public class PathTest
	{
		[Test]
		public void GetPaths()
		{
			IPath[] expFinalPaths, expCyclicPaths;
			IFiniteStateMachine fsm = CreateTestFSM(out expFinalPaths, out expCyclicPaths);

			IFSMPaths paths = new FSMPaths(fsm);

			Assert.AreEqual(expFinalPaths.Length, paths.FinalPaths.Length);
			Assert.AreEqual(expCyclicPaths.Length, paths.CyclicPaths.Length);
			foreach (IPath path in expCyclicPaths)
			{
				Assert.IsTrue(Array.IndexOf(paths.CyclicPaths, path) >= 0);
			}
			foreach (IPath path in expFinalPaths)
			{
				Assert.IsTrue(Array.IndexOf(paths.FinalPaths, path) >= 0);
			}
		}

		public static StateHash CreateStates(params string[] anIDArray)
		{
			StateHash result = new StateHash();
			foreach (string id in anIDArray)
			{
				IState state = CreateState(id);
				result.Add(state);
			}
			return result;
		}

		public static ITransition CreateTransition(IState from, IInput i, IState to)
		{
			ITransition transition = FSMFactory.CreateDefaultTransition(
				from,
				i,
				to);
			return transition;
		}

		public static IState CreateState(string anID)
		{
			IState s = FSMFactory.CreateDefaultState(anID);
			return s;
		}

		public static IFiniteStateMachine CreateTestFSM(out IPath[] expFinalPaths, out IPath[] expCyclicPaths)
		{
			IEditableFiniteStateMachine editFSM = FSMFactory.CreateEmptyFSM();

			InputSymbolHash ih = FSMFactory.CreateInputFromList("a", "b", "c");
			editFSM.AddInputSymbols(ih.StoredInputs);
			StateHash sh = CreateStates("1", "2", "3", "4", "5");
			editFSM.AddStates(sh.StoredStates);
			editFSM.StartState = sh["1"];
			editFSM.FinalStates = new IState[] {sh["4"]};

			editFSM.AddTransitions(CreateTransition(sh["1"], ih["a"], sh["2"]));
			editFSM.AddTransitions(CreateTransition(sh["1"], ih["b"], sh["3"]));
			editFSM.AddTransitions(CreateTransition(sh["2"], ih["a"], sh["2"]));
			editFSM.AddTransitions(CreateTransition(sh["2"], ih["b"], sh["3"]));
			editFSM.AddTransitions(CreateTransition(sh["2"], ih["c"], sh["4"]));
			editFSM.AddTransitions(CreateTransition(sh["3"], ih["c"], sh["3"]));
			editFSM.AddTransitions(CreateTransition(sh["3"], ih["a"], sh["2"]));
			editFSM.AddTransitions(CreateTransition(sh["3"], ih["b"], sh["4"]));

			expFinalPaths = new IPath[4];
			expFinalPaths[0] = new Path(editFSM.StartState);
			expFinalPaths[0].Append(editFSM.GetNextTransition(expFinalPaths[0].ExitState, ih["a"]));
			expFinalPaths[0].Append(editFSM.GetNextTransition(expFinalPaths[0].ExitState, ih["c"]));

			expFinalPaths[1] = new Path(editFSM.StartState);
			expFinalPaths[1].Append(editFSM.GetNextTransition(expFinalPaths[1].ExitState, ih["b"]));
			expFinalPaths[1].Append(editFSM.GetNextTransition(expFinalPaths[1].ExitState, ih["b"]));

			expFinalPaths[2] = new Path(editFSM.StartState);
			expFinalPaths[2].Append(editFSM.GetNextTransition(expFinalPaths[2].ExitState, ih["a"]));
			expFinalPaths[2].Append(editFSM.GetNextTransition(expFinalPaths[2].ExitState, ih["b"]));
			expFinalPaths[2].Append(editFSM.GetNextTransition(expFinalPaths[2].ExitState, ih["b"]));

			expFinalPaths[3] = new Path(editFSM.StartState);
			expFinalPaths[3].Append(editFSM.GetNextTransition(expFinalPaths[3].ExitState, ih["b"]));
			expFinalPaths[3].Append(editFSM.GetNextTransition(expFinalPaths[3].ExitState, ih["a"]));
			expFinalPaths[3].Append(editFSM.GetNextTransition(expFinalPaths[3].ExitState, ih["c"]));

			expCyclicPaths = new IPath[3];
			expCyclicPaths[0] = new Path(sh["2"]);
			expCyclicPaths[0].Append(editFSM.GetNextTransition(sh["2"], ih["a"]));

			expCyclicPaths[1] = new Path(sh["3"]);
			expCyclicPaths[1].Append(editFSM.GetNextTransition(sh["3"], ih["c"]));

			expCyclicPaths[2] = new Path(sh["2"]);
			expCyclicPaths[2].Append(editFSM.GetNextTransition(sh["2"], ih["b"]));
			expCyclicPaths[2].Append(editFSM.GetNextTransition(sh["3"], ih["a"]));

			return editFSM;
		}
	}
}

#endif