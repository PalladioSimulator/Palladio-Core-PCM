using System;
using Palladio.Identifier;

namespace Palladio.Simulation.Model.Elements
{
	/// <summary>
	/// This class is the parameter structure for simulationbindings with static time constants.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// $Log$
	/// Revision 1.1  2004/07/20 11:46:42  joemal
	/// new cvs module for first release
	///
	/// 
	/// </pre>
	/// </remarks>
	public class StaticTimeBindingParams : ISimulationBindingParams
	{
		#region data

		/// <summary>
		/// holds the loggingtype of the binding
		/// </summary>
		private LoggingType_t loggingType;

		/// <summary>
		/// holds the static time
		/// </summary>
		private long staticTime;

		#endregion

		#region constructor

		/// <summary>
		/// call to construct a new StaticTimeBindingParams structure using the given parameters.
		/// </summary>
		/// <param name="loggingType">the loggingtype of the binding</param>
		/// <param name="staticTime">the static time of this binding</param>
		public StaticTimeBindingParams(LoggingType_t loggingType,long staticTime)
		{
			this.loggingType = loggingType;
			this.staticTime = staticTime;
		}

		#endregion

		#region properties

		/// <summary>
		/// returns the loggingtype of the binding
		/// </summary>
		public LoggingType_t LoggingType
		{
			get
			{
				return this.loggingType;
			}
		}

		/// <summary>
		/// the static time
		/// </summary>
		public long StaticTime
		{
			get
			{
				return this.staticTime;
			}
		}

		#endregion
	}
}
//EOF
