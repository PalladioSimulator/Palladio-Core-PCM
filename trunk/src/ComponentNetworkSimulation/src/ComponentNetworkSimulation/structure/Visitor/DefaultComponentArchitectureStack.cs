using System;
using Palladio.FiniteStateMachines;

namespace ComponentNetworkSimulation.Structure.Visitor
{
	/// <summary>
	/// This class is the default implementation of <code>IComponentArchitectureStack</code> using 
	/// <code>System.Collections.Stack</code>.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	/// 
	/// $Log$
	/// Revision 1.1  2004/05/18 15:40:40  joemal
	/// initial creation
	///
	///
	/// 
	/// </pre>	
	/// </remarks>
	public class DefaultComponentArchitectureStack : System.Collections.Stack, IComponentArchitectureStack
	{
		#region methods

		/// <summary>
		/// the implementation of this method throws a NotImplementedException. It must not be used in this extension of stack.
		/// </summary>
		/// <param name="obj"></param>
		public override void Push(object obj)
		{
			throw (new NotImplementedException("This method must not be used in this implementation. Use one of the overloaded methods."));
		}

		/// <summary>
		/// push the given state on top of the stack
		/// </summary>
		/// <param name="state">the state to be put on top of the stack</param>
		public void Push(IState state)
		{
			base.Push(state);
		}

		/// <summary>
		/// push the given transition on top of the stack
		/// </summary>
		/// <param name="transition">the transition to be put on top of the stack</param>
		public void Push(ITransition transition)
		{
			base.Push(transition);
		}

		/// <summary>
		/// push the fsm and then its starting state on top of the stack.
		/// </summary>
		/// <param name="fsm">the fsm</param>
		public void Push(IFiniteStateMachine fsm)
		{
			base.Push(fsm);
			this.Push(fsm.StartState);
		}

		/// <summary>
		/// override the base method in order to return null if the stack is empty.
		/// </summary>
		/// <returns>the element on top of the stack</returns>
		public override object Pop()
		{
			if (this.Count == 0)
				return null;
			else
				return base.Pop();

		}

		/// <summary>
		/// override the base method in order to return null if the stack is empty.
		/// </summary>
		/// <returns>the element on top of the stack.</returns>
		public override object Peek()
		{
			if (this.Count == 0) 
				return null;
			else
                return base.Peek();
		}

		/// <summary>
		/// return the count of the given element in stack.
		/// </summary>
		/// <param name="element">the element to be counted in the stack</param>
		/// <returns>the count of the element in the stack</returns>
		public int GetCountOfElement(object element)
		{
			int count=0;

			foreach(object obj in this)
				if (element == obj) count ++;

			return count;
		}
		#endregion
	}
}
//EOF