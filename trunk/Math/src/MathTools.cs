using System;
using Palladio.Reliability.Math.Functions;
using Palladio.Reliability.Math.Fourier;

namespace Palladio.Reliability.Math
{
	/// <summary>
	/// </summary>
	public class MathTools
	{
		/// <summary>
		/// Provides a Factory for discrete functions. You can
		/// create your own factory by cloning this one.
		/// </summary>
		public static IDiscreteFunctionFactory DiscreteFunctions
		{
			get { return discreteFunctions; }
		}

		public static IFourierTransform SimpleFourierTransform
		{
			get { return simpleFourierTransform; }
		}

		public static IFourierTransform FastFourierTransform
		{
			get { throw new NotImplementedException(); }
		}


		private static DiscreteFactory discreteFunctions = new DiscreteFactory();
		private static IFourierTransform simpleFourierTransform = new SimpleFourierTransform();
		private static IFourierTransform fastFourierTransform = null;

		private MathTools()
		{
		}
	}
}