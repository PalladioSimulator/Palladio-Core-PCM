using System;
using Palladio.FiniteStateMachines;

namespace ComponentNetworkSimulation.Structure
{
	/// <summary>
	/// This class is the default implementation of the datastructure describing a starting point for simulationthreads.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// $Log$
	/// Revision 1.1  2004/05/26 16:36:29  joemal
	/// initial creation
	///
	/// 
	/// </pre>
	/// </remarks>
	public class DefaultThreadStartingPoint : IThreadStartingPoint
	{
		//TODO: add Component, Interface, and Signature
		#region data

		//the first service
		private IFiniteStateMachine fsm;

		#endregion

		#region constructors

		/// <summary>
		/// constructs a new DefaultThreadStartingPoint described by the given parameters.
		/// </summary>
		/// <param name="fsm"></param>
		public DefaultThreadStartingPoint(IFiniteStateMachine fsm)
		{
            this.fsm = fsm;			
		}

		#endregion

		#region Properties

		public IFiniteStateMachine FiniteStateMachine
		{
			get
			{
				return this.fsm;
			}
		}

		#endregion
	}
}
//EOF