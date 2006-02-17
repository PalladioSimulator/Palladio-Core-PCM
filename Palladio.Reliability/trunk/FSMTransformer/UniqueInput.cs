using System;
using Palladio.FiniteStateMachines;

namespace Palladio.Reliability.FSMTransformer
{
	/// <summary>
	/// UniqueInput.
	/// </summary>
	public class UniqueInput : IInput, IMatchable
	{
		private Guid guid;
		private IInput input;

		public Guid Guid
		{
			get { return guid; }
		}

		public IInput Input
		{
			get { return input; }
			set { input = value; }
		}


		public UniqueInput(IInput input)
		{
			guid = Guid.NewGuid();
			this.input = input;
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
			return input.ToString();
		}

		public override bool Equals(object obj)
		{
			if (obj is UniqueInput)
			{
				UniqueInput uInput = (UniqueInput) obj;
				return guid.Equals(uInput.Guid);
			}
			return false;
		}

		public override int GetHashCode()
		{
			return guid.GetHashCode();
		}
	}
}