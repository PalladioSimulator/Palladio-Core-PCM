#region Copyright 2001-2003 Christoph Daniel Rüegg [Modified BSD License]
/*
Math.NET, a symbolic math library
Copyright (c) 2001-2003, Christoph Daniel Rueegg, http://cdrnet.net/. All rights reserved.

Redistribution and use in source and binary forms, with or without modification,
are permitted provided that the following conditions are met:

1. Redistributions of source code must retain the above copyright notice,
this list of conditions and the following disclaimer. 

2. Redistributions in binary form must reproduce the above copyright notice,
this list of conditions and the following disclaimer in the documentation
and/or other materials provided with the distribution.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
THE POSSIBILITY OF SUCH DAMAGE.
*/
#endregion

using System;

namespace cdrnet.Lib.MathLib.Core
{
	internal class MathHelper
	{
		/// <summary>
		/// EvaluateGcd calculates the greatest common divisor (gcd, aka ggT) of the two parameters a and b
		/// </summary>
		public static double EvaluateGcd(double a, double b)
		{
			if(a > b)
				return(RecursiveGcd(Math.Abs(a),Math.Abs(b)));
			else
				return(RecursiveGcd(Math.Abs(b),Math.Abs(a)));
		}
		private static double RecursiveGcd(double a, double b)
		{
			if(b>0)
			{
				return(RecursiveGcd(b,a%b));
			}
			return(a);
		}
		/// <summary>
		/// swaps two integer variables
		/// </summary>
		public static void Swap(ref int a, ref int b)
		{
			int c = a;
			a = b;
			b = c;
		}
		/// <summary>
		/// swaps two integer values so that the first is smaller then the second.
		/// </summary>
		public static void MinMax(ref int a, ref int b)
		{
			if(a > b)
				Swap(ref a, ref b);
		}
		/// <summary>
		/// normalizes two integer so that they're inside of [0..length[ (using modulo length) and the the first one is smaller than the second
		/// </summary>
		public static void NormalizeMinMaxSpan(ref int a, ref int b, int length)
		{
			a %= length;
			b %= length;
			if(a < 0)
				a += length;
			if(b < 0)
				b += length;
			if(a > b)
				Swap(ref a, ref b);
		}
	}
}
