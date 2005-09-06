using System;
using System.IO;
using System.Collections;

using QmlParser.Semantic;

using antlr.collections;
using antlr;

namespace QmlParser
{
	public class SemanticTreeWalker
	{

		#region Private Variables

		private SymboleTable _symboleTable;
		private Report _report;
		private string _filename;

		#endregion 

		public SemanticTreeWalker()
		{
			this._filename = "FILENAME TODO";
		}

		public SymboleTable Check(AST t)
		{
			this._symboleTable = new SymboleTable();	
			this._report = new Report();
			declarations(t);
			return this._symboleTable;
		}

		public Report getErrorReport()
		{
			return this._report;
		}

		// only for testing
		public IEnumerator GetErrors()
		{
			return this._report.GetEnumerator();
		}

		// only for testing
		public string GetErrorsDebug()
		{
			string errors = String.Empty;

			IEnumerator ienum = this._report.GetEnumerator();
			while (ienum.MoveNext())
			{
				Error error = (Error)ienum.Current;
				errors += error.Filename + " (" + error.Line + "," + error.Column + "): " + error.Message + "\r\n"; 
			}

			errors += "\r\n";
			errors += "---------------------- Done ----------------------";
			errors += "\r\n\r\n";
			if (this._report.Count != 0)
				errors += "Transformation failed - " + this._report.Count; 
			else
				errors += "Transformation done - " + this._report.Count;
			if (this._report.Count == 1)
				errors += " Error";
			else
				errors += " Errors";

			return errors;
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
				currentAST = currentAST.getNextSibling();
			}
		}

		// -------------------- Contract Type Decl --------------------
		#region contractTypeDecl

		private void conractTypeDecl(AST t)
		{
			ContractTypeDecl contractTypeDecl = null;			
			AST currentAST = t.getFirstChild();

			contractTypeDecl = new ContractTypeDecl(currentAST.getText());
			
			
			// Catch Exception if name already exists
			// error flag couldn't be set
			try
			{
				this._symboleTable.Insert(contractTypeDecl.Name, contractTypeDecl);
			}
			catch(Semantic.SemanticException e)
			{
				this._report.ReportError(this._filename, ((QMLAST)currentAST).Line, ((QMLAST)currentAST).Column, contractTypeDecl.Name.Length, e.Message);
				return;
			}

			currentAST = currentAST.getNextSibling();
			while (currentAST != null)
			{
				dimensionDecl(currentAST);
				currentAST = currentAST.getNextSibling();
			}
		}

		private void dimensionDecl(AST t)
		{
			DimensionDecl dimensionDecl =  null;
			AST currentAST = t.getFirstChild();

			dimensionDecl = new DimensionDecl(currentAST.getText());			
			try
			{
				this._symboleTable.CurrentAsContractTypeDecl.Insert(dimensionDecl.Name, dimensionDecl);
			}
			catch(Semantic.SemanticException e)
			{
				this._report.ReportError(this._filename, ((QMLAST)currentAST).Line, ((QMLAST)currentAST).Column, dimensionDecl.Name.Length, e.Message);
				return;
			}

			currentAST = currentAST.getNextSibling();
			dimensionType(currentAST);
			
			currentAST = currentAST.getNextSibling();
			// check if unit is specified
			if (currentAST != null)
				this._symboleTable.CurrentAsContractTypeDecl.Current.Unit = unit(currentAST);
			
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
			this._symboleTable.CurrentAsContractTypeDecl.Current.Type = DimensionDecl.DeclarationTypes.EnumType;

			if (currentAST.Type == QMLTokenTypes.INCREASING_ORDER_SEM)
			{
				this._symboleTable.CurrentAsContractTypeDecl.Current.Order = DimensionDecl.DimensionDeclOrder.Increasing;
				currentAST = currentAST.getNextSibling();
			}

			if (currentAST.Type == QMLTokenTypes.DECREASING_ORDER_SEM)
			{
				this._symboleTable.CurrentAsContractTypeDecl.Current.Order = DimensionDecl.DimensionDeclOrder.Decreasing;
				currentAST = currentAST.getNextSibling();
			}			

			ArrayList elements = nameList(currentAST); 
			try 
			{
				this._symboleTable.CurrentAsContractTypeDecl.Current.Elements = elements;
			}
			catch(Semantic.SemanticException e)
			{
				int length = -1;
				foreach (string element in elements)
					length += element.Length + 2;
				this._report.ReportError(this._filename, ((QMLAST)currentAST.getFirstChild()).Line, ((QMLAST)currentAST.getFirstChild()).Column, length, e.Message);
				return;
			}

			currentAST = currentAST.getNextSibling();
			// has order
			if (currentAST != null)
			{
				this._symboleTable.CurrentAsContractTypeDecl.Current.Orders = new OrderTable(elements);
				int orderLength = orderDef(currentAST);
				try 
				{
					this._symboleTable.CurrentAsContractTypeDecl.Current.Orders.ResolveTransitiveRelations();
				}
				catch(Semantic.SemanticException e)
				{
					this._report.ReportError(this._filename, ((QMLAST)currentAST.getFirstChild().getFirstChild()).Line, ((QMLAST)currentAST.getFirstChild().getFirstChild()).Column, orderLength, e.Message);
					return;
				}
			}
		}

