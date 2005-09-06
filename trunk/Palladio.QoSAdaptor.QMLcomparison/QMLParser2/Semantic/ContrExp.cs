using System;
using System.Collections;
using System.Collections.Specialized;

namespace QmlParser.Semantic
{
	public class ContrExp
	{
		#region Private Variables

		private DimConstraint _current;
		private ContractTypeDecl _contrTypeDecl;
		private ContrDecl _parentContrDecl;
		private bool _isValid;
		private HybridDictionary _dimConstraints;		// holds the dimensionDecl objects

		#endregion

		#region Constructors

		public ContrExp() : this (null)
		{
		}

		public ContrExp(ContractTypeDecl contrTypeDecl)
		{
			this._contrTypeDecl = contrTypeDecl;
			this._parentContrDecl = null;
			this._current = null;
			this._isValid = true;
			this._dimConstraints = new HybridDictionary();
		}

		#endregion

		#region Public Methods

		public object Insert(string name, DimConstraint dimConstraint)
		{
			if (this._dimConstraints[name] != null)
			{
				this._isValid = false;
				throw new SemanticException("A dimension constraint with name '" + name + "' already exists.");
			}

			this._dimConstraints.Add(name, dimConstraint);
			this._current = dimConstraint;
			return dimConstraint;
		}

