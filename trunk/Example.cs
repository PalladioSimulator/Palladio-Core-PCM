using System;
using System.Collections;
using Palladio.FiniteStateMachines;
using Palladio.ComponentModel;

namespace Example
{
	/// <summary>
	/// </summary>
	public class ComponentExample
	{

		public static Component BuildComponentA()
		{
			FSMFactory factory = new FSMFactory();

			IState[] states = new State[5];
			states[0] = new State("start",true,false);
			states[1] = new State("final",false,true);

			Input[] inputs = new Input[5];
			inputs[2] = new Input("e1");
			inputs[3] = new Input("e2");
			inputs[4] = new Input("e3");

			// Provides Signaturen
			IList prvSigList = new ArrayList();
			prvSigList.Add( new SimpleSignature("d1") );
			prvSigList.Add( new SimpleSignature("d2") );

			// Provides InterfaceModel
			IInterfaceModel prvIModel = new SignatureListIModel( prvSigList );

			// Service Effect Spec d1
			IList d1TransList = new ArrayList();
			d1TransList.Add( new Transition (states[0],inputs[2],states[1]) );
			d1TransList.Add( new Transition (states[1],inputs[3],states[0]) );
			IFiniteStateMachine d1Fsm = factory.CreateFSM(d1TransList);

			IList d1SigList = new ArrayList();
			d1SigList.Add( new SimpleSignature("e1") );
			d1SigList.Add( new SimpleSignature("e2") );

			IInterfaceModel d1IModel = new ProtocolIModel( d1Fsm, d1SigList );

			// Service Effect Spec d2
			IList d2TransList = new ArrayList();
			d2TransList.Add( new Transition (states[0],inputs[3],states[1]) );
			IFiniteStateMachine d2Fsm = factory.CreateFSM(d2TransList);

			IList d2SigList = new ArrayList();
			d2SigList.Add( new SimpleSignature("e1") );
			d2SigList.Add( new SimpleSignature("e2") );

			IInterfaceModel d2IModel = new ProtocolIModel( d2Fsm, d2SigList );

			// ServiceList
			IList prvSrvList = new ArrayList();
			prvSrvList.Add( new Service(d1IModel, new SimpleSignature("d1")) );
			prvSrvList.Add( new Service(d2IModel, new SimpleSignature("d2")) );

			// ProvidesInterface
			ProvidesInterface prvIFace = new ProvidesInterface( prvIModel, prvSrvList, "provides");

			// Requires IModel
			IList rqSigList = new ArrayList();
			rqSigList.Add( new SimpleSignature("e1") );
			rqSigList.Add( new SimpleSignature("e2") );
			rqSigList.Add( new SimpleSignature("e3") );
			IInterfaceModel rqIModel = new SignatureListIModel(rqSigList);

			// RequiresInterface
			RequiresInterface rqIFace = new RequiresInterface(rqIModel,"extern");

			// Component
			IList prvList = new ArrayList();
			prvList.Add(prvIFace);
			IList rqList = new ArrayList();
			rqList.Add(rqIFace);

			return new Component(prvList,rqList);		
		}

		public static Component BuildComponentB()
		{
			IList prvSigList = new ArrayList();
			prvSigList.Add( new SimpleSignature("e1") );
			prvSigList.Add( new SimpleSignature("e2") );
			prvSigList.Add( new SimpleSignature("e3") );

			IInterfaceModel prvIModel = new SignatureListIModel( prvSigList );
			ProvidesInterface prvIFace = new ProvidesInterface( prvIModel, "extern" );

			IList prvList = new ArrayList();
			prvList.Add( prvIFace );
			return new Component( prvList );
		}

		public static void Main()
		{
			Component compA = BuildComponentA();
			Component compB = BuildComponentB();
			CompBinding binding = new CompBinding(compA,compB);
		}
	}
}