		private void setDef(AST t)
		{
			AST currentAST = t.getFirstChild();
			this._symboleTable.CurrentAsContractTypeDecl.Current.Type = DimensionDecl.DeclarationTypes.SetType;

			if (currentAST.Type == QMLTokenTypes.INCREASING_ORDER_SEM)
			{
				this._symboleTable.CurrentAsContractTypeDecl.Current.Order = DimensionDecl.DimensionDeclOrder.Increasing;
				currentAST = currentAST.getNextSibling();
			}

			if (currentAST.Type == QMLTokenTypes.DECREASING_ORDER_SEM)
			{
				this._symboleTable.CurrentAsContractTypeDecl.Current.Order = DimensionDecl.DimensionDeclOrder.Decreasing;
				currentAST = currentAST.getNextSibling();
			}		
	
			ArrayList elements = nameList(currentAST); 
			try 
			{
				this._symboleTable.CurrentAsContractTypeDecl.Current.Elements = elements;
			}
			catch(Semantic.SemanticException e)
			{
				int length = -1;
				foreach (string element in elements)
					length += element.Length + 2;
				this._report.ReportError(this._filename, ((QMLAST)currentAST.getFirstChild()).Line, ((QMLAST)currentAST.getFirstChild()).Column, length, e.Message);
				return;
			}

			currentAST = currentAST.getNextSibling();
			// has order
			if (currentAST != null)
			{
				this._symboleTable.CurrentAsContractTypeDecl.Current.Orders = new OrderTable(elements);
				int orderLength = orderDef(currentAST);
				try 
				{
					this._symboleTable.CurrentAsContractTypeDecl.Current.Orders.ResolveTransitiveRelations();
				}
				catch(Semantic.SemanticException e)
				{
					this._report.ReportError(this._filename, ((QMLAST)currentAST.getFirstChild().getFirstChild()).Line, ((QMLAST)currentAST.getFirstChild().getFirstChild()).Column, orderLength, e.Message);
					return;
				}
			}
		}

		private int orderDef(AST t)
		{
			AST currentAST = t.getFirstChild();
			int length = -1;
	
			while (currentAST != null)
			{
				length += oneOrder(currentAST) + 1;
				currentAST = currentAST.getNextSibling();
			}

			return length;
		}

