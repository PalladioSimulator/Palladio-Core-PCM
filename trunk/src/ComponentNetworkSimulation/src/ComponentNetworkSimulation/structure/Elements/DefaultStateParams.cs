using System;

namespace ComponentNetworkSimulation.Structure.Services
{
	/// <summary>
	/// This is the default parameterstructure for simulationstates, implemented by the framework. 
	/// States might extend this structure to add some parameters.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// $Log$
	/// Revision 1.2  2004/05/26 16:31:53  joemal
	/// change some docs
	///
	/// Revision 1.1  2004/05/20 14:12:22  joemal
	/// initial creation
	///
	/// 
	/// </pre>
	/// </remarks>
	internal class DefaultStateParams : ISimulationStateParams
	{
		#region data
		
		//holds the id
		private String id;

		//holds the strategy
		private IControlFlowStrategy strategy;

		//holds the loggingtype
		private LoggingType_t type;

		#endregion

		#region constructor

		/// <summary>
		/// constructs a new DefaultStateParams structure filled with given values.
		/// </summary>
		/// <param name="id">the id of the state</param>
		/// <param name="strategy">the controlflowstrategy used to find the way through the fsm.</param>
		/// <param name="type">the loggingtype of the state</param>
		public DefaultStateParams(string id, IControlFlowStrategy strategy, LoggingType_t type)
		{
			this.id = id;
			this.strategy = strategy;
			this.type = type;
		}

		#endregion 

		#region properties
		
		/// <summary>
		/// call to get the id
		/// </summary>
		public string ID
		{
			get{return this.id;}
		}

		/// <summary>
		/// call to get the controlflowstrategy
		/// </summary>
		public IControlFlowStrategy ControlFlowStrategy
		{
			get{return this.strategy;}
		}

		/// <summary>
		/// call to return the loggingtype of the state
		/// </summary>
		public LoggingType_t LoggingType
		{
			get{return this.type;}
		}

		#endregion
	}
}
//EOF