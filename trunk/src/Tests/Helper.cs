/*
 * $Id$
 * 
 * $Log$
 * Revision 1.9  2004/11/18 06:53:17  sliver
 * *** empty log message ***
 *
 * Revision 1.8  2004/11/08 03:50:06  sliver
 * *** empty log message ***
 *
 * Revision 1.7  2004/11/04 08:52:13  sliver
 * added regular expressions
 *
 * Revision 1.6  2004/10/25 07:07:21  sliver
 * implementation of
 * - functions discrete, including convolution
 * - path segmentation of FSMs
 * - prediction of time consuption using density functions
 *
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


using MathNet.Numerics;
using MathNet.Numerics.LinearAlgebra;
using Palladio.Attributes;
using Palladio.FiniteStateMachines;
using Palladio.Identifier;
using Palladio.Math;
using Palladio.Reliability.Attributes;
using Palladio.Math;

namespace Palladio.Reliability.Tests
{
	/// <summary>
	/// Description of Helper.	
	/// </summary>
	public class Helper
	{
		public static double SumUpRow(Matrix aMatrix, int row)
		{
			double result = 0;
			for (int j = 0; j < aMatrix.ColumnDimension; j++)
			{
				result += aMatrix[row, j];
			}
			return result;
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

		public static ITransition CreateTransition(IState from, IInput input, IState to, double prob)
		{
			ITransition transition = FSMFactory.CreateDefaultTransition(
				from,
				input,
				to);
			ProbabilityAttribute.SetAttribute(transition, prob);
			return transition;
		}

		public static ITransition CreateTransition(IState from, IMatchable m, IState to, double prob)
		{
			ITransition transition = FSMFactory.CreateDefaultTransition(
				from,
				FSMFactory.CreateDefaultInput(m),
				to);
			ProbabilityAttribute.SetAttribute(transition, prob);
			return transition;
		}

		public static ITransition CopyTransition(ITransition transition)
		{
			return CreateTransition(transition.SourceState, transition.InputSymbol, transition.DestinationState, ProbabilityAttribute.GetAttribute(transition).Probability);
		}

		public static StateHash CreateStates(params string[] anIDArray)
		{
			StateHash result = new StateHash();

			IFunction df = MathTools.DiscreteFunctions.ExponentialDistribution(1);
			foreach (string id in anIDArray)
			{
				IState state = CreateState(id);
				TimeAttribute.SetAttribute(state, df);
				result.Add(state);
			}
			return result;
		}

		public static IState CreateState(string anID)
		{
			IState s = FSMFactory.CreateDefaultState(anID);
			return s;
		}

		public static IAttributeHash CreateAttributeHash()
		{
			return AttributesFactory.Default.CreateAttributeHash();
		}

	}
}