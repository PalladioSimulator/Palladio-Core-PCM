using System;
using FSM;

namespace FSM {
	/// <summary>
	/// Summary Description
	/// </summary>
	public class CCDistance : ACounterCondition{


		public CCDistance(Set aSetA, Set aSetB, int aDistance): base(aSetA,aSetB,aDistance){}

		public CCDistance(Input inputA, Input inputB, int aDistance): base(inputA,inputB,aDistance){}

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
			return CheckPrefix();
		}

	
	
	}
}