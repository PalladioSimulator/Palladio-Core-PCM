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
			// TODO: catch and throw exceptions
			FileStream fileStream = new FileStream(args[0], System.IO.FileMode.Open);
			StreamReader sr = new StreamReader(fileStream);
			/*QMLLexer lexer = new QMLLexer(sr);
			QMLParser parser = new QMLParser(lexer);
			try
			{
				//parser.declarations();
				parser.profileDecl();
			}
			catch (antlr.MismatchedTokenException e)
			{
				Console.WriteLine(e.fileName+" "+e.line+" "+e.Message);
			}
			AST ast = parser.getAST();
			PrettyPrintTextTreeWalker pp = new PrettyPrintTextTreeWalker();
			Console.WriteLine(pp.PrettyPrint(ast));*/

			QMLLexer lexer = new QMLLexer(sr);	
			lexer.setTokenObjectClass("antlr.CommonHiddenStreamToken");
				
			TokenStreamHiddenTokenFilter filter = new TokenStreamHiddenTokenFilter(lexer); 
			filter.hide(QMLLexer.SL_COMMENT);
			filter.hide(QMLLexer.ML_COMMENT);

			QMLParser parser = new QMLParser(filter);
			parser.setASTNodeClass("QmlParser.QMLAST");

			

				try
				{
					//parser.declarations();
					parser.declarations();
				}
				catch (antlr.MismatchedTokenException e)
				{
					Console.WriteLine(e.fileName+" "+e.line+" "+e.Message);
				}
				
				antlr.CommonAST ast = (antlr.CommonAST)parser.getAST();

				while (ast != null)
				{
				Console.WriteLine("NEW DECLARATION");
				if (ast == null)
					Console.WriteLine("AST == NULL");

				PrettyPrintTextTreeWalker pp = new PrettyPrintTextTreeWalker();
				string tc = pp.PrettyPrint(ast);
				Console.WriteLine("TC: "+tc);
				Console.WriteLine();

				// ASTFrame frame = new ASTFrame("QML AST Debugger", ast);
				// frame.Show();

				/*StringReader sr1 = new StringReader(tc);
				QMLLexer lexer1 = new QMLLexer(sr1);	
				lexer1.setTokenObjectClass("antlr.CommonHiddenStreamToken");
				
				TokenStreamHiddenTokenFilter filter1 = new TokenStreamHiddenTokenFilter(lexer1); 
				filter1.hide(QMLLexer.SL_COMMENT);
				filter1.hide(QMLLexer.ML_COMMENT);

				QMLParser parser1 = new QMLParser(filter1);
				parser1.setASTNodeClass("QmlParser.QMLAST");
				parser1.declarations();

				antlr.CommonAST ast1 = (antlr.CommonAST)parser1.getAST();
              
				SemanticTreeWalker stw = new SemanticTreeWalker();
				SymboleTable st = stw.Check(ast1);
				Console.WriteLine(st.ToString());*/

				/*IEnumerator ienum2 = this.dockManager.Contents.GetEnumerator();
				while (ienum2.MoveNext())
				{
							
					if (((Content)(ienum2.Current)).Name == "OutputWindow")
					{
						TextBox tb = ((OutputWindow)(ienum2.Current)).textBox1;
						tb.Text += st.ToString();
						tb.Text += "\r\n";

						tb.Text += stw.GetErrorsDebug();

						IEnumerator ienum = stw.GetErrors();
						while (ienum.MoveNext())
						{
							Error error = (Error)ienum.Current;
							Point position = new Point(error.Column-1, error.Line-1);

							int offset = tc.Document.PositionToOffset(position);

							Point a = tc.Document.OffsetToPosition(offset);


							TextMarker tm = new TextMarker(offset, error.Length-1, TextMarkerType.WaveLine);
							tm.ToolTip = error.Message;
							tc.Document.MarkerStrategy.TextMarker.Add(tm);
						}

						tc.Select();

					}
				}*/
					try
					{
						parser.declarations();
					}
					catch (antlr.MismatchedTokenException e)
					{
						Console.WriteLine(e.fileName+" "+e.line+" "+e.Message);
					}

					ast = (antlr.CommonAST)parser.getAST();
			}
		}
	}
}
