using System;
using System.Collections;
using System.Reflection;
using NUnit.Framework;
using Utils.Collections;

namespace Palladio.ComponentModel.UnitTests
{
	/// <summary>
	/// </summary>
	public abstract class AbstractInterfaceModelTest
	{
		protected IInterfaceModel modelOne, modelOne1, modelTwo, modelIsec, modelMerged;

		/// <summary>
		/// </summary>
		/// <param name="aModel"></param>
		protected abstract void Modify(ref IInterfaceModel aModel);

		/// <summary>
		/// </summary>
		[Test] public void Equals()
		{
			Assert.IsTrue(modelOne.Equals(modelOne1));
			Assert.IsFalse(modelOne.Equals(modelTwo));
		}

		/// <summary>
		/// </summary>
		[Test] public void Clone()
		{
			IInterfaceModel model = (IInterfaceModel) modelOne.Clone();
			Assert.IsTrue(model.Equals(modelOne));
			Modify(ref model);
			Assert.IsFalse(model.Equals(modelOne));
		}

		/// <summary>
		/// </summary>
		[Test] public void GetIntersection()
		{
			IInterfaceModel isec = modelOne.GetIntersection(modelTwo);
			Assert.AreEqual(modelIsec,isec);
			Assert.IsFalse(isec.Equals(modelOne));
			Assert.IsFalse(isec.Equals(modelTwo));
		}

		/// <summary>
		/// </summary>
		[Test] public void IsSubSetOf()
		{
			Assert.IsTrue(modelIsec.IsSubSetOf(modelOne));
			Assert.IsTrue(modelIsec.IsSubSetOf(modelTwo));
			Assert.IsFalse(modelOne.IsSubSetOf(modelTwo));
			Assert.IsFalse(modelTwo.IsSubSetOf(modelOne));
		}

		/// <summary>
		/// </summary>
		[Test] public void Merge()
		{
			// TODO fix bug in Palladio.FSM
//			IInterfaceModel merged = modelOne.Merge(modelTwo);
//			Assert.AreEqual(modelMerged,merged);
		}
		
	}
}
