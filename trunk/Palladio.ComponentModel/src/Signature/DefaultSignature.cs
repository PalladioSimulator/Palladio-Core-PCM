using System;
using System.Collections;
using Palladio.Identifier;
using Palladio.Attributes;
using Palladio.Utils.Collections;
using Palladio.FiniteStateMachines;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// Simple implementation of the ISignature interface for methods.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/02/21 13:49:17  joemal
	/// initial import
	///
	///
	/// </pre>
	/// </remarks>
	internal class DefaultSignature : ISignature
	{
		#region Properties

		
		/// <summary>
		/// The name of the signature without any additional
		/// information like the return type or parameters.
		/// </summary>
		public string Name
		{
			get { return name; }
		}

		/// <summary>
		/// Type of the return value.
		/// </summary>
		public IType ReturnType 
		{ 
			get { return type; } 
		}

		/// <summary>
		/// Parameters required by this signature.
		/// </summary>
		public IParameter[] Parameters
		{ 
			get { return (IParameter[])parameters.ToArray(typeof(IParameter)); } 
		}
		
		public IType[] Exceptions {
			get { return (IType[])exceptions.ToArray(typeof(IType)); }
		}
		public AttributeHash Attributes {
			get {
				return attributes;
			}
		}
		
		public IIdentifier ID
		{
			get
			{
				return IdentifiableFactory.CreateStringID(this.GetHashCode().ToString());
//				string sigID = this.name+"(";
//				if (this.Parameters.Length > 0) 
//				{
//					foreach (IParameter p in this.Parameters) 
//					{
//						sigID += p.Type+",";
//					}
//					sigID = sigID.TrimEnd(new char[]{','});
//				}
//				sigID += ")";
//				return IdentifiableFactory.CreateStringID(sigID);
			}
		}
		#endregion

		#region Methods
		
		public bool Match(IMatchable other)
		{
			return false;
			//TODO implement proper matching algorithm
		}

		/// <summary>
		/// Creates a copy of the current instance.
		/// </summary>
		/// <returns>A new object with the same values as the current instance.</returns>
		public object Clone()
		{
			return new DefaultSignature(this);
		}

		public override bool Equals(object obj)
		{
			if (!(obj is ISignature)) return false;
			ISignature sig = (ISignature)obj;

			if (!(this.name.Equals(sig.Name) &&
						this.Name.Equals(sig.Name) && 
						this.ReturnType.Equals(sig.ReturnType) &&
						(this.Parameters.Length == sig.Parameters.Length) &&
						(this.Exceptions.Length == sig.Exceptions.Length)
					))
				return false;

			for (int i = 0; i < this.Parameters.Length; i++)
			{
				if (!sig.Parameters[i].Equals(this.Parameters[i]))
					return false;
			}

			foreach (IType ex in this.Exceptions)
			{
				if (Array.IndexOf(sig.Exceptions, ex) < 0)
					return false;
			}

			return true;
		}

		public override int GetHashCode()
		{
			return	
				(
				(Name		!= null ? Name.GetHashCode() : 0) ^ 
				(ReturnType != null ? ReturnType.GetHashCode() : 0) ^
				(parameters != null ? parameters.GetHashCode() : 0) ^
				(exceptions != null ? exceptions.GetHashCode() : 0) 
				);
		}

		public override string ToString()
		{
			string result = ReturnType + " " + Name + "(";
			string parameters = "";
			string exceptions = "";
			foreach(IParameter p in Parameters)
			{
				parameters += p.ToString() + ", ";
			}
			if (parameters.Length != 0) 
				parameters = parameters.Substring(0,parameters.Length-2);
			foreach(IType e in Exceptions)
			{
				exceptions += e.ToString() + ", ";
			}
			if (exceptions.Length != 0) 
				exceptions = exceptions.Substring(0,exceptions.Length-2);
			result += parameters + ")";
			if (exceptions.Length > 0)
				result += "throws " + exceptions;
			return result;
		}

		public void Serialize(System.Xml.XmlTextWriter writer) 
		{
			writer.WriteStartElement("Signature","http://palladio.informatik.uni-oldenburg.de/XSD");
			writer.WriteAttributeString("id",this.ID.ToString());

			writer.WriteStartElement("Name","http://palladio.informatik.uni-oldenburg.de/XSD");
			writer.WriteString(this.Name);
			writer.WriteEndElement();

			writer.WriteStartElement("ReturnType","http://palladio.informatik.uni-oldenburg.de/XSD");
			writer.WriteString(this.ReturnType.ToString());
			writer.WriteEndElement();

			foreach (IParameter p in parameters) 
			{
				writer.WriteStartElement("Parameter","http://palladio.informatik.uni-oldenburg.de/XSD");

				writer.WriteStartElement("Name","http://palladio.informatik.uni-oldenburg.de/XSD");
				writer.WriteString(p.Name);
				writer.WriteEndElement();

				writer.WriteStartElement("Type","http://palladio.informatik.uni-oldenburg.de/XSD");
				writer.WriteString(p.Type.ToString());
				writer.WriteEndElement();

				writer.WriteEndElement();
			}

			foreach (IType t in exceptions) 
			{
				writer.WriteStartElement("Exception","http://palladio.informatik.uni-oldenburg.de/XSD");
				writer.WriteString(t.ToString());
				writer.WriteEndElement();
			}

			writer.WriteEndElement();
		}

		public void Deserialize(System.Xml.XmlNode element) 
		{
			foreach(System.Xml.XmlNode node in element.ChildNodes)
			{
				switch (node.Name) 
				{
					case "Name":
						this.name = node.InnerText;
						break;
					case "ReturnType":
						this.type = ComponentFactory.CreateType(node.InnerText);
						break;
					case "Parameter":
						IType type = null;
						string name = "";
						foreach (System.Xml.XmlNode paramChild in node.ChildNodes) 
						{
							switch (paramChild.Name)
							{
								case "Name":
									name = paramChild.InnerText;
									break;
								case "Type":
									type = ComponentFactory.CreateType(paramChild.InnerText);
									break;
								case "Modifier":
									break;
							}
						}
						this.parameters.Add(ComponentFactory.CreateParameter(type,name));
						break;
					case "Exception":
						this.exceptions.Add(ComponentFactory.CreateType(node.InnerText));
							break;
				}
			}
		}

		#endregion

		#region Constructors

		/// <summary>
		/// Creates a new signature.
		/// </summary>
		/// <param name="anAttribHash">Attributes of the Signature.</param>
		/// <param name="aType">A return type</param>
		/// <param name="aName">The name of the signature</param>
		/// <param name="aParamArray">Parameters of the signature</param>
		/// <param name="anExceptArray">Exceptions of the signature</param>
		public DefaultSignature(AttributeHash anAttribHash, IType aType, string aName, IParameter[] aParamArray, IType[] anExceptArray
		)
		{
			attributes = anAttribHash;
			type = aType;
			name = aName;
			parameters = new Vector(aParamArray);
			exceptions = new Set(anExceptArray);
		}

		/// <summary>
		/// CopyConstructor.
		/// </summary>
		/// <param name="aSig">Signature to copy.</param>
		public DefaultSignature(DefaultSignature  aSig) : 
			this(aSig.Attributes, aSig.ReturnType, aSig.Name, aSig.Parameters, aSig.Exceptions
						
			)
		{
		}
		#endregion

		#region Data
		
		private string name;
		private IType  type;
		private Vector parameters;
		private Set exceptions;
		private AttributeHash attributes;

		#endregion
	}
}
