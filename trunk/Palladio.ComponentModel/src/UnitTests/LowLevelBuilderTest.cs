#if TEST
using NUnit.Framework;
using Palladio.ComponentModel.Exceptions;
using Palladio.ComponentModel.ModelDataManagement;
using Palladio.ComponentModel.ModelEntities;

namespace Palladio.ComponentModel.UnitTests
{
	/// <summary>
	/// Testcases to test the lowlevelbuilder
	/// </summary>
	[TestFixture]	
	public class LowLevelBuilderTest
	{
		private ModelDataManager modelManager;

		public LowLevelBuilderTest()
		{
			
		}

		[SetUp]
		public void Init()
		{
			modelManager = new ModelDataManager();
		}

		[Test]
		[ExpectedException(typeof(ComponentNotFoundException))]
		public void ParentComponentNotFound()
		{
			IComponent cc = EntityFactory.CreateComponent(ComponentType.COMPOSITE,"CC");
			modelManager.LowLevelBuilder.AddComponent(cc,cc.ComponentID);
		}
		[Test]
		[ExpectedException(typeof(WrongComponentTypeException))]
		public void ComponentFromWrongType()
		{
			IComponent cc = EntityFactory.CreateComponent(ComponentType.BASIC,"CC");
			modelManager.LowLevelBuilder.AddComponent(cc,null);

			IComponent bc = EntityFactory.CreateComponent(ComponentType.BASIC,"BC");
			modelManager.LowLevelBuilder.AddComponent(bc,cc.ComponentID);
		}

		[Test]
		[ExpectedException(typeof(EntityAlreadyExistsException))]
		public void AddSameComponentTwice()
		{
			IComponent cc = EntityFactory.CreateComponent(ComponentType.BASIC,"CC");
			modelManager.LowLevelBuilder.AddComponent(cc,null);
			modelManager.LowLevelBuilder.AddComponent(cc,null);
		}

		[Test]
		[ExpectedException(typeof(ComponentNotFoundException))]
		public void RemoveComponent()
		{
			IComponent cc = EntityFactory.CreateComponent(ComponentType.COMPOSITE,"CC");
			modelManager.LowLevelBuilder.AddComponent(cc,null);

			IComponent bc = EntityFactory.CreateComponent(ComponentType.BASIC,"BC");
			modelManager.LowLevelBuilder.AddComponent(bc,cc.ComponentID);
			modelManager.LowLevelBuilder.RemoveComponent(bc.ComponentID);
			modelManager.LowLevelBuilder.AddComponent(bc,cc.ComponentID);
			//remove with cascade
			modelManager.LowLevelBuilder.RemoveComponent(cc.ComponentID);
			//ComponentNotFoundException expected 
			modelManager.LowLevelBuilder.AddComponent(bc,cc.ComponentID);
		}

		[Test]
		public void AddInterfaceTest()
		{
			IInterface iface = EntityFactory.CreateInterface("ICloneable");
            modelManager.LowLevelBuilder.AddInterface(iface);
		}

		[Test]
		public void AddSignature()
		{
			IInterface iface = EntityFactory.CreateInterface("ICloneable");
			modelManager.LowLevelBuilder.AddInterface(iface);
			ISignature sig = EntityFactory.CreateSignature("Clone",new SignatureDescription());
			modelManager.LowLevelBuilder.AddSignature(sig,iface.InterfaceID);
		}

		[Test]
		[ExpectedException(typeof(InterfaceNotFoundException))]
		public void AddSignatureIFaceNotFound()
		{
			IInterface iface = EntityFactory.CreateInterface("ICloneable");
			ISignature sig = EntityFactory.CreateSignature("Clone",new SignatureDescription());
			modelManager.LowLevelBuilder.AddSignature(sig,iface.InterfaceID);
		}

		[Test]
		[ExpectedException(typeof(InterfaceNotFoundException))]
		public void AddInterfaceToComponentIFaceNotFound()
		{
			IComponent cc = EntityFactory.CreateComponent(ComponentType.COMPOSITE,"CC");
			IInterface iface = EntityFactory.CreateInterface("ICloneable");

			modelManager.LowLevelBuilder.AddComponent(cc,null);
			modelManager.LowLevelBuilder.AddInterfaceToComponent(cc.ComponentID,iface.InterfaceID,InterfaceRole.PROVIDES);
		}

