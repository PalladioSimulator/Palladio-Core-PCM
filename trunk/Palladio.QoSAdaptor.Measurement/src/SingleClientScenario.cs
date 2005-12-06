//using Palladio.QoSAdaptor.ReplicationAdaptor;

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

namespace Palladio.QoSAdaptor.Measurement
{
	/// <summary>
	/// </summary>
	public class SingleClientScenario
	{
		#region attributes
		/// <summary>
		/// The client used for measurement.
		/// </summary>
		private Client client;
		#endregion

		#region constructor
		/// <summary>
		/// Constructs a new SingleClientScenario.
		/// </summary>
		public SingleClientScenario()
		{
			//ServiceCacheAdaptor service = new ServiceCacheAdaptor();
			//ServiceReplicationAdaptor service = new ServiceReplicationAdaptor();
			//client = new Client(service, 500);
		}
		#endregion

		#region public methods
		/// <summary>
		/// Starts the scenario.
		/// </summary>
		public void Start()
		{
			client.Start();
		}
		#endregion
	}
}
