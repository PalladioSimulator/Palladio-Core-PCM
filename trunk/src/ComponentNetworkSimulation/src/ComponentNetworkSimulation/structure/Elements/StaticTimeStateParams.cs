using System;

namespace ComponentNetworkSimulation.Structure.Services
{
	/// <summary>
	/// This parameterstructure extends BasicStateParams with a field for a static time.
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
	internal class StaticTimeStateParams : DefaultStateParams
	{
		private long staticTime;

		/// <summary>
		/// constructs a new StaticTimeParams struture filled with given parameters.
		/// </summary>
		/// <param name="id">the id of the state</param>
		/// <param name="strategy">the strategy used to find the way through the fsm</param>
		/// <param name="type">the loggingtype of the state</param>
		/// <param name="staticTime">the static time to wait in this state</param>
		public StaticTimeStateParams(string id, IControlFlowStrategy strategy, LoggingType_t type, long staticTime) :
			base(id,strategy,type)
		{
			this.staticTime = staticTime;
		}

		/// <summary>
		/// returns the static time
		/// </summary>
		public long StaticTime
		{
			get {return this.staticTime;}
		}
	}
}
//EOF