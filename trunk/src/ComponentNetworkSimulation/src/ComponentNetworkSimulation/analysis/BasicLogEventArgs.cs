using System;

namespace ComponentNetworkSimulation.analysis
{
	/// <summary>
	/// Zusammenfassung für BasicLogEventArgs.
	/// </summary>
	public class BasicLogEventArgs : EventArgs
	{
		#region data
		protected String message;
		#endregion

		#region constructors

		public BasicLogEventArgs(String message)
		{
			this.message = message;
		}

		#endregion

		#region properties

		public String Message
		{
			get { return this.message;}
		}

		#endregion
	}
}
//EOF