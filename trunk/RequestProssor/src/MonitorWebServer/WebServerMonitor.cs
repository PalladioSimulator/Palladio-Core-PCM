using System;
using System.IO;
using Request;
using System.Timers;

namespace RequestProssor.MonitorWebServer
{
	/// <summary>
	/// Zusammenfassung für TestingEventListener.
	/// </summary>
	public class WebServerMonitor
	{
		int LogFileCounter;
		int FileCount;
		string log;
		public WebServerMonitor()
		{
			this.LogFileCounter =0;
			this.FileCount=0;
			this.log ="";
		}

		public void ServedRequestReciver(Monitor sender, RequestServedEventArgs e)
		{  
			Console.WriteLine("habe ein Event bekommen!");

			TimeSpan duration = ComputeRoundTripTime(e.ServedRequest.ArrivalTime);

			WriteText(e.ServedRequest.URI+";"+e.ServedRequest.FileExtension+";"+duration.Seconds+","+duration.Milliseconds+";"+e.ServedResponse.FileSize);
			//			WriteText(DateTime.Now+";"+e.ServedRequest.URI+";"+duration.ToString());

		}

		internal TimeSpan ComputeRoundTripTime(DateTime arrival)
		{
			DateTime now = DateTime.Now;
			
			int days= now.Day - arrival.Day;
			int hour= now.Hour - arrival.Hour;
			int min = now.Minute - arrival.Minute;
			int sec = now.Second - arrival.Second;
			int mil = now.Millisecond - arrival.Millisecond;

			TimeSpan da = new TimeSpan(days,hour,min,sec,mil);
			Console.WriteLine(da.Duration());

			return new TimeSpan(days,hour,min,sec,mil).Duration();
		}

		internal string NowToString()
		{
			string da = DateTime.Now.Hour+"-"+DateTime.Now.Minute+"-"+DateTime.Now.Second;
			return da;
		}
		public void ServerShutdown(Monitor sender)
		{
			StreamWriter writer = new StreamWriter(NowToString()+"logLastLogs.csv");
			writer.WriteLine(log);
			writer.Flush();
			writer.Close();
			Console.WriteLine("Logs written - Server can be closed ....................");
		}

		
		internal void WriteText(string s)
		{
			
			try
			{
				StreamWriter w = File.AppendText("LoggingMonitor.csv");
		
		
				Log (s, w);
				// Close the writer and underlying file.
				w.Close();
			}
			catch(Exception )
			{
				Console.WriteLine("Log Lost");
			}
//			this.log = log +s+"\n";
//			this.LogFileCounter ++;
//			if(this.LogFileCounter>=1000)
//			{
//				StoreLog();
//			}
		}

		public static void Log (String logMessage, TextWriter w)
		{
//			w.Write("\r\nLog Entry : ");
			//		w.WriteLine("{0} {1}", DateTime.Now.ToLongTimeString(),
			//		DateTime.Now.ToLongDateString());
			//		w.WriteLine("  :");
			w.WriteLine(logMessage);
//			w.WriteLine ("-------------------------------");
			// Update the underlying file.
			w.Flush(); 
		}
		internal void StoreLog()
		{
			string text = this.log;
			this.log="";
			
			StreamWriter writer = new StreamWriter("log"+this.FileCount+".csv");
			writer.WriteLine("URI;Fileextension;Servetime;Size in Bytes");
			writer.WriteLine(text);
			writer.Flush();
			writer.Close();
			this.LogFileCounter =0;
			this.FileCount++;
		}
//		public static void Log (String logMessage, TextWriter w)
//		{
////			w.Write("\r\nLog Entry : ");
////			w.WriteLine("{0} {1}", DateTime.Now.ToLongTimeString(),
////				DateTime.Now.ToLongDateString());
////			w.WriteLine("  :");
////			w.WriteLine("  :{0}", logMessage);
//			w.WriteLine(logMessage);
//			w.WriteLine ("-------------------------------");
//			// Update the underlying file.
//			
//		}
		public static void DumpLog (StreamReader r)
		{
			// While not at the end of the file, read and write lines.
			String line;
			while ((line=r.ReadLine())!=null)
			{
				Console.WriteLine(line);
			}
			r.Close();
		}

	}
}
