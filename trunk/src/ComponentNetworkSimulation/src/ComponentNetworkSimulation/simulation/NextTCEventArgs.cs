using System;
using ComponentNetworkSimulation.structure;

namespace ComponentNetworkSimulation.simulation
{
	/// <summary>
	/// This class extends the class EventArgs. It is used in NextTCEventHandler.
	/// </summary>
	public class NextTCEventArgs : EventArgs
	{
		#region data

		/// <summary>
		/// The field holding the current timeconsumer
		/// </summary>
		private TimeConsumer currentTimeConsumer;

		/// <summary>
		/// the field holding the previous time consumer
		/// </summary>
		private TimeConsumer previousTimeConsumer;

		#endregion

		#region constructors

		/// <summary>
		/// constructs a new NextTCEventArgs data structure
		/// </summary>
		/// <param name="current">The current timeconsumer</param>
		/// <param name="previous">The previous timeconsumer</param>
		public NextTCEventArgs(TimeConsumer current, TimeConsumer previous)
		{
			this.currentTimeConsumer = current;
			this.previousTimeConsumer = previous;
		}

		#endregion

		#region properties

		/// <summary>
		/// return the current timeconsumer
		/// </summary>
		public TimeConsumer CurrentTimeConsumer
		{ 
			get { return this.currentTimeConsumer;}
		}		

		/// <summary>
		/// return the previous timeconsumer
		/// </summary>
		public TimeConsumer PreviousTimeConsumer
		{ 
			get { return this.previousTimeConsumer;}
		}
		
		#endregion
	}
}
//EOF