namespace Palladio.Simulation.Analysis
{
	/// <summary>
	/// The factory belongs to the "Factory Methods Pattern" which implements the creation of several datapools.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// $Log$
	/// Revision 1.1  2004/07/20 11:46:43  joemal
	/// new cvs module for first release
	///
	/// 
	/// </pre>
	/// </remarks>
	public class DataPoolFactory
	{
		#region static create methods
		
		/// <summary>
		/// called to create a DataPool, logging all events to the console.
		/// </summary>
		/// <param name="environment">the using simulation environment</param>
		/// <returns>the instance of IDataPool</returns>
		public static IDataPool CreateConsoleWriterDataPool(ISimulationEnvironment environment)
		{
			return new Datapools.TextWriterDataPool(environment,System.Console.Out);
		}

		/// <summary>
		/// called to create a DataPool, logging all events to the given textwriter
		/// </summary>
		/// <param name="environment">the using simulation environment</param>
		/// <param name="writer">all events are written to this writer</param>
		/// <returns>the instance of IDataPool</returns>
		public static IDataPool CreateTextWriterDataPool(ISimulationEnvironment environment, 
			System.IO.TextWriter writer)
		{
			return new Datapools.TextWriterDataPool(environment,writer);
		}

		#endregion
	}
}
//EOF