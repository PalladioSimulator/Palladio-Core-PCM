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
		#region data
		private Client client1;
		private Client client2;
		private Client client3;
		private Client client4;
		private Client client5;
		#endregion

		#region constructor
		/// <summary>
		/// Constructs a ConcurrentClientScenario and initialises the clients.
		/// </summary>
		public ConcurrentClientScenario()
		{
			client1 = new Client();
			client2 = new Client();
			client3 = new Client();
			client4 = new Client();
			client5 = new Client();
		}
		#endregion
	
		#region public methods
		/// <summary>
		/// Starts the scenario.
		/// </summary>
		public void Start()
		{
			Thread t = null;
			t = new Thread(new ThreadStart(client1.Start)) ;
			t.Start();
			t = new Thread(new ThreadStart(client2.Start)) ;
			t.Start();
			t = new Thread(new ThreadStart(client3.Start)) ;
			t.Start();
			t = new Thread(new ThreadStart(client4.Start)) ;
			t.Start();
			t = new Thread(new ThreadStart(client5.Start)) ;
			t.Start();
			t.Join();
			client1.MemoryAppender2File();
			client2.MemoryAppender2File();
			client3.MemoryAppender2File();
			client4.MemoryAppender2File();
			client5.MemoryAppender2File();
		}
		#endregion
	}
}
