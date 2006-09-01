using System;
using System.Text;

namespace ThreadedRequestProzessor
{
	/// <summary>
	/// Zusammenfassung für ErrorHandler.
	/// </summary>
	public class ErrorHandler
	{
		public ErrorHandler()
		{
			
		}

//		private byte[] GenerateErrorside(string message){}

		internal byte[] GenerateErrorMessage(string message)
		{
			string reply = "<html><head><title>Sorry,,,,</title></head>";
			reply=reply+"<body>"+message+"</body></html>";
			return Encoding.ASCII.GetBytes(reply);
		}

		internal int ErrorMessageSize(string message)
		{
			int iTotBytes=0;
			string sRespone="";
			string reply = "<html><head><title>Sorry,,,,</title></head>";
//			reply=reply+"<body>"+message+"</body></html>";
//			byte[] bytes =  Encoding.ASCII.GetBytes(reply);
//			
////			byte[] bytes = new byte[fs.Length];
//			int read;
//			while((read = reader.Read(bytes, 0, bytes.Length)) != 0) 
//			{
//				// Read from the file and write the data to the network
//				sResponse = sResponse + Encoding.ASCII.GetString(bytes,0,read);
//				iTotBytes = iTotBytes + read;
//			}
//			reader.Close(); 
//			fs.Close();
		
		
			return iTotBytes;
		}
	}
}
