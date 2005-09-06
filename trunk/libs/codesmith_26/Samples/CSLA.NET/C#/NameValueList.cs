using System;
using System.Data;
using System.ComponentModel;
using CodeSmith.Engine;
using SchemaExplorer;
using Microsoft.CSharp;

/// <summary>
/// Summary description for NameValueList.
/// </summary>
public class NameValueList : CodeTemplate
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
	private string _classNamespace = "";
	private string _objectName = "";
	private TableSchema _rootTable;

	//Name Value List
	private string _keyColumn;
	private string _valueColumn;

	//Class Level Options
	private bool _useTabIndent = true;
	private string _flcPrefix = "";
	private string _memberPrefix = "_"; 
	private AccessibilityEnum _accessibility = AccessibilityEnum.Public;
	private bool _serializable = true;
	private bool _mustBeInherited = false;
	private TransactionEnum _transactionType = TransactionEnum.ADO;

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

	#region Name Value List
	[CodeTemplateProperty(CodeTemplatePropertyOption.Required),
	Category("4. Name Value List"), 
	Description("The Column name that is the Key column for this list.")]
	public string KeyColumn 
	{
		get {return _keyColumn;}
		set {_keyColumn = value;}
	}

	[CodeTemplateProperty(CodeTemplatePropertyOption.Required),
	Category("4. Name Value List"), 
	Description("The column name that is used for the value of the list.")]
	public string ValueColumn 
	{
		get {return _valueColumn;}
		set {_valueColumn = value;}
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


}
