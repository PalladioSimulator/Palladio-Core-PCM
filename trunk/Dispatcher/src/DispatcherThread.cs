using System;
using System.Net.Sockets;
using System.Text;
using System.Collections;
using System.Threading;
using SimpleLogging;
using RequestParser;
using RequestProssor;

namespace Dispatcher
{
	/// <summary>
	/// Zusammenfassung für DispatcherThread.
	/// </summary>
	public class DispatcherThread 
	{
		
		/// <summary>
		/// The <code>Socket</code> on which the client is conntected
		/// </summary>
		/// 


		RequestProzessorComponent sendsResponse;
		RequestParserComponent parsesRequest;

		protected TcpClient clientSocket;
		protected DateTime arrivalTime;
		protected NetworkStream clientStream;
		protected SimpleLogger logger;
		protected string request;

		protected bool read;

		

		public DispatcherThread(TcpClient aSocket,DateTime now, ref RequestParserComponent parser, ref RequestProzessorComponent prozzesor )
		{

			this.sendsResponse = prozzesor;
			this.parsesRequest = parser;

			this.clientSocket = null;
			this.read = false;
			//load Logger
			this.logger = new SimpleLogger(this);
			this.logger.FileOutput=true;
			this.logger.ConsoleOutput=true;
			this.logger.DebugOutput=true;
			this.logger.InfoOutput=true;
			

			this.clientSocket= aSocket;
			this.arrivalTime = now;
			


			Thread clientThread = new Thread(new ThreadStart(StartListen));
			clientThread.Start();


		}

		
		



		public void StartListen()
		{
			//			try
			//			{
//			if(this.clientStream.DataAvailable)
//			{
				this.request = ReadRequest();
				this.request.Trim();
				//			this.logger.Debug("The Request: "+this.request);
				Console.Write(this.request);
				//			Console.Read();
				this.parsesRequest.IdentifiyAndHandleRequest(this.request,this.clientStream,this.arrivalTime, ref this.sendsResponse,this.clientSocket);
//			}
		}
//				}
//				else
//					 throw new Exception();
//			}
//			catch(Exception e)
//			{
//				Console.WriteLine(e.Message);
//				Console.WriteLine("Beende Client");
//				this.clientSocket.Close();
//			}
//		}
		public string ReadRequest()
		{
			this.logger.Debug("new Thread started");
			//			this.read=false;
//			if(this.clientStream.DataAvailable)
//			{
			Byte[] bytes = new Byte[256];
				this.request = "";
				String data = null;

				// Enter the listening loop.
				Console.WriteLine("Connected!");

				data = null;

				// Get a stream object for reading and writing
//				NetworkStream stream = this.clientSocket.GetStream();
				Thread.Sleep(1000);
				this.clientStream = this.clientSocket.GetStream();

				int i;

				string completeMessage = "";

				byte[] msg = System.Text.Encoding.ASCII.GetBytes("HTTP/1.1 200 OK\nContent-Type:text/plain;\n\n");

				// Send back a response.
//				stream.Write(msg, 0, msg.Length);

				// Loop to receive all the data sent by the client.
				while(this.clientStream.DataAvailable) 
				{   
					i=this.clientStream.Read(bytes,0,bytes.Length);

					// Translate data bytes to a ASCII string.
					data =
						System.Text.Encoding.ASCII.GetString(bytes, 0, i);
					//
//					Console.Write(String.Format("{0}", data));
					
					completeMessage += data;
				}
				msg =
					System.Text.Encoding.ASCII.GetBytes(completeMessage);
//			Console.WriteLine("DAs ist der reQUEST. "+completeMessage);
//				this.request = completeMessage;
				// Send back a response.
//				stream.Write(msg, 0, msg.Length);
				// Shutdown and end connection
//				stream.Close();
//				client.Close();
			Console.WriteLine("Jetzt gebe ich was zurück");
//			if(this.request == null)
//				Console.WriteLine("das ist leer");
//				return this.request;
				return completeMessage;
			}
			
//		}
//				this.logger.Info("\nClient Connected!!\n==================\nCLient IP" +this.clientSocket.RemoteEndPoint) ;

//				System.Collections.ArrayList
				//make a byte array and receive data from the client 
//				Byte[] receiveStream = new Byte[5000] ;
//				int i = this.clientSocket.Receive(receiveStream,receiveStream.Length,0) ;
//				try
//				{
//					Console.WriteLine("Client connected");
//					int count;
//					do
//					{
//						Byte[] receiveStream = new Byte[10024] ;
//						count =
//							this.clientSocket.Receive(receiveStream,receiveStream.Length,0) ;
//	
//						for (int i=0; i < count; i++)
//						{
//							this.request = this.request+(Char)receiveStream[i];
//							//						Console.Write((Char)receiveStream[i]);
//						
//						}
//						return this.request;
//					}
//					while(count > 0);
//					Console.WriteLine("Lost client");
//					return this.request;
//				}
////				catch(Exception e)
////				{
////					Console.WriteLine("Fehler beim Einlesen##################################");
////					this.clientSocket.Close();
////				}
////			}
//				
//				//Convert Byte to String
////				this.request = Encoding.ASCII.GetString(receiveStream);
//				
//				
//			
////			}
			
		
		public bool RequestRead
		{
			get{return this.read;}
		}
//		public void ParseRequest(string request, DateTime now,Socket clientSocket)
//		{
//			RequestProzessor parser = new RequestProzessor();
//			parser.HandleRequest(this.request);
//		}
		public DateTime ArrivalTime
		{
			get{return this.arrivalTime;}
		}
		public TcpClient ClientSocket
		{
			get{return this.clientSocket;}
		}

		public NetworkStream client
		{
			get{return this.clientStream;}
		}
		public string Request
		{
			get{return this.request;}
		}
//			
	}
}
