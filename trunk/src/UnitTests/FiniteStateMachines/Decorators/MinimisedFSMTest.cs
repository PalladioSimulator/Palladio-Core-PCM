using System;
using System.Collections;
using FiniteStateMachines;
using FiniteStateMachines.Decorators;
using NUnit.Framework;

namespace UnitTests.FiniteStateMachines.Decorators {

	[TestFixture]
	public class MinimisedFSMTest {

		IFiniteStateMachine originalFSM;
		IFiniteStateMachine minimisedFSM;

		[SetUp] public void Init() {
			originalFSM = AbstractFiniteStateMachine.Loader("../../data/minimisableFSM.xml");
			minimisedFSM = AbstractFiniteStateMachine.Loader("../../data/minimisedFSM.xml");
		}

		[Test] public void Minimise() {
			IFiniteStateMachine result = new MinimisedFSM( originalFSM );
			Assert.IsTrue( AbstractFiniteStateMachine.AreEqual( result, minimisedFSM ));
		}

		public static void Main() {
			MinimisedFSMTest test = new MinimisedFSMTest();
		}
	}
}
