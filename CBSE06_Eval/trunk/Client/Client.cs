using System;
using System.Runtime.Remoting.Channels;
using System.Runtime.Remoting.Channels.Tcp;
using System.Threading;
using ServiceReplication;
using MathNet.Numerics.Generators;

namespace RemoteClient
{
	internal class Client
	{
		private static TcpChannel channel = new TcpChannel();
		private static int clientCnt = 0;
		private static object csem = new object();

//		private static byte[] _randomData500;
//		private static byte[] _randomData50;
//		private static byte[] _randomData5;

		[STAThread]
		private static void Main(string[] args)
		{

//			_randomData500 = new byte[500 * 1024];
//			rand.NextBytes(_randomData500);
//			_randomData50 = new byte[50 * 1024];
//			rand.NextBytes(_randomData50);
//			_randomData5 = new byte[5 * 1024];
//			rand.NextBytes(_randomData5);


			ChannelServices.RegisterChannel(channel);

			Thread[] threads = new Thread[10];
			Console.WriteLine("Starting Threads...");
			for (int i = 0; i < threads.Length; i++)
			{
				threads[i] = new Thread(new ThreadStart(Client.DoSomething));
				threads[i].Start();
			}
			Console.WriteLine("Waiting for clients...");
			for (int i = 0; i < threads.Length; i++)
			{
				threads[i].Join();
			}
		}

		public static void DoSomething()
		{
			int clientNum;
			lock (csem)
			{
				clientCnt ++;
				clientNum = clientCnt;
			}
			Random rand = new Random(clientNum);
			ExponentialGenerator randExp = new ExponentialGenerator(0.5);

			try
			{
				ReplicatedService repService = new ReplicatedService("tcp://localhost:8081/ReplicationManager", channel,"Client"+clientNum);
				IServiceClass service = new ServiceProbe(repService, "Client"+clientNum);
				for (int i = 0; i < 100; i++)
				{
					if (rand.NextDouble() < 0.1)
					{
						byte[] data = GetData();
						service.WriteData(data);
						Console.WriteLine(data.Length + " Bytes written");
					}
					else
					{
						byte[] data = service.ReadData();
						Console.WriteLine(data.Length + " Bytes read.");
					}
					

					//Thread.Sleep((int)(50d + rand.NextDouble() * 100d));
					Thread.Sleep((int)(50d + randExp.Next() * 100d));
					
				}
				((ServiceProbe)service).Save();
				repService.Save();
			}
			catch (Exception e)
			{
				Console.WriteLine("Service call failed!");
				Console.WriteLine(e);
				Console.ReadLine();
			}
		}

		public static byte[] GetData()
		{
			return new byte[0];
//			double p = rand.NextDouble();
//			if (p<0.1)
//				return _randomData500;
//			if (p<0.4)
//				return _randomData50;
//			return _randomData5;
		}

	}
}