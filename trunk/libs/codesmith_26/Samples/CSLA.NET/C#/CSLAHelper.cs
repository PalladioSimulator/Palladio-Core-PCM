using System;
using System.Data;
using System.ComponentModel;
using CodeSmith.Engine;
using SchemaExplorer;
using Microsoft.CSharp;

/// <summary>
/// Summary description for CSLAHelper.
/// </summary>
public class CSLAHelper : CodeTemplate
{
	#region Enumerations
	public enum TemplateEnum
	{
		EditableRoot = 0,
		EditableRootCollection = 1,
		EditableSwitchable = 2,
		EditableChild = 3,
		EditableChildCollection = 4,
		NameValueList = 5,
		ReadOnly = 6,
		ReadOnlyCollection = 7
	}

	public enum CollectionTemplateEnum
	{
		None = 0,
		EditableRootCollection = 1,
		EditableChildCollection = 2,
		ReadOnlyCollection = 3
	}
		
	public enum AccessibilityEnum
	{
		Public = 0,
		Protected = 1,
		Internal = 2,
		ProtectedInternal = 3,
		Private = 4
	}


	public enum TransactionEnum
	{
		None = 0, ADO = 1, EnterpriseServices = 2
	}

	#endregion

	//This variable is used to control the indent of the 
	//formatted code that is output in conjunction with
	//the Level method
	const int INDENT_LEVEL_SPACES = 3;

	#region private level variable declaration

	//Base Class options
	private bool _setAsBaseClass = false;
	private string _baseClassExt = "Base";

	//Common Required Template Options
	private TemplateEnum _objectTemplate = TemplateEnum.EditableRoot;
	private string _classNamespace = "";
	private string _objectName;
	private string _collectionName = "";
	private TableSchema _rootTable;

	//Class Level Options
	private bool _useTabIndent = true;
	private string _flcPrefix = "";
	private string _memberPrefix = "_"; 
	private AccessibilityEnum _accessibility = AccessibilityEnum.Public;
	private bool _serializable = true;
	private bool _mustBeInherited = false;
	private TransactionEnum _transactionType = TransactionEnum.ADO;

	//Common Stored Procedure Options
	private string _generalSPPrefix = "";
	private string _insertPrefix = "Add";
	private string _updatePrefix = "Update";
	private string _deletePrefix = "Delete";
	private string _selectPrefix = "Get";
	#endregion //private level variable declaration

	#region Base Class Options
	[CodeTemplateProperty(CodeTemplatePropertyOption.Required),
	Category("5. Base Class Options"),
	Description("Required - Set this as the base object class.")]
	public bool SetAsBaseClass 
	{
		get {return _setAsBaseClass;} 
		set {_setAsBaseClass = value;}
	}
																																														
	[CodeTemplateProperty(CodeTemplatePropertyOption.Optional),
	Category("5. Base Class Options"), 
	Description("Optional - The Extension that the class will use when generating the 'Base' Class. Defaults to 'Base'.")]
	public string BaseClassExt 
	{
		get {return _baseClassExt;}
		set {_baseClassExt = value;}
	}
	#endregion

	#region Common Required Template Options
	[CodeTemplateProperty(CodeTemplatePropertyOption.Optional),
	Category("1. Common Required Template Options"), 
	Description("Optional - The namespace that the generated Classes will be a member of.")]
	public string ClassNamespace 
	{
		get {return _classNamespace;}
		set {_classNamespace = value;}
	}
	
	[CodeTemplateProperty(CodeTemplatePropertyOption.Required),    
	Category("1. Common Required Template Options"), 
	Description("Required - The Name of the Business Object Class to Generate.")]
	public string ObjectName 
	{
		get { return _objectName; }
		set {_objectName = value;}
	}

	[CodeTemplateProperty(CodeTemplatePropertyOption.Required), 
	Category("1. Common Required Template Options"), 
	Description("Required - The Root Table that the object is based on.")]
	public TableSchema RootTable 
	{
		get {return _rootTable;}
		set {_rootTable = value;}
	}

	
	//this is hidden property, only used in GUIRender when create collection object
	//other templates will use ObjectName for both object and collection object
	[Browsable(false)]
	public string HiddenCollectionName 
	{
		get {return _collectionName;}
		set {_collectionName = value;}
	}

	#endregion

	#region Class Level Options
	[CodeTemplateProperty(CodeTemplatePropertyOption.Optional), 
	Category("6. Class Level Options"), 
	Description("Optional - Use tab character indentation rather than spaces.")]
	public bool UseTabIndent 
	{
		get {return _useTabIndent;}
		set {_useTabIndent = value;}
	}

