using System;
using Palladio.Simulation.Model;

namespace Palladio.Simulation.Simulation
{
	/// <summary>
	/// This class extends the class EventArgs. It is used in NextTCEventHandler.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// $Log$
	/// Revision 1.3  2004/07/29 15:13:48  joemal
	/// - changes from the review
	///
	/// Revision 1.2  2004/07/22 20:28:18  joemal
	/// - changed some comments
	///
	/// Revision 1.1  2004/07/20 11:46:42  joemal
	/// new cvs module for first release
	///
	/// 
	/// </pre>
	/// </remarks>
	public class NextTCEventArgs : EventArgs
	{
		#region data

		/// <summary>
		/// holds the current TimeConsumer
		/// </summary>
		private ITimeConsumer currentTimeConsumer;

		/// <summary>
		/// holds the previous TimeConsumer
		/// </summary>
		private ITimeConsumer previousTimeConsumer;

		#endregion

		#region constructors

		/// <summary>
		/// constructs a new <c>NextTCEventArgs</c> data structure
		/// </summary>
		/// <param name="current">the current TimeConsumer</param>
		/// <param name="previous">the previous TimeConsumer</param>
		public NextTCEventArgs(ITimeConsumer current, ITimeConsumer previous)
		{
			this.currentTimeConsumer = current;
			this.previousTimeConsumer = previous;
		}

		#endregion

		#region properties

		/// <summary>
		/// returns the current TimeConsumer
		/// </summary>
		public ITimeConsumer CurrentTimeConsumer
		{ 
			get { return this.currentTimeConsumer;}
		}		

		/// <summary>
		/// returns the previous TimeConsumer
		/// </summary>
		public ITimeConsumer PreviousTimeConsumer
		{ 
			get { return this.previousTimeConsumer;}
		}
		
		#endregion
	}
}
//EOF