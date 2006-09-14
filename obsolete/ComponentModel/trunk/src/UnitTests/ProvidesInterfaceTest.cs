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
	public class ProvidesInterfaceTest : AbstractInterfaceModelTest
	{
		ProvidesInterface modelNoSrv;
		/// <summary>
		/// </summary>
		[SetUp] public void Init() 
		{
			modelOne = Helper.CreateProvidesIface("../../data","provOne","d1","d2");
			modelOne1 = Helper.CreateProvidesIface("../../data","provOne","d1","d2");
			modelTwo = Helper.CreateProvidesIface("../../data","provTwo","d2","d3");
			modelIsec = Helper.CreateProvidesIface("../../data","provOne-x-provTwo","d2");
			modelMerged = Helper.CreateProvidesIface("../../data","provMerged","d1","d2","d3");
			modelNoSrv = Helper.CreateProvidesIface("../../data","provOne");
		}

		protected override void Modify(ref IInterfaceModel aModel)
		{
			((ProvidesInterface)aModel).ServiceList.RemoveAt(0);
		}

		/// <summary>
		/// </summary>
		[Test] public void ServiceListValid()
		{
			//TODO implementation
		}
	}
}
