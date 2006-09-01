using Palladio.FiniteStateMachines;

namespace Palladio.Reliability.FSMTransformer
{
	/// <summary>
	/// Wraps a state into an input symbol.
	/// </summary>
	public class StateInput : IInput, IMatchable
	{
		private IState state;


		/// <summary>
		/// Wrapped state.
		/// </summary>
		public IState State
		{
			get { return state; }
			set { state = value; }
		}

		public StateInput(IState state)
		{
			this.state = state;
		}

		/// <summary>
		/// The ID of the input symbol used for a certain transition
		/// </summary>
		public IMatchable ID
		{
			get { return this; }
		}

		/// <summary>
		/// A match is a more specialised comparison of two objects.
		/// </summary>
		/// <param name="other">Another object which should be matched.</param>
		/// <returns>True, if this object an the other object match, false otherwise.</returns>
		public bool Match(IMatchable other)
		{
			return Equals(other);
		}

		public override string ToString()
		{
			return state.ToString();
		}

		public override bool Equals(object obj)
		{
			if (obj is StateInput)
			{
				StateInput si = (StateInput) obj;
				return state.Equals(si.state);
			}
			return false;
		}

		public override int GetHashCode()
		{
			return state.GetHashCode();
		}
	}
}