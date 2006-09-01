using System;
using ComponentNetworkSimulation;
using ComponentNetworkSimulation.Simulation;
using ComponentNetworkSimulation.Structure;
using ComponentNetworkSimulation.Structure.Builder;
using nunittests.structure;
using Palladio.ComponentModel;
using Palladio.Identifier;

namespace testapplication
{

	public class TestApp : IThreadObserver
	{
		public static Random random = new Random();

		public static void Main()
		{
			ISimulationEnvironment env = new DefaultSimulationEnvironment();
			env.RegisterDataPool(DefaultEnvironmentFactory.CreateDefaultDataPool(env));

			TestArchitectures.FillCC((ICompositeComponentBuilder)env.ComponentArchitecture.CreateCompositeRootComponent(ID("CC"),null));

			IThreadStartingPoint sp = new DefaultThreadStartingPoint(ID("CC"),ID("P1"),ID("d1"));			
			env.Clock.ThreadScheduler.CreateSimulationThread(sp,SimulationThreadType.TYPE_LOG_ALL,new TestApp());
			
			sp = new DefaultThreadStartingPoint(ID("CC"),ID("P1"),ID("d2"));			
			env.Clock.ThreadScheduler.CreateSimulationThread(sp,SimulationThreadType.TYPE_LOG_ALL,5);

			
			int cntr = 0;
			while (env.SimulationStep() && cntr < 50) 
			{
				cntr++;
				Console.ReadLine();
			}

			Console.ReadLine();
		}

		public static IIdentifier ID(string id)
		{
			return IdentifiableFactory.CreateStringID(id);
		}


		#region IThreadObserver Member

		public void NotifyThreadReachedEnd(ISimulationThread sender)
		{
			Console.WriteLine("Thread "+sender.ThreadID+" reached end ...");
		}

		public void NotifyThreadEnteredFirstTimeConsumer(ISimulationThread sender)
		{
			Console.WriteLine("Thread "+sender.ThreadID+" entered first TC: "+sender.CurrentTimeConsumer);
		}

		public void NotifyThreadChangedTimeConsumer(ISimulationThread sender, ITimeConsumer previous)
		{
			Console.WriteLine("Thread "+sender.ThreadID+" changed TC from "+previous+" to "+sender.CurrentTimeConsumer);
		}

		public void NotifyTimeStep(ISimulationThread sender, long timeStep)
		{
			Console.WriteLine("Thread "+sender.ThreadID+" makes a timestep: "+timeStep+" ms");
		}

		public void NotifyUnknownElementFound(ISimulationThread sender)
		{
			Console.WriteLine("Thread "+sender.ThreadID+" found and unknown element !");
		}

		public void NotifyUnboundExternalCall(ISimulationThread sender,IComponent c, IExternalSignature externalSignature)
		{
			Console.WriteLine("Thread "+sender.ThreadID+" found the unbound external call: ");
			Console.WriteLine("Component: "+c.ID);
			Console.WriteLine("Interface: "+externalSignature.RoleID);
			Console.WriteLine("Signature: "+externalSignature.Signature.ID);
		}

		#endregion
	}
}
