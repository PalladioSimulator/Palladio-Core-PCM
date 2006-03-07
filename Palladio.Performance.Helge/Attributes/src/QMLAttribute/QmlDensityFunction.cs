namespace Palladio.Performance.Attributes
{
	/// <summary>
	/// Containing the probabilities of the density function and the distance between the values. 
	/// This function is not equidistant.
	/// </summary>
	internal class QmlDensityFunction
	{
		private QmlDensityFunctionValue[] qmlDensityFunctionValues;

		/// <summary>
		/// Function values.
		/// </summary>
		public QmlDensityFunctionValue[] QmlDensityFunctionValues
		{
			get { return qmlDensityFunctionValues; }
		}

		/// <summary>
		/// Constructor. 
		/// </summary>
		/// <param name="length">Number of function values.</param>
		public QmlDensityFunction(int length)
		{
			qmlDensityFunctionValues = new QmlDensityFunctionValue[length];
		}

		/// <summary>
		/// Returns an array 
		/// </summary>
		/// <returns></returns>
		public long[] GetDistance()
		{
			long[] distance = new long[QmlDensityFunctionValues.Length];
			distance[0] = QmlDensityFunctionValues[0].Value;
			for(int i= 1;i<QmlDensityFunctionValues.Length;i++)
			{
				distance[i] = QmlDensityFunctionValues[i].Value - QmlDensityFunctionValues[i-1].Value;
			}
			return distance;
		}
	}

	/// <summary>
	/// Class representing a function value.
	/// </summary>
	internal class QmlDensityFunctionValue
	{
		private long functionValue;
		private double probability;

		/// <summary>
		/// x-value of the function value.
		/// </summary>
		public long Value
		{
			get { return functionValue; }
			set { this.functionValue = value; }
		}

		/// <summary>
		/// y-value of the function value.
		/// </summary>
		public double Probability
		{
			get { return probability; }
			set{ this.probability=value; }
		}

		/// <summary>
		/// Constructor.
		/// </summary>
		/// <param name="value">x-value of the function value.</param>
		/// <param name="probability">y-value of the function value.</param>
		public QmlDensityFunctionValue(long value, double probability)
		{
			this.functionValue=value;
			this.probability=probability;
		}
	}

}
