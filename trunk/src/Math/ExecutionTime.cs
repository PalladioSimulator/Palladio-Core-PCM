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
 */

using System;
using System.Diagnostics;
using cdrnet.Lib.MathLib.Core;
using cdrnet.Lib.MathLib.Scalar;
using Palladio.FiniteStateMachines;
using Palladio.Reliability.Attributes;

namespace Palladio.Reliability.Math
{
	/// <summary>
	/// </summary>
	public class ExecutionTime : IExecutionTime
	{
		public IVariableExpression Total
		{
			get { return totalTime; }
		}

		public IVariableExpression[] PathToState
		{
			get { return pathToStateTimes; }
		}

		public MarkovModelInfo ModelInfo
		{
			get { return markovModelInfo; }
		}

		public IFiniteStateMachine MarkovModel
		{
			get { return markovModelInfo.MarkovModel; }
		}

		public int GetStateIndex(IState state)
		{
			return markovModelInfo.GetStateIndex(state);
		}
		
		public ExecutionTime(MarkovModelInfo mmInfo)
		{
			CheckPreconditions(mmInfo);
			markovModelInfo = mmInfo;

			IVariableExpression[] stateTimes = ExtractStateTimes();
			totalTime = CalculateTotalTime(stateTimes);
			pathToStateTimes = CalculatePathToStateTimes(stateTimes);

		}

		private IVariableExpression[] CalculatePathToStateTimes(IVariableExpression[] stateTimes)
		{
			IVariableExpression[] pathTimes = new IVariableExpression[stateTimes.Length];

			for (int i=0; i<pathTimes.Length; i++)
			{
				pathTimes[i] = new VariableExpression(0);
				Context cx = pathTimes[i].Expression.Context;
				for (int j=0; j<stateTimes.Length; j++)
				{
					// time consumed by state j * expected number of visits to j
					IScalarExpression wightedTime = new ScalarMultiplication(cx, stateTimes[i].Expression, markovModelInfo.VisitsOnPathMatrix[j,i] ).Expand();
					pathTimes[i].Expression = new ScalarAddition(cx, pathTimes[i].Expression, wightedTime).Expand();	
				}
			}
			return pathTimes;
		}

		private IVariableExpression CalculateTotalTime(IVariableExpression[] stateTimes)
		{
			IVariableExpression total = new VariableExpression(0);
			Context cx = total.Expression.Context;
			for (int i=0; i<stateTimes.Length; i++)
			{
				// time consumed by state i * expected number of visits to i
				IScalarExpression wightedTime = new ScalarMultiplication(cx, stateTimes[i].Expression, markovModelInfo.PotentialMatrix[markovModelInfo.StartStateIndex, i] ).Expand();
				total.Expression = new ScalarAddition(cx, total.Expression, wightedTime).Expand();	
			}
			return total;
		}

		private IVariableExpression[] ExtractStateTimes()
		{
			IState[] states = MarkovModel.States;
			IVariableExpression[] stateTimes = new IVariableExpression[states.Length];
			foreach (IState state in states)
			{
				stateTimes[GetStateIndex(state)] = TimeAttribute.GetAttribute(state).Time;
			}
			return stateTimes;
		}

		/// <summary>
		/// All states of the Markov model are required to have a
		/// TimeAttribute.
		/// </summary>
		/// <param name="mmInfo"></param>
		private void CheckPreconditions(MarkovModelInfo mmInfo)
		{
			foreach (IState state in mmInfo.MarkovModel.States)
			{
				Trace.Assert( TimeAttribute.GetAttribute(state) != null, String.Format("State {0} has no TimeAttribute!!",state));
			}
		}

		private MarkovModelInfo markovModelInfo;
		private IVariableExpression totalTime;
		private IVariableExpression[] pathToStateTimes;
	}
}
