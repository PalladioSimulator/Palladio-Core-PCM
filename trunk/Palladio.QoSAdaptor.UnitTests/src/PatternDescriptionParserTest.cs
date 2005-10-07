#region info
///////////////////////////////////////////////////////////////////////////////
// This software has been developed as a part of the diploma thesis 
// "Einfluss von Generatorkonfiguration auf die QoS-Vorhersage für 
// Komponentenadapter" ("Influence of the configuration of a generator on the 
// prediction of the QoS of component adaptors")
// at the 
// University of Oldenburg
// Department of Computing Science
// Software Engineering Group
// Palladio Research Group
// (http://se.informatik.uni-oldenburg.de/research/projects/Palladio)
// 
// Development period: July 2005 - January 2006
// 
// Author: Niels Streekmann
// E-mail: niels.streekmann@informatik.uni-oldenburg.de
///////////////////////////////////////////////////////////////////////////////
#endregion

using Palladio.QoSAdaptor.Configuration;
using Palladio.QoSAdaptor.Pattern;
using NUnit.Framework;

namespace Palladio.QoSAdaptor.UnitTests
{
	/// <summary>
	/// Tests the PatternDescriptionParser. Takes the 
	/// cache_pattern_description.xml file as example. 
	/// </summary>
	[TestFixture]
	public class PatternDescriptionParserTest
	{
		private PatternDescriptionParser parser;

		#region initialisation and shutdown
		/// <summary>
		/// Initialises the parser and parses the cache pattern description.
		/// TODO: Check the parsed description.
		/// </summary>
		[SetUp]
		public void Init()
		{	
			this.parser = new PatternDescriptionParser(
				Config.PATTERN_DIRECTORY+"Cache\\cache_pattern_description.xml");
		}

		/// <summary>
		/// Shutdown method needed by NUnit
		/// </summary>
		[TearDown]
		public void Shutdown()
		{	
		}
		#endregion

		#region tests
		/// <summary>
		/// Tests if the parser works properly.
		/// </summary>
		[Test]
		public void SelectionTest()
		{
			PatternDescription pattern = this.parser.Pattern;
			Assert.AreEqual(pattern.Name, "Cache");
			// Further attributes of the description are not tested at the moment, 
			// because are probably changed in the further development. 
			// Besides this one test already shows that the file is parsed and at least 
			// parts of it are correct. 
		}
		#endregion
	}
}
