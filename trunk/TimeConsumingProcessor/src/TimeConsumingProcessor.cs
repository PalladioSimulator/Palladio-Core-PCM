using System;
using System.IO;
using System.Threading;
using System.Xml;
using Palladio.Webserver.ConfigReader;
using Palladio.Webserver.HTTPRequestProcessor;
using Palladio.Webserver.HTTPRequestProcessorTools;
using Palladio.Webserver.Request;
using Palladio.Webserver.WebserverMonitor;
using TimeConsumingProcessorXML;

namespace Palladio.Webserver.TimeConsumingProcessor
{
	/// <summary>
	/// TimeConsumingProcessor. Component that consumes a definable amount of time. This component doesn't process the
	/// IHTTPRequest, but waits until the request is passed to the successor in the Chain Of Responsibility (COR).
	/// Note: There are two ways how the cosumer is waiting:
	/// A: the current thread is set sleeping to produce the delay. This means, that other threads can continue working.
	/// B: the current thread is busy waiting. So this component simulates complex webserver-operations.
	/// The options of this component are set in "TimeConsumingProcessorXML.xml". E. g. there are options to adjust the
	/// probalitity how often the TimeConsumingProcessor should consume time (means: how often the component is activated)
	/// in average.
	/// </summary>
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.3  2005/05/01 17:23:26  kelsaka
	/// - added further documentation
	/// - extracted IHTTPRequestProcessorTools as own project
	/// - made server name configureable by config files
	///
	/// Revision 1.2  2005/01/22 16:42:56  kelsaka
	/// added configureable (XML) connection-string for the database;
	/// added thread-name for the main thread;
	/// fixed socket-error (updated documentation)
	///
	/// Revision 1.1  2005/01/07 16:58:02  kelsaka
	/// Added TimeConsumingProcessor including its documentation and configuration.
	/// Integrated the new processor into the COR.
	///
	/// </pre>
	/// </remarks>
	public class TimeConsumingProcessor : IHTTPRequestProcessor
	{

		private IWebserverConfiguration webserverConfiguration;
		private IWebserverMonitor webserverMonitor;
		private IHTTPRequestProcessor corSuccessor;
		private TimeConsumingProcessorConfiguration timeConsumingConfiguration;
		private IHTTPRequestProcessorTools requestProcessorTools;

		/// <summary>
		/// (Relative) Path to the xml-config-file. All other settings should be read out from the xml-file.
		/// </summary>
		private const string DEFAULT_XML_CONFIGURATION_FILE = "TimeConsumingProcessorXML.xml";
		


		public TimeConsumingProcessor(IHTTPRequestProcessor corSuccessor, IWebserverMonitor webserverMonitor, IWebserverConfiguration webserverConfiguration, IHTTPRequestProcessorTools requestProcessorTools)
		{
			this.corSuccessor = corSuccessor;
			this.webserverMonitor = webserverMonitor;
			this.webserverConfiguration = webserverConfiguration;
			this.timeConsumingConfiguration = readConfiguration();
			this.requestProcessorTools = requestProcessorTools;
		}


		/// <summary>
		/// This method doesn't processes the given IHTTPRequest. As an early part of the COR that handles the IHTTPRequests
		/// this methods consumes a specified amount of time, until it forwards the request to the COR-Successor.
		/// </summary>
		/// <param name="httpRequest">The Request that is forwarded to the COR-Successor.</param>
		public void HandleRequest(IHTTPRequest httpRequest)
		{

			// check for component activation:
			if(timeConsumingConfiguration.Active)
			{
				System.Random random;
				if(timeConsumingConfiguration.Seed == 0) //convention: "0" indicates use of default initialization
				{
					random = new Random();
				}
				else // Use the seed from the config-file
				{
					random = new Random(timeConsumingConfiguration.Seed); 
				}

				// How often the consumer should produce a time consume. This will cause unpredictable time consuming.
				// If the value is 100 the consumption will always be enabled, if the value is 0 the chance of
				// activation is 1 to 100. All integer number between 0 and 100 are allowed. Default is 100.
				if (random.Next(100) <= timeConsumingConfiguration.ProbaliltyOfActivation)
				{
					// calculate waiting-time:
					int waitingTime = timeConsumingConfiguration.BasicDelay //this delay has always to be used
						- (timeConsumingConfiguration.Variance / 2) // as variance (in a simple case) defines the range + and - the central value: subtract the half
						+ random.Next(timeConsumingConfiguration.Variance);

					if(timeConsumingConfiguration.WaitOption.Equals(TimeConsumingProcessorConfiguration.WaitOptionChoice.busyWait))
					{
						webserverMonitor.WriteLogEntry("The TimeConsumingProcessor is busy waiting for " + waitingTime + " milliseconds.");
						BusyWait(waitingTime);
					}
					else
					{
						webserverMonitor.WriteLogEntry("The TimeConsumingProcessor put the current thread sleeping for " + waitingTime + " milliseconds.");
						ThreadSleepWait(waitingTime);
					}
				}
			}
			// Finally always continue with COR-successor:
			corSuccessor.HandleRequest(httpRequest);
		}


		/// <summary>
		/// Consumes the the given time by busy waiting.
		/// </summary>
		/// <param name="waitTimeInMillis">The time the method should produce CPU-load.</param>
		private void BusyWait(int waitTimeInMillis)
		{
			//Ticks are given in nanoseconds, so multiply by 100 to get them out of milliseconds.
			long endTime = DateTime.Now.Ticks + (waitTimeInMillis * 100);
			int i = 0;
			do
			{
				i++;
			} while (endTime >= DateTime.Now.Ticks); 
		}

		/// <summary>
		/// Puts the current thread sleeping.
		/// </summary>
		/// <param name="waitTimeInMillis">The time the method should cause the thread sleeping.</param>
		private void ThreadSleepWait(int waitTimeInMillis)
		{
			Thread.Sleep(waitTimeInMillis);
		}



		/// <summary>
		/// Reads the configuration at the specified path and creates a TimeConsumingProcessorConfiguration out of the
		/// information read.
		/// </summary>
		/// <returns>Representation of the XML-configuration-files.</returns>
		private TimeConsumingProcessorConfiguration readConfiguration ()
		{		
	
			TimeConsumingProcessorXMLDoc doc = new TimeConsumingProcessorXMLDoc();
			doc.SetRootElementName("", "Config");

			ConfigType root = new ConfigType();

			try 
			{
				root = new ConfigType(doc.Load(webserverConfiguration.ConfigFilesPath + DEFAULT_XML_CONFIGURATION_FILE));
			}
			catch (FileNotFoundException e)
			{
				webserverMonitor.WriteDebugMessage(e.ToString(), 1);
			}
			catch (XmlException e)
			{
				webserverMonitor.WriteDebugMessage(e.ToString(), 1);
			}

			return new TimeConsumingProcessorConfiguration(root);
		}
	}
}
