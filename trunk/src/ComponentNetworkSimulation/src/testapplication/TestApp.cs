using System;
using System.Collections;
using Palladio.FiniteStateMachines;
using Palladio.ComponentModel;

namespace testapplication
{

	public class TestApp
	{
		public static void Main()
		{
			try 
			{
				IComponent compB = CreateComponentB();
				Console.WriteLine("Comp B created ...");
				IComponent compA = CreateComponentA();
				Console.WriteLine("Comp A created ...");

				CompBinding b = new CompBinding(compA,compB);
				Console.WriteLine("All bound");

			}
			catch(Exception exc)
			{
				Console.WriteLine("Exception: "+exc.StackTrace);
				
			}

			Console.ReadLine();
		}

		public static IComponent CreateComponentA()
		{
			IList prvSigList = new SimpleSignature[] {new SimpleSignature("d0")};
			// Provides InterfaceModel
			IInterfaceModel prvIModel = new SignatureListIModel( prvSigList );

			// ServiceList
			IList prvSrvList = new Service[] {CreateServiceE0()};
            
			ProvidesInterface prvIFace = new ProvidesInterface( prvIModel, prvSrvList, "interface0" );

			// Requires IModel
			IList rqSigList = new ArrayList();
			rqSigList.Add( new SimpleSignature("e1"));
			rqSigList.Add( new SimpleSignature("e2"));
			IInterfaceModel rqIModel = new SignatureListIModel(rqSigList);

			// RequiresInterface
			RequiresInterface rqIFace = new RequiresInterface(rqIModel,"interface1");

			// Component
			IList prvList = new ArrayList();
			prvList.Add(prvIFace);
			IList rqList = new ArrayList();
			rqList.Add(rqIFace);

			return new Component(prvList,rqList);	
		}

		public static IComponent CreateComponentB()
		{
			IList prvSigList = new SimpleSignature[] {
				new SimpleSignature("d1"),
			    new SimpleSignature("d2"),
			};
			// Provides InterfaceModel
			IInterfaceModel prvIModel = new SignatureListIModel( prvSigList );

			// ServiceList
			IList prvSrvList = new Service[2];
			prvSrvList[0] = CreateServiceE1();
			Console.Out.WriteLine("E1 created ...");
			prvSrvList[1] = CreateServiceE2();
			Console.Out.WriteLine("E2 created ...");
            
			ProvidesInterface prvIFace = new ProvidesInterface( prvIModel, prvSrvList, "interface1" );
			// Component
			IList prvList = new ArrayList();
			prvList.Add(prvIFace);

			return new Component(prvList);	
		}

		public static Service CreateServiceE0()
		{
			State[] s = new State[] {new State("e0_0",true,false),new State("e0_1",false,false),new State("e0_2",false,true)};
			IList transList = new Transition[] 
				{
					new Transition(s[0],new Input("e1"),s[2]),
					new Transition(s[0],new Input("e2"),s[1]),
					new Transition(s[1],new Input("e1"),s[2])
				};
			IFiniteStateMachine fsm = new FSMFactory().CreateFSM(transList);

			IList prvSigList = new SimpleSignature[] 
				{
					new SimpleSignature("e1"),
					new SimpleSignature("e2")
				};

			return new Service(new ProtocolIModel(fsm,prvSigList),new SimpleSignature("d0"));			
		}

		public static Service CreateServiceE1()
		{
			IFiniteStateMachine fsm = new FSMFactory().GenerateFSM(new State("internal service e1",true,true));
			return new Service(new ProtocolIModel(fsm,new ArrayList()),new SimpleSignature("e1"));			
		}

		public static Service CreateServiceE2()
		{
			IFiniteStateMachine fsm = new FSMFactory().GenerateFSM(new State("internal service e2",true,true));
			return new Service(new ProtocolIModel(fsm,new ArrayList()),new SimpleSignature("e2"));			
		}
	}

}
