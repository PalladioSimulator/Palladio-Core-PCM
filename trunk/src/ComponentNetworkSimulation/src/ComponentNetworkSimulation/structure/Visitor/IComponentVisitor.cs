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
	/// Revision 1.2  2004/06/19 13:42:07  joemal
	/// Add some methods to retrieve the status of the visitor
	///
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
		/// if the current element is a timeconsumer, it is returned. Otherwise, null is returned.
		/// </summary>
		ITimeConsumer CurrentTimeConsumer
		{
			get;
		}

		/// <summary>
		/// returns true, if the current element is a timeconsumer
		/// </summary>
		bool IsTimeConsumer
		{
			get;
		}

		/// <summary>
		/// returns true, if any element exits in controlflow of the visitor
		/// </summary>
		bool HasAnyElement
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