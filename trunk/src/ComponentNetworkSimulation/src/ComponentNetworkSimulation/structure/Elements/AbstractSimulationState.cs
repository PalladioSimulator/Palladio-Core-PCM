using System;
using Palladio.Attributes;
using Palladio.FiniteStateMachines;

namespace ComponentNetworkSimulation.Structure.Services
{
	/// <summary>
	/// This is the abstract class for all states of the FSM's services implemented by the framework.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// $Log$
	/// Revision 1.1  2004/05/18 16:27:22  joemal
	/// initial creation
	///
	/// 
	/// </pre>
	/// </remarks>
	public abstract class AbstractSimulationState : ISimulationState
	{
		#region data

		//holds the strategy object used to find the path through the FSMs.
		private IControlFlowStrategy strategy;

		// the id of the state
		private string id;

		// the attribute hashtable
		private IAttributeHash attributes = new AttributesFactory().Default.CreateAttributeHash();

		private LoggingType_t loggingType;

		#endregion

		#region constructors

		/// <summary>
		/// constructs a new SimulationState.
		/// </summary>
		/// <param name="id">the id of the state</param>
		/// <param name="strategy">the strategy object used to find the path through the FSMs.</param>
		public AbstractSimulationState(string id, IControlFlowStrategy strategy, LoggingType_t loggingType)
		{
			this.strategy = strategy;
			this.id = id;
			this.loggingType = loggingType;
		}

		#endregion

		#region Properties 

		/// <summary>
		/// returns an instance of IControlFlowStrategy, used to find the path through the fsm.
		/// </summary>
		public IControlFlowStrategy ControlFlowStrategy
		{
			get
			{
				return this.strategy;
			}
		}

		/// <summary>
		///		The unique ID of the state.
		/// </summary>
		public string ID
		{
			get
			{
				return this.id;
			}
		}

		/// <summary>
		/// is always false, because all simulation states are not errorstates.
		/// </summary>
		public bool IsErrorState
		{
			get
			{
				return false;
			}
			set{}
		}

		/// <summary>
		/// A list of attributes attached to the state.
		/// </summary>
		public Palladio.Attributes.IAttributeHash Attributes
		{
			get
			{
				return this.attributes;
			}
		}

		public ITimeConsumer NextTimeConsumer
		{
			get
			{
				// TODO:  away later
				return null;
			}
		}

		public bool HasNextTimeConsumer
		{
			get
			{
				//TODO: away later ... 
				return false;
			}
		}


		/// <summary>
		/// returns the logging type of the state.
		/// </summary>
		public ComponentNetworkSimulation.Structure.LoggingType_t LoggingType
		{
			get
			{
				return this.loggingType;
			}
		}

		#endregion


		#region methods

		/// <summary>
		/// not used in this implementation
		/// </summary>
		/// <param name="visitor"></param>
		public void AcceptVisitor(ReflectionBasedVisitor.IVisitor visitor)
		{
		}

		public abstract long ThreadEntered();

		public abstract void ThreadExited();

		#endregion
	}
}
//EOF
