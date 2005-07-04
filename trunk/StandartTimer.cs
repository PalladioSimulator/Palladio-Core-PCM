using System;
using ILBenchmark.Common.Interfaces;

namespace ILBenchmark
{
	/// <summary>
	/// Zusammenfassung für StandartTimer.
	/// </summary>
	public class StandartTimer : MarshalByRefObject, ITimer
	{
		private int _start;
		private int _timer;

		public StandartTimer()
		{
		}
		#region ITimer Member

		public void Start()
		{
			_start = Environment.TickCount;
		}

		public ulong Stop()
		{
			_timer = Environment.TickCount - _start;
			return (ulong)_timer;
		}

		public ulong ElapsedMicroseconds
		{
			get
			{
				return (ulong)_timer;
			}
		}

		#endregion
	}
}