	[CodeTemplateProperty(CodeTemplatePropertyOption.Optional),
	Category("6. Class Level Options"), 
	Description("Optional - Generate the variables and properties for field level concurrency tracking. These will be generated into the custom programming class of the object using this Prefix."),
	Browsable(false)]
	public string FLCPrefix 
	{
		get {return _flcPrefix;}
		set {_flcPrefix = value;}
	}

	[CodeTemplateProperty(CodeTemplatePropertyOption.Optional), 
	Category("6. Class Level Options"), 
	Description("Optional - The prefix for the member variables.")]
	public string MemberPrefix 
	{
		get {return _memberPrefix;}
		set {_memberPrefix = value;}
	}

	[CodeTemplateProperty(CodeTemplatePropertyOption.Required),
	Category("6. Class Level Options"), 
	Description("Required - The accessibility of the Class to be generated.")]
	public AccessibilityEnum Accessibility 
	{
		get {return _accessibility;}
		set {_accessibility = value;}
	}

	[CodeTemplateProperty(CodeTemplatePropertyOption.Required),
	Category("6. Class Level Options"), 
	Description("Required - Should this Class have a Serialized Attiribute?")]
	public bool Serializable 
	{
		get {return _serializable;}
		set {_serializable = value;}
	}

	[CodeTemplateProperty(CodeTemplatePropertyOption.Required),
	Category("6. Class Level Options"), 
	Description("Required - Should this Class have a Must Inherit Directive?")]
	public bool MustBeInherited 
	{
		get {return _mustBeInherited;}
		set {_mustBeInherited = value;}
	}

	[CodeTemplateProperty(CodeTemplatePropertyOption.Required),
	Category("6. Class Level Options"), 
	Description("Required - What type of Transaction should this Business Object use?")]
	public TransactionEnum TransactionType 
	{
		get {return _transactionType;}
		set {_transactionType = value;}
	}

	#endregion

	#region Stored Procedure Options
	[CodeTemplateProperty(CodeTemplatePropertyOption.Optional),
	Category("7. Stored Procedure Options"), 
	Description("Optional - The GLOBAL prefix that identifies our own stored procedures.")]
	public string GeneralSPPrefix 
	{
		get {return _generalSPPrefix;}
		set {_generalSPPrefix = value;}
	}

	[CodeTemplateProperty(CodeTemplatePropertyOption.Optional),
	Category("7. Stored Procedure Options"), 
	Description("Optional - Prefix to use for all generated INSERT stored procedures.")]
	public string InsertPrefix 
	{
		get {return _insertPrefix;}
		set {_insertPrefix = value;}
	}

	[CodeTemplateProperty(CodeTemplatePropertyOption.Optional),
	Category("7. Stored Procedure Options"), 
	Description("Optional - Prefix to use for all generated UPDATE stored procedures.")]
	public string UpdatePrefix 
	{
		get {return _updatePrefix;}
		set {_updatePrefix = value;}
	}

	[CodeTemplateProperty(CodeTemplatePropertyOption.Optional),
	Category("7. Stored Procedure Options"), 
	Description("Optional - Prefix to use for all generated DELETE stored procedures.")]
	public string DeletePrefix 
	{
		get {return _deletePrefix;}
		set {_deletePrefix = value;}
	}

	[CodeTemplateProperty(CodeTemplatePropertyOption.Optional),
	Category("7. Stored Procedure Options"), 
	Description("Optional - Prefix to use for all generated SELECT stored procedures.")]
	public string SelectPrefix 
	{
		get {return _selectPrefix;}
		set {_selectPrefix = value;}
	}
	#endregion

	#region Generic Read Only Hidden Properties/Methods for code generation
	[Browsable(false)]
	public string GetCustomClassName 
	{
		//The Custom Class Name for the Custom collection class
		//Basically, drop the "Base" from the base object class name
		get 
		{
			if(_objectName.EndsWith(BaseClassExt))
				return _objectName.Substring(0,_objectName.Length-BaseClassExt.Length);
			else return _objectName;
		}
	}

	[Browsable(false)]
	public string GetCustomCollectionName 
	{
		//The Custom Class Name for the Custom collection class
		//Basically, drop the "Base" from the base object class name
		get 
		{
			if(_collectionName.EndsWith(BaseClassExt))
				return _collectionName.Substring(0, _collectionName.Length-BaseClassExt.Length);
			else return _collectionName;
		}
	}

