using System;

namespace Palladio.FiniteStateMachines.DefaultFSM
{
	/// <summary>
	///	Represents the input of a FSM.
	///	
	///	author: JH
	/// </summary>
	internal class DefaultInput : IInput
	{
		protected string id;

		/// <summary>
		/// A label for this input. Here implemented as Payload.ToString().
		/// </summary>
		public string ID
		{
			get
			{
				return id;
			}
		}

		/// <summary>
		/// The default constuctor.
		/// </summary>
		/// <param name="anInputSymbol">Payload of this transition</param>
		public DefaultInput(string anID) 
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
			return id;
		}

	}
}
