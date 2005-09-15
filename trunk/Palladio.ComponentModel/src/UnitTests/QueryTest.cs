using System;
using NUnit.Framework;
using Palladio.ComponentModel.Builder;
using Palladio.ComponentModel.Builder.TypeLevelBuilder;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelEntities;
using Palladio.ComponentModel.Query;
using Palladio.ComponentModel.Query.TypeLevel;
using Palladio.Identifier;
#if TEST

namespace Palladio.ComponentModel.UnitTests
{
	[TestFixture]
	public class QueryTest
	{
		private ComponentModelEnvironment model;

		public QueryTest()
		{
		}

		[SetUp]
		public void Init()
		{
			model = new ComponentModelEnvironment();	
		}

		[Test]
		public void QueryEntities()
		{
			StaticComponentModel.Create(model);
			IQueryRepository query = model.Query.QueryRepository;
			Assert.IsTrue(query.ContainsEntity(StaticComponentModel.BCWRITEBEID));
			Assert.IsTrue(query.ContainsEntity(StaticComponentModel.CCWRITEID));
			Assert.IsTrue(query.ContainsEntity(StaticComponentModel.BCWRITEID));
			Assert.IsTrue(query.ContainsEntity(StaticComponentModel.IWRITERBEID));
			Assert.IsTrue(query.ContainsEntity(StaticComponentModel.IWRITERID));

			Assert.AreEqual(StaticComponentModel.BCWRITEBEID,query.GetComponent(StaticComponentModel.BCWRITEBEID).ComponentID);
			Assert.AreEqual(StaticComponentModel.CCWRITEID,query.GetComponent(StaticComponentModel.CCWRITEID).ComponentID);
			Assert.AreEqual(StaticComponentModel.BCWRITEID,query.GetComponent(StaticComponentModel.BCWRITEID).ComponentID);
			Assert.AreEqual(StaticComponentModel.IWRITERID,query.GetInterface(StaticComponentModel.IWRITERID).InterfaceID);
			Assert.AreEqual(StaticComponentModel.IWRITERBEID,query.GetInterface(StaticComponentModel.IWRITERBEID).InterfaceID);
		}

		[Test]
		public void QueryComponentTest()
		{
			StaticComponentModel.Create(model);
			IQueryCompositeComponentTypeLevel ccQuery = model.Query.QueryTypeLevel.
				QueryCompositeComponent(StaticComponentModel.CCWRITEID);
			IQueryBasicComponentTypeLevel bc1Query = model.Query.QueryTypeLevel.
				QueryBasicComponent(StaticComponentModel.BCWRITEID);
			IQueryBasicComponentTypeLevel bc2Query = model.Query.QueryTypeLevel.
				QueryBasicComponent(StaticComponentModel.BCWRITEBEID);

			Assert.AreEqual(ccQuery.GetBasicComponents().Length,1);
			Assert.AreEqual(ccQuery.GetCompositeComponents().Length,0);
            
			Assert.AreEqual(ccQuery.GetProvidesInterfaceIDs().Length,1);
			Assert.AreEqual(ccQuery.GetProvidesInterfaceIDs()[0],StaticComponentModel.IWRITERID);
			Assert.AreEqual(ccQuery.GetRequiresInterfaceIDs().Length,1);
			Assert.AreEqual(ccQuery.GetRequiresInterfaceIDs()[0],StaticComponentModel.IWRITERBEID);

			Assert.AreEqual(bc1Query.GetProvidesInterfaceIDs().Length,1);
			Assert.AreEqual(bc1Query.GetProvidesInterfaceIDs()[0],StaticComponentModel.IWRITERID);
			Assert.AreEqual(bc1Query.GetRequiresInterfaceIDs().Length,1);
			Assert.AreEqual(bc1Query.GetRequiresInterfaceIDs()[0],StaticComponentModel.IWRITERBEID);

			Assert.AreEqual(bc2Query.GetProvidesInterfaceIDs().Length,1);
			Assert.AreEqual(bc2Query.GetProvidesInterfaceIDs()[0],StaticComponentModel.IWRITERBEID);
			Assert.AreEqual(bc2Query.GetRequiresInterfaceIDs().Length,0);

			IConnectionIdentifier[] conIDs = ccQuery.GetConnections();
			Assert.AreEqual(conIDs.Length,2);

			Assert.AreEqual(ccQuery.GetProvidesDelegationConnector(StaticComponentModel.IWRITERID,
				StaticComponentModel.BCWRITEID,StaticComponentModel.IWRITERID),conIDs[0]);
			Assert.AreEqual(ccQuery.GetRequiresDelegationConnector(StaticComponentModel.IWRITERBEID,
				StaticComponentModel.BCWRITEID,StaticComponentModel.IWRITERBEID),conIDs[1]);
		}

