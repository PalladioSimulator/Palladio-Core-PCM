namespace ComponentNetworkSimulation.analysis
{
	class DataPoolFactory
	{
		public static AbstractDataPool createConsoleWriterDataPool(AbstractSimulationEnvironment environment)
		{
			return new datapools.ConsoleWriterDataPool(environment);
		}
	}
}
