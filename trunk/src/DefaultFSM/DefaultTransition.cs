using System;
using System.Collections;
using ReflectionBasedVisitor.Interfaces;

namespace Palladio.FiniteStateMachines.DefaultFSM
{
	/// <summary>
	/// Represents the transitions of the FSM.
	/// 
	/// Important:	Every class which inherits from <code>ITransition</code> has to
	///				implement the method <code>Clone()</code> and a constructor 
	///				of the following type:
	///				
	///				XXXTransition(AbstractState, Input, AbstractState)
	///				
	///	author: JH
	///         StB
	/// </summary>
	internal class DefaultTransition : ITransition
	{
		/// <summary>
		/// The source of the transition.
		/// </summary>
		private IState sourceState;

		/// <summary>
		/// The input symbol.
		/// </summary>
		private IInput inputSymbol;

		/// <summary>
		/// The destination of the transition.
		/// </summary>
		private IState destinationState;

		private Hashtable attributeTable;

		/// <summary>
		/// Deafault constructor
		/// Initializes a new instance of the ITransition.
		/// </summary>
		/// <param name="aSourceState">State, the source of the ITransition.</param>
		/// <param name="anInputSymbol">Input of the ITransition.</param>
		/// <param name="aDestinationState">State, where the ITransition leads to.</param>
		public DefaultTransition(IState aSourceState, IInput anInputSymbol, IState aDestinationState, Hashtable anAttTable) 
		{
			this.SourceState = aSourceState;
			this.InputSymbol = anInputSymbol;
			this.DestinationState = aDestinationState;
			this.attributeTable = anAttTable;
		}

		public DefaultTransition(IState aSourceState, IInput anInputSymbol, IState aDestinationState ) :
			this (aSourceState, anInputSymbol, aDestinationState, new Hashtable()) {}
			
			
		/// <summary>
		/// The copy constructor.
		/// </summary>
		/// <param name="newTransition"></param>
		public DefaultTransition(ITransition newTransition) 
		{
			this.SourceState = newTransition.SourceState;
			this.InputSymbol = newTransition.InputSymbol;
			this.DestinationState = newTransition.DestinationState;
		}


		/// <summary>
		/// The source of the transition.
		/// </summary>
		public IState SourceState 
		{
			get { return sourceState; }
			set { sourceState = value; }
		}

		/// <summary>
		/// The destination of the transition.
		/// </summary>
		public IState DestinationState 
		{
			get { return destinationState; }
			set { destinationState = value; }
		}
		
		/// <summary>
		/// The input symbol.
		/// </summary>
		public IInput InputSymbol {
			get { return inputSymbol; }
			set { inputSymbol = value; }
		}

		public Hashtable AttributeTable 
		{
			get { return attributeTable; }
		}

		/// <summary>
		/// Sets the important values of a transition object.
		/// </summary>
		/// <param name="aSourceState">Source</param>
		/// <param name="anInputSymbol">Input symbol</param>
		/// <param name="aDestinationState">Destination</param>
		public void SetValues(IState aSourceState, IInput anInputSymbol, IState aDestinationState) 
		{
			this.SourceState = aSourceState;
			this.InputSymbol = anInputSymbol;
			this.DestinationState = aDestinationState;
		}

		/// <summary>
		/// Returns a string representing the instance of a transition.
		/// </summary>
		/// <returns>The ITransition as string.</returns>
		override public string ToString() 
		{
			return "( " + SourceState + "\t-  " + InputSymbol + "\t-  " + DestinationState + ")";
		}
		
		
		/// <summary>
		/// Default implementation.
		/// </summary>
		/// <returns></returns>
		public override int GetHashCode() 
		{
			return ToString().GetHashCode();
		}

		/// <summary>
		/// Default implementation.
		/// </summary>
		public virtual object Clone()
		{
			return new DefaultTransition(this);
		}

		/// <summary>
		/// Default implementation for Equals.
		/// </summary>
		/// <param name="obj"></param>
		/// <returns></returns>
		public override bool Equals(object obj) 
		{
			if (obj is ITransition)
			{
				ITransition trans = (ITransition)obj;
				return (DestinationState.Equals(trans.DestinationState) &&
					SourceState.Equals(trans.SourceState) &&
					InputSymbol.Equals(trans.InputSymbol));
			} 
			return false;
		}

		/// <summary>
		/// Implementation of the data structure driven visitor movement. It is
		/// not implemented here!
		/// </summary>
		/// <param name="v">The visitor visiting this object</param>
		public virtual void AcceptVisitor(IVisitor v) {}
	}
}
