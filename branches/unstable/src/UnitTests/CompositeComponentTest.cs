#if TEST

using System;
using System.Xml;
using System.Collections;
using NUnit.Framework;
using Palladio.ComponentModel.Exceptions;
using Palladio.ComponentModel.Connections;
using Palladio.ComponentModel.Components;
using Palladio.Identifier;


namespace Palladio.ComponentModel.UnitTests
{
	/// <summary>
	/// 
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.5.2.3  2005/02/15 20:02:00  joemal
	/// diverses
	///
	/// Revision 1.5.2.2  2004/11/26 16:23:44  uffi
	/// serialization schema changed.
	/// interfaces added to structure-node.
	/// sef-serialization/deserialization
	///
	/// Revision 1.5.2.1  2004/11/16 13:37:47  uffi
	/// Initial commit of the 2.0 version of the component model. BETA!!! See the techreport (to be updated) for details.
	/// Documentation needs fixing. Some unittests fail.
	///
	/// Revision 1.5  2004/09/02 12:50:06  uffi
	/// Added XML Serialization and Deserialization functionality
	///
	/// Revision 1.4  2004/07/05 09:30:12  sbecker
	/// Changes due to the refactorings after the first review
	///
	/// Revision 1.3  2004/06/09 12:36:31  sbecker
	/// Fixed documentation and renamed IExternalSignature
	///
	/// Revision 1.2  2004/06/04 01:54:04  sliver
	/// rework of composite component
	///
	/// Revision 1.1  2004/06/02 14:50:25  sbecker
	/// Initial Import after a major rework
	///
	/// Revision 1.2  2004/05/23 19:00:07  sliver
	/// added comments
	///
	/// Revision 1.1  2004/05/23 16:03:56  sliver
	/// completed unit tests
	///
	/// </pre>
	/// </remarks>
	/// <exclude />
	[TestFixture]
	public class CompositeComponentTest
	{

		ISignatureList oSigProv1, oSigProv2, iSigProv1, iSigProv2;
		ISignatureList iSigReq1, iSigReq2;
		IInterfaceModel oProv1, oProv2, iProv1, iProv2;
		IInterfaceModel iReq1, iReq2;
		IServiceEffectSpecification d1se, d2se, d3se, d4se, d5se;
		IBasicComponent iComp1, iComp2, iComp3;
		ICompositeComponent oComp, oCompCopy;
		IMapping pm1, pm2;
		IMapping rm1, rm2;
		IBinding b1;

		[TestFixtureSetUp]
		public void Init()
		{
			CreateIComp1();
			CreateIComp2();
			CreateIComp3();
			CreateOComp();
		}
//
		[Test] public void ContainsComponents()
		{
			Assert.IsTrue( oComp.ContainsComponent(iComp1.ID) );
			Assert.IsTrue( oComp.ContainsComponent(iComp2.ID) );
			Assert.IsTrue( oComp.ContainsComponent(iComp3.ID) );
			Assert.IsTrue( oComp.Components.Length == 3 );
			Assert.IsFalse(oComp.ContainsComponent( 
				ID("not here") ) );
			Assert.IsFalse( oComp.ContainsComponent(null) );
		}


		[Test] public void ContainsConnections()
		{
			IBinding[] bindings = oComp.Bindings;
			Assert.IsTrue( bindings.Length == 1 );
			Assert.IsTrue( bindings[0].Equals(b1) );

			IMapping[] provMappings = oComp.ProvidesMappings;
			Assert.IsTrue( provMappings.Length == 2 );
			Assert.IsTrue( Array.IndexOf(provMappings, pm1) >= 0 );
			Assert.IsTrue( Array.IndexOf(provMappings, pm2) >= 0 );

			IMapping[] reqMappings = oComp.RequiresMappings;
			Assert.IsTrue( reqMappings.Length == 2 );
			Assert.IsTrue( Array.IndexOf(reqMappings, rm1) >= 0 );
			Assert.IsTrue( Array.IndexOf(reqMappings, rm2) >= 0 );
		}

		[ExpectedException(typeof(RoleIDNotFoundException))]
		[Test] public void GetGetProvidesByOuter()
		{
			Assert.AreEqual( pm1, oComp.GetProvidesMappingByOuter(ID("oProv1")) );
			Assert.AreEqual( pm2, oComp.GetProvidesMappingByOuter(ID("oProv2")) );
			oComp.GetProvidesMappingByOuter(ID("missing"));
		}

