namespace ComponentNetworkSimulation.structure
{
	public enum LoggingType {NO_LOG,LOG_ON_ENTER,LOG_ON_EXIT,LOG_BOTH};	

	public interface ITimeConsumer
	{
		ITimeConsumer getNextTimeConsumer();
		bool hasNextTimeConsumer();
		long getUsedTime();
		LoggingType getLoggingType();

	}
}