		// TO DO: Handling refined by
		public void ValidateCurrentDimConstraint()
		{
			if (!this._contrTypeDecl.IsValid)
				throw new SemanticException("Unable to validate dimension '" + this._current.Name + "' because contract type '" + this._contrTypeDecl.Name + "' is invalid.");

			if (this._contrTypeDecl.DimensionDecls[this._current.Name] == null)
				throw new SemanticException("A dimension type definition with name '" + this._current.Name + "' doesn't exist.");

			// switch between simple and aspectConstr
			if (this._current.GetType().ToString() == "QmlParser.Semantic.SimpleConstr")
			{
				SimpleConstr simpleConstr = (SimpleConstr)this._current;
				DimensionDecl dimensionDecl = (DimensionDecl)this._contrTypeDecl.DimensionDecls[this._current.Name];

				// maybe I should use the type enumeration?
				switch (dimensionDecl.Type)
				{
					case DimensionDecl.DeclarationTypes.NumericType:

						#region Numeric Validation

						if (simpleConstr.ValueLiteralType != DimConstraint.ValueLiteralTypes.Number)
							throw new SemanticException("The domain of the constraint '" + simpleConstr.Name + "' is numeric. Your usage is wrong.");
						break;

						#endregion

					case DimensionDecl.DeclarationTypes.EnumType:

						#region Enum Validation

						if (simpleConstr.ValueLiteralType != DimConstraint.ValueLiteralTypes.LiteralName)
							throw new SemanticException("The domain of the constraint '" + simpleConstr.Name + "' is enum. Your usage is wrong.");
						if (!dimensionDecl.Elements.Contains(simpleConstr.LiteralName))
							throw new SemanticException("The domain of the constraint '" + simpleConstr.Name + "' doesn't contain the value '" + simpleConstr.LiteralName +"'."); 
						break;

						#endregion

					case DimensionDecl.DeclarationTypes.SetType:

						#region Set Validation

						if (simpleConstr.ValueLiteralType != DimConstraint.ValueLiteralTypes.NameList)
							throw new SemanticException("The domain of the constraint '" + simpleConstr.Name + "' is set. Your usage is wrong.");
						foreach (string element in simpleConstr.NameList)
						{
							if (!dimensionDecl.Elements.Contains(element))
								throw new SemanticException("The domain of the constraint '" + simpleConstr.Name + "' doesn't contain the value '" + element +"'."); 
						}
						break;

						#endregion
				}

				#region Common Validation

				if ((dimensionDecl.Order == DimensionDecl.DimensionDeclOrder.Increasing) &&
					((simpleConstr.NumOp == DimConstraint.NumOps.LTE) ||
					(simpleConstr.NumOp == DimConstraint.NumOps.LTHAN)))
					throw new SemanticException("For the increasing domain '" + simpleConstr.Name + "' only the operations ==, >=, > are acceptable.");
						
				if ((dimensionDecl.Order == DimensionDecl.DimensionDeclOrder.Decreasing) &&
					((simpleConstr.NumOp == DimConstraint.NumOps.GTE) ||
					(simpleConstr.NumOp == DimConstraint.NumOps.GTHAN)))
					throw new SemanticException("For the decreasing domain '" + simpleConstr.Name + "' only the operations ==, <=, < are acceptable.");

				if (simpleConstr.Unit[0] != String.Empty)
					if (simpleConstr.Unit[0] != dimensionDecl.Unit[0] ||
						simpleConstr.Unit[1] != dimensionDecl.Unit[1])
					{
						string unit = dimensionDecl.Unit[0];
						if (dimensionDecl.Unit[1] != String.Empty)
							unit += " / " + dimensionDecl.Unit[1];
						throw new SemanticException("For the domain '" + simpleConstr.Name + "' only the following unit is permitted: '" + unit + "'.");
					}

				#endregion
			}
				// aspectConstr
			else
			{
				AspectConstr aspectConstr = (AspectConstr)this._current;
				DimensionDecl dimensionDecl = (DimensionDecl)this._contrTypeDecl.DimensionDecls[this._current.Name];
			
				switch (dimensionDecl.Type)
				{
					case DimensionDecl.DeclarationTypes.NumericType:

						#region Numeric Validation

						int meanCount = 0;
						int varianceCount = 0;
						foreach (StatConstr statConstr in aspectConstr.StatConstraints)
						{
							switch (statConstr.StatType)
							{
								case StatConstr.StatTypes.Percentile:
									//O(n2)
									int percentileCount = 0;
									foreach (StatConstr statConstrInner in aspectConstr.StatConstraints)
									{
										if ((statConstr.Number == statConstrInner.Number) &&
											(statConstr.NumOp == statConstrInner.NumOp) &&
											(statConstr.PercentileNumber == statConstrInner.PercentileNumber) &&
											(statConstr.StatType == StatConstr.StatTypes.Percentile))
											percentileCount++;
									}
									if (percentileCount != 1)
										throw new SemanticException("A percentile could only occur once. Please check the constraint '" + aspectConstr.Name + "'.");
									break;

								case StatConstr.StatTypes.Mean:
									if (meanCount != 0)
										throw new SemanticException("Only one mean constraint is permitted per aspect constraint. Please check the constraint '" + aspectConstr.Name + "'.");
									meanCount = 1;

									if ((dimensionDecl.Order == DimensionDecl.DimensionDeclOrder.Increasing) &&
										((statConstr.NumOp == DimConstraint.NumOps.LTE) ||
										(statConstr.NumOp == DimConstraint.NumOps.LTHAN)))
										throw new SemanticException("For the increasing domain '" + aspectConstr.Name + "' only the operations ==, >=, > are acceptable for a mean constraint.");

									if ((dimensionDecl.Order == DimensionDecl.DimensionDeclOrder.Decreasing) &&
										((statConstr.NumOp == DimConstraint.NumOps.GTE) ||
										(statConstr.NumOp == DimConstraint.NumOps.GTHAN)))
										throw new SemanticException("For the decreasing domain '" + aspectConstr.Name + "' only the operations ==, <=, < are acceptable for a mean constraint.");
									break;

								case StatConstr.StatTypes.Variance:
									if (varianceCount != 0)
										throw new SemanticException("Only one variance constraint is permitted per aspect constraint. Please check the constraint '" + aspectConstr.Name + "'.");
									varianceCount = 1;

									if (statConstr.NumOp == DimConstraint.NumOps.GTE ||
										statConstr.NumOp == DimConstraint.NumOps.GTHAN)
										throw new SemanticException("For the domain '" + aspectConstr.Name + "' only the operations ==, <=, < are acceptable for a variance constraint.");
									break;

								case StatConstr.StatTypes.Frequency:

									if (statConstr.Frequency.ValueLiteralType != DimConstraint.ValueLiteralTypes.Number)
										throw new SemanticException("For the numeric domain '" + aspectConstr.Name + "' only numbers are permitted.");

									if (statConstr.Number < 0 || statConstr.Number > 100)
										throw new SemanticException("For a frequency constraint only a percent number between 0 and 100 is permitted.");

									if (statConstr.Frequency.HasRange)
									{
										if (!(statConstr.Frequency.Number < statConstr.Frequency.SecondNumber))
											throw new SemanticException("The lower bound must be lower than the upper bound. Please check the constraint '" + aspectConstr.Name + "'.");
									}
									
									int frequencyCount = 0;
									foreach (StatConstr statConstrInner in aspectConstr.StatConstraints)
									{
										if ((statConstr.Frequency.Number == statConstrInner.Frequency.Number) &&
											(statConstr.Frequency.SecondNumber == statConstrInner.Frequency.SecondNumber) &&
											(statConstr.NumOp == statConstrInner.NumOp) &&
											(statConstr.Number == statConstrInner.Number) &&
											(statConstr.StatType == StatConstr.StatTypes.Frequency))
											frequencyCount++;
									}
									if (frequencyCount != 1)
										throw new SemanticException("A frequency could only occur once. Please check the constraint '" + aspectConstr.Name + "'.");
									break;
						
							}
						}

						break;

						#endregion

					case DimensionDecl.DeclarationTypes.EnumType:

						#region Enum Validation

						foreach (StatConstr statConstr in aspectConstr.StatConstraints)
						{
							switch (statConstr.StatType)
							{
								case StatConstr.StatTypes.Percentile:
									throw new SemanticException("For the enum domain '" + aspectConstr.Name + "' a percentile constraint is not permitted.");
								case StatConstr.StatTypes.Mean:
									throw new SemanticException("For the enum domain '" + aspectConstr.Name + "' a mean constraint is not permitted.");
								case StatConstr.StatTypes.Variance:
									throw new SemanticException("For the enum domain '" + aspectConstr.Name + "' a variance constraint is not permitted.");
							}
						}

						foreach (StatConstr statConstr in aspectConstr.StatConstraints)
						{
							if (statConstr.Number < 0 || statConstr.Number > 100)
								throw new SemanticException("For a frequency constraint only a percent number between 0 and 100 is permitted.");

							if (statConstr.Frequency.HasRange)
								throw new SemanticException("For the enum domain '" + aspectConstr.Name + "' only a literal name is permitted, no range.");

							if (statConstr.Frequency.ValueLiteralType != DimConstraint.ValueLiteralTypes.LiteralName)
								throw new SemanticException("For the enum domain '" + aspectConstr.Name + "' only a literal name is permitted.");

							if (!dimensionDecl.Elements.Contains(statConstr.Frequency.LiteralName))
								throw new SemanticException("The domain of the constraint '" + aspectConstr.Name + "' doesn't contain the value '" + statConstr.Frequency.LiteralName +"'."); 
						}

						int frequencyCountEnum = 0;
						foreach (StatConstr statConstr in aspectConstr.StatConstraints)
						{
							foreach (StatConstr statConstrInner in aspectConstr.StatConstraints)
							{
								if ((statConstr.Frequency.LiteralName == statConstrInner.Frequency.LiteralName) &&
									(statConstr.NumOp == statConstrInner.NumOp) &&
									(statConstr.Number == statConstrInner.Number) &&
									(statConstr.StatType == StatConstr.StatTypes.Frequency))
									frequencyCountEnum++;
							}
							if (frequencyCountEnum != 1)
								throw new SemanticException("A frequency could only occur once. Please check the constraint '" + aspectConstr.Name + "'.");
							break;
						}
						break;

						#endregion

					case DimensionDecl.DeclarationTypes.SetType:

						#region Set Validation

						foreach (StatConstr statConstr in aspectConstr.StatConstraints)
						{
							switch (statConstr.StatType)
							{
								case StatConstr.StatTypes.Percentile:
									throw new SemanticException("For the set domain '" + aspectConstr.Name + "' a percentile constraint is not permitted.");
								case StatConstr.StatTypes.Mean:
									throw new SemanticException("For the set domain '" + aspectConstr.Name + "' a mean constraint is not permitted.");
								case StatConstr.StatTypes.Variance:
									throw new SemanticException("For the set domain '" + aspectConstr.Name + "' a variance constraint is not permitted.");
							}
						}

						foreach (StatConstr statConstr in aspectConstr.StatConstraints)
						{
							if (statConstr.Number < 0 || statConstr.Number > 100)
								throw new SemanticException("For a frequency constraint only a percent number between 0 and 100 is permitted.");

							if (statConstr.Frequency.HasRange)
								throw new SemanticException("For the set domain '" + aspectConstr.Name + "' only a literal name is permitted, no range.");

							if (statConstr.Frequency.ValueLiteralType != DimConstraint.ValueLiteralTypes.NameList)
								throw new SemanticException("For the set domain '" + aspectConstr.Name + "' only a name list is permitted.");

							foreach (string element in statConstr.Frequency.NameList)
								if (!dimensionDecl.Elements.Contains(element))
									throw new SemanticException("The domain of the constraint '" + aspectConstr.Name + "' doesn't contain the value '" + element +"'."); 
						}
						break;

						#endregion
				}
			}
		}

		public void CopyParentConstrDeclsIfNotExists()
		{
			ArrayList list = new ArrayList();
			foreach (DimConstraint parentConstraint in this._parentContrDecl.ContrExp._dimConstraints)
			{
				if (!this._dimConstraints.Contains(parentConstraint.Name))
					list.Add(parentConstraint);
			}
			foreach (DimConstraint constraint in list)
				this._dimConstraints.Add(constraint.Name, constraint);
		}

		#endregion

		#region Properties

		public DimConstraint Current
		{
			get
			{
				return this._current;
			}
		}

		public ContractTypeDecl ContractType
		{
			get
			{
				return this._contrTypeDecl;
			}
			set
			{
				this._contrTypeDecl = value;
			}
		}

		public ContrDecl ParentContrDecl
		{
			get
			{
				return this._parentContrDecl;
			}
			set
			{
				this._parentContrDecl = value;
			}
		}

		public bool IsValid
		{
			get
			{
				return this._isValid;
			}
		}

		#endregion
	}
}
