namespace ComponentNetworkSimulation.Structure
{
	public enum LoggingType_t {NO_LOG,LOG_ON_ENTER,LOG_ON_EXIT,LOG_BOTH};	

	public interface ITimeConsumer
	{
		ITimeConsumer NextTimeConsumer
		{
			get;
		}

		bool HasNextTimeConsumer 
		{
			get;
		}

		LoggingType_t LoggingType
		{
			get;
		}

		long ThreadEntered();
		void ThreadExited();
	}
}
