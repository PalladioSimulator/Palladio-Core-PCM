using System;
using FSM;

namespace FSM {
	/// <summary>
	/// Implements the condition DistanceEqual.
	/// </summary>
	public class CCDistanceEqual : ACounterCondition {


		public CCDistanceEqual(Set aSetA, Set aSetB, int aDistance): base(aSetA,aSetB,aDistance){}

		public CCDistanceEqual(Input inputA, Input inputB, int aDistance): base(inputA,inputB,aDistance){}

		/// <summary>
		///Checks the condition for the so far read prefix.
		/// </summary>
		public override bool CheckPrefix() {
			return ( CurrentDistance >= RequiredDistance );
		}




		/// <summary>
		/// Checks the condition for the read input, assuming that it is a terminal word.
		/// </summary>
		public override bool CheckTerminalWord() {
			return (CurrentDistance == RequiredDistance);
		}

	
	}
}