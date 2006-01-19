using System;
using System.Threading;
using Measurement;

namespace RemoteClient
{
	public class ServiceClass : MarshalByRefObject, IServiceClass
	{
		private byte[] _data;
		private int _max; 
		HiResTimer timer;

		public ServiceClass()
		{
			_data = new byte[_max];
			Random rand = new Random();
			rand.NextBytes(_data);
			timer = new HiResTimer();
		}

		public void WriteData(byte[] data)
		{
			_data = data;
			timer.Start();
			Thread.Sleep(100);
			timer.Stop();
			Console.WriteLine("Writer slept "+timer.ElapsedMicroseconds);

		}

		public byte[] ReadData()
		{
			timer.Start();
			Thread.Sleep(200);
			timer.Stop();
			Console.WriteLine("Reader slept " + timer.ElapsedMicroseconds);
			return _data;
		}

		public void PrintData()
		{
			Console.WriteLine("PRINT: ");
		}
	}
}