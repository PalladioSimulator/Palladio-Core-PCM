/*
 * $Id$
 * 
 * $Log$
 * Revision 1.5  2004/11/18 06:53:17  sliver
 * *** empty log message ***
 *
 * Revision 1.4  2004/11/08 03:50:06  sliver
 * *** empty log message ***
 *
 * Revision 1.3  2004/11/04 08:52:13  sliver
 * added regular expressions
 *
 * Revision 1.1  2004/10/25 07:07:22  sliver
 * implementation of
 * - functions discrete, including convolution
 * - path segmentation of FSMs
 * - prediction of time consuption using density functions
 *
 * Revision 1.1  2004/09/23 00:44:14  sliver
 * - major refactorings
 * - changed TypedCollections to CodeSmith generated files
 * - introduced MakrovModel
 * - added Transition-, Potential-, VisitProbability-, and VisitsOnPath- matrix types
 *
 */

using System;
using MathNet.Numerics;
using Palladio.Attributes;
using Palladio.Math;
using Double = System.Double;

namespace Palladio.Reliability.Attributes
{
	/// <summary>
	/// Attribute containig the Markov Probability of a transition.	
	/// </summary>
	public class TimeAttribute
	{
		#region Properties

		/// <summary>
		/// Density function of the random variable describing the
		/// execution time.
		/// </summary>
		public IFunction DensityFunction
		{
			get { return function; }
			set
			{
				if (!(value is IDiscreteFunction))
					throw new ApplicationException("Discrete functions are supported only!");
				function = value as IDiscreteFunction;

				// lazy.
				expectationValue = Double.NaN;
				fourierTransformed = null;
			}
		}


		/// <summary>
		/// Expectation value of the random variable describing the
		/// execution time.
		/// </summary>
		public double ExpectationValue
		{
			get
			{
				if (expectationValue == Double.NaN)
					expectationValue = ComputeExpectationValue(function);
				return expectationValue;
			}
		}

		private double ComputeExpectationValue(IDiscreteFunction function)
		{
			double val = 0;
			double x = function.XMin;
			for (int i = 0; i < function.Data.Length; i++)
			{
				val += function.Data[i]*x*function.SamplingRate;
				x += function.SamplingRate;
			}
			return val;
		}

		/// <summary>
		/// Fourier transformed values of the <c>DensityFunction</c>.
		/// </summary>
		public Complex[] FourierTransformed
		{
			get
			{
				if (fourierTransformed == null)
					fourierTransformed = fourier.ForwardFromReal(function.Data);
				return fourierTransformed;
			}
		}

		/// <summary>
		/// Type of the TimeAttribute.
		/// </summary>
		public static IAttributeType AttributeType
		{
			get { return attributeType; }
		}

		#endregion

		#region Methods

		/// <summary>
		/// Returns the TimeAttribute of the object. If it
		/// has no TimeAttribute null is returned.
		/// </summary>
		/// <param name="obj"></param>
		/// <returns></returns>
		public static TimeAttribute GetAttribute(IAttributable obj)
		{
			return obj.Attributes[AttributeType] as TimeAttribute;
		}

		public static void SetAttribute(IAttributable obj, IFunction df)
		{
			TimeAttribute attr = GetAttribute(obj);
			if (attr == null)
				attr = new TimeAttribute();

			attr.DensityFunction = df;
			obj.Attributes.Add(AttributeType, attr);
		}

		#endregion

		#region Constructors

		/// <summary>
		/// Create a new TimeAttribute and assigns aValue to it. 
		/// </summary>
		public TimeAttribute()
		{
			fourier = MathTools.SimpleFourierTransform;
		}

		#endregion

		#region Data

		private IDiscreteFunction function;
		private double expectationValue;
		private Complex[] fourierTransformed;
		private IFourierTransform fourier;
		private static IAttributeType attributeType = AttributesFactory.Default.CreateAttributeType(new Guid("E3D56D31-11E6-481e-8B1C-1BB350B1014B"), "TimeAttribute", typeof (TimeAttribute));

		#endregion
	}
}