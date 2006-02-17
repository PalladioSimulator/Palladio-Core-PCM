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
using System.Security;

namespace Measurement
{

	/// <summary>
	/// High resolution timer.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2006/01/19 13:23:34  sliver
	/// initial version
	///
	/// Revision 1.1  2005/08/12 07:59:19  helgeh
	/// Initial impot after refactoring.
	///
	/// Math:
	/// - Added DiscretePDFunction.
	/// - Added Fast Fourier Transformation and FourierFunction.
	/// - Changed operations of DiscreteFunction. The operations are independent of the sampling rate. For a probability density  function the sum of function values is a value in [0,1].
	/// - Added to interface IDiscreteFunction: Sum,ExpandDomainPo2, Crop, NumberOfNullValues, AdjustSamplingRate,  FunctionWithNValues, ToFile, ValueAt, DismissValuesSmalerThanN, ValueOf, MaximumDataValue
	/// - Altered MEthods: ExpandDomain, Scale, GetScaled, Convolution, Add
	///
	/// FSMTransformer:
	/// - Method SEFFValidity added.
	/// - The Method FSMWithIntermediateState now returns a FSM, where all time consumption is contained by the input symbols of the  transitions.
	///
	/// WebserverSeffFactory:
	/// - All service effect automaton are now IFiniteStateMachines. No use of the PAlladio.ComponentModel.
	///
	/// WebserverAnalyser:
	/// - Data class for configuration added.
	/// - ConfigReader added.
	///
	/// RegExASTVisitor:
	/// - There are now two visitors. One for the calculation in time domain and one for the calculation in frequency domain.
	///
	/// RegularExpressions:
	/// - No changes.
	///
	/// XmlSeffParser:
	/// - Data class for configuration added.
	/// - ConfigReader added.
	///
	/// PerformanceCalculator:
	/// - Added interface IPerformanceCalculator. Added CalculatorFactory.
	///
	/// Unit Tests added.
	/// Updated documentation.
	///
	/// 
	/// </pre>
	/// </remarks>
	public class HiResTimer
	{
		// Construction

		/// <summary>
		/// Constructor. Initalizes a new high resolution timer.
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
		/// Elapsed ticks from the start of the timer to the last stop.
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
		/// Elapsed microseconds from the start of the timer to the last stop.
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
		/// 
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
		/// 
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
		/// Starts the timer.
		/// </summary>
		public void Start()
		{
#if (!NOTIMER)
			QueryPerformanceCounter( out a);
#endif
		}

		/// <summary>
		/// Stops the timer.
		/// </summary>
		/// <returns>Elapsed Ticks from the start.</returns>
		public ulong Stop()
		{
#if (!NOTIMER)
			QueryPerformanceCounter( out b);
			return ElapsedTicks;
#else
		return 0UL;
#endif
		}

		// Implementation

#if (!NOTIMER)
		[SuppressUnmanagedCodeSecurity()]
		[ DllImport("kernel32.dll") ]
		private static extern 
			int QueryPerformanceFrequency( out ulong x);

		[SuppressUnmanagedCodeSecurity()]
		[ DllImport("kernel32.dll") ]
		private static extern 
			int QueryPerformanceCounter( out ulong x);

		private ulong a, b, f;
#endif
	}


}