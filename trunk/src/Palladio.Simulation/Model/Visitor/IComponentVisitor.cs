using System;
using Palladio.FiniteStateMachines;
using Palladio.ComponentModel;

namespace Palladio.Simulation.Model.Visitor
{
	/// <summary>
	/// This interface defines a visitor used to walk through all elements in the components of the componentarchitecture.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	/// 
	/// $Log$
	/// Revision 1.2  2004/07/28 15:34:46  sbecker
	/// Review comments added
	///
	/// Revision 1.1  2004/07/20 11:46:42  joemal
	/// new cvs module for first release
	///
	/// 
	/// </pre>
	/// </remarks>
	/// IEnumerable einbauen ...
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