		[Test]
		public void QueryStaticView()
		{
			StaticComponentModel.Create(model);
			IQueryStaticViewTypeLevel query = model.Query.QueryTypeLevel.QueryStaticView();
			IConnectionIdentifier[] conIDs = query.GetConnections();

			Assert.AreEqual(query.GetComponents().Length,2);
			Assert.AreEqual(query.GetBasicComponents().Length,1);
			Assert.AreEqual(query.GetCompositeComponents().Length,1);
			Assert.AreEqual(conIDs.Length,1);

			Assert.IsTrue(query.IsChild(StaticComponentModel.CCWRITEID));
			Assert.IsTrue(query.IsChild(StaticComponentModel.BCWRITEBEID));
			Assert.IsFalse(query.IsChild(StaticComponentModel.BCWRITEID));

			Assert.IsTrue(query.IsConnectionFromComponent(conIDs[0]));
		}

		[Test]
		public void QueryConnectionTest()
		{
			StaticComponentModel.Create(model);
			IQueryStaticViewTypeLevel svQuery = model.Query.QueryTypeLevel.QueryStaticView();
			IConnectionIdentifier[] conIDs = svQuery.GetConnections();
			Assert.AreEqual(conIDs.Length, 1);
            
			IQueryConnectionTypeLevel query = model.Query.QueryTypeLevel.QueryConnection(conIDs[0]);
			Assert.AreEqual(query.GetProvidingComponent(),StaticComponentModel.BCWRITEBEID);
			Assert.AreEqual(query.GetRequiringComponent(),StaticComponentModel.CCWRITEID);
			Assert.AreEqual(query.GetProvidingInterface(),StaticComponentModel.IWRITERBEID);
			Assert.AreEqual(query.GetRequiringInterface(),StaticComponentModel.IWRITERBEID);
		}

		[Test]
		public void QueryBasicComponentTest()
		{
			StaticComponentModel.Create(model);
			IQueryBasicComponentTypeLevel bc1Query = model.Query.QueryTypeLevel.
				QueryBasicComponent(StaticComponentModel.BCWRITEBEID);
			IQueryBasicComponentTypeLevel bc2Query = model.Query.QueryTypeLevel.
				QueryBasicComponent(StaticComponentModel.BCWRITEID);

			ISeffIdentifier[] seffs = bc2Query.GetServiceEffectSpecifications();
			Assert.IsTrue(seffs.Length==0);
			seffs = bc1Query.GetServiceEffectSpecifications();
			Assert.IsTrue(seffs.Length==1);

			IServiceEffectSpecification seff = model.Query.QueryRepository.GetServiceEffectSpecification(seffs[0]);

			Assert.IsFalse(bc2Query.IsSeffFromBasicComponent(seff.SeffID));
			Assert.IsTrue(bc1Query.IsSeffFromBasicComponent(seff.SeffID));

			Assert.AreEqual(bc1Query.GetServiceEffectSpecification(
				StaticComponentModel.IWRITERBEID,StaticComponentModel.SIG2ID),seffs[0]);
			Assert.AreEqual(bc1Query.GetServiceEffectSpecification(
				StaticComponentModel.IWRITERBEID,StaticComponentModel.SIG1ID),null);

			Assert.AreEqual(bc1Query.GetInterfaceOfSeff(seff.SeffID),StaticComponentModel.IWRITERBEID);
			Assert.AreEqual(bc1Query.GetSignatureOfSeff(seff.SeffID),StaticComponentModel.SIG2ID);

			model.BuilderManager.GetBasicComponentTypeLevelBuilder(StaticComponentModel.BCWRITEBEID).
				RemoveServiceEffectSpecification(seff.SeffID);

			Assert.AreEqual(bc1Query.GetServiceEffectSpecification(
				StaticComponentModel.IWRITERBEID,StaticComponentModel.SIG2ID),null);
			Assert.AreEqual(bc1Query.GetServiceEffectSpecification(
				StaticComponentModel.IWRITERBEID,StaticComponentModel.SIG1ID),null);

			Assert.IsFalse(bc2Query.IsSeffFromBasicComponent(seff.SeffID));
			Assert.IsFalse(bc1Query.IsSeffFromBasicComponent(seff.SeffID));

			seffs = bc2Query.GetServiceEffectSpecifications();
			Assert.IsTrue(seffs.Length==0);
			seffs = bc1Query.GetServiceEffectSpecifications();
			Assert.IsTrue(seffs.Length==0);

			Assert.IsNull(bc1Query.GetInterfaceOfSeff(seff.SeffID));
			Assert.IsNull(bc1Query.GetSignatureOfSeff(seff.SeffID));
		}

