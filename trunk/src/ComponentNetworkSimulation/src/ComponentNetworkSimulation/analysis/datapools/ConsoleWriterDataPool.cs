using ComponentNetworkSimulation.simulation;
using ComponentNetworkSimulation.structure;

namespace ComponentNetworkSimulation.analysis.datapools
{
	internal class ConsoleWriterDataPool : ComponentNetworkSimulation.analysis.AbstractDataPool
	{
		public override void reset()
		{
			System.Console.Out.WriteLine("Log: reset simulation"); 
		}

		public override void otherLog(System.String message)
		{
			System.Console.Out.WriteLine("Log: "+message); 
		}

		public override void threadLog(SimulationThread sender,TimeConsumer TimeConsumer, long time, int param)
		{
			System.Console.Out.WriteLine("Thread Log: "+sender+" on "+TimeConsumer+" at time "+time+".");
			System.Console.Out.WriteLine("Param = "+param+", means: ");
			if ((param & PARAM_ENTER_LP)!= 0)
				System.Console.Out.WriteLine("Thread entered logpoint.");
			if ((param & PARAM_EXIT_LP)!= 0)
				System.Console.Out.WriteLine("Thread leaved logpoint.");
			if (param == 0)
				System.Console.Out.WriteLine("No params set.");
		}
	}
}
