using System;

namespace FiniteStateMachines.Decorators 
{
	/// <summary>
	/// Zusammenfassung für CPState.
	/// </summary>
	public class DualState : AbstractState 
	{
		protected AbstractState one;
		protected AbstractState two;
		protected String CPname;
		protected AbstractState state;
		

		/// <summary>
		/// Creates an empty CPState
		/// </summary>
		public DualState() 
		{
		}

		/// <summary>
		/// copy construktor 
		/// </summary>
		/// <param name="state"></param>
		public DualState(DualState aState) 
		{
//			if(aState is DualState == false)
//				throw new InvalidStateException();
			this.one = aState.one;
			this.two = aState.two;
			this.CPname = aState.CPname;
			this.state = aState.state;
		}
		/// <summary>
		/// Creates a CPState
		/// </summary>
		/// <param name="one">A State</param>
		/// <param name="two">Another State, together with one a CPState can be 
		/// created</param>
		public DualState(AbstractState one, AbstractState two) 
		{
			this.one = one;
			this.two = two;
			this.state = new State(this.Name,this.IsStartState,this.IsFinalState);
		}
		/// <summary>
		/// returns a 'normal' FSMState, which can be used in all FSMs
		/// </summary>
		/// <returns>The normal FSM state</returns>
		public AbstractState getState() 
		{
			return this.state;
		}
		/// <summary>
		/// Checks if the state is a Startstate
		/// </summary>
		/// <returns>true if is a StartState, false if not </returns>
		public override bool IsStartState 
		{
			get 
			{
				if(this.one.IsStartState == this.two.IsStartState)
					return this.one.IsStartState;
				return false;
			}
		}

		/// <summary>
		/// Checks if the state is a finalstate
		/// </summary>
		/// <returns>true if it is a finalstate, false if not</returns>
		public override bool IsFinalState 
		{
			get 
			{
				if(this.one.IsFinalState == this.two.IsFinalState)
					return this.one.IsFinalState;
				return false;
			}
		}

		/// <summary>
		/// returns the name of a state in a string
		/// </summary>
		/// <returns>the name of the state</returns>
		public override string Name 
		{
			get {return this.one.Name+"-X-"+this.two.Name;}
		}

		public AbstractState oneState 
		{
			get {return this.one;}
		}
		public AbstractState twoState 
		{
			get {return this.two;}
		}
		public override bool Equals(object obj) 
		{
			DualState state;
			
			if (obj is DualState) 
			{ 
				state = (DualState)obj;
				if(this.Name == state.Name) 
				{
					if(this.IsStartState == state.IsStartState)
						if(this.IsFinalState == state.IsFinalState)
							if(this.oneState == state.twoState)
								if(this.twoState == state.twoState)
									if(this.state == state.state)
										return true;
				}
			}
			return false;
		}
		public static bool operator == (DualState one, DualState two) 
		{
			return one.Equals(two);
		}
		public static bool operator !=(DualState one, DualState two) 
		{
			return !one.Equals(two);
		}
		public override int GetHashCode() 
		{
			return Name.GetHashCode();
		}
	}
}
