using System;
using Palladio.FiniteStateMachines;

namespace ComponentNetworkSimulation.Structure.Visitor
{
	/// <summary>
	/// This interface defines the visitor used by the simulationthreads to navigate through the timeconsumers of 
	/// the componentarchitecture.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	/// 
	/// $Log$
	/// Revision 1.1  2004/05/18 15:40:40  joemal
	/// initial creation
	///
	///
	/// 
	/// </pre>
	/// </remarks>
	public interface IComponentArchitectureVisitor : ReflectionBasedVisitor.IVisitor 
	{
		/// <summary>
		/// return the current timeconsumer in the controlflow of the visitor.
		/// </summary>
		ITimeConsumer CurrentTimeConsumer
		{
			get;
		}

		
		/// <summary>
		/// called to set the entry point of the controlflow.
		/// </summary>
		/// <param name="fsm">the fsm</param>
		//todo: later Component and Signature of the service as param
		void SetStart(IFiniteStateMachine fsm);
		
		/// <summary>
		/// call to jump to the next TimeConsumer in controlflow of the visitor.
		/// </summary>
		ITimeConsumer NextTimeConsumer();
	}
}
//EOF