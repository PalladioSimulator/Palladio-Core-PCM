#if TEST
using System;
using NUnit.Framework;

namespace Palladio.Performance.Math.Test
{
	/// <summary>
	/// Zusammenfassung für DiscreteFunctionTest.
	/// </summary>
	[TestFixture]
	public class DiscreteFunctionTest
	{
		public DiscreteFunctionTest()
		{
			//
			// TODO: Fügen Sie hier die Konstruktorlogik hinzu
			//
		}

		[Test]
		public void MaximumDataValue()
		{
			long xmin = 6;
			long samplingrate = 2;
			double[] data = {0.2,0.15,0.3,0.35,0};
			IDiscreteFunction function = MathTools.DiscreteFunctions.DiscreteValueFunction(xmin,samplingrate,data);
			Assert.AreEqual(0.35,function.MaximunDataValue());
		}

		[Test]
		public void Clone()
		{
			long xmin = 6;
			long samplingrate = 2;
			double[] data = {0.2,0.15,0.3,0.35};
			IDiscreteFunction function = MathTools.DiscreteFunctions.DiscreteValueFunction(xmin,samplingrate,data);
			IDiscreteFunction clonedFunction = (IDiscreteFunction) function.Clone();
			Assert.AreEqual(function,clonedFunction);
						
		}

		[Test]
		public void ValueOf()
		{
			long xmin = 6;
			long samplingrate = 2;
			double[] data = {0.2,0.15,0.3,0.35};
			IDiscretePDFunction function = MathTools.DiscreteFunctions.DiscreteValuePDFunction(xmin,samplingrate,data);
			Assert.AreEqual(0.2,function.ValueOf(xmin+samplingrate*0));
			Assert.AreEqual(0.3,function.ValueOf(xmin+samplingrate*2));
			Assert.AreEqual(0.35,function.ValueOf(xmin+samplingrate*3));
			Assert.AreEqual(0,function.ValueOf(xmin+samplingrate*4));
			Assert.AreEqual(0,function.ValueOf(xmin+samplingrate*5));
		}

		[Test]
		[ExpectedException(typeof(ApplicationException))]
		public void ValueOfException()
		{
			long xmin = 6;
			long samplingrate = 2;
			double[] data = {0.2,0.15,0.3,0.35};
			IDiscretePDFunction function = MathTools.DiscreteFunctions.DiscreteValuePDFunction(xmin,samplingrate,data);
			function.ValueOf(5);
		}

		[Test]
		public void Multiply()
		{
			long xmin = 2;
			long samplingrate = 1;
			double[] data = {0.2,0.15,0.3,0.35};
			double[] data2 = {0.1,0.2,0.3};
			IDiscretePDFunction function = MathTools.DiscreteFunctions.DiscreteValuePDFunction(xmin,samplingrate,data);
			IDiscretePDFunction function2 = MathTools.DiscreteFunctions.DiscreteValuePDFunction(xmin+2,samplingrate,data2);
			IDiscreteFunction df = function.Multiply(function2);
			df.Crop();
			Assert.AreEqual(new double[]{0.03,0.07},df.Data );
		}

		[Test]
		[ExpectedException(typeof(ApplicationException))]
		public void MultiplyException()
		{
			long xmin = 2;
			long samplingrate = 1;
			double[] data = {0.2,0.15,0.3,0.35};
			double[] data2 = {0.1,0.2,0.3};
			IDiscretePDFunction function = MathTools.DiscreteFunctions.DiscreteValuePDFunction(xmin,samplingrate,data);
			samplingrate=10;
			IDiscretePDFunction function2 = MathTools.DiscreteFunctions.DiscreteValuePDFunction(xmin+2,samplingrate,data2);
			IDiscreteFunction df = function.Multiply(function2);
			df.Crop();
			Assert.AreEqual(new double[]{0.03,0.07},df.Data );
		}

