using System;
using System.Collections;
using Palladio.Attributes;
using Palladio.FiniteStateMachines;

namespace Palladio.RegularExpressions.GNFA
{
	/// <summary>
	/// Algorithm for the conversion of a FSM to a regular expression that
	/// accepts the same language. The conversion is done by constructing the
	/// GNFA and systematically removing states until only the start and accept state
	/// are left.
	/// </summary>
	internal class FSMToRegexConverter
	{
		/// <summary>
		/// Returns a regular expression that accepts the same language as
		/// the FSM.
		/// </summary>
		/// <param name="fsm"></param>
		/// <returns></returns>
		public static IRegEx Convert(IFiniteStateMachine fsm)
		{
			IEditableFiniteStateMachine gnfa = CreateGNFA(fsm);
			MeltTransitions(ref gnfa);
			while (gnfa.States.Length > 2)
			{
				IState state = PickState(gnfa);
				ConvertGNFA(ref gnfa, state);
			}
			// After the conversion there is only one transition left from the new start state
			// to the accept state. It's input symbol is the regular expression of the FSM
			return gnfa.GetOutgoingTransitions(gnfa.StartState)[0].InputSymbol as IRegEx;
		}

		/// <summary>
		/// Adds a unique accept state and new start state to the fsm. Furthermore, 
		/// all input symbols are converted to regular expressions.
		/// </summary>
		/// <param name="fsm"></param>
		/// <returns></returns>
		public static IEditableFiniteStateMachine CreateGNFA(IFiniteStateMachine fsm)
		{
			IEditableFiniteStateMachine gnfa = FSMFactory.CreateEmptyFSM();
			gnfa.AddStates(fsm.States);

			for (int i = 0; i < fsm.Transitions.Length; i++)
			{
				IState source = fsm.Transitions[i].SourceState;
				IState dest = fsm.Transitions[i].DestinationState;
				AttributeHash attributeHash = fsm.Transitions[i].Attributes.Clone() as AttributeHash;
				IInput input = RegexFactory.Symbol(attributeHash, fsm.Transitions[i].InputSymbol);
				ITransition transition = FSMFactory.CreateDefaultTransition(source, input, dest);

				gnfa.AddInputSymbols(input);
				gnfa.AddTransitions(transition);
			}

			ITransition startTransition = FSMFactory.CreateDefaultTransition(startState, epsilon, fsm.StartState);
			ITransition[] finalTransitions = new ITransition[fsm.FinalStates.Length];
			for (int i = 0; i < finalTransitions.Length; i++)
			{
				finalTransitions[i] = FSMFactory.CreateDefaultTransition(fsm.FinalStates[i], epsilon, acceptState);
			}

			gnfa.AddStates(startState, acceptState);
			gnfa.AddInputSymbols(epsilon);
			gnfa.AddTransitions(startTransition);
			gnfa.AddTransitions(finalTransitions);

			gnfa.StartState = startState;
			gnfa.FinalStates = new IState[] {acceptState};
			return gnfa;
		}

		/// <summary>
		/// Melts all transitions in fsm that have the same source and destination state.
		/// </summary>
		/// <param name="fsm"></param>
		public static void MeltTransitions(ref IEditableFiniteStateMachine fsm)
		{
			foreach (IState si in fsm.States)
			{
				ArrayList outgoing = new ArrayList(fsm.GetOutgoingTransitions(si));
				int numTransitions = outgoing.Count;
				for (int i = 0; i < numTransitions; i++)
				{
					ITransition ti = outgoing[i] as ITransition;
					fsm.DeleteTransitions(ti);
					for (int j = i + 1; j < numTransitions; j++)
					{
						ITransition tj = outgoing[j] as ITransition;
						if (ti.DestinationState.Equals(tj.DestinationState))
						{
							ti = Melt(ti, tj);
							fsm.DeleteTransitions(tj);
							outgoing.RemoveAt(j);
							j--; // set counter one position back, 
							// since the current position has been removed.
							numTransitions--;
						}
					}
					outgoing[i] = ti;
					fsm.AddInputSymbols(ti.InputSymbol); // a new input symbol was generated. 
					// it has to be added to the gnfa before
					// adding the new transition.
					fsm.AddTransitions(ti);
				}
			}
		}

