/*
 * $Id$
 * 
 * $Log$
 * Revision 1.2  2004/11/18 06:53:17  sliver
 * *** empty log message ***
 *
 * Revision 1.1  2004/11/04 08:52:14  sliver
 * added regular expressions
 *
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

using MathNet.Numerics.LinearAlgebra;
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

		public TransitionMatrix(IMarkovModel aMarkovModel, ReliabilityHashtable anExtReliabilityHashtable)
		{
			matrix = CreateTransitionMatrix(aMarkovModel, anExtReliabilityHashtable);
			startStateIndex = aMarkovModel.StartStateIndex;
			finalStateIndex = aMarkovModel.FinalStateIndex;
		}

		public TransitionMatrix(IMarkovModel aMarkovModel) : this(aMarkovModel, new ReliabilityHashtable())
		{
		}

		public TransitionMatrix(Matrix aMatrix, int aStartStateIndex, int aFinalStateIndex)
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
		public override Matrix Matrix
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
			double[,] shrinked = new double[indices.Length,indices.Length];
			for (int i = 0; i < indices.Length; i++)
				for (int j = 0; j < indices.Length; j++)
				{
					shrinked[i, j] = Matrix[indices[i], indices[j]];
				}
			Matrix shrinkedMx = new Matrix(shrinked);
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
		private Matrix CreateTransitionMatrix(IMarkovModel aMarkovModel, ReliabilityHashtable anExternalReliabiltyHash)
		{
			int rank = aMarkovModel.FSM.States.Length + 1;
			double[,] transitionExprs = CreateZeroExpressionMatrix(rank);

			foreach (ITransition transition in aMarkovModel.FSM.Transitions)
			{
				int i = aMarkovModel.GetStateIndex(transition.SourceState);
				int j = aMarkovModel.GetStateIndex(transition.DestinationState);
				double serviceRel = (double)anExternalReliabiltyHash[transition.InputSymbol.ID];
				ProbabilityAttribute probabilityAttr = ProbabilityAttribute.GetAttribute(transition);

				double successProb = probabilityAttr.Probability;
				if (serviceRel != 0d)
					successProb *= serviceRel;

				transitionExprs[i, j] += successProb;
			}

			foreach (IState state in aMarkovModel.FSM.FinalStates)
			{
				double markovProb = 1d;
				foreach (ITransition transition in aMarkovModel.FSM.GetOutgoingTransitions(state))
				{
					ProbabilityAttribute probabilityAttr = ProbabilityAttribute.GetAttribute(transition);
					markovProb -= probabilityAttr.Probability;
				}
				int i = aMarkovModel.GetStateIndex(state);
				transitionExprs[i, rank - 1] = markovProb;
			}

			return new Matrix(transitionExprs);
		}

		/// <summary>
		/// Creates a new aRang x aRang array of doubles and initializes it with zeros.
		/// </summary>
		/// <param name="aRang">Rang of the new matrix.</param>
		private double[,] CreateZeroExpressionMatrix(int aRang)
		{
			double[,] result = new double[aRang,aRang];
			for (int i = 0; i < aRang; i++)
				for (int j = 0; j < aRang; j++)
					result[i, j] = 0;
			return result;
		}

		#endregion

		#region Data

		private Matrix matrix;
		private int startStateIndex;
		private int finalStateIndex;

		#endregion
	}
}