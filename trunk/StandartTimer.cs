using System;
using ILBenchmark.Interfaces;

namespace ILBenchmark
{
	/// <summary>
	/// Zusammenfassung für StandartTimer.
	/// </summary>
	public class StandartTimer : ITimer
	{
		private long _start;
		private long _timer;

		public StandartTimer()
		{
		}
		#region ITimer Member

		public void Start()
		{
			_start = Environment.TickCount;
		}

		public void Stop()
		{
			_timer = Environment.TickCount - _start;
		}

		public long getElapsedTime
		{
			get
			{
				return _timer;
			}
		}

		#endregion
	}
}