	[Browsable(false)]
	public string GetBaseClassName 
	{
		get 
		{
			if(_setAsBaseClass) 
			{
				//make sure object name ends with Base
				if(!_objectName.EndsWith(BaseClassExt))
					return _objectName + BaseClassExt;
			}
			else 
			{
				if(_objectName.EndsWith(BaseClassExt))
					return _objectName.Substring(0,_objectName.Length-BaseClassExt.Length);
			}
			return _objectName;
		}
	}

	[Browsable(false)]
	public string GetBaseCollectionName 
	{
		get 
		{
			if(_setAsBaseClass) 
			{
				//make sure object name ends with Base
				if(!_collectionName.EndsWith(BaseClassExt))
					return _collectionName + BaseClassExt;
			}
			else 
			{
				if(_collectionName.EndsWith(BaseClassExt))
					return _collectionName.Substring(0,_collectionName.Length-BaseClassExt.Length);
			}
			return _collectionName;
		}
	}

	[Browsable(false)]
	public bool IsAdoTransaction 
	{
		get 
		{
			return TransactionType == TransactionEnum.ADO;
		}
	}
	#endregion

	public string ConstructorDeclaration() 
	{
		//Returns the correct declaration of the variables even if
		if(_setAsBaseClass || _mustBeInherited)
			return "protected";
		else return "private";
	}

	public string Level(int level, bool newLine) 
	{
		//Provides formatting for the outputted code
		//The INDENT_LEVEL_SPACES defines how many spaces 
		//  are in a level and is declared at the top of the class
		string str = newLine? "\r\n": "";
		
		if(_useTabIndent)
			str += new string('\t',level);
		else 
			str += new string(' ',level * INDENT_LEVEL_SPACES);

		return str;
		
	}

	public string GetOverrideable()
	{
		if(_setAsBaseClass || _mustBeInherited)
			return "virtual ";
		else return "";
	}
	public string GetMemberVariableScope() 
	{
		//Returns the correct declaration of the variables even if
		if(_setAsBaseClass || _mustBeInherited)
			return "protected";
		else return "private";
	}

	public string GetPropertyDeclarations(ColumnSchema column, bool readOnly, int nLevel, string sFLCPrefix) 
	{
		return GetPropertyDeclarations(column, readOnly, nLevel, sFLCPrefix, false);
	}
	public string GetPropertyDeclarations(ColumnSchema column, bool readOnly, int nLevel, string sFLCPrefix, bool isStructure) 
	{
		string propertyStatement = "";
		bool isDateType = GetCSVariableType(column) == "SmartDate";
		string txt = "";

		//Set the text variable for the Smartdate.
		if(isDateType) txt = ".Text";

		//Override the default bReadOnly As specified by programmer - No Set for PKs or TimeStamps
		propertyStatement = Level(nLevel,false);
		propertyStatement += "public " + GetOverrideable() + GetPropertyVariableType(column) + " " + sFLCPrefix + GetPropertyName(column) + " ";
		propertyStatement += Level(nLevel++,true) + "{";
		//Get Statement Definition
		propertyStatement += Level(nLevel,true) + "get { return " + GetMemberVariableName(column, sFLCPrefix) + txt + "; } ";

		if(isStructure)
			propertyStatement += Level(nLevel,true) + "set { " + GetMemberVariableName(column, sFLCPrefix) + txt + " = value; } ";
		else	
			if(!(readOnly || (column.NativeType == "timestamp"))) 
		{
			//Set Statement Definition
			propertyStatement += Level(nLevel,true) + "set ";
			propertyStatement += Level(nLevel++,true) + "{";
			propertyStatement += Level(nLevel,true) + "if(value != " + GetMemberVariableName(column, sFLCPrefix) + txt + ") ";
			propertyStatement += Level(nLevel++,true) + "{";
			propertyStatement += Level(nLevel,true) + GetMemberVariableName(column, sFLCPrefix) + txt + " = value; ";
			propertyStatement += Level(nLevel,true) + "CheckRules(\"" + GetPropertyName(column) + "\");";
			propertyStatement += Level(nLevel,true) + "MarkDirty();";
			propertyStatement += Level(--nLevel,true) + "}";
			propertyStatement += Level(--nLevel,true) + "}";
		}
		propertyStatement += Level(--nLevel,true) + "}";

		return propertyStatement;
	}

	public string GetPropertyName(ColumnSchema column) 
	{
		string propertyName = column.Name;

		if(propertyName == column.Table.Name + "Name") return "Name";
		if(propertyName == column.Table.Name + "Description") return "Description";

		if(propertyName.EndsWith("TypeCode"))
			propertyName = propertyName.Substring(0,propertyName.Length-4);

		return propertyName;
	}

