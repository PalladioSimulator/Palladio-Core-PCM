#if TEST

using System;
using NUnit.Framework;
using Palladio.ComponentModel.Exceptions;
using System.Collections;
using Palladio.FiniteStateMachines;
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
	/// Revision 1.3  2004/06/03 14:37:29  sbecker
	/// Added the possibility to attach auxiliary specifications to a basic component
	///
	/// Revision 1.2  2004/06/02 15:41:13  sbecker
	/// Fixed Compiler Warnings
	///
	/// Revision 1.1  2004/06/02 14:50:25  sbecker
	/// Initial Import after a major rework
	///
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
		IInterfaceModel iProv1;
		IInterfaceModel iReq1, iReq2;
		IServiceEffectSpecification d1se, d2se;
		IBasicComponent iComp1, iComp2, iComp3;
		ISignatureList sigsProv1, sigsReq1, sigsReq2;
		IBasicComponent fsmComponent;

		[SetUp] public void Init()
		{
			iComp1 = ComponentFactory.CreateBasicComponent("C1");

			sigsProv1 = ComponentFactory.CreateSignatureList("d1", "d2" );
			iProv1 = ComponentFactory.CreateInterfaceModel(sigsProv1);
			
			sigsReq1 = ComponentFactory.CreateSignatureList("e1", "e2" );
			iReq1 = ComponentFactory.CreateInterfaceModel(sigsReq1);

			sigsReq2 = ComponentFactory.CreateSignatureList("d3", "d4" );
			iReq2 = ComponentFactory.CreateInterfaceModel(sigsReq2);

			d1se = ComponentFactory.CreateServiceEffectSpecification();
			d1se.SignatureList.AddSignatures(ComponentFactory.CreateExternalSignatureArray("E1",sigsReq1[0],sigsReq1[1]));
			d2se = ComponentFactory.CreateServiceEffectSpecification();
			d2se.SignatureList.AddSignatures(ComponentFactory.CreateExternalSignatureArray("E1",sigsReq1[0]));
			d2se.SignatureList.AddSignatures(ComponentFactory.CreateExternalSignatureArray("E2",sigsReq2[0],sigsReq2[1]));

			iComp1.AddRequiresInterface(ID("E1"),iReq1);
			iComp1.AddRequiresInterface(ID("E2"),iReq2);
			iComp1.AddProvidesInterface(ID("P1"),iProv1);

			iComp1.AddServiceEffectSpecification(SigRole("P1",sigsProv1[0]),d1se);
			iComp1.AddServiceEffectSpecification(SigRole("P1",sigsProv1[1]),d2se);

			iComp2 = ComponentFactory.CreateBasicComponent("C2");
			iComp2.AddRequiresInterface(ID("E1"),(IInterfaceModel)iReq1.Clone());
			iComp2.AddRequiresInterface(ID("E2"),(IInterfaceModel)iReq2.Clone());
			iComp2.AddProvidesInterface(ID("P1"),(IInterfaceModel)iProv1.Clone());
			
			iComp2.AddServiceEffectSpecification(SigRole("P1",sigsProv1[0]),d1se);
			iComp2.AddServiceEffectSpecification(SigRole("P1",sigsProv1[1]),d2se);

			iComp3 = ComponentFactory.CreateBasicComponent("C3");
			ISignatureList sigList = ComponentFactory.CreateSignatureList("e1","e2", "e3");
			IInterfaceModel model = ComponentFactory.CreateInterfaceModel(sigList);
			iComp3.AddRequiresInterface(ID("iReq1"),model);
			iComp3.AddRequiresInterface(ID("E2"),(IInterfaceModel)iReq2.Clone());
			iComp3.AddProvidesInterface(ID("P1"),(IInterfaceModel)iProv1.Clone());
			iComp3.AddServiceEffectSpecification(ID("P1"),sigsProv1[0],(IServiceEffectSpecification)d1se.Clone());
			iComp3.AddServiceEffectSpecification(ID("P1"),sigsProv1[1],(IServiceEffectSpecification)d2se.Clone());

			fsmComponent = ComponentFactory.CreateBasicComponent("fsmComponent");
			IInterfaceModel prov = ComponentFactory.CreateInterfaceModel();
			prov.AddAuxiliarySpecification(FSMProtocolTest.CreateProvidesInterface());
			IServiceEffectSpecification d1 = ComponentFactory.CreateServiceEffectSpecification();
			d1.AddAuxiliarySpecification(FSMProtocolTest.CreateServiceEffectD1());
			IServiceEffectSpecification d2 = ComponentFactory.CreateServiceEffectSpecification();
			d2.AddAuxiliarySpecification(FSMProtocolTest.CreateServiceEffectD2());
			IInterfaceModel req = ComponentFactory.CreateInterfaceModel();
			prov.AddAuxiliarySpecification(FSMProtocolTest.CreateRequires());
			
			ISignature[] signatures = ComponentFactory.CreateSignatureArray("d1","d2");
			prov.SignatureList.AddSignatures(signatures);
			req.SignatureList.AddSignatures(ComponentFactory.CreateSignatureArray("e1","e2","e3"));

			fsmComponent.AddProvidesInterface(ID("Prov1"),prov);
			fsmComponent.AddServiceEffectSpecification(ID("Prov1"),signatures[0],d1);
			fsmComponent.AddServiceEffectSpecification(ID("Prov1"),signatures[1],d2);
			
			fsmComponent.AddRequiresInterface(ID("Req1"),req);
		}

		private IIdentifier ID(string aID)
		{
			return IdentifiableFactory.CreateStringID(aID);
		}

		private ISignatureWithRole SigRole(string role,ISignature sig)
		{
			return ComponentFactory.CreateSignatureWithRole(role,sig);
		}

		[Test] public void WalkthroughFSMComponent()
		{
			IInterfaceModel prov = fsmComponent.GetProvidesInterface(ID("Prov1"));
			IFSMInterface fsmprov = (IFSMInterface)prov.GetAuxiliarySpecification(typeof(IFSMInterface));
			ITransition[] transitions = fsmprov.FSM.GetOutgoingTransitions(fsmprov.FSM.StartState);
			IServiceEffectSpecification d1spec = fsmComponent.GetServiceEffectSpecification(SigRole("Prov1",(ISignature)transitions[0].InputSymbol.ID ));
			IFSMServiceEffect d1 = (IFSMServiceEffect)d1spec.GetAuxiliarySpecification(typeof(IFSMServiceEffect));
			IServiceEffectSpecification d2spec = fsmComponent.GetServiceEffectSpecification(SigRole("Prov1",(ISignature)transitions[1].InputSymbol.ID ));
			IFSMServiceEffect d2 = (IFSMServiceEffect)d2spec.GetAuxiliarySpecification(typeof(IFSMServiceEffect));
			foreach( ITransition t in d1.FSM.Transitions )
			{
				Assert.IsTrue( fsmComponent.HasRequiresInterface( ((ISignatureWithRole)t.InputSymbol.ID).RoleID ));
			}
			foreach( ITransition t in d2.FSM.Transitions )
			{
				Assert.IsTrue( fsmComponent.HasRequiresInterface( ((ISignatureWithRole)t.InputSymbol.ID).RoleID ));
			}
		}

		[Test] public void GetInterfacesByRole()
		{
			Assert.AreEqual( iProv1, iComp1.GetProvidesInterface(ID("P1")) );
			Assert.IsTrue( iComp1.ProvidedRoles.Length == 1 );
			Assert.AreEqual( iReq1, iComp1.GetRequiresInterface(ID("E1")) );
			Assert.AreEqual( iReq2, iComp1.GetRequiresInterface(ID("E2")) );
			Assert.IsTrue( iComp1.RequiredRoles.Length == 2 );
		}
		[ExpectedException(typeof(RoleIDNotFoundException))]
		[Test] public void GetUnkownReqInterface()
		{
			iComp1.GetRequiresInterface(ID("unkown"));
		}

		[ExpectedException(typeof(RoleIDNotFoundException))]
		[Test] public void GetUnkownProvInterface()
		{
			iComp1.GetProvidesInterface(ID("unkown"));
		}

		[ExpectedException(typeof(RoleIDAlreadySpecifiedException))]
		[Test] public void ReAddProvInterface()
		{
			iComp1.AddProvidesInterface(ID("P1"),iProv1);
		}

		[ExpectedException(typeof(RoleIDAlreadySpecifiedException))]
		[Test] public void ReAddReqInterface()
		{
			iComp1.AddRequiresInterface(ID("E1"),iReq1);
		}

		[Test] public void CloneBasicComponent()
		{
			IBasicComponent compClone = (IBasicComponent)iComp1.Clone();
			Assert.AreEqual(compClone,iComp1);
		}

		[Test] public void DeleteServiceEffect()
		{
			IBasicComponent comp = (IBasicComponent)iComp1.Clone();
			IServiceEffectSpecification spec = comp.GetServiceEffectSpecification(SigRole("P1",sigsProv1[0]));
			comp.DeleteServiceEffectSpecification(SigRole("P1",sigsProv1[0]));
		}

		[ExpectedException(typeof(SignatureHasNoServEffSpecException))]
		[Test] public void MissingServiceEffect()
		{
			IBasicComponent comp = (IBasicComponent)iComp1.Clone();
			comp.DeleteServiceEffectSpecification(SigRole("P1",sigsProv1[0]));
			comp.GetServiceEffectSpecification(SigRole("P1",sigsProv1[0]));
		}

		[Test] public void GetServiceEffect()
		{
			IInterfaceModel prov = iComp1.GetProvidesInterface(ID("P1"));
			ArrayList list = new ArrayList();
			foreach(ISignature sig in prov.SignatureList.Signatures )
			{
				list.Add( iComp1.GetServiceEffectSpecification(SigRole("P1",sig)) );
			}
			Assert.IsTrue( list.Count == 2 );
			Assert.IsTrue( list.Contains( d1se ) );
			Assert.IsTrue( list.Contains( d2se ) );
		}

		[ExpectedException(typeof(RoleIDNotFoundException))]
		[Test] public void GetInvalidServiceEffectRole()
		{
			ISignature sig = ComponentFactory.CreateSignature("d1");
			iComp1.GetServiceEffectSpecification(SigRole("unknown",sig));
		}

		[ExpectedException(typeof(SignatureNotFoundException))]
		[Test] public void GetInvalidServiceEffectSignature()
		{
			ISignature sig = ComponentFactory.CreateSignature("unknown");
			iComp1.GetServiceEffectSpecification(SigRole("P1",sig));
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
			ISignature sig = ComponentFactory.CreateSignature("unknown");
			clone.GetProvidesInterface(ID("P1")).SignatureList.AddSignatures(sig);
			Assert.IsFalse(iComp1.Equals(clone));
		}

		[Test] public void ChangeServiceEffect()
		{
			IBasicComponent cmp = (IBasicComponent)iComp1.Clone();
			IServiceEffectSpecification spec = ComponentFactory.CreateServiceEffectSpecification();
			spec.SignatureList.AddSignatures(SigRole("E1",sigsReq1[0]));
			cmp.ChangeServiceEffectSpecification(ID("P1"),sigsProv1[0],
				spec);
			IServiceEffectSpecification se = cmp.GetServiceEffectSpecification(SigRole("P1",sigsProv1[0]));
			Assert.IsTrue( se.SignatureList.ContainsSignature(SigRole("E1",sigsReq1[0])));
			Assert.IsTrue( se.SignatureList.Signatures.Length == 1 );
		}
	}
}
#endif
