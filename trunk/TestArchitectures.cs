using System;

using Palladio.Simulation.Model.Elements;
using Palladio.Simulation.Model.Builder;
using Palladio.Simulation.Model;

namespace Palladio.Example.Simulation
{
	/// <summary>
	/// this static methods fill several basic or composite components used in the example
	/// </summary>
	public class TestArchitectures
	{
		//uses the given builder to fill a composite component
		//it is filled with the two basic components, created by FillC1() and FillC2()
		public static void FillCC(ICompositeComponentBuilder builder)
		{
			//create the two inner components
			FillC1(builder.AddBasicComponent(ID("C1"),null));
			FillC2(builder.AddBasicComponent(ID("C2"),null));

			//bind them
			StaticTimeBindingParams p = new StaticTimeBindingParams(LoggingType_t.LOG_BOTH,3);
			builder.AddBinding(ID("C2"),ID("C1"),ID("P2"),ID("R1"),p);

			//adds a provides mapping from c1 
			builder.AddProvidesMapping(ID("C1"),ID("P1"),ID("P1"));
		}

		//uses the given builder to fill a basic component
		public static void FillC1(IBasicComponentBuilder builder)
		{
			//only to test the get methods of the service builder
			builder.AddService(ID("P1"),ID("d1"),null);
			builder.AddService(ID("P1"),ID("d2"),null);

			//creates service d1 and d2
			FillServiceD1(builder.GetServiceBuilder(ID("P1"),ID("d1")));
			FillServiceD2(builder.GetServiceBuilder(ID("P1"),ID("d2")));				
		}

		//uses the given builder to fill a basic component
		public static void FillC2(IBasicComponentBuilder builder)
		{	
			//creates service e1 to d4
			FillEmptyService(builder.AddService(ID("P2"),ID("e1"),null),"e1(1)");
			FillEmptyService(builder.AddService(ID("P2"),ID("e2"),null),"e2(1)");
			FillEmptyService(builder.AddService(ID("P2"),ID("e3"),null),"e3(1)");
			FillEmptyService(builder.AddService(ID("P2"),ID("e4"),null),"e4(1)");
		}

		//fills the service d1
		public static void FillServiceD1(IServiceBuilder builder)
		{
			builder.AddState(CP("d1(1)",5,LoggingType_t.NO_LOG));
			builder.AddState(CP("d1(2)",3,LoggingType_t.NO_LOG));
			builder.AddState(CP("d1(3)",7,LoggingType_t.NO_LOG));

			builder.SetStartState("d1(1)");
			builder.SetFinalStates("d1(3)");

			builder.AddTransition("d1(1)",ID("e1"),ID("R1"),"d1(2)");
			builder.AddTransition("d1(2)",ID("e2"),ID("R1"),"d1(1)");
			builder.AddTransition("d1(1)",ID("e4"),ID("R1"),"d1(3)");
		}

		//fills the service d2
		public static void FillServiceD2(IServiceBuilder builder)
		{
			builder.AddState(CP("d2(1)",3,LoggingType_t.NO_LOG));
			builder.AddState(CP("d2(2)",4,LoggingType_t.NO_LOG));

			builder.SetStartState("d2(1)");
			builder.SetFinalStates("d2(2)");

			builder.AddTransition("d2(1)",ID("e3"),ID("R1"),"d2(2)");
		}

		//fills empty services. The name of the service is create from string service
		public static void FillEmptyService(IServiceBuilder builder, string service)
		{
			builder.AddState(CP(service,10,LoggingType_t.NO_LOG));

			builder.SetStartState(service);
			builder.SetFinalStates(service);
		}

        //call to create a parameterstructure for simulationstates using the random strategy
		public static ISimulationStateParams CP(string id, long time,LoggingType_t type)
		{
			return new StaticTimeStateParams(id,DefaultRandomStrategy.getInstance(),type,time);
		}

		//call to create an identifier from given string
		public static Palladio.Identifier.IIdentifier ID(string id)
		{
			return Palladio.Identifier.IdentifiableFactory.CreateStringID(id);
		}
	}
}