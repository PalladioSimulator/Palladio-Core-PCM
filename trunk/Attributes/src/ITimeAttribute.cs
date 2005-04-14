using System;
using MathNet.Numerics;
using Palladio.Attributes;
using Palladio.Reliability.Math;

namespace Palladio.Reliability.Attributes
{
	/// <summary>
	/// Attribute representing the execution time of an object.
	/// </summary>
	public interface ITimeAttribute : IAttribute
	{
		/// <summary>
		/// Expected or average execution time.
		/// </summary>
		double ExpectedTime { get; }

		/// <summary>
		/// Maximal execution time.
		/// </summary>
		double MaxTime { get; }

		/// <summary>
		/// Total time spent in the object.
		/// </summary>
		double TotalTime { get; }

		/// <summary>
		/// Total number of visits to the instance.
		/// </summary>
		long NumberOfVisits { get;	}

		/// <summary>
		/// The time consumption as a probability density function.
		/// </summary>
		IFunction ProbabilityDensityFunction { get; }
	}
}
