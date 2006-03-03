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
using System.Collections;
using System.IO;
using System.Runtime.InteropServices;

public class HiResTimer
{
	// Construction

	public HiResTimer()
	{
#if (!NOTIMER)
		a = b = 0UL;
		QueryPerformanceFrequency( out f);
#endif
	}

	// Properties

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

	public ulong ElapsedMicroseconds
	{
#if (!NOTIMER)
		get
		{ 
			return ToMicroSeconds(b-a);
		}
#else
		get
		{ return 0UL; }
#endif
	}

	public ulong StartTime
	{
		get
		{
			return ToMicroSeconds(a);
		}
	}

	public ulong StopTime
	{
		get
		{
			return ToMicroSeconds(b);
		}
	}

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

	public void Start()
	{
#if (!NOTIMER)
		QueryPerformanceCounter( out a);
#endif
	}

	public ulong Stop()
	{
#if (!NOTIMER)
		QueryPerformanceCounter( out b);
		return ElapsedTicks;
#else
		return 0UL;
#endif
	}

	private ulong ToMicroSeconds(ulong d)
	{
		if (d < 0x10c6f7a0b5edUL) // 2^64 / 1e6
			return (d*1000000UL)/f; 
		else
			return (d/f)*1000000UL;
	}

	
	// Implementation

#if (!NOTIMER)
	[System.Security.SuppressUnmanagedCodeSecurity()]
	[ DllImport("kernel32.dll") ]
	protected static extern 
		int QueryPerformanceFrequency( out ulong x);

	[System.Security.SuppressUnmanagedCodeSecurity()]
	[ DllImport("kernel32.dll") ]
	protected static extern 
		int QueryPerformanceCounter( out ulong x);

	protected ulong a, b, f;
#endif
}
