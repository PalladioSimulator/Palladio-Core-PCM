using System;
using NUnit.Framework;
using XMLConfigReader;

namespace XMLConfigReader.UnitTest
{
	/// <summary>
	/// Zusammenfassung für XMLConfigReaderTest.
	/// </summary>
	/// 
	[TestFixture]
	public class XMLConfigReaderTest
	{
		protected XMLConfigFileReader reader;
		public XMLConfigReaderTest()
		{
			//
			// TODO: Fügen Sie hier die Konstruktorlogik hinzu
			//
		}

		[SetUp]public void Init()
		{
			this.reader = new XMLConfigFileReader(@"C:\Dokumente und Einstellungen\Yvette\Eigene Dateien\Visual Studio Projects\WebserverComponents\XMLConfigReader\UnitTest\TestXMLFile.xml");
		}

		[Test]public void CheckStartUP()
		{
			Assert.IsTrue(true);
			Console.WriteLine("habe geladen");
		}

		//		[Test]
		//		public void NothingTest()
		//		{
		//			Console.WriteLine("Nothing Test");
		//		}
		//		public static void Main()
		//		{
		//			XMLConfigReaderTest test = new XMLConfigReaderTest();
		//			test.Init();
		//			test.CheckStartUP();
		//		}
	}
}
