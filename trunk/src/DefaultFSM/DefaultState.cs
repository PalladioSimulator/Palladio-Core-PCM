using System;
using System.Collections;

namespace Palladio.FiniteStateMachines.DefaultFSM
{
	/// <summary>
	/// This class represents a default state type of a finite state machine. 
	/// It is primarily used by the class FiniteTabularMachine.
	/// 
	/// author: JH
	///			StB
	/// </summary>
	internal class DefaultState : AbstractState 
	{
		/// <summary>
		/// Default constructor of a default state
		/// </summary>
		/// <param name="isErrorState">Determine if this state should represent an error condition</param>
		/// <param name="payload">The payload to be attached to the state</param>
		public DefaultState(string anID, Hashtable anAttTab, bool isErrorState) 
		{
			this.id = anID;
			this.attributeTable = anAttTab;
			this.isErrorState = isErrorState;
		}

		/// <summary>
		/// Default constructor of a default state which is NOT an error state
		/// </summary>
		/// <param name="payload">The payload to be attached to the state</param>
		public DefaultState(string anId, Hashtable anAttTab) : this (anId, anAttTab, false) {}
		
		public DefaultState(string anId) : this (anId, new Hashtable(), false) {}
		
		public DefaultState(string anID, bool isErrorState) : this (anID, new Hashtable(), isErrorState) {}
	}
}
