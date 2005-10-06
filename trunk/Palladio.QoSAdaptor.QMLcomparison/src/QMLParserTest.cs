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
using System;
using System.Collections;
using System.IO;
using antlr;
using antlr.collections;
using antlr.debug;
using Palladio.QoSAdaptor.QMLComparison.QmlSpecification;
using QmlParser;
using QmlParser.Semantic;

namespace Palladio.QoSAdaptor.QMLComparison
{
	/// <summary>
	/// Zusammenfassung für QMLParserTest.
	/// </summary>
	public class QMLParserTest
	{
		static void Main (string[] args)
		{
			if ((args[0] == null) || args[1] == null)
			{
				Console.WriteLine("Two qml specifications have to be given as parameters.");
				return;
			}
		
			FileStream fileStream = new FileStream(args[0], 
				System.IO.FileMode.Open);
			StreamReader sr = new StreamReader(fileStream);
			QMLSpecification requiredSpecification = CreateSpecification(
				sr);
			fileStream = new FileStream(args[1], System.IO.FileMode.Open);
			sr = new StreamReader(fileStream);
			QMLSpecification providedSpecification = CreateSpecification(
				sr);

			Console.WriteLine("\nREQUIRED SPECIFICATION \n"+
				requiredSpecification.ToString());
			Console.WriteLine("\n\nPROVIDED SPECIFICATION \n"+
				providedSpecification.ToString());

			/*try
			{*/
				IList mismatches = requiredSpecification.GetMismatches(
					providedSpecification);	
				Console.WriteLine();
				Console.WriteLine("MISMATCHES:");
				IEnumerator enu = mismatches.GetEnumerator();
				while (enu.MoveNext())
				{
					QMLMismatch qmlMismatch = (QMLMismatch)enu.Current;
					Console.WriteLine(qmlMismatch.ToString());
				}
			/*}
			catch (Exception e)
			{
				Console.WriteLine(e.Message);
			}*/


			/*
			// TODO: catch and throw exceptions
			FileStream fileStream = new FileStream(args[0], System.IO.FileMode.Open);
			StreamReader sr = new StreamReader(fileStream);

			QMLLexer lexer = new QMLLexer(sr);	
			lexer.setTokenObjectClass("antlr.CommonHiddenStreamToken");
				
			TokenStreamHiddenTokenFilter filter = new TokenStreamHiddenTokenFilter(lexer); 
			filter.hide(QMLLexer.SL_COMMENT);
			filter.hide(QMLLexer.ML_COMMENT);

			QMLParser parser = new QMLParser(filter);
			parser.setASTNodeClass("QmlParser.QMLAST");

			try
			{
				parser.declarations();
			}
			catch (antlr.MismatchedTokenException e)
			{
				Console.WriteLine(e.fileName+" "+e.line+" "+e.Message);
			}
				
			antlr.CommonAST ast = (antlr.CommonAST)parser.getAST();

			PrettyPrintTextTreeWalker pp = new PrettyPrintTextTreeWalker();
			string astString = pp.PrettyPrint(ast);

			Console.WriteLine(astString);
			Console.WriteLine();
			Console.WriteLine();

			Console.WriteLine("ROOT = "+ast.getText());
			AST ast2 = ast.getFirstChild();
			for (int i=0; i<ast.getNumberOfChildren(); i++)
			{
				Console.WriteLine("CHILD"+(i+1)+" = "+ast2.getText());
				ast2 = ast2.getNextSibling();
			}
			*/
		}

		/*
		private static void testComparison(string[] args)
		{
			// parse required 
			FileStream fileStream = new FileStream(args[0], System.IO.FileMode.Open);
			StreamReader sr = new StreamReader(fileStream);
			QMLLexer lexer = new QMLLexer(sr);	
			lexer.setTokenObjectClass("antlr.CommonHiddenStreamToken");
			QMLParser parser = new QMLParser(lexer);
			parser.setASTNodeClass("QmlParser.QMLAST");
			parser.declarations();

			// parse provided 
			FileStream fileStream2 = new FileStream(args[1], System.IO.FileMode.Open);
			StreamReader sr2 = new StreamReader(fileStream2);
			QMLLexer lexer2 = new QMLLexer(sr2);	
			lexer2.setTokenObjectClass("antlr.CommonHiddenStreamToken");
			QMLParser parser2 = new QMLParser(lexer2);
			parser2.setASTNodeClass("QmlParser.QMLAST");
			parser2.declarations();

			QMLComparator comparator = new QMLComparator();
			comparator.Compare(parser.getAST(), parser2.getAST());

		}*/

		public static QMLSpecification CreateSpecification (TextReader 
			textReader)
		{
			QMLLexer lexer = new QMLLexer(textReader);	
			lexer.setTokenObjectClass("antlr.CommonHiddenStreamToken");
			QMLParser parser = new QMLParser(lexer);
			parser.setASTNodeClass("QmlParser.QMLAST");
			parser.declarations();

			QMLSpecification specification = new QMLSpecification(
													parser.getAST());

			return specification;
		}
	}
}
