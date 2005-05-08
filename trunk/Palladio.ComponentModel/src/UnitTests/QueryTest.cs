using System;
using NUnit.Framework;
using Palladio.ComponentModel.Builder;
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
			IQueryEntities query = model.Query.QueryEntities;
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
			Assert.AreEqual(conIDs.Length,1);

			Assert.IsTrue(query.IsChildren(StaticComponentModel.CCWRITEID));
			Assert.IsTrue(query.IsChildren(StaticComponentModel.BCWRITEBEID));
			Assert.IsFalse(query.IsChildren(StaticComponentModel.BCWRITEID));

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
		public void QueryInterfacesTest()
		{
			IInterfaceBuilder ifaceB = model.BuilderManager.RootBuilder.AddInterface("IWriter");
			ISignatureIdentifier sig1ID = ifaceB.AddSignature("Write1").Signature.SignatureID;
			ISignatureIdentifier sig2ID = ifaceB.AddSignature("Write2").Signature.SignatureID;
			ISignatureIdentifier sig3ID = ifaceB.AddSignature("Write3").Signature.SignatureID;

			IProtocol pro1 = new TestProtocol();
			ifaceB.AddProtocol(pro1);
			IProtocol pro2 = new TestProtocol();
			ifaceB.AddProtocol(pro2);

			Console.Out.WriteLine("The interface: "+ifaceB.Interface.InterfaceID.Key);
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