		[Test]
		[ExpectedException(typeof(ComponentNotFoundException))]
		public void AddInterfaceToComponentComponentNotFound()
		{
			IInterface iface = EntityFactory.CreateInterface("ICloneable");
			IComponent cc = EntityFactory.CreateComponent(ComponentType.COMPOSITE,"CC");
			
			modelManager.LowLevelBuilder.AddInterface(iface);
			modelManager.LowLevelBuilder.AddInterfaceToComponent(cc.ComponentID,iface.InterfaceID,InterfaceRole.REQUIRES);
		}

		[Test]
		public void AddInterfaceToComponent()
		{
			IInterface iface = EntityFactory.CreateInterface("ICloneable");
			IComponent cc = EntityFactory.CreateComponent(ComponentType.COMPOSITE,"CC");

			modelManager.LowLevelBuilder.AddInterface(iface);
			modelManager.LowLevelBuilder.AddComponent(cc,null);
			modelManager.LowLevelBuilder.AddInterfaceToComponent(cc.ComponentID,iface.InterfaceID,InterfaceRole.PROVIDES);
			modelManager.LowLevelBuilder.AddInterfaceToComponent(cc.ComponentID,iface.InterfaceID,InterfaceRole.REQUIRES);
		}

		[Test]
		public void AddConnections()
		{
			//creates the entities
			IInterface ifaceWBE = EntityFactory.CreateInterface("IWriterBackEnd");
			IInterface ifaceW = EntityFactory.CreateInterface("IWriter");
			IComponent cc1 = EntityFactory.CreateComponent(ComponentType.COMPOSITE,"WriterCC");
			IComponent bc1 = EntityFactory.CreateComponent(ComponentType.BASIC,"Writer");
			IComponent bc2 = EntityFactory.CreateComponent(ComponentType.BASIC,"WriterBackEnd");
			IConnection delProv = EntityFactory.CreateConnection("cc->bc1");
			IConnection delReq = EntityFactory.CreateConnection("bc1->cc");
			IConnection assCon = EntityFactory.CreateConnection("cc->bc2");

			//add the components to the model
			modelManager.LowLevelBuilder.AddComponent(cc1,null);
			modelManager.LowLevelBuilder.AddComponent(bc2, null);
			modelManager.LowLevelBuilder.AddComponent(bc1, cc1.ComponentID);

			//add the interfaces to the model
			modelManager.LowLevelBuilder.AddInterface(ifaceWBE);
			modelManager.LowLevelBuilder.AddInterface(ifaceW);

			//bind the interfaces to the component
			modelManager.LowLevelBuilder.AddInterfaceToComponent(cc1.ComponentID,ifaceW.InterfaceID, InterfaceRole.PROVIDES);
			modelManager.LowLevelBuilder.AddInterfaceToComponent(cc1.ComponentID,ifaceWBE.InterfaceID, InterfaceRole.REQUIRES);
			modelManager.LowLevelBuilder.AddInterfaceToComponent(bc1.ComponentID,ifaceW.InterfaceID, InterfaceRole.PROVIDES);
			modelManager.LowLevelBuilder.AddInterfaceToComponent(bc1.ComponentID,ifaceWBE.InterfaceID, InterfaceRole.REQUIRES);
			modelManager.LowLevelBuilder.AddInterfaceToComponent(bc2.ComponentID,ifaceWBE.InterfaceID, InterfaceRole.PROVIDES);

			//add the connections
			modelManager.LowLevelBuilder.AddProvidesDelegationConnector(delProv,cc1.ComponentID,ifaceW.InterfaceID,
				bc1.ComponentID,ifaceW.InterfaceID);
			modelManager.LowLevelBuilder.AddRequiresDelegationConnector(delReq,bc1.ComponentID,ifaceWBE.InterfaceID,
				cc1.ComponentID,ifaceWBE.InterfaceID);
			modelManager.LowLevelBuilder.AddAssemblyConnector(assCon,cc1.ComponentID,ifaceWBE.InterfaceID,
				bc2.ComponentID,ifaceWBE.InterfaceID);
		}

