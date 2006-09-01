using System;
using System.Reflection;
using System.Reflection.Emit;

namespace ILBenchmark
{
	/// <summary>
	/// Zusammenfassung für ILBenchmark.
	/// </summary>
	public class StandartBenchmark : Benchmark
	{
		protected ILFunktion _fkt;

		public StandartBenchmark(string Name,ILFunktion f)
		{
			this._name = Name + ".exe";
			this._fullname = Name;
			_fkt = f;
			//base.ToString();
		}

		override public bool AssembleCode()
		{
			//AppDomainSetup info = new AppDomainSetup();
			//info.ApplicationBase = System.Environment.CurrentDirectory;
			//AppDomain dom = AppDomain.CreateDomain("RemoteDomain", null,info);
			AppDomain dom = AppDomain.CurrentDomain;
			Helper h = new Helper(ref dom);
			_til = h.getTIL(Name.Replace(".exe",""));
			for (int i=0;i<_fkt.Count;i++)
			{
				if (_fkt[i].Wert == null)
				{
					_til.Generator.Emit(_fkt[i].Code);
				}
				else
				{
					if (_fkt[i].Wert.GetType().Equals(typeof(System.Int32))) 
					{
						_til.Generator.Emit(_fkt[i].Code ,(int)_fkt[i].Wert);
					}
					if (_fkt[i].Wert.GetType().Equals(typeof(System.Byte))) 
					{
						_til.Generator.Emit(_fkt[i].Code ,(Byte)_fkt[i].Wert);
					}
					if (_fkt[i].Wert.GetType().Equals(typeof(System.Double))) 
					{
						_til.Generator.Emit(_fkt[i].Code ,(double)_fkt[i].Wert);
					}
					if (_fkt[i].Wert.GetType().Equals(typeof(long))) 
					{
						_til.Generator.Emit(_fkt[i].Code ,(long)_fkt[i].Wert);
					}					
					if (_fkt[i].Wert.GetType().Equals(typeof(short))) 
					{
						_til.Generator.Emit(_fkt[i].Code ,(short)_fkt[i].Wert);
					}
					if (_fkt[i].Wert.GetType().Equals(typeof(sbyte))) 
					{
						_til.Generator.Emit(_fkt[i].Code ,(sbyte)_fkt[i].Wert);
					}
					if (_fkt[i].Wert.GetType().Equals(typeof(System.String))) 
					{
						_til.Generator.Emit(_fkt[i].Code ,(string)_fkt[i].Wert);
					}
					if (_fkt[i].Wert.GetType().Equals(typeof(float))) 
					{
						_til.Generator.Emit(_fkt[i].Code ,(float)_fkt[i].Wert);
					}
				}
			}
			_type =_til.Builder.CreateType();
			return true;
		}
	}
}
