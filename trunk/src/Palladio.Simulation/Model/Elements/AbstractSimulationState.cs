using System;
using Palladio.Attributes;
using Palladio.FiniteStateMachines;

using Palladio.Simulation.Model.Attributes;

namespace Palladio.Simulation.Model.Elements
{
	/// <summary>
	/// This is the abstract class for all states of the FSM's services implemented by the framework.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// $Log$
	/// Revision 1.1  2004/07/20 11:46:43  joemal
	/// new cvs module for first release
	///
	/// 
	/// </pre>
	/// </remarks>
	public abstract class AbstractSimulationState : ISimulationState
	{
		#region data

		//the state, that is used as delegat
		private IState delegat;

		#endregion

		#region constructors

		/// <summary>
		/// constructs a new SimulationState.
		/// </summary>
		/// <param name="param">the parameterstructure of the state</param>
		public AbstractSimulationState(ISimulationStateParams param)
		{
			delegat = FSMFactory.CreateDefaultState(param.ID);
			this.Attributes.Add(DefaultAttributeTypeSet.ControlFlowStrategyType,param.ControlFlowStrategy);
			this.Attributes.Add(DefaultAttributeTypeSet.LoggingAttributeType,param.LoggingType);
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
				return (IControlFlowStrategy)this.Attributes[DefaultAttributeTypeSet.ControlFlowStrategyType];
			}
		}

		/// <summary>
		///		The unique ID of the state.
		/// </summary>
		public string ID
		{
			get
			{
				return this.delegat.ID;
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
				return this.delegat.Attributes;
			}
		}

		/// <summary>
		/// returns the logging type of the state.
		/// </summary>
		public LoggingType_t LoggingType
		{
			get
			{
				return (LoggingType_t)this.Attributes[DefaultAttributeTypeSet.LoggingAttributeType];
			}
		}

		#endregion

		#region methods

		/// <summary>
		/// delegated to default state
		/// </summary>
		/// <param name="visitor"></param>
		public virtual void AcceptVisitor(ReflectionBasedVisitor.IVisitor visitor)
		{
			delegat.AcceptVisitor(visitor);
		}

		/// <summary>
		/// override to return a debug string containing the id of this state
		/// </summary>
		/// <returns>a debug string containing the id of this state</returns>
		public override string ToString()
		{
			return delegat.ToString();
		}

		/// <summary>
		///	delegated to default state
		/// </summary>
		/// <returns></returns>
		public override int GetHashCode() 
		{
			return delegat.GetHashCode();
		}
		
		/// <summary>
		///		Default implementation of Equals.
		/// </summary>
		/// <param name="obj">
		///		The other object.
		///	</param>
		/// <returns>
		///		True, if Name, IsStartState and
		///		IsFinalState are Equal; false otherwise.
		///	</returns>
		public override bool Equals(object obj) 
		{
			if (!(obj is ISimulationState)) return false;
			ISimulationState state = (ISimulationState)obj;

			return (state.ControlFlowStrategy == this.ControlFlowStrategy &&
					state.LoggingType == this.LoggingType &&
					state.ID == this.ID
				);
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

		/// <summary>
		/// this method is called, when the simulation wants to reset the architecture. Dynamic timeconsumer should
		/// implement this method to reset its state.
		/// </summary>
		public abstract void Reset();

		#endregion
	}
}
//EOF