		[Test]
		public void AddScaled()
		{
			long xmin = 2;
			long samplingrate = 1;
			double[] data = {0.2,0.15,0.3,0.35};
			double[] data2 = {0.1,0.2,0.3};
			IDiscretePDFunction function = MathTools.DiscreteFunctions.DiscreteValuePDFunction(xmin,samplingrate,data);
			IDiscretePDFunction function2 = MathTools.DiscreteFunctions.DiscreteValuePDFunction(xmin+2,samplingrate,data2);
			IDiscreteFunction df = function.AddScaled(2.5,function2);
			Assert.AreEqual(new double[]{0.2,0.15,0.55,0.85,0.75},df.Data );
			Assert.AreEqual(df.XMin,System.Math.Min(function.XMin,function2.XMin));
			Assert.AreEqual(df.XMax,System.Math.Max(function.XMax,function2.XMax));
		}

		[Test]
		[ExpectedException(typeof(ApplicationException))]
		public void AddScaledException()
		{
			long xmin = 2;
			long samplingrate = 1;
			double[] data = {0.2,0.15,0.3,0.35};
			double[] data2 = {0.1,0.2,0.3};
			IDiscretePDFunction function = MathTools.DiscreteFunctions.DiscreteValuePDFunction(xmin,samplingrate,data);
			samplingrate =3;
			IDiscretePDFunction function2 = MathTools.DiscreteFunctions.DiscreteValuePDFunction(xmin+2,samplingrate,data2);
			IDiscreteFunction df = function.AddScaled(2.5,function2);
			Assert.AreEqual(new double[]{0.2,0.15,0.55,0.85,0.75},df.Data );
			Assert.AreEqual(df.XMin,System.Math.Min(function.XMin,function2.XMin));
			Assert.AreEqual(df.XMax,System.Math.Max(function.XMax,function2.XMax));
		}

		[Test]
		public void Add()
		{
			long xmin = 2;
			long samplingrate = 1;
			double[] data = {0.2,0.15,0.3,0.35};
			double[] data2 = {0.1,0.2,0.3};
			IDiscretePDFunction function = MathTools.DiscreteFunctions.DiscreteValuePDFunction(xmin,samplingrate,data);
			IDiscretePDFunction function2 = MathTools.DiscreteFunctions.DiscreteValuePDFunction(xmin+2,samplingrate,data2);
			IDiscreteFunction df = function.Add(function2);
			Assert.AreEqual(new double[]{0.2,0.15,0.4,0.55,0.3},df.Data );
			Assert.AreEqual(df.XMin,System.Math.Min(function.XMin,function2.XMin));
			Assert.AreEqual(df.XMax,System.Math.Max(function.XMax,function2.XMax));
		}

		[Test]
		[ExpectedException(typeof(ApplicationException))]
		public void AddException()
		{
			long xmin = 2;
			long samplingrate = 1;
			double[] data = {0.2,0.15,0.3,0.35};
			double[] data2 = {0.1,0.2,0.3};
			IDiscretePDFunction function = MathTools.DiscreteFunctions.DiscreteValuePDFunction(xmin,samplingrate,data);
			samplingrate=2;
			IDiscretePDFunction function2 = MathTools.DiscreteFunctions.DiscreteValuePDFunction(xmin+2,samplingrate,data2);
			function.Add(function2);
		}

		[Test]
		public void Scale()
		{
			long xmin = 28;
			long samplingrate = 1;
			double[] data = {0.1,0.2,0.3,0.25,0.15};
			IDiscretePDFunction function = MathTools.DiscreteFunctions.DiscreteValuePDFunction(xmin,samplingrate,data);
			function.Scale(0.2);
			Assert.AreEqual(new double[]{0.02,0.04,0.06,0.05,0.03},function.Data);
		}

