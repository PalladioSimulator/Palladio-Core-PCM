namespace ComponentNetworkSimulation.structure
{
	public enum LoggingType {NO_LOG,LOG_ON_ENTER,LOG_ON_EXIT,LOG_BOTH};	

	public interface TimeConsumer
	{
		TimeConsumer getNextTimeConsumer();
		bool hasNextTimeConsumer();
		long getUsedTime();
		LoggingType getLoggingType();

	}
}
