using System;
using System.Collections;
using ReflectionBasedVisitor.Interfaces;

namespace Palladio.FiniteStateMachines
{
	/// <summary>
	///An Interface for all kinds of Transitions
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2004/05/12 13:40:18  sbecker
	/// Added documentation and CVS log
	///
	///
	/// </pre>
	/// </remarks>
	public interface ITransition : ICloneable, IVisitable
	{
		/// <summary>
		/// The sorceState of a ITransition
		/// </summary>
		IState SourceState{get;set;}

		/// <summary>
		/// The Destination of a ITransition
		/// </summary>
		IState DestinationState{get;set;}

		/// <summary>
		/// The input of a ITransition
		/// </summary>
		IInput InputSymbol{get;set;}

		/// <summary>
		/// A list of attributes attached to this transition. The attributes are hashed
		/// by their ID on their respective values.
		/// </summary>
		Hashtable AttributeTable {get;}

		/// <summary>
		/// Set all the relevant information of a transiton with a single call
		/// </summary>
		/// <param name="aSourceState">A source state</param>
		/// <param name="anInputSymbol">An input symbol</param>
		/// <param name="aDestinationState">An destination state</param>
		void SetValues(IState aSourceState, IInput anInputSymbol, IState aDestinationState);
	}
}
