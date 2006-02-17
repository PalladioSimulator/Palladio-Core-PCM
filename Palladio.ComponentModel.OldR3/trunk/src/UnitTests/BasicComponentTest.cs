#if TEST

using System;
using NUnit.Framework;
using Palladio.ComponentModel.Exceptions;
using System.Collections;
using Palladio.FiniteStateMachines;

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
	/// Revision 1.2  2004/05/24 15:03:14  sliver
	/// added tests for fsmprotocols in a basic component
	///
	/// Revision 1.1  2004/05/23 16:03:56  sliver
	/// completed unit tests
	///
	/// </pre>
	/// </remarks>
	[TestFixture]
	public class BasicComponentTest
	{
		ISignatureList iProv1;
		ISignatureList iReq1, iReq2;
		ISignatureList d1se, d2se;
		IServiceEffectMapping d1map, d2map;
		IBasicComponent iComp1, iComp2, iComp3;
		ISignature[] sigsProv1, sigsReq1, sigsReq2;
		IBasicComponent fsmComponent;

		[SetUp] public void Init()
		{
			iComp1 = ComponentFactory.CreateBasicComponent();
			sigsProv1 = ComponentFactory.CreateSignatureArray("iProv1", "d1", "d2" );
			sigsReq1 = ComponentFactory.CreateSignatureArray("iReq1", "e1", "e2" );
			sigsReq2 = ComponentFactory.CreateSignatureArray("iReq2", "d3", "d4" );
			iProv1 = ComponentFactory.CreateSignatureListInterface("iProv1", sigsProv1);
			iReq1 = ComponentFactory.CreateSignatureListInterface("iReq1", sigsReq1);
			iReq2 = ComponentFactory.CreateSignatureListInterface("iReq2", sigsReq2);
			d1se = ComponentFactory.CreateSignatureListServiceEffect(sigsReq1[0],sigsReq1[1]);
			d2se = ComponentFactory.CreateSignatureListServiceEffect(sigsReq1[0],sigsReq2[0],sigsReq2[1]);
			d1map = ComponentFactory.CreateServiceEffectMapping(iProv1[0], d1se );
			d2map = ComponentFactory.CreateServiceEffectMapping(iProv1[1], d2se );
			iComp1.AddRequiresInterfaces(iReq1, iReq2);
			iComp1.AddProvidesInterface(iProv1,d1map,d2map);

			iComp2 = ComponentFactory.CreateBasicComponent();
			iComp2.AddRequiresInterfaces((ISignatureList) iReq1.Clone(), (ISignatureList) iReq2.Clone());
			iComp2.AddProvidesInterface( (ISignatureList) iProv1.Clone(), (IServiceEffectMapping) d1map.Clone(), (IServiceEffectMapping) d2map.Clone());

			iComp3 = ComponentFactory.CreateBasicComponent();
			iComp3.AddRequiresInterfaces(ComponentFactory.CreateSignatureListInterface("iReq1","e1","e2", "e3" ), (ISignatureList) iReq2.Clone());
			iComp3.AddProvidesInterface( (ISignatureList) iProv1.Clone(), (IServiceEffectMapping) d1map.Clone(), (IServiceEffectMapping) d2map.Clone());

			fsmComponent = ComponentFactory.CreateBasicComponent();
			IFSMProtocol prov = FSMProtocolTest.CreateProvidesInterface();
			IFSMProtocol d1	  = FSMProtocolTest.CreateServiceEffectD1();
			IFSMProtocol d2	  = FSMProtocolTest.CreateServiceEffectD2();
			IFSMProtocol req  = FSMProtocolTest.CreateRequires();
			IServiceEffectMapping m1 = ComponentFactory.CreateServiceEffectMapping(prov[0], d1);
			IServiceEffectMapping m2 = ComponentFactory.CreateServiceEffectMapping(prov[1], d2);
			fsmComponent.AddProvidesInterface(prov, m1, m2);
			fsmComponent.AddRequiresInterfaces(req);
		}

		[Test] public void WalkthroughFSMComponent()
		{
			IFSMProtocol prov = (IFSMProtocol)fsmComponent.GetProvidesInterface("ProvIF");
			ITransition[] transitions = prov.FSM.GetOutgoingTransitions(prov.FSM.StartState);
			IFSMProtocol d1 = (IFSMProtocol)fsmComponent.GetServiceEffectSpecification( (ISignature) transitions[0].InputSymbol.ID );
			IFSMProtocol d2 = (IFSMProtocol)fsmComponent.GetServiceEffectSpecification( (ISignature) transitions[1].InputSymbol.ID );
			foreach( ITransition t in d1.FSM.Transitions )
			{
				Assert.IsTrue( fsmComponent.HasRequiresInterface( ((ISignature)t.InputSymbol.ID).RoleID ) );
			}
			foreach( ITransition t in d2.FSM.Transitions )
			{
				Assert.IsTrue( fsmComponent.HasRequiresInterface( ((ISignature)t.InputSymbol.ID).RoleID ) );
			}
		}

		[Test] public void GetInterfacesByRole()
		{
			Assert.AreEqual( iProv1, iComp1.GetProvidesInterface("iProv1") );
			Assert.IsTrue( iComp1.ProvidesInterfaces.Length == 1 );
			Assert.AreEqual( iReq1, iComp1.GetRequiresInterface("iReq1") );
			Assert.AreEqual( iReq2, iComp1.GetRequiresInterface("iReq2") );
			Assert.IsTrue( iComp1.RequiresInterfaces.Length == 2 );
		}

		[ExpectedException(typeof(RoleIDNotFoundException))]
		[Test] public void GetUnkownReqInterface()
		{
			iComp1.GetRequiresInterface("unkown");
		}

		[ExpectedException(typeof(RoleIDNotFoundException))]
		[Test] public void GetUnkownProvInterface()
		{
			iComp1.GetProvidesInterface("unkown");
		}

		[ExpectedException(typeof(RoleIDAlreadySpecifiedException))]
		[Test] public void ReAddProvInterface()
		{
			iComp1.AddProvidesInterface(iProv1,d1map,d2map);
		}

		[ExpectedException(typeof(RoleIDAlreadySpecifiedException))]
		[Test] public void ReAddReqInterface()
		{
			iComp1.AddRequiresInterfaces(iReq1);
		}

		[ExpectedException(typeof(SignatureHasNoServEffSpecException))]
		[Test] public void MissingServiceEffect()
		{
			IBasicComponent comp = ComponentFactory.CreateBasicComponent();
			comp.AddRequiresInterfaces(iReq1);
			comp.AddProvidesInterface(iProv1);
		}

		[Test] public void GetServiceEffect()
		{
			ISignatureList prov = iComp1.GetProvidesInterface("iProv1");
			ArrayList list = new ArrayList();
			foreach( ISignature sig in prov.Signatures )
			{
				list.Add( iComp1.GetServiceEffectSpecification(sig) );
			}
			Assert.IsTrue( list.Count == 2 );
			Assert.IsTrue( list.Contains( d1se ) );
			Assert.IsTrue( list.Contains( d2se ) );
		}

		[ExpectedException(typeof(SignatureNotFoundException))]
		[Test] public void GetInvalidServiceEffect()
		{
			ISignature sig = ComponentFactory.CreateSignature("unkown", "d1");
			iComp1.GetServiceEffectSpecification(sig);
		}

		[Test] public void Equals()
		{
			Assert.IsTrue( iComp1.Equals(iComp2) );
			Assert.IsFalse( iComp1.Equals(iComp3) );
		}



		[Test] public void Clone()
		{
			IBasicComponent clone = (IBasicComponent)iComp1.Clone();
			Assert.IsTrue(iComp1.Equals(clone));
			clone.AddRequiresInterfaces( ComponentFactory.CreateSignatureListInterface("another","s1","s2") );
			Assert.IsFalse(iComp1.Equals(clone));
		}

		[Test] public void ChangeServiceEffect()
		{
			IBasicComponent cmp = (IBasicComponent)iComp1.Clone();
			cmp.ChangeServiceEffectSpecification(
				ComponentFactory.CreateSignature("iProv1","d1"), 
				ComponentFactory.CreateSignatureListServiceEffect( iReq2.Signatures ));
			ISignatureList se = cmp.GetServiceEffectSpecification(
				ComponentFactory.CreateSignature("iProv1","d1"));
			Assert.IsTrue( se.ContainsSignature(iReq2[0]));
			Assert.IsTrue( se.ContainsSignature(iReq2[1]));
			Assert.IsTrue( se.Signatures.Length == 2 );
		}


	}
}
#endif
