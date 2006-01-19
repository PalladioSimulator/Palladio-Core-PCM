using System;
using System.IO;

namespace Service
{
	/// <summary>
	/// Zusammenfassung für TimerArray.
	/// </summary>
	public class TimeArray
	{
		private int _size;
		private ulong[] _data;
		int _pos;
		string _fileName;
		int samplingRate = 100;
		int maxTime = 1000000;

		public int Size
		{
			get { return _size; }
		}

		public ulong[] Data
		{
			get { return _data; }
		}

		public TimeArray(string fileName)
		{
			_size = 11000;
			_data = new ulong[Size];
			_pos = 0;
			_fileName = fileName;
		}

		public void Add(ulong val)
		{
			Data[_pos] = val;
			_pos++;
		}

		public void Save()
		{
			using(StreamWriter sw = new StreamWriter(_fileName+".csv"))
			{
				sw.Write(_data[0]);
				for (int i=1; i<_pos; i++)
				{
					sw.Write("\n" + _data[i]);
				}
			}
		}

		public void SavePDF()
		{
			double[] pdf = new double[maxTime/samplingRate];
			
			int start = _pos / 10; // omit the 10% first values.
			for (int i=start; i<_pos; i++)
			{
				int pos = (int) (_data[i] / (ulong)samplingRate);
				pdf[pos] += 1;
			}

			double divisor = _pos - start;

			for (int i =0; i<pdf.Length; i++)
			{
				pdf[i] /= divisor;
			}

			using(StreamWriter sw = new StreamWriter("PMF_"+_fileName+".csv"))
			{
				sw.Write(pdf[0]);
				for (int i=1; i<pdf.Length; i++)
				{
					sw.Write("\n" + pdf[i]);
				}
			}			
		}

	}
}
