using System;
using System.Collections;
using System.Reflection;
using NUnit.Framework;
using Palladio.FiniteStateMachines;

namespace Palladio.ComponentModel.UnitTests
{
	/// <summary>
	/// </summary>
	[TestFixture]
	public class ProtocolIModelTest
	{
		IFiniteStateMachine fsmOne, fsmTwo, fsmThree, fsmIsec;
		ProtocolIModel modelOne, modelTwo, modelThree, expectedIsec;

		/// <summary>
		/// </summary>
		[SetUp] public void Init() 
		{
			FSMFactory factory = new FSMFactory();
			fsmOne = factory.CreateFSMFromFile("../../data/se_d1.xml");
			fsmTwo = factory.CreateFSMFromFile("../../data/se_d2.xml");
			fsmThree = factory.CreateFSMFromFile("../../data/se_d1.xml");
			fsmIsec = factory.CreateFSMFromFile("../../data/intersection.xml");


			modelOne = new ProtocolIModel(fsmOne, Helper.SigListFromInputAlphabet(fsmOne.InputAlphabet));
			modelTwo = new ProtocolIModel(fsmTwo, Helper.SigListFromInputAlphabet(fsmTwo.InputAlphabet));
			modelThree = new ProtocolIModel(fsmThree, Helper.SigListFromInputAlphabet(fsmThree.InputAlphabet));
			expectedIsec = new ProtocolIModel(fsmIsec, Helper.SigListFromInputAlphabet(fsmIsec.InputAlphabet));
		}

		/// <summary>
		/// </summary>
		[Test] public void Equals()
		{
			Assert.IsTrue(modelOne.Equals(modelThree));
			Assert.IsFalse(modelOne.Equals(modelTwo));
		}

		/// <summary>
		/// </summary>
		[Test] public void Clone()
		{
			ProtocolIModel model = (ProtocolIModel) modelOne.Clone();
			Assert.IsTrue(model.Equals(modelOne));
		}

		/// <summary>
		/// </summary>
		[Test] public void GetIntersection()
		{
			IInterfaceModel isec = modelOne.GetIntersection(modelTwo);
			expectedIsec.Equals(isec);
//			Assert.AreEqual(expectedIsec,isec);
//			Assert.IsFalse(expectedIsec.Equals(modelOne));
//			Assert.IsFalse(expectedIsec.Equals(modelTwo));
		}

//		/// <summary>
//		/// </summary>
//		[Test] public void IsSubSetOf()
//		{
//			Assert.IsTrue(expectedIsec.IsSubSetOf(modelOne));
//			Assert.IsTrue(expectedIsec.IsSubSetOf(modelTwo));
//			Assert.IsFalse(modelOne.IsSubSetOf(modelTwo));
//			Assert.IsFalse(modelTwo.IsSubSetOf(modelOne));
//		}
//
//		/// <summary>
//		/// </summary>
//		[Test] public void Merge()
//		{
//			IInterfaceModel merged = modelOne.Merge(modelTwo);
//			Assert.AreEqual(expectedMerge,merged);
//		}
//
//		/// <summary>
//		/// </summary>
//		[ExpectedException(typeof(AmbiguousMatchException))]
//		[Test] public void CorruptedMerge()
//		{
//			IInterfaceModel result = corrupted.Merge(modelOne);
//		}
	}
}
