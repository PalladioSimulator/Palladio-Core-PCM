using System;
using System.IO;

namespace RequestProssor
{
	/// <summary>
	/// This class stores all information about the generated response. This inforamtion 
	/// are mime-types, status codes and the generated message for exsample. 
	/// </summary>
	public class HttPResponse
	{
		string mineType;
		string statusCode;
		Stream message;
		byte[] messageB;
		int size;
		
		public HttPResponse()
		{
		}


		public byte[] MessageByte
		{
			get{return this.messageB;}
			set{this.messageB = value;}
		}

		public int FileSize
		{
			get{return this.size;}
			set{this.size = value;}
		}

		public string MineType
		{
			get{return this.mineType;}
			set{this.mineType= value;}
		}

		public string StatusCode
		{
			get{return this.statusCode;}
			set{this.statusCode = value;}
		}

		public Stream MessageToSend
		{
			get{return this.message;}
			set{this.message = value;}
		}

		public Stream ConvertStringToStream(string s)
		{
			return new MemoryStream(System.Text.ASCIIEncoding.ASCII.GetBytes(s));
		}
	}
}
