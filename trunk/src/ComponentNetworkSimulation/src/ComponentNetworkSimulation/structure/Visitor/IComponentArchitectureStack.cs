using System;
using Palladio.FiniteStateMachines;

namespace ComponentNetworkSimulation.Structure.Visitor
{
	/// <summary>
	/// This interface defines the stack used for threads to store there current context in the architecture.
	/// This stack provides several methods to push objects of the architecture to the stack. Note that some of the 
	/// push methods push more than the given object to the stack. The method <code>void Push(IFiniteStateMachine fsm)</code>
	/// first puts the FSM to the top of the stack and then its starting state.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// $Log$
	/// Revision 1.1  2004/05/18 15:40:40  joemal
	/// initial creation
	///
	///
	/// </pre>
	/// </remarks>

	public interface IComponentArchitectureStack
	{
		/// <summary>
		/// returns the current count of elements in the stack.
		/// </summary>
		int Count
		{
			get;
		}

		/// <summary>
		/// push the given state on top of the stack
		/// </summary>
		/// <param name="state">the state to be put on top of the stack</param>
		void Push(IState state);		

		/// <summary>
		/// push the given transition on top of the stack
		/// </summary>
		/// <param name="transition">the transition to be put on top of the stack</param>
		void Push(ITransition transition);

		/// <summary>
		/// push the fsm and then its starting state on top of the stack.
		/// </summary>
		/// <param name="fsm">the fsm</param>
		void Push(IFiniteStateMachine fsm);
			
		//todo: später mal weiter Push methoden für Komponenten, IFaces und Services

		/// <summary>
		/// return the object on top of the stack without removing it. If the stack is empty, null is returned.
		/// </summary>
		/// <returns>the element on top of the stack</returns>
		object Peek();

		/// <summary>
		/// removes the first object from top of the stack and returns it. If the stack is empty, null is returned.
		/// </summary>
		/// <returns>the object</returns>
		object Pop();

		/// <summary>
		/// call to clear the stack.
		/// </summary>
		void Clear();

		/// <summary>
		/// return the count of the given element in stack.
		/// </summary>
		/// <param name="element">the element to be counted in the stack</param>
		/// <returns>the count of the element in the stack</returns>
		int GetCountOfElement(object element);
	}
}
//EOF