		[ExpectedException(typeof(RoleIDNotFoundException))]
		[Test] public void GetGetProvidesByInner()
		{
			IMapping[] mappings = oComp.GetProvidesMappingsByInner(iComp1.ID,ID("iProv1"));
			Assert.IsTrue( mappings.Length == 2 );
			Assert.IsTrue( Array.IndexOf( mappings, pm1 ) >= 0 );
			Assert.IsTrue( Array.IndexOf( mappings, pm2 ) >= 0 );
			oComp.GetProvidesMappingsByInner(iComp1.ID, ID("missing"));
		}

		[ExpectedException(typeof(RoleIDNotFoundException))]
		[Test] public void GetRequiresByInner()
		{
			Assert.AreEqual( rm1, oComp.GetRequiresMappingByInner(iComp1.ID, ID("iReq1")) );
			Assert.AreEqual( rm2, oComp.GetRequiresMappingByInner(iComp2.ID, ID("iReq1")) );
			oComp.GetRequiresMappingByInner(iComp3.ID, ID("missing"));
		}

		[ExpectedException(typeof(ComponentNotFoundException))]
		[Test] public void GetBindingByRequires()
		{
			Assert.AreEqual( b1, oComp.GetBindingByRequires(iComp1.ID, iComp1.GetRequiresRoleByInterfaceID(iReq2.ID).ID) );
			oComp.GetBindingByRequires(null,ID("missing"));
		}

		[ExpectedException(typeof(RoleIDNotFoundException))]
		[Test] public void GetBindingByProvides()
		{
			Assert.AreEqual( b1, oComp.GetBindingsByProvides(iComp2.ID, iComp2.GetProvidesRoleByInterfaceID(iProv2.ID).ID)[0] );
			oComp.GetBindingsByProvides(iComp3.ID,ID("missing"));
		}

		[Test] public void TestBinding()
		{
			IBinding b2 = ComponentFactory.CreateBinding(iComp1, iComp1.GetRequiresRoleByInterfaceID(iReq2.ID).ID, iComp2, iComp2.GetProvidesRoleByInterfaceID(iProv2.ID).ID);
			Assert.IsTrue(b1.Equals(b2));
			IBinding b3 = ComponentFactory.CreateBinding(iComp1, iComp1.GetRequiresRoleByInterfaceID(iReq1.ID).ID, iComp2, iComp2.GetProvidesRoleByInterfaceID(iProv2.ID).ID);
			Assert.IsFalse(b1.Equals(b3));
			IBinding b4 = ComponentFactory.CreateBinding(iComp1, iComp1.GetRequiresRoleByInterfaceID(iReq2.ID).ID, iComp1, iComp1.GetProvidesRoleByInterfaceID(iProv1.ID).ID);
			Assert.IsFalse(b1.Equals(b4));

			DefaultBinding b5 = (DefaultBinding)b1.Clone();
			b5.ProvidingRole = new DefaultRole(iComp1, iProv1);
			Assert.IsFalse(b5.Equals(b1));
		}



		[ExpectedException(typeof(NullNotAllowedException))]
		[Test] public void AddNullComponent()
		{
			oComp.AddComponents(null);
		}

		[Test] public void HasConnections()
		{
			Assert.IsFalse( oComp.HasIncomingConnections ( iComp3.ID ) );
			Assert.IsFalse( oComp.HasOutgoingConnections ( iComp3.ID ) );

			Assert.IsTrue( oComp.HasIncomingConnections( iComp1.ID ) );
			Assert.IsTrue( oComp.HasOutgoingConnections( iComp1.ID ) );

		}

		[ExpectedException(typeof(ComponentNotFoundException))]
		[Test] public void GetConnections()
		{
			Assert.AreEqual( b1, oComp.GetRequiresBindings(iComp1.ID)[0] );
			Assert.AreEqual( b1, oComp.GetProvidesBindings(iComp2.ID)[0] );
			Assert.AreEqual( 1, oComp.GetRequiresBindings(iComp1.ID).Length );
			Assert.AreEqual( 1, oComp.GetProvidesBindings(iComp2.ID).Length );
			IMapping[] provMappings = oComp.GetProvidesMappings(iComp1.ID);
			Assert.AreEqual( 2, provMappings.Length );
			Assert.IsTrue( Array.IndexOf( provMappings, pm1 ) >= 0);
			Assert.IsTrue( Array.IndexOf( provMappings, pm2 ) >= 0);
			Assert.AreEqual( 0, oComp.GetRequiresMappings(iComp3.ID).Length );
			IMapping[] reqMappings = oComp.GetRequiresMappings(iComp2.ID);
			Assert.AreEqual(1, reqMappings.Length);
			Assert.AreEqual(rm2, reqMappings[0]);
			oComp.GetRequiresBindings(null);
		}

