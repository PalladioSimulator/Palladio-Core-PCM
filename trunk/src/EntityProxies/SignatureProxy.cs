#region Universität Oldenburg
//////////////////////////////////////////////////////////////////////////
//	Universität Oldenburg
//	Department für Informatik, Software Engineering
//	-----------------------------------------------------------------
//	Master-Arbeit "Entwicklung eines Editors für die modellgetriebene
//	Konstruktion komponentenbasierter Software-Architekturen"
//	Autor: Matthias Uflacker, 2004
//	eMail: matthias.uflacker@informatik.uni-oldenburg.de
//////////////////////////////////////////////////////////////////////////
#endregion

using System;
using System.Text;
using System.Collections;
using System.ComponentModel;
using System.Drawing.Design;

using Palladio.Identifier;
using Palladio.ComponentModel;
using Palladio.Editor.Common.Commands;
using Palladio.Editor.Common.EntityProxies.Collections;
using Palladio.Editor.Common.EntityProxies.UITypeEditors;

namespace Palladio.Editor.Common.EntityProxies
{
	/// <summary>
	/// Zusammenfassung für SignatureProxy.
	/// </summary>
	[TypeConverter(typeof(UITypeEditors.SignatureTypeConverter))]
	public class SignatureProxy : EntityProxy
	{
		/// <summary>
		/// </summary>
		protected ISignature _signature;

		/// <summary>
		/// </summary>
		protected InterfaceProxy _interface;

		private ParameterProxyCollection _parameters;

		private EntityChangedHandler _parameter_EntityChangedHandler;

		#region Constructors
		/// <summary>
		/// 
		/// </summary>
		/// <param name="signature"></param>
		/// <param name="iface"></param>
		/// <param name="cmdHandler"></param>
		/// <param name="parameters"></param>
		public SignatureProxy(ISignature signature, InterfaceProxy iface, CommandHandler cmdHandler, ParameterProxy[] parameters)
			: base(cmdHandler)
		{
			this._signature = signature;
			this._interface = iface;

			this._parameters = new ParameterProxyCollection();
			this._parameters.AddRange(parameters);

			//this._parameter_EntityChangedHandler = new EntityChangedHandler(parameter_EntityChanged);

			//this.UpdateParameterList();
		}
		#endregion

		#region Public Properties
		/// <summary>
		/// 
		/// </summary>
		[ ReadOnly(true),
		TypeConverter(typeof(StringConverter)),
		Category("Default"),
		DescriptionAttribute("The ID of this signature.") ]
		public override IIdentifier ID
		{
			get
			{
				return (IIdentifier)this._signature.ID.Clone();
			}
		}

		/// <summary>
		/// 
		/// </summary>
		[ ReadOnly(false),
		TypeConverter(typeof(StringConverter)),
		Category("Default"),
		DescriptionAttribute("The name of the method.") ]
		public string Name
		{
			get
			{
				return this._signature.Name;
			}
			set
			{
				ChangeSignatureCmd command = new ChangeSignatureCmd(this._signature, this._interface, value, null, null, null);
				this.FireCommandIssued( command );
			}
		}

		/// <summary>
		/// 
		/// </summary>
		[ ReadOnly(false),
		TypeConverter(typeof(StringConverter)),
		Category("Default"),
		DescriptionAttribute("The name of the type this service returns.") ]
		public string ReturnType
		{
			get
			{
				return this._signature.ReturnType.ToString();
			}
			set
			{
				ChangeSignatureCmd command = new ChangeSignatureCmd(this._signature, this._interface, null, value, null, null);
				this.FireCommandIssued( command );
			}
		}

		/// <summary>
		/// 
		/// </summary>
		[ ReadOnly(false),
		TypeConverter(typeof(ParameterListTypeConverter)),
		Editor(typeof(ParameterProxyCollectionTypeEditor), typeof(UITypeEditor)),
		Category("Parameters"),
		DescriptionAttribute("A ordered list of parameters accepted by this service.") ]
		public ParameterProxyCollection Parameters
		{
			get
			{
				return this._parameters;
			}
		}

		/// <summary>
		/// 
		/// </summary>
		[ ReadOnly(true),
		TypeConverter(typeof(StringConverter)),
		Category("Default"),
		DescriptionAttribute("Simple string representation") ]
		public string DisplayName
		{
			get
			{
				StringBuilder sb = new StringBuilder();
				sb.Append(this.Name);
				sb.Append("(");
				for(int i = 0; i < this.Parameters.Count; i++)
				{
					if (i > 0)
						sb.Append(", ");
					sb.Append(this.Parameters[i].Type);
					sb.Append(" ");
					sb.Append(this.Parameters[i].Name);
				}
				sb.Append(")");
				return sb.ToString();				
			}
			set
			{
			}
		}

