using System;

namespace Palladio.FiniteStateMachines.DefaultFSM
{
	/// <summary>
	///	Represents the input of a FSM.
	///	
	///	author: JH
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/02/21 13:19:37  joemal
	/// initial import
	///
	///
	/// </pre>
	/// </remarks>
	internal class DefaultInput : IInput
	{
		protected IMatchable id;

		/// <summary>
		/// A label for this input. Here implemented as Payload.ToString().
		/// </summary>
		public IMatchable ID
		{
			get
			{
				return id;
			}
		}

		/// <summary>
		/// The default constuctor.
		/// </summary>
		/// <param name="anID">ID of the input symbol</param>
		public DefaultInput(IMatchable anID) 
		{
			this.id = anID;
		}

		/// <summary>
		/// Compares this input to another object.
		/// </summary>
		/// <returns>true if both inputs are equal, false otherwise</returns>
		public override bool Equals(object obj) 
		{
			if (obj is IInput)
			{
				IInput otherInput = (IInput)obj;
				return otherInput.ID.Equals(this.ID);
			}
			return false;
		}
		
		/// <summary>
		/// Delivers the Hashcode of the input
		/// </summary>
		/// <returns>The Hashcode in a <code>int</code>representation.</returns>
		public override int GetHashCode() 
		{
			return id.GetHashCode();
		}

		/// <summary>
		/// Overriden ToString for debug purposes
		/// </summary>
		/// <returns>The label of this input symbol</returns>
		public override string ToString()
		{
			return id.ToString();
		}

	}
}