		[Test] public void Equals()
		{
			Assert.IsTrue( oComp.Equals( oCompCopy ) );
			ICompositeComponent clone = (ICompositeComponent)oCompCopy.Clone();
			clone.DeleteBindings(b1);
			Assert.IsFalse( oComp.Equals( clone ) );
			Assert.IsFalse( oComp.Equals(null));
		}

		[Test] public void Clone()
		{
			ICompositeComponent clone = (ICompositeComponent)oComp.Clone();
			Assert.IsTrue(clone.Equals(oComp));
			clone.DeleteBindings(b1);
			Assert.IsFalse( oComp.Equals( clone ) );
		}

		[ExpectedException(typeof(ConnectionNotFoundException))]
		[Test] public void DeleteBinding()
		{
			ICompositeComponent clone = (ICompositeComponent)oComp.Clone();
			clone.DeleteBindings(b1);
			Assert.IsTrue( clone.Bindings.Length == 0 );
			Assert.IsTrue( clone.GetBindingByRequires(b1.RequiringRole) == null );
			Assert.IsTrue( clone.GetBindingsByProvides(b1.ProvidingRole).Length == 0 );
			clone.DeleteBindings(b1);
		}

		[ExpectedException(typeof(ConnectionNotFoundException))]
		[Test] public void DeleteProvidesMapping()
		{
			ICompositeComponent clone = (ICompositeComponent)oComp.Clone();
			clone.DeleteProvidesMappings(pm1);
			Assert.IsTrue( clone.ProvidesMappings.Length == 1 );
			Assert.AreEqual( 1, clone.GetProvidesMappingsByInner(pm1.InnerRole).Length);
			Assert.IsTrue( clone.GetProvidesMappingByOuter(pm1.OuterRole.ID) == null );
			clone.DeleteProvidesMappings(pm1);
		}

		[ExpectedException(typeof(ConnectionNotFoundException))]
		[Test] public void DeleteRequiresMapping()
		{
			ICompositeComponent clone = (ICompositeComponent)oComp.Clone();
			clone.DeleteRequiresMappings(rm1);
			Assert.IsTrue( clone.RequiresMappings.Length == 1 );
			Assert.AreEqual( 1, clone.GetRequiresMappingsByOuter(rm1.OuterRole.ID).Length);
			Assert.IsTrue( clone.GetRequiresMappingByInner(rm1.InnerRole) == null );
			clone.DeleteRequiresMappings(rm1);
		}

		[ExpectedException(typeof(ComponentHasIncomingConnectionsException))]
		[Test] public void DeleteComponent()
		{
			ICompositeComponent clone = (ICompositeComponent)oComp.Clone();
			clone.DeleteComponents(iComp3.ID);
			Assert.AreEqual(2, clone.Components.Length);
			Assert.IsTrue( clone.ContainsComponent(iComp1.ID) );
			Assert.IsTrue( clone.ContainsComponent(iComp2.ID) );
			Assert.IsFalse( clone.ContainsComponent(iComp3.ID) );
			clone.DeleteComponents(null);
			clone.DeleteComponents(null,null);
			clone.DeleteComponents(iComp3.ID);
			clone.DeleteComponents(iComp2.ID);
		}

