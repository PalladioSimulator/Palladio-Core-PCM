/*
 * $Id$
 * 
 * $Log$
 * Revision 1.1  2004/10/25 07:07:22  sliver
 * implementation of
 * - functions discrete, including convolution
 * - path segmentation of FSMs
 * - prediction of time consuption using density functions
 *
 */
using System.Collections;
using Palladio.FiniteStateMachines;
using Palladio.Reliability.Attributes;
using Palladio.Reliability.Functions;
using Palladio.Reliability.Paths;

namespace Palladio.Reliability.Time
{
	/// <summary>
	/// </summary>
	public class TimeOperations
	{
		/// <summary>
		/// Accuracy for the approximation of the execution timie limit of loops.
		/// </summary>
		private const double ACCURACY = 0.001;

		/// <summary>
		/// Returns the execution time of two sequential elements. That is,
		/// f(x) convolution g(x), where f(x) is the density function of the predecessor
		/// and g(x) the one of the successor. The total probability is given by p*t*q, where
		/// p and q are the probabilities of the predecessor and successor and t is the 
		/// transition probability.
		/// </summary>
		/// <param name="predecessor"></param>
		/// <param name="successor"></param>
		/// <param name="transitionProbability">The probability of going from the predecessor to the successor.</param>
		/// <returns></returns>
		public static IExecutionTime Sequence(IExecutionTime predecessor, IExecutionTime successor, double transitionProbability)
		{
			IFunction f = DefaultFactory.Default.Convolution(predecessor.Function, successor.Function);
			double p = predecessor.Probability*transitionProbability*successor.Probability;
			return new ExecutionTime(f, p);
		}

		/// <summary>
		/// Returns the joined execution time of two alternatives. That is,
		/// p * f(x) + q * g(x), 
		/// where p	and q arte the probabilites and f(x) and g(x) are 
		/// the density functions of alternative A and B. The total probability
		/// is given by p + q, the sum of the probabilities of both alternatives.
		/// </summary>
		/// <param name="alternativeA"></param>
		/// <param name="probabilityA">Probability of entering altA</param>
		/// <param name="alternativeB"></param>
		/// <param name="probabilityB">Probability of entering altB</param>
		/// <returns></returns>
		public static IExecutionTime Alternative(IExecutionTime alternativeA, double probabilityA, IExecutionTime alternativeB, double probabilityB)
		{
			double pA = alternativeA.Probability*probabilityA;
			double pB = alternativeB.Probability*probabilityB;
			double pTotal = pA + pB;

			IFunction f = DefaultFactory.Default.CreateConstantFunction(0);
			// The functions are scaled by their _relative_ probability 
			f = DefaultFactory.Default.ScaledSum(f, alternativeA.Function, pA/pTotal);
			f = DefaultFactory.Default.ScaledSum(f, alternativeB.Function, pB/pTotal);
			return new ExecutionTime(f, pTotal);
		}

		/// <summary>
		/// Returns the joined execution time of two alternatives. That is,
		/// p * f(x) + q * g(x), 
		/// where p	and q arte the probabilites and f(x) and g(x) are 
		/// the density functions of alternative A and B. The total probability
		/// is given by p + q, the sum of the probabilities of both alternatives.
		/// </summary>
		public static IExecutionTime Alternative(IExecutionTime alternativeA, IExecutionTime alternativeB)
		{
			return Alternative(alternativeA, 1.0, alternativeB, 1.0);
		}

		/// <summary>
		/// Returns the execution time of a loop. That is, 
		/// sum_{k=0}^{\infty} p^{k} * convolution_{n=0}^{k} f(x),
		/// where p is the probability of the loop and f(x) is its density
		/// function. convolution_{n=0}^{0} is the dirac function, since it is the 
		/// neutral element of convolution. So, the result contains a density function
		/// from zero to (almost) infinity executions of the loop.
		/// 
		/// The probability returned in fact is no 'probability' but the expected 
		/// number of loop executions. Anyway, this the result conforms with the properties
		/// of the probability value (even if it can be greater than one), since the 
		/// integration in a (surrounding) sequence yields a valid probability value. The
		/// application of an alternative operation on the result is not allowed.
		/// </summary>
		/// <param name="inner">Contains the execution time and probabiltiy of 
		/// the inner part of the loop.</param>
		/// <returns></returns>
		public static IExecutionTime Loop(IExecutionTime inner)
		{
			IFunction f = DefaultFactory.Default.CreateDiracFunction();
			IFunction cf = DefaultFactory.Default.CreateDiracFunction();

			double cp = 1.0;
			double p = 1.0; // the probability of zero or an arbitrary number of executions is 1.0.
			while (cp > ACCURACY)
			{
				cf = DefaultFactory.Default.Convolution(cf, inner.Function);
				cp *= inner.Probability;
				f = DefaultFactory.Default.ScaledSum(f, cf, cp);
				p += cp;
			}
			return new ExecutionTime(f, p);
		}

		/// <summary>
		/// Returns the execution time of a state.
		/// </summary>
		/// <param name="state">It must have a TimeAttribute.</param>
		/// <returns></returns>
		public static IExecutionTime StateExecutionTime(IState state)
		{
			IFunction f = TimeAttribute.GetAttribute(state).DensityFunction;
			return new ExecutionTime(f, 1.0);
		}

		/// <summary>
		/// Returns an execution time of zero.
		/// </summary>
		/// <returns></returns>
		public static IExecutionTime ZeroExecutionTime(double probability)
		{
			return new ExecutionTime(DefaultFactory.Default.CreateDiracFunction(), probability);
		}

