/*
class HiResTimer

	by: Shawn Van Ness
	rev: 30 Oct 2001

This simple little C# class wraps Kernel32's QueryPerformanceCounter API. 
Usage is straightforward:

	HiResTimer hrt = new HiResTimer();

	hrt.Start();
	DoSomethingLengthy();
	hrt.Stop();

	Console.WriteLine("{0}", hrt.ElapsedMicroseconds);

The hires timer API deals in unsigned, 64-bit (ulong) values, so the problem 
of rollover (or "lapping") is not an issue -- even on a box with a 1GHz timer 
frequency, 500 years will pass by before the counter laps its start position 
(and 500 years is probably far longer than the MTBF of a sizzling hot 1GHz 
Pentium). 

Because the code must P/Invoke down to Kernel32.dll, it may not be desirable 
to include in retail code.  But because it's so awkward to comment-out all of 
the references to HiResTimer (4 non-contiguous lines, in the above example!) 
I've included a handy preprocessor symbol (NOTIMER) to render the class inert.
*/



using System;
using System.Runtime.InteropServices;

namespace Palladio.QoSAdaptor
{
	/// <summary>
	/// This high resolution timer class by Shawn Van Ness has been modified such that a
	/// call to the <see cref="Stop"/> method returns <see cref="ElapsedMicroseconds"/>
	/// instead of <see cref="ElapsedTicks"/>, for convenience.
	/// 
	/// This class has been copied unchanged from the software developed by 
	/// Rico Starke in the context of his diploma thesis "Untersuchung des 
	/// Trade-Offs zwischen Performanz und Wartbarkeit von Persistenz-
	/// Frameworks für .NET".
	/// </summary>
	public class HiResTimer
	{
		// Construction

		/// <summary>
		/// Creates a new instance of the timer class.
		/// </summary>
		public HiResTimer()
		{
#if (!NOTIMER)
			a = b = 0UL;
			QueryPerformanceFrequency( out f);
#endif
		}

		// Properties

		/// <summary>
		/// Gets the number of elapsed ticks for the 
		/// timespan between the most recent calls of
		/// <see cref="Start"/> and <see cref="Stop"/>.
		/// </summary>
		public ulong ElapsedTicks
		{
#if (!NOTIMER)
			get
			{ return (b-a); }
#else
		get
		{ return 0UL; }
#endif
		}

		/// <summary>
		/// Gets the number of elapsed microseconds for the 
		/// timespan between the most recent calls of
		/// <see cref="Start"/> and <see cref="Stop"/>.
		/// </summary>
		public ulong ElapsedMicroseconds
		{
#if (!NOTIMER)
			get
			{ 
				ulong d = (b-a); 
				if (d < 0x10c6f7a0b5edUL) // 2^64 / 1e6
					return (d*1000000UL)/f; 
				else
					return (d/f)*1000000UL;
			}
#else
		get
		{ return 0UL; }
#endif
		}

		/// <summary>
		/// Gets the <see cref="System.TimeSpan"/> between the most
		/// recent calls of <see cref="Start"/> and <see cref="Stop"/>.
		/// </summary>
		public TimeSpan ElapsedTimeSpan
		{
#if (!NOTIMER)
			get
			{ 
				ulong t = 10UL*ElapsedMicroseconds;
				if ((t&0x8000000000000000UL) == 0UL)
					return new TimeSpan((long)t);
				else
					return TimeSpan.MaxValue;
			}
#else
		get
		{ return TimeSpan.Zero; }
#endif
		}

		/// <summary>
		/// Gets the frequency of the timer.
		/// </summary>
		public ulong Frequency
		{
#if (!NOTIMER)
			get
			{ return f; }
#else
		get
		{ return 1UL; }
#endif
		}

		// Methods

		/// <summary>
		/// Starts a new timer measurement period.
		/// </summary>
		public void Start()
		{
#if (!NOTIMER)
			QueryPerformanceCounter( out a);
#endif
		}

		/// <summary>
		/// Stops the timer and returns the number of
		/// elapsed microseconds.
		/// </summary>		
		public ulong Stop()
		{
#if (!NOTIMER)
			QueryPerformanceCounter( out b);
			return ElapsedMicroseconds; // modified
#else
		return 0UL;
#endif
		}

		// Implementation

#if (!NOTIMER)
		[System.Security.SuppressUnmanagedCodeSecurity()]
		[ DllImport("kernel32.dll") ]
		private static extern 
			int QueryPerformanceFrequency( out ulong x);

		[System.Security.SuppressUnmanagedCodeSecurity()]
		[ DllImport("kernel32.dll") ]
		private static extern 
			int QueryPerformanceCounter( out ulong x);

		/// <summary>
		/// Represents the starting time of the current timing operation.
		/// </summary>
		private ulong a;
		
		/// <summary>
		/// Represents the ending time of the current timing operation.
		/// </summary>
		private ulong b;
		
		/// <summary>
		/// Represents the ending time of the current timing operation.
		/// </summary>
		private ulong f;
#endif
	}
}
