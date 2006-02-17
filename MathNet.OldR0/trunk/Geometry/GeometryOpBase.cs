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
using cdrnet.Lib.MathLib.Core;
using cdrnet.Lib.MathLib.Exceptions;
using cdrnet.Lib.MathLib.Scalar;

namespace cdrnet.Lib.MathLib.Scalar.Geometry
{
	#region Triple Parameters
	public class Triple1Parameters: Parameters
	{
		private ITripleExpression triple1;
		public Triple1Parameters() : base(1) {}
		public Triple1Parameters(ITripleExpression t1) : base(1)
		{
			triple1 = t1;
		}
		public ITripleExpression Triple1
		{
			get {return triple1;}
			set {triple1 = value;}
		}
		public override void ConvertChilds(string conversionType)
		{
			TripleConversionMap.Convert(ref triple1, conversionType);
		}
		public override Parameters Simplify()
		{
			return new Triple1Parameters(triple1.Simplify());
		}
		public override Parameters Expand()
		{
			return new Triple1Parameters(Triple1.Expand());
		}
		public override Parameters Substitute(IExpression original, IExpression replacement)
		{
			return new Triple1Parameters(triple1.Substitute(original,replacement));
		}
		public override IExpression this[int index]
		{
			get
			{
				switch(index)
				{
					case 0:
						return triple1;
					default:
						throw new IndexOutOfRangeException();
				}
			}
		}
	}
	public class Triple2Parameters: Parameters
	{
		private ITripleExpression triple1, triple2;
		public Triple2Parameters() : base(2) {}
		public Triple2Parameters(ITripleExpression t1, ITripleExpression t2) : base(2)
		{
			triple1 = t1;
			triple2 = t2;
		}
		public ITripleExpression Triple1
		{
			get {return triple1;}
			set {triple1 = value;}
		}
		public ITripleExpression Triple2
		{
			get {return triple2;}
			set {triple2 = value;}
		}
		public override void ConvertChilds(string conversionType)
		{
			TripleConversionMap.Convert(ref triple1, conversionType);
			TripleConversionMap.Convert(ref triple2, conversionType);
		}
		public override Parameters Simplify()
		{
			return new Triple2Parameters(triple1.Simplify(),triple2.Simplify());
		}
		public override Parameters Expand()
		{
			return new Triple2Parameters(triple1.Expand(),triple2.Expand());
		}
		public override Parameters Substitute(IExpression original, IExpression replacement)
		{
			return new Triple2Parameters(triple1.Substitute(original,replacement),triple2.Substitute(original,replacement));
		}
		public override IExpression this[int index]
		{
			get
			{
				switch(index)
				{
					case 0:
						return triple1;
					case 1:
						return triple2;
					default:
						throw new IndexOutOfRangeException();
				}
			}
		}
	}
	#endregion
	#region Scalar Triple Parameters
	public class Scalar1Triple1Parameters: Parameters
	{
		private IScalarExpression scalar1;
		private ITripleExpression triple1;
		public Scalar1Triple1Parameters() : base(2) {}
		public Scalar1Triple1Parameters(IScalarExpression s1, ITripleExpression t1) : base(2)
		{
			scalar1 = s1;
			triple1 = t1;
		}
		public IScalarExpression Scalar1
		{
			get {return scalar1;}
			set {scalar1 = value;}
		}
		public ITripleExpression Triple1
		{
			get {return triple1;}
			set {triple1 = value;}
		}
		public override void ConvertChilds(string conversionType)
		{
			ScalarConversionMap.Convert(ref scalar1, conversionType);
			TripleConversionMap.Convert(ref triple1, conversionType);
		}
		public override Parameters Simplify()
		{
			return new Scalar1Triple1Parameters(scalar1.Simplify(),triple1.Simplify());
		}
		public override Parameters Expand()
		{
			return new Scalar1Triple1Parameters(scalar1.Expand(),Triple1.Expand());
		}
		public override Parameters Substitute(IExpression original, IExpression replacement)
		{
			return new Scalar1Triple1Parameters(scalar1.Substitute(original,replacement),
				triple1.Substitute(original,replacement));
		}
		public override IExpression this[int index]
		{
			get
			{
				switch(index)
				{
					case 0:
						return scalar1;
					case 1:
						return triple1;
					default:
						throw new IndexOutOfRangeException();
				}
			}
		}
	}
	#endregion

	#region Geometry Operators
	/// <summary>
	/// TripleOperator is a base operator for operators
	/// returning an <see cref="ITripleExpression"/>.
	/// </summary>
	/// <remarks>It's very important to implement either Expand() or ExpandX(), ExpandY() and ExpandZ()!</remarks>
	public abstract class TripleOperator: MathExpression, ITripleExpression
	{
		public TripleOperator(Context context): base(context) {}
		public virtual ValueTriple Calculate()
		{
			return Expand().Calculate();
		}

		#region Basic Ops
		public override IExpression ExpressionExpand()
		{
			return Expand();
		}
		public virtual Vector3D Expand()
		{
			return new Vector3D(context,ExpandX(),ExpandY(),ExpandZ());
		}
		public virtual IScalarExpression ExpandX()
		{
			return Expand().ExpressionX;
		}
		public virtual IScalarExpression ExpandY()
		{
			return Expand().ExpressionY;
		}
		public virtual IScalarExpression ExpandZ()
		{
			return Expand().ExpressionZ;
		}
		public ITripleExpression SafeExpand()
		{
			return (ITripleExpression) ExpressionSafeExpand();
		}
		public override IExpression ExpressionSimplify()
		{
			return Simplify();
		}
		public virtual ITripleExpression Simplify()
		{
			return (ITripleExpression) InnerSimplify();
		}
		public override IExpression ExpressionSubstitute(IExpression original, IExpression replacement)
		{
			return Substitute(original, replacement);
		}
		public virtual ITripleExpression Substitute(IExpression original, IExpression replacement)
		{
			return (ITripleExpression) InnerSubstitute(original,replacement);
		}
		#endregion
	}
	#endregion
}
