#if TEST

using System;
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
			Assert.AreEqual( b1, oComp.GetBindingByRequires(iComp1.ID,ID("iReq2")) );
			oComp.GetBindingByRequires(null,ID("missing"));
		}

//		[ExpectedException(typeof(InvalidAttachedRoleException))]
		[Test] public void GetBindingByProvides()
		{
			Assert.AreEqual( b1, oComp.GetBindingsByProvides(iComp2.ID,ID("iProv2"))[0] );
//			oComp.GetBindingsByProvides(iComp3.ID,null);
		}

		[Test] public void TestBinding()
		{
			IBinding b2 = ComponentFactory.CreateBinding(iComp1,ID("iReq2"), iComp2,ID("iProv2"));
			Assert.IsTrue(b1.Equals(b2));
			IBinding b3 = ComponentFactory.CreateBinding(iComp1,ID("iReq1"), iComp2,ID("iProv2"));
			Assert.IsFalse(b1.Equals(b3));
			IBinding b4 = ComponentFactory.CreateBinding(iComp1,ID("iReq2"), iComp1,ID("iProv1"));
			Assert.IsFalse(b1.Equals(b4));

			DefaultBinding b5 = (DefaultBinding)b1.Clone();
			b5.ProvidingRole = new DefaultAttachedRole(iComp1, ID("iProv1"));
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
			Assert.IsTrue( clone.GetProvidesMappingByOuter(pm1.OuterRole.RoleID) == null );
			clone.DeleteProvidesMappings(pm1);
		}

		[ExpectedException(typeof(ConnectionNotFoundException))]
		[Test] public void DeleteRequiresMapping()
		{
			ICompositeComponent clone = (ICompositeComponent)oComp.Clone();
			clone.DeleteRequiresMappings(rm1);
			Assert.IsTrue( clone.RequiresMappings.Length == 1 );
			Assert.AreEqual( 1, clone.GetRequiresMappingsByOuter(rm1.OuterRole.RoleID).Length);
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
			iProv1 = ComponentFactory.CreateInterfaceModel(iSigProv1);
			iReq1 = ComponentFactory.CreateInterfaceModel(iSigReq1);
			iReq2 = ComponentFactory.CreateInterfaceModel(iSigReq2);
			iComp1.AddProvidesInterface(ID("iProv1"),iProv1);
			iComp1.AddRequiresInterface(ID("iReq1"),iReq1);
			iComp1.AddRequiresInterface(ID("iReq2"),iReq2);

			d1se = ComponentFactory.CreateServiceEffectSpecification();
			d1se.SignatureList.AddSignatures(ComponentFactory.CreateExternalSignatureArray("iReq1",iSigReq1[0], iSigReq1[1]));

			d2se = ComponentFactory.CreateServiceEffectSpecification();
			d2se.SignatureList.AddSignatures(ComponentFactory.CreateExternalSignatureArray("iReq1",iSigReq1[0]));
			d2se.SignatureList.AddSignatures(ComponentFactory.CreateExternalSignatureArray("iReq2",iSigReq2[0], iSigReq2[1]));

			iComp1.AddServiceEffectSpecification(SigRole("iProv1",iSigProv1[0]),d1se);
			iComp1.AddServiceEffectSpecification(SigRole("iProv1",iSigProv1[1]),d2se);
		}

		private void CreateIComp2()
		{
			iComp2 = ComponentFactory.CreateBasicComponent("iComp2");
			iSigProv2 = ComponentFactory.CreateSignatureList("d3", "d4", "d5" );
			iProv2 = ComponentFactory.CreateInterfaceModel(iSigProv2);
			d3se = ComponentFactory.CreateServiceEffectSpecification();
			d4se = ComponentFactory.CreateServiceEffectSpecification();
			d4se.SignatureList.AddSignatures(ComponentFactory.CreateExternalSignatureArray("iReq1",iSigReq1[0],iSigReq1[1]));
			d5se = ComponentFactory.CreateServiceEffectSpecification();
			iComp2.AddRequiresInterface(ID("iReq1"),iReq1);							 
			iComp2.AddProvidesInterface(ID("iProv2"),iProv2);
			iComp2.AddServiceEffectSpecification(SigRole("iProv2",iSigProv2[0]),d3se);
			iComp2.AddServiceEffectSpecification(SigRole("iProv2",iSigProv2[1]),d4se);
			iComp2.AddServiceEffectSpecification(SigRole("iProv2",iSigProv2[2]),d5se);
		}

		private void CreateIComp3()
		{
			iComp3 = ComponentFactory.CreateBasicComponent("iComp3");
			iComp3.AddRequiresInterface(ID("iReq1a"),iReq1);
			iComp3.AddRequiresInterface(ID("iReq2a"),iReq2);
			iComp1.AddProvidesInterface(ID("iProv1a"),iProv1);
		}

		private void CreateOComp()
		{
			oSigProv1 = ComponentFactory.CreateSignatureList("d1");
			oSigProv2 = ComponentFactory.CreateSignatureList("d2");
			oProv1 = ComponentFactory.CreateInterfaceModel(oSigProv1);
			oProv2 = ComponentFactory.CreateInterfaceModel(oSigProv2);

			oComp = ComponentFactory.CreateCompositeComponent("oComp");
			oCompCopy = ComponentFactory.CreateCompositeComponent("oComp");
			oComp.AddComponents(iComp1, iComp2, iComp3);

			oCompCopy.AddComponents( iComp1, iComp2, iComp3 );
			
			oComp.AddProvidesInterface(ID("oProv1"),oProv1);
			oComp.AddProvidesInterface(ID("oProv2"),oProv2);
			oCompCopy.AddProvidesInterface( ID("oProv1"), (IInterfaceModel)oProv1.Clone());
			oCompCopy.AddProvidesInterface( ID("oProv2"), (IInterfaceModel)oProv2.Clone());
			oComp.AddRequiresInterface(ID("oReq1"),iReq1);
			oCompCopy.AddRequiresInterface(ID("oReq1"), (IInterfaceModel)iReq1.Clone());

			pm1 = ComponentFactory.CreateProvidesMapping(oComp, ID("oProv1"), iComp1, ID("iProv1"));
			pm2 = ComponentFactory.CreateProvidesMapping(oComp, ID("oProv2"), iComp1, ID("iProv1"));

			oComp.AddProvidesMappings(pm1,pm2);
			oCompCopy.AddProvidesMappings(ComponentFactory.CreateProvidesMapping(oCompCopy, ID("oProv1"), iComp1, ID("iProv1")), ComponentFactory.CreateProvidesMapping(oCompCopy, ID("oProv2"), iComp1, ID("iProv1")));

			rm1 = ComponentFactory.CreateRequiresMapping(iComp1, ID("iReq1"), oComp, ID("oReq1"));
			rm2 = ComponentFactory.CreateRequiresMapping(iComp2, ID("iReq1"), oComp, ID("oReq1"));
			oComp.AddRequiresMappings(rm1,rm2);
			oCompCopy.AddRequiresMappings( ComponentFactory.CreateRequiresMapping(iComp1, ID("iReq1"), oCompCopy, ID("oReq1")), ComponentFactory.CreateRequiresMapping(iComp2, ID("iReq1"), oCompCopy, ID("oReq1")) );

			b1 = ComponentFactory.CreateBinding(iComp1,ID("iReq2"),iComp2,ID("iProv2"));
			oComp.AddBindings(b1);
			oCompCopy.AddBindings(b1);
		}

		private IIdentifier ID(string aID)
		{
			return IdentifiableFactory.CreateStringID(aID);
		}

		private IExternalSignature SigRole(string role,ISignature sig)
		{
			return ComponentFactory.CreateExternalSignature(role,sig);
		}

	}
}
#endif
