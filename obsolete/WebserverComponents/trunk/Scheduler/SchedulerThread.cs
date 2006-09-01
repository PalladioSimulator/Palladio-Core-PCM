using System;
using System.Collections;
using System.Net;
using System.Net.Sockets;
using System.Threading;
using System.Text;


namespace Scheduler
{
	/// <summary>
	/// Summary description for SchedulerThread.
	/// </summary>
	public class SchedulerThread
	{
		private TcpClient tcpClient;
		private IPEndPoint serverEndPoint;
		
		public SchedulerThread(TcpClient aClient, IPEndPoint aEndPoint)
		{
			this.tcpClient = aClient;
			this.serverEndPoint = aEndPoint;
			
			Thread clientThread = new Thread(new ThreadStart(ForwardRequest));
			clientThread.Start();
		}

		protected void ForwardRequest()
		{
			// open server connection
			TcpClient schedulerToServer = new TcpClient();
			schedulerToServer.Connect(this.serverEndPoint);
			NetworkStream schedulerToServerStream = schedulerToServer.GetStream();
			
			// transmit client request to web server
			NetworkStream clientStream = this.tcpClient.GetStream();			
			
			// wait for request
			Console.Write("Waiting for Client: ");
			int counter=0;
			while (!clientStream.DataAvailable) 
			{
				Thread.Sleep(100);
				counter+=100;
				Console.Write(counter + " ");
				if (counter >= 5000) 
				{
					Console.WriteLine("\r\nClient Connection Timeout (5000 ms)." );
					clientStream.Close();
					schedulerToServer.Close();
					return;
				}
			} 
			Console.WriteLine();

			// transmit request to selected web-server
			int i=0;
			Byte[] bytes = new Byte[1024];
			while(clientStream.DataAvailable) 
			{   
				i=clientStream.Read(bytes,0,bytes.Length);	// receive from client
				string data = System.Text.Encoding.ASCII.GetString(bytes);
				//Console.WriteLine("**** sending: "+data);
				schedulerToServerStream.Write(bytes, 0, i); // send to server
			}
			
			// wait for answer
			counter=0;
			Console.Write("Waiting for Web-Server: ");
			while (!schedulerToServerStream.DataAvailable) 
			{
				Thread.Sleep(100);
				counter+=100;
				Console.Write(counter + " ");
				if (counter >= 5000) 
				{
					Console.WriteLine("\r\nServer Connection Timeout (5000 ms)." );
					clientStream.Close();
					schedulerToServer.Close();
					return;
				}
			} 
			Console.WriteLine();

			// transmit web server response to client
			i=0;
			Byte[] receiveBuffer = new Byte[1024];
			while (schedulerToServerStream.DataAvailable)
			{
				i=schedulerToServerStream.Read(receiveBuffer,0,receiveBuffer.Length); // receive from server
				string data = System.Text.Encoding.ASCII.GetString(receiveBuffer);
				//Console.WriteLine("**** receiving: "+data);
				clientStream.Write(receiveBuffer, 0, i);	// send to client
			}

			clientStream.Close();
			schedulerToServer.Close();
			
		}
	}
}
