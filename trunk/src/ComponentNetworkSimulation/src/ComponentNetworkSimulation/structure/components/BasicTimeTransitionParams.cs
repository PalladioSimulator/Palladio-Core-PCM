using System;

using ComponentNetworkSimulation.Structure;

namespace ComponentNetworkSimulation.Structure.Components
{
	/// <summary>
	/// Zusammenfassung für BasicTimeTransitionParams.
	/// </summary>
	public class BasicTimeTransitionParams
	{
		protected LoggingType_t loggingType;

		public BasicTimeTransitionParams(LoggingType_t loggingType)
		{
			this.loggingType = loggingType;
		}

		public LoggingType_t LoggingType
		{
			get {return this.loggingType;}
		}
	}
}