		private int oneOrder(AST t)
		{
			AST currentAST = t.getFirstChild();

			string lesser = currentAST.getText();
			currentAST = currentAST.getNextSibling();
			string greater = currentAST.getText();
			int length = lesser.Length + greater.Length + 4;

			try 
			{
				this._symboleTable.CurrentAsContractTypeDecl.Current.Orders.Add(lesser, greater);
			}
			catch(Semantic.SemanticException e)
			{
				this._report.ReportError(this._filename, ((QMLAST)t.getFirstChild()).Line, ((QMLAST)t.getFirstChild()).Column, length, e.Message);
				return length;
			}

			return length;
		}		

		private void numericDef(AST t)
		{
			AST currentAST = t.getFirstChild();
			this._symboleTable.CurrentAsContractTypeDecl.Current.Type = DimensionDecl.DeclarationTypes.NumericType;

			if (currentAST.Type == QMLTokenTypes.INCREASING_ORDER_SEM)
				this._symboleTable.CurrentAsContractTypeDecl.Current.Order = DimensionDecl.DimensionDeclOrder.Increasing;

			if (currentAST.Type == QMLTokenTypes.DECREASING_ORDER_SEM)
				this._symboleTable.CurrentAsContractTypeDecl.Current.Order = DimensionDecl.DimensionDeclOrder.Decreasing;
		}

		private string[] unit(AST t)
		{
			string[] units = new string[2] {String.Empty, String.Empty};

			AST currentAST = t.getFirstChild();
			units[0] = currentAST.getText();

			currentAST = currentAST.getNextSibling();
			// have second part
			if (currentAST != null)
				units[1] = currentAST.getText();
			return units;
		}



		#endregion

		// -------------------- Contract Decl -------------------------
		#region contractDecl

		private void contractDecl(AST t)
		{
			ContrDecl contrDecl = null;
			AST currentAST = t.getFirstChild();

			contrDecl = new ContrDecl(currentAST.getText());
			
			// Catch Exception if name already exists
			// error flag couldn't be set
			try
			{
				this._symboleTable.Insert(contrDecl.Name, contrDecl);
			}
			catch(Semantic.SemanticException e)
			{
				this._report.ReportError(this._filename, ((QMLAST)currentAST).Line, ((QMLAST)currentAST).Column+1, contrDecl.Name.Length, e.Message);
				return;
			}
			
			currentAST = currentAST.getNextSibling();
			contrExp(currentAST);
		}

		private void contrExp(AST t)
		{
			AST currentAST = t.getFirstChild();
			string name = currentAST.getText(); 
			ContrExp contrExp = new ContrExp();
			
			// contract
			if (t.Type  == QMLTokenTypes.CONTRACT_EXP_CONTRACT)
			{
				// Catch Exception if name already exists
				// error flag couldn't be set
				ContractTypeDecl contractTypeDecl = null;
				try
				{
					contractTypeDecl = (ContractTypeDecl)this._symboleTable.Find(name, Type.GetType("QmlParser.Semantic.ContractTypeDecl"));
				}
				catch(Semantic.SemanticException e)
				{
					this._report.ReportError(this._filename, ((QMLAST)currentAST).Line, ((QMLAST)currentAST).Column, name.Length, e.Message);
					return;
				}
				contrExp.ContractType = contractTypeDecl;
			}
			// refined by
			else
			{
				// Catch Exception if name already exists
				// error flag couldn't be set
				ContrDecl contrDecl = null;
				try
				{
					contrDecl = (ContrDecl)this._symboleTable.Find(name, Type.GetType("QmlParser.Semantic.ContrDecl"));
				}
				catch(Semantic.SemanticException e)
				{
					this._report.ReportError(this._filename, ((QMLAST)currentAST).Line, ((QMLAST)currentAST).Column, name.Length, e.Message);
					return;
				}
				contrExp.ContractType = contrDecl.ContrExp.ContractType;
				contrExp.ParentContrDecl = contrDecl;
			}
			currentAST = currentAST.getNextSibling();

			if (this._symboleTable.CurrentAsContrDecl != null)
				this._symboleTable.CurrentAsContrDecl.ContrExp = contrExp;
			else
			{
				try
				{
					this._symboleTable.CurrentProfileDecl.InsertContrExp(name, contrExp);
				}
				catch(Semantic.SemanticException e)
				{
					this._report.ReportError(this._filename, ((QMLAST)t.getFirstChild()).Line, ((QMLAST)t.getFirstChild()).Column, name.Length, e.Message);
					return;
				}				
			}

			// handle dimConstraints
			while (currentAST != null)
			{
				dimContraint(currentAST);
				currentAST = currentAST.getNextSibling();
			}

			// refined by validation

			if (t.Type == QMLTokenTypes.CONTRACT_EXP_REFINED_BY)
				if (this._symboleTable.CurrentAsContrDecl != null)
					this._symboleTable.CurrentAsContrDecl.ContrExp.CopyParentConstrDeclsIfNotExists();
				else
					this._symboleTable.CurrentProfileDecl.CurrentReqClause.CurrentContrExp.CopyParentConstrDeclsIfNotExists();
		}

