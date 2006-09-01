using System;
using System.Collections;
using antlr;
using antlr.collections;

namespace QmlParser
{
	/// <summary>
	/// Zusammenfassung für NodeHelper.
	/// </summary>
	public sealed class NodeHelper
	{

		public static void CopyComments(AST fromAST, AST toAST)
		{
			antlr.CommonHiddenStreamToken commentBefore = (CommonHiddenStreamToken)(((QMLAST)fromAST).getHiddenBefore());
			antlr.CommonHiddenStreamToken commentAfter = (CommonHiddenStreamToken)(((QMLAST)toAST).getHiddenAfter());
			((QMLAST)toAST).setHiddenTokenBefore(commentBefore);
			((QMLAST)toAST).setHiddenTokenAfter(commentAfter);
		}

		public static void CopyLocation(AST fromAST, AST toAST)
		{
			int line = ((QMLAST)fromAST).Line;
			int column = ((QMLAST)fromAST).Column;
			((QMLAST)toAST).Line = line;
			((QMLAST)toAST).Column = column;
		}
	}
}