	public bool IsIdentityColumn(ColumnSchema column)
	{
		return (bool)column.ExtendedProperties["CS_IsIdentity"].Value;
	} 

	public string GetCamelCaseName(string val)
	{
		if(val.Length<=2) return val.ToLower();
		return val.Substring(0, 1).ToLower() + val.Substring(1);
	}

	public string GetMemberVariableName(ColumnSchema column, string sFLCPrefix)
	{
		string propertyName = GetPropertyName(column);
		string memberVariableName = MemberPrefix + sFLCPrefix + GetCamelCaseName(propertyName);

		return memberVariableName;
	}

	public string GetMemberVariableDefaultValue(ColumnSchema column) 
	{
		switch (column.DataType)
		{
			case DbType.Guid:
				return "Guid.NewGuid()";
			case DbType.AnsiString:
			case DbType.AnsiStringFixedLength:
			case DbType.String:
			case DbType.StringFixedLength:
				return "\"\"";
			case DbType.Boolean:
				return "false";
			case DbType.Binary:
				return "";
			case DbType.Date:
			case DbType.DateTime: 
			{
				if(column.AllowDBNull) 
				{
					string colName = column.Name.ToLower();
					if(colName.IndexOf("begin")>=0) return "new SmartDate(false)";
					if(colName.IndexOf("active")>=0) return "new SmartDate(false)";
					if(colName.IndexOf("start")>=0) return "new SmartDate(false)";
					if(colName.IndexOf("from")>=0) return "new SmartDate(false)";
					return "new SmartDate(true)";
				}
				return "new SmartDate(DateTime.Now, true)";
			}
			default:
				return "0";
		}
	}

	public string GetMemberVariableDeclarationStatement(ColumnSchema column, string sFLCPrefix) 
	{
		return GetMemberVariableDeclarationStatement(column, sFLCPrefix, false);
	}
	public string GetMemberVariableDeclarationStatement(ColumnSchema column, string sFLCPrefix, bool isStructure) 
	{
		string defaultValue = isStructure? "": GetMemberVariableDefaultValue(column);
		string statement = GetMemberVariableScope() + " " + GetCSVariableType(column) + " " +
			GetMemberVariableName(column, sFLCPrefix);

		if(defaultValue.Length>0)
			statement += " = " + defaultValue;

		return statement + "; ";

	}

	public string GetPrimaryKeys(ColumnSchemaCollection primaryKeys, string access,
		int nLevel, string sFLCPrefix) 
	{
		return GetPrimaryKeys(primaryKeys, access, nLevel, sFLCPrefix, false);
	}
	
	public string GetPrimaryKeys(ColumnSchemaCollection primaryKeys, string access,
		int nLevel, string sFLCPrefix, bool isStructure) 
	{
		string pks = "";
		string defaultValue;
		string variableName;
		bool isProperty = access == "public";
		
		foreach(ColumnSchema col in primaryKeys) 
		{
			defaultValue = isStructure? "": GetMemberVariableDefaultValue(col);
			variableName = isProperty? GetPropertyName(col): GetMemberVariableName(col,sFLCPrefix);

			pks += Level(nLevel,true) + access + " " + GetCSVariableType(col) + " " + variableName;
			if(defaultValue.Length>0)
				pks += " = " + defaultValue;
			pks += ";\t\t//**PK";
		}
		return pks;
	}

	public string GetBrokenRules(ColumnSchema column, int nLevel)
	{
		string var = GetMemberVariableName(column, "");
		string varType = GetCSVariableType(column);
		string propertyName = GetPropertyName(column);
		string rule = "";
		string brokenRules = "";

		//required field
		if(!column.AllowDBNull) 
		{
			switch(varType)
			{
				case "string":
					rule = var + ".Trim().Length == 0";
					break;
				case "short":
				case "int":
				case "long":
				case "decimal":
				case "ushort":
				case "uint":
				case "ulong":
					rule = var + " == 0";
					break;
				case "SmartDate":
					rule = "!" + var + ".IsEmpty";
					break;
			}
			if(rule.Length>0) 
				brokenRules += Level(nLevel,true) + string.Format("BrokenRules.Assert(\"{0}Required\",\"{0} is required.\",\"{0}\",{1});",propertyName, rule);
		}

		//string length too long
		if(varType=="string")
		{
			rule = var + ".Trim().Length > " + column.Size.ToString();
			brokenRules += Level(nLevel,true) + string.Format("BrokenRules.Assert(\"{0}Len\",\"{0} is too long.\",\"{0}\",{1});",propertyName, rule);
		}
		return brokenRules;
	}

