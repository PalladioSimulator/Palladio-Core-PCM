namespace ComponentNetworkSimulation.structure
{
	public enum LoggingType {NO_LOG,LOG_ON_ENTER,LOG_ON_EXIT,LOG_BOTH}

	public interface TimeConsumer
	{
		TimeUser getNextTimeUser();
		bool hasNextTimeUser();
		long getUsedTime();
		LoggingType getLoggingType();

	}
}
