using System;
using FiniteStateMachines;
using Utils.Collections;

namespace FiniteStateMachines.Decorators
{
	/// <summary>
	/// A <code>PowerSetState</code> consists of a set of regular states. 
	/// </summary>
	public class PowerSetState : AbstractState {
		
		/// <summary>
		/// Denotes this state as a start state of the
		/// finite state machine it belongs to.
		/// </summary>
		private bool isStartState;

		/// <summary>
		/// A Set of states forming the <code>PowerSetState</code>.
		/// </summary>
		private Set stateSet;


		/// <summary>
		/// Creates a new <code>PowerSetState</code> consisting of
		/// the states in <code>aStateSet</code>.
		/// </summary>
		/// <param name="aStateSet">A set of regular states.</param>
		/// <param name="isStartState">Denotes this state as a start state.</param>
		public PowerSetState(Set aStateSet,bool isStartState) {
			this.isStartState = isStartState;
			stateSet = (Set)aStateSet.Clone();
		}

		
		/// <summary>
		/// Creates a new <code>PowerSetState</code> containing only 
		/// the state <code>aState</code>.
		/// </summary>
		/// <param name="aState">A regular state.</param>
		public PowerSetState(AbstractState aState) {
			this.isStartState = aState.IsStartState;
			stateSet = new Set();
			stateSet.Add(aState);
		}

		
		/// <summary>
		/// A Set of states forming the <code>PowerSetState</code>.
		/// </summary>
		public Set States {
			get {
				return stateSet;
			}
		}


		/// <summary>
		/// Denotes this state as a start state of the
		/// finite state machine it belongs to.
		/// </summary>
		public override bool IsStartState { 
			get{
				return isStartState;
			}
		}

		
		/// <summary>
		/// Denotes this state as a final state of the
		/// finite state machine it belongs to.
		/// 
		/// If one of the states of the set is a final state,
		/// this state is a final state.
		/// </summary>
		public override bool IsFinalState { 
			get{
				foreach (AbstractState state in stateSet) {
					if (state.IsFinalState){
						return true;
					}
				}
				return false;
			}
		}

		
		/// <summary>
		/// The name of the state.
		/// </summary>
		public override string Name { 
			get{
				string result = "(";
				foreach (AbstractState state in stateSet) {
					result += " "+state;
				}
				result += " )";
				return result;
			}
		}
	}
}
