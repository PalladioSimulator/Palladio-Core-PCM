#if TEST

using NUnit.Framework;
using Palladio.ComponentModel;
using Palladio.Identifier;
using Palladio.Reliability.WebserverComponentModel;

namespace Palladio.Reliability.WebserverAnalyser.Tests
{
	/// <summary>
	/// 
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2004/12/15 00:05:15  sliver
	/// initial checkin after some major refactorings
	///
	/// </pre>
	/// </remarks>
	/// <exclude />
	[TestFixture]
	public class ModelFactoryTest
	{
		[SetUp]
		public void Init()
		{
		}

		[Test]
		public void CreatWebserver()
		{
			ICompositeComponent ws = WebserverComponentFactory.CreateWebserver();
			Assert.AreEqual("Webserver", ws.Name);
		}

		[Test]
		public void CreateRequestParser()
		{
			ICompositeComponent comp = WebserverComponentFactory.CreateRequestParser();
			Assert.AreEqual("RequestParser", comp.Name);
		}

		[Test]
		public void CreateHTTPRequestProcessor()
		{
			ICompositeComponent comp = WebserverComponentFactory.CreateHTTPRequestProcessor();
			Assert.AreEqual("HTTPRequestProcessor", comp.Name);
		}

		[Test]
		public void CreateIDispatcher()
		{
			IInterfaceModel configReader = WebserverInterfaceFactory.CreateIDispatcher();
			Assert.AreEqual("IDispatcher", configReader.Name);
		}

		[Test]
		public void CreateDefaultDispatcher()
		{
//			IComponent dispatcher = WebserverModelFactory.CreateDefaultDispatcher();
//			Assert.AreEqual("DefaultDispatcher", dispatcher.Name);
		}

		private IIdentifier ID(string aID)
		{
			return IdentifiableFactory.CreateStringID(aID);
		}
	}
}

#endif