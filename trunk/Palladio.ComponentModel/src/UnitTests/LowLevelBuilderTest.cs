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
			modelManager = new ModelDataManager();
		}

		[Test]
		[ExpectedException(typeof(ComponentNotFoundException))]
		public void ParentComponentNotFound()
		{
			IComponent cc = EntityFactory.CreateComponent(ComponentType.COMPOSITE,"CC");
			modelManager.LowLevelBulder.AddComponent(cc,cc.ComponentID);
		}
		[Test]
		[ExpectedException(typeof(WrongComponentTypeException))]
		public void ComponentFromWrongType()
		{
			IComponent cc = EntityFactory.CreateComponent(ComponentType.BASIC,"CC");
			modelManager.LowLevelBulder.AddComponent(cc,null);

			IComponent bc = EntityFactory.CreateComponent(ComponentType.BASIC,"BC");
			modelManager.LowLevelBulder.AddComponent(bc,cc.ComponentID);
		}

		[Test]
		[ExpectedException(typeof(EntityAlreadyExistsException))]
		public void AddSameComponentTwice()
		{
			IComponent cc = EntityFactory.CreateComponent(ComponentType.BASIC,"CC");
			modelManager.LowLevelBulder.AddComponent(cc,null);
			modelManager.LowLevelBulder.AddComponent(cc,null);
		}

		[Test]
		[ExpectedException(typeof(ComponentNotFoundException))]
		public void RemoveComponent()
		{
			IComponent cc = EntityFactory.CreateComponent(ComponentType.COMPOSITE,"CC");
			modelManager.LowLevelBulder.AddComponent(cc,null);

			IComponent bc = EntityFactory.CreateComponent(ComponentType.BASIC,"BC");
			modelManager.LowLevelBulder.AddComponent(bc,cc.ComponentID);
			modelManager.LowLevelBulder.RemoveComponent(bc.ComponentID);
			modelManager.LowLevelBulder.AddComponent(bc,cc.ComponentID);
			//remove with cascade
			modelManager.LowLevelBulder.RemoveComponent(cc.ComponentID);
			//ComponentNotFoundException expected 
			modelManager.LowLevelBulder.AddComponent(bc,cc.ComponentID);
		}

		[Test]
		public void AddInterfaceTest()
		{
			IInterface iface = EntityFactory.CreateInterface("ICloneable");
            modelManager.LowLevelBulder.AddInterface(iface);
		}

		[Test]
		public void AddSignature()
		{
			IInterface iface = EntityFactory.CreateInterface("ICloneable");
			modelManager.LowLevelBulder.AddInterface(iface);
			ISignature sig = EntityFactory.CreateSignature("Clone",new SignatureDescription());
			modelManager.LowLevelBulder.AddSignature(sig,iface.InterfaceID);
		}

		[Test]
		[ExpectedException(typeof(InterfaceNotFoundException))]
		public void AddSignatureIFaceNotFound()
		{
			IInterface iface = EntityFactory.CreateInterface("ICloneable");
			ISignature sig = EntityFactory.CreateSignature("Clone",new SignatureDescription());
			modelManager.LowLevelBulder.AddSignature(sig,iface.InterfaceID);
		}
	}
}

#endif