/*
 * $Id$
 * 
 * $Log$
 * Revision 1.1  2004/07/12 06:33:03  sliver
 * Initial checkin
 * 
 */


using System;
using System.Collections;
using System.Diagnostics;

using Palladio.FiniteStateMachines;
using Palladio.Reliability.TypedCollections;
using Palladio.ComponentModel;

using cdrnet.Lib.MathLib.Core;
using cdrnet.Lib.MathLib.Scalar;
using cdrnet.Lib.MathLib.Scalar.LinearAlgebra;
using cdrnet.Lib.MathLib.Parsing;
using cdrnet.Lib.MathLib.Exceptions;
using cdrnet.Lib.MathLib.Tools;

namespace Palladio.Reliability.Math
{
	/// <summary>
	/// Description of MarkovMatirx.	
	/// </summary>
	public class MarkovMatrix
	{
		#region Properties
		
		/// <summary>
		/// The calculated Markov Matrix. It contains the probabilities to 
		/// successfully reach another state from a source state with one transition.
		/// </br>
		/// To handle multiple final states, it contains a new, superior finalstate and
		/// transitions  with probabilities of 1.0 - (sum of outgoing transitions) form the
		/// final states of the FSM to the new final state.
		/// </summary>
		public ScalarMatrix Matrix
		{
			get { return matrix; }
		}
		
		/// <summary>
		/// The original Markov Model.
		/// </summary>
		public IFiniteStateMachine FSM
		{
			get { return fsm; }
		}
		
		/// <summary>
		/// Index of the start state in the Markov Matrix.
		/// </summary>
		public int StartStateIndex
		{
			get { return (int)stateNumHash[fsm.StartState.ID]; }
		}
		
		/// <summary>
		/// Index of the final state in the Markov Matrix.
		/// </summary>
		public int FinalStateIndex
		{
			get { return matrix.LengthX - 1; }
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
		/// <param name="anExtReliabilityHash">Hash assigning a ServiceReliability to external services.</param>
		public MarkovMatrix(Context aContext, IFiniteStateMachine aMarkovModel, ReliabilityHash anExtReliabilityHash)
		{
			Trace.Assert( CheckPreconditions(aMarkovModel) );
			this.context = aContext;
			this.fsm = aMarkovModel;
			this.extReliabilityHash = anExtReliabilityHash;
			this.stateNumHash = CreateStateNumberHash();
			this.matrix = CreateMarkovMatrix(context, fsm, extReliabilityHash, stateNumHash);
		}
		
		/// <summary>
		/// Creates a new MarkovMatrix whichs cells contain the probabilities of transition
		/// from a source state to a destination state.
		/// </summary>
		/// <param name="aContext">Mathematical context.</param>
		/// <param name="aMarkovModel">FSM with the MarkovProabilityAttribute annotated to its transitions.</param>
		public MarkovMatrix(Context aContext, IFiniteStateMachine aMarkovModel)
		{
			Trace.Assert( CheckPreconditions(aMarkovModel) );
			this.context = aContext;
			this.fsm = aMarkovModel;
			this.extReliabilityHash = new ReliabilityHash();
			this.stateNumHash = CreateStateNumberHash();
			this.matrix = CreateMarkovMatrix(context, fsm, extReliabilityHash, stateNumHash);
		}
		#endregion
		
		#region Private Methods

		/// <summary>
		/// Creates a Hashtable associating an unique integer number with each state
		/// of the FSM.
		/// </summary>
		private Hashtable CreateStateNumberHash()
		{
			Hashtable stateNumHash = new Hashtable();
			for (int i = 0; i<fsm.States.Length; i++)
			{
				stateNumHash.Add(fsm.States[i].ID, i);
			}
			return stateNumHash;
		}
		
		/// <summary>
		/// Creates a new aRang x aRang array of IScalarExpressions and initializes it with zeros.
		/// </summary>
		/// <param name="aContext">Mathematical context.</param>
		/// <param name="aRang">Rang of the new matrix.</param>
		private IScalarExpression[,] CreateInitialMatrix(Context aContext, int aRang)
		{
			IScalarExpression[,] result = new IScalarExpression[aRang, aRang];
			for (int i=0; i<aRang; i++)
				for (int j=0; j<aRang; j++)
					result[i,j] = new ScalarExpressionValue(aContext,0.0);
			return result;
		}
		
		
		/// <summary>
		/// Creates a new MarkovMatrix using aFSM and the given external reliabilities.
		/// </summary>
		/// <param name="aContext">Mathematical context.</param>
		/// <param name="aFSM">FSM describing the Markov Model.</param>
		/// <param name="anExtReliabilityHash">Hashtable association external services with a certain reliability.</param>
		/// <param name="aStateNumHash">Hashtable associating an unique identifier with each state of aFSM.</param>
		/// <returns>The Markov Matrix according to aFSM.</returns>
		private ScalarMatrix CreateMarkovMatrix(Context aContext, IFiniteStateMachine aFSM, ReliabilityHash anExtReliabilityHash, Hashtable aStateNumHash)
		{
			int rang = aFSM.States.Length + 1;
			IScalarExpression[,] result = CreateInitialMatrix(aContext, rang);
			
			foreach (ITransition t in fsm.Transitions)
			{
				int x = (int)aStateNumHash[t.DestinationState.ID];
				int y = (int)aStateNumHash[t.SourceState.ID];
				ServiceReliability serviceRel = anExtReliabilityHash[ (IExternalSignature)t.InputSymbol.ID ];
				MarkovProbabilityAttribute markovProb = (MarkovProbabilityAttribute) t.Attributes[ MarkovProbabilityAttribute.AttributeType ];
				
				IScalarExpression successProb = markovProb.Expression;
				if ( serviceRel != null ) successProb = new ScalarMultiplication( aContext, successProb, serviceRel.Expression);				
				
				IScalarExpression currentExpr = result[x,y];
				result[x,y] = new ScalarAddition( context, currentExpr, successProb );
			}
			
			foreach (IState state in aFSM.FinalStates)
			{
				IScalarExpression markovProb = new ScalarExpressionValue(context, 1.0);
				foreach (ITransition trans in aFSM.GetOutgoingTransitions(state))
				{
					MarkovProbabilityAttribute outMarkovProb = (MarkovProbabilityAttribute) trans.Attributes[ MarkovProbabilityAttribute.AttributeType ];
					markovProb = new ScalarSubtraction( context, markovProb, outMarkovProb.Expression );
				}
				int y = (int)aStateNumHash[state.ID];
				result[rang-1,y] = markovProb;
			}
			
			return new ScalarMatrix(context, result);
		}

		/// <summary>
		/// Checks if all transitions of aMarkovModel contain a MarkovProbabilityAttribute.
		/// </summary>
		/// <returns>True, if all transitions contain a MarkovProbabilityAttribute, false otherwise.</returns>
		private bool CheckPreconditions(IFiniteStateMachine markovModel)
		{
			foreach (ITransition t in markovModel.Transitions)
			{
				if (!t.Attributes.Contains(MarkovProbabilityAttribute.AttributeType))
					return false;
			}
			return true;
		}
		#endregion
		
		#region Data
		
		private IFiniteStateMachine fsm;
		private ScalarMatrix matrix;
		private ReliabilityHash extReliabilityHash;
		private Context context;
		private Hashtable stateNumHash;
		#endregion
	}
}