		private void dimContraint(AST t)
		{
			if (t.Type == QMLTokenTypes.SIMPLE_CONSTR)
				simpleConstr(t);
			else if(t.Type == QMLTokenTypes.ASPECT_CONSTR)
				aspectConstr(t);
		}

		private void simpleConstr(AST t)
		{
			SimpleConstr simpleConstr = null;
			AST currentAST = t.getFirstChild();

			simpleConstr = new SimpleConstr(currentAST.getText());

			try
			{
				if (this._symboleTable.CurrentAsContrDecl != null)
					this._symboleTable.CurrentAsContrDecl.ContrExp.Insert(simpleConstr.Name, simpleConstr);
				else
					this._symboleTable.CurrentProfileDecl.CurrentReqClause.CurrentContrExp.Insert(simpleConstr.Name, simpleConstr);
			}
			catch(Semantic.SemanticException e)
			{
				this._report.ReportError(this._filename, ((QMLAST)currentAST).Line, ((QMLAST)currentAST).Column, simpleConstr.Name.Length, e.Message);
				return;
			}
			
			currentAST = currentAST.getNextSibling();

			simpleConstr.NumOp = numOp(currentAST);
			currentAST = currentAST.getNextSibling();

			try
			{
				object obj = valueLiteral(currentAST);
				switch (obj.GetType().ToString())
				{
					case "System.Double":
						simpleConstr.ValueLiteralType = DimConstraint.ValueLiteralTypes.Number;
						simpleConstr.Number = (double)obj;
						break;
					case "System.String":
						simpleConstr.ValueLiteralType = DimConstraint.ValueLiteralTypes.LiteralName;
						simpleConstr.LiteralName = (string)obj;
						break;
					case "System.Collections.ArrayList":
						simpleConstr.ValueLiteralType = DimConstraint.ValueLiteralTypes.NameList;
						simpleConstr.NameList = (ArrayList)obj;
						break;
				}

				currentAST = currentAST.getNextSibling();

				// has unit
				if (currentAST != null)
					simpleConstr.Unit = this.unit(currentAST);

				if (this._symboleTable.CurrentAsContrDecl != null)
					this._symboleTable.CurrentAsContrDecl.ContrExp.ValidateCurrentDimConstraint();
				else
					this._symboleTable.CurrentProfileDecl.CurrentReqClause.CurrentContrExp.ValidateCurrentDimConstraint();
			}
			catch(Semantic.SemanticException e)
			{
				this._report.ReportError(this._filename, ((QMLAST)t.getFirstChild()).Line, ((QMLAST)t.getFirstChild()).Column, simpleConstr.Name.Length, e.Message);
				return;
			}
		}

		private object valueLiteral(AST t)
		{
			if (t.Type == QMLTokenTypes.NUMBER)
				return double.Parse(t.getText());
			else if(t.Type == QMLTokenTypes.NAME)
				return (string)t.getText();
			else
				return nameList(t);
		}

