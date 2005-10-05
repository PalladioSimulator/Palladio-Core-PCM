using System;
using System.IO;

using antlr.collections;
using antlr;

namespace QmlParser
{

	public class PrettyPrintTextTreeWalker
	{

		#region Pretty Print Handler Class

		private class PrettyPrintHandler
		{
			const string NEW_LINE = "\n";
			private string _str = String.Empty;

			public string PrettyPrint
			{
				set
				{
					this._str = value;
				}
				get
				{
					return this._str;
				}
			}

			public string PrettyPrintNewLine
			{
				set
				{
					this._str = value + NEW_LINE;
				}
				get
				{
					return this._str;
				}
			}
		}

		#endregion

		#region Space Handler Class

		private class SpaceHandler
		{
			const int STEP = 3;
			private int _spaces = -1;

			public SpaceHandler() { this._spaces = 0; }
			public void Inc() { this._spaces += STEP; }
			public void Dec() { this._spaces -= STEP; }
			public string Print() { string str = String.Empty; return str.PadRight(this._spaces); }
		}

		#endregion

		#region Private Variables

		private SpaceHandler _spaces;
		private PrettyPrintHandler _output;
		private bool _includeComments;

		#endregion

		#region Public Methods

		public PrettyPrintTextTreeWalker()
		{
			this._spaces = new SpaceHandler();
			this._output = new PrettyPrintHandler();
			this._includeComments = true;
		}

		public string PrettyPrint(AST t)
		{
			declarations(t);
			return this._output.PrettyPrint;
		}

		public string PrettyPrint(AST t, bool includeComments)
		{
			this._includeComments = includeComments;
			return PrettyPrint(t);
		}

		#endregion

		#region Private Tree Walker Methods

		private string comment(AST t)
		{
			string commentStr = String.Empty;

			if (!this._includeComments)
				return commentStr;

			QMLAST hiddenBeforeNode = (QMLAST)t;
			if (hiddenBeforeNode.getHiddenBefore() != null) 
			{
				commentStr = hiddenBeforeNode.getHiddenBefore().getText().Trim(); 

				if (commentStr.IndexOf('\n') == -1 &&
					commentStr.IndexOf('\r') == -1 &&
					commentStr.IndexOf("\n\r") == -1 &&
					commentStr.IndexOf("\r\n") == -1)
				{
					commentStr = "// " + commentStr + "\n";
					commentStr += this._spaces.Print();
				}
				else
				{
					StringReader sr = new StringReader(commentStr);
					string str = String.Empty;
					commentStr = String.Empty;
					commentStr += "/*";
					commentStr += "\n";
					commentStr += this._spaces.Print();
					while ((str = sr.ReadLine()) != null)
					{
						commentStr += "*";
						commentStr += " ";
						commentStr += str.Trim();
						commentStr += "\n";
						commentStr += this._spaces.Print();
					}
					commentStr += "*/";
					commentStr += "\n";
					commentStr += this._spaces.Print();
				}
			}
			
			return commentStr;
		}

		private void declarations(AST t)
		{
			AST currentAST = t.getFirstChild();
			
			while (currentAST != null)
			{
				if (currentAST.Type == QMLTokenTypes.CONTRACT_TYPE_DECL)
					conractTypeDecl(currentAST);
				else if (currentAST.Type == QMLTokenTypes.CONTRACT_DECL)
					contractDecl(currentAST);
				else if (currentAST.Type == QMLTokenTypes.PROFILE_DECL)
					profileDecl(currentAST);
				this._output.PrettyPrintNewLine += "";
				currentAST = currentAST.getNextSibling();
			}
		}

		// -------------------- Contract Type Decl --------------------
		#region contractTypeDecl

		private void conractTypeDecl(AST t)
		{
			AST currentAST = t.getFirstChild();

			// TO DO
			// this._output.PrettyPrint += this.comment(currentAST);
			
			this._output.PrettyPrint += "type ";
			this._output.PrettyPrint += currentAST.getText();
			this._output.PrettyPrintNewLine += " = contract {";

			currentAST = currentAST.getNextSibling();

			this._spaces.Inc();
			while (currentAST != null)
			{
				dimensionDecl(currentAST);
				currentAST = currentAST.getNextSibling();
			}
			this._spaces.Dec();

			this._output.PrettyPrintNewLine += "}";
		}

