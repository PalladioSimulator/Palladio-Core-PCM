using System;

using ComponentNetworkSimulation.Structure;

namespace ComponentNetworkSimulation.Structure.Services
{
	/// <summary>
	/// Zusammenfassung für BasicTimeTransitionParams.
	/// </summary>
	public class BasicTimeTransitionParams
	{
		protected LoggingType_t loggingType;

		protected double probability;

		protected long staticTime;

		public BasicTimeTransitionParams(LoggingType_t loggingType, double probability, long staticTime)
		{
			this.loggingType = loggingType;
			this.probability = probability;
			this.staticTime = staticTime;
		}

		public LoggingType_t LoggingType
		{
			get {return this.loggingType;}
		}

		public double Probability
		{
			get{ return this.probability;}
		}

		public long StaticTime
		{
			get {return this.staticTime;}
		}
	}
}
