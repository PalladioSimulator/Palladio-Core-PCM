using System;
using Palladio.FiniteStateMachines;
using Palladio.Attributes;
using ComponentNetworkSimulation.Simulation;
using ComponentNetworkSimulation.Structure;
using ComponentNetworkSimulation.Structure.Visitor;
using Palladio.ComponentModel;
using Palladio.Identifier;

namespace testapplication
{

	public class TestApp : IThreadObserver
	{
		public static Random random = new Random();

		public static void Main()
		{
			for (int a=0;a<5;a++)
			{
				Console.Out.WriteLine("Neuer lauf: ");
				IComponentArchitecture architecture = new SimpleComponentArchitecture();

				IThreadStartingPoint sp = new DefaultThreadStartingPoint(ID("CompCom"),ID("P1"),ID("d1")); 
				IComponentVisitor visitor = architecture.CreateVisitor(sp);
				DefaultSimulationThread thread = new DefaultSimulationThread(0,visitor,SimulationThreadType.TYPE_LOG_NOTHING,new TestApp());

				int round = 0;

				while(thread.IsAlive && round <50)
				{
					round ++;
					long timeInFuture = thread.TimeInFuture;
					Console.WriteLine("CurrentTC: "+thread.CurrentTimeConsumer);
					Console.WriteLine("Time in future: "+thread.TimeInFuture);
					thread.TimeMoved(timeInFuture);
					Console.ReadLine();
				}

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
			Console.WriteLine("Thread reached end ...");
		}

		public void NotifyThreadChangedTimeConsumer(ISimulationThread sender, ITimeConsumer previous)
		{
			Console.WriteLine("Thread changed TC from "+previous+" to "+sender.CurrentTimeConsumer);
		}

		public void NotifyTimeStep(ISimulationThread sender, long timeStep)
		{
			Console.WriteLine("Thread makes a timestep: "+timeStep+" ms");
		}

		public void NotifyUnknownElementFound()
		{
			Console.WriteLine("Thread found and unknown element !");
		}

		public void NotifyUnboundExternalCall(IComponent c, IExternalSignature externalSignature)
		{
			Console.WriteLine("Thread found the unbound external call: ");
			Console.WriteLine("Component: "+c.ID);
			Console.WriteLine("Interface: "+externalSignature.RoleID);
			Console.WriteLine("Signature: "+externalSignature.Signature.ID);
		}

		#endregion
	}
}
