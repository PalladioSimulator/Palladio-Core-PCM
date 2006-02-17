using NUnit.Framework;
using Palladio.FiniteStateMachines;
using Palladio.Performance.Attributes;
using Palladio.Performance.WebserverSeff;

#if TEST
namespace WebserverSeff.src.Test
{
	[TestFixture]
	public class TestSeffWithAttributeCreator
	{

		[Test]
		public void TestBuildCompletePath()
		{
			IFiniteStateMachine buildCompletePath =
				factory.CreateSeff_DefaultHTTPRequestProcessor_BuildCompletePath();
			string serviceName = "Palladio.Webserver.HTTPRequestProcessor.DefaultHTTPRequestProcessorTools_IHTTPRequestProcessorTools_BuildCompletePath";
			creator.AddAttributesToSeff(buildCompletePath,serviceName);
			Assert.AreEqual(1330, 
				MeasureAttribute.GetAttribute(WebserverModelHelper.GetState(7101))[0]);
			Assert.AreEqual(1, MeasureAttribute.GetAttribute(WebserverModelHelper.GetState(7101)).measures.Count);

			Assert.AreEqual(10, MeasureAttribute.GetAttribute(WebserverModelHelper.GetState(7102))[0]);
			Assert.AreEqual(1, MeasureAttribute.GetAttribute(WebserverModelHelper.GetState(7102)).measures.Count);

			Assert.AreEqual(6356, MeasureAttribute.GetAttribute(WebserverModelHelper.GetTransition(7103))[0]);
			Assert.AreEqual(1, MeasureAttribute.GetAttribute(WebserverModelHelper.GetState(7102)).measures.Count);

		}

		[TestFixtureSetUp]
		public void Init()
		{
			factory = new WebserverSeffFactory();
			creator = new SeffWithAttributeCreator(file, 100);
		}

		string file = "../../../TestData/Measure6.xml";
		WebserverSeffFactory factory;
		SeffWithAttributeCreator creator;
	}
}
#endif