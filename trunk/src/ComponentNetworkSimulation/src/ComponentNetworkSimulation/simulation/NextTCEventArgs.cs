using System;
using ComponentNetworkSimulation.structure;

namespace ComponentNetworkSimulation.Simulation
{
	/// <summary>
	/// This class extends the class EventArgs. It is used in NextTCEventHandler.
	/// </summary>
	public class NextTCEventArgs : EventArgs
	{
		#region data

		/// <summary>
		/// The field holding the current TimeConsumer
		/// </summary>
		private ITimeConsumer currentTimeConsumer;

		/// <summary>
		/// the field holding the previous time consumer
		/// </summary>
		private ITimeConsumer previousTimeConsumer;

		#endregion

		#region constructors

		/// <summary>
		/// constructs a new NextTCEventArgs data structure
		/// </summary>
		/// <param name="current">The current TimeConsumer</param>
		/// <param name="previous">The previous TimeConsumer</param>
		public NextTCEventArgs(ITimeConsumer current, ITimeConsumer previous)
		{
			this.currentTimeConsumer = current;
			this.previousTimeConsumer = previous;
		}

		#endregion

		#region properties

		/// <summary>
		/// return the current TimeConsumer
		/// </summary>
		public ITimeConsumer CurrentTimeConsumer
		{ 
			get { return this.currentTimeConsumer;}
		}		

		/// <summary>
		/// return the previous TimeConsumer
		/// </summary>
		public ITimeConsumer PreviousTimeConsumer
		{ 
			get { return this.previousTimeConsumer;}
		}
		
		#endregion
	}
}
//EOF