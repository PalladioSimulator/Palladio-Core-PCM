/*
 * $Id$
 * 
 * $Log$
 * Revision 1.1  2004/09/23 00:44:14  sliver
 * - major refactorings
 * - changed TypedCollections to CodeSmith generated files
 * - introduced MakrovModel
 * - added Transition-, Potential-, VisitProbability-, and VisitsOnPath- matrix types
 *
 * Revision 1.4  2004/09/09 04:07:52  sliver
 * code refactored
 * vs.net project files created
 *
 * Revision 1.3  2004/07/19 04:37:48  sliver
 * extracted attributes
 *
 * Revision 1.2  2004/07/13 02:14:49  sliver
 * Added comments
 *
 * Revision 1.1  2004/07/12 06:33:03  sliver
 * Initial checkin
 * 
 */


using System.Collections;
using System.Diagnostics;
using cdrnet.Lib.MathLib.Core;
using cdrnet.Lib.MathLib.Scalar;
using cdrnet.Lib.MathLib.Scalar.LinearAlgebra;
using Palladio.FiniteStateMachines;
using Palladio.FiniteStateMachines.Exceptions;
using Palladio.Identifier;
using Palladio.Reliability.Attributes;
using Palladio.Reliability.TypedCollections;

namespace Palladio.Reliability.Math
{
	/// <summary>
	/// Description of MarkovMatirx.	
	/// </summary>
	public class MarkovModelInfo
	{
		#region Properties

		/// <summary>
		/// Transition matrix P of the Markov model. It contains the probabilities to 
		/// successfully reach another state from a source state with one transition.
		/// </br>
		/// To handle multiple final states, it contains a new, superior finalstate and
		/// transitions  with probabilities of 1.0 - (sum of outgoing transitions) form the
		/// final states of the FSM to the new final state.
		/// </summary>
		public ScalarMatrix TransitionMatrix
		{
			get { return transitonMatrix; }
		}

		/// <summary>
		/// Limit of the series \sum_(k=0)^(\infty) P^k </br>
		/// The elements R(i,j) of this matrix are the expected number
		/// of visits to state j starting in state i.
		/// </summary>
		public ScalarMatrix PotentialMatrix
		{
			get { return potentialMatrix; }
		}

		/// <summary>
		/// The elements F(i,j) of this matrix are the probability of reaching
		/// state j in an arbitrary number of steps starting in state i.
		/// If i=j, F(i,j) is the probability to ever return to state i.
		/// </summary>
		public ScalarMatrix VisitProbabilityMatrix
		{
			get { return visitProbabilityMatrix; }
		}


		/// <summary>
		/// Each element S(i,j) of the matrix contains the expected number
		/// of visits of state i on an abritary path (including intermediate 
		/// visits to j) to state j starting in the start state of the Markov model.
		/// </summary>
		public ScalarMatrix VisitsOnPathMatrix
		{
			get { return visitsOnPathMatrix; }
		}

		/// <summary>
		/// The FSM representing the Markov model.
		/// </summary>
		public IFiniteStateMachine MarkovModel
		{
			get { return markovModel; }
		}

		/// <summary>
		/// Index of the start state in the Markov Matrix.
		/// </summary>
		public int StartStateIndex
		{
			get { return GetStateIndex(markovModel.StartState); }
		}

		/// <summary>
		/// Index of the final state in the Markov Matrix.
		/// </summary>
		public int FinalStateIndex
		{
			get { return transitonMatrix.LengthX - 1; }
		}

		#endregion

		#region Constructors

		/// <summary>
		/// Creates a new MarkovMatrix whichs probabilities indicate the
		/// <b>successful</b> transition from a source state to a destiation state. It takes
		/// into account the reliability of external services.
		/// </br>
		/// If the reliability of an external service is not given, it is assumed to be 1.
		/// </summary>
		/// <param name="aContext">Mathematical context.</param>
		/// <param name="aMarkovModel">FSM with the MarkovProabilityAttribute annotated to its transitions.</param>
		/// <param name="anExtReliabilityHashmap">Hash assigning a ServiceReliability to external services.</param>
		public MarkovModelInfo(Context aContext, IFiniteStateMachine aMarkovModel, ReliabilityHashmap anExtReliabilityHashmap)
		{
			Trace.Assert(CheckPreconditions(aMarkovModel));
			this.context = aContext;
			this.markovModel = aMarkovModel;
			this.externalReliabilityHash = anExtReliabilityHashmap;
			this.state2intHash = CreateState2IntHash();
			this.transitonMatrix = CreateTransitionMatrix(context, markovModel, externalReliabilityHash);
			this.potentialMatrix = CreatePotentialMatrix(this.transitonMatrix);
			this.visitProbabilityMatrix = CreateVisitProbabilityMatrix(this.potentialMatrix);
			this.visitsOnPathMatrix = CreateVisitsOnPathMatrix(this.potentialMatrix, this.visitProbabilityMatrix);
		}