		private void aspectConstr(AST t)
		{
			AspectConstr aspectConstr = null;
			AST currentAST = t.getFirstChild();

			aspectConstr = new AspectConstr(currentAST.getText());

			try
			{
				if (this._symboleTable.CurrentAsContrDecl != null)
					this._symboleTable.CurrentAsContrDecl.ContrExp.Insert(aspectConstr.Name, aspectConstr);
				else
					this._symboleTable.CurrentProfileDecl.CurrentReqClause.CurrentContrExp.Insert(aspectConstr.Name, aspectConstr);
			}
			catch(Semantic.SemanticException e)
			{
				this._report.ReportError(this._filename, ((QMLAST)currentAST).Line, ((QMLAST)currentAST).Column, aspectConstr.Name.Length, e.Message);
				return;
			}

			currentAST = currentAST.getNextSibling();

			try
			{

				while (currentAST != null)
				{
					statConstr(currentAST);
					currentAST = currentAST.getNextSibling();
				}

				if (this._symboleTable.CurrentAsContrDecl != null)
					this._symboleTable.CurrentAsContrDecl.ContrExp.ValidateCurrentDimConstraint();
				else
					this._symboleTable.CurrentProfileDecl.CurrentReqClause.CurrentContrExp.ValidateCurrentDimConstraint();
			}
			catch(Semantic.SemanticException e)
			{
				this._report.ReportError(this._filename, ((QMLAST)t.getFirstChild()).Line, ((QMLAST)t.getFirstChild()).Column, aspectConstr.Name.Length, e.Message);
				return;
			}
		}

		private void statConstr(AST t)
		{
			StatConstr statConstr = new StatConstr();
			AST currentAST = t.getFirstChild();

			if (t.Type != QMLTokenTypes.FREQUENCY_CONTR)
			{
				switch(t.Type)
				{
					case QMLTokenTypes.PERCENTILE_CONTR:
						statConstr = new StatConstr(StatConstr.StatTypes.Percentile);
						statConstr.PercentileNumber = double.Parse(currentAST.getText());
						currentAST = currentAST.getNextSibling();
						break;
					case QMLTokenTypes.MEAN_CONTR:
						statConstr = new StatConstr(StatConstr.StatTypes.Mean);
						break;
					case QMLTokenTypes.VARIANCE_CONTR:
						statConstr = new StatConstr(StatConstr.StatTypes.Variance);
						break;
				}
				statConstr.NumOp = numOp(currentAST);
				currentAST = currentAST.getNextSibling();
				statConstr.Number = double.Parse(currentAST.getText());
			}
			else
			{
				statConstr = new StatConstr(StatConstr.StatTypes.Frequency);
				statConstr.Frequency = freqRange(currentAST);
				currentAST = currentAST.getNextSibling();
				statConstr.NumOp = numOp(currentAST);
				currentAST = currentAST.getNextSibling();
				statConstr.Number = double.Parse(currentAST.getText());
			}

			if (this._symboleTable.CurrentAsContrDecl != null)
				((AspectConstr)this._symboleTable.CurrentAsContrDecl.ContrExp.Current).StatConstraints.Add(statConstr);
			else
				((AspectConstr)this._symboleTable.CurrentProfileDecl.CurrentReqClause.CurrentContrExp.Current).StatConstraints.Add(statConstr);
		}

