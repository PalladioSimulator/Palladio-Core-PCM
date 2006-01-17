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

using System.Threading;
using log4net;
using System;
//using Palladio.QoSAdaptor.ReplicationAdaptor;
using Palladio.QoSAdaptor.CacheAdaptor;
//using Palladio.QoSAdaptor.TestService;
using Palladio.QoSAdaptor.Utils;

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
		#region attributes
		/// <summary>
		/// The measured service
		/// </summary>
		//private ServiceReplicationAdaptor service;
		private ServiceCacheAdaptor service;
		//private Service service;

		/// <summary>
		/// Indicates how many service calls shall be executed by the client.
		/// </summary>
		private int numberOfCalls;

		/// <summary>
		/// The probability that the client executes a writing call.
		/// </summary>
		private double writeProbability;

		/// <summary>
		/// Randomizer for the indices used in service calls.
		/// </summary>
		private Random indexRandomizer;

		/// <summary>
		/// Randomizer for Thread.sleep() duration after each service call.
		/// </summary>
		private Random sleepRandomizer;

		/// <summary>
		/// Used to create writing calls with a certain probabiliy.
		/// </summary>
		private Random writeRandomizer;

		/// <summary>
		/// Timer to measure the response times of the service.
		/// </summary>
		private HiResTimer timer;

		/// <summary>
		/// log4net logger that writes all response times to the main memory.
		/// </summary>
		private static readonly ILog clientLogger = 
			log4net.LogManager.GetLogger("ClientResponseTimeLogger");
		#endregion

		#region constructor
		/// <summary>
		/// Constructs a new Client object and initialises all attributes.
		/// </summary>
		/// <param name="service">The service that shall be used by the client.
		/// </param>
		/// <param name="numberOfCalls">The number of calls the client has to 
		/// execute.</param>
		/// <param name="writeProbability">The probability of a writing call.
		/// </param>
		//public Client (ServiceReplicationAdaptor service, int numberOfCalls, double writeProbability)
		public Client (ServiceCacheAdaptor service, int numberOfCalls, double writeProbability)
		//public Client (Service service, int numberOfCalls, double writeProbability)
		{
			this.service = service;
			this.numberOfCalls = numberOfCalls;
			this.writeProbability = writeProbability;

			this.indexRandomizer = new Random(this.GetHashCode());
			this.sleepRandomizer = new Random(this.GetHashCode()+1);
			this.writeRandomizer = new Random(this.GetHashCode()+2);
			this.timer = new HiResTimer();
		}
		#endregion
		
		#region properties
		/// <summary>
		/// Returns the logger used to log the response times in the main
		/// memory.
		/// </summary>
		public static ILog ClientLogger
		{
			get
			{
				return clientLogger;
			}
		}
		#endregion

		#region public methods
		/// <summary>
		/// Starts the client.
		/// </summary>
		public void Start ()
		{
			for (int i = 0; i<numberOfCalls; i++)
			{
				this.timer.Start();
				// 1001 has been taken as max, because the the maximum value 
				// seems not be taken as return value, but the min value
				// may can appear (This has been tested with 1000 calls).
				// By using the factor 1000 writingProbabilities differing by
				// 0,001 can be processed getting correct results.
				int readWriteProbability = this.writeRandomizer.Next(1,1001);
				if (readWriteProbability <= (this.writeProbability * 1000))
				{
					// The service is assigned in the measuring time, because
					// through this the overhead of .NET remoting can be 
					// measured according to the replication adaptor where this
					// also happens in the measured time.
					/*this.service = (Service)Activator.GetObject(typeof(Service),
						"tcp://localhost:8085/TestService");*/
					this.service.Set(this.indexRandomizer.Next(0, 99), 1);
					clientLogger.Debug(string.Format("Client {0}\t{1}\t{2}\t{3}",
						this.GetHashCode(), "Write", DateTime.Now, 
						this.timer.Stop()));
				}
				else
				{
					// The service is assigned in the measuring time, because
					// through this the overhead of .NET remoting can be 
					// measured according to the replication adaptor where this
					// also happens in the measured time.
					/*this.service = (Service)Activator.GetObject(typeof(Service),
						"tcp://localhost:8085/TestService");*/
					this.service.Get(this.indexRandomizer.Next(0, 99));
					clientLogger.Debug(string.Format("Client {0}\t{1}\t{2}\t{3}",
						this.GetHashCode(), "Read", DateTime.Now, 
						this.timer.Stop()));
				}
				
				Thread.Sleep(this.sleepRandomizer.Next(0,100));
			}
		}
		#endregion
	}
}
