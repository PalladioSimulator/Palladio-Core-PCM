using System;
using ILBenchmark.Common.Benchmarks;
using ILBenchmark.Common;
using System.Runtime.Remoting;

namespace ILBenchmark
{
	/// <summary>
	/// Zusammenfassung für Helper.
	/// </summary>
	public class Helper
	{
		public Helper()
		{
			//
			// TODO: Fügen Sie hier die Konstruktorlogik hinzu
			//
		}

		public StandartBenchmark getRemoteStandartBenchmark(string Name,ILFunktion f)
		{
			AppDomain neueDomain = AppDomain.CreateDomain("BenchDomain");
			
			ObjectHandle obj = neueDomain.CreateInstanceFrom("ILBenchmark.Common.dll"," ILBenchmark.Common.Benchmarks.StandartBenchmark",true,System.Reflection.BindingFlags.Default,null,new Object[2] {Name, f},null,null,null );
			StandartBenchmark sb = (StandartBenchmark)obj.Unwrap();
			return sb;
		}
	}
}
