using System;
using System.Collections;

namespace FSM
{
	/// <summary>
	/// An interface witch helps to store all relevant data of a FSM.
	/// </summary>
	public interface Setters
	{
		/// <summary>
		/// Sets a transition of a FSM.
		/// </summary>
		/// <param name="tr">The transition witch should be stored.</param>
		void setTransition(Transition tr);
		/// <summary>
		/// Sets a array of transitions of a FSM.
		/// </summary>
		/// <param name="tr">The array of transitions.</param>
		void setTransitions(Transition[] tr);
		/// <summary>
		/// Returns all transitions of a FSM.
		/// </summary>
		/// <returns>A Hashtable of witch contains all transitions.</returns>
		Hashtable getTransitions();
		/// <summary>
		/// Returns the input of a FSM.
		/// </summary>
		/// <returns>A Set witch contains the input of the FSM.</returns>
		Set getInputAl();
	}
}