		/// <summary>
		/// Removes state and all connected transitions from gnfa and introduces a new
		/// transition whose regular expression is equivalent to those transitions.
		/// </summary>
		/// <param name="gnfa"></param>
		/// <param name="state"></param>
		private static void ConvertGNFA(ref IEditableFiniteStateMachine gnfa, IState state)
		{
			ArrayList transitionList = new ArrayList();
			foreach (IState si in gnfa.States)
			{
				// visit all states si without the accept state and current state.
				if (si.Equals(acceptState) || si.Equals(state))
					continue;
				foreach (IState sj in gnfa.States)
				{
					// visit all states sj without the start state and current state.
					if (sj.Equals(startState) || sj.Equals(state))
						continue;

					ITransition transition = CreateMergedTransition(gnfa, si, sj, state);
					// if a transiton from si to sj over state is possible
					if (transition != null)
					{
						gnfa.AddInputSymbols(transition.InputSymbol);
						transitionList.Add(transition);
					}
				}
			}
			DeleteState(ref gnfa, state);
			if (transitionList.Count > 0)
				gnfa.AddTransitionList(transitionList);
			MeltTransitions(ref gnfa);
		}

		/// <summary>
		/// Deletes state and all connected transitions in gnfa.
		/// </summary>
		/// <param name="gnfa"></param>
		/// <param name="state"></param>
		private static void DeleteState(ref IEditableFiniteStateMachine gnfa, IState state)
		{
			gnfa.DeleteTransitions(GetIncomingTransitions(gnfa, state));
			gnfa.DeleteTransitions(GetOutgoingTransitions(gnfa, state));
			gnfa.DeleteStates(state);
		}

		/// <summary>
		/// Returns the transitions in gnfa leaving state.
		/// </summary>
		/// <param name="gnfa"></param>
		/// <param name="state"></param>
		/// <returns></returns>
		private static ITransition[] GetOutgoingTransitions(IFiniteStateMachine gnfa, IState state)
		{
			return gnfa.GetOutgoingTransitions(state);
		}

		/// <summary>
		/// Returns the transitions in gnfa pointing to state.
		/// </summary>
		/// <param name="gnfa"></param>
		/// <param name="state"></param>
		/// <returns></returns>
		private static ITransition[] GetIncomingTransitions(IFiniteStateMachine gnfa, IState state)
		{
			ArrayList incomingList = new ArrayList();
			foreach (ITransition transition in gnfa.Transitions)
			{
				if (state.Equals(transition.DestinationState))
					incomingList.Add(transition);
			}
			return (ITransition[]) incomingList.ToArray(typeof (ITransition));
		}

		/// <summary>
		/// For three states si,sj, and sr the merged transition from si to sj is returned. It
		/// is equivalent to all transitions going direclty from si to sj or over sr. If there 
		/// is no such transition null is returned.
		/// </summary>
		/// <param name="gnfa"></param>
		/// <param name="si"></param>
		/// <param name="sj"></param>
		/// <param name="sr"></param>
		/// <returns></returns>
		private static ITransition CreateMergedTransition(IEditableFiniteStateMachine gnfa, IState si, IState sj, IState sr)
		{
			IRegEx r1, r2, r3;
			r1 = r2 = r3 = null;
			foreach (ITransition transition in gnfa.GetOutgoingTransitions(si))
			{
				// r1 = t(si,sr)
				if (sr.Equals(transition.DestinationState))
					r1 = GetRegexFromTransition(transition);
			}
			foreach (ITransition transition in gnfa.GetOutgoingTransitions(sr))
			{
				// r2 = t(sr,sr)
				if (sr.Equals(transition.DestinationState))
					r2 = GetRegexFromTransition(transition);
					// r3 = t(sr,sj)
				else if (sj.Equals(transition.DestinationState))
					r3 = GetRegexFromTransition(transition);
			}

			IRegEx resultEx = GetTotalExpressionForTransition(r1, r2, r3);

			// no ingoing or outgoing transition for state sr
			if (resultEx == null)
				return null;

			return CreateTransition(si, resultEx, sj);

		}