		/// <summary>
		/// Creates a new MarkovMatrix whichs cells contain the probabilities of transition
		/// from a source state to a destination state.
		/// </summary>
		/// <param name="aContext">Mathematical context.</param>
		/// <param name="aMarkovModel">FSM with the MarkovProabilityAttribute annotated to its transitions.</param>
		public MarkovModelInfo(Context aContext, IFiniteStateMachine aMarkovModel) : this(aContext, aMarkovModel, new ReliabilityHashmap())
		{
		}

		#endregion

		#region Public Methods

		/// <summary>
		/// Returns the index of a given state. The index+1
		/// correspondes to the row/column of the matrix which
		/// represents the state.
		/// </summary>
		/// <param name="state"></param>
		/// <returns></returns>
		public int GetStateIndex(IState state)
		{
			object obj = state2intHash[state.ID];
			if (obj == null)
				throw new StateNotFoundException(state);
			return (int) obj;
		}

		#endregion

		#region Private Methods

		/// <summary>
		/// Creates a Hashtable associating an unique integer number with each state
		/// of the FSM.
		/// </summary>
		private Hashtable CreateState2IntHash()
		{
			Hashtable state2intHash = new Hashtable();
			ArrayList stateList = new ArrayList();
			foreach (IState state in markovModel.States)
			{							  
				stateList.Add(state.ID);
			}
			stateList.Sort();
			for (int i = 0; i < stateList.Count; i++)
			{
				state2intHash.Add(stateList[i], i);
			}
			return state2intHash;
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


		/// <summary>
		/// Creates a new MarkovMatrix using aFSM and the given external reliabilities.
		/// </summary>
		/// <param name="aContext">Mathematical context.</param>
		/// <param name="aMarkovModel">FSM describing the Markov Model.</param>
		/// <param name="anExternalReliabiltyHash">Hashtable association external services with a certain reliability.</param>
		/// <returns>The Markov Matrix according to aFSM.</returns>
		private ScalarMatrix CreateTransitionMatrix(Context aContext, IFiniteStateMachine aMarkovModel, ReliabilityHashmap anExternalReliabiltyHash)
		{
			int rank = aMarkovModel.States.Length + 1;
			IScalarExpression[,] transitionExprs = CreateZeroExpressionMatrix(aContext, rank);

			foreach (ITransition transition in markovModel.Transitions)
			{
				int i = GetStateIndex(transition.SourceState);
				int j = GetStateIndex(transition.DestinationState);
				IVariableExpression serviceRel = anExternalReliabiltyHash[ (IIdentifiable) transition.InputSymbol.ID ];
				MarkovAttribute markovAttr = MarkovAttribute.GetAttribute(transition);

				IScalarExpression successProb = markovAttr.Probability.Expression;
				if (serviceRel != null)
					successProb = new ScalarMultiplication(aContext, successProb, serviceRel.Expression).Expand().Simplify();

				IScalarExpression currentExpr = transitionExprs[i, j];
				transitionExprs[i, j] = new ScalarAddition(context, currentExpr, successProb).Expand().Simplify();
			}

			foreach (IState state in aMarkovModel.FinalStates)
			{
				IScalarExpression markovProb = new ScalarExpressionValue(context, 1.0);
				foreach (ITransition transition in aMarkovModel.GetOutgoingTransitions(state))
				{
					MarkovAttribute markovAttr = MarkovAttribute.GetAttribute(transition);
					markovProb = new ScalarSubtraction(context, markovProb, markovAttr.Probability.Expression).Expand().Simplify();
				}
				int i = GetStateIndex(state);
				transitionExprs[i, rank - 1] = markovProb;
			}

			return new ScalarMatrix(context, transitionExprs);
		}

		/// <summary>
		/// Checks if all transitions of aMarkovModel contain a MarkovProbabilityAttribute.
		/// </summary>
		/// <returns>True, if all transitions contain a MarkovProbabilityAttribute, false otherwise.</returns>
		private bool CheckPreconditions(IFiniteStateMachine markovModel)
		{
			foreach (ITransition transition in markovModel.Transitions)
			{
				if (MarkovAttribute.GetAttribute(transition) == null)
					return false;
			}
			return true;
		}

		private ScalarMatrix CreatePotentialMatrix(IMatrixExpression probabilityMx)
		{
			Trace.Assert(probabilityMx.LengthX == probabilityMx.LengthY, "probabilityMatrix.LengthX == probabilityMatrix.LengthY");
			Context context = probabilityMx.Context;
			int rank = probabilityMx.LengthX;
			IScalarExpression rankExpr = new ScalarExpressionValue(context, rank);
			IMatrixExpression idMx = new MatrixIdentity(probabilityMx.Context, rankExpr).Expand();
			IMatrixExpression idMinusProbMx = new MatrixMatrixSubtraction(context, idMx, probabilityMx).Expand();
			return MatrixTools.Invert(idMinusProbMx).Expand();
		}

		private ScalarMatrix CreateVisitProbabilityMatrix(IMatrixExpression potentialMx)
		{
			Trace.Assert(potentialMx.LengthX == potentialMx.LengthY, "potentialMx.LengthX == potentialMx.LengthY");
			Context cx = potentialMx.Context;
			int rank = potentialMatrix.LengthX;
			IScalarExpression one = new ScalarExpressionValue(cx, 1.0);
			ScalarMatrix pMx = potentialMatrix.Expand();
			IScalarExpression[,] fExprs = new IScalarExpression[rank,rank];
			for (int i = 0; i < pMx.LengthX; i++)
			{
				for (int j = 0; j < pMx.LengthY; j++)
				{
					if (i == j)
					{
						// F(i,j) = 1 - 1 / R(i,j) for i==j
						fExprs[i, j] = new ScalarSubtraction(cx, one, new ScalarDivision(cx, one, pMx[i, j])).Expand();
					}
					else
					{
						// F(i,j) = R(i,j)/R(j,j) for i!=j
						fExprs[i, j] = new ScalarDivision(cx, pMx[i, j], pMx[j, j]).Expand();
					}
				}
			}
			return new ScalarMatrix(cx, fExprs);
		}

		private ScalarMatrix CreateVisitsOnPathMatrix(ScalarMatrix potentialMx, ScalarMatrix visitProbabilityMx)
		{
			Trace.Assert(potentialMx.LengthX == potentialMx.LengthY, "potentialMx.LengthX == potentialMx.LengthY");
			Trace.Assert(visitProbabilityMx.LengthX == visitProbabilityMx.LengthY, "visitProbabilityMx.LengthX == visitProbabilityMx.LengthY");
			int rank = potentialMx.LengthX;
			Context cx = potentialMx.Context;
			IScalarExpression[,] visitsExprs = new IScalarExpression[rank,rank];

			for (int i = 0; i < potentialMx.LengthX; i++)
				for (int j = 0; j < potentialMx.LengthY; j++)
				{
					if (i == j)
					{
						// for i == j the expected number of visits of i on an arbitrary path from 
						// the start state to j(=i) equals the expected number of visits to i
						visitsExprs[i, j] = potentialMx[StartStateIndex, i];
					}
					else
					{
						// for i != j the expected number of visits of i on an arbitrary path from 
						// the start state to j is P(s,i)*F(i,j), the expected number of visits to
						// state i starting in s (=start state) multiplied by the probability of ever
						// reaching state j from state i.
						visitsExprs[i, j] = new ScalarMultiplication(cx, potentialMx[StartStateIndex, i], visitProbabilityMx[i, j]).Expand();
					}
				}
			return new ScalarMatrix(cx, visitsExprs);
		}

		#endregion

		#region Data

		private IFiniteStateMachine markovModel;
		private ScalarMatrix transitonMatrix;
		private ScalarMatrix potentialMatrix;
		private ScalarMatrix visitProbabilityMatrix;
		private ScalarMatrix visitsOnPathMatrix;
		private ReliabilityHashmap externalReliabilityHash;
		private Context context;
		private Hashtable state2intHash;

		#endregion
	}
}