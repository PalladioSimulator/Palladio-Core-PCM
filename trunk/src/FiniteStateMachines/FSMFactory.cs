using System;
using System.Collections;
using Utils.Collections;
using Palladio.FiniteStateMachines.Decorators;
using Palladio.ParameterisedContracts;

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
		/// Generates an empty factory
		/// </summary>
		public FSMFactory()
		{
		}

		/// <summary>
		/// Generates an empty FiniteStateMachine.
		/// </summary>
		/// <returns>An empty FSM</returns>
		public IFiniteStateMachine CreateFSM()
		{
			return new TabularFSM();
		}


		/// <summary>
		///		Creates a new FSM containing only aStartState.
		/// </summary>
		/// <param name="aStartState">Start-State of the new FSM.</param>
		/// <returns>new FSM</returns>
		public IFiniteStateMachine CreateFSM(IState aStartState)
		{
			return new TabularFSM(aStartState);
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
			result.Load(aFileDestination);
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
			return new TabularFSM(aTransitionList); 
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
			FiniteCrossProductMaschineLazy product = new FiniteCrossProductMaschineLazy(aFSM,anotherFSM);
			return product;
		}


		/// <summary>
		/// Minizes a given FiniteStateMachine
		/// </summary>
		/// <param name="aFSM">The FiniteStateMachine, which should be reduced</param>
		/// <returns>An<code>IFiniteStateMachine</code>whitch contains the reduced machine</returns>
		public IFiniteStateMachine Minimize(IFiniteStateMachine aFSM)
		{
			return new MinimisedFSM(aFSM);
		}


		/// <summary>
		///     The FiniteStateMachineExpander reconstructs all epsilon
		///     transitions of the reduced automaton by means of
		///     the transitions in the original automaton.
		/// 
		///     The reduced automaton has to accomplish
		///     several constraints:
		///     - it must _NOT_ contain epsilon transitions
		///     - it must accept a language which is a subset
		///       of the language accepted by the original automaton.
		/// 
		///     An epsilon transition is a transition with an
		///     input symbol contained by the epsilon alphabet.
		///     The epsilon alphabet is a subset of the input
		///     alphabet of the original automaton.
		/// <param name="aOriginalMachine">
		///     Automaton used for reconstructing the
		///     epsilon transition in the reduced
		///     automaton.
		/// </param>
		/// <param name="aReducedMachine">
		///     A reduced version of the original automaton.
		///     It does not contain any epsilon transition and
		///     the accepted language is a subset of the language
		///     accepted by the original automaton.
		/// </param>
		/// <param name="anEpsilonAlphabet">
		///     Set of symbols interpreted as epsilon input.
		///     It has to be a subset of the input alphabet of
		///     the original automaton.
		/// </param>
		/// <returns>A new IFiniteStateMachine representing the
		///     expanded version of the reduced automaton.
		///     "Expanded" means that it contains all possible
		///     epsilon transitions regarding to the original
		///     automaton.</returns>
		public IFiniteStateMachine Expand(IFiniteStateMachine aFiniteStateMachine,IFiniteStateMachine areducedFiniteStateMachine,Set anEpsilonAlphabet)
		{
			return new FSMExpander(aFiniteStateMachine,areducedFiniteStateMachine,anEpsilonAlphabet).GetExpandedMachine();
		}


		/// <summary>
		///		The MachineReducer reduces a FSM using a set of other FSMs. 
		///		It is assumed, that the FSM which should be reduced is a 
		///		somehow modified StackFiniteStateMachine.
		///		
		///		The reduction of the source FSM is done by graph grammars, 
		///		using some essential modifications to meet the performance 
		///		requirements.
		///		
		///		So whats different to graph grammars:
		///			
		///		At first we don't have any indeterminism in our algorithm. It is
		///		always clear where a rule has to be applied and which one it must
		///		be. This is because we begin our application at the start state of the 
		///		FSM and walk from there trough the whole automaton. We know the rule
		///		to apply because of the calling transitions of the subautomatons. We
		///		also know, that the result of the application can only be a transiton,
		///		labeled the same as the calling transition.
		///		
		///		An other point is the possibility of recursive calls during a Match. If
		///		an other calling transition is found during a Match the corresponding Match 
		///		function is called recursively. This avoids the necessity of resets.
		/// <param name="aRuleTable">
		///		Set of rules which should be applied to the machine.
		/// </param>
		/// <param name="anMachine">
		///		The machine affected by the rules.
		/// </param>
		/// <returns>A new, reduced machine.</returns>
		public IFiniteStateMachine Reduce(Hashtable aServiceTable, IFiniteStateMachine aMachine)
		{
			FSMReducer reduce = new FSMReducer(aServiceTable,aMachine);
			return reduce.GetReducedMachine();
		}

	}	
}
