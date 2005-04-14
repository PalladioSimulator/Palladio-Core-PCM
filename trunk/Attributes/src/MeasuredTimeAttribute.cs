using System;
using System.Collections;
using MathNet.Numerics;
using Palladio.Attributes;
using Palladio.Reliability.Math;

namespace Palladio.Reliability.Attributes
{
	/// <summary>
	/// </summary>
	public class MeasuredTimeAttribute : ITimeAttribute
	{
		/// <summary>
		/// The number of ticks that pass between two timer interrupts. 
		/// This is the amount of ticks added to the counter after every
		/// interrupt, therfore each measured time is a	multiple of this 
		/// value.
		/// 
		/// One tick represents 100 nanoseconds. The value DateTime.Now.Ticks
		/// contians the number of ticks that have elapsed since 
		/// 12:00 A.M., January 1, 0001.
		/// 
		/// Therefore, we have that we can measure the method execution times
		/// with an accuracy of approximately 0.01 seconds. This is not perfect, but
		/// it should be OK for this experiment.
		/// 
		/// Note: I don't know, if this value differs for different machines.
		/// </summary>
		public const long TIMER_INTERVAL = 100144;

		/// <summary>
		/// The time interval used to determine the execution time directly
		/// yields the samplingrate in seconds:
		///  sampling rate = time interval * 100 * 10^{-9}
		/// The ticks are given in 100 nanoseconds and a nanosecond is 10^{-9}
		/// seconds.
		/// </summary>
		public const double SAMPLING_RATE =  TIMER_INTERVAL * 0.0000001; // 10^(-7)

		/// <summary>
		/// Factory used for the creation of discrete functions. It is used by all
		/// instances of this class.
		/// </summary>
		public static IDiscreteFunctionFactory functionFactory = CreateFunctionFactory();

		/// <summary>
		/// Contains the measured times for the attributed object.
		/// </summary>
		private ArrayList timeList;

		/// <summary>
		/// Flag for the lazy evaluation.
		/// </summary>
		private bool valuesDetermined = false;

		private double averageTime;
		private double totalTime;
		private double maxTime;
		private IFunction probabilityDensityFunction;

		/// <summary>
		/// Average Time spent in the attributed object.
		/// </summary>
		public double ExpectedTime
		{
			get
			{
				if (!valuesDetermined)
					DetermineValues();
				return averageTime;
			}
		}

		/// <summary>
		/// Number of visits to the object.
		/// </summary>
		public long NumberOfVisits
		{
			get { return timeList.Count; }
		}

		/// <summary>
		/// Total time spent in the object.
		/// </summary>
		public double TotalTime
		{
			get
			{
				if (!valuesDetermined)
					DetermineValues();
				return totalTime;
			}
		}

		/// <summary>
		/// returns the maximum execution time 
		/// measured for this object.
		/// </summary>
		public double MaxTime
		{
			get
			{
				if (!valuesDetermined)
					DetermineValues();
				return maxTime;
			}
		}

		/// <summary>
		/// Returns the probability density function of
		/// the measured values.
		/// </summary>
		public IFunction ProbabilityDensityFunction
		{
			get
			{
				if (!valuesDetermined)
					DetermineValues();
				return probabilityDensityFunction;
			}
		}

		public void AddTime(long executionTime)
		{
			timeList.Add(executionTime);
		}

		public MeasuredTimeAttribute()
		{
			timeList = new ArrayList();
		}

		public static IAttributeType AttributeType
		{
			get { return attributeType; }
		}

		public static MeasuredTimeAttribute GetAttribute(IAttributable obj)
		{
			MeasuredTimeAttribute attr = obj.Attributes[MeasuredTimeAttribute.AttributeType] as MeasuredTimeAttribute;
			if (attr == null)
			{
				attr = new MeasuredTimeAttribute();
				SetAttribute(obj, attr);
			}
			return attr;
		}

		public static void SetAttribute(IAttributable obj, MeasuredTimeAttribute attr)
		{
			obj.Attributes.Add(MeasuredTimeAttribute.AttributeType, attr);
		}

		public static void AddTime(IAttributable obj, long time)
		{
			MeasuredTimeAttribute attr = GetAttribute(obj);
			if (attr == null)
			{
				attr = new MeasuredTimeAttribute();
				SetAttribute(obj, attr);
			}
			attr.valuesDetermined = false;
			attr.timeList.Add(time);
		}

		private void DetermineValues()
		{
			totalTime = 0;
			maxTime = 0;
			
			for (int i=0; i < timeList.Count; i++)
			{
				long time = (long)timeList[i];
				maxTime = time > maxTime ? time : maxTime;
				totalTime += time;
			}

			averageTime = timeList.Count == 0 ? 0 : totalTime / timeList.Count;

			long size = (long)maxTime / TIMER_INTERVAL + 1;
			double[] values = new double[size];
			double incVal = 1 / ( (double)timeList.Count * functionFactory.SamplingRate);

			for (int i=0; i < timeList.Count; i++)
			{
				long time = (long)timeList[i];
				int pos = (int)(time / TIMER_INTERVAL);
				values[pos]+= incVal;
			}

			probabilityDensityFunction = functionFactory.DiscreteValueFunction(0,values);
		}

		private static IDiscreteFunctionFactory CreateFunctionFactory()
		{
			IDiscreteFunctionFactory factory = (IDiscreteFunctionFactory) MathTools.DiscreteFunctions.Clone();
			factory.SamplingRate = SAMPLING_RATE;
			factory.XMax = 10; // 10 sec
			return factory;
		}

		private static IAttributeType attributeType = AttributesFactory.Default.CreateAttributeType(new Guid("50AC0D03-F05D-4b67-8502-717D7D32B14D"), "MeasuredTimesAttribute", typeof (MeasuredTimeAttribute));


		public void Serialize(System.Xml.XmlTextWriter writer)
		{
			throw new NotImplementedException();
		}

		public void Deserialize(System.Xml.XmlNode element)
		{
			throw new NotImplementedException();
		}
	}
}
