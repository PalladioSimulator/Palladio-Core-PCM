using System;

namespace ComponentNetworkSimulation.Structure
{
	/// <summary>
	/// Zusammenfassung für SimpleTestComponentNetwork.
	/// </summary>
	public class SimpleTestComponentNetwork : AbstractComponentNetwork
	{
		public SimpleTestComponentNetwork()
		{
			build_network();
		}

		private void build_network()
		{
			//------- Component B -------

			//service effect automat: Comp B -> provided Service e1
			TestInternalService serviceE1State0 = new TestInternalService("Service E1, state0",5);
			//service effect automat: Comp B -> provided Service e2
			TestInternalService serviceE2State0 = new TestInternalService("Service E2, state0",3);

			//----------------------------

			//------- Mapping zwischen Comp A und Comp B, later one mapping with several signatures, each for one service
			//Mapping  für E1
			TestMapping mapE1 = new TestMapping("Mapping for Service E1 between Comp A and B",3,serviceE1State0);
			//Mapping  für E2
			TestMapping mapE2 = new TestMapping("Mapping for Service E2 between Comp A and B",3,serviceE2State0);
			//------------------------------------------

			//------- Component A --------
			
			//Endzustand 2 von Service E0
			TestInternalService serviceE0State2 = new TestInternalService("Final state of E0",4);

			//Transition zwischen State 1 und State 2, Aufruf von Service E1 (Teilbaum beginnend bei mapE1)
			TestTransition transState1To2 = new TestTransition("Transition between state 1 and 2 of Service E0",
				mapE1,serviceE0State2);

			//state 1 von Service E0
			TestInternalService serviceE0State1 = new TestInternalService("state 1 of E0",
				6,transState1To2);

			//Transition zwischen State 0 und State 1, Aufruf von Service E2 (Teilbaum beginnend bei mapE2)
			TestTransition transState0To1 = new TestTransition("Transition between state 0 and 1 of Service E0",
				mapE2,serviceE0State1);

			//startzustand state 0 von Service E0
			TestInternalService serviceE0State0 = new TestInternalService("state 0 of E0",2,transState0To1);

			//----------------------------
			
			//Service von E0 ist Systemservice der Architektur
			this.SystemServices.Add(serviceE0State0);
		}

		public override String getName()
		{
			return "Only to test the current version ...";
		}
	}

	// Die Klassen ab hier sind nur zum Test da, sie werden später in der Art in den Modellen der Komponenten und der Architektur
	// irgendwo auftauchen ...

	/// <summary>
	/// wird später mal ein State eines SEA sein: repräsentiert interne Verarbeitung von Befehlen ...
	/// </summary>
	public class TestInternalService : ITimeConsumer
	{
		private string name;
		private long time = 0;
		private ITimeConsumer nextTC = null;

		public TestInternalService(string name, long time)
		{
			this.time = time;
			this.name = name;
		}

		public TestInternalService(string name,long time, ITimeConsumer nextTC):this(name,time)
		{
			this.nextTC = nextTC;
		}

		public override string ToString()
		{
			return this.name;
		}

	
		#region ITimeConsumer Member

		public ITimeConsumer NextTimeConsumer
		{
			get
			{
				return nextTC;
			}
		}

		public bool HasNextTimeConsumer
		{
			get
			{
				return nextTC != null;
			}
		}

		public ComponentNetworkSimulation.Structure.LoggingType_t LoggingType
		{
			get
			{
				return LoggingType_t.LOG_BOTH;
			}
		}

		public long ThreadEntered()
		{
			return this.time;
		}

		public void ThreadExited()
		{
		}

		#endregion
	}

	/// <summary>
	/// Wird später mal die Verbindung zwischen zwei Diensten zweier Komponenten existieren
	/// </summary>
	public class TestMapping : ITimeConsumer
	{
		private string name;
		private long time;
		private ITimeConsumer nextTC = null;

		public TestMapping(string name,long time)
		{
			this.time = time;
			this.name = name;
		}

		public TestMapping(string name,long time, ITimeConsumer nextTC):this(name,time)
		{
			this.nextTC = nextTC;
		}
		
		public override string ToString()
		{
			return this.name;
		}
	
		#region ITimeConsumer Member

		public ITimeConsumer NextTimeConsumer
		{
			get
			{
				return this.nextTC;
			}
		}

		public bool HasNextTimeConsumer
		{
			get
			{
				return this.nextTC != null;
			}
		}

		public ComponentNetworkSimulation.Structure.LoggingType_t LoggingType
		{
			get
			{
				return LoggingType_t.LOG_BOTH;
			}
		}

		public long ThreadEntered()
		{
			return this.time;
		}

		public void ThreadExited()
		{
		}

		#endregion

	}

	/// <summary>
	/// Wird später mal als Transition eines SEA existieren. Stellt eine Verbindung zu einem Teilbaumes von TimeConsumern her.
	/// Repräsentiert den Aufruf eines externen Services ...
	/// </summary>
	public class TestTransition : ISubCallingTimeConsumer
	{
		private string name;
		private ITimeConsumer nextTC;
		private ITimeConsumer nextTCAfterReturn = null;

		public TestTransition(string name,ITimeConsumer nextTC)
		{
            this.nextTC = nextTC;			
			this.name = name;
		}

		public TestTransition(string name,ITimeConsumer nextTC, ITimeConsumer nextTCAfterReturn) : this(name,nextTC)
		{
			this.nextTCAfterReturn = nextTCAfterReturn;			
		}
		
		public override string ToString()
		{
			return this.name;
		}

		#region ISubCallingTimeConsumer Member

		public ITimeConsumer NextTimeConsumerAfterReturn
		{
			get
			{
				return this.nextTCAfterReturn;
			}
		}

		#endregion

		#region ITimeConsumer Member

		public ITimeConsumer NextTimeConsumer
		{
			get
			{
				return this.nextTC;
			}
		}

		public bool HasNextTimeConsumer
		{
			get
			{
				return true;
			}
		}

		public ComponentNetworkSimulation.Structure.LoggingType_t LoggingType
		{
			get
			{
				// TODO:  Getter-Implementierung für Transition.LoggingType hinzufügen
				return LoggingType_t.LOG_BOTH;
			}
		}

		public long ThreadEntered()
		{
			return 0;
		}

		public void ThreadExited()
		{
		}

		#endregion

	}
}
