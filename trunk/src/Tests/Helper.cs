/*
 * $Id$
 * 
 * $Log$
 * Revision 1.5  2004/09/23 00:44:14  sliver
 * - major refactorings
 * - changed TypedCollections to CodeSmith generated files
 * - introduced MakrovModel
 * - added Transition-, Potential-, VisitProbability-, and VisitsOnPath- matrix types
 *
 * Revision 1.4  2004/09/09 04:07:53  sliver
 * code refactored
 * vs.net project files created
 *
 * Revision 1.3  2004/07/30 01:25:51  sliver
 * Some changes...
 *
 * Revision 1.2  2004/07/13 02:14:52  sliver
 * Added comments
 *
 * Revision 1.1  2004/07/12 06:33:04  sliver
 * Initial checkin
 * 
 */


using cdrnet.Lib.MathLib.Core;
using cdrnet.Lib.MathLib.Scalar;
using cdrnet.Lib.MathLib.Scalar.LinearAlgebra;
using Palladio.Attributes;
using Palladio.FiniteStateMachines;
using Palladio.Identifier;

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
			for (int j = 0; j < aMatrix.LengthX; j++)
			{
				result = new ScalarAddition(aMatrix.Context, result, aMatrix[row, j]);
			}
			return result.Calculate();
		}

		public static ScalarExpressionValue SetValue(ref Variable var, double val)
		{
			ScalarExpressionValue exprVal = new ScalarExpressionValue(var.Context, val);
			((ScalarExpressionVariable) var).Value = exprVal;
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
				FSMFactory.CreateDefaultInput(input),
				FSMFactory.CreateDefaultState(destinationState));
		}

		public static IAttributeHash CreateAttributeHash()
		{
			return AttributesFactory.Default.CreateAttributeHash();
		}

	}
}