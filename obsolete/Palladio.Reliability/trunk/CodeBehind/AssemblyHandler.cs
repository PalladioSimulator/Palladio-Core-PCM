using System;
using System.Collections;
using System.ComponentModel;
using System.IO;
using System.Reflection;
using CodeSmith.Engine;

/// <summary>
/// Code Behind for the Interceptor and Interfaces Templates.
/// </summary>
public abstract class AssemblyHandler : CodeTemplate
{
	private string _assemblyPath = "";
	private string _assemblyNames = "";

	[Category("Strings")]
	[Description("Path to the assemblies.")]
	public string AssemblyPath
	{ 
		get {return _assemblyPath;}
		set {_assemblyPath = value;}
	}

	[Category("Strings")]
	[Description("Komma seperated list of assembly names (without the .dll extension).")]
	public string AssemblyNames
	{ 
		get {return _assemblyNames;}
		set {_assemblyNames = value;}
	}

	/// <summary>
	/// If the \ is missing, it is added.
	/// </summary>
	public void UnifyPath()
	{
		if (!AssemblyPath.EndsWith(@"\"))
			AssemblyPath += @"\";
	}

	/// <summary>
	/// Loads all assemblies and their References.
	/// </summary>
	/// <returns></returns>
	public Assembly[] GetAssemblies()
	{
		string[] names = AssemblyNames.Split(',');
		ArrayList assemblyList = new ArrayList();

		foreach (string name in names)
		{
			assemblyList.Add(LoadAssembly(name));
		}
		return (Assembly[])assemblyList.ToArray(typeof(Assembly));
	}

	/// <summary>
	/// If the assembly exists it is loaded.
	/// </summary>
	/// <param name="name"></param>
	/// <returns></returns>
	public Assembly LoadAssembly(string name)
	{
		string fileName = AssemblyPath + name.Trim() + ".dll";
		if (File.Exists(fileName))
		{
			Assembly assembly = Assembly.LoadFrom(fileName);
			loadedAssemblies[name] = assembly;
			LoadReferencedAssemblies(assembly);
			return assembly;
		}
		return null;
	}

	/// <summary>
	/// Load all references.
	/// </summary>
	/// <param name="assembly"></param>
	public void LoadReferencedAssemblies(Assembly assembly)
	{
		foreach (AssemblyName name in assembly.GetReferencedAssemblies())
		{
			LoadAssembly(name.Name);
		}
	}
	
	/// <summary>
	/// Returns all accessors of a type seperated into properties and
	/// methods.
	/// </summary>
	/// <param name="type"></param>
	/// <param name="propertyTable"></param>
	/// <param name="methodList"></param>
	public void GetMethods(System.Type type, out Hashtable propertyTable, out ArrayList methodList)
	{
		MethodInfo[] methods = type.GetMethods ( BindingFlags.Public | BindingFlags.Instance | BindingFlags.Static  );
		propertyTable = new Hashtable();
		methodList = new ArrayList();
		foreach (MethodInfo M in methods)
		{
			if (M.Name.StartsWith("get_"))
			{
				string name = M.Name.Remove(0,4);
				PropertyInfo pInfo = new PropertyInfo(name);
				if (propertyTable.Contains(name))
				{
					pInfo = (PropertyInfo)propertyTable[name];
					propertyTable.Remove(name);
				}
				pInfo.IsGettable = true;
				pInfo.Type = M.ReturnType;
				propertyTable.Add(name,pInfo);
			}
			else if (M.Name.StartsWith("set_"))
			{
				string name = M.Name.Remove(0,4);
				PropertyInfo pInfo = new PropertyInfo(name);
				if (propertyTable.Contains(name))
				{
					pInfo = (PropertyInfo)propertyTable[name];
					propertyTable.Remove(name);
				}
				pInfo.IsSettable = true;
				pInfo.Type = M.GetParameters()[0].ParameterType;
				propertyTable.Add(name,pInfo);
			}	
			else
			{
				methodList.Add(M);	
			}
		}
	}
	
	public bool IsVoidMethod(MethodInfo methodInfo)
	{
		return methodInfo.ReturnType.Equals(typeof(void));
	}

	public string GetCallString(MethodInfo methodInfo)
	{
		string callStr = "";
		if (!IsVoidMethod(methodInfo))
		{
			callStr += methodInfo.ReturnType.ToString() + " returnValue = ";
		}
		callStr += "_target." + methodInfo.Name +"(";
		
		ParameterInfo[] parameters = methodInfo.GetParameters();
		for (int i=0; i<parameters.Length; i++ )
		{
			if (i!=0) 
			{ 
				callStr += ", ";
			}
			callStr += parameters[i].Name;
		}
		callStr += ")";
		return callStr;
	}

	public string GetParameterString(MethodInfo methodInfo)
	{
		string parameterStr = "";
		ParameterInfo[] parameters = methodInfo.GetParameters();
		for (int i=0; i<parameters.Length; i++ )
		{
			if (i!=0) 
			{ 
				parameterStr += ", ";
			}
			parameterStr += parameters[i].ParameterType.ToString();
			parameterStr += " ";
			parameterStr += parameters[i].Name;
		}
		return parameterStr;
	}

	public string GetParameterTypeArrayString(MethodInfo methodInfo)
	{
		ParameterInfo[] parameters = methodInfo.GetParameters();
		string paramTypeStr = "new Type[] {";
		for (int i=0; i<parameters.Length; i++ )
		{
			if (i!=0) 
			{ 
				paramTypeStr += ", ";
			}
			paramTypeStr += "typeof("+parameters[i].ParameterType.ToString()+")";
		}
		paramTypeStr += "}";
		return paramTypeStr;		
	}

	public string GetReturnTypeString(MethodInfo methodInfo)
	{
		return IsVoidMethod(methodInfo) ? "void" : methodInfo.ReturnType.FullName;
	}

	public struct PropertyInfo
	{
		public bool IsGettable;
		public bool IsSettable;
		public string Name;
		public Type Type;

		public PropertyInfo(string name)
		{
			Name = name;
			IsGettable = false;
			IsSettable = false;
			Type = typeof(void);
		}
	}


	Hashtable loadedAssemblies = new Hashtable();
}
