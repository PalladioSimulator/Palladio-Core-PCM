using System;
using System.Collections;
using Palladio.Utils.Collections;
using Palladio.Utils.Exceptions;
using Palladio.FiniteStateMachines;
using Palladio.FiniteStateMachines.Visitors;


namespace Palladio.FiniteStateMachines.DefaultFSM
{

	/// <summary>
	///     The AbstractFiniteStateMachine implements some
	///     default functionality useful for most finite state
	///     machines.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.6  2004/05/12 14:11:39  sbecker
	/// Added CVS log
	///
	///
	/// </pre>
	/// </remarks>
	internal abstract class AbstractFSM : IFiniteStateMachine 
	{
		#region Properties

		public abstract IState StartState { get; set; }

		public abstract IState[] FinalStates { get; set; }

		public abstract IInput[] InputAlphabet { get; }

		public abstract IState[] States { get; }

		public abstract ITransition[] Transitions { get; }

		#endregion

		#region Methods

		public abstract ITransition GetNextTransition(IState aSourceState, IInput anInput);
        
		public abstract ITransition[] GetNextTransitions(IState aSourceState, IInput anInput);

		public abstract bool IsFinalState(IState aState);
		
		public abstract object Clone();

		public virtual IState GetNextState(IState aSourceState, IInput anInput) 
		{
			return GetNextTransition(aSourceState,anInput).DestinationState;
		}
																																		
		public virtual IState[] GetNextStates(IState aSourceState, IInput anInput)
		{
			ITransition[] transitions = GetNextTransitions(aSourceState, anInput);
			Set statesSet = new Set();
			foreach (ITransition trans in transitions)
			{
				statesSet.Add(trans.DestinationState);
			}
			IState[] resultStates = new IState[statesSet.Count];
			statesSet.CopyTo(resultStates,0);
			return resultStates;
		}

		public virtual ITransition[] GetOutgoingTransitions(IState aSourceState) 
		{
			IList transList = new Vector();
			foreach( IInput input in InputAlphabet ) 
			{
				ITransition[] transArray = GetNextTransitions(aSourceState,input);
				foreach (ITransition trans in transArray)
				{
					if ( !trans.DestinationState.IsErrorState ) 
					{
						transList.Add(trans);
					}
				}
			}
			ITransition[] resultTransArray = new ITransition[transList.Count];
			transList.CopyTo(resultTransArray,0);
			return resultTransArray;
		}

		public IState[] GetReachableStates ( IState s )
		{
			StateVisitor visitor = new StateVisitor(this);
			visitor.Visit(s);
			return visitor.VisitedStates;
		}

		public ITransition[] GetReachableTransitions(IState aState)
		{
			TransitionVisitor visitor = new TransitionVisitor(this);
			visitor.Visit(aState);
			return visitor.VisitedTransitions;
		}

		public override bool Equals(object obj) 
		{
			if ( obj is IFiniteStateMachine) 
			{
//TODO				return FSMFactory.AreEqual( this, (IFiniteStateMachine) obj );
				return false;
			} 
			return false;
		}

		public override string ToString() 
		{
//			string result = "start state : ";
//			try 
//			{
//				result += StartState+"\n";
//				result += "transitions : \n";
//				DynamicTransitionIterator iterator = new DynamicTransitionIterator(StartState,this);
//				while(iterator.MoveNext())
//				{
//					result += "\t"+iterator.Current+"\n";
//					iterator.Append(iterator.Current.DestinationState);
//				}
//			} 
//			catch (InvalidStateException e)
//			{
//				result += e.Message+"\n";
//			}	
//			try 
//			{
//				result += "final states: ";
//				foreach (IState state in FinalStates) 
//				{
//					result += state + " ";
//				}
//			} 
//			catch (InvalidStateException e)
//			{
//				result += e.Message+"\n";
//			}	
//			return result;
			return "";
		}

		public override int GetHashCode() 
		{
			return base.GetHashCode();
		}

		#endregion

		#region Static Data

		protected static IState ERROR_STATE = new DefaultState("ERROR_STATE", true);
		#endregion
	}
}