		/// <summary>
		/// Returns the execution time of a path. That is the sequential composition
		/// of all state execution times.
		/// </summary>
		/// <param name="path">Its transitions must have a MarkovAttribute and 
		/// states must have a TimeAttribute.</param>
		/// <returns></returns>
		public static IPathExecutionTime PathExecutionTime(IPath path)
		{
			IState state = path.EntryState;
			IExecutionTime execTime = ZeroExecutionTime(1.0);

			// if path is a cycle, EntryState equals ExitState, but
			// must only considered once. Therefore, start with a zero
			// time function.
			if (!path.IsCycle)
				execTime = StateExecutionTime(state);

			if (path.Length > 0)
			{
				do
				{
					ITransition transition = path.GetNextTransition(state);
					state = transition.DestinationState;
					execTime = Sequence(execTime, StateExecutionTime(state), GetProbability(transition));
				} while (!state.Equals(path.ExitState));
			}

			return new PathExecutionTime(execTime.Function, execTime.Probability, path);
		}

		/// <summary>
		/// Returns the execution time consumed by the finite state machine.
		/// </summary>
		/// <param name="fsm">Its transitions must have a MarkovAttribute and 
		/// states must have a TimeAttribute.</param>
		/// <returns></returns>
		public static IExecutionTime FSMExecutionTime(IFiniteStateMachine fsm)
		{
			IFSMPaths fsmPaths = new FSMPaths(fsm);

			IPathExecutionTime[] fpTimes = new IPathExecutionTime[fsmPaths.FinalPaths.Length];
			for (int i = 0; i < fpTimes.Length; i++)
				fpTimes[i] = TimeOperations.PathExecutionTime(fsmPaths.FinalPaths[i]);

			IPathExecutionTime[] cpTimes = new IPathExecutionTime[fsmPaths.CyclicPaths.Length];
			for (int i = 0; i < cpTimes.Length; i++)
				cpTimes[i] = TimeOperations.PathExecutionTime(fsmPaths.CyclicPaths[i]);

			IExecutionTime totalTime = Constant(0.0, 0.0);

			foreach (IPathExecutionTime time in fpTimes)
			{
				IExecutionTime[] cycleTimes = GetConnectedCycleTimes(time, cpTimes);
				IExecutionTime totalPathTime = GetTotalPathTime(time, cycleTimes);
				totalTime = Sum(totalTime, totalPathTime);

			}
			return totalTime;
		}

		private static IExecutionTime Constant(double value, double probability)
		{
			return new ExecutionTime(DefaultFactory.Default.CreateConstantFunction(value), probability);
		}

		private static IExecutionTime Sum(IExecutionTime timeA, IExecutionTime timeB)
		{
			IFunction f = DefaultFactory.Default.Sum(timeA.Function, timeB.Function);
			return new ExecutionTime(f, timeA.Probability + timeB.Probability);
		}

		private static IExecutionTime GetTotalPathTime(IPathExecutionTime finalPathTime, IExecutionTime[] cyclicPathTimes)
		{
			IExecutionTime totalPathTime = finalPathTime;
			foreach (IExecutionTime cyclicPathTime in cyclicPathTimes)
			{
				totalPathTime = Sequence(totalPathTime, cyclicPathTime, 1.0);
			}
			// this scalation is actually the scalation of the finalPathTime function,
			// but since the operations (convolution and scalar multiplication) are 
			// commutative, it can be done at the end.
			totalPathTime.Function.Scale(finalPathTime.Probability);
			return totalPathTime;
		}

		/// <summary>
		/// Returns the loop execution time for all loops attached to the path.
		/// Loops which are entered from the same state are merged by the alternative
		/// operator before calculating their limit.
		/// 
		/// TODO: implement a 'caching' for already calculated limits.
		/// </summary>
		/// <param name="finalPathTime"></param>
		/// <param name="cyclicPathTimes"></param>
		/// <returns></returns>
		private static IExecutionTime[] GetConnectedCycleTimes(IPathExecutionTime finalPathTime, IPathExecutionTime[] cyclicPathTimes)
		{
			ArrayList connectedCycleTimes = new ArrayList();
			bool[] used = new bool[cyclicPathTimes.Length];
			for (int i = 0; i < used.Length; i++)
				used [i] = false;

			for (IState state = finalPathTime.Path.EntryState; !state.Equals(finalPathTime.Path.ExitState); state = finalPathTime.Path.GetNextState(state))
			{
				IExecutionTime joinedCycleTime = ZeroExecutionTime(0);
				bool overlaps = false;
				for (int i = 0; i < cyclicPathTimes.Length; i++)
				{
					if ((cyclicPathTimes[i].Path.Contains(state)) && (!used[i]))
					{
						joinedCycleTime = TimeOperations.Alternative(joinedCycleTime, cyclicPathTimes[i]);
						used[i] = true;
						overlaps = true;
					}
				}
				if (overlaps)
				{
					IExecutionTime loopedTime = TimeOperations.Loop(joinedCycleTime);
					connectedCycleTimes.Add(loopedTime);
				}
			}
			return (IExecutionTime[]) connectedCycleTimes.ToArray(typeof (IExecutionTime));
		}

		/// <summary>
		/// Returns the probability associated with transition.
		/// </summary>
		/// <param name="transition">It must have a MarkovAttribute.</param>
		/// <returns></returns>
		public static double GetProbability(ITransition transition)
		{
			return MarkovAttribute.GetAttribute(transition).Probability.Expression.Calculate();
		}
	}
}