using System;
using System.Collections;
using System.Reflection;
using NUnit.Framework;
using Utils.Collections;

namespace Palladio.ComponentModel.UnitTests
{
	/// <summary>
	/// </summary>
	[TestFixture]
	public class SignatureIModelTest : AbstractInterfaceModelTest
	{
		IInterfaceModel corruptedModel;

		/// <summary>
		/// </summary>
		[SetUp] public void Init() 
		{
			modelOne = Helper.CreateSigListIModel("sig1", "sig2", "sig3");
			modelOne1 = Helper.CreateSigListIModel("sig1", "sig2", "sig3");
			modelTwo = Helper.CreateSigListIModel("sig3", "sig4", "sig5");
			modelMerged = Helper.CreateSigListIModel("sig1", "sig2", "sig3", "sig4", "sig5");
			modelIsec = Helper.CreateSigListIModel("sig3");
			corruptedModel = Helper.CreateSigListIModel("sig1", "sig2", "sig3", "sig3");
		}

		/// <summary>
		/// </summary>
		/// <param name="aModel"></param>
		protected override void Modify(ref IInterfaceModel aModel)
		{
			SignatureListIModel sigModel = (SignatureListIModel) aModel;
			sigModel.SignatureList.Add( new SimpleSignature("sig6") );
		}

		/// <summary>
		/// </summary>
		[ExpectedException(typeof(AmbiguousMatchException))]
		[Test] public void CorruptedMerge()
		{
			IInterfaceModel result = corruptedModel.Merge(modelOne);
		}
	}
}
