/*
 * $Id$
 * 
 * $Log$
 * Revision 1.2  2004/09/09 04:07:52  sliver
 * code refactored
 * vs.net project files created
 *
 * Revision 1.1  2004/07/12 06:33:03  sliver
 * Initial checkin
 * 
 */

using System.Collections;
using cdrnet.Lib.MathLib.Core;
using cdrnet.Lib.MathLib.Scalar;

namespace Palladio.Reliability.Math
{
	/// <summary>
	/// An IVariableExpression adds information about the variables contained
	/// in an IScalarExpression to the expression.		
	/// </summary>
	public interface IVariableExpression
	{
		/// <summary>
		/// Represented mathematical expression.
		/// </summary>
		IScalarExpression Expression { get; }

		/// <summary>
		/// Set of variables used by the expression above.
		/// </summary>
		ICollection VariableSet { get; }

		/// <summary>
		/// Variables used by the expression above.
		/// </summary>
		Variable[] Variables { get; }

		/// <summary>
		/// Indicates whether the expression has variables or not.
		/// </summary>
		bool HasVariables { get; }
	}
}