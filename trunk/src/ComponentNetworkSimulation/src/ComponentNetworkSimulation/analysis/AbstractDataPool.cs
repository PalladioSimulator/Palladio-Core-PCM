using ComponentNetworkSimulation.simulation;
using ComponentNetworkSimulation.structure;

namespace ComponentNetworkSimulation.analysis
{
	
	public abstract class AbstractDataPool
	{
		public const int PARAM_NO_PARAM = 0;
		public const int PARAM_ENTER_LP = 1;
		public const int PARAM_EXIT_LP = 2;
		
		public abstract void reset();

		public abstract void threadLog(SimulationThread  sender,TimeConsumer TimeConsumer, long time,int param);

		public abstract void otherLog(System.String message);
	}
}
