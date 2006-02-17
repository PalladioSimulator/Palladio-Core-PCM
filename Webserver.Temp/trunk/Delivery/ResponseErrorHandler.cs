using System;
using System.IO;
using System.Text;
using Request;

namespace Delivery
{
	/// <summary>
	/// Zusammenfassung für ErrorHandler.
	/// </summary>
	public class ResponseErrorHandler : IResponseHandler
	{
		private string errorMessage;

		public int GetFileSize
		{
			get { return GenerateErrorMessage(errorMessage).Length; }
		}

		private IResponseHandler successor;
		private string statusCode;

		public ResponseErrorHandler()
		{
			errorMessage = "An error occured in the delivery chain!";
		}

		public IResponseHandler GetResponsibleHandler(HttpRequest r, string path)
		{
			if (FileNotFound(r,path))
			{
				errorMessage = "Error 404 File not found!";
				statusCode = " 404 File Not Found";
			}
			return this;
		}

		public Stream GetResponseStream()
		{
			return new MemoryStream(GenerateErrorMessage(errorMessage));
		}

		public byte[] GetResponse
		{
			get { return GenerateErrorMessage(errorMessage); }
		}

		public DateTime LastModified()
		{
			return DateTime.Now;
		}

		public string StatusCode
		{
			get { return statusCode; }
		}

		public IResponseHandler Sucessor
		{
			get { return this.successor; }
			set { this.successor = value; }
		}

		private bool FileNotFound(HttpRequest r, string path)
		{
			return ((r.RequestedMethod=="GET") && (r.UserInput==null) && !File.Exists(path));
		}

		private byte[] GenerateErrorMessage(string message)
		{
			string reply = "<html><head><title>An Error occurred!</title></head>";
			reply = reply + "<body>" + message + "</body></html>";
			return Encoding.ASCII.GetBytes(reply);
		}


	}
}