	public string StringReplacement(ColumnSchemaCollection primaryKeys) 
	{
		string str = (char)34 + primaryKeys[0].Table.Name + (char)34;
		
		foreach(ColumnSchema col in primaryKeys) 
		{
			str += " + " + (char)34 + "/" + (char)34 + " + " + GetMemberVariableName(col, "") + ".ToString()";
		}
		return str;
	}

	public string GetCSVariableType(ColumnSchema column)
	{
		if (column.Name.EndsWith("TypeCode")) return column.Name;

		switch (column.DataType)
		{
			case DbType.AnsiString: 
			case DbType.AnsiStringFixedLength: 
			case DbType.String: 
			case DbType.StringFixedLength: return "string";
			case DbType.Binary: return "byte[]";
			case DbType.Boolean: return "bool";
			case DbType.Byte: return "byte";
			case DbType.Currency: return "decimal";
			case DbType.Date: 
			case DbType.DateTime: return "SmartDate";
			case DbType.VarNumeric: 
			case DbType.Decimal: return "decimal";
			case DbType.Double: return "double";
			case DbType.Guid: return "Guid";
			case DbType.Int16: return "short";
			case DbType.Int32: return "int";
			case DbType.Int64: return "long";
			case DbType.Object: return "object";
			case DbType.SByte: return "sbyte";
			case DbType.Single: return "float";
			case DbType.Time: return "TimeSpan";
			case DbType.UInt16: return "ushort";
			case DbType.UInt32: return "uint";
			case DbType.UInt64: return "ulong";
			default:
			{
				return "__UNKNOWN__" + column.NativeType;
			}
		}
	}

	public string GetPropertyVariableType(ColumnSchema column) 
	{
		//override property type to string if date or datetime
		if(DbType.Date == column.DataType || DbType.DateTime == column.DataType)
			return "string";

		return GetCSVariableType(column);
	}

	public string GetAccessModifier(AccessibilityEnum accessibility)
	{
		string output;

		switch (accessibility)
		{
			case AccessibilityEnum.Public:
				output ="public";
				break;
			case AccessibilityEnum.Protected:
				output ="protected";
				break;
			case AccessibilityEnum.Internal:
				output ="internal";
				break;
			case AccessibilityEnum.ProtectedInternal:
				output ="protected internal";
				break;
			case AccessibilityEnum.Private:
				output = "private";
				break;
			default:
				output = "";
				break;
		}
		return output;
	}

	public string GetMustInherit(bool value)
	{
		if (value || _setAsBaseClass) 
			return "abstract ";
		else
			return "";
	}

	#region Data Reader functions
	public string GetSProcParmExt(ColumnSchema column) 
	{
		//get extension to use for stored procedure parameter values
		switch (GetCSVariableType(column)) 
		{
			case "SmartDate":
				return ".DBValue";
			default:
				return "";
		}
	}

	public string GetReaderMethod(ColumnSchema column)
	{
		switch (column.DataType)
		{
			case DbType.AnsiString: 
			case DbType.AnsiStringFixedLength: 
			case DbType.String: 
			case DbType.StringFixedLength: return "GetString";
			case DbType.Binary: return "GetBytes";
			case DbType.Boolean: return "GetBoolean";
			case DbType.SByte: 
			case DbType.Byte: return "GetByte";
			case DbType.Currency: 
			case DbType.VarNumeric: 
			case DbType.Decimal: return "GetDecimal";
			case DbType.Date:
			case DbType.Time: 
			case DbType.DateTime: return "GetSmartDate";
			case DbType.Double: return "GetDouble";
			case DbType.Guid: return "GetGuid";
			case DbType.Int16: return "GetInt16";
			case DbType.Int32: return "GetInt32";
			case DbType.Int64: return "GetInt64";
			case DbType.Single: return "GetFloat";
			default:
			{
				return "GetObject";
			}
		}
	}
	public string GetReaderAssignmentStatement(ColumnSchema column, int index, string structureName)
	{
		string memberVariableName = structureName.Length==0? GetMemberVariableName(column,""): structureName + "." + GetPropertyName(column);
		string readerMethod = GetReaderMethod(column);
		string statement = memberVariableName + " = ";
	
		switch (readerMethod)
		{
			case "GetSmartDate":
				statement += "dr.GetSmartDate(" + index.ToString() +"," + memberVariableName + ".EmptyIsMin);";
				break;
			case "GetBytes":
				statement = "dr.GetBytes(" + index.ToString() + ", 0, " + memberVariableName + ", 0, int.MaxValue);";
				break;
			default:
				statement += "dr." + readerMethod + "(" + index.ToString() +");";
				break;
		}
		return statement;
	}

	#endregion


}
