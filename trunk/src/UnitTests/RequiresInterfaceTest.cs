using System;
using System.Collections;
using System.Reflection;
using NUnit.Framework;
using Utils.Collections;
using Palladio.FiniteStateMachines;

namespace Palladio.ComponentModel.UnitTests
{
	/// <summary>
	/// </summary>
	[TestFixture]
	public class RequiresInterfaceTest : AbstractInterfaceModelTest
	{
		/// <summary>
		/// </summary>
		[SetUp] public void Init() 
		{
			modelOne = Helper.CreateReqInterface("../../data/d1.xml","d1");
			modelOne1 = Helper.CreateReqInterface("../../data/d1.xml","d1");
			modelTwo = Helper.CreateReqInterface("../../data/d2.xml","d2");
			modelIsec = Helper.CreateReqInterface("../../data/intersection.xml","d1-x-d2");
			modelMerged = Helper.CreateReqInterface("../../data/merged.xml","merged");
		}

		/// <summary>
		/// </summary>
		/// <param name="aModel"></param>
		protected override void Modify(ref IInterfaceModel aModel)
		{
			aModel = modelIsec;
		}


	}
}
