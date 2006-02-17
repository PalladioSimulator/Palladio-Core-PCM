#region MathNet Numerics, Copyright ©2004 Christoph Ruegg 

// MathNet Numerics, part of MathNet
//
// Copyright (c) 2004,	Christoph Ruegg, http://www.cdrnet.net
//
// This program is free software; you can redistribute it and/or modify
// it under the terms of the GNU Lesser General Public License as published 
// by the Free Software Foundation; either version 2 of the License, or
// (at your option) any later version.
//
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public 
// License along with this program; if not, write to the Free Software
// Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.

#endregion

using System;

namespace MathNet.Numerics
{
	/// <summary>
	/// Static DoublePrecision Trigonometry Helper Class
	/// </summary>
	public sealed class Trig
	{
		private Trig() {}

		#region Angle Conversion
		/// <summary>
		/// Converts a degree (360-periodic) angle to a radiant (2*Pi-periodic) angle. 
		/// </summary>
		public static double DegreeToRadiant(double degree)
		{
			return degree/180*Math.PI;
		}
		/// <summary>
		/// Converts a radiant (2*Pi-periodic) angle to a degree (360-periodic) angle. 
		/// </summary>
		public static double RadiantToDegree(double radiant)
		{
			return radiant/Math.PI*180;
		}
		/// <summary>
		/// Converts a newgrad (400-periodic) angle to a radiant (2*Pi-periodic) angle. 
		/// </summary>
		public static double NewgradToRadiant(double newgrad)
		{
			return newgrad/200*Math.PI;
		}
		/// <summary>
		/// Converts a radiant (2*Pi-periodic) angle to a newgrad (400-periodic) angle. 
		/// </summary>
		public static double RadiantToNewgrad(double radiant)
		{
			return radiant/Math.PI*200;
		}
		/// <summary>
		/// Converts a degree (360-periodic) angle to a newgrad (400-periodic) angle. 
		/// </summary>
		public static double DegreeToNewgrad(double degree)
		{
			return degree/9*10;
		}
		/// <summary>
		/// Converts a newgrad (400-periodic) angle to a degree (360-periodic) angle. 
		/// </summary>
		public static double NewgradToDegree(double newgrad)
		{
			return newgrad/10*9;
		}
		#endregion

		#region Trigonometric Functions
		/// <summary>Trigonometric Sine (Sinus) of an angle in radians</summary>
		public static double Sin(double angleRadians) 
		{
			return Math.Sin(angleRadians);
		}
		/// <summary>Trigonometric Cosine (Cosinus) of an angle in radians</summary>
		public static double Cos(double angleRadians) 
		{
			return Math.Cos(angleRadians);
		}
		/// <summary>Trigonometric Tangent (Tangens) of an angle in radians</summary>
		public static double Tan(double angleRadians) 
		{
			return Math.Tan(angleRadians);
		}
		/// <summary>Trigonometric Cotangent (Cotangens) of an angle in radians</summary>
		public static double Cot(double angleRadians) 
		{
			return 1/Math.Tan(angleRadians);
		}
		/// <summary>Trigonometric Secant (Sekans) of an angle in radians</summary>
		public static double Sec(double angleRadians) 
		{
			return 1/Math.Cos(angleRadians);
		}
		/// <summary>Trigonometric Cosecant (Cosekans) of an angle in radians</summary>
		public static double Csc(double angleRadians) 
		{
			return 1/Math.Sin(angleRadians);
		}
		#endregion

