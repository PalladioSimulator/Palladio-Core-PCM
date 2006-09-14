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
using cdrnet.Lib.MathLib.Exceptions;

namespace cdrnet.Lib.MathLib.Logic
{
	#region Basic Modules
	[ParsingObject(ParsingObjectType.Function,250,Character="and")]
	public class LogicAnd: ScalarOperator
	{
		protected Scalar2Parameters parameters;
		public Scalar2Parameters Parameters {get {return parameters;}}
		public LogicAnd(Context context, Scalar2Parameters parameters): base(context)
		{
			this.parameters = parameters; Init(parameters);
		}
		public LogicAnd(Context context, IScalarExpression left, IScalarExpression right): base(context)
		{
			this.parameters = new Scalar2Parameters(left,right);
			Init(parameters);
		}
		public override double Calculate()
		{
			if(parameters.Scalar1.Calculate() != 0 && parameters.Scalar2.Calculate() != 0)
				return 1;
			else
				return 0;
		}
		public override IScalarExpression Simplify()
		{
			IScalarExpression xFirst = parameters.Scalar1.Simplify();
			IScalarExpression xLast = parameters.Scalar2.Simplify();
			if(xFirst.IsConstant && (xFirst.Calculate() == 0) || xLast.IsConstant && (xLast.Calculate() == 0))
			{
				return ScalarExpressionValue.Zero(context);
			}
			if(xFirst.IsConstant && (xFirst.Calculate() != 0))
			{
				return xLast;
			}
			if(xLast.IsConstant && (xLast.Calculate() != 0))
			{
				return xFirst;
			}
			return new LogicAnd(context,xFirst,xLast);
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="or")]
	public class LogicOr: ScalarOperator
	{
		protected Scalar2Parameters parameters;
		public Scalar2Parameters Parameters {get {return parameters;}}
		public LogicOr(Context context, Scalar2Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public LogicOr(Context context, IScalarExpression left, IScalarExpression right): base(context)
		{
			this.parameters = new Scalar2Parameters(left,right);
			Init(parameters);
		}
		public override double Calculate()
		{
			if(parameters.Scalar1.Calculate() != 0 || parameters.Scalar2.Calculate() != 0)
				return 1;
			else
				return 0;
		}
		public override IScalarExpression Simplify()
		{
			IScalarExpression xFirst = parameters.Scalar1.Simplify();
			IScalarExpression xLast = parameters.Scalar2.Simplify();
			if(xFirst.IsConstant && (xFirst.Calculate() != 0) || xLast.IsConstant && (xLast.Calculate() != 0))
			{
				return ScalarExpressionValue.One(context);
			}
			if(xFirst.IsConstant && (xFirst.Calculate() == 0))
			{
				return xLast;
			}
			if(xLast.IsConstant && (xLast.Calculate() == 0))
			{
				return xFirst;
			}
			return new LogicOr(context,xFirst,xLast);
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="not")]
	public class LogicNot: ScalarOperator
	{
		protected Scalar1Parameters parameters;
		public Scalar1Parameters Parameters {get {return parameters;}}
		public LogicNot(Context context, Scalar1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public LogicNot(Context context, IScalarExpression sub): base(context)
		{
			this.parameters = new Scalar1Parameters(sub);
			Init(parameters);
		}
		public override double Calculate()
		{
			if(parameters.Scalar1.Calculate() != 0)
				return 0;
			else
				return 1;
		}
		public override IScalarExpression Simplify()
		{
			IScalarExpression xSub = parameters.Scalar1.Simplify();
			if(xSub.IsConstant && (xSub.Calculate() == 0))
			{
				return ScalarExpressionValue.One(context);
			}
			if(xSub.IsConstant && (xSub.Calculate() != 0))
			{
				return ScalarExpressionValue.Zero(context);
			}
			return new LogicNot(context,xSub);
		}
	}
	#endregion
	#region Primary Modules
	[ParsingObject(ParsingObjectType.Function,250,Character="nand")]
	public class LogicNand: ScalarOperator
	{
		protected Scalar2Parameters parameters;
		public Scalar2Parameters Parameters {get {return parameters;}}
		public LogicNand(Context context, Scalar2Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public LogicNand(Context context, IScalarExpression left, IScalarExpression right): base(context)
		{
			this.parameters = new Scalar2Parameters(left,right);
			Init(parameters);
		}
		public override double Calculate()
		{
			if(!(parameters.Scalar1.Calculate() != 0 && parameters.Scalar2.Calculate() != 0))
				return 1;
			else
				return 0;
		}
		public override IScalarExpression Simplify()
		{
			IScalarExpression xFirst = parameters.Scalar1.Simplify();
			IScalarExpression xLast = parameters.Scalar2.Simplify();
			if(xFirst.IsConstant && (xFirst.Calculate() == 0) || xLast.IsConstant && (xLast.Calculate() == 0))
			{
				return ScalarExpressionValue.One(context);
			}
			if(xFirst.IsConstant && (xFirst.Calculate() != 0))
			{
				return new LogicNot(context,xLast);
			}
			if(xLast.IsConstant && (xLast.Calculate() != 0))
			{
				return new LogicNot(context,xFirst);
			}
			return new LogicNand(context,xFirst,xLast);
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="nor")]
	public class LogicNor: ScalarOperator
	{
		protected Scalar2Parameters parameters;
		public Scalar2Parameters Parameters {get {return parameters;}}
		public LogicNor(Context context, Scalar2Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public LogicNor(Context context, IScalarExpression left, IScalarExpression right): base(context)
		{
			this.parameters = new Scalar2Parameters(left,right);
			Init(parameters);
		}
		public override double Calculate()
		{
			if(!(parameters.Scalar1.Calculate() != 0 && parameters.Scalar2.Calculate() != 0))
				return 1;
			else
				return 0;
		}
		public override IScalarExpression Simplify()
		{
			IScalarExpression xFirst = parameters.Scalar1.Simplify();
			IScalarExpression xLast = parameters.Scalar2.Simplify();
			if(xFirst.IsConstant && (xFirst.Calculate() != 0) || xLast.IsConstant && (xLast.Calculate() != 0))
			{
				return ScalarExpressionValue.Zero(context);
			}
			if(xFirst.IsConstant && (xFirst.Calculate() == 0))
			{
				return new LogicNot(context,xLast);
			}
			if(xLast.IsConstant && (xLast.Calculate() == 0))
			{
				return new LogicNot(context,xFirst);
			}
			return new LogicNor(context,xFirst,xLast);
		}
	}
	#endregion
	#region Secondary Modules
	[ParsingObject(ParsingObjectType.Function,250,Character="xor")]
	public class LogicXor: ScalarOperator
	{
		protected Scalar2Parameters parameters;
		public Scalar2Parameters Parameters {get {return parameters;}}
		public LogicXor(Context context, Scalar2Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public LogicXor(Context context, IScalarExpression left, IScalarExpression right): base(context)
		{
			this.parameters = new Scalar2Parameters(left,right);
			Init(parameters);
		}
		public override double Calculate()
		{
			if((parameters.Scalar1.Calculate() != 0 && parameters.Scalar2.Calculate() == 0) || (parameters.Scalar1.Calculate() == 0 && parameters.Scalar2.Calculate() != 0))
				return 1;
			else
				return 0;
		}
		public override IScalarExpression Simplify()
		{
			IScalarExpression xFirst = parameters.Scalar1.Simplify();
			IScalarExpression xLast = parameters.Scalar2.Simplify();
			if(xFirst.IsEntity && xLast.IsEntity)
			{
				if(xFirst.Calculate() == 0 && xLast.Calculate() != 0 || xFirst.Calculate() != 0 && xLast.Calculate() == 0)
					return ScalarExpressionValue.One(context);
				else
					return ScalarExpressionValue.Zero(context);
			}
			return new LogicXor(context,xFirst,xLast);
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="xnor")]
	public class LogicXnor: ScalarOperator
	{
		protected Scalar2Parameters parameters;
		public Scalar2Parameters Parameters {get {return parameters;}}
		public LogicXnor(Context context, Scalar2Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public LogicXnor(Context context, IScalarExpression left, IScalarExpression right): base(context)
		{
			this.parameters = new Scalar2Parameters(left,right);
			Init(parameters);
		}
		public override double Calculate()
		{
			if((parameters.Scalar1.Calculate() == 0 && parameters.Scalar2.Calculate() == 0) || (parameters.Scalar1.Calculate() != 0 && parameters.Scalar2.Calculate() != 0))
				return 1;
			else
				return 0;
		}
		public override IScalarExpression Simplify()
		{
			IScalarExpression xFirst = parameters.Scalar1.Simplify();
			IScalarExpression xLast = parameters.Scalar2.Simplify();
			if(xFirst.IsConstant && xLast.IsEntity)
			{
				if(xFirst.Calculate() == 0 && xLast.Calculate() == 0 || xFirst.Calculate() != 0 && xLast.Calculate() != 0)
					return ScalarExpressionValue.One(context);
				else
					return ScalarExpressionValue.Zero(context);
			}
			return new LogicXnor(context,xFirst,xLast);
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="imp")]
	public class LogicImplication: ScalarOperator
	{
		protected Scalar2Parameters parameters;
		public Scalar2Parameters Parameters {get {return parameters;}}
		public LogicImplication(Context context, Scalar2Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public LogicImplication(Context context, IScalarExpression left, IScalarExpression right): base(context)
		{
			this.parameters = new Scalar2Parameters(left,right);
			Init(parameters);
		}
		public override double Calculate()
		{
			if(parameters.Scalar1.Calculate() == 0 || parameters.Scalar2.Calculate() != 0)
				return 1;
			else
				return 0;
		}
		public override IScalarExpression Simplify()
		{
			IScalarExpression xFirst = parameters.Scalar1.Simplify();
			IScalarExpression xLast = parameters.Scalar2.Simplify();
			if(xFirst.IsConstant && xLast.IsConstant)
			{
				if(xFirst.Calculate() == 0 || xLast.Calculate() != 0)
					return ScalarExpressionValue.One(context);
				else
					return ScalarExpressionValue.Zero(context);
			}
			return new LogicImplication(context,xFirst,xLast);
		}
	}
	#endregion
}
