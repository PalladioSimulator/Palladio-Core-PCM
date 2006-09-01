using System;
using System.Reflection;
using System.Reflection.Emit;

namespace ILBenchmark
{
	/// <summary>
	/// Zusammenfassung für ILBenchmark.
	/// </summary>
	public class OpCodeAndValue
	{
		private OpCode _opcode;
		private object _value;

		public OpCodeAndValue(OpCode op, object wert)
		{
			_opcode = op;
			_value = wert;
		}

		public OpCode Code
		{
			get { return _opcode; }
			set { _opcode = value; }
		}
		public object Wert
		{
			get { return _value; }
			set { _value = value; }
		}

	}
}
