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
using System.Collections;
using cdrnet.Lib.MathLib.Core;
using cdrnet.Lib.MathLib.Scalar;
using cdrnet.Lib.MathLib.Scalar.LinearAlgebra;
using cdrnet.Lib.MathLib.Exceptions;

namespace cdrnet.Lib.MathLib.Scalar.Geometry
{
	/// <summary>
	/// Math.NET type: a fixed 3D vector expression
	/// </summary>
	[ParsingType(ParsingExpressionType.Vector,3)]
	public interface ITripleExpression: IExpression
	{
		/// <summary>
		/// calculate the axis components as real doubles
		/// </summary>
		ValueTriple Calculate();
		/// <summary>
		/// scalar expression of the vector's X axis component
		/// </summary>
		IScalarExpression ExpandX();
		/// <summary>
		/// scalar expression of the vector's Y axis component
		/// </summary>
		IScalarExpression ExpandY();
		/// <summary>
		/// scalar expression of the vector's Z axis component
		/// </summary>
		IScalarExpression ExpandZ();
		/// <summary>
		/// vector representation using axis components as scalar expressions
		/// </summary>
		/// <returns>the splitted expression</returns>
		Vector3D Expand();
		/// <summary>
		/// expands the expression.
		/// </summary>
		/// <remarks>
		/// SafeExpand() is less powerfull than <see cref="Expand()"/> but never throws an ExpressionNotDeriveableException.
		/// </remarks>
		/// <returns>the expanded expression</returns>
		ITripleExpression SafeExpand();
		/// <summary>
		/// simplifies the expression
		/// </summary>
		/// <returns>the simplified expression</returns>
		ITripleExpression Simplify();
		/// <summary>
		/// substitutes the specified subterms with the given replacement
		/// </summary>
		/// <param name="original">the subterm to look for</param>
		/// <param name="replacement">the replacement of the subterms</param>
		/// <returns>the substituted expression</returns>
		ITripleExpression Substitute(IExpression original, IExpression replacement);
	}
	public struct ValueTriple
	{
		public double X,Y,Z;
		public double ToAbsolute()
		{
			return(Math.Sqrt(X*X+Y*Y+Z*Z));
		}
		public override string ToString()
		{
			return("["+X+","+Y+","+Z+"]");
		}
	}

	#region Specific Math Objects
	[ParsingObject(ParsingObjectType.Object,11)]
	public class Vector3D: TripleOperator
	{
		protected Scalar3Parameters parameters;
		public Vector3D(Context context, Scalar3Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public Vector3D(Context context, IScalarExpression initX, IScalarExpression initY, IScalarExpression initZ): base(context)
		{
			this.parameters = new Scalar3Parameters(initX,initY,initZ);
			Init(parameters);
		}
		public Vector3D(Context context): base(context)
		{
			this.parameters = new Scalar3Parameters(ScalarExpressionValue.One(context),ScalarExpressionValue.One(context),ScalarExpressionValue.One(context));
			Init(parameters);
		}

		#region Static Vector Templates
		public static Vector3D OriginVector(Context context)
		{
			IScalarExpression se = ScalarExpressionValue.Zero(context);
			return new Vector3D(context,se,se,se);
		}
		public static Vector3D ZeroVector(Context context)
		{
			IScalarExpression se = ScalarExpressionValue.Zero(context);
			return new Vector3D(context,se,se,se);
		}
		public static Vector3D XAxisVector(Context context)
		{
			IScalarExpression se = ScalarExpressionValue.Zero(context);
			IScalarExpression se2 = ScalarExpressionValue.One(context);
			return new Vector3D(context,se2,se,se);
		}
		public static Vector3D YAxisVector(Context context)
		{
			IScalarExpression se = ScalarExpressionValue.Zero(context);
			IScalarExpression se2 = ScalarExpressionValue.One(context);
			return new Vector3D(context,se,se2,se);
		}
		public static Vector3D ZAxisVector(Context context)
		{
			IScalarExpression se = ScalarExpressionValue.Zero(context);
			IScalarExpression se2 = ScalarExpressionValue.One(context);
			return new Vector3D(context,se,se,se2);
		}
		#endregion

		public IScalarExpression ExpressionX
		{
			set {parameters.Scalar1 = value;}
			get {return parameters.Scalar1;}
		}
		public IScalarExpression ExpressionY
		{
			set {parameters.Scalar2 = value;}
			get {return parameters.Scalar2;}
		}
		public IScalarExpression ExpressionZ
		{
			set {parameters.Scalar3 = value;}
			get {return parameters.Scalar3;}
		}
		public override IScalarExpression ExpandX()
		{
			return parameters.Scalar1;
		}
		public override IScalarExpression ExpandY()
		{
			return parameters.Scalar2;
		}
		public override IScalarExpression ExpandZ()
		{
			return parameters.Scalar3;
		}
		public override Vector3D Expand()
		{
			return this;
		}
		public override bool IsEntity
		{
			get	{return true;}
		}
		public override ValueTriple Calculate()
		{
			ValueTriple rsp;
			rsp.X = parameters.Scalar1.Calculate();
			rsp.Y = parameters.Scalar2.Calculate();
			rsp.Z = parameters.Scalar3.Calculate();
			return(rsp);
		}
		public override string ToString()
		{
			return string.Format("[{0},{1},{2}]",parameters.Scalar1.ToString(),parameters.Scalar2.ToString(),parameters.Scalar3.ToString());
		}
	}
	#endregion

