namespace Palladio.Performance.Attributes
{
	/// <summary>
	/// Class representing a percentile aspect of the QML.
	/// </summary>
	public class PercentileAspect
	{
		private double percentile;
		private long timeValue;

		/// <summary>
		/// Percentile.
		/// </summary>
		public double Percentile
		{
			get { return percentile; }
			set { this.percentile = value; }
		}

		/// <summary>
		/// Value.
		/// </summary>
		public long TimeValue
		{
			get { return timeValue; }
			set { this.timeValue=value; }
		}

		/// <summary>
		/// Creates a string representation of thew object.
		/// </summary>
		/// <returns>String representation of the object.</returns>
		public override string ToString()
		{
			return "(" + percentile + ")(" + timeValue + ")";
		}

		/// <summary>
		/// Constructor. 
		/// </summary>
		/// <param name="percentile">Percentile.</param>
		/// <param name="timeValue">Time value.</param>
		public PercentileAspect(double percentile, long timeValue)
		{
			this.percentile=percentile;
			this.timeValue=timeValue;
		}
	}
}
