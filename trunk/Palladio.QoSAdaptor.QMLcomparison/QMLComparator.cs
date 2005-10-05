#region info
///////////////////////////////////////////////////////////////////////////////
/// This software has been developed as a part of the diploma thesis 
/// "Einfluss von Generatorkonfiguration auf die QoS-Vorhersage für 
/// Komponentenadapter" ("Influence of the configuration of a generator on the 
/// prediction of the QoS of component adaptors")
/// at the 
/// University of Oldenburg
/// Department of Computing Science
/// Software Engineering Group
/// Palladio Research Group
/// (http://se.informatik.uni-oldenburg.de/research/projects/Palladio)
/// 
/// Development period: July 2005 - January 2006
/// 
/// Author: Niels Streekmann
/// E-mail: niels.streekmann@informatik.uni-oldenburg.de
///////////////////////////////////////////////////////////////////////////////
#endregion

using System.Collections;
using System.IO;
using antlr.collections;
using Palladio.QoSAdaptor.QMLComparison.QmlSpecification;
using QmlParser;

namespace Palladio.QoSAdaptor.QMLComparison
{
	
	public class QMLComparator : IComparator
	{
		#region data
		private string requiredString;
		private string providedString;
		#endregion

		#region constructor
		/// <summary>
		/// Standard constructor.
		/// </summary>
		public QMLComparator()
		{
		}
		#endregion

		#region properties
		/// <summary>
		/// Returns the last parsed required specification in its string 
		/// representation
		/// </summary>
		public string RequiredSpecificationString
		{
			get
			{
				return this.requiredString;
			}
		}

		/// <summary>
		/// Returns the last parsed provided specification in its string 
		/// representation
		/// </summary>
		public string ProvidedSpecificationString
		{
			get
			{
				return this.providedString;
			}
		}
		#endregion

		#region public methods
		public IList FindMismatches (TextReader required, TextReader provided)
		{
			QMLSpecification requiredSpecification = CreateSpecification(
				required);
			QMLSpecification providedSpecification = CreateSpecification(
				provided);

			this.requiredString = requiredSpecification.ToString();
			this.providedString = providedSpecification.ToString();

			IList mismatches = requiredSpecification.GetMismatches(
				providedSpecification);	

			/* BEGIN DEBUG OUTPUT
			Console.WriteLine("\nREQUIRED SPECIFICATION:\n");
			Console.WriteLine(requiredSpecification.ToString());
			Console.WriteLine("\n\nPROVIDEDED SPECIFICATION:\n");
			Console.WriteLine(providedSpecification.ToString());
			// END DEBUG OUTPUT*/

			return mismatches;
		}

		/// <summary>
		/// Parses the given QML specification, builds an internal model of the
		/// specification and returns its string representation.
		/// Can e.g. be used for debugging of the parser. 
		/// </summary>
		/// <param name="specificationReader">A TextReader representing a QML
		/// specification.</param>
		/// <returns>The string representation of the internal model of the
		/// QML specification.</returns>
		public string Parse (TextReader specificationReader)
		{
			QMLSpecification specification = CreateSpecification(
				specificationReader);
			return specification.ToString();
		}
		#endregion

		#region private methods
		private QMLSpecification CreateSpecification (TextReader 
			textReader)
		{
			QMLLexer lexer = new QMLLexer(textReader);	
			lexer.setTokenObjectClass("antlr.CommonHiddenStreamToken");
			QMLParser parser = new QMLParser(lexer);
			parser.setASTNodeClass("QmlParser.QMLAST");
			parser.declarations();

			QMLSpecification specification = new QMLSpecification(
				(AST)parser.getAST());

			return specification;
		}
		#endregion
	}
}
