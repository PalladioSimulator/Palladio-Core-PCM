using System;
using ComponentNetworkSimulation.Structure.Elements;
using ComponentNetworkSimulation.Structure.Builder;
using ComponentNetworkSimulation.Structure;

namespace nunittests.structure
{
	/// <summary>
	/// </summary>
 	/// <remarks>
	/// <pre>
	/// Version history:
	/// 
	/// $Log$
	/// Revision 1.4  2004/06/23 16:35:39  joemal
	/// xxxx
	///
	/// Revision 1.3  2004/05/27 10:31:47  joemal
	/// xxx
	///
	/// Revision 1.2  2004/05/26 16:38:46  joemal
	/// xxx
	///
	/// Revision 1.1  2004/05/24 16:00:14  joemal
	/// initial creation
	///
	/// 
	/// </pre>
	/// </remarks>

	public class TestArchitectures
	{
		public static void CreateC1(IBasicComponentBuilder builder)
		{
			//only to test the get methods of the service builder
			builder.AddService(ID("P1"),ID("d1"));
			builder.AddService(ID("P1"),ID("d2"));

			//creates service d1 and d2
			TestArchitectures.CreateServiceD1(builder.GetServiceBuilder(ID("P1"),ID("d1")));
			TestArchitectures.CreateServiceD2(builder.GetServiceBuilder(ID("P1"),ID("d2")));				
		}

		public static void CreateC2(IBasicComponentBuilder builder)
		{	
			//creates service e1 to d4
			CreateEmptyService(builder.AddService(ID("P2"),ID("e1")),"C2->e1->1");
			CreateEmptyService(builder.AddService(ID("P2"),ID("e2")),"C2->e2->1");
			CreateEmptyService(builder.AddService(ID("P2"),ID("e3")),"C2->e3->1");
			CreateEmptyService(builder.AddService(ID("P2"),ID("e4")),"C2->e44->1");
		}

		public static void CreateServiceD1(IServiceBuilder builder)
		{
			builder.AddState(CP("d1->1",5));
			builder.AddState(CP("d1->2",3));
			builder.AddState(CP("d1->3",7));

			builder.SetStartState("d1->1");
			builder.SetFinalStates("d1->3");

			builder.AddTransition("d1->1",ID("e1"),ID("R1"),"d1->2");
			builder.AddTransition("d1->2",ID("e2"),ID("R1"),"d1->1");
			builder.AddTransition("d1->1",ID("e4"),ID("R1"),"d1->3");
		}

		public static void CreateServiceD2(IServiceBuilder builder)
		{
			builder.AddState(CP("d2->1",3));
			builder.AddState(CP("d2->2",4));

			builder.SetStartState("d2->1");
			builder.SetFinalStates("d2->2");

			builder.AddTransition("d2->1",ID("e3"),ID("R1"),"d2->2");
		}

		public static void CreateEmptyService(IServiceBuilder builder, string service)
		{
			string statename = "C2->"+service+"->1";
			builder.AddState(CP(statename,10));

			builder.SetStartState(statename);
			builder.SetFinalStates(statename);
		}


		public static ISimulationStateParams CP(string id, long time)
		{
			return new StaticTimeStateParams(id,DefaultRandomStrategy.getInstance(),LoggingType_t.NO_LOG,time);
		}

		public static Palladio.Identifier.IIdentifier ID(string id)
		{
			return Palladio.Identifier.IdentifiableFactory.CreateStringID(id);
		}
	}
}
