using System;
using System.Threading;
using Measurement;
using MathNet.Numerics.Generators;

namespace RemoteClient
{
	public class ServiceClass : MarshalByRefObject, IServiceClass
	{
		private byte[] _data;
		private int _max; 
		HiResTimer timer;
		ExponentialGenerator randExp;

		public ServiceClass()
		{
			_data = new byte[_max];
			Random rand = new Random();
			rand.NextBytes(_data);
			randExp = new ExponentialGenerator(0.5);
			timer = new HiResTimer();
		}

		public void WriteData(byte[] data)
		{
			_data = data;
			timer.Start();
			Thread.Sleep((int) (randExp.Next() * 10d));
			timer.Stop();
			Console.WriteLine("Writer slept "+timer.ElapsedMicroseconds);

		}

		public byte[] ReadData()
		{
			timer.Start();
			Thread.Sleep((int) (randExp.Next() * 20d));
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