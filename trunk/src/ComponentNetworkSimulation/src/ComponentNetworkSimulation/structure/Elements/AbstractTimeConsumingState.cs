using System;
using ComponentNetworkSimulation.Structure;
using Palladio.FiniteStateMachines;

namespace ComponentNetworkSimulation.Structure.Services
{
	/// <summary>
	/// Zusammenfassung für TimeConsumingState.
	/// </summary>
	public abstract class AbstractTimeConsumingState : State,ITimeConsumer
	{	
		#region data
		
		protected BasicTimeStateParams param;

		#endregion

		#region constructors

		internal AbstractTimeConsumingState (string aName, bool isStartState, bool isFinalState, BasicTimeStateParams param) 
			: base(aName, isStartState,isFinalState)
		{
			this.param = param;
		}

		#endregion

		#region properties

		public LoggingType_t LoggingType
		{
			get
			{
				return param.LoggingType;
			}
		}

		public abstract ITimeConsumer NextTimeConsumer
		{
			get;
		}
		
		public abstract bool HasNextTimeConsumer
		{
			get;
		}

		#endregion

		#region methods

		public abstract long ThreadEntered();

		public virtual void ThreadExited()
		{
		}

		#endregion
	}
}
