using System;
using Palladio.Attributes;
using Palladio.FiniteStateMachines;

using ComponentNetworkSimulation.Structure.Attributes;

namespace ComponentNetworkSimulation.Structure.Services
{
	/// <summary>
	/// This is the abstract class for all states of the FSM's services implemented by the framework.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// $Log$
	/// Revision 1.4  2004/05/26 16:33:26  joemal
	/// remove methods:
	/// - NextTimeConsumer
	/// - HasNextTimeConsumer
	/// Use visitor now
	///
	/// Revision 1.3  2004/05/25 16:23:37  joemal
	/// parameters now are stored in attributehash
	///
	/// Revision 1.2  2004/05/20 14:14:01  joemal
	/// replace the single parameters of the state with a parameterstructure
	///
	/// Revision 1.1  2004/05/18 16:27:22  joemal
	/// initial creation
	///
	/// 
	/// </pre>
	/// </remarks>
	public abstract class AbstractSimulationState : ISimulationState
	{
		#region data

		// the attribute hashtable
		private IAttributeHash attributes = new AttributesFactory().Default.CreateAttributeHash();

		#endregion

		#region constructors

		/// <summary>
		/// constructs a new SimulationState.
		/// </summary>
		/// <param name="param">the parameterstructure of the state</param>
		public AbstractSimulationState(ISimulationStateParams param)
		{
			this.attributes.Add(DefaultAttributeTypeSet.IDType,param.ID);
			this.attributes.Add(DefaultAttributeTypeSet.ControlFlowStrategyType,param.ControlFlowStrategy);
			this.attributes.Add(DefaultAttributeTypeSet.LoggingAttributeType,param.LoggingType);
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
				return (IControlFlowStrategy)this.attributes[DefaultAttributeTypeSet.ControlFlowStrategyType];
			}
		}

		/// <summary>
		///		The unique ID of the state.
		/// </summary>
		public string ID
		{
			get
			{
				return (string)this.attributes[DefaultAttributeTypeSet.IDType];
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

		/// <summary>
		/// returns the logging type of the state.
		/// </summary>
		public LoggingType_t LoggingType
		{
			get
			{
				return (LoggingType_t)this.attributes[DefaultAttributeTypeSet.LoggingAttributeType];
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

		/// <summary>
		/// called, when a thread entered this state
		/// </summary>
		/// <returns>the time, the thread has to wait in this state</returns>
		public abstract long ThreadEntered();

		/// <summary>
		/// called, when a thread want to leave this state.
		/// </summary>
		public abstract void ThreadExited();

		#endregion
	}
}
//EOF
