using System;
using Request;
using System.IO;

namespace Delivery
{
	/// <summary>
	/// Zusammenfassung für ErrorHandler.
	/// </summary>
	public class ErrorHandler : IDeliverResponse
	{

		public int GetFileSize
		{
			get
			{
				return "An error occured in the delivery chain".Length;
			}
		}
		IDeliverResponse successor;
		public ErrorHandler() 
		{
			
		}

		public IDeliverResponse DeliverResonse(HttpRequest r,string path)
		{
			return this;
		}

		public Stream DeliverResponseStream()
		{
			return new MemoryStream(System.Text.ASCIIEncoding.ASCII.GetBytes("An error occured in the delivery chain"));
		}
//		public byte[] GetResponse(HttpRequest r)
//		{
//			return System.Text.ASCIIEncoding.ASCII.GetBytes("An error occured in the delivery chain");
//
//		}
		public byte[] GetResponse
		{
			get
			{
				return System.Text.ASCIIEncoding.ASCII.GetBytes("An error occured in the delivery chain");
			}
		}

		public DateTime LastModified()
		{
			return DateTime.Now;
		}

		public IDeliverResponse Sucessor
		{
			get{return this.successor;}
			set{this.successor=value;}
		}

	}
}