		[Test]
		public void GetScaled()
		{
			long xmin = 28;
			long samplingrate = 1;
			double[] data = {0.1,0.2,0.3,0.25,0.15};
			IDiscretePDFunction function = MathTools.DiscreteFunctions.DiscreteValuePDFunction(xmin,samplingrate,data);
			IDiscreteFunction function2 = function.GetScaled(0.2);
			Assert.AreEqual(new double[]{0.02,0.04,0.06,0.05,0.03},function2.Data);
			Assert.AreEqual(data,function.Data);
		}

		[Test]
		public void Convolution()
		{
			long xmin = 2;
			long samplingrate = 1;
			double[] data = {0.2,0.15,0.3,0.35};
			IDiscretePDFunction function = MathTools.DiscreteFunctions.DiscreteValuePDFunction(xmin,samplingrate,data);
			Assert.AreEqual(2,function.XMin);
			Assert.AreEqual(5,function.XMax);
			IDiscreteFunction df = function.Convolution(function);
			Assert.AreEqual(new double[]{0.04,0.06,0.1425,0.23,0.195,0.21,0.1225},df.Data);
			Assert.AreEqual(4,df.XMin);
		}

		[Test]
		[ExpectedException(typeof(ApplicationException))]
		public void ConvolutionException()
		{
			long xmin = 2;
			long samplingrate = 1;
			double[] data = {0.2,0.15,0.3,0.35};
			IDiscretePDFunction function = MathTools.DiscreteFunctions.DiscreteValuePDFunction(xmin,samplingrate,data);
			samplingrate=2;
			IDiscretePDFunction function2 = MathTools.DiscreteFunctions.DiscreteValuePDFunction(xmin,samplingrate,data);
			function.Convolution(function2);
		}

		[Test]
		public void DismissValuesSmallerThanN()
		{
			double[] data = new double[] {0.00000001,0,0,0.5,0.1,0.175,0,0,0.05,0.075,0.2,0,0.2,0,0.0000001,0,0.000000001};
			IDiscretePDFunction function = MathTools.DiscreteFunctions.DiscreteValuePDFunction(25,25, data);
			long max = function.XMax;
			function.DismissValuesSmalerThanN(0.0000001);
			Assert.AreEqual(new double[] {0,0,0,0.5,0.1,0.175,0,0,0.05,0.075,0.2,0,0.2,0,0.0000001,0,0},function.Data);
			function.Crop();
			Assert.AreEqual(new double[] {0.5,0.1,0.175,0,0,0.05,0.075,0.2,0,0.2,0,0.0000001},function.Data);
			Assert.AreEqual(100,function.XMin);
			Assert.AreEqual(max-50,function.XMax); // two vales eleminated at the end with samplingrate 25
		}

		[Test]
		public void ExpandDomain()
		{
			double[] data = new double[] {0,0.2,0.1,0.175,0,0,0.05,0.075,0.2,0,0.2,0};
			IDiscretePDFunction function = MathTools.DiscreteFunctions.DiscreteValuePDFunction(10,10, data);
			Assert.AreEqual(10,function.XMin);
			function.Crop();
			Assert.AreEqual(20,function.XMin);
			Assert.AreEqual(110,function.XMax);
			function.ExpandDomain(130);
			Assert.AreEqual(130,function.XMax);
			Assert.AreEqual(20,function.XMin);
			Assert.AreEqual(new double[]{0.2,0.1,0.175,0,0,0.05,0.075,0.2,0,0.2,0,0},function.Data );
			function.Crop();
			function.ExpandDomain(0,130);
			Assert.AreEqual(new double[]{0,0,0.2,0.1,0.175,0,0,0.05,0.075,0.2,0,0.2,0,0},function.Data );
			Assert.AreEqual(0,function.XMin);
			function.Crop();
			function.ExpandDomainPo2(0,130);
			Assert.AreEqual(150,function.XMax);
			Assert.AreEqual(0,function.XMin);
			Assert.AreEqual(new double[]{0,0,0.2,0.1,0.175,0,0,0.05,0.075,0.2,0,0.2,0,0,0,0},function.Data);
		}

