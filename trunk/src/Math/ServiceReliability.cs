/*
 * $Id$
 * 
 * $Log$
 * Revision 1.5  2004/10/25 07:07:21  sliver
 * implementation of
 * - functions discrete, including convolution
 * - path segmentation of FSMs
 * - prediction of time consuption using density functions
 *
 * Revision 1.4  2004/09/23 00:44:14  sliver
 * - major refactorings
 * - changed TypedCollections to CodeSmith generated files
 * - introduced MakrovModel
 * - added Transition-, Potential-, VisitProbability-, and VisitsOnPath- matrix types
 *
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
		/// <param name="anExtReliabilityHashmap">Hashtable containing information about the reliability of 
		/// the external services used by aMarkovModel.</param>
		public ServiceReliability(IMarkovModel aMarkovModel, ReliabilityHashmap anExtReliabilityHashmap)
		{
			ITransitionMatrix tMx = new TransitionMatrix(aMarkovModel, anExtReliabilityHashmap);
			IPotentialMatrix pMx = new PotentialMatrix(tMx);
			expression = pMx.Matrix[pMx.StartStateIndex, pMx.FinalStateIndex];
			variableSet = new Set(VariableExpression.GetVariables(expression));
		}

		#endregion
	}
}