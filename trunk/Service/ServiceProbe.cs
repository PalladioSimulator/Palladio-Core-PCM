using System;
using Measurement;
using Service;

namespace RemoteClient
{
	public class ServiceProbe : IServiceClass
	{
		IServiceClass _service;
		TimeArray writeTimes;
		TimeArray readTimes;
		private TimeArray printTimes;


		public ServiceProbe(IServiceClass service, string name)
		{
			_service = service;
			writeTimes = new TimeArray(name+"_write");
			readTimes = new TimeArray(name+"_read");
			printTimes = new TimeArray(name+"_print");
		}

		public void WriteData(byte[] data)
		{
			HiResTimer timer = new HiResTimer();
			timer.Start();
			_service.WriteData(data);
			timer.Stop();
			writeTimes.Add(timer.ElapsedMicroseconds);
		}

		public byte[] ReadData()
		{
			HiResTimer timer = new HiResTimer();
			timer.Start();
			byte[] data = _service.ReadData();
			timer.Stop();
			readTimes.Add(timer.ElapsedMicroseconds);
			return data;
		}

		public void PrintData()
		{
			HiResTimer timer = new HiResTimer();
			timer.Start();
			_service.PrintData();
			timer.Stop();
			printTimes.Add(timer.ElapsedMicroseconds);
		}

		public void Save()
		{
			writeTimes.Save();
			readTimes.Save();
			printTimes.Save();
		}
	}
}
