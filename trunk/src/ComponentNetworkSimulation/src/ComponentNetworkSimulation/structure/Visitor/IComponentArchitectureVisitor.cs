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
	/// Revision 1.2  2004/05/26 16:34:25  joemal
	/// visitor now gets its startparameter in a structure
	///
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
		/// <param name="startingPoint">the datastructure, which describes the starting point of this thread.</param>
		void SetStart(IThreadStartingPoint startingPoint);
		
		/// <summary>
		/// call to jump to the next TimeConsumer in controlflow of the visitor.
		/// </summary>
		ITimeConsumer NextTimeConsumer();
	}
}
//EOF