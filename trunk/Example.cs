using System;
using System.Collections;
using Palladio.FiniteStateMachines;
using Palladio.ComponentModel;

namespace Example
{
	/// <summary>
	/// Example for the usage of the ComponentModel.
	/// </summary>
	public class ComponentExample
	{
		private static FSMFactory factory = new FSMFactory();

		public static Component BuildComponentA()
		{
			IState[] states = new State[5];
			states[0] = new State("start",true,false);
			states[1] = new State("final",false,true);

			// Input symbols of the protocol of the ProvidesInterface
			Input[] provInputs = new Input[2];
			provInputs[0] = new Input("d1");
			provInputs[1] = new Input("d2");

			IList provTransList = new ArrayList();
			//									start	     d2			start
			provTransList.Add( new Transition (states[0],provInputs[1],states[0]) );
			//									start	     d1			final
			provTransList.Add( new Transition (states[0],provInputs[0],states[1]) );
			//									final	     d2			final
			provTransList.Add( new Transition (states[1],provInputs[1],states[1]) );

			IFiniteStateMachine provFsm = factory.CreateFSM(provTransList);
			
			// Provides signatures
			IList provSigList = new ArrayList();
			provSigList.Add( new SimpleSignature("d1") );
			provSigList.Add( new SimpleSignature("d2") );
			IInterfaceModel provIModel = new ProtocolIModel( provFsm, provSigList );

			// Input symbols of the protocol of the RequiresInterface
			Input[] reqInputs = new Input[3];
			reqInputs[0] = new Input("e1");
			reqInputs[1] = new Input("e2");
			reqInputs[2] = new Input("e3");

			// Service Effect Spec d1
			IList d1TransList = new ArrayList();
			//								  start		  e1	  final
			d1TransList.Add( new Transition (states[0],reqInputs[0],states[1]) );
			//								  final		  e2	  start
			d1TransList.Add( new Transition (states[1],reqInputs[1],states[0]) );
			IFiniteStateMachine d1Fsm = factory.CreateFSM(d1TransList);

			IList d1SigList = new ArrayList();
			d1SigList.Add( new SimpleSignature("e1") );
			d1SigList.Add( new SimpleSignature("e2") );
			IInterfaceModel d1IModel = new ProtocolIModel( d1Fsm, d1SigList );

			// Service Effect Spec d2
			IList d2TransList = new ArrayList();
			//								  start		  e3	  final
			d2TransList.Add( new Transition (states[0],reqInputs[2],states[1]) );
			IFiniteStateMachine d2Fsm = factory.CreateFSM(d2TransList);

			IList d2SigList = new ArrayList();
			d2SigList.Add( new SimpleSignature("e3") );
			IInterfaceModel d2IModel = new ProtocolIModel( d2Fsm, d2SigList );

			// ServiceList
			IList provSrvList = new ArrayList();
			provSrvList.Add( new Service(d1IModel, new SimpleSignature("d1")) );
			provSrvList.Add( new Service(d2IModel, new SimpleSignature("d2")) );

			// ProvidesInterface
			ProvidesInterface provIFace = new ProvidesInterface( provIModel, provSrvList, "provides");

			// Requires IModel
			IList reqSigList = new ArrayList();
			reqSigList.Add( new SimpleSignature("e1") );
			reqSigList.Add( new SimpleSignature("e2") );
			reqSigList.Add( new SimpleSignature("e3") );
			IInterfaceModel reqIModel = new SignatureListIModel(reqSigList);

			// RequiresInterface
			RequiresInterface reqIFace = new RequiresInterface(reqIModel,"extern");

			// Component
			IList provList = new ArrayList();
			provList.Add(provIFace);
			IList reqList = new ArrayList();
			reqList.Add(reqIFace);

			return new Component(provList,reqList);		
		}

		public static Component BuildComponentB()
		{
			IList provSigList = new ArrayList();
			provSigList.Add( new SimpleSignature("e1") );
			provSigList.Add( new SimpleSignature("e2") );
			provSigList.Add( new SimpleSignature("e3") );
			provSigList.Add( new SimpleSignature("e4") );

			IInterfaceModel provIModel = new SignatureListIModel( provSigList );
			ProvidesInterface provIFace = new ProvidesInterface( provIModel, "extern" );

			IList provList = new ArrayList();
			provList.Add( provIFace );
			return new Component( provList );
		}


		public static void Main()
		{
			Component compA = BuildComponentA();
			Component compB = BuildComponentB();
			ComponentBinding binding = new ComponentBinding(compA,compB);

			Console.WriteLine("\n------------------------------------------------------");
			Console.WriteLine(binding.IfaceBindings[0].ProvIface);

			Console.WriteLine("\n------------------------------------------------------");
			Console.WriteLine(binding.IfaceBindings[0].ReqIface);

			Console.WriteLine("\n------------------------------------------------------");
			IInterfaceModel modelIntersection = binding.IfaceBindings[0].GetIntersection();
			Console.WriteLine(modelIntersection);

			Console.WriteLine("\n------------------------------------------------------");
			
			IList provIfaceList = binding.ReqComponent.GetProvidesIfaceList();
			foreach (ProvidesInterface provIface in provIfaceList)
			{
				Console.WriteLine(provIface);
				Console.WriteLine("\n------------------------------------------------------");
			}

			IList reqIfaceList = binding.ReqComponent.GetRequiresIfaceList();
			foreach (RequiresInterface reqIface in reqIfaceList)
			{
				Console.WriteLine(reqIface);
				Console.WriteLine("\n------------------------------------------------------");
			}

		}
	}
}
