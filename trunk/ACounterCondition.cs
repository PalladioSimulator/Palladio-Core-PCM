using System;
using FSM;

namespace FSM {
	/// <summary>
	///Abstract class describing the basic functionality of a condition for a counter.
	/// </summary>
	public abstract class ACounterCondition {

		private int requiredDistance;
		private int currentDistance;
		private Set setA;
		private Set setB;

		
		public ACounterCondition(){
			requiredDistance = 0;
			currentDistance = 0;
			setA = new Set();
			setB = new Set();
		}

		public ACounterCondition(Set aSetA, Set aSetB, int aDistance){
			requiredDistance = aDistance;
			currentDistance = 0;
			setA = aSetA;
			setB = aSetB;
		}

		public ACounterCondition(Input inputA, Input inputB, int aDistance){
			requiredDistance = aDistance;
			currentDistance = 0;
			setA = new Set();
			setA.Add(inputA);
			setB = new Set();
			setB.Add(inputB);
		}

		protected int RequiredDistance{
			get { return requiredDistance; }
		}

		protected int CurrentDistance{
			get { return currentDistance; }
		}

		/// <summary>
		/// Adds the next input to the condition.
		/// </summary>
		public void ReadInput(Input anInput) {
			if (setA.Contains(anInput)){
				currentDistance++;
			} else if (setB.Contains(anInput)){
				currentDistance--;
			}
		}

		/// <summary>
		///Checks the condition for the so far read prefix.
		/// </summary>
		public abstract bool CheckPrefix();

		/// <summary>
		/// Checks the condition for the read input, assuming that it is a terminal word.
		/// </summary>
		public abstract bool CheckTerminalWord();

	
	
	}
}