#if TEST

using System;
using NUnit.Framework;
using Palladio.ComponentModel.Exceptions;
using System.Collections;
using Palladio.ComponentModel.Connections;
using Palladio.ComponentModel.Visitors;

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
	/// Revision 1.1  2004/05/23 16:03:56  sliver
	/// completed unit tests
	///
	/// </pre>
	/// </remarks>
	[TestFixture]
	public class CompositeComponentTest
	{

		ISignatureList oProv1, oProv2, iProv1, iProv2;
		ISignatureList iReq1, iReq2, oReq1;
		ISignatureList d1se, d2se, d3se, d4se, d5se;
		IBasicComponent iComp1, iComp2, iComp3;
		ICompositeComponent oComp, oCompCopy;
		IServiceEffectMapping d1map, d2map;
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

		[Test] public void ContainsComponents()
		{
			Assert.IsTrue( oComp.ContainsComponent(iComp1) );
			Assert.IsTrue( oComp.ContainsComponent(iComp2) );
			Assert.IsTrue( oComp.ContainsComponent(iComp3) );
			Assert.IsTrue( oComp.Components.Length == 3 );
			Assert.IsFalse(oComp.ContainsComponent( 
				ComponentFactory.CreateBasicComponent() ) );
			Assert.IsFalse( oComp.ContainsComponent(null) );
		}

		[Test] public void ContainsInterfaces()
		{
			Assert.IsTrue( oComp.HasProvidesInterface("oProv1") );
			Assert.IsTrue( oComp.HasProvidesInterface("oProv2") );
			Assert.IsTrue( oComp.ProvidesInterfaces.Length == 2 );
			Assert.IsFalse( oComp.HasProvidesInterface("missing") );
			Assert.IsFalse( oComp.HasProvidesInterface(null) );

			Assert.IsTrue( oComp.HasRequiresInterface("oReq1") );
			Assert.IsTrue( oComp.RequiresInterfaces.Length == 1 );
			Assert.IsFalse( oComp.HasRequiresInterface("missing") );
			Assert.IsFalse( oComp.HasRequiresInterface(null) );
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
			Assert.AreEqual( pm1, oComp.GetProvidesMappingByOuter("oProv1") );
			Assert.AreEqual( pm2, oComp.GetProvidesMappingByOuter("oProv2") );
			oComp.GetProvidesMappingByOuter("missing");
		}

		[ExpectedException(typeof(InvalidAttachedInterfaceException))]
		[Test] public void GetGetProvidesByInner()
		{
			IMapping[] mappings = oComp.GetProvidesMappingsByInner(iComp1,"iProv1");
			Assert.IsTrue( mappings.Length == 2 );
			Assert.IsTrue( Array.IndexOf( mappings, pm1 ) >= 0 );
			Assert.IsTrue( Array.IndexOf( mappings, pm2 ) >= 0 );
			oComp.GetProvidesMappingsByInner(iComp1, "missing");
		}

		[ExpectedException(typeof(RoleIDNotFoundException))]
		[Test] public void GetRequiresByOuter()
		{
			IMapping[] mappings = oComp.GetRequiresMappingsByOuter("oReq1");
			Assert.IsTrue( mappings.Length == 2 );
			Assert.IsTrue( Array.IndexOf(mappings, rm1) >= 0 );
			Assert.IsTrue( Array.IndexOf(mappings, rm2) >= 0 );
			oComp.GetRequiresMappingsByOuter("missing");
		}

		[ExpectedException(typeof(InvalidAttachedInterfaceException))]
		[Test] public void GetRequiresByInner()
		{
			Assert.AreEqual( rm1, oComp.GetRequiresMappingByInner(iComp1, "iReq1") );
			Assert.AreEqual( rm2, oComp.GetRequiresMappingByInner(iComp2, "iReq1") );
			oComp.GetRequiresMappingByInner(iComp3, "missing");
		}

		[ExpectedException(typeof(InvalidAttachedInterfaceException))]
		[Test] public void GetBindingByRequires()
		{
			Assert.AreEqual( b1, oComp.GetBindingByRequires(iComp1,"iReq2") );
			oComp.GetBindingByRequires(null,"missing");
		}

		[ExpectedException(typeof(InvalidAttachedInterfaceException))]
		[Test] public void GetBindingByProvides()
		{
			Assert.AreEqual( b1, oComp.GetBindingsByProvides(iComp2,"iProv2")[0] );
			oComp.GetBindingsByProvides(iComp3,null);
		}

		[Test] public void TestBinding()
		{
			IBinding b2 = ComponentFactory.CreateBinding(iComp2,"iProv2",iComp1,"iReq2");
			Assert.IsTrue(b1.Equals(b2));
			IBinding b3 = ComponentFactory.CreateBinding(iComp2,"iProv2",iComp1,"iReq1");
			Assert.IsFalse(b1.Equals(b3));
			IBinding b4 = ComponentFactory.CreateBinding(iComp1,"iProv2",iComp1,"iReq2");
			Assert.IsFalse(b1.Equals(b4));

			Binding b5 = (Binding)b1.Clone();
			b5.ProvidesInterface = new AttachedInterface("role",iComp1);
			Assert.IsFalse(b5.Equals(b1));
		}



		[ExpectedException(typeof(NullNotAllowedException))]
		[Test] public void AddNullComponent()
		{
			oComp.AddComponents(null);
		}

		[Test] public void HasConnections()
		{
			Assert.IsFalse( oComp.HasIncomingConnections ( iComp3 ) );
			Assert.IsFalse( oComp.HasOutgoingConnections ( iComp3 ) );

			Assert.IsTrue( oComp.HasIncomingConnections( iComp1 ) );
			Assert.IsTrue( oComp.HasOutgoingConnections( iComp1 ) );

		}

		[ExpectedException(typeof(ComponentNotFoundException))]
		[Test] public void GetConnections()
		{
			Assert.AreEqual( b1, oComp.GetOutgoingBindings(iComp1)[0] );
			Assert.AreEqual( b1, oComp.GetIncomingBindings(iComp2)[0] );
			Assert.AreEqual( 1, oComp.GetOutgoingBindings(iComp1).Length );
			Assert.AreEqual( 1, oComp.GetIncomingBindings(iComp2).Length );
			IMapping[] provMappings = oComp.GetIncomingMappings(iComp1);
			Assert.AreEqual( 2, provMappings.Length );
			Assert.IsTrue( Array.IndexOf( provMappings, pm1 ) >= 0);
			Assert.IsTrue( Array.IndexOf( provMappings, pm2 ) >= 0);
			Assert.AreEqual( 0, oComp.GetOutgoingMappings(iComp3).Length );
			IMapping[] reqMappings = oComp.GetOutgoingMappings(iComp2);
			Assert.AreEqual(1, reqMappings.Length);
			Assert.AreEqual(rm2, reqMappings[0]);
			oComp.GetOutgoingBindings(null);
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

		[Test] public void DeleteBinding()
		{
			ICompositeComponent clone = (ICompositeComponent)oComp.Clone();
			clone.DeleteBindings(b1);
			Assert.IsTrue( clone.Bindings.Length == 0 );
			Assert.IsTrue( clone.GetBindingByRequires(b1.RequiresInterface) == null );
			Assert.IsTrue( clone.GetBindingsByProvides(b1.ProvidesInterface).Length == 0 );
			clone.DeleteBindings(b1);
		}

		[Test] public void DeleteProvidesMapping()
		{
			ICompositeComponent clone = (ICompositeComponent)oComp.Clone();
			clone.DeleteProvidesMappings(pm1);
			Assert.IsTrue( clone.ProvidesMappings.Length == 1 );
			Assert.AreEqual( 1, clone.GetProvidesMappingsByInner(pm1.InnerInterface).Length);
			Assert.IsTrue( clone.GetProvidesMappingByOuter(pm1.OuterRoleID) == null );
			clone.DeleteProvidesMappings(pm1);
		}

		[Test] public void DeleteRequiresMapping()
		{
			ICompositeComponent clone = (ICompositeComponent)oComp.Clone();
			clone.DeleteRequiresMappings(rm1);
			Assert.IsTrue( clone.RequiresMappings.Length == 1 );
			Assert.AreEqual( 1, clone.GetRequiresMappingsByOuter(rm1.OuterRoleID).Length);
			Assert.IsTrue( clone.GetRequiresMappingByInner(rm1.InnerInterface) == null );
			clone.DeleteRequiresMappings(rm1);
		}

		[ExpectedException(typeof(ComponentHasIncomingConnectionsException))]
		[Test] public void DeleteComponent()
		{
			ICompositeComponent clone = (ICompositeComponent)oComp.Clone();
			clone.DeleteComponents(iComp3);
			Assert.AreEqual(2, clone.Components.Length);
			Assert.IsTrue( clone.ContainsComponent(iComp1) );
			Assert.IsTrue( clone.ContainsComponent(iComp2) );
			Assert.IsFalse( clone.ContainsComponent(iComp3) );
			clone.DeleteComponents(null);
			clone.DeleteComponents(null,null);
			clone.DeleteComponents(iComp3);
			clone.DeleteComponents(iComp2);
		}


		[Test] public void Visitor()
		{
			BasicComponentVisitor v = new BasicComponentVisitor(oComp);
			v.Start();
			Assert.IsTrue( v.VisitedComponents.Length == 2 );
			Assert.IsTrue( Array.IndexOf(v.VisitedComponents, iComp1) >= 0);
			Assert.IsTrue( Array.IndexOf(v.VisitedComponents, iComp2) >= 0);
		}


		private void CreateIComp1()
		{
			iComp1 = ComponentFactory.CreateBasicComponent();
			iProv1 = ComponentFactory.CreateSignatureListInterface("iProv1", "d1", "d2" );
			iReq1 = ComponentFactory.CreateSignatureListInterface("iReq1", "e1", "e2" );
			iReq2 = ComponentFactory.CreateSignatureListInterface("iReq2", "d3", "d4" );
			d1se = ComponentFactory.CreateSignatureListServiceEffect(iReq1[0],iReq1[1]);
			d2se = ComponentFactory.CreateSignatureListServiceEffect(iReq1[0],iReq2[0],iReq2[1]);
			d1map = ComponentFactory.CreateServiceEffectMapping(iProv1[0], d1se );
			d2map = ComponentFactory.CreateServiceEffectMapping(iProv1[1], d2se );
			iComp1.AddRequiresInterfaces(iReq1, iReq2);
			iComp1.AddProvidesInterface(iProv1,d1map,d2map);
		}

		private void CreateIComp2()
		{
			iComp2 = ComponentFactory.CreateBasicComponent();
			iProv2 = ComponentFactory.CreateSignatureListInterface("iProv2", "d3", "d4", "d5" );
			d3se = ComponentFactory.CreateSignatureListServiceEffect();
			d4se = ComponentFactory.CreateSignatureListServiceEffect(iReq1[0],iReq1[1]);
			d5se = ComponentFactory.CreateSignatureListServiceEffect();
			IServiceEffectMapping d3map = ComponentFactory.CreateServiceEffectMapping(iProv2[0], d3se );
			IServiceEffectMapping d4map = ComponentFactory.CreateServiceEffectMapping(iProv2[1], d4se );
			IServiceEffectMapping d5map = ComponentFactory.CreateServiceEffectMapping(iProv2[2], d5se );
			iComp2.AddRequiresInterfaces(iReq1);							 
			iComp2.AddProvidesInterface(iProv2,d3map,d4map, d5map);
		}

		private void CreateIComp3()
		{
			iComp3 = ComponentFactory.CreateBasicComponent();
			iComp3.AddRequiresInterfaces(ComponentFactory.CreateSignatureListInterface("iReq1","e1","e2", "e3" ), (ISignatureList) iReq2.Clone());
			iComp3.AddProvidesInterface( (ISignatureList) iProv1.Clone(), (IServiceEffectMapping) d1map.Clone(), (IServiceEffectMapping) d2map.Clone());
		}

		private void CreateOComp()
		{
			oProv1 = ComponentFactory.CreateSignatureListInterface("oProv1", "d1" );
			oProv2 = ComponentFactory.CreateSignatureListInterface("oProv2", "d2" );
			oReq1 = ComponentFactory.CreateSignatureListInterface("oReq1", "e1", "e2" );

			oComp = ComponentFactory.CreateCompositeComponent();
			oCompCopy = ComponentFactory.CreateCompositeComponent();
			oComp.AddComponents(iComp1,iComp2,iComp3);
			oCompCopy.AddComponents( (IComponent)iComp1.Clone(), (IComponent)iComp2.Clone(), (IComponent)iComp3.Clone() );
			
			oComp.AddProvidesInterfaces(oProv1,oProv2);
			oCompCopy.AddProvidesInterfaces( (ISignatureList)oProv1.Clone(), (ISignatureList)oProv2.Clone() );
			oComp.AddRequiresInterfaces(oReq1);
			oCompCopy.AddRequiresInterfaces((ISignatureList)oReq1.Clone());


			pm1 = ComponentFactory.CreateMapping("oProv1",iComp1, "iProv1");
			pm2 = ComponentFactory.CreateMapping("oProv2",iComp1, "iProv1");
			oComp.AddProvidesMappings(pm1,pm2);
			oCompCopy.AddProvidesMappings((IMapping)pm1.Clone(), (IMapping)pm2.Clone());



			rm1 = ComponentFactory.CreateMapping("oReq1",iComp1, "iReq1");
			rm2 = ComponentFactory.CreateMapping("oReq1",iComp2, "iReq1");
			oComp.AddRequiresMappings(rm1,rm2);
			oCompCopy.AddRequiresMappings( (IMapping)rm1.Clone(), (IMapping)rm2.Clone() );

			b1 = ComponentFactory.CreateBinding(iComp2,"iProv2",iComp1,"iReq2");
			oComp.AddBindings(b1);
			oCompCopy.AddBindings((IBinding)b1.Clone());
		}
	}
}
#endif
