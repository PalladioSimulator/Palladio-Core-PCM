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
using cdrnet.Lib.MathLib.Scalar;

namespace cdrnet.Lib.MathLib.Tools
{
	public delegate void ExpressionEventHandler(object sender, ExpressionEventArgs e);
	public delegate void ScalarExpressionEventHandler(object sender, ScalarExpressionEventArgs e);
	public delegate void StackItemEventHandler(object sender, StackItemEventArgs e);
	public delegate void StringEventHandler(object sender, StringEventArgs e);

	public class ExpressionEventArgs: EventArgs
	{
		protected IExpression expression;
		public ExpressionEventArgs(IExpression expression)
		{
			this.expression = expression;
		}
		public IExpression Expression
		{
			get {return expression;}
			set {expression = value;}
		}
	}
	public class ScalarExpressionEventArgs: EventArgs
	{
		protected IScalarExpression expression;
		public ScalarExpressionEventArgs(IScalarExpression expression)
		{
			this.expression = expression;
		}
		public IScalarExpression Expression
		{
			get {return expression;}
			set {expression = value;}
		}
	}
	public class StackItemEventArgs: EventArgs
	{
		protected ExpressionStackItem item;
		public StackItemEventArgs(ExpressionStackItem item)
		{
			this.item = item;
		}
		public ExpressionStackItem Item
		{
			get {return item;}
			set {item = value;}
		}
	}
	public class StringEventArgs: EventArgs
	{
		protected string item;
		public StringEventArgs(string item)
		{
			this.item = item;
		}
		public string Item
		{
			get {return item;}
			set {item = value;}
		}
	}
}
