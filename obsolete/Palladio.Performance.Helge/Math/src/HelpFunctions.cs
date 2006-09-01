using System;
using System.IO;
using System.Text;

namespace Palladio.Performance.Math
{
	/// <summary>
	/// Zusammenfassung für HelpFunctions.
	/// </summary>
	public class HelpFunctions
	{
		#region Data
		// Erzeugen eine File-Streams für die Ausgabe zur Weiterverwertung mit Excel
		static FileStream fs = null;
		static StreamWriter sw = null;
		//static bool init = false;

		#endregion

		public HelpFunctions()
		{
			//
			// TODO: Fügen Sie hier die Konstruktorlogik hinzu
			//
		}

		public static void init() 
		{
			fs= new FileStream("L:\\Helges Dateien\\Visual Studio Projects\\Visitor.txt",FileMode.Create,FileAccess.Write);
			sw = new StreamWriter(fs, Encoding.Unicode);
			sw.BaseStream.Seek(0,SeekOrigin.End);
		}

		public static void CleanUp() 
		{
			sw.Close();
			fs.Close();
		}

		#region HelpFunctions

		public static void WriteToFile(string s) 
		{
			sw.WriteLine(s);
		}

		public static void PrintFunction(IDiscreteFunction f) 
		{
			sw.WriteLine("Wertebereich:");
			for (int i=0;i<f.Count;i++)
			{
				sw.WriteLine(f.XMin + i*f.SamplingRate);
			}

			double x = 0;
			for (int i=0;i<f.Count;i++) 
			{
				sw.WriteLine(f.Data[i]);
				Console.Write(f.Data[i] + ", ");
				x += f.Data[i];
			}
			Console.WriteLine("P: " + x);
		}
		#endregion HelpFunctions

	}
}
