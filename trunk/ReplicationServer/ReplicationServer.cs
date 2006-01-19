using System;
using System.Runtime.Remoting;
using System.Runtime.Remoting.Channels;
using System.Runtime.Remoting.Channels.Tcp;

namespace ServiceReplication
{
	public class ReplicationServer
	{
		[STAThread]
		private static void Main(string[] args)
		{
			TcpChannel channel = new TcpChannel(8081);
			ChannelServices.RegisterChannel(channel);
			RemotingConfiguration.RegisterWellKnownServiceType(
				typeof (ReplicationManager), "ReplicationManager", WellKnownObjectMode.Singleton);
			Console.WriteLine("Replication manager started.\nHit <enter> to exit...");
			Console.ReadLine();
		}

	}
}