		[Test]
		[ExpectedException(typeof(InterfaceNotFromComponentException))]
		public void AddConnectionsIFaceNotBound()
		{
			//creates the entities
			IInterface ifaceWBE = EntityFactory.CreateInterface("IWriterBackEnd");
			IComponent bc1 = EntityFactory.CreateComponent(ComponentType.BASIC,"Writer");
			IComponent bc2 = EntityFactory.CreateComponent(ComponentType.BASIC,"WriterBackEnd");
			IConnection assCon = EntityFactory.CreateConnection("bc1->bc2");

			modelManager.LowLevelBuilder.AddComponent(bc1, null);
			modelManager.LowLevelBuilder.AddComponent(bc2, null);

			modelManager.LowLevelBuilder.AddInterface(ifaceWBE);

			//the error
		//	modelManager.LowLevelBuilder.AddInterfaceToComponent(bc1.ComponentID,ifaceWBE.InterfaceID, InterfaceRole.REQUIRES);
			modelManager.LowLevelBuilder.AddInterfaceToComponent(bc2.ComponentID,ifaceWBE.InterfaceID, InterfaceRole.PROVIDES);

			//add the connections
			modelManager.LowLevelBuilder.AddAssemblyConnector(assCon,bc1.ComponentID,ifaceWBE.InterfaceID,
				bc2.ComponentID,ifaceWBE.InterfaceID);
		}

		[Test]
		[ExpectedException(typeof(ComponentHierarchyException))]
		public void AddAssemblyConnectorHierarchyException()
		{
			//creates the entities
			IInterface ifaceWBE = EntityFactory.CreateInterface("IWriterBackEnd");
			IComponent bc1 = EntityFactory.CreateComponent(ComponentType.BASIC,"Writer");
			IComponent bc2 = EntityFactory.CreateComponent(ComponentType.BASIC,"WriterBackEnd");
			IComponent cc1 = EntityFactory.CreateComponent(ComponentType.COMPOSITE,"Writer");
			IConnection assCon = EntityFactory.CreateConnection("cc->bc2");

			modelManager.LowLevelBuilder.AddComponent(cc1, null);
			modelManager.LowLevelBuilder.AddComponent(bc1, cc1.ComponentID);
			modelManager.LowLevelBuilder.AddComponent(bc2, null);

			modelManager.LowLevelBuilder.AddInterface(ifaceWBE);

			//bind the interfaces to the component
			modelManager.LowLevelBuilder.AddInterfaceToComponent(bc1.ComponentID,ifaceWBE.InterfaceID, InterfaceRole.REQUIRES);
			modelManager.LowLevelBuilder.AddInterfaceToComponent(bc2.ComponentID,ifaceWBE.InterfaceID, InterfaceRole.PROVIDES);

			//add the connections
			modelManager.LowLevelBuilder.AddAssemblyConnector(assCon,bc1.ComponentID,ifaceWBE.InterfaceID,
				bc2.ComponentID,ifaceWBE.InterfaceID);
		}

		[Test]
		[ExpectedException(typeof(ComponentHierarchyException))]
		public void AddDelegationConnectorHierarchyException()
		{
			//creates the entities
			IInterface ifaceWBE = EntityFactory.CreateInterface("IWriterBackEnd");
			IComponent bc1 = EntityFactory.CreateComponent(ComponentType.BASIC,"Writer");
			IComponent cc1 = EntityFactory.CreateComponent(ComponentType.COMPOSITE,"Writer");
			IConnection assCon = EntityFactory.CreateConnection("bc1->cc1");

			modelManager.LowLevelBuilder.AddComponent(cc1, null);
			modelManager.LowLevelBuilder.AddComponent(bc1, null);

			modelManager.LowLevelBuilder.AddInterface(ifaceWBE);

			//bind the interfaces to the component
			modelManager.LowLevelBuilder.AddInterfaceToComponent(bc1.ComponentID,ifaceWBE.InterfaceID, InterfaceRole.REQUIRES);
			modelManager.LowLevelBuilder.AddInterfaceToComponent(cc1.ComponentID,ifaceWBE.InterfaceID, InterfaceRole.REQUIRES);

			//add the connections
			modelManager.LowLevelBuilder.AddRequiresDelegationConnector(assCon,bc1.ComponentID,ifaceWBE.InterfaceID,
				cc1.ComponentID,ifaceWBE.InterfaceID);
		}
	}
}

#endif