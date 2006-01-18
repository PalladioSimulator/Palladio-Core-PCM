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

using System.Collections;
using System.Threading;
//using Palladio.QoSAdaptor.ReplicationAdaptor;
using Palladio.QoSAdaptor.CacheAdaptor;
//using Palladio.QoSAdaptor.TestService;

namespace Palladio.QoSAdaptor.Measurement
{
	/// <summary>
	/// Implementation of a simple measurement scenario with multiple clients 
	/// to examine the behaviour of the system when multiple clients call the 
	/// system concurrently.
	/// TODO: Implement clients that wait for a random time between the calls
	/// to get more realistic results.
	/// TODO: Log details about the resources the clients request to see if 
	/// the cache works properly. 
	/// TODO: Implement remote clients.
	/// </summary>
	public class ConcurrentClientScenario
	{
		#region attributes
		/// <summary>
		/// A list of clients used for measurement.
		/// </summary>
		private ArrayList clients;
		#endregion

		#region constructor
		/// <summary>
		/// Constructs a ConcurrentClientScenario and initialises the service 
		/// and the clients.
		/// </summary>
		public ConcurrentClientScenario(int numberOfClients, int numberOfCalls,
			double writeProbability, double repetitionProbability)
		{
			//Service service = new Service();
			ServiceCacheAdaptor service = new ServiceCacheAdaptor();
			//ServiceReplicationAdaptor service = new ServiceReplicationAdaptor();
			clients = new ArrayList();
			for (int i=0; i<numberOfClients; i++)
				clients.Add(new Client(service, numberOfCalls, 
					writeProbability, repetitionProbability));
		}
		#endregion
	
		#region public methods
		/// <summary>
		/// Starts the scenario.
		/// </summary>
		public void Start()
		{
			// Create threads
			ArrayList threads = new ArrayList();
			Thread t = null;
			foreach (Client client in clients)
			{
				t = new Thread(new ThreadStart(client.Start)) ;
				t.Start();
				threads.Add(t);
			}

			// Wait until all threads are finished
			bool allThreadsFinished = false;
			while (!allThreadsFinished)
			{
				allThreadsFinished = true;
				foreach (Thread thread in threads)
				{
					if (thread.IsAlive)
						allThreadsFinished = false;
				}
				Thread.Sleep(1);
			}
		}
		#endregion
	}
}