		private void dimensionDecl(AST t)
		{
			AST currentAST = t.getFirstChild();
			this._output.PrettyPrint += this._spaces.Print();

			// TO DO
			// this._output.PrettyPrint += this.comment(dimAST.getFirstChild());

			this._output.PrettyPrint += currentAST.getText();
			currentAST = currentAST.getNextSibling();

			this._output.PrettyPrint += " : ";

			dimensionType(currentAST);
			currentAST = currentAST.getNextSibling();
			// check if unit is specified
			if (currentAST != null)
			{
				this._output.PrettyPrint += " ";
				unit(currentAST);
			}
				
			this._output.PrettyPrintNewLine += ";";
		}

		private void dimensionType(AST t)
		{
			if (t.Type == QMLTokenTypes.ENUM_DEF)
				enumDef(t);
			else if(t.Type == QMLTokenTypes.SET_DEF)
				setDef(t);
			else if (t.Type == QMLTokenTypes.NUMERIC_DEF)
				numericDef(t);
		}

		private void enumDef(AST t)
		{
			AST currentAST = t.getFirstChild();

			if (currentAST.Type == QMLTokenTypes.INCREASING_ORDER_SEM ||
				currentAST.Type == QMLTokenTypes.DECREASING_ORDER_SEM)
			{
				this._output.PrettyPrint += currentAST.getText();
				this._output.PrettyPrint += " ";
				currentAST = currentAST.getNextSibling();
			}
				
			this._output.PrettyPrint += "enum {";
			nameList(currentAST);
			this._output.PrettyPrint += "}";

			currentAST = currentAST.getNextSibling();
			// has order
			if (currentAST != null)
				orderDef(currentAST);
		}

		private void setDef(AST t)
		{
			AST currentAST = t.getFirstChild();

			if (currentAST.Type == QMLTokenTypes.INCREASING_ORDER_SEM ||
				currentAST.Type == QMLTokenTypes.DECREASING_ORDER_SEM)
			{
				this._output.PrettyPrint += currentAST.getText();
				this._output.PrettyPrint += " ";
				currentAST = currentAST.getNextSibling();
			}

			this._output.PrettyPrint += "set {";
			nameList(currentAST);
			this._output.PrettyPrint += "}";

			currentAST = currentAST.getNextSibling();
			// has order
			if (currentAST != null)
				orderDef(currentAST);
		}

		private void orderDef(AST t)
		{
			AST currentAST = t.getFirstChild();
			this._output.PrettyPrint += " with order {";

			while (currentAST != null)
			{
				oneOrder(currentAST);
				currentAST = currentAST.getNextSibling();
				if (currentAST != null) 
					this._output.PrettyPrint += ", ";
			}

			this._output.PrettyPrint += "}";
		}

		private void oneOrder(AST t)
		{
			AST currentAST = t.getFirstChild();
			this._output.PrettyPrint += currentAST.getText();
			this._output.PrettyPrint += " < ";
			currentAST = currentAST.getNextSibling();
			this._output.PrettyPrint += currentAST.getText();
		}		

		private void numericDef(AST t)
		{
			AST currentAST = t.getFirstChild();
			this._output.PrettyPrint += currentAST.getText();
			this._output.PrettyPrint += " numeric";
		}

		private void unit(AST t)
		{
			AST currentAST = t.getFirstChild();
			this._output.PrettyPrint += currentAST.getText();

			currentAST = currentAST.getNextSibling();
			// have second part
			if (currentAST != null)
			{
				this._output.PrettyPrint += " / ";
				this._output.PrettyPrint += currentAST.getText();
			}
		}

		#endregion

		// -------------------- Contract Decl -------------------------
		#region contractDecl
		private void contractDecl(AST t)
		{
			AST currentAST = t.getFirstChild();

			// TO DO
			// this._output.PrettyPrint += this.comment(declAST);

			this._output.PrettyPrint += currentAST.getText();
			this._output.PrettyPrint += " = ";
			
			currentAST = currentAST.getNextSibling();
			contrExp(currentAST);
			this._output.PrettyPrintNewLine += "";

		}

