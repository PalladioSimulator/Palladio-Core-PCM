/*
 * $Id$
 * 
 * $Log$
 * Revision 1.2  2004/07/13 02:14:52  sliver
 * Added comments
 *
 * Revision 1.1  2004/07/12 06:33:04  sliver
 * Initial checkin
 * 
 */


using System;

using Palladio.ComponentModel;
using Palladio.FiniteStateMachines;
using Palladio.Identifier;
using Palladio.Attributes;
using Palladio.Reliability;
using Palladio.Reliability.TypedCollections;
using Palladio.Reliability.Math;

using cdrnet.Lib.MathLib.Core;
using cdrnet.Lib.MathLib.Scalar;
using cdrnet.Lib.MathLib.Scalar.LinearAlgebra;
using cdrnet.Lib.MathLib.Parsing;
using cdrnet.Lib.MathLib.Exceptions;
using cdrnet.Lib.MathLib.Tools;


namespace Palladio.Reliability.Tests
{
	/// <summary>
	/// Description of Helper.	
	/// </summary>
	public class Helper
	{
		public static double SumUpRow(ScalarMatrix aMatrix, int row)
		{
			IScalarExpression result = new ScalarExpressionValue(aMatrix.Context, 0.0);
			for (int i = 0; i<aMatrix.LengthX; i++)
			{
				result = new ScalarAddition(aMatrix.Context, result, aMatrix[i,row]);
			}
			return result.Calculate();
		}
		
		public static ScalarExpressionValue SetValue(ref Variable var, double val)
		{
			ScalarExpressionValue exprVal = new ScalarExpressionValue( var.Context, val );
			((ScalarExpressionVariable)var).Value = exprVal;
			var.IsThreatenedAsVariable = false;
			return exprVal;
		}
		
		public static IIdentifier ID(string id)
		{
			return IdentifiableFactory.CreateStringID(id);
		}
		
		public static ITransition CreateTransition(string sourceState, IMatchable input, string destinationState)
		{
			return FSMFactory.CreateDefaultTransition(
			       		FSMFactory.CreateDefaultState(sourceState), 
			       		FSMFactory.CreateDefaultInput( input ), 
			       		FSMFactory.CreateDefaultState(destinationState));
		}		
		
		public static IAttributeHash CreateAttributeHash()
		{
			AttributesFactory factory = new AttributesFactory();
			return factory.Default.CreateAttributeHash();
		}
		
	}
}