		#region Trigonometric Arcus Functions
		/// <summary>Trigonometric Arcus Sine (Arkussinus) in radians</summary>
		public static double Asin(double length)
		{
			return Math.Asin(length);
		}
		/// <summary>Trigonometric Arcus Cosine (Arkuscosinus) in radians</summary>
		public static double Acos(double length)
		{
			return Math.Acos(length);
		}
		/// <summary>Trigonometric Arcus Tangent (Arkustangens) in radians</summary>
		public static double Atan(double length)
		{
			return Math.Atan(length);
		}
		/// <summary>The principal argument (in radians) of the complex number x+I*y</summary>
		/// <param name="nominator">y</param>
		/// <param name="denominator">x</param>
		public static double ArcusTangentFromRational(double nominator, double denominator)
		{
			return Math.Atan2(nominator,denominator);
		}
		/// <summary>Trigonometric Arcus Cotangent (Arkuscotangens) in radians</summary>
		public static double Acot(double length)
		{
			return Math.Atan(1/length);
		}
		/// <summary>Trigonometric Arcus Secant (Arkussekans) in radians</summary>
		public static double Asec(double length)
		{
			return Math.Acos(1/length);
		}
		/// <summary>Trigonometric Arcus Cosecant (Arkuscosekans) in radians</summary>
		public static double Acsc(double length)
		{
			return Math.Asin(1/length);
		}
		#endregion

		#region Hyperbolic Functions
		/// <summary>Trigonometric Hyperbolic Sine (Sinus hyperbolicus)</summary>
		public static double Sinh(double x) 
		{
			//NOT SUPPORTED BY COMPACT FRAMEWORK!!???
			//return Math.Sinh(x)
			return (Math.Exp(x)-Math.Exp(-x))/2;
		}
		/// <summary>Trigonometric Hyperbolic Cosine (Cosinus hyperbolicus)</summary>
		public static double Cosh(double x) 
		{
			//NOT SUPPORTED BY COMPACT FRAMEWORK!!???
			//return Math.Cosh(x);
			return (Math.Exp(x)+Math.Exp(-x))/2;
		}
		/// <summary>Trigonometric Hyperbolic Tangent (Tangens hyperbolicus)</summary>
		public static double Tanh(double x) 
		{
			//NOT SUPPORTED BY COMPACT FRAMEWORK!!???
			//return Math.Tanh(x);
			double e1 = Math.Exp(x);
			double e2 = Math.Exp(-x);
			return (e1-e2)/(e1+e2);
		}
		/// <summary>Trigonometric Hyperbolic Cotangent (Cotangens hyperbolicus)</summary>
		public static double Coth(double x) 
		{
			//NOT SUPPORTED BY COMPACT FRAMEWORK!!???
			//return 1/Math.Tanh(x);
			double e1 = Math.Exp(x);
			double e2 = Math.Exp(-x);
			return (e1+e2)/(e1-e2);
		}
		/// <summary>Trigonometric Hyperbolic Secant (Sekans hyperbolicus)</summary>
		public static double Sech(double x) 
		{
			return 1/Cosh(x);
		}
		/// <summary>Trigonometric Hyperbolic Cosecant (Cosekans hyperbolicus)</summary>
		public static double Csch(double x) 
		{
			return 1/Sinh(x);
		}
		#endregion

		#region Hyperbolic Area Functions
		/// <summary>Trigonometric Hyperbolic Area Sine (Areasinus hyperbolicus)</summary>
		public static double Asinh(double x) 
		{
			return Math.Log(x+Math.Sqrt(x*x+1),Math.E);
		}
		/// <summary>Trigonometric Hyperbolic Area Cosine (Areacosinus hyperbolicus)</summary>
		public static double Acosh(double x) 
		{
			return Math.Log(x+Math.Sqrt(x-1)*Math.Sqrt(x+1),Math.E);
		}
		/// <summary>Trigonometric Hyperbolic Area Tangent (Areatangens hyperbolicus)</summary>
		public static double Atanh(double x) 
		{
			return Math.Log((1+x)/(1-x),Math.E)/2;
		}
		/// <summary>Trigonometric Hyperbolic Area Cotangent (Areacotangens hyperbolicus)</summary>
		public static double Acoth(double x) 
		{
			return Math.Log((x+1)/(x-1),Math.E)/2;
		}
		/// <summary>Trigonometric Hyperbolic Area Secant (Areasekans hyperbolicus)</summary>
		public static double Asech(double x)
		{
			return Acosh(1/x);
		}
		/// <summary>Trigonometric Hyperbolic Area Cosecant (Areacosekans hyperbolicus)</summary>
		public static double Acsch(double x)
		{
			return Asinh(1/x);
		}
		#endregion
	}
}
