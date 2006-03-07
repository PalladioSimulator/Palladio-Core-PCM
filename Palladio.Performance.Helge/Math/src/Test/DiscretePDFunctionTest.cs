#if TEST
using NUnit.Framework;
using Palladio.Performance.Math.Functions.Discrete;

namespace Palladio.Performance.Math.Test
{
	/// <summary>
	/// Zusammenfassung für DiscreteFunctionTest.
	/// </summary>
	[TestFixture]
	public class DiscretePDFunctionTest
	{
		public DiscretePDFunctionTest()
		{
			//
			// TODO: Fügen Sie hier die Konstruktorlogik hinzu
			//
		}

		[Test]
		public void TotalProb()
		{
			long xmin= 20;
			long samplingrate=10;
			double[] data = {0.2,0.15,0.15,0.4,0.1};
			IDiscretePDFunction function = 
				MathTools.DiscreteFunctions.DiscreteValuePDFunction(xmin,samplingrate,data);
			Assert.AreEqual(1,function.TotalProb);
		}

		[Test]
		public void Median()
		{
			long xmin= 20;
			long samplingrate=10;
			double[] data = {0.2,0.15,0.15,0.4,0.1};
			IDiscretePDFunction function = 
				MathTools.DiscreteFunctions.DiscreteValuePDFunction(xmin,samplingrate,data);
			Assert.AreEqual(40,function.Median);
		}

		[Test]
		public void UpperQuartil()
		{
			long xmin= 20;
			long samplingrate=10;
			double[] data = {0.2,0.15,0.15,0.4,0.1};
			DiscretePDFunction function = 
				(DiscretePDFunction) MathTools.DiscreteFunctions.DiscreteValuePDFunction(xmin,samplingrate,data);
			Assert.AreEqual(50,function.UpperQuartil);
		}

		[Test]
		public void Expectancy()
		{
			long xmin= 20;
			long samplingrate=10;
			double[] data = {0.2,0.1,0.3,0.1,0.3};
			IDiscretePDFunction function = 
				MathTools.DiscreteFunctions.DiscreteValuePDFunction(xmin,samplingrate,data);
			Assert.AreEqual(42,function.Expectancy);
		}

		[Test]
		public void Variance()
		{
			long xmin= 20;
			long samplingrate=10;
			double[] data = {0.2,0.1,0.3,0.1,0.3};
			DiscretePDFunction function = 
				(DiscretePDFunction) MathTools.DiscreteFunctions.DiscreteValuePDFunction(xmin,samplingrate,data);
			Assert.AreEqual(1020,function.Variance);
		}
	}
}
#endif