using System;

namespace FiniteStateMachines.Decorators
{
	/// <summary>
	///		Specialised implementation of a rule according to the double 
	///		pushout approach. A rule constists of a left side (L), a right 
	///		side (R) and a "glue" (K).
	///		The application of a rule works as following:
	///			- match L with the graph G using morphism g(L)
	///			- check gluing conditions
	///			- remove g(L-K) in G
	///			- add R-K in G
	///		The "glue" is not stored in the Rule class. It is 
	///		implicitly given by L crop R
	/// </summary>
	public class Rule
	{
		private IFiniteStateMachine left;
		private Transition right;

		public Rule(IFiniteStateMachine aLeftSide, Transition aRightSide){
			left = aLeftSide;
			right = aRightSide;
		}

		/// <summary>
		/// Left side of a rule, which is matched with G and then removed.
		/// </summary>
		public IFiniteStateMachine Left {
			get{ return left; }
			set{ left = value; }
		}

		/// <summary>
		/// Right side of a rule, which is added to G.
		/// </summary>
		public Transition Right {
			get{ return right; }
			set{ right = value; }
		}
	}
}