		[Test] public void SerializeComponent()
		{
			ModelPersistencyService.Instance.SaveEntity(oComp.ID, "test.xml");
	
			ModelPersistencyService.Instance.ClearEntityTable();


			ICompositeComponent loadedComp = ModelPersistencyService.Instance.LoadCompositeComponent("test.xml");
	
			ModelPersistencyService.Instance.SaveEntity(loadedComp.ID, "test2.xml");
			Assert.AreEqual(loadedComp, oComp);
		}


//		[Test] public void Visitor()
//		{
//			BasicComponentVisitor v = new BasicComponentVisitor(oComp);
//			v.Start();
//			Assert.IsTrue( v.VisitedComponents.Length == 2 );
//			Assert.IsTrue( Array.IndexOf(v.VisitedComponents, iComp1) >= 0);
//			Assert.IsTrue( Array.IndexOf(v.VisitedComponents, iComp2) >= 0);
//		}
//
//
		private void CreateIComp1()
		{
			iComp1 = ComponentFactory.CreateBasicComponent("iComp1");
			iSigProv1 = ComponentFactory.CreateSignatureList("d1", "d2" );
			iSigReq1 = ComponentFactory.CreateSignatureList("e1", "e2" );
			iSigReq2 = ComponentFactory.CreateSignatureList("d3", "d4" );
			iProv1 = ComponentFactory.CreateInterfaceModel(iSigProv1, "iProv1", IdentifiableFactory.CreateGUID() as GloballyUniqueIdentifier, ModelPersistencyInfo.ATTACHED);
			iReq1 = ComponentFactory.CreateInterfaceModel(iSigReq1, "iReq1", IdentifiableFactory.CreateGUID() as GloballyUniqueIdentifier, ModelPersistencyInfo.ATTACHED);
			iReq2 = ComponentFactory.CreateInterfaceModel(iSigReq2, "iReq2", IdentifiableFactory.CreateGUID() as GloballyUniqueIdentifier, ModelPersistencyInfo.ATTACHED);
			iComp1.AddProvidesInterface(iProv1);
			iComp1.AddRequiresInterface(iReq1);
			iComp1.AddRequiresInterface(iReq2);

			ISignature sig = ComponentFactory.CreateSignature(System.Type.GetType("System.Int32"),"someMethod",
				ComponentFactory.CreateParameter(ComponentFactory.CreateType("System.String"),"param"));

			IInterfaceModel iReqX = ComponentFactory.CreateInterfaceModel("iReqX");
			iReqX.SignatureList.AddSignatures(sig);
			iComp1.AddRequiresInterface(iReqX);

			d1se = ComponentFactory.CreateServiceEffectSpecification();
			d1se.RequiredServicesList.AddServices(ComponentFactory.CreateServiceArray(iReq1, iSigReq1[0].ID, iSigReq1[1].ID));
			d1se.RequiredServicesList.AddServices(ComponentFactory.CreateServiceArray(iReqX,sig.ID));

			d2se = ComponentFactory.CreateServiceEffectSpecification();
			d2se.RequiredServicesList.AddServices(ComponentFactory.CreateServiceArray(iReq1,iSigReq1[0].ID));
			d2se.RequiredServicesList.AddServices(ComponentFactory.CreateServiceArray(iReq2,iSigReq2[0].ID, iSigReq2[1].ID));

			iComp1.AddServiceEffectSpecification(ComponentFactory.CreateService(iProv1,iSigProv1[0].ID),d1se);
			iComp1.AddServiceEffectSpecification(ComponentFactory.CreateService(iProv1,iSigProv1[1].ID),d2se);
		}

		private void CreateIComp2()
		{
			iComp2 = ComponentFactory.CreateBasicComponent("iComp2");
			iSigProv2 = ComponentFactory.CreateSignatureList("d3", "d4", "d5" );
			iProv2 = ComponentFactory.CreateInterfaceModel(iSigProv2, "iProv2", IdentifiableFactory.CreateGUID() as GloballyUniqueIdentifier, ModelPersistencyInfo.ATTACHED);
			d3se = ComponentFactory.CreateServiceEffectSpecification();
			d4se = ComponentFactory.CreateServiceEffectSpecification();
			d4se.RequiredServicesList.AddServices(ComponentFactory.CreateServiceArray(iReq1,iSigReq1[0].ID,iSigReq1[1].ID));
			d5se = ComponentFactory.CreateServiceEffectSpecification();
			iComp2.AddRequiresInterface(iReq1);							 
			iComp2.AddProvidesInterface(iProv2);
			iComp2.AddServiceEffectSpecification(ComponentFactory.CreateService(iProv2,iSigProv2[0].ID),d3se);
			iComp2.AddServiceEffectSpecification(ComponentFactory.CreateService(iProv2,iSigProv2[1].ID),d4se);
			iComp2.AddServiceEffectSpecification(ComponentFactory.CreateService(iProv2,iSigProv2[2].ID),d5se);
		}

