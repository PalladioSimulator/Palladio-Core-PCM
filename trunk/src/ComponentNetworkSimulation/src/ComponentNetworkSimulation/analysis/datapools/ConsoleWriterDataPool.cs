using System;
using ComponentNetworkSimulation.simulation;
using ComponentNetworkSimulation.structure;

namespace ComponentNetworkSimulation.analysis.datapools
{
	internal class ConsoleWriterDataPool : ComponentNetworkSimulation.analysis.AbstractDataPool
	{
		public ConsoleWriterDataPool(AbstractSimulationEnvironment simulationEnvironment) : base (simulationEnvironment)
		{
		}

		public override void Reset()
		{
			PrintLog("Simulation reseted");
		}

		protected override void OnClockEvent(object sender, ClockLogEventArgs eventArgs)
		{
			if (eventArgs.TheType == ClockLogEventArgs.EventType.CLOCK_RESET)
				PrintLog("ClockLog -> reset");
			else if (eventArgs.TheType == ClockLogEventArgs.EventType.CLOCK_STEP)
				PrintLog("ClockLog timeStep -> Stepsize = "+eventArgs.TimeStep);
			else if (eventArgs.TheType == ClockLogEventArgs.EventType.CLOCK_REACHED_MAXTIME)
				PrintLog("ClockLog -> maxtime reached");
			else if (eventArgs.TheType == ClockLogEventArgs.EventType.CLOCK_NO_MORE_THREADS)
				PrintLog("ClockLog -> no more threads alive");
		}

		protected override void OnThreadEvent(object sender, ThreadLogEventArgs eventArgs)
		{
			if (eventArgs.TheType == ThreadLogEventArgs.EventType.THREAD_CREATED) 
			{
				if (eventArgs.TheThread is PeriodicSimulationThread)
					PrintLog("ThreadLog -> Periodic Thread("+eventArgs.TheThread.ThreadID+
						","+((PeriodicSimulationThread)eventArgs.TheThread).PeriodID+") created.");
				else
					PrintLog("ThreadLog -> Thread("+eventArgs.TheThread.ThreadID+") created.");
			}
			else if (eventArgs.TheType == ThreadLogEventArgs.EventType.THREAD_REACHED_END) 
				PrintLog("ThreadLog -> Thread("+eventArgs.TheThread.ThreadID+") reached its end.");
			else if (eventArgs.TheType == ThreadLogEventArgs.EventType.THREAD_ENTERED_TIMECONSUMER) 
				PrintLog("ThreadLog -> Thread("+eventArgs.TheThread.ThreadID+") entered TimeConsumer "+
					eventArgs.TheTimeConsumer);
			else if (eventArgs.TheType == ThreadLogEventArgs.EventType.THREAD_EXITED_TIMECONSUMER) 
				PrintLog("ThreadLog -> Thread("+eventArgs.TheThread.ThreadID+") exited TimeConsumer "+eventArgs.TheTimeConsumer);
		}

		protected override void OnUnknownEvent(object sender, BasicLogEventArgs eventArgs)
		{
			PrintLog("Unknown log event -> "+eventArgs.Message);
		}



		protected void PrintLog(String message)
		{
			Console.WriteLine("Log at time "+this.SimulationTime+": "+message);
		}

	}
}
