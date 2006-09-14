using System.IO;

namespace RemoteClient
{
	public interface IServiceClass
	{
		void WriteData(byte[] data);
		byte[] ReadData();
		void PrintData();
	}
}