using System;
using System.IO;
using System.Runtime.Remoting.Channels.Tcp;
using Measurement;
using RemoteClient;
using Service;

namespace ServiceReplication
{
	public class DirectServiceProxy : IServiceClass
	{
		private TcpChannel channel = null;
		private IServiceClass service;

		public DirectServiceProxy(string objectURI, TcpChannel channel)
		{
			this.channel = channel;
			service = (ServiceClass) Activator.GetObject(typeof (ServiceClass), objectURI);
		}

		public void WriteData(byte[] data)
		{
			if (service == null)
				throw new ApplicationException("Service could not be initialised.");
			service.WriteData(data);
		}

		public byte[] ReadData()
		{
			if (service == null)
				throw new ApplicationException("Service could not be initialised.");
			return service.ReadData();
		}

		public void PrintData()
		{
			if (service == null)
				throw new ApplicationException("Service could not be initialised.");
			service.PrintData();
		}
	}
}