#if TEST
using Palladio.ComponentModel;
using Palladio.ComponentModel.Builder;
using Palladio.ComponentModel.Query.TypeLevel;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelEntities;
using NUnit.Framework;

namespace Steffen.Tests
{
	/// <summary>
	/// Testcases for the component model from Steffen. Random test cases.
	/// </summary>
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.3  2005/06/17 18:30:43  joemal
	/// fix a bug in the test
	///
	/// Revision 1.2  2005/06/12 17:07:31  joemal
	/// renamed from QueryEntity to QueryRepository
	///
	/// Revision 1.1  2005/06/08 15:23:16  sbecker
	/// Added a test suite with random tests
	/// Currently one fails
	///
	/// 
	/// </pre>
	/// </remarks>
	[TestFixture]
	public class TestSuite
	{
		[SetUp]
		public void Setup()
		{
			Init();
		}


		[Test]
		public void GetP1()
		{
			IInterface p1 = null;

			IQueryStaticViewTypeLevel tlQuery = cm.Query.QueryTypeLevel.QueryStaticView();
			IInterfaceIdentifier[] interfaces = tlQuery.GetInterfaces();
			foreach(IInterfaceIdentifier i in interfaces)
			{
				if ( cm.Query.QueryRepository.GetInterface(i).Name == "P1")
				{
					p1 = cm.Query.QueryRepository.GetInterface(i);
					break;
				}
			}
			Assert.IsNotNull(p1);
			Assert.IsTrue(cm.Query.QueryRepository.ContainsEntity(p1.ID));
			Assert.IsTrue(cm.Query.QueryTypeLevel.QueryInterface(p1.InterfaceID).GetSignatures().Length == 2);
		}

		[Test]
		public void GetCon1()
		{
			IConnectionIdentifier con1ID = cm.Query.QueryTypeLevel.QueryStaticView().GetConnections()[0];
			IConnection con1 = cm.Query.QueryRepository.GetConnection(con1ID);

			Assert.IsNotNull(con1);
			Assert.IsTrue(con1.Name == "Con1");
		}

		[Test]
		public void RemoveC1()
		{
			IConnectionIdentifier con1ID = cm.Query.QueryTypeLevel.QueryStaticView().GetConnections()[0];

			cm.BuilderManager.RootTypeLevelBuilder.RemoveComponent(C1ID);
			Assert.IsTrue(cm.Query.QueryRepository.ContainsEntity(P1ID));
			Assert.IsFalse(cm.Query.QueryRepository.ContainsEntity(con1ID));
			Assert.IsTrue(cm.Query.QueryRepository.ContainsEntity(C1ID));
			cm.BuilderManager.RootTypeLevelBuilder.DestroyComponent(C1ID);
			Assert.IsFalse(cm.Query.QueryRepository.ContainsEntity(C1ID));
		}

		private void Init()
		{
			cm = new ComponentModelEnvironment();
			BuildC1(cm.BuilderManager.RootTypeLevelBuilder.AddNewBasicComponent("C1"));
			BuildC2(cm.BuilderManager.RootTypeLevelBuilder.AddNewBasicComponent("C2"));
			cm.BuilderManager.RootTypeLevelBuilder.AddAssemblyConnector("Con1",C1ID,R1ID,C2ID,P3ID);
		}

		private void BuildC1(IBasicComponentBuilder basicComponent)
		{
			IInterfaceBuilder p1Builder = basicComponent.AddNewInterfaceAsProvides("P1");
			p1Builder.AddSignature("a");
			p1Builder.AddSignature("b");
			P1ID = p1Builder.InterfaceId;
			
			IInterfaceBuilder p2Builder = basicComponent.AddNewInterfaceAsProvides("P2");
			p2Builder.AddSignature("c");

			IInterfaceBuilder r1Builder = basicComponent.AddNewInterfaceAsRequires("R1");
			r1Builder.AddSignature("e");
			r1Builder.AddSignature("f");
			R1ID = r1Builder.InterfaceId;

			IInterfaceBuilder r2Builder = basicComponent.AddNewInterfaceAsRequires("R2");
			r2Builder.AddSignature("g");
			
			C1ID = basicComponent.ComponentId;
		}

		private void BuildC2(IBasicComponentBuilder basicComponent)
		{
			IInterfaceBuilder p3Builder = basicComponent.AddNewInterfaceAsProvides("P3");
			p3Builder.AddSignature("e");
			p3Builder.AddSignature("f");
			p3Builder.AddSignature("h");
			P3ID = p3Builder.InterfaceId;

			C2ID = basicComponent.ComponentId;
		}

		private ComponentModelEnvironment cm = null;
		private IInterfaceIdentifier R1ID = null, P3ID = null, P1ID = null;
		private IComponentIdentifier C1ID = null, C2ID = null;
	}
}
#endif