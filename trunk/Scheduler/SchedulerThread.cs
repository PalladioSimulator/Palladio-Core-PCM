using System;
using System.Collections;
using System.Net;
using System.Net.Sockets;
using System.Threading;

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
			int i=0;
			Byte[] bytes = new Byte[256];
			while(clientStream.DataAvailable) 
			{   
				i=clientStream.Read(bytes,0,bytes.Length);	// receive from client
				schedulerToServerStream.Write(bytes, 0, i); // send to server
			}
			
			// wait for answer
			int counter=0;
			Console.Write("Waiting for reply: ");
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
			Byte[] receiveBuffer = new Byte[256];
			while (schedulerToServerStream.DataAvailable)
			{
				i=schedulerToServerStream.Read(receiveBuffer,0,receiveBuffer.Length); // receive from server
				clientStream.Write(receiveBuffer, 0, i);	// send to client
			}

			clientStream.Close();
			schedulerToServer.Close();
			
		}
	}
}
