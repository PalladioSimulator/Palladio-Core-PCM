using System;

namespace ComponentNetworkSimulation.Structure.Services
{
	/// <summary>
	/// This interface defines a class as parameter structure describing simulationstates.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// $Log$
	/// Revision 1.1  2004/05/20 14:12:22  joemal
	/// initial creation
	///
	/// 
	/// </pre>
	/// </remarks>
	public interface ISimulationStateParams
	{
		/// <summary>
		/// returns the id of the state
		/// </summary>
		string ID
		{
			get;
		}

		/// <summary>
		/// returns the controlflowstrategy
		/// </summary>
		IControlFlowStrategy ControlFlowStrategy
		{
			get;
		}

		/// <summary>
		/// returns the loggingtype of the state
		/// </summary>
		LoggingType_t LoggingType
		{
			get;
		}
	}
}
//EOF
