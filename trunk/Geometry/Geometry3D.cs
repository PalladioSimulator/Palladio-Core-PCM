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
using cdrnet.Lib.MathLib.Scalar.LinearAlgebra;

namespace cdrnet.Lib.MathLib.Scalar.Geometry
{
	[ParsingType(ParsingExpressionType.Object,3)]
	public interface IGeometryObject
	{
		/// <summary>
		/// location of the object in relation to the origin
		/// </summary>
		ITripleExpression Location {get;set;}
	}
	
	public class Point3D: IGeometryObject
	{
		private Context context;
		private ITripleExpression location;
		private int priority;
		public Point3D(Context context, ITripleExpression location)
		{
			this.context = context;
			this.location = location;
		}
		public Point3D(Context context)
		{
			this.context = context;
			this.location = new Vector3D(context);
		}
		public ITripleExpression Location
		{
			get {return(location);}
			set {location = value;}
		}
		public override string ToString()
		{
			return("Point3D(" + location.ToString() + ")");
		}
		public bool IsConstant
		{
			get {return(location.IsConstant);}
		}
		public ITripleExpression GetVectorToPoint(Point3D point)
		{
			return(new TripleSubtraction(context,point.Location,location));
		}
		public IScalarExpression GetDistanceOf(Point3D point)
		{
			return(new TripleAbsolute(context,this.GetVectorToPoint(point)));
		}
		public int Priority
		{
			set {priority = value;}
			get {return(priority);}
		}
		public bool IsEntity
		{
			get {return(false);}
		}
		public void ConvertChilds(string conversionType)
		{
			TripleConversionMap.Convert(ref location,conversionType);
		}
		public override bool Equals(object exp)
		{
			if(exp.GetType() == typeof(Point3D))
			{
				Point3D x = exp as Point3D;
				if(x.location.Equals(this.location))
					return(true);
			}
			return(false);
		}
		public void CollectVariables(VariableManager vars, bool deep)
		{
			location.CollectVariables(vars,deep);
		}
	}
	public class Line3D: IGeometryObject
	{
		private Context context;
		private ITripleExpression location, direction;
		private int priority;
		public Line3D(Context context)
		{
			this.context = context;
			this.location = new Vector3D(context);
			this.direction = new Vector3D(context);
		}
		public Line3D(Context context, Point3D point1, Point3D point2)
		{
			this.context = context;
			this.location = point1.Location;
			this.direction = point1.GetVectorToPoint(point2);
		}
		public Line3D(Context context, Point3D point, ITripleExpression direction)
		{
			this.context = context;
			this.location = point.Location;
			this.direction = direction;
		}
		public ITripleExpression Location
		{
			get {return(location);}
			set {location = value;}
		}
		public ITripleExpression Direction
		{
			get {return(direction);}
			set {direction = value;}
		}
		/*
		public Point3D Point1
		{
			get {return(new Point3D(location));}
		}
		public Point3D Point2
		{
			get {return(new Point3D(new VectorAddition(location,direction)));}
		}
		*/
		public override string ToString()
		{
			return("Line3D(" + location.ToString() + "," + direction.ToString() + ")");
		}
		public bool IsConstant
		{
			get {return(location.IsConstant && direction.IsConstant);}
		}
		public IScalarExpression GetDistanceOf(Point3D point)
		{
			ITripleExpression t = new TripleCrossMultiplication(context,direction,new TripleSubtraction(context,point.Location,location));
			return(new ScalarDivision(context,new TripleAbsolute(context,t),new TripleAbsolute(context,direction)));
		}
		public int Priority
		{
			set {priority = value;}
			get {return(priority);}
		}
		public bool IsEntity
		{
			get {return(false);}
		}
		public void ConvertChilds(string conversionType)
		{
			TripleConversionMap.Convert(ref direction,conversionType);
			TripleConversionMap.Convert(ref location,conversionType);
		}
		public override bool Equals(object exp)
		{
			if(exp.GetType() == typeof(Line3D))
			{
				Line3D x = exp as Line3D;
				if(x.location.Equals(this.location) && x.direction.Equals(this.direction))
					return(true);
			}
			return(false);
		}
		public void CollectVariables(VariableManager vars, bool deep)
		{
			location.CollectVariables(vars,deep);
			direction.CollectVariables(vars,deep);
		}
	}
	public class Plain3D: IGeometryObject
	{
		private Context context;
		private ITripleExpression location, normalVector;
		private int priority;
		public Plain3D(Context context)
		{
			this.context = context;
			this.location = new Vector3D(context);
			this.normalVector = new Vector3D(context);
		}
		public Plain3D(Context context, IScalarExpression A, IScalarExpression B, IScalarExpression C, IScalarExpression D)
		{
			this.context = context;
			this.location = new Vector3D(context,ScalarExpressionValue.Zero(context),ScalarExpressionValue.Zero(context),new ScalarNegative(context,new ScalarDivision(context,D,C)));
			this.normalVector = new Vector3D(context,A,B,C);
		}
		public Plain3D(Context context, Point3D point, ITripleExpression normalVector)
		{
			this.context = context;
			this.location = point.Location;
			this.normalVector = normalVector;
		}
		public Plain3D(Context context, Point3D point, ITripleExpression direction1, ITripleExpression direction2)
		{
			this.context = context;
			this.location = point.Location;
			this.normalVector = new TripleCrossMultiplication(context,direction1,direction2);
		}
		public Plain3D(Context context, Point3D point1, Point3D point2, Point3D point3)
		{
			this.context = context;
			this.location = point1.Location;
			this.normalVector = new TripleCrossMultiplication(context,point1.GetVectorToPoint(point2),point1.GetVectorToPoint(point3));
		}
		public ITripleExpression Location
		{
			get {return(location);}
			set {location = value;}
		}
		public ITripleExpression NormalVector
		{
			get {return(normalVector);}
			set {normalVector = value;}
		}
		public IScalarExpression A
		{
			get {return(normalVector.ExpandX());}
		}
		public IScalarExpression B
		{
			get {return(normalVector.ExpandY());}
		}
		public IScalarExpression C
		{
			get {return(normalVector.ExpandZ());}
		}
		public IScalarExpression D
		{
			get {return new ScalarNegative(context,new TripleDotMultiplication(context,normalVector,location));}
		}
		public override string ToString()
		{
			return("Plain3D(" + location.ToString() + "," + normalVector.ToString() + ")");
		}
		public bool IsConstant
		{
			get {return(location.IsConstant && normalVector.IsConstant);}
		}
		public IScalarExpression GetDistanceOf(Point3D point)
		{
			return new ScalarDivision(context,new ScalarAddition(context,new TripleDotMultiplication(context,normalVector,point.Location),this.D),new TripleAbsolute(context,normalVector));
		}
		public Line3D CutWithPlain(Plain3D plain)
		{
			ITripleExpression dir = new TripleCrossMultiplication(context,this.NormalVector,plain.NormalVector);
			IScalarExpression det = new ScalarSubtraction(context,new ScalarMultiplication(context,this.B,plain.C),new ScalarMultiplication(context,this.C,plain.B));
			IScalarExpression posy = new ScalarDivision(context,new ScalarSubtraction(context,new ScalarMultiplication(context,this.C,plain.D),new ScalarMultiplication(context,this.D,plain.C)),det);
			IScalarExpression posz = new ScalarDivision(context,new ScalarSubtraction(context,new ScalarMultiplication(context,this.D,plain.B),new ScalarMultiplication(context,this.B,plain.D)),det);
			return(new Line3D(context,new Point3D(context,new Vector3D(context,ScalarExpressionValue.Zero(context),posy,posz)),dir));
		}
		public Point3D CutWithLine(Line3D line)
		{
			IScalarExpression t = new ScalarNegative(context,new ScalarDivision(context,new ScalarAddition(context,new TripleDotMultiplication(context,normalVector,line.Location),this.D),new TripleDotMultiplication(context,normalVector,line.Direction)));
			Point3D point = new Point3D(context,new TripleAddition(context,line.Location,new TripleScalarStretch(context,line.Direction,t)));
			return(point);
		}
		public Point3D MirrorPointOnPlain(Point3D point)
		{
			IScalarExpression t = new ScalarMultiplication(context,new ScalarExpressionValue(context,-2),new ScalarDivision(context,new ScalarAddition(context,new TripleDotMultiplication(context,normalVector,point.Location),this.D),new TripleDotMultiplication(context,normalVector,normalVector)));
			Point3D s = new Point3D(context,new TripleAddition(context,point.Location,new TripleScalarStretch(context,normalVector,t)));
			return(s);
		}
		public int Priority
		{
			set {priority = value;}
			get {return(priority);}
		}
		public bool IsEntity
		{
			get {return(false);}
		}
		public void ConvertChilds(string conversionType)
		{
			TripleConversionMap.Convert(ref normalVector,conversionType);
			TripleConversionMap.Convert(ref location,conversionType);
		}
		public override bool Equals(object exp)
		{
			if(exp.GetType() == typeof(Plain3D))
			{
				Plain3D x = exp as Plain3D;
				if(x.location.Equals(this.location) && x.normalVector.Equals(this.normalVector))
					return(true);
			}
			return(false);
		}
		public void CollectVariables(VariableManager vars, bool deep)
		{
			location.CollectVariables(vars,deep);
			normalVector.CollectVariables(vars,deep);
		}
	}
}