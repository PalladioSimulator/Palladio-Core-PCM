#if TEST
using System;
using MathNet.Numerics;
using NUnit.Framework;

namespace Palladio.Performance.Math.Test
{
	/// <summary>
	/// Zusammenfassung für FourierTest.
	/// </summary>
	[TestFixture]
	public class FourierTest
	{

		/// <summary>
		/// This tests, that the data array is not changed while silmy transform in the frequency domain
		/// and transform back to the time domain.
		/// </summary>
		[Test]
		public void FourierTransform()
		{
			long xmin = 6;
			long samplingrate = 2;
			double[] data = {0.2,0.15,0.3,0.35};
			IDiscretePDFunction function = MathTools.DiscreteFunctions.DiscreteValuePDFunction(xmin,samplingrate,data);

			Complex[] fourierTransformed = MathTools.FastFourierTransform.ForwardFromReal(function.Data);
			double[] backTransformed = MathTools.FastFourierTransform.BackwardToReal(fourierTransformed);

			Assert.AreEqual(data,backTransformed);
		}

		/// <summary>
		/// This Test throws an ApplicationException, because the length of the data array is not
		/// a power of 2.
		/// </summary>
		[Test]
		[ExpectedException(typeof(ApplicationException))]
		public void FourierTransformException()
		{
			long xmin = 6;
			long samplingrate = 2;
			double[] data = {0.2,0.15,0.3,0.35,0};
			IDiscretePDFunction function = MathTools.DiscreteFunctions.DiscreteValuePDFunction(xmin,samplingrate,data);

			Complex[] fourierTransformed = MathTools.FastFourierTransform.ForwardFromReal(function.Data);
			double[] backTransformed = MathTools.FastFourierTransform.BackwardToReal(fourierTransformed);

			Assert.AreEqual(data,backTransformed);
		}

		/// <summary>
		/// This tests, that the multiplication in den frquency domain is the same as the 
		/// convolution in the time domain. For this the data array must be big enough.
		/// </summary>
		[Test]
		public void FourierMultiplication()
		{
			long xmin = 0;
			long samplingrate = 2;
			double[] data = {0.2,0.15,0.3,0.35};
			IDiscretePDFunction function = MathTools.DiscreteFunctions.DiscreteValuePDFunction(xmin,samplingrate,data);
			IDiscreteFunction convolutionTimeSpace = function.Convolution(function);
			convolutionTimeSpace.ExpandDomainPo2(0,12);
			function.ExpandDomainPo2(0,12);

			Complex[] fourierTransformed = MathTools.FastFourierTransform.ForwardFromReal(function.Data);
			IFourierFunction ff = 
				MathTools.DiscreteFunctions.DiscreteFourierFunction(fourierTransformed,samplingrate);
			IFourierFunction ffMultiply = ff.Multiply(ff);
			double[] backTransformed = MathTools.FastFourierTransform.BackwardToReal(ffMultiply.Data);
			IDiscretePDFunction backTransformedFunction =
				MathTools.DiscreteFunctions.DiscreteValuePDFunction(xmin,samplingrate,backTransformed);
			backTransformedFunction.DismissValuesSmalerThanN(0.0000000000001);

			Assert.AreEqual(convolutionTimeSpace.Data,backTransformedFunction.Data);
		}
		
		/// <summary>
		/// This tests, that the multiplication in den frquency domain is the same as the 
		/// convolution in the time domain. For this the data array must be big enough.
		/// </summary>
		[Test]
		public void FourierAddition()
		{
			long xmin = 0;
			long samplingrate = 2;
			double[] data = {0.2,0.15,0.3,0.35};
			IDiscretePDFunction function = MathTools.DiscreteFunctions.DiscreteValuePDFunction(xmin,samplingrate,data);
			IDiscreteFunction AdditionTimeSpace = function.Add(function);

			Complex[] fourierTransformed = MathTools.FastFourierTransform.ForwardFromReal(function.Data);
			IFourierFunction ff = 
				MathTools.DiscreteFunctions.DiscreteFourierFunction(fourierTransformed,samplingrate);
			IFourierFunction ffAdd = ff.Add(ff);
			double[] backTransformed = MathTools.FastFourierTransform.BackwardToReal(ffAdd.Data);
			IDiscretePDFunction backTransformedFunction =
				MathTools.DiscreteFunctions.DiscreteValuePDFunction(xmin,samplingrate,backTransformed);
			backTransformedFunction.DismissValuesSmalerThanN(0.0000000000001);

			Assert.AreEqual(AdditionTimeSpace.Data,backTransformedFunction.Data);
		}

		[Test]
		public void TestComputeLoopLimit()
		{
			long xmin = 0;
			long samplingrate = 2;
			double[] data = {0.2,0.15,0.3,0.35};
			IDiscretePDFunction function = MathTools.DiscreteFunctions.DiscreteValuePDFunction(xmin,samplingrate,data);
			Complex[] fourierTransformed = MathTools.FastFourierTransform.ForwardFromReal(function.Data);
			IFourierFunction ff = 
				MathTools.DiscreteFunctions.DiscreteFourierFunction(fourierTransformed,samplingrate);

			double p=0;
			while(p<=1){
				IFourierFunction result = ff.ComputeLoopLimit(p);
				IDiscretePDFunction resultTimeDomain =
					MathTools.DiscreteFunctions.DiscreteValuePDFunction(result);
				Assert.IsTrue(System.Math.Round(resultTimeDomain.TotalProb,5) == 1);
				p +=0.1;
			}
		}

		[Test]
		public void CompareSimpleAndFastFourierTransform()
		{
			double[] data = {0.2,0.15,0.3,0.35};
			Complex[] simpleFT = MathTools.SimpleFourierTransform.ForwardFromReal(data);
			Complex[] fastFT = MathTools.FastFourierTransform.ForwardFromReal(data);

			Assert.AreEqual(simpleFT,fastFT);
		}
	}
}
#endif