		private Frequency freqRange(AST t)
		{
			Frequency frequency = new Frequency();
			
			if (t.Type == QMLParser.FREQ_RANGE)
			{
				AST currentAST = t.getFirstChild();
				frequency.IncludeLowerBound = (currentAST.Type == QMLTokenTypes.INCLUDE_BOUND);
				currentAST = currentAST.getNextSibling();
				frequency.ValueLiteralType = DimConstraint.ValueLiteralTypes.Number;
				frequency.Number = double.Parse(currentAST.getText());
				currentAST = currentAST.getNextSibling();	
				frequency.ValueLiteralType = DimConstraint.ValueLiteralTypes.Number;
				frequency.SecondNumber = double.Parse(currentAST.getText());
				currentAST = currentAST.getNextSibling();	
				frequency.IncludeLowerBound = (currentAST.Type == QMLTokenTypes.INCLUDE_BOUND);
			}
			else
			{
				#region Switch Lower
				object obj = valueLiteral(t);
				switch (obj.GetType().ToString())
				{
					case "System.Double":
						frequency.ValueLiteralType = DimConstraint.ValueLiteralTypes.Number;
						frequency.Number = (double)obj;
						break;
					case "System.String":
						frequency.ValueLiteralType = DimConstraint.ValueLiteralTypes.LiteralName;
						frequency.LiteralName = (string)obj;
						break;
					case "System.Collections.ArrayList":
						frequency.ValueLiteralType = DimConstraint.ValueLiteralTypes.NameList;
						frequency.NameList = (ArrayList)obj;
						break;
				}
				#endregion
			}

			return frequency;
		}

		#endregion

		// -------------------- Profile Decl --------------------------
		#region profileDecl

		private void profileDecl(AST t)
		{
			ProfileDecl profileDecl;
			AST currentAST = t.getFirstChild();

			profileDecl = new ProfileDecl(currentAST.getText(), this._symboleTable);
			try
			{
				this._symboleTable.Insert(profileDecl.Name, profileDecl);
			}
			catch(Semantic.SemanticException e)
			{
				this._report.ReportError(this._filename, ((QMLAST)currentAST).Line, ((QMLAST)currentAST).Column+1, profileDecl.Name.Length, e.Message);
				return;
			}
			currentAST = currentAST.getNextSibling();
			this._symboleTable.CurrentProfileDecl.InterfaceName = currentAST.getText();
			currentAST = currentAST.getNextSibling();

			profileExp(currentAST);
		}
		

		private void profileExp(AST t)
		{
			AST currentAST = t.getFirstChild();

			if (t.Type == QMLTokenTypes.PROFILE_EXP_REFINED_BY)
			{

				ProfileDecl profileDecl = null;
				string name = currentAST.getText();
				try
				{
					profileDecl = (ProfileDecl)this._symboleTable.Find(name, Type.GetType("QmlParser.Semantic.ProfileDecl"));
				}
				catch(Semantic.SemanticException e)
				{
					this._report.ReportError(this._filename, ((QMLAST)currentAST).Line, ((QMLAST)currentAST).Column, name.Length, e.Message);
					return;
				}
				this._symboleTable.CurrentProfileDecl.ParentProfileDecl = profileDecl;
				currentAST = currentAST.getNextSibling();
			}

			while (currentAST != null)
			{
				reqClause(currentAST);
				currentAST = currentAST.getNextSibling();
			}

			// profile validation refined by
		}

		private int calcLengthOfArrayListElements(ArrayList list)
		{
			int length = 0;
			foreach (string entry in list)
			{
				length += entry.Length;
				if (entry.StartsWith("resultof"))
					length += 2;
				if (entry.IndexOf(".", 0, entry.Length-1) != -1)
					length += 1;
				length += 2;
			}
			length -= 2;

			return length;
		}