	#region Operator Base (deactive)
	/*
	public abstract class BiTripleOperator
	{
		protected ITripleExpression first, last;
		private int priority;
		protected BiTripleOperator(ITripleExpression first, ITripleExpression last)
		{
			this.first = first;
			this.last = last;
		}
		public ITripleExpression PreExpression
		{
			set {first = value;}
			get {return(first);}
		}
		public ITripleExpression AfterExpression
		{
			set {last = value;}
			get {return(last);}
		}
		public int Priority
		{
			set {priority = value;}
			get {return(priority);}
		}
		public bool IsConstant
		{
			get {return(first.IsConstant && last.IsConstant);}
		}
		public virtual bool IsEntity
		{
			get {return(false);}
		}
		public void ConvertChilds(string conversionType)
		{
			TripleConversionMap.Convert(ref first,conversionType);
			TripleConversionMap.Convert(ref last,conversionType);
		}
		public override bool Equals(object exp)
		{
			if(exp.GetType() == this.GetType())
			{
				BiTripleOperator x = exp as BiTripleOperator;
				//override this method if not true!!
				if(x.first.IsEqualTo(this.first) && x.last.IsEqualTo(this.last) || x.first.IsEqualTo(this.last) && x.last.IsEqualTo(this.first))
					return(true);
			}
			return(false);
		}
		public void CollectVariables(VariableManager vars, bool deep)
		{
			first.CollectVariables(vars,deep);
			last.CollectVariables(vars,deep);
		}
	}
	public abstract class SingleTripleOperator
	{
		protected ITripleExpression sub;
		private int priority;
		protected SingleTripleOperator(ITripleExpression sub)
		{
			this.sub = sub;
		}
		public ITripleExpression SubExpression
		{
			set {sub = value;}
			get {return(sub);}
		}
		public int Priority
		{
			set {priority = value;}
			get {return(priority);}
		}
		public bool IsConstant
		{
			get {return(sub.IsConstant);}
		}
		public virtual bool IsEntity
		{
			get {return(false);}
		}
		public void ConvertChilds(string conversionType)
		{
			TripleConversionMap.Convert(ref sub,conversionType);
		}
		public override bool Equals(object exp)
		{
			if(exp.GetType() == this.GetType())
			{
				SingleTripleOperator x = exp as SingleTripleOperator;
				//override this method if not true!!
				if(x.sub.IsEqualTo(this.sub))
					return(true);
			}
			return(false);
		}
		public void CollectVariables(VariableManager vars, bool deep)
		{
			sub.CollectVariables(vars,deep);
		}
	}
	public abstract class TripleScalarOperator
	{
		protected ITripleExpression triple;
		protected IScalarExpression scalar;
		private int priority;
		protected TripleScalarOperator(ITripleExpression triple, IScalarExpression scalar)
		{
			this.triple = triple;
			this.scalar = scalar;
		}
		public ITripleExpression VectorExpression
		{
			set {triple = value;}
			get {return(triple);}
		}
		public IScalarExpression ScalarExpression
		{
			set {scalar = value;}
			get {return(scalar);}
		}
		public int Priority
		{
			set {priority = value;}
			get {return(priority);}
		}
		public bool IsConstant
		{
			get {return(triple.IsConstant && scalar.IsConstant);}
		}
		public virtual bool IsEntity
		{
			get {return(false);}
		}
		public void ConvertChilds(string conversionType)
		{
			TripleConversionMap.Convert(ref triple,conversionType);
			ScalarConversionMap.Convert(ref scalar,conversionType);
		}
		public override bool Equals(object exp)
		{
			if(exp.GetType() == this.GetType())
			{
				TripleScalarOperator x = exp as TripleScalarOperator;
				//override this method if not true!!
				if(x.triple.IsEqualTo(this.triple) && x.scalar.IsEqualTo(this.scalar))
					return(true);
			}
			return(false);
		}
		public void CollectVariables(VariableManager vars, bool deep)
		{
			triple.CollectVariables(vars,deep);
			scalar.CollectVariables(vars,deep);
		}
	}
	*/
	#endregion

