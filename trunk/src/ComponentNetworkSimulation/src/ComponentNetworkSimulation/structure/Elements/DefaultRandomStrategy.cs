using System;
using Palladio.FiniteStateMachines;

namespace ComponentNetworkSimulation.Structure.Services
{
	/// <summary>
	/// This class implements a controlflowstrategy using the random strategy.
	/// </summary>
	/// <remarks>
	/// <pre>
	///	$Log$
	///	Revision 1.1  2004/05/20 14:12:22  joemal
	///	initial creation
	///
	///	 	
	/// </pre>
	/// </remarks>
	internal class DefaultRandomStrategy : IControlFlowStrategy
	{
		private static Random random = new Random();

		#region singleton pattern

		private static DefaultRandomStrategy instance = null; 

		/// <summary>
		/// returns the single instance of DefaultRandomStrategy
		/// </summary>
		/// <returns>an instance of DefaultRandomStrategy</returns>
		public static DefaultRandomStrategy getInstance()
		{
			if (instance == null) instance = new DefaultRandomStrategy();
			return instance;
		}

		private DefaultRandomStrategy()
		{
		}

		#endregion

		/// <summary>
		/// called to get the next outgoing transition of the given state. This implementation selects one of them using a 
		/// random strategy. If the given state is a final state, also null is a possibility to be returned.
		/// </summary>
		/// <param name="state">the state</param>
		/// <param name="fsm">the fsm of the state</param>
		/// <param name="recursiveDepth">the recursive depth</param>
		/// <returns>the selected transition or null</returns>
		public ITransition GetNextTransition(IState state, IFiniteStateMachine fsm, int recursiveDepth)
		{
			ITransition[] outTrans = fsm.GetOutgoingTransitions(state);
			int possibilities = outTrans.Length;
			if (fsm.IsFinalState(state)) possibilities++;

			int selected = random.Next(possibilities);

			if (selected < outTrans.Length) 
				return outTrans[selected];
			else
                return null;
		}
	}
}
//EOF
