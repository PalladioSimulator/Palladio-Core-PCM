using System;
using System.Runtime.Remoting;
using System.Runtime.Remoting.Channels;
using System.Runtime.Remoting.Channels.Tcp;

namespace RemoteClient
{
	internal class Server
	{
		[STAThread]
		private static void Main(string[] args)
		{
			if (args.Length > 0)
			{
				try
				{
					TcpChannel channel = new TcpChannel(int.Parse(args[0]));
					ChannelServices.RegisterChannel(channel);
					RemotingConfiguration.RegisterWellKnownServiceType(
						typeof (ServiceClass), "Service", WellKnownObjectMode.Singleton);
					Console.WriteLine("Server started on port " + args[0] + "\nHit <enter> to exit...\n");
					Console.ReadLine();
				}
				catch (Exception e)
				{
					Console.WriteLine("An error occured: " + e.Message + "\nPlease type 'server <port>' to start server.");
				}
			}
			else
			{
				Console.WriteLine("Please specify the used port!\nFor example use 'server 8085' to start a server listening on port 8085.");
			}
		}
	}
}