using System;
using System.Collections;
using Utils.Collections;
using Palladio.FiniteStateMachines.DefaultFSM;

namespace Palladio.FiniteStateMachines
{
	/// <summary>
	/// This Factory Generates a different kinds of FSMs. With this Factory you can merge, intersect,... 
	/// FiniteStateMachines.
	/// 
	/// This class deals with the Factory Method Pattern. 
	/// </summary>
	public class FSMFactory
	{
		/// <summary>
		/// Generates an empty FiniteStateMachine.
		/// </summary>
		/// <returns>An empty FSM</returns>
		public static IEditableFiniteStateMachine CreateEmptyFSM()
		{
			return new TabularFSM();
		}

		/// <summary>
		///		Creates a new FSM containing only aStartState.
		/// </summary>
		/// <param name="aStartState">Start-State of the new FSM.</param>
		/// <returns>new FSM</returns>
		public static IEditableFiniteStateMachine CreateFSM(IState aStartState)
		{
			IEditableFiniteStateMachine fsm = new TabularFSM();
			fsm.AddStates(aStartState);
			fsm.StartState = aStartState;
			return fsm;
		}

		/// <summary>
		/// Construct a state with the given payload
		/// </summary>
		/// <param name="payload">A payload object characterizing the state to be constructed</param>
		/// <returns>An IState representing the new state</returns>
		public static IState CreateDefaultState(string anID)
		{
			return new DefaultState(anID);
		}

		/// <summary>
		/// Create a transition from the given start state to the given end state with the 
		/// given input symbol
		/// </summary>
		/// <param name="start">The start state</param>
		/// <param name="input">The input symbol</param>
		/// <param name="end">The end state</param>
		/// <returns>The transition representing the parameters</returns>
		public static ITransition CreateDefaultTransition(IState start, IInput input, IState end)
		{
			return new DefaultTransition(start,input,end);
		}

		/// <summary>
		/// Create an input symbol to be used in transitions
		/// </summary>
		/// <param name="payload">The ID of the input symbol</param>
		/// <returns>The created input symbol</returns>
		public static IInput CreateDefaultInput(string anID)
		{
			return new DefaultInput(anID);
		}

		/// <summary>
		/// Convert the given FSM into a FSM which can be edited
		/// </summary>
		/// <param name="fsm">The FSM to convert</param>
		/// <returns>The given FSM in an editable mode</returns>
		public static IEditableFiniteStateMachine GetEditableFSM(IFiniteStateMachine fsm)
		{
			if (fsm is IEditableFiniteStateMachine)
			{
				return (IEditableFiniteStateMachine)fsm;
			}
			else
			{
				/// TODO!!!
				return null;
			}
		}

		/// <summary>
		/// Create an array of input symbols from a given list of strings
		/// </summary>
		/// <param name="objs">A list of objects, each one will be uses as input symbol</param>
		/// <returns>An array of input symbols</returns>
		public static InputSymbolHash CreateInputFromList(params string[] anIDArray)
		{
			InputSymbolHash result = new InputSymbolHash();

			foreach (string str in anIDArray)
			{
				result.Add(str,CreateDefaultInput(str));
			}
			return result;
		}

		/// <summary>
		/// Create an array of input symbols from a given list of strings
		/// </summary>
		/// <param name="objs">A list of objects, each one will be uses as input symbol</param>
		/// <returns>An array of input symbols</returns>
		public static StateHash CreateStatesFromList(params string[] anIDArray)
		{
			StateHash result = new StateHash();

			foreach (string str in anIDArray)
			{
				result.Add(str,CreateDefaultState(str));
			}
			return result;
		}

		/// <summary>
		///		Creates a tabular FSMs using a xml-file as input.
		///		An example is listed below:
		/// 
		/// <?xml version="1.0" encoding="utf-8" ?> 
		/// <fsm>
		///		<state name="one" start="true"/>
		///		<state name="two" final="true"/>
		///		
		///		<transition source="one" target="one" input="d2"/>
		///		<transition source="one" target="two" input="d1"/>
		///		<transition source="two" target="two" input="d2"/>
		/// </fsm>
		/// 
		/// </summary>
		public IFiniteStateMachine CreateFSMFromFile(string aFileDestination)
		{
		
			TabularFSM result = new TabularFSM();
#if false
			result.Load(aFileDestination);
#endif
			return result;
		}