		/// <summary>
		/// Creates a transition with a regular expression as input symbol.
		/// </summary>
		/// <param name="si"></param>
		/// <param name="regEx"></param>
		/// <param name="sj"></param>
		/// <returns></returns>
		private static ITransition CreateTransition(IState si, IRegEx regEx, IState sj)
		{
			return FSMFactory.CreateDefaultTransition(si, regEx, sj);
		}

		/// <summary>
		/// Returns the complete regular expression of the following form: r1 r2* r3
		/// null pointers for r1...r4 are allowed.
		/// r1 and r3 must exists to construct the left side of the expression.
		/// If the complete expression cannot be constructed due to missing subexpressions
		/// null is returned.
		/// </summary>
		/// <param name="r1"></param>
		/// <param name="r2"></param>
		/// <param name="r3"></param>
		/// <returns></returns>
		private static IRegEx GetTotalExpressionForTransition(IRegEx r1, IRegEx r2, IRegEx r3)
		{
			// regex = r1 r2* r3
			// r1 and r2 must exist to construct the left side of the new regex. 
			// They can be epsilon
			IRegEx resultEx = null;

			// construct the left side, if a transiton to and from sr exists.
			if ((r1 != null) && (r3 != null))
			{
				resultEx = r1;
				if ((r2 != null) && !r2.Equals(epsilon))
				{
					r2 = RegexFactory.Loop(r2);
					if (!resultEx.Equals(epsilon))
						resultEx = RegexFactory.Sequence(resultEx, r2);
					else
						resultEx = r2; // ignore the epsilon input
				}
				if (!r3.Equals(epsilon))
				{
					if (!resultEx.Equals(epsilon))
						resultEx = RegexFactory.Sequence(resultEx, r3);
					else
						resultEx = r3;
				}
			}
			return resultEx;
		}

		/// <summary>
		/// Returns the regular expression associated with the transition.
		/// </summary>
		/// <param name="transition"></param>
		/// <returns></returns>
		private static IRegEx GetRegexFromTransition(ITransition transition)
		{
			return transition.InputSymbol as IRegEx;
		}

		/// <summary>
		/// Picks a state from the gnfa that is not the start or accept state.
		/// </summary>
		/// <param name="gnfa"></param>
		/// <returns></returns>
		private static IState PickState(IFiniteStateMachine gnfa)
		{
			foreach (IState state in gnfa.States)
			{
				if (!(state.Equals(acceptState) || state.Equals(startState)))
					return state;
			}
			throw new ApplicationException("No state found different from start and accept state!");
		}

		/// <summary>
		/// Melts two transitions which have the same source- and destination-state.
		/// </summary>
		/// <param name="ti"></param>
		/// <param name="tj"></param>
		/// <returns></returns>
		private static ITransition Melt(ITransition ti, ITransition tj)
		{
			IInput regex = RegexFactory.Alternative(ti.InputSymbol as IRegEx, tj.InputSymbol as IRegEx);
			return FSMFactory.CreateDefaultTransition(ti.SourceState, regex, ti.DestinationState);
		}

		/// <summary>
		/// Creates an empty attribute hash.
		/// </summary>
		/// <returns></returns>
		private static AttributeHash CreateAttributeHash()
		{
			return AttributesFactory.Default.CreateAttributeHash();
		}

		private static IState startState = FSMFactory.CreateDefaultState("GNFA Start State");
		private static IState acceptState = FSMFactory.CreateDefaultState("GNFA Accept State");
		private static IInput epsilon = RegexFactory.Symbol(FSMFactory.CreateDefaultInput("GNFA Epsilon"));
	}
}