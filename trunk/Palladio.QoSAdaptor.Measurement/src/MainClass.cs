#region info
///////////////////////////////////////////////////////////////////////////////
// This software has been developed as a part of the diploma thesis 
// "Einfluss von Generatorkonfiguration auf die QoS-Vorhersage für 
// Komponentenadapter" ("Influence of the configuration of a generator on the 
// prediction of the QoS of component adaptors")
// at the 
// University of Oldenburg
// Department of Computing Science
// Software Engineering Group
// Palladio Research Group
// (http://se.informatik.uni-oldenburg.de/research/projects/Palladio)
// 
// Development period: July 2005 - January 2006
// 
// Author: Niels Streekmann
// E-mail: niels.streekmann@informatik.uni-oldenburg.de
///////////////////////////////////////////////////////////////////////////////
#endregion
using System;
using log4net.Appender;
using log4net.Config;
using log4net.Repository.Hierarchy;
using Palladio.QoSAdaptor.Utils;

namespace Palladio.QoSAdaptor.Measurement
{
	/// <summary>
	/// Starts a measurement scenario.
	/// TODO: Let all scenarios implement the same interface.
	/// </summary>
	public class MainClass
	{
		/// <summary>
		/// The main class of the measurement application. Start the given 
		/// scenario.
		/// </summary>
		/// <param name="args"></param>
		public static void Main (string[] args)
		{
			// Configure log4net for the measurement component. 
			// The configuration can be found in 
			// Palladio.QoSAdaptor.Measurement.config
			XmlConfigurator.Configure();
			int numberOfClients;
			int numberOfCalls;
			double writeProbability;
			try
			{
				numberOfClients = Int32.Parse(args[0]);
				numberOfCalls = Int32.Parse(args[1]);
				writeProbability = Double.Parse(args[2]);
			}
			catch (Exception)
			{
				Console.WriteLine("The number of clients, the number of "+
					"calls and the writing call probability have to be given "+
					"as arguments.");
				return;
			}
			if (numberOfClients <= 0)
			{
				Console.WriteLine("The number of clients has to be greater "+
					"than 0.");
				return;
			}
			if (numberOfCalls <= 0)
			{
				Console.WriteLine("The number of calls has to be greater "+
					"than 0.");
				return;
			}

			if ((writeProbability < 0 || writeProbability > 1))
			{
				Console.WriteLine("The writing call probability has to be "+
					"between  0 and 1.");
				return;
			}


			ConcurrentClientScenario scenario = 
				new ConcurrentClientScenario(numberOfClients, numberOfCalls, 
					writeProbability);
			scenario.Start();
			MemoryAppender2File("response_times_"+numberOfClients+
									"_clients_"+numberOfCalls+"_calls_"+
									"WP="+writeProbability+".log");
		}

		/// <summary>
		/// Writes the logs from the main memory to a file.
		/// </summary>
		private static void MemoryAppender2File(string fileName)
		{
			// write accept shopping cart rt log contents to file
			Logger logger = (Logger) Client.ClientLogger.Logger;
			MemoryAppender ma = (MemoryAppender) logger.GetAppender(
				"ClientResponseTimeAppender");
			if (ma != null)
			{
				LoggingHelper.SaveLogAppenderDataToDisk(ma, fileName);
			}
			else
			{
				Console.WriteLine("ERROR: Cannot write clogic log data to "+
					"file, appender not found");
			}
		}
	}
}