		[Test]
		public void NumberOfNullValues()
		{
			double[] data = new double[] {0,0.2,0.1,0.175,0,0,0.05,0.075,0.2,0,0.2,0};
			IDiscretePDFunction function = MathTools.DiscreteFunctions.DiscreteValuePDFunction(10,10, data);
			Assert.AreEqual(function.Count,data.Length);
			Assert.AreEqual(5,function.NumberOfNullValues());
			function.Crop();
			Assert.AreEqual(3,function.NumberOfNullValues());
		}

		[Test]
		public void AdjustSamplingRate()
		{
			long xmin = 28;
			long samplingrate = 1;
			double[] data = {0.1,0.2,0.3,0.25,0.15};
			IDiscretePDFunction function = MathTools.DiscreteFunctions.DiscreteValuePDFunction(xmin,samplingrate,data);

			Assert.AreEqual(1,function.TotalProb);
			function.AdjustSamplingRate(10);
			Assert.AreEqual(30,function.XMin);
			Assert.AreEqual(40,function.XMax);
			Assert.AreEqual(10,function.SamplingRate);
			Assert.AreEqual(new double[]{0.6,0.4},function.Data );

			function.AdjustSamplingRate(5);
			Assert.AreEqual(5,function.SamplingRate);
			Assert.AreEqual(25,function.XMin);
			Assert.AreEqual(40,function.XMax);
			Assert.AreEqual(new double[]{0.3,0.3,0.2,0.2},function.Data );

			function.AdjustSamplingRate(1);
			Assert.AreEqual(1,function.SamplingRate);
			Assert.AreEqual(21,function.XMin);
			Assert.AreEqual(40,function.XMax);
			Assert.AreEqual(new double[]{0.06,0.06,0.06,0.06,0.06,0.06,0.06,0.06,0.06,0.06,
											0.04,0.04,0.04,0.04,0.04,0.04,0.04,0.04,0.04,0.04},function.Data );
		}

		[Test]
		public void AdjustSamplingRate2()
		{
			long xmin = 28;
			long samplingrate = 1;
			double[] data = {0.1,0.2,0.3,0.25,0.15};
			IDiscretePDFunction function = MathTools.DiscreteFunctions.DiscreteValuePDFunction(xmin,samplingrate,data);

			Assert.AreEqual(1,function.TotalProb);
			function.AdjustSamplingRate(10);
			Assert.AreEqual(30,function.XMin);
			Assert.AreEqual(40,function.XMax);
			Assert.AreEqual(10,function.SamplingRate);
			Assert.AreEqual(new double[]{0.6,0.4},function.Data );

			function.AdjustSamplingRate(5);
			Assert.AreEqual(5,function.SamplingRate);
			Assert.AreEqual(25,function.XMin);
			Assert.AreEqual(40,function.XMax);
			Assert.AreEqual(new double[]{0.3,0.3,0.2,0.2},function.Data );

			function.AdjustSamplingRate(1);
			Assert.AreEqual(1,function.SamplingRate);
			Assert.AreEqual(21,function.XMin);
			Assert.AreEqual(40,function.XMax);
			Assert.AreEqual(new double[]{0.06,0.06,0.06,0.06,0.06,0.06,0.06,0.06,0.06,0.06,
											0.04,0.04,0.04,0.04,0.04,0.04,0.04,0.04,0.04,0.04},function.Data );
		}
		[Test]
		public void AdjustSamplingRate3()
		{
			long xmin = 0;
			long samplingrate = 10;
			double[] data = {0.2,0.8};
			IDiscretePDFunction function = MathTools.DiscreteFunctions.DiscreteValuePDFunction(xmin,samplingrate,data);

			function.AdjustSamplingRate(5);
			Assert.AreEqual(5,function.SamplingRate);
			Assert.AreEqual(new double[]{0.2,0.4,0.4},function.Data );
			Assert.AreEqual(0,function.XMin);
		}
	}
}
#endif