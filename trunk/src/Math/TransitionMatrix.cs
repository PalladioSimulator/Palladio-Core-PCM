/*
 * $Id$
 * 
 * $Log$
 * Revision 1.2  2004/10/25 07:07:21  sliver
 * implementation of
 * - functions discrete, including convolution
 * - path segmentation of FSMs
 * - prediction of time consuption using density functions
 *
 * Revision 1.1  2004/09/23 00:44:14  sliver
 * - major refactorings
 * - changed TypedCollections to CodeSmith generated files
 * - introduced MakrovModel
 * - added Transition-, Potential-, VisitProbability-, and VisitsOnPath- matrix types
 *
 */

using cdrnet.Lib.MathLib.Core;
using cdrnet.Lib.MathLib.Scalar;
using cdrnet.Lib.MathLib.Scalar.LinearAlgebra;
using Palladio.FiniteStateMachines;
using Palladio.Reliability.Attributes;
using Palladio.Reliability.TypedCollections;

namespace Palladio.Reliability.Math
{
	/// <summary>
	/// Transition matrix P of the Markov model. It contains the probabilities to 
	/// successfully reach another state from a source state with one transition.
	/// </br>
	/// To handle multiple final states, it contains a new, superior finalstate and
	/// transitions  with probabilities of 1.0 - (sum of outgoing transitions) form the
	/// final states of the FSM to the new final state.
	/// </summary>
	public class TransitionMatrix : AbstractMarkovMatrix, ITransitionMatrix
	{
		#region Constructors

		public TransitionMatrix(IMarkovModel aMarkovModel, ReliabilityHashmap anExtReliabilityHashmap)
		{
			matrix = CreateTransitionMatrix(aMarkovModel, anExtReliabilityHashmap);
			startStateIndex = aMarkovModel.StartStateIndex;
			finalStateIndex = aMarkovModel.FinalStateIndex;
		}

		public TransitionMatrix(IMarkovModel aMarkovModel) : this(aMarkovModel, new ReliabilityHashmap())
		{
		}

		public TransitionMatrix(ScalarMatrix aMatrix, int aStartStateIndex, int aFinalStateIndex)
		{
			matrix = aMatrix;
			finalStateIndex = aFinalStateIndex;
			startStateIndex = aStartStateIndex;
		}

		#endregion

		#region Properties

		/// <summary>
		/// Index of the start state in the Markov Matrix.
		/// </summary>
		public override int StartStateIndex
		{
			get { return startStateIndex; }
		}

		/// <summary>
		/// Index of the final state in the Markov Matrix.
		/// </summary>
		public override int FinalStateIndex
		{
			get { return finalStateIndex; }
		}

		/// <summary>
		/// Transition matrix.
		/// </summary>
		public override ScalarMatrix Matrix
		{
			get { return matrix; }
		}

		#endregion

		#region Public Methods

		/// <summary>
		/// Shrinks the matrix to the rows and columns with the selected indices. It is assumed
		/// that indices[0] is the start state index and indices[length-1] is the final state index.
		/// </summary>
		/// <param name="indices"></param>
		/// <returns></returns>
		public ITransitionMatrix ShrinkTo(params int[] indices)
		{
			IScalarExpression[,] shrinked = new IScalarExpression[indices.Length,indices.Length];
			for (int i = 0; i < indices.Length; i++)
				for (int j = 0; j < indices.Length; j++)
				{
					shrinked[i, j] = Matrix[indices[i], indices[j]];
				}
			ScalarMatrix shrinkedMx = new ScalarMatrix(new Context(), shrinked);
			return new TransitionMatrix(shrinkedMx, 0, indices.Length - 1);
		}

		#endregion

		#region Private Methods

		/// <summary>
		/// Creates a new MarkovMatrix using aMarkovModel and the given external reliabilities.
		/// </summary>
		/// <param name="aMarkovModel">FSM describing the Markov Model.</param>
		/// <param name="anExternalReliabiltyHash">Hashtable association external services with a certain reliability.</param>
		/// <returns>The Markov Matrix according to aFSM.</returns>
		private ScalarMatrix CreateTransitionMatrix(IMarkovModel aMarkovModel, ReliabilityHashmap anExternalReliabiltyHash)
		{
			Context cx = new Context();
			int rank = aMarkovModel.FSM.States.Length + 1;
			IScalarExpression[,] transitionExprs = CreateZeroExpressionMatrix(cx, rank);

			foreach (ITransition transition in aMarkovModel.FSM.Transitions)
			{
				int i = aMarkovModel.GetStateIndex(transition.SourceState);
				int j = aMarkovModel.GetStateIndex(transition.DestinationState);
				IVariableExpression serviceRel = anExternalReliabiltyHash[ transition.InputSymbol.ID ];
				MarkovAttribute markovAttr = MarkovAttribute.GetAttribute(transition);

				IScalarExpression successProb = markovAttr.Probability.Expression;
				if (serviceRel != null)
					successProb = new ScalarMultiplication(cx, successProb, serviceRel.Expression).Expand().Simplify();

				IScalarExpression currentExpr = transitionExprs[i, j];
				transitionExprs[i, j] = new ScalarAddition(cx, currentExpr, successProb).Expand().Simplify();
			}

			foreach (IState state in aMarkovModel.FSM.FinalStates)
			{
				IScalarExpression markovProb = new ScalarExpressionValue(cx, 1.0);
				foreach (ITransition transition in aMarkovModel.FSM.GetOutgoingTransitions(state))
				{
					MarkovAttribute markovAttr = MarkovAttribute.GetAttribute(transition);
					markovProb = new ScalarSubtraction(cx, markovProb, markovAttr.Probability.Expression).Expand().Simplify();
				}
				int i = aMarkovModel.GetStateIndex(state);
				transitionExprs[i, rank - 1] = markovProb;
			}

			return new ScalarMatrix(cx, transitionExprs);
		}

		/// <summary>
		/// Creates a new aRang x aRang array of IScalarExpressions and initializes it with zeros.
		/// </summary>
		/// <param name="aContext">Mathematical context.</param>
		/// <param name="aRang">Rang of the new matrix.</param>
		private IScalarExpression[,] CreateZeroExpressionMatrix(Context aContext, int aRang)
		{
			IScalarExpression[,] result = new IScalarExpression[aRang,aRang];
			for (int i = 0; i < aRang; i++)
				for (int j = 0; j < aRang; j++)
					result[i, j] = new ScalarExpressionValue(aContext, 0.0);
			return result;
		}

		#endregion

		#region Data

		private ScalarMatrix matrix;
		private int startStateIndex;
		private int finalStateIndex;

		#endregion
	}
}