		private void reqClause(AST t)
		{
			ArrayList list = null;
			AST currentAST = t.getFirstChild();
			ReqClause reqClause = new ReqClause(this._symboleTable);
			this._symboleTable.CurrentProfileDecl.InsertReqClause(reqClause);

			if (currentAST.Type == QMLTokenTypes.ENTITY_LIST)
			{
				list = fromEntityList(currentAST);
				currentAST = currentAST.getNextSibling();

				Hashtable ht = new Hashtable();
				try
				{
					foreach (string element in list)
						ht.Add(element, null);
				}
				catch
				{
					int length = calcLengthOfArrayListElements(list);
					this._report.ReportError(this._filename, ((QMLAST)t.getFirstChild().getFirstChild().getFirstChild()).Line, ((QMLAST)t.getFirstChild().getFirstChild().getFirstChild()).Column, length, "The same entity is only permitted once. Please check profile '" + this._symboleTable.CurrentProfileDecl.Name + "'.");
					return;
				}
			}

			if (currentAST.Type == QMLTokenTypes.CONTRACT_LIST)
			{				
				contractList(currentAST, list);
			}
			else
			{
				if (list != null)
				{
					int length = calcLengthOfArrayListElements(list);
					this._report.ReportError(this._filename, ((QMLAST)t.getFirstChild().getFirstChild().getFirstChild()).Line, ((QMLAST)t.getFirstChild().getFirstChild().getFirstChild()).Column, length, "A contract for operations must refine the default contract. Please check profile '" + this._symboleTable.CurrentProfileDecl.Name + "'.");
					return;
				}
				string contractName = currentAST.getText();
				try
				{
					this._symboleTable.CurrentProfileDecl.InsertInterfaceContract(contractName);
				}
				catch(Semantic.SemanticException e)
				{
					this._report.ReportError(this._filename, ((QMLAST)currentAST).Line, ((QMLAST)currentAST).Column, contractName.Length, e.Message);
					return;
				}
			}
		}

		private void contractList(AST t, ArrayList list)
		{
			AST currentAST = t.getFirstChild();

			if (list == null)
			{
				this._report.ReportError(this._filename, ((QMLAST)currentAST.getFirstChild()).Line, ((QMLAST)currentAST.getFirstChild()).Column, currentAST.getFirstChild().getText().Length, "A contract, which refines the default contract must have at least one operation. Please check profile '" + this._symboleTable.CurrentProfileDecl.Name + "'.");
				return;
			}

			while (currentAST != null)
			{
				contrExp(currentAST);
				currentAST = currentAST.getNextSibling();
			}
		}

		private ArrayList fromEntityList(AST t)
		{
			return entityList(t);
		}

		private ArrayList entityList(AST t)
		{
			ArrayList list = new ArrayList();
			AST currentAST = t.getFirstChild();
			while (currentAST != null)
			{
				string result = entity(currentAST);
				list.Add(result);
				currentAST = currentAST.getNextSibling();
			}
			return list;
		}

		private string entity(AST t)
		{
			string result = String.Empty;
			AST currentAST = t.getFirstChild();

			switch (t.Type)
			{
				case QMLTokenTypes.ENTITY:
					result = currentAST.getText();
					break;
				case QMLTokenTypes.ENTITY_PARM:
					result = currentAST.getText();
					currentAST = currentAST.getNextSibling();
					result += ".";
					result += currentAST.getText();
					break;
				case QMLTokenTypes.ENTITY_RESULT_OF:
					result = "resultof";
					result += currentAST.getText();
					break;
			}

			return result;
		}

		#endregion


		private ArrayList nameList(AST t)
		{
			AST currentAST = t.getFirstChild();
			ArrayList names = new ArrayList();

			while (currentAST != null)
			{
				names.Add(currentAST.getText());
				currentAST = currentAST.getNextSibling();
			}
			return names;
		}

		private DimConstraint.NumOps numOp(AST t)
		{
			switch (t.Type)
			{
				case QMLParser.NUMOP_GTE:
					return DimConstraint.NumOps.GTE;
				case QMLParser.NUMOP_GTHAN:
					return DimConstraint.NumOps.GTHAN;
				case QMLParser.NUMOP_LTHAN:
					return DimConstraint.NumOps.LTHAN;
				case QMLParser.NUMOP_LTE:
					return DimConstraint.NumOps.LTE;
				case QMLParser.NUMOP_EQUAL:
					return DimConstraint.NumOps.EUQAL;
			}
			return DimConstraint.NumOps.Unknown;
		}
	}
}
