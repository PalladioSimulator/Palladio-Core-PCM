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
using System.Runtime.Remoting;
using System.Runtime.Remoting.Channels;
using System.Runtime.Remoting.Channels.Tcp;
using Palladio.QoSAdaptor.TestService;

namespace Palladio.QoSAdaptor.RemotingService
{
	/// <summary>
	/// Starts the TestService using .NET remoting.
	/// </summary>
	public class MainClass
	{
		public static int Main(string [] args) 
		{

			TcpChannel chan = new TcpChannel(8085);
			ChannelServices.RegisterChannel(chan);
			Service service = new Service();

			RemotingConfiguration.RegisterWellKnownServiceType
				// TODO: Why does Type.GetType not work???
				//(Type.GetType("Palladio.QoSAdaptor.TestService.Service,object"), 
				(service.GetType(),
				"TestService", WellKnownObjectMode.SingleCall);
			System.Console.WriteLine("Hit <enter> to exit...");
			System.Console.ReadLine();
			return 0;
		}
	}
}
