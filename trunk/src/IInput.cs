using System;

namespace Palladio.FiniteStateMachines 
{
	/// <summary>
	/// </summary>
	public interface IInput 
	{
		/// <summary>
		/// An label used e.g. for graphical output of this input symbol
		/// </summary>
		string ID { get; }
	}
}
