using System;
using Utils.Collections;
using FiniteStateMachines;

namespace ParameterisedContracts
{
	/// <summary>
	/// Class describing the basic functionality of a condition for a counter.
	/// 
	/// author: JH
	/// </summary>
	/// <remarks>
	///	This class is only needed implicit by StackFiniteStateMachine
	/// </remarks>
	public class CounterCondition {

		private int requiredDistance;
		private int currentDistance;
		private Set setA;
		private Set setB;

		
		public CounterCondition(Set aSetA, Set aSetB, int aDistance){
			requiredDistance = aDistance;
			currentDistance = 0;
			setA = aSetA;
			setB = aSetB;
		}

		public CounterCondition(Input inputA, Input inputB, int aDistance){
			requiredDistance = aDistance;
			currentDistance = 0;
			setA = new Set();
			setA.Add(inputA);
			setB = new Set();
			setB.Add(inputB);
		}

		/// <summary>
		///		Adjust the condition for a new input symbol.
		/// </summary>
		public void ReadInput(Input anInput) {
			if (setA.Contains(anInput)){
				currentDistance++;
			} else if (setB.Contains(anInput)){
				currentDistance--;
			}
		}

		/// <summary>
		///		Checks the condition for the so far read prefix.
		/// </summary>
		public bool CheckPrefix(){
			return ( currentDistance >= requiredDistance );
		}

		/// <summary>
		///		Checks the condition for the read input, 
		///		assuming that it is a terminal word.
		/// </summary>
		public bool CheckTerminalWord(){
			return ( currentDistance == requiredDistance);
		}

	
	
	}
}