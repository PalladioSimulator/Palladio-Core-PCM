using System;
using System.Collections;
using ReflectionBasedVisitor;
using Palladio.Attributes;

namespace Palladio.FiniteStateMachines.DefaultFSM {

	/// <summary>
	///		Class representing the abstract type of a state.
	///		
	///		author: JH
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.5  2004/05/17 14:08:05  sliver
	/// added interface for attributable classes
	///
	/// Revision 1.4  2004/05/12 14:11:39  sbecker
	/// Added CVS log
	///
	///
	/// </pre>
	/// </remarks>
	internal abstract class AbstractState : IState 
	{
		protected bool isErrorState = false;
		protected string id;
		protected IAttributeHash attributes;

		/// <summary>
		/// If true, this state is an error state in which the FSM can drop if
		/// running along an invalid transition
		/// </summary>
		public bool IsErrorState
		{
			get
			{
				return isErrorState;
			}
			set
			{
				isErrorState = value;
			}
		}
		
		/// <summary>
		/// Return a string representation of this state, e.g. for graphical output.
		/// Here implemented as payload.ToString();
		/// </summary>
		public string ID
		{
			get
			{
				return id;
			}
		}

		/// <summary>
		/// Information describing this state. Any type of information object can be
		/// associated to a state.
		/// </summary>
		public virtual IAttributeHash Attributes
		{
			get
			{
				return attributes;
			}
		}

		/// <summary>
		///		Default implementation of GetHashCode(). 
		///		Refers to the hashcode of name.
		/// </summary>
		/// <returns>
		///		Hashcode of Name
		///	</returns>
		public override int GetHashCode() 
		{
			return id.GetHashCode();
		}
		
		/// <summary>
		///		Default implementation of Equals.
		/// </summary>
		/// <param name="obj">
		///		The other object.
		///	</param>
		/// <returns>
		///		True, if Name, IsStartState and
		///		IsFinalState are Equal; false otherwise.
		///	</returns>
		public override bool Equals(object obj) 
		{
			if (obj is IState) 
			{ 
				IState state = (IState)obj;
				return id.Equals(state.ID);
			}
			return false;
		}

		/// <summary>
		/// Overriden ToString for debug purposes
		/// </summary>
		/// <returns>The label of this state</returns>
		public override string ToString()
		{
			return ID;
		}

		/// <summary>
		/// Implementation of the data structure driven visitor movement. It is
		/// not implemented here!
		/// </summary>
		/// <param name="v">The visitor visiting this object</param>
		public virtual void AcceptVisitor(IVisitor v) {}

	}
}