using System;

namespace ILBenchmark.Interfaces
{
	/// <summary>
	/// Zusammenfassung für ITimer.
	/// </summary>
	public interface ITimer
	{
		void Start();
		void Stop();
		long getElapsedTime
		{
			get;
		}
	}
}