		private void contrExp(AST t)
		{
			AST currentAST = t.getFirstChild();

			this._output.PrettyPrint += currentAST.getText();

			// type
			if (t.Type == QMLTokenTypes.CONTRACT_EXP_CONTRACT)
				this._output.PrettyPrintNewLine += " contract {";
			else
				this._output.PrettyPrintNewLine += " refined by {";

			currentAST = currentAST.getNextSibling();

			this._spaces.Inc();
			while (currentAST != null)
			{
				dimContraint(currentAST);
				currentAST = currentAST.getNextSibling();
			}
			this._spaces.Dec();

			this._output.PrettyPrint += this._spaces.Print();
			this._output.PrettyPrint += "}";
		}

		private void dimContraint(AST t)
		{
			this._output.PrettyPrint += this._spaces.Print();
			if (t.Type == QMLTokenTypes.SIMPLE_CONSTR)
				simpleConstr(t);
			else if(t.Type == QMLTokenTypes.ASPECT_CONSTR)
				aspectConstr(t);
			this._output.PrettyPrintNewLine += ";";
		}

		private void simpleConstr(AST t)
		{
			AST currentAST = t.getFirstChild();
			
			// TO DO
			// this._output.PrettyPrint += this.comment(simpleAST.getFirstChild());

			this._output.PrettyPrint += currentAST.getText();
			currentAST = currentAST.getNextSibling();

			numOp(currentAST);
			currentAST = currentAST.getNextSibling();

			valueLiteral(currentAST);
			currentAST = currentAST.getNextSibling();

			// has unit
			if (currentAST != null)
			{
				this._output.PrettyPrint += " ";
				this.unit(currentAST);
			}
		}

		private void valueLiteral(AST t)
		{
			if (t.Type != QMLTokenTypes.NAME_LIST)
				this._output.PrettyPrint += t.getText();
			else
			{
				this._output.PrettyPrint += "{";
				nameList(t);
				this._output.PrettyPrint += "}";
			}
		}

		private void aspectConstr(AST t)
		{
			AST currentAST = t.getFirstChild();

			// TO DO
			// this._output.PrettyPrint += this.comment(aspectAST.getFirstChild());
			this._output.PrettyPrint += currentAST.getText();
			this._output.PrettyPrintNewLine += " {";

			currentAST = currentAST.getNextSibling();
			this._spaces.Inc();
			while (currentAST != null)
			{
				statConstr(currentAST);
				currentAST = currentAST.getNextSibling();
			}
			this._spaces.Dec();
			this._output.PrettyPrint += this._spaces.Print();
			this._output.PrettyPrint += "}";
		}

		private void statConstr(AST t)
		{
			this._output.PrettyPrint += this._spaces.Print();

			AST currentAST = t.getFirstChild();
			switch (t.Type)
			{
				case QMLTokenTypes.PERCENTILE_CONTR:
					this._output.PrettyPrint += "percentile ";
					this._output.PrettyPrint += currentAST.getText();
					currentAST = currentAST.getNextSibling();
					numOp(currentAST);
					currentAST = currentAST.getNextSibling();
					this._output.PrettyPrint += currentAST.getText();
					break;
				case QMLTokenTypes.FREQUENCY_CONTR:
					this._output.PrettyPrint += "frequency ";
					freqRange(currentAST);
					currentAST = currentAST.getNextSibling();
					numOp(currentAST);
					currentAST = currentAST.getNextSibling();
					this._output.PrettyPrint += currentAST.getText();
					this._output.PrettyPrint += " %";
					break;
				case QMLTokenTypes.MEAN_CONTR:
					this._output.PrettyPrint += "mean";
					numOp(currentAST);
					currentAST = currentAST.getNextSibling();
					this._output.PrettyPrint += currentAST.getText();
					break;
				case QMLTokenTypes.VARIANCE_CONTR:
					this._output.PrettyPrint += "variance";
					numOp(currentAST);
					currentAST = currentAST.getNextSibling();
					this._output.PrettyPrint +=  currentAST.getText();
					break;
			}

			this._output.PrettyPrintNewLine += ";";
		}

		private void freqRange(AST t)
		{
			if (t.Type == QMLTokenTypes.FREQ_RANGE)
			{
				AST currentAST = t.getFirstChild();
				this._output.PrettyPrint += currentAST.getText();
				currentAST = currentAST.getNextSibling();
				valueLiteral(currentAST);
				currentAST = currentAST.getNextSibling();		
				this._output.PrettyPrint += ", ";
				valueLiteral(currentAST);
				currentAST = currentAST.getNextSibling();	
				this._output.PrettyPrint += currentAST.getText();
			}
			else
				this.valueLiteral(t);
		}
		#endregion

