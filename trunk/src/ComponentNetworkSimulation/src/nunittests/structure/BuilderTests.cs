using System;
using Palladio.ComponentModel;
using ComponentNetworkSimulation.Structure;
using ComponentNetworkSimulation.Structure.Builder;
using ComponentNetworkSimulation.Structure.Elements;
using NUnit.Framework;

namespace nunittests.structure
{
	/// <summary>
	/// Zusammenfassung für BuilderTests.
	/// </summary>
	[TestFixture]
	public class BuilderTests
	{
		public static IBuilderFactory factory = new DefaultBuilderFactory(new DefaultElementFactory());

		public BuilderTests()
		{
		}

		[SetUp]
		public void Init()
		{
		}

		[Test]
		public void BasicComponentBuilderTest()
		{
			IBasicComponent comp = ComponentFactory.CreateBasicComponent("comp");
			IBasicComponent comp2 = ComponentFactory.CreateBasicComponent("comp");

			IBasicComponentBuilder builder = factory.CreateBuilder(comp2);

			comp.AddProvidesInterface(ID("P1"),ComponentFactory.CreateInterfaceModel());
			Assert.IsFalse(comp.Equals(comp2));
			builder.AddProvidesInterface(ID("P1"));

			builder.AddRequiresInterface(ID("R1"));
			Assert.IsFalse(comp.Equals(comp2));
			comp.AddRequiresInterface(ID("R1"),ComponentFactory.CreateInterfaceModel());

			Assert.AreEqual(comp,comp2);
		}

		[Test]
		public void CompositeComponentBuilderTest()
		{
			ICompositeComponent cc = ComponentFactory.CreateCompositeComponent("CC");
			Assert.IsFalse(ReferenceArchitecture.CreateCompositeComponent().Equals(cc));

			TestArchitectures.FillCC(factory.CreateBuilder(cc));
			Assert.IsTrue(ReferenceArchitecture.CreateCompositeComponent().Equals(cc));
		}

		[Test]
		public void ServiceBuilderTest()
		{
			//test c2 created with builder using the one from the reference architecture 
			IBasicComponent c1 = ComponentFactory.CreateBasicComponent("C1");
			Assert.IsFalse(ReferenceArchitecture.CreateC1().Equals(c1));

			TestArchitectures.FillC1(factory.CreateBuilder(c1));
			Assert.IsTrue(ReferenceArchitecture.CreateC1().Equals(c1));

			//test c2 created with builder using the one from the reference architecture 			
			IBasicComponent c2 = ComponentFactory.CreateBasicComponent("C1");
			Assert.IsFalse(ReferenceArchitecture.CreateC2().Equals(c2));

			TestArchitectures.FillC2(factory.CreateBuilder(c2));
			Assert.IsTrue(ReferenceArchitecture.CreateC2().Equals(c2));
		}

		public static Palladio.Identifier.IIdentifier ID(string id)
		{
			return Palladio.Identifier.IdentifiableFactory.CreateStringID(id);
		}
	}
}