		/// <summary>
		///		Creates a new finite state machine using an array of transitions.
		/// </summary>
		/// <param name="aTransitionList">
		///		All transitions of the finite state machine.
		///	</param>
		///	<returns>
		///		
		///	</returns>
		public IFiniteStateMachine CreateFSM(IList aTransitionList)
		{
			// return new TabularFSM(aTransitionList); 
			return null;
		}

		
#if false
		/// <summary>
		/// Minimizes a given FiniteStateMachine
		/// </summary>
		/// <param name="aFSM">The FiniteStateMachine, which should be reduced</param>
		/// <returns>An IFiniteStateMachine which contains the reduced machine</returns>
		public static IFiniteStateMachine Minimize(IFiniteStateMachine aFSM)
		{
			return new MinimisedFSM(aFSM);
		}

		/// <summary>
		/// This FiniteStateMachine only contains Transitions and the Inputs which is in both
		/// given FSMs. Its the intersection of two FSMs in the representation of new 
		/// FiniteTabularMachine.
		/// </summary>
		/// <param name="aFSM">The first FiniteStateMachine</param>
		/// <param name="anotherFSM">The other FiniteStateMachine</param>
		/// <returns>The intersection of the two FiniteStateMachines</returns>
		public IFiniteStateMachine Intersect(IFiniteStateMachine aFSM, IFiniteStateMachine anotherFSM)
		{
			FiniteCrossProductMaschineLazy cross = new FiniteCrossProductMaschineLazy(aFSM,anotherFSM);
			return cross;
		}

		

		/// <summary>
		/// This methods generates a specialization of a normal FSM. Is generated out
		/// of two FSMs. It looks like:
		/// FSM A, FSM B 
		/// FSP(A B)={
		/// Input: (Input A + Input B);
		/// StartState: ((Startstate A, StartState B)) 
		/// FinalState: ((FinalState A, FinalState B))
		/// FSPState: ((aState of A, aState of B))
		/// ITransition: ((FSPState x, Input i, FSPState y) |
		///		1. i is in Input A and Input B:  
		///			FSPState y =(a State of A.next reachable with i),(a State of B.next reachable with i))
		///		2. i is in Input A and not in Input B:
		///			FSPState y =(a State of A.next reachable with i),(a State of B))
		///		3. i is in Input B and not in Input A
		///			FSPState y =(a State of A),(a State of B.next reachable with i))
		///		4. i is not in Input A and not in Inptut B
		///			FSPState Y = ErrorState.
		/// </summary>
		/// <param name="aFSM">The first FiniteStateMachine</param>
		/// <param name="anotherFSM">The other FiniteStateMachine</param>
		/// <returns>The result of merging the two FiniteStateMachines in a representation of a <code>IFiniteStateMachine</code></returns>
		public IFiniteStateMachine Merge(IFiniteStateMachine aFSM, IFiniteStateMachine anotherFSM)
		{
			FiniteShuffleProductMaschine product = new FiniteShuffleProductMaschine(aFSM,anotherFSM);
			return product.ShuffleProduct;
		}


		/// <summary>
		/// Compares two FSMs.
		/// Two FSMs are considered as equal, if they accept the same language.
		/// </summary>
		/// <param name="aFsmOne"></param>
		/// <param name="aFsmTwo"></param>
		/// <returns>
		/// True if the two FSMs accept the same language, false otherwise.
		/// </returns>
		public static bool AreEqual( IFiniteStateMachine aFsmOne, IFiniteStateMachine aFsmTwo ) 
		{
			IFiniteStateMachine minOne = new MinimisedFSM(aFsmOne);
			IFiniteStateMachine minTwo = new MinimisedFSM(aFsmTwo);

			DynamicStateIterator iter = new DynamicStateIterator(new DualState(aFsmOne.StartState,aFsmTwo.StartState));
			while (iter.MoveNext()) 
			{
				DualState current = (DualState) iter.Current;
				if ((current.oneState.IsFinalState == current.twoState.IsFinalState) &&
					(current.oneState.IsStartState == current.twoState.IsStartState)) 
				{
					foreach (Input input in minOne.InputAlphabet) 
					{
						if (minOne.GetOutgoingTransitions(current.oneState).Count == minTwo.GetOutgoingTransitions(current.twoState).Count )
						{
							IState nextOne = minOne.GetNextState(current.oneState, input);
							IState nextTwo = minTwo.GetNextState(current.twoState, input);	
							if (( nextOne != minOne.ErrorState ) &&
								( nextTwo != minTwo.ErrorState )) 
							{
								iter.Append(new DualState (nextOne, nextTwo));
							} 
							else 
							{
								// At this point at least one of the states is 
								// an ErrorState. If both states are ErrorStates the FSMs
								// can still be equivalent, else they are not.
								if (( nextOne != minOne.ErrorState ) ||
									( nextTwo != minTwo.ErrorState )) 
								{
									return false;
								}
							}
						} 
						else 
						{
							return false;
						}
					}
				} 
				else 
				{
					return false;
				}
			}
			return true;
		}
#endif
	}	
}
