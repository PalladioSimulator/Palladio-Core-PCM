using System;

namespace Palladio.FiniteStateMachines
{
	/// <summary>
	///An Interface for all kinds of Transitions
	/// </summary>
	public interface ITransition
	{
		/// <summary>
		/// The sorceState of a Transition
		/// </summary>
		IState SourceState{get;set;}

		/// <summary>
		/// The Destination of a Transition
		/// </summary>
		IState DestinationState{get;set;}

		/// <summary>
		/// The input of a Transition
		/// </summary>
		Input InputSymbol{get;set;}

		/// <summary>
		/// Default implemnetation
		/// </summary>
		/// <param name="o"></param>
		/// <returns></returns>
		bool Equals(object o);

		/// <summary>
		/// Default implementation
		/// </summary>
		/// <returns></returns>
		object Clone();

		/// <summary>
		/// Another default implemntation
		/// </summary>
		/// <returns></returns>
		int GetHashCode();

		
	}
}
