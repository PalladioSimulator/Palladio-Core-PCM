/*
 * $Id$
 * 
 * $Log$
 * Revision 1.3  2004/09/09 04:07:52  sliver
 * code refactored
 * vs.net project files created
 *
 * Revision 1.2  2004/07/13 02:14:50  sliver
 * Added comments
 *
 * Revision 1.1  2004/07/12 06:33:04  sliver
 * Initial checkin
 * 
 */

using System.Diagnostics;
using cdrnet.Lib.MathLib.Core;
using cdrnet.Lib.MathLib.Scalar;
using cdrnet.Lib.MathLib.Scalar.LinearAlgebra;
using Palladio.FiniteStateMachines;
using Palladio.Reliability.TypedCollections;
using Palladio.Utils.Collections;

namespace Palladio.Reliability.Math
{
	/// <summary>
	/// The class ServiceReliability contains information about the 
	/// reliability of a service. It can be a given or calculated value, 
	/// the name of a variable, or a calculated function.
	/// </summary>
	public class ServiceReliability : VariableExpression
	{
		#region Constructors

		/// <summary>
		/// Creates a new ServiceReliability with the constant value
		/// aValue. The value must be inbetween 0 and 1.
		/// </summary>
		/// <param name="aValue">Value of the reliability.</param>
		public ServiceReliability(double aValue) : base(aValue)
		{
			Trace.Assert(aValue >= 0);
			Trace.Assert(aValue <= 1);
		}

		/// <summary>
		/// Creates a new ServiceReliability with a variable representing
		/// its value.
		/// </summary>
		/// <param name="aVarName">Name of the Variable.</param>
		public ServiceReliability(string aVarName) : base(aVarName)
		{
		}

		/// <summary>
		/// Calculates the ServiceReliability out of a Markov Model describing the
		/// usage profile of the service and the reliability of external services.
		/// </summary>
		/// <param name="aMarkovModel">FSM with annotated transition. Each transition 
		/// must contain a MarkovProbabilityAttribute.</param>
		/// <param name="anExtReliabilityHash">Hashtable containing information about the reliability of 
		/// the external services used by aMarkovModel.</param>
		public ServiceReliability(IFiniteStateMachine aMarkovModel, ReliabilityHash anExtReliabilityHash)
		{
			MarkovMatrix aMarkovMatrix = new MarkovMatrix(new Context(), aMarkovModel, anExtReliabilityHash);
			expression = CalculateReliability(aMarkovMatrix);
			variableSet = new Set(VariableExpression.GetVariables(expression));

		}

		#endregion

		#region Private Methods

		/// <summary>
		/// Uses aMarkovMatrix to calculate the reliability of a service. At first aMarkovMatrix
		/// is substracted from the identity matrix. Then the result is inverted. The service
		/// reliability is the value at position [start state, final state] of the matrix. It indicates
		/// the probability of a successful walk through the FSM from the start state to the final
		/// state.
		/// </summary>
		/// <param name="aMarkovMatrix">Makrov matrix describing the probabilities of successful 
		/// transtions between two states of a FSM.</param>
		/// <returns>An expression for the reliability of the service associated with aMarkovMatrix.</returns>
		private IScalarExpression CalculateReliability(MarkovMatrix aMarkovMatrix)
		{
			IMatrixExpression matrix = aMarkovMatrix.Matrix.Expand();
			MatrixIdentity identity = new MatrixIdentity(matrix.Context, new ScalarExpressionValue(matrix.Context, matrix.LengthX));
			matrix = new MatrixMatrixSubtraction(matrix.Context, identity.Expand(), matrix);
			ScalarMatrix invers = MatrixTools.Invert(matrix);
			IScalarExpression result = invers[ aMarkovMatrix.FinalStateIndex, aMarkovMatrix.StartStateIndex].Simplify();
			ScalarConversionMap.Convert(ref result, "simple");
			return result;
		}

		#endregion
	}
}