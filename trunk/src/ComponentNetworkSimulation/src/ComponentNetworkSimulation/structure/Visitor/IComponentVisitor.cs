using System;
using Palladio.FiniteStateMachines;
using Palladio.ComponentModel;

namespace ComponentNetworkSimulation.Structure.Visitor
{
	/// <summary>
	/// This interface defines a visitor used to walk through all elements in the components of the componentarchitecture.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	/// 
	/// $Log$
	/// Revision 1.1  2004/06/18 17:20:13  joemal
	/// initial class creation
	///
	/// 
	/// </pre>
	/// </remarks>
	public interface IComponentVisitor 
	{
		/// <summary>
		/// used to call the super visitor when an external call is needed or this visitor reached the end of its controlflow.
		/// </summary>
		event VisitorEventHandler OnVisitorEvent;

		/// <summary>
		/// return the current element of the visitor
		/// </summary>
		object CurrentElement
		{
			get;
		}
				
		/// <summary>
		/// jumps to the next element in the controlflow of this visitor
		/// </summary>
		void NextElement();
	}
}
//EOF