	#region SingleTriple & TripleScalar Operations
	[ParsingObject(ParsingObjectType.OuterOperator,30,Character="|")]
	public class TripleAbsolute: ScalarOperator
	{
		protected Triple1Parameters parameters;
		public Triple1Parameters Parameters {get {return parameters;}}
		public TripleAbsolute(Context context, Triple1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public TripleAbsolute(Context context, ITripleExpression sub): base(context)
		{
			this.parameters = new Triple1Parameters(sub);
			Init(parameters);
		}
		public override double Calculate()
		{
			return parameters.Triple1.Calculate().ToAbsolute();
		}
		public override IScalarExpression Expand()
		{
			Vector3D v = parameters.Triple1.Expand();
			return new ScalarSquareRoot(context,new ScalarAddition(context,new ScalarAddition(context,new ScalarSquare(context,v.ExpressionX),new ScalarSquare(context,v.ExpressionY)),new ScalarSquare(context,v.ExpressionZ))).Expand();
		}
	}
	[ParsingObject(ParsingObjectType.InnerOperator,50,Character="*")]
	public class TripleScalarStretch: TripleOperator
	{
		protected Scalar1Triple1Parameters parameters;
		public Scalar1Triple1Parameters Parameters {get {return parameters;}}
		public TripleScalarStretch(Context context, Scalar1Triple1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public TripleScalarStretch(Context context, ITripleExpression triple, IScalarExpression scalar): base(context)
		{
			this.parameters = new Scalar1Triple1Parameters(scalar,triple);
			Init(parameters);
		}
		public TripleScalarStretch(Context context, IScalarExpression scalar, ITripleExpression triple): base(context)
		{
			this.parameters = new Scalar1Triple1Parameters(scalar,triple);
			Init(parameters);
		}
		public override ValueTriple Calculate()
		{
			ValueTriple a = parameters.Triple1.Calculate();
			double b = parameters.Scalar1.Calculate();
			ValueTriple rsp;
			rsp.X = a.X * b;
			rsp.Y = a.Y * b;
			rsp.Z = a.Z * b;
			return rsp;
		}
		public override IScalarExpression ExpandX()
		{
			return new ScalarMultiplication(context,parameters.Triple1.ExpandX(),parameters.Scalar1);
		}
		public override IScalarExpression ExpandY()
		{
			return new ScalarMultiplication(context,parameters.Triple1.ExpandY(),parameters.Scalar1);
		}
		public override IScalarExpression ExpandZ()
		{
			return new ScalarMultiplication(context,parameters.Triple1.ExpandZ(),parameters.Scalar1);
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="TtV")]
	public class TripleToVector: VectorOperator
	{
		protected Triple1Parameters parameters;
		public Triple1Parameters Parameters {get {return parameters;}}
		public TripleToVector(Context context, Triple1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public TripleToVector(Context context, ITripleExpression sub): base(context)
		{
			this.parameters = new Triple1Parameters(sub);
			Init(parameters);
		}
		public override ScalarVector Expand()
		{
			IScalarExpression[] se = new IScalarExpression[3];
			Vector3D v = parameters.Triple1.Expand();
			se[0] = v.ExpressionX;
			se[1] = v.ExpressionY;
			se[2] = v.ExpressionZ;
			return new ScalarVector(context,se);
		}
		public override int Length
		{
			get {return 3;}
		}
	}
	#endregion

