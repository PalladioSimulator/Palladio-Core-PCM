using System;
using System.IO;
using System.Text;

namespace Measurement.RandomNumbers
{
	/// <summary>
	/// Zusammenfassung für Zufallszahl.
	/// </summary>
	public class RandomNumbers
	{
		static int i = 0;
		static int[] values = new int[2000];

		public RandomNumbers()
		{
			values = RandomDotOrgHttp.GetRandomNumbers(1,10000,500);
			// Erzeugen eine File-Streams für die Ausgabe zur Weiterverwertung mit Excel
			FileStream fs = new FileStream("zufallszahlen.txt",FileMode.OpenOrCreate,FileAccess.Write);
			StreamWriter sw = new StreamWriter(fs, Encoding.Unicode);
			sw.BaseStream.Seek(0,SeekOrigin.End);
			sw.WriteLine("Zufallszahlen: ");
			for(int j=0;j<values.Length;j++)
			{
				sw.WriteLine(values[j]);
			}
			sw.Close();
			fs.Close();
		}

		public static double nextDouble() 
		{
			//return ((double)Zufallszahlen.RandomDotOrgHttp.GetSingleRandomNumber(1,10000))/10000;
			double rand = ((double)values[i]) /10000;
			i++;
			Console.WriteLine("rand1: " + rand);
			return rand;
		}
		public static double nextDouble2() 
		{
			//return ((double)Zufallszahlen.RandomDotOrgHttp.GetSingleRandomNumber(1,10000))/10000;
			double rand = ((double) values[2000-i]) /10000;
			Console.WriteLine("rand2: " + rand);
			return rand;
		}
	}
}
