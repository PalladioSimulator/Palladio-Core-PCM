using System;

namespace ComponentNetworkSimulation.Structure
{
	/// <summary>
	/// This interface defines a datastructure which describes the point, where simulationthreads can be started.
	/// This point is defined by a component, an interface of this component and a signature in the interface.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// $Log$
	/// Revision 1.1  2004/05/26 16:35:25  joemal
	/// initial creation
	///
	/// 
	/// </pre>
	/// </remarks>
	public interface IThreadStartingPoint
	{
		//TODO: add Component, Interface, and Signature

		/// <summary>
		///
		/// </summary>
		Palladio.FiniteStateMachines.IFiniteStateMachine FiniteStateMachine
		{
			get;
		}
	}
}
//EOF