	#region BiTriple Operations
	[ParsingObject(ParsingObjectType.InnerOperator,50,Character="x",Commutative=false,Associative=false)]
	public class TripleCrossMultiplication: TripleOperator
	{
		protected Triple2Parameters parameters;
		public Triple2Parameters Parameters {get {return parameters;}}
		public TripleCrossMultiplication(Context context, Triple2Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public TripleCrossMultiplication(Context context, ITripleExpression first, ITripleExpression last): base(context)
		{
			this.parameters = new Triple2Parameters(first,last);
			Init(parameters);
		}
		public override ValueTriple Calculate()
		{
			ValueTriple a = parameters.Triple1.Calculate();
			ValueTriple b = parameters.Triple2.Calculate();
			ValueTriple rsp;
			rsp.X = a.Y*b.Z-a.Z*b.Y;
			rsp.Y = -a.X*b.Z+a.Z*b.X;
			rsp.Z = a.X*b.Y-a.Y*b.X;
			return(rsp);
		}
		public override IScalarExpression ExpandX()
		{
			return new ScalarSubtraction(context,new ScalarMultiplication(context,parameters.Triple1.ExpandY(),parameters.Triple2.ExpandZ()),new ScalarMultiplication(context,parameters.Triple1.ExpandZ(),parameters.Triple2.ExpandY()));
		}
		public override IScalarExpression ExpandY()
		{
			return new ScalarSubtraction(context,new ScalarMultiplication(context,parameters.Triple1.ExpandZ(),parameters.Triple2.ExpandX()),new ScalarMultiplication(context,parameters.Triple1.ExpandX(),parameters.Triple2.ExpandZ()));
		}
		public override IScalarExpression ExpandZ()
		{
			return new ScalarSubtraction(context,new ScalarMultiplication(context,parameters.Triple1.ExpandX(),parameters.Triple2.ExpandY()),new ScalarMultiplication(context,parameters.Triple1.ExpandY(),parameters.Triple2.ExpandX()));
		}
	}
	[ParsingObject(ParsingObjectType.InnerOperator,50,Character="*",Commutative=true,Associative=true)]
	public class TripleDotMultiplication: ScalarOperator
	{
		protected Triple2Parameters parameters;
		public Triple2Parameters Parameters {get {return parameters;}}
		public TripleDotMultiplication(Context context, Triple2Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public TripleDotMultiplication(Context context, ITripleExpression first, ITripleExpression last): base(context)
		{
			this.parameters = new Triple2Parameters(first,last);
			Init(parameters);
		}
		public override double Calculate()
		{
			ValueTriple a = parameters.Triple1.Calculate();
			ValueTriple b = parameters.Triple2.Calculate();
			return a.X*b.X+a.Y*b.Y+a.Z*b.Z;
		}
		public override IScalarExpression Expand()
		{
			return new ScalarAddition(context,new ScalarMultiplication(context,parameters.Triple1.ExpandX(),parameters.Triple2.ExpandX()),new ScalarAddition(context,new ScalarMultiplication(context,parameters.Triple1.ExpandY(),parameters.Triple2.ExpandY()),new ScalarMultiplication(context,parameters.Triple1.ExpandZ(),parameters.Triple2.ExpandZ())));
		}
	}
	[ParsingObject(ParsingObjectType.InnerOperator,60,Character="+",Commutative=true,Associative=true)]
	public class TripleAddition: TripleOperator
	{
		protected Triple2Parameters parameters;
		public Triple2Parameters Parameters {get {return parameters;}}
		public TripleAddition(Context context, Triple2Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public TripleAddition(Context context, ITripleExpression first, ITripleExpression last): base(context)
		{
			this.parameters = new Triple2Parameters(first,last);
			Init(parameters);
		}
		public override ValueTriple Calculate()
		{
			ValueTriple a = parameters.Triple1.Calculate();
			ValueTriple b = parameters.Triple2.Calculate();
			ValueTriple rsp;
			rsp.X = a.X + b.X;
			rsp.Y = a.Y + b.Y;
			rsp.Z = a.Z + b.Z;
			return rsp;
		}
		public override IScalarExpression ExpandX()
		{
			return new ScalarAddition(context,parameters.Triple1.ExpandX(),parameters.Triple2.ExpandX());
		}
		public override IScalarExpression ExpandY()
		{
			return new ScalarAddition(context,parameters.Triple1.ExpandY(),parameters.Triple2.ExpandY());
		}
		public override IScalarExpression ExpandZ()
		{
			return new ScalarAddition(context,parameters.Triple1.ExpandZ(),parameters.Triple2.ExpandZ());
		}
	}
	[ParsingObject(ParsingObjectType.InnerOperator,60,Character="-",Commutative=false,Associative=false)]
	public class TripleSubtraction: TripleOperator
	{
		protected Triple2Parameters parameters;
		public Triple2Parameters Parameters {get {return parameters;}}
		public TripleSubtraction(Context context, Triple2Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public TripleSubtraction(Context context, ITripleExpression first, ITripleExpression last): base(context)
		{
			this.parameters = new Triple2Parameters(first,last);
			Init(parameters);
		}
		public override ValueTriple Calculate()
		{
			ValueTriple a = parameters.Triple1.Calculate();
			ValueTriple b = parameters.Triple2.Calculate();
			ValueTriple rsp;
			rsp.X = a.X - b.X;
			rsp.Y = a.Y - b.Y;
			rsp.Z = a.Z - b.Z;
			return rsp;
		}
		public override IScalarExpression ExpandX()
		{
			return new ScalarSubtraction(context,parameters.Triple1.ExpandX(),parameters.Triple2.ExpandX());
		}
		public override IScalarExpression ExpandY()
		{
			return new ScalarSubtraction(context,parameters.Triple1.ExpandY(),parameters.Triple2.ExpandY());
		}
		public override IScalarExpression ExpandZ()
		{
			return new ScalarSubtraction(context,parameters.Triple1.ExpandZ(),parameters.Triple2.ExpandZ());
		}
	}
	#endregion

	#region Triple Conversion Maps
	public abstract class TripleMapEntry: ConversionMapEntry
	{
		public abstract bool ConvertTo(ref ITripleExpression exp);
		public override bool ConvertTo(ref IExpression exp)
		{
			ITripleExpression ex = exp as ITripleExpression;
			bool res = ConvertTo(ref ex);
			if(res)
				exp = ex;
			return(res);
		}
	}
	public class TripleConversionMap
	{
		public static void Convert(ref ITripleExpression exp, string conversionType)
		{
			ArrayList al;
			bool changed = true;
			while(changed)
			{
				changed = false;
				exp.ConvertChilds(conversionType);
				exp = exp.Simplify();
				al = ConversionMap.GetMapEntryList(exp.GetType(),conversionType);
				foreach(TripleMapEntry entry in al)
				{
					changed = entry.ConvertTo(ref exp);
					if(changed)
						break;
				}
			}
		}
	}
	#endregion
}