		// -------------------- Profile Decl --------------------------
		#region profileDecl

		private void profileDecl(AST t)
		{
			AST currentAST = t.getFirstChild();

			// TO DO
			// this._output.PrettyPrint += this.comment(currentAST);

			this._output.PrettyPrint += currentAST.getText();
			this._output.PrettyPrint += " for ";
			currentAST = currentAST.getNextSibling();

			this._output.PrettyPrint += currentAST.getText();
			this._output.PrettyPrint += " = ";
			currentAST = currentAST.getNextSibling();

			profileExp(currentAST);
		}

		private void profileExp(AST t)
		{
			AST currentAST = t.getFirstChild();

			if (t.Type == QMLTokenTypes.PROFILE_EXP_PROFILE)
				this._output.PrettyPrint += "profile ";
			else
			{
				this._output.PrettyPrint += currentAST.getText();
				currentAST = currentAST.getNextSibling();
				this._output.PrettyPrint += " refined by ";
			}

			this._output.PrettyPrintNewLine += "{";
			this._spaces.Inc();

			while (currentAST != null)
			{
				reqClause(currentAST);
				currentAST = currentAST.getNextSibling();
			}

			this._spaces.Dec();
			this._output.PrettyPrintNewLine += "}";
		}

		private void reqClause(AST t)
		{
			AST currentAST = t.getFirstChild();

			this._output.PrettyPrint += this._spaces.Print();

			if (currentAST.Type == QMLTokenTypes.ENTITY_LIST)
			{
				fromEntityList(currentAST);
				currentAST = currentAST.getNextSibling();
			}

			this._output.PrettyPrint += "require ";
			if (currentAST.Type == QMLTokenTypes.CONTRACT_LIST)
				contractList(currentAST);
			else
				this._output.PrettyPrint += currentAST.getText();

			this._output.PrettyPrintNewLine += ";";
		}

		private void contractList(AST t)
		{
			AST currentAST = t.getFirstChild();

			while (currentAST != null)
			{
				contrExp(currentAST);
				currentAST = currentAST.getNextSibling();
				if (currentAST != null) this._output.PrettyPrint += ", ";
			}
		}

		private void fromEntityList(AST t)
		{
			this._output.PrettyPrint += "from ";
			entityList(t);
			this._output.PrettyPrint += " ";
		}

		private void entityList(AST t)
		{
			AST currentAST = t.getFirstChild();
			while (currentAST != null)
			{
				entity(currentAST);
				currentAST = currentAST.getNextSibling();
				if (currentAST != null) this._output.PrettyPrint += ", ";
			}
		}

		private void entity(AST t)
		{
			AST currentAST = t.getFirstChild();

			switch (t.Type)
			{
				case QMLTokenTypes.ENTITY:
					this._output.PrettyPrint += currentAST.getText();
					break;
				case QMLTokenTypes.ENTITY_PARM:
					this._output.PrettyPrint += currentAST.getText();
					currentAST = currentAST.getNextSibling();
					this._output.PrettyPrint += ".";
					this._output.PrettyPrint += currentAST.getText();
					break;
				case QMLTokenTypes.ENTITY_RESULT_OF:
					this._output.PrettyPrint += "result of ";
					this._output.PrettyPrint += currentAST.getText();
					break;
			}
		}

		#endregion

		private void nameList(AST t)
		{
			AST currentAST = t.getFirstChild();
			while (currentAST != null)
			{
				this._output.PrettyPrint += currentAST.getText();
				currentAST = currentAST.getNextSibling();
				if (currentAST != null) 
					this._output.PrettyPrint += ", ";
			}
		}

		private void numOp(AST t)
		{
			this._output.PrettyPrint += " ";

			switch (t.Type)
			{
				case QMLParser.NUMOP_GTE:
					this._output.PrettyPrint += ">=";
					break;
				case QMLParser.NUMOP_GTHAN:
					this._output.PrettyPrint += ">";
					break;
				case QMLParser.NUMOP_LTHAN:
					this._output.PrettyPrint += "<";
					break;
				case QMLParser.NUMOP_LTE:
					this._output.PrettyPrint += "<=";
					break;
				case QMLParser.NUMOP_EQUAL:
					this._output.PrettyPrint += "==";
					break;
			}

			this._output.PrettyPrint += " ";
		}

		#endregion

	}
}
