namespace ComponentNetworkSimulation.analysis
{
	class DataPoolFactory
	{
		public static AbstractDataPool createConsoleWriterDataPool()
		{
			return new datapools.ConsoleWriterDataPool();
		}
	}
}
