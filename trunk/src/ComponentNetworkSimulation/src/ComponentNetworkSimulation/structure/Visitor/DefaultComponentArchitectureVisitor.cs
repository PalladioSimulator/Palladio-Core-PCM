using System;
using ComponentNetworkSimulation.Structure.Services;
using Palladio.FiniteStateMachines;
using ReflectionBasedVisitor;

namespace ComponentNetworkSimulation.Structure.Visitor
{
	/// <summary>
	/// This class is the default implementation of <code>IComponentArchitectureVisitor</code> using the class
	/// <code>ReflectionBasedVisitor.ReflectionBasedVisitor</code>. It is used by the simulation threads to find there way 
	/// through the componentarchitecture.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	/// 
	/// $Log$
	/// Revision 1.2  2004/05/20 14:18:53  joemal
	/// changed the visit methods to public
	///
	/// Revision 1.1  2004/05/18 15:40:40  joemal
	/// initial creation
	///
	///
	/// 
	/// </pre>	
	/// </remarks>
	public class DefaultComponentArchitectureVisitor : ReflectionBasedVisitor.ReflectionBasedVisitor,IComponentArchitectureVisitor
	{
		#region data

		// the stack to store the way to the elements
		private IComponentArchitectureStack stack = new DefaultComponentArchitectureStack();

		#endregion

		#region constructor

		/// <summary>
		/// constructs a new Visitor.
		/// </summary>
		public DefaultComponentArchitectureVisitor() : base (false) {}

		#endregion

		#region properties

		/// <summary>
		/// return the current timeconsumer. It returns null, if no startpoint is set, or the visitor reached its end.
		/// </summary>
		public ITimeConsumer CurrentTimeConsumer
		{
			get
			{
				return (ITimeConsumer)stack.Peek();
			}
		}

		#endregion

		#region methods

		/// <summary>
		/// call to set the startpoint of the controlflow of this visitor.
		/// </summary>
		/// <param name="fsm">fsm</param>
		//todo: later Component and signature as parameter
		public void SetStart(Palladio.FiniteStateMachines.IFiniteStateMachine fsm)
		{
			Visit(fsm);
		}

		/// <summary>
		/// called to move to the next timeconsumer. This timeconsumer is returned. If no more timeconsumer exist in path, null
		/// is returned.
		/// </summary>
		/// <returns>the new timeconsumer</returns>
		public ITimeConsumer NextTimeConsumer()
		{
			if (stack.Count == 0) return null;
            this.Visit(stack.Pop());

			return this.CurrentTimeConsumer;
		}

		/// <summary>
		/// not used in this implementation
		/// </summary>
		/// <param name="o"></param>
		public override void VisitObject (object o)
		{
			Console.WriteLine("Object from type: "+o.GetType()+" not supported ...");
		}

		/// <summary>
		/// called by the <code>ReflectionBasedVisitor</code> when the element to be visited is a fsm.
		/// </summary>
		/// <param name="fsm">the fsm</param>
		public void VisitIFiniteStateMachine(IFiniteStateMachine fsm)
		{
			this.stack.Push(fsm);
		}

		/// <summary>
		/// called by the <code>ReflectionBasedVisitor</code> when the element to be visited is a simulationstate.
		/// </summary>
		/// <param name="state">the state</param>
		public void VisitISimulationState(ISimulationState state)
		{
			try 
			{
				IFiniteStateMachine fsm = (IFiniteStateMachine)stack.Peek();
				int recursionDepth = stack.GetCountOfElement(state);

				ITransition nextTrans = state.ControlFlowStrategy.GetNextTransition(state,fsm,recursionDepth);
				if (nextTrans != null) 
					Visit(nextTrans);
				else
					BackToCallingTransition();
			}
			catch(Exception e)
			{
				Console.WriteLine("Exc: "+e.Message+"Trace: "+e.StackTrace);
			}
		}

		// called by VisitISimulationState when a final state is reached to empty the stack to the calling transition.
		private void BackToCallingTransition()
		{
			while (stack.Count != 0) 
			{
				object element = stack.Pop();
				if (element is ITransition) 
				{
					stack.Push(((ITransition)element).DestinationState);
					return;
				}
			}
		}

		/// <summary>
		/// called by the <code>ReflectionBasedVisitor</code> when the element to be visited is a transition.
		/// </summary>
		/// <param name="trans">the transition</param>
		public void VisitITransition(ITransition trans)
		{
			//todo: subcall to extern service
			//now only the next state is set to stack
			stack.Push(trans.DestinationState);		
		}

		#endregion
	}
}
//EOF