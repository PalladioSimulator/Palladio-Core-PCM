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
	/// Revision 1.5.2.3  2005/02/18 13:31:36  joemal
	/// xxx
	///
	/// Revision 1.5.2.2  2005/02/15 20:02:00  joemal
	/// diverses
	///
	/// Revision 1.5.2.1  2004/11/16 13:37:47  uffi
	/// Initial commit of the 2.0 version of the component model. BETA!!! See the techreport (to be updated) for details.
	/// Documentation needs fixing. Some unittests fail.
	///
	/// Revision 1.5  2004/07/05 09:30:12  sbecker
	/// Changes due to the refactorings after the first review
	///
	/// Revision 1.4  2004/06/09 12:36:31  sbecker
	/// Fixed documentation and renamed IExternalSignature
	///
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
	/// <exclude />
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
			iProv1 = ComponentFactory.CreateInterfaceModel(sigsProv1, "iProv1");
			
			sigsReq1 = ComponentFactory.CreateSignatureList("e1", "e2" );
			iReq1 = ComponentFactory.CreateInterfaceModel(sigsReq1, "iReq1");

			sigsReq2 = ComponentFactory.CreateSignatureList("d3", "d4" );
			iReq2 = ComponentFactory.CreateInterfaceModel(sigsReq2, "iReq2");

			iComp1.AddRequiresInterface(iReq1);
			iComp1.AddRequiresInterface(iReq2);
			iComp1.AddProvidesInterface(iProv1);

			d1se = ComponentFactory.CreateServiceEffectSpecification();
			d1se.RequiredServicesList.AddServices(ComponentFactory.CreateServiceArray(iReq1, sigsReq1[0].ID,sigsReq1[1].ID) );
			d2se = ComponentFactory.CreateServiceEffectSpecification();
			d2se.RequiredServicesList.AddServices(ComponentFactory.CreateServiceArray(iReq1, sigsReq1[0].ID));
			d2se.RequiredServicesList.AddServices(ComponentFactory.CreateServiceArray(iReq2, sigsReq2[0].ID,sigsReq2[1].ID));

			iComp1.AddServiceEffectSpecification(ComponentFactory.CreateService(iProv1,sigsProv1[0].ID),d1se);
			iComp1.AddServiceEffectSpecification(ComponentFactory.CreateService(iProv1,sigsProv1[1].ID),d2se);

			iComp2 = ComponentFactory.CreateBasicComponent("C2");
			iComp2.AddRequiresInterface((IInterfaceModel)iReq1.Clone());
			iComp2.AddRequiresInterface((IInterfaceModel)iReq2.Clone());
			iComp2.AddProvidesInterface((IInterfaceModel)iProv1.Clone());
			
			iComp2.AddServiceEffectSpecification(ComponentFactory.CreateService(iProv1,sigsProv1[0].ID),d1se);
			iComp2.AddServiceEffectSpecification(ComponentFactory.CreateService(iProv1,sigsProv1[1].ID),d2se);

			iComp3 = ComponentFactory.CreateBasicComponent("C3");
			ISignatureList sigList = ComponentFactory.CreateSignatureList("e1","e2", "e3");
			IInterfaceModel model = ComponentFactory.CreateInterfaceModel(sigList, "model");
			iComp3.AddRequiresInterface(model);
			iComp3.AddRequiresInterface((IInterfaceModel)iReq2.Clone());
			iComp3.AddProvidesInterface((IInterfaceModel)iProv1.Clone());
			iComp3.AddServiceEffectSpecification(iProv1.ID,sigsProv1[0].ID,(IServiceEffectSpecification)d1se.Clone());
			iComp3.AddServiceEffectSpecification(iProv1.ID,sigsProv1[1].ID,(IServiceEffectSpecification)d2se.Clone());

			fsmComponent = ComponentFactory.CreateBasicComponent("fsmComponent");
			IInterfaceModel prov = ComponentFactory.CreateInterfaceModel("prov");
			prov.AddProtocolInformation(FSMProtocolTest.CreateProvidesInterface());
			IServiceEffectSpecification d1 = ComponentFactory.CreateServiceEffectSpecification();
			d1.AddServiceInformation(FSMProtocolTest.CreateServiceEffectD1());
			IServiceEffectSpecification d2 = ComponentFactory.CreateServiceEffectSpecification();
			d2.AddServiceInformation(FSMProtocolTest.CreateServiceEffectD2());
			IInterfaceModel req = ComponentFactory.CreateInterfaceModel("req");
			prov.AddProtocolInformation(FSMProtocolTest.CreateRequires());
			
			ISignature[] signatures = ComponentFactory.CreateSignatureArray("d1","d2");
			prov.SignatureList.AddSignatures(signatures);
			req.SignatureList.AddSignatures(ComponentFactory.CreateSignatureArray("e1","e2","e3"));

			fsmComponent.AddProvidesInterface(prov);
			fsmComponent.AddServiceEffectSpecification(prov.ID,signatures[0].ID,d1);
			fsmComponent.AddServiceEffectSpecification(prov.ID,signatures[1].ID,d2);
			
			fsmComponent.AddRequiresInterface(req);
		}

		private IIdentifier ID(string aID)
		{
			return IdentifiableFactory.CreateStringID(aID);
		}