		/// <summary>
		/// 
		/// </summary>
		public InterfaceProxy Interface
		{
			get
			{
				return this._interface;
			}
			set
			{
				this._interface = value;
			}
		}
		#endregion


		#region Public Methods
		/// <summary>
		/// 
		/// </summary>
		public void SetParameterList(ParameterProxyCollection parameters)
		{
			this._parameters = parameters;
			ChangeSignatureCmd command = new ChangeSignatureCmd(
				this._signature,
				this._interface, null, null, parameters, null);
			this.FireCommandIssued( command );
		}
		#endregion

		/// <summary>
		/// 
		/// </summary>
//		private void UpdateParameterList()
//		{
//			this._parameters.Clear();
//			foreach (IParameter param in this._signature.Parameters)
//			{
//				ParameterProxy parameter = new ParameterProxy(param);
//				this._parameters.Add(parameter);
//			}
//		}

		#region ICustomTypeDescriptor Member Overrides

		/// <summary>
		/// 
		/// </summary>
		/// <param name="attributes"></param>
		/// <returns></returns>
		public override PropertyDescriptorCollection GetProperties(Attribute[] attributes)
		{
			return GetProperties();
		}

		/// <summary>
		/// 
		/// </summary>
		/// <returns></returns>
		public override PropertyDescriptorCollection GetProperties()
		{
			// Create a new collection object PropertyDescriptorCollection
			PropertyDescriptorCollection pds = new PropertyDescriptorCollection(null);

			pds.Add(TypeDescriptor.GetProperties(this, true)["ID"]);
			pds.Add(TypeDescriptor.GetProperties(this, true)["Name"]);
			pds.Add(TypeDescriptor.GetProperties(this, true)["ReturnType"]);
			pds.Add(TypeDescriptor.GetProperties(this, true)["Parameters"]);
			pds.Add(TypeDescriptor.GetProperties(this, true)["DisplayName"]);

			return pds;
		}

		#endregion

		/// <summary>
		/// 
		/// </summary>
		/// <param name="source"></param>
		/// <param name="entity"></param>
		/// <param name="e"></param>
//		private void parameter_EntityChanged(object source, EntityProxy entity, EventArgs e)
//		{
//			this.UpdateParameterList();
//		}
	}

	/// <summary>
	/// 
	/// </summary>
	internal class SignatureProxyCollectionDescriptor : PropertyDescriptor
	{
		private SignatureProxyCollection collection = null;
		private int index = -1;

		public SignatureProxyCollectionDescriptor(SignatureProxyCollection coll, int idx) : 
			base( "#"+idx.ToString(), null )
		{
			this.collection = coll;
			this.index = idx;
		} 

		/// <summary>
		/// 
		/// </summary>
		public override AttributeCollection Attributes
		{
			get 
			{ 
				return new AttributeCollection(null);
			}
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="component"></param>
		/// <returns></returns>
		public override bool CanResetValue(object component)
		{
			return true;
		}

		/// <summary>
		/// 
		/// </summary>
		public override Type ComponentType
		{
			get 
			{ 
				return this.collection.GetType();
			}
		}

		/// <summary>
		/// 
		/// </summary>
		public override string DisplayName
		{
			get 
			{
				return this.collection[index].Name;
			}
		}

		/// <summary>
		/// 
		/// </summary>
		public override string Description
		{
			get
			{
				SignatureProxy sig = this.collection[index];
				StringBuilder sb = new StringBuilder();
				sb.Append(sig.ReturnType);
				sb.Append(" ");
				sb.Append(sig.Name);
				sb.Append("(");
				for(int i = 0; i < sig.Parameters.Count; i++)
				{
					if (i > 0)
						sb.Append(", ");
					sb.Append(sig.Parameters[i].Type);
					sb.Append(" ");
					sb.Append(sig.Parameters[i].Name);
				}
				sb.Append(") ");
				sb.Append("throws ");
				return sig.ToString();
			}
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="component"></param>
		/// <returns></returns>
		public override object GetValue(object component)
		{
			return this.collection[index];
		}

		/// <summary>
		/// 
		/// </summary>
		public override bool IsReadOnly
		{
			get { return false;  }
		}

		/// <summary>
		/// 
		/// </summary>
		public override string Name
		{
			get { return "#"+index.ToString(); }
		}

		/// <summary>
		/// 
		/// </summary>
		public override Type PropertyType
		{
			get { return this.collection[index].GetType(); }
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="component"></param>
		public override void ResetValue(object component)
		{
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="component"></param>
		/// <returns></returns>
		public override bool ShouldSerializeValue(object component)
		{
			return true;
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="component"></param>
		/// <param name="value"></param>
		public override void SetValue(object component, object value)
		{
			// this.collection[index] = value;
		}
	}
}
