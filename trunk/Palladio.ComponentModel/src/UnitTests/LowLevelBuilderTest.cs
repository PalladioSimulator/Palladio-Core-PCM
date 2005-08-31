#if TEST
using NUnit.Framework;
using Palladio.ComponentModel.Builder.TypeLevelBuilder;
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
		public void NewBCWithoutParent()
		{
			// new
			Identifier.IComponentIdentifier ci = new Identifier.InternalEntityIdentifier();
			IComponent component = EntityFactory.CreateComponent(ci, ComponentType.BASIC, "test");
			modelManager.LowLevelBuilder.CreateComponent(component);
			modelManager.LowLevelBuilder.AddComponent(component.ComponentID,null);
		}

		[Test]
		[ExpectedException(typeof(ComponentNotFoundException))]
		public void ParentComponentNotFound()
		{
			IComponent cc = EntityFactory.CreateComponent(ComponentType.COMPOSITE,"CC");
			modelManager.LowLevelBuilder.AddComponent(cc.ComponentID,cc.ComponentID);
		}

		[Test]
		[ExpectedException(typeof(WrongComponentTypeException))]
		public void ComponentFromWrongType()
		{
			IComponent bc1 = EntityFactory.CreateComponent(ComponentType.BASIC,"BC1");
			IComponent bc2 = EntityFactory.CreateComponent(ComponentType.BASIC,"BC2");
			modelManager.LowLevelBuilder.CreateComponent(bc1);
			modelManager.LowLevelBuilder.CreateComponent(bc2);
			modelManager.LowLevelBuilder.AddComponent(bc1.ComponentID,bc2.ComponentID);
		}

		[Test]
		[ExpectedException(typeof(EntityAlreadyExistsException))]
		public void AddSameComponentTwice()
		{
			IComponent cc = EntityFactory.CreateComponent(ComponentType.BASIC,"CC");
			modelManager.LowLevelBuilder.CreateComponent(cc);
			modelManager.LowLevelBuilder.AddComponent(cc.ComponentID,null);
			modelManager.LowLevelBuilder.AddComponent(cc.ComponentID,null);
		}

		[Test]
		[ExpectedException(typeof(ComponentNotFoundException))]
		public void RemoveComponent()
		{
			IComponent cc = EntityFactory.CreateComponent(ComponentType.COMPOSITE,"CC");
			modelManager.LowLevelBuilder.CreateComponent(cc);
			modelManager.LowLevelBuilder.AddComponent(cc.ComponentID,null);

			IComponent bc = EntityFactory.CreateComponent(ComponentType.BASIC,"BC");
			modelManager.LowLevelBuilder.CreateComponent(bc);
			modelManager.LowLevelBuilder.AddComponent(bc.ComponentID,cc.ComponentID);
			modelManager.LowLevelBuilder.RemoveComponentFromComponent(bc.ComponentID,cc.ComponentID);
			modelManager.LowLevelBuilder.AddComponent(bc.ComponentID,cc.ComponentID);
			//remove with cascade
			modelManager.LowLevelBuilder.RemoveComponent(cc.ComponentID);
			//ComponentNotFoundException expected 
			modelManager.LowLevelBuilder.AddComponent(bc.ComponentID,cc.ComponentID);
		}

		[Test]
		public void AddInterfaceTest()
		{
			IInterface iface = EntityFactory.CreateInterface("ICloneable");
			modelManager.LowLevelBuilder.CreateInterface(iface);
		}

		[Test]
		public void AddSignature()
		{
			IInterface iface = EntityFactory.CreateInterface("ICloneable");
			modelManager.LowLevelBuilder.CreateInterface(iface);
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

			modelManager.LowLevelBuilder.CreateComponent(cc);
			modelManager.LowLevelBuilder.AddInterface(cc.ComponentID,iface.InterfaceID,InterfaceRole.PROVIDES);
		}

		[Test]
		[ExpectedException(typeof(ComponentNotFoundException))]
		public void AddInterfaceToComponentComponentNotFound()
		{
			IInterface iface = EntityFactory.CreateInterface("ICloneable");
			IComponent cc = EntityFactory.CreateComponent(ComponentType.COMPOSITE,"CC");
			
			modelManager.LowLevelBuilder.CreateInterface(iface);
			modelManager.LowLevelBuilder.AddInterface(cc.ComponentID,iface.InterfaceID,InterfaceRole.REQUIRES);
		}

		[Test]
		public void AddInterfaceToComponent()
		{
			IInterface iface = EntityFactory.CreateInterface("ICloneable");
			IComponent cc = EntityFactory.CreateComponent(ComponentType.COMPOSITE,"CC");

			modelManager.LowLevelBuilder.CreateInterface(iface);
			modelManager.LowLevelBuilder.CreateComponent(cc);
			modelManager.LowLevelBuilder.AddInterface(cc.ComponentID,iface.InterfaceID,InterfaceRole.PROVIDES);
			modelManager.LowLevelBuilder.AddInterface(cc.ComponentID,iface.InterfaceID,InterfaceRole.REQUIRES);
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
			modelManager.LowLevelBuilder.CreateComponent(cc1);
			modelManager.LowLevelBuilder.CreateComponent(bc2);
			modelManager.LowLevelBuilder.CreateComponent(bc1);

			//add them to the static view
			modelManager.LowLevelBuilder.AddComponent(cc1.ComponentID,null);
			modelManager.LowLevelBuilder.AddComponent(bc2.ComponentID, null);
			modelManager.LowLevelBuilder.AddComponent(bc1.ComponentID, cc1.ComponentID);

			//add the interfaces to the model
			modelManager.LowLevelBuilder.CreateInterface(ifaceWBE);
			modelManager.LowLevelBuilder.CreateInterface(ifaceW);

			//bind the interfaces to the component
			modelManager.LowLevelBuilder.AddInterface(cc1.ComponentID,ifaceW.InterfaceID, InterfaceRole.PROVIDES);
			modelManager.LowLevelBuilder.AddInterface(cc1.ComponentID,ifaceWBE.InterfaceID, InterfaceRole.REQUIRES);
			modelManager.LowLevelBuilder.AddInterface(bc1.ComponentID,ifaceW.InterfaceID, InterfaceRole.PROVIDES);
			modelManager.LowLevelBuilder.AddInterface(bc1.ComponentID,ifaceWBE.InterfaceID, InterfaceRole.REQUIRES);
			modelManager.LowLevelBuilder.AddInterface(bc2.ComponentID,ifaceWBE.InterfaceID, InterfaceRole.PROVIDES);

			//add the connections
			modelManager.LowLevelBuilder.AddProvidesDelegationConnector(delProv,new ConnectionPoint(ifaceW.InterfaceID,cc1.ComponentID),
				new ConnectionPoint(ifaceW.InterfaceID,bc1.ComponentID));
			modelManager.LowLevelBuilder.AddRequiresDelegationConnector(delReq,new ConnectionPoint(ifaceWBE.InterfaceID,bc1.ComponentID),
				new ConnectionPoint(ifaceWBE.InterfaceID,cc1.ComponentID));
			modelManager.LowLevelBuilder.AddAssemblyConnector(assCon,null,new ConnectionPoint(ifaceWBE.InterfaceID,cc1.ComponentID),
				new ConnectionPoint(ifaceWBE.InterfaceID,bc2.ComponentID));
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

			modelManager.LowLevelBuilder.CreateComponent(bc1);
			modelManager.LowLevelBuilder.CreateComponent(bc2);

			modelManager.LowLevelBuilder.CreateInterface(ifaceWBE);

			modelManager.LowLevelBuilder.AddComponent(bc1.ComponentID,null);
			modelManager.LowLevelBuilder.AddComponent(bc2.ComponentID,null);
			//the error
		//	modelManager.LowLevelBuilder.AddInterface(bc1.ComponentID,ifaceWBE.InterfaceID, InterfaceRole.REQUIRES);
			modelManager.LowLevelBuilder.AddInterface(bc2.ComponentID,ifaceWBE.InterfaceID, InterfaceRole.PROVIDES);

			//add the connections
			modelManager.LowLevelBuilder.AddAssemblyConnector(assCon,null,new ConnectionPoint(ifaceWBE.InterfaceID,bc1.ComponentID),
				new ConnectionPoint(ifaceWBE.InterfaceID,bc2.ComponentID));
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

			modelManager.LowLevelBuilder.CreateComponent(cc1);
			modelManager.LowLevelBuilder.CreateComponent(bc1);
			modelManager.LowLevelBuilder.CreateComponent(bc2);

			modelManager.LowLevelBuilder.AddComponent(cc1.ComponentID, null);
			modelManager.LowLevelBuilder.AddComponent(bc1.ComponentID, cc1.ComponentID);
			modelManager.LowLevelBuilder.AddComponent(bc2.ComponentID, null);

			modelManager.LowLevelBuilder.CreateInterface(ifaceWBE);

			//bind the interfaces to the component
			modelManager.LowLevelBuilder.AddInterface(bc1.ComponentID,ifaceWBE.InterfaceID, InterfaceRole.REQUIRES);
			modelManager.LowLevelBuilder.AddInterface(bc2.ComponentID,ifaceWBE.InterfaceID, InterfaceRole.PROVIDES);

			//add the connections
			modelManager.LowLevelBuilder.AddAssemblyConnector(assCon,null,new ConnectionPoint(ifaceWBE.InterfaceID,bc1.ComponentID),
				new ConnectionPoint(ifaceWBE.InterfaceID,bc2.ComponentID));
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

			modelManager.LowLevelBuilder.CreateComponent(cc1);
			modelManager.LowLevelBuilder.CreateComponent(bc1);

			modelManager.LowLevelBuilder.AddComponent(cc1.ComponentID, null);
			modelManager.LowLevelBuilder.AddComponent(bc1.ComponentID, null);

			modelManager.LowLevelBuilder.CreateInterface(ifaceWBE);

			//bind the interfaces to the component
			modelManager.LowLevelBuilder.AddInterface(bc1.ComponentID,ifaceWBE.InterfaceID, InterfaceRole.REQUIRES);
			modelManager.LowLevelBuilder.AddInterface(cc1.ComponentID,ifaceWBE.InterfaceID, InterfaceRole.REQUIRES);

			//add the connections
			modelManager.LowLevelBuilder.AddRequiresDelegationConnector(assCon,new ConnectionPoint(ifaceWBE.InterfaceID,bc1.ComponentID),
				new ConnectionPoint(ifaceWBE.InterfaceID,cc1.ComponentID));
		}
	}
}

#endif