		[Test]
		public void QueryStaticViewAssemblyConnectors()
		{
			IBasicComponentTypeLevelBuilder bc1TLB =
				model.BuilderManager.RootTypeLevelBuilder.AddNewBasicComponent("bc1");
			ICompositeComponentTypeLevelBuilder cc1TLB = 
				model.BuilderManager.RootTypeLevelBuilder.AddNewCompositeComponent("cc1");
			
			IInterfaceIdentifier if1ID =
				model.BuilderManager.RootTypeLevelBuilder.CreateInterface("if1").InterfaceId;
			IInterfaceIdentifier if2ID =
				model.BuilderManager.RootTypeLevelBuilder.CreateInterface("if2").InterfaceId;

			cc1TLB.AddExistingInterfaceAsProvides(if1ID);
			cc1TLB.AddExistingInterfaceAsRequires(if2ID);

			bc1TLB.AddExistingInterfaceAsRequires(if1ID);
			
			IConnectionIdentifier con = model.BuilderManager.RootTypeLevelBuilder.
				AddAssemblyConnector("ac1", bc1TLB.ComponentId, if1ID, cc1TLB.ComponentId, if1ID);

			IConnectionIdentifier[] cons = model.Query.QueryTypeLevel.QueryStaticView().GetAssemblyConnectors();
			
			Console.Out.WriteLine(cons.Length);
			Assert.IsTrue(cons.Length == 1);
			Assert.AreSame(con, cons[0]);
		}

		[Test]
		public void QueryInterfacesTest()
		{
			IInterfaceBuilder ifaceB = model.BuilderManager.RootTypeLevelBuilder.CreateInterface("IWriter");
			ISignatureIdentifier sig1ID = ifaceB.AddSignature("Write1").Signature.SignatureID;
			ISignatureIdentifier sig2ID = ifaceB.AddSignature("Write2").Signature.SignatureID;
			ISignatureIdentifier sig3ID = ifaceB.AddSignature("Write3").Signature.SignatureID;

			IProtocol pro1 = new TestProtocol();
			ifaceB.AddProtocol(pro1);
			IProtocol pro2 = new TestProtocol();
			ifaceB.AddProtocol(pro2);

			IQueryInterfaceTypeLevel query = model.Query.QueryTypeLevel.QueryInterface(ifaceB.Interface.InterfaceID);
			Assert.AreEqual(query.GetSignatures().Length,3);
			Assert.AreEqual(query.GetProtocols().Length,2);

			Assert.IsTrue(query.IsSignatureFromInterface(sig1ID));
			Assert.IsTrue(query.IsSignatureFromInterface(sig2ID));
			Assert.IsTrue(query.IsSignatureFromInterface(sig3ID));

			Assert.IsTrue(query.IsProtocolFromInterface(pro1.ProtocolID));
			Assert.IsTrue(query.IsProtocolFromInterface(pro2.ProtocolID));

			ifaceB.RemoveSignature(sig1ID);
			Assert.IsFalse(query.IsSignatureFromInterface(sig1ID));
			ifaceB.RemoveSignature(sig2ID);
			Assert.IsFalse(query.IsSignatureFromInterface(sig2ID));
			ifaceB.RemoveSignature(sig3ID);
			Assert.IsFalse(query.IsSignatureFromInterface(sig3ID));

			ifaceB.RemoveProtocol(pro1.ProtocolID);
			Assert.IsFalse(query.IsProtocolFromInterface(pro1.ProtocolID));
			ifaceB.RemoveProtocol(pro2.ProtocolID);
			Assert.IsFalse(query.IsProtocolFromInterface(pro2.ProtocolID));
		}

        
	}

	public class TestProtocol:IProtocol
	{
		//the protocolIdentifier
		private IProtocolIdentifier id = ComponentModelIdentifier.CreateProtocolID(Guid.NewGuid().ToString());

		//the guid for the typeid of this protocol
		private static IProtocolTypeIdentifier TYPE_ID = 
			ComponentModelIdentifier.CreateProtocolTypeID("43DD8A47-97D7-4643-AB7C-C4CA389BAECD");

		/// <summary>
		/// returns the typed id of the protocol
		/// </summary>
		public IProtocolIdentifier ProtocolID
		{
			get
			{
				return this.id;
			}
		}

		/// <summary>
		/// returns the id of the type of protocol (fsm, ...)
		/// </summary>
		public IProtocolTypeIdentifier ProtocolTypeID
		{
			get
			{
				return TYPE_ID;
			}
		}

		/// <summary>
		/// The Identifier describing the identified object
		/// </summary>
		public IIdentifier ID
		{
			get
			{
				return this.id;
			}
		}
	}
}


#endif