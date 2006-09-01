using System;
using System.Text;
using TimeConsumingProcessorXML;

namespace Palladio.Webserver.TimeConsumingProcessor
{
	/// <summary>
	/// TimeConsumingProcessorConfiguration is the configuration for the TimeConsumingProcessor.
	/// </summary>
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2005/05/01 18:27:44  kelsaka
	/// - update: codestyle + documentation
	///
	/// Revision 1.1  2005/01/07 16:58:02  kelsaka
	/// Added TimeConsumingProcessor including its documentation and configuration.
	/// Integrated the new processor into the COR.
	///
	/// </pre>
	/// </remarks>
	public class TimeConsumingProcessorConfiguration
	{
		/// <summary>
		/// Enumeration of WaitOptions, dertermines the way the TimeConsumer is spending time.
		/// </summary>
		public enum WaitOptionChoice
		{
			busyWait,
			threadSleep
		}
		
		private ConfigType configRoot;

		/// <summary>
		/// Default constructor.
		/// </summary>
		/// <param name="configRoot">The documents root.</param>
		public TimeConsumingProcessorConfiguration(ConfigType configRoot)
		{
			this.configRoot = configRoot;
		}

		/// <summary>
		/// Returns, wether the component is activated (if true it consumes time; else it simply delegates
		/// to COR-Successor).
		/// </summary>
		public bool Active
		{
			get
			{
				return configRoot.Active.GetValue().BoolValue();	
			}
		}

		/// <summary>
		/// Returns, wether the component waits by busy waiting or by thread sleeping. 
		/// </summary>
		public Enum WaitOption 
		{
			get
			{
				// true: thread-sleep, false: busy waiting
				if(configRoot.WaitOption.GetThreadSleep().BoolValue() == true)
				{
					return WaitOptionChoice.threadSleep;
				}
				else
				{
					return WaitOptionChoice.busyWait;
				}
			}
		}

		/// <summary>
		/// Basic Delay. The mean time (in milliseconds) to wait.
		/// </summary>
		public int BasicDelay 
		{
			get
			{
				return configRoot.Delay.BasicDelay.IntValue();
			}
		}

		/// <summary>
		/// The variance (in milliseconds) of the delay.
		/// </summary>
		public int Variance 
		{
			get
			{
				return configRoot.Delay.Variance.IntValue();
			}
		}

		/// <summary>
		/// How probable the component is active.
		/// </summary>
		public int ProbaliltyOfActivation
		{
			get
			{
				return configRoot.ProbaliltyOfActivation.Value.IntValue();
			}
		}

		/// <summary>
		/// The random seed that has to be used. If the value is "0" no seed shall be used.
		/// </summary>
		public int Seed 
		{
			get
			{
				return configRoot.Seed.InitialSeed.IntValue();
			}
		}

	}
}
