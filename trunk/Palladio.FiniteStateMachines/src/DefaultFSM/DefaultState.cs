using System;
using System.Collections;
using Palladio.Attributes;

namespace Palladio.FiniteStateMachines.DefaultFSM
{
	/// <summary>
	/// This class represents a default state type of a finite state machine. 
	/// It is primarily used by the class FiniteTabularMachine.
	/// 
	/// author: JH
	///			StB
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2005/04/05 14:23:31  joemal
	/// changes in Palladio.Attributes
	///
	/// Revision 1.1  2005/02/21 13:19:37  joemal
	/// initial import
	///
	///
	/// </pre>
	/// </remarks>
	internal class DefaultState : AbstractState 
	{
		/// <summary>
		/// Default constructor of a default state
		/// </summary>
		/// <param name="isErrorState">Determine if this state should represent an error condition</param>
		/// <param name="anAttTab">A Hashtable containing the attributes attached to this state</param>
		/// <param name="anID">ID of the state to create</param>
		public DefaultState(string anID, IAttributeHash anAttTab, bool isErrorState) 
		{
			this.id = anID;
			this.attributes = anAttTab;
			this.isErrorState = isErrorState;
		}

		/// <summary>
		/// Default constructor of a default state which is NOT an error state
		/// </summary>
		/// <param name="anAttTab">A Hashtable containing the attributes attached to this state</param>
		/// <param name="anId">ID of the new state</param>
		public DefaultState(string anId, IAttributeHash anAttTab) : this (anId, anAttTab, false) {}
		
		/// <summary>
		/// Default constructor of a default state which is NOT an error state and has an 
		/// empty set of attributes attached to it.
		/// </summary>
		/// <param name="anId">ID of the new state</param>
		public DefaultState(string anId) : this (anId, new DefaultAttributeHash() , false) {}
		
		/// <summary>
		/// Default constructor of a default state that has an 
		/// empty set of attributes attached to it.
		/// </summary>
		/// <param name="anID">ID of the new state</param>
		/// <param name="isErrorState">Specifies if this state is constructed as ErrorState</param>
		public DefaultState(string anID, bool isErrorState) : this (anID, new DefaultAttributeHash(), isErrorState) {}
	}
}
