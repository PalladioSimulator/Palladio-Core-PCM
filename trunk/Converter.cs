using System;
using System.IO;

namespace Time2Pdf
{
	/// <summary>
	/// Zusammenfassung für Class1.
	/// </summary>
	internal class Converter
	{
		private static int samplingRate;
		private static int maxTime;

		/// <summary>
		/// Der Haupteinstiegspunkt für die Anwendung.
		/// </summary>
		[STAThread]
		private static void Main(string[] args)
		{
			samplingRate = int.Parse(args[0]);
			maxTime = int.Parse(args[1]);
			string fileName = args[2];
			int ignore = int.Parse(args[3]);

			double[] pdf = new double[maxTime/samplingRate];
			ulong maxtime = 0;
			double numElems = 0;
			double cntValues = 0;

			using (StreamReader reader = new StreamReader(fileName))
			{
				for (int i = 0; i < ignore; i++)
				{
					reader.ReadLine();
				}
				string line;
				while ((line = reader.ReadLine()) != null)
				{
					ulong time = ulong.Parse(line);
					int pos = (int) (time/(ulong) samplingRate);
					if (pos < pdf.Length)
					{
						pdf[pos] += 1;
						cntValues += 1;
					}
					if (maxtime < time) maxtime = time;
					numElems += 1;
				}
				for (int i = 0; i < pdf.Length; i++)
				{
					pdf[i] /= numElems;
				}
				double sum = pdf[0];
				using (StreamWriter sw = new StreamWriter("PMF_" + fileName))
				{
					sw.Write(pdf[0]);
					for (int i = 1; i < pdf.Length; i++)
					{
						sw.Write("\n" + pdf[i]);
						sum += pdf[i];
					}
				}
				Console.WriteLine(sum);
				Console.WriteLine((double) cntValues/(double) numElems);
				Console.WriteLine(maxtime);
			}
		}
	}
}