using System;

using Palladio.Identifier;
using Palladio.ComponentModel;

using Palladio.Simulation;
using Palladio.Simulation.Model;
using Palladio.Simulation.Simulation;

namespace Palladio.Example.Simulation
{

	public class TestApp : IThreadObserver
	{
		public static void Main()
		{
			//create a new environment and register a datapool
			ISimulationEnvironment env = new DefaultSimulationEnvironment();
			env.RegisterDataPool(DefaultEnvironmentFactory.CreateDefaultDataPool(env));

			//use the TestArchitectures to create a componentarchitecture with two basic components
			TestArchitectures.FillCC(env.ComponentArchitecture.CreateCompositeRootComponent(ID("CC"),null));

			//the first simple thread starts in composite component CC at provides interface P1 with a call to
			//the signature d1. This thread is observed.
			ThreadStartingPoint sp = new ThreadStartingPoint(ID("CC"),ID("P1"),ID("d1"));			
			env.Clock.ThreadScheduler.CreateSimulationThread(sp,SimulationThreadType.TYPE_LOG_ON_LPS,null);//new TestApp());

			//the second thread is a periodic thread that starts in composite component CC at provides interface P1 with a call to
			//the signature d2. It creates a new one every 5 timeunits.			
			sp = new ThreadStartingPoint(ID("CC"),ID("P1"),ID("d2"));			
			env.Clock.ThreadScheduler.CreateSimulationThread(sp,SimulationThreadType.TYPE_LOG_NOTHING,5);

			//the simulation will never ends with periodic threads. Abort it after 100 timeunits 
			env.Clock.MaximumSimulationTime = 100;
			
			//simulate, until no more steps are available
			while (env.SimulationStep()) 
			{
				Console.ReadLine();
			}

			Console.ReadLine();
		}

		//call to create an identifier from given string
		public static IIdentifier ID(string id)
		{
			return IdentifiableFactory.CreateStringID(id);
		}

		//the following lines are used to observe the first thread.
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
