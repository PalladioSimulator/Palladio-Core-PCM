using System;

namespace ILBenchmark
{
	/// <summary>
	/// Zusammenfassung für ILBenchmark.
	/// </summary>
	public class ILFunktion
	{
		private System.Collections.ArrayList _ar;
		
		public ILFunktion()
		{
			_ar = new System.Collections.ArrayList();
		}
		public void Add(OpCodeAndValue wert)
		{
			_ar.Add(wert);
		}
		public int Count
		{
			get { return _ar.Count; }
		}
		public OpCodeAndValue this[int index]
		{
			get { return (OpCodeAndValue)_ar[index]; }
			set { _ar[index] = value; }
		}
	}
}