		private void CreateIComp3()
		{
			iComp3 = ComponentFactory.CreateBasicComponent("iComp3");
			iComp3.AddRequiresInterface(iReq1);
			iComp3.AddRequiresInterface(iReq2);
			iComp3.AddProvidesInterface(iProv1);
		}

		private void CreateOComp()
		{
			oSigProv1 = ComponentFactory.CreateSignatureList("d1");
			oSigProv2 = ComponentFactory.CreateSignatureList("d2");
			oProv1 = ComponentFactory.CreateInterfaceModel(oSigProv1, "oProv1");
			oProv2 = ComponentFactory.CreateInterfaceModel(oSigProv2, "oProv1");

			oComp = ComponentFactory.CreateCompositeComponent("oComp");
			oCompCopy = ComponentFactory.CreateCompositeComponent("oComp");
			oComp.AddComponents(iComp1, iComp2, iComp3);

			oCompCopy.AddComponents( iComp1, iComp2, iComp3 );
			
			oComp.AddProvidesInterface(oProv1);
			oComp.AddProvidesInterface(oProv2);
			oCompCopy.AddProvidesInterface((IInterfaceModel)oProv1.Clone());
			oCompCopy.AddProvidesInterface((IInterfaceModel)oProv2.Clone());
			oComp.AddRequiresInterface(iReq1);
			oCompCopy.AddRequiresInterface((IInterfaceModel)iReq1.Clone());

			pm1 = ComponentFactory.CreateProvidesMapping(oComp, oComp.GetProvidesRoleByInterfaceID(oProv1.ID).ID, iComp1, iComp1.GetProvidesRoleByInterfaceID(iProv1.ID).ID);
			pm2 = ComponentFactory.CreateProvidesMapping(oComp, oComp.GetProvidesRoleByInterfaceID(oProv2.ID).ID, iComp1, iComp1.GetProvidesRoleByInterfaceID(iProv1.ID).ID);

			oComp.AddProvidesMappings(pm1,pm2);
			oCompCopy.AddProvidesMappings(
				ComponentFactory.CreateProvidesMapping(oCompCopy, oCompCopy.GetProvidesRoleByInterfaceID(oProv1.ID).ID, iComp1, iComp1.GetProvidesRoleByInterfaceID(iProv1.ID).ID), 
				ComponentFactory.CreateProvidesMapping(oCompCopy, oCompCopy.GetProvidesRoleByInterfaceID(oProv2.ID).ID, iComp1, iComp1.GetProvidesRoleByInterfaceID(iProv1.ID).ID));

			rm1 = ComponentFactory.CreateRequiresMapping(iComp1, iComp1.GetRequiresRoleByInterfaceID(iReq1.ID).ID, oComp, oComp.GetRequiresRoleByInterfaceID(iReq1.ID).ID);
			rm2 = ComponentFactory.CreateRequiresMapping(iComp2, iComp2.GetRequiresRoleByInterfaceID(iReq1.ID).ID, oComp, oComp.GetRequiresRoleByInterfaceID(iReq1.ID).ID);
			oComp.AddRequiresMappings(rm1,rm2);
			oCompCopy.AddRequiresMappings( 
				ComponentFactory.CreateRequiresMapping(iComp1, iComp1.GetRequiresRoleByInterfaceID(iReq1.ID).ID, oCompCopy, oCompCopy.GetRequiresRoleByInterfaceID(iReq1.ID).ID), 
				ComponentFactory.CreateRequiresMapping(iComp2, iComp2.GetRequiresRoleByInterfaceID(iReq1.ID).ID, oCompCopy, oCompCopy.GetRequiresRoleByInterfaceID(iReq1.ID).ID) );

			b1 = ComponentFactory.CreateBinding(iComp1, iComp1.GetRequiresRoleByInterfaceID(iReq2.ID).ID, iComp2, iComp2.GetProvidesRoleByInterfaceID(iProv2.ID).ID);
			oComp.AddBindings(b1);
			oCompCopy.AddBindings(b1);
		}

		private IIdentifier ID(string aID)
		{
			return IdentifiableFactory.CreateStringID(aID);
		}

//		private IService SigRole(string role,ISignature sig)
//		{
//			return ComponentFactory.CreateService(role,sig);
//		}

	}
}
#endif