//		[Test] public void WalkthroughFSMComponent()
//		{
//			IInterfaceModel prov = fsmComponent.GetProvidesInterface(ID("Prov1"));
//			IFSMInterface fsmprov = (IFSMInterface)prov.GetAuxiliarySpecification(typeof(IFSMInterface));
//			ITransition[] transitions = fsmprov.FSM.GetOutgoingTransitions(fsmprov.FSM.StartState);
//			IServiceEffectSpecification d1spec = fsmComponent.GetServiceEffectSpecification(SigRole("Prov1",(ISignature)transitions[0].InputSymbol.ID ));
//			IFSMServiceEffect d1 = (IFSMServiceEffect)d1spec.GetAuxiliarySpecification(typeof(IFSMServiceEffect));
//			IServiceEffectSpecification d2spec = fsmComponent.GetServiceEffectSpecification(SigRole("Prov1",(ISignature)transitions[1].InputSymbol.ID ));
//			IFSMServiceEffect d2 = (IFSMServiceEffect)d2spec.GetAuxiliarySpecification(typeof(IFSMServiceEffect));
//			foreach( ITransition t in d1.FSM.Transitions )
//			{
//				IRole role = fsmComponent.GetRequiresRoleByInterfaceID( ((IService)t.InputSymbol.ID).Interface.ID );
//				Assert.IsNotNull( role );
//				//Assert.IsTrue( fsmComponent.HasRequiresInterface( ((IService)t.InputSymbol.ID).RoleID ));
//			}
//			foreach( ITransition t in d2.FSM.Transitions )
//			{
//				IRole role = fsmComponent.GetRequiresRoleByInterfaceID( ((IService)t.InputSymbol.ID).Interface.ID );
//				Assert.IsNotNull( role );
//				//Assert.IsTrue( fsmComponent.HasRequiresInterface( ((IService)t.InputSymbol.ID).RoleID ));
//			}
//		}

		[Test] public void GetInterfacesByRole()
		{
			Assert.AreEqual( iProv1, iComp1.GetProvidesInterface( iComp1.GetProvidesRoleByInterfaceID(iProv1.ID).ID ) );
			Assert.IsTrue( iComp1.ProvidedRoles.Length == 1 );
			Assert.AreEqual( iReq1, iComp1.GetRequiresInterface(iComp1.GetRequiresRoleByInterfaceID(iReq1.ID).ID) );
			Assert.AreEqual( iReq2, iComp1.GetRequiresInterface(iComp1.GetRequiresRoleByInterfaceID(iReq2.ID).ID) );
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
			iComp1.AddProvidesInterface(iProv1);
		}

		[ExpectedException(typeof(RoleIDAlreadySpecifiedException))]
		[Test] public void ReAddReqInterface()
		{
			iComp1.AddRequiresInterface(iReq1);
		}

		[Test] public void CloneBasicComponent()
		{
			IBasicComponent compClone = (IBasicComponent)iComp1.Clone();
			Assert.AreEqual(compClone,iComp1);
		}

		[Test] public void DeleteServiceEffect()
		{
			IBasicComponent comp = (IBasicComponent)iComp1.Clone();
			IServiceEffectSpecification spec = comp.GetServiceEffectSpecification(ComponentFactory.CreateService(iProv1,sigsProv1[0].ID));
			comp.DeleteServiceEffectSpecification(ComponentFactory.CreateService(iProv1,sigsProv1[0].ID));
		}

		[ExpectedException(typeof(ServiceHasNoServEffSpecException))]
		[Test] public void MissingServiceEffect()
		{
			IBasicComponent comp = (IBasicComponent)iComp1.Clone();
			comp.DeleteServiceEffectSpecification(ComponentFactory.CreateService(iProv1,sigsProv1[0].ID));
			comp.GetServiceEffectSpecification(ComponentFactory.CreateService(iProv1,sigsProv1[0].ID));
		}

		[Test] public void GetServiceEffect()
		{
			ArrayList list = new ArrayList();
			foreach(ISignature sig in iProv1.SignatureList)
			{
				list.Add( iComp1.GetServiceEffectSpecification(ComponentFactory.CreateService(iProv1,sig.ID)) );
			}
			Assert.IsTrue( list.Count == 2 );
			Assert.IsTrue( list.Contains( d1se ) );
			Assert.IsTrue( list.Contains( d2se ) );
		}

//		[ExpectedException(typeof(RoleIDNotFoundException))]
//		[Test] public void GetInvalidServiceEffectRole()
//		{
//			ISignature sig = ComponentFactory.CreateSignature("d1");
//			iComp1.GetServiceEffectSpecification(SigRole(iComp1.GetRole(IdentifiableFactory.CreateStringID("unknown")),sig));
//		}

		[ExpectedException(typeof(SignatureNotFoundException))]
		[Test] public void GetInvalidServiceEffectSignature()
		{
			IService service = ComponentFactory.CreateService(iProv1,ComponentFactory.CreateSignature("unknown").ID);
			iComp1.GetServiceEffectSpecification(service);
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
			spec.RequiredServicesList.AddServices(ComponentFactory.CreateService(iReq2,sigsReq2[0].ID));
			cmp.ChangeServiceEffectSpecification(ComponentFactory.CreateService(iProv1,sigsProv1[0].ID),
				spec);
			IServiceEffectSpecification se = cmp.GetServiceEffectSpecification(ComponentFactory.CreateService(iProv1,sigsProv1[0].ID));
			Assert.IsTrue( se.RequiredServicesList.ContainsService(ComponentFactory.CreateService(iReq2,sigsReq2[0].ID)));
			Assert.IsTrue( se.RequiredServicesList.Count == 1 );
		}
	}
}
#endif
