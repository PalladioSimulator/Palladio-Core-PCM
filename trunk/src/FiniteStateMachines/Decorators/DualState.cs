using System;

namespace FiniteStateMachines.Decorators 
{
	/// <summary>
	/// This is a special form of a <code>AbstrcatState</code>it contains of two 
	/// <code>AbstractStates</code>. This is usefull when you are bulding
	/// <code>FiniteCrossProductMaschine</code> and so on. 
	/// </summary>
	public class DualState : AbstractState 
	{
		/// <summary>
		/// The first <code>AbstractState</code> of which every DualState is composed of.
		/// </summary>
		protected AbstractState one;

		/// <summary>
		/// The second <code>Abstract State</code> of which every DualState is composed of.
		/// </summary>
		protected AbstractState two;

		/// <summary>
		/// The name of the <code>DualState</code>. It always looks like one.name-x-two.name.
		/// </summary>
		protected String CPname;

		/// <summary>
		/// Creates an empty DualState
		/// </summary>
		public DualState() 
		{
		}


		/// <summary>
		/// Copy construktor. Creates a new <code>DualState</code>from an existing DualState 
		/// </summary>
		/// <param name="state">A DualState which should be copied</param>
		public DualState(DualState aState) 
		{
			this.one = aState.one;
			this.two = aState.two;
			this.CPname = aState.CPname;
		}


		/// <summary>
		/// Creates a new <code>DualState</code> from two given <code>AbstractStates</code>
		/// </summary>
		/// <param name="one">A <code>AbstractState</code></param>
		/// <param name="two">Another <code>AbstractState</code>, together with one a CPState can be 
		/// created</param>
		public DualState(AbstractState one, AbstractState two) 
		{
			this.one = one;
			this.two = two;
		}


		/// <summary>
		/// Checks if this <code>DualState</code> is a Startstate
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
		/// Checks if this <code>DualState</code> is a FinalState
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
		/// Returns the name of this <code>DualState</code> in a string. It always 
		/// looks like one.name-x-two.name.
		/// </summary>
		/// <returns>The name of this <code>DualState</code>as <code>string</code></returns>
		public override string Name 
		{
			get {return this.one.Name+"-X-"+this.two.Name;}
		}


		/// <summary>
		/// Delivers the first <code>Abstractstate</code> of this 
		/// <code>DualState</code>
		/// </summary>
		public AbstractState oneState 
		{
			get {return this.one;}
		}

		/// Delivers the second <code>Abstractstate</code> of this 
		/// <code>DualState</code>
		public AbstractState twoState 
		{
			get {return this.two;}
		}


		/// <summary>
		/// Checks if this <code>DualState</code> is equal with the given object.
		/// </summary>
		/// <param name="obj">The object which should be checked</param>
		/// <returns>true, if booth are equal, false if not.</returns>
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
//							if(this.oneState == state.twoState)
//								if(this.twoState == state.twoState)
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

		/// <summary>
		/// Provides the Hashcode of this <code>DualState</code>
		/// </summary>
		/// <returns>An int with the computes Hashcode of this object.</returns>
		public override int GetHashCode() 
		{
			return Name.GetHashCode();
		}
	}
}
