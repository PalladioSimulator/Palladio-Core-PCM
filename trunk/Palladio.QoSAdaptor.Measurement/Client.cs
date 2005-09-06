#region info
///////////////////////////////////////////////////////////////////////////////
/// This software has been developed as a part of the diploma thesis 
/// "Einfluss von Generatorkonfiguration auf die QoS-Vorhersage für 
/// Komponentenadapter" ("Influence of the configuration of a generator on the 
/// prediction of the QoS of component adaptors")
/// at the 
/// University of Oldenburg
/// Department of Computing Science
/// Software Engineering Group
/// Palladio Research Group
/// (http://se.informatik.uni-oldenburg.de/research/projects/Palladio)
/// 
/// Development period: July 2005 - January 2006
/// 
/// Author: Niels Streekmann
/// E-mail: niels.streekmann@informatik.uni-oldenburg.de
///////////////////////////////////////////////////////////////////////////////
#endregion

using log4net;
using log4net.Appender;
using log4net.Repository.Hierarchy;
using Palladio.QoSAdaptor;
using System;

namespace Palladio.QoSAdaptor.Measurement
{
	/// <summary>
	/// Client used to execute measurements with the generated adaptor.
	/// Measurement are implemented using the HiResTimer class which results
	/// are first written to memory and into a log file at the end of the 
	/// measurement using the log4net framework.
	/// </summary>
	public class Client
	{
		private static readonly ILog clientLogger = 
			log4net.LogManager.GetLogger("ClientResponseTimeLogger");
			

		public Client()
		{
		}

		public void Start ()
		{
			ServiceCacheAdaptor service = new ServiceCacheAdaptor();
			int seed = 1;
			Random randomizer = new Random(seed);

			for (int i = 0; i<500; i++)
			{
				HiResTimer timer = new HiResTimer();
				timer.Start();
				service.Get(randomizer.Next(0, 99));
				clientLogger.Debug(string.Format("Client {0}\t{1}",
					this.GetHashCode(), timer.Stop()));
			}
		}

		public void MemoryAppender2File()
		{
			// write accept shopping cart rt log contents to file
			Logger logger = (Logger) clientLogger.Logger;
			MemoryAppender ma = (MemoryAppender) logger.GetAppender(
					"ClientResponseTimeAppender");
			if (ma != null)
			{
				string fileName = "client"+this.GetHashCode()+".log";
				LoggingHelper.SaveLogAppenderDataToDisk(ma, fileName);
			}
			else
			{
				Console.WriteLine("ERROR: Cannot write clogic log data to file, appender not found");
			}
		}
	}
}
