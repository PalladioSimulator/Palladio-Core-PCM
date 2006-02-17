using System;
using System.Diagnostics;
using MathNet.Numerics;
using Palladio.Attributes;

namespace Palladio.Reliability.Attributes
{
	/// <summary>
	/// Zusammenfassung für FourierTimeAttribute.
	/// </summary>
	public class FourierTimeAttribute : IAttribute
	{
		public const long DATA_SIZE = 1000;
		private Complex[] data;

		public Complex[] Data
		{
			get { return data; }
		}

		/// <summary>
		/// Multiplication of each pair of elements (for sequence).
		/// </summary>
		/// <param name="fourier"></param>
		/// <returns></returns>
		public FourierTimeAttribute Multiply(FourierTimeAttribute fourier)
		{
			Complex[] result = new Complex[DATA_SIZE];
			for (int i = 0; i < result.Length; i++)
			{
				result[i] = data[i]*fourier.data[i];
				if (result[i].IsNaN) Debugger.Break();
			}
			return new FourierTimeAttribute(result);
		}

		/// <summary>
		/// Addition of each pair of elements (for alternative).
		/// </summary>
		/// <param name="fourier"></param>
		/// <returns></returns>
		public FourierTimeAttribute Add(FourierTimeAttribute fourier)
		{
			Complex[] result = new Complex[DATA_SIZE];
			for (int i = 0; i < result.Length; i++)
			{
				result[i] = data[i] + fourier.data[i];
				if (result[i].IsNaN) Debugger.Break();
			}
			return new FourierTimeAttribute(result);
		}

		/// <summary>
		/// Scales each element of the function by <c>factor</c>.
		/// </summary>
		/// <param name="factor"></param>
		public void Scale(double factor)
		{
			for (int i = 0; i < data.Length; i++)
			{
				data[i] *= factor;
				if (data[i].IsNaN) Debugger.Break();
			}
		}


		/// <summary>
		/// Computes the execution time of a loop.
		/// </summary>
		/// <param name="p">Probability of re-iterating through the loop.</param>
		/// <returns></returns>
		public FourierTimeAttribute ComputeLoopLimit(double p)
		{
			double alpha = MeasuredTimeAttribute.SAMPLING_RATE;
			double alphaInv = 1/alpha;
			Complex[] result = new Complex[DATA_SIZE];
			for (int i = 0; i < result.Length; i++)
			{
				result[i] = alphaInv + ((p*data[i])/(1 - p*alpha*data[i]));
				if (result[i].IsNaN) Debugger.Break();
			}
			return new FourierTimeAttribute(result);
		}


		public FourierTimeAttribute(Complex[] data)
		{
			this.data = data;
		}

		#region Attribute Handling

		/// <summary>
		/// Type of the FourierTimeAttribute.
		/// </summary>
		public static IAttributeType AttributeType
		{
			get { return attributeType; }
		}

		/// <summary>
		/// Returns the FourierTimeAttribute of the state. If it
		/// has no FourierTimeAttribute null is returned.
		/// </summary>
		/// <param name="obj"></param>
		/// <returns></returns>
		public static FourierTimeAttribute GetAttribute(IAttributable obj)
		{
			return obj.Attributes[FourierTimeAttribute.AttributeType] as FourierTimeAttribute;
		}

		/// <summary>
		/// </summary>
		public static void SetAttribute(IAttributable obj, FourierTimeAttribute fourier)
		{
			obj.Attributes.Add(FourierTimeAttribute.AttributeType, fourier);
		}

		private static IAttributeType attributeType = AttributesFactory.Default.CreateAttributeType(new Guid("BE3E2386-A1C9-4925-9992-283204A3B169"), "FourierTimeAttribute", typeof (FourierTimeAttribute));

		#endregion

		#region IAttribute Member

		public void Serialize(System.Xml.XmlTextWriter writer)
		{
			// TODO:  Implementierung von FourierTimeAttribute.Serialize hinzufügen
		}

		public void Deserialize(System.Xml.XmlNode element)
		{
			// TODO:  Implementierung von FourierTimeAttribute.Deserialize hinzufügen
		}

		#endregion
	}
}