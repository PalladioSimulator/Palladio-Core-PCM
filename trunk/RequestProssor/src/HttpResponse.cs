using System.IO;
using System.Text;

namespace RequestProssor
{
	/// <summary>
	/// This class stores all information about the generated response. This inforamtion 
	/// are mime-types, status codes and the generated message for exsample. 
	/// </summary>
	public class HttpResponse
	{
		private string mineType;
		private string statusCode;
		private Stream message;
		private byte[] messageB;
		private int size;

		public HttpResponse()
		{
		}


		public byte[] MessageByte
		{
			get { return this.messageB; }
			set { this.messageB = value; }
		}

		public int FileSize
		{
			get { return this.size; }
			set { this.size = value; }
		}

		public string MineType
		{
			get { return this.mineType; }
			set { this.mineType = value; }
		}

		public string StatusCode
		{
			get { return this.statusCode; }
			set { this.statusCode = value; }
		}

		public Stream MessageToSend
		{
			get { return this.message; }
			set { this.message = value; }
		}

		public Stream ConvertStringToStream(string s)
		{
			return new MemoryStream(ASCIIEncoding.ASCII.GetBytes(s));
		}
	}
}