// 
// Palladio Class
// $Id$
//
using System;
using Palladio.Identifier;

namespace Palladio.ComponentModel.Components
{
	/// <summary>
	/// Summary description for DefaultRole.
	/// </summary>
	/// <remarks><pre>
	/// $Log$
	/// Revision 1.4.2.1  2004/11/16 13:37:47  uffi
	/// Initial commit of the 2.0 version of the component model. BETA!!! See the techreport (to be updated) for details.
	/// Documentation needs fixing. Some unittests fail.
	///
	/// Revision 1.4  2004/09/02 12:50:06  uffi
	/// Added XML Serialization and Deserialization functionality
	///
	/// Revision 1.3  2004/06/02 19:41:31  sbecker
	/// Fixed docu
	///
	/// Revision 1.2  2004/06/02 15:41:13  sbecker
	/// Fixed Compiler Warnings
	///
	/// Revision 1.1  2004/06/02 14:50:24  sbecker
	/// Initial Import after a major rework
	///
	///
	/// </pre></remarks>
	internal class DefaultRole : IRole
	{
		protected IInterfaceModel interfaceModel;
		protected IComponent component;
		protected IIdentifier myID;
		protected string name;

		public IInterfaceModel Interface
		{
			get
			{
				return interfaceModel;
			}
		}

		public IComponent Component
		{
			get
			{
				return component;
			}
		}

		public string Name
		{
			get
			{
				return name;
			}
			set
			{
				name = value;
			}
		}

		public IIdentifier ID
		{
			get
			{
				return IdentifiableFactory.CreateStringID( GetHashCode().ToString() );
			}
		}

		public object Clone()
		{
			return new DefaultRole(this.component, (IInterfaceModel)interfaceModel.Clone());
		}

		public override bool Equals(object obj)
		{
			if (!(obj is IRole)) return false;
			if (obj == this) return true;
			IRole otherRole = (IRole)obj;
			return (otherRole.ID.Equals(this.ID) && otherRole.Interface.Equals(this.Interface));
		}
 
		public override int GetHashCode()
		{
			return ( component.ID.GetHashCode() ^ interfaceModel.ID.GetHashCode() );
		}

		/// <summary>
		/// Desciption of the constructor
		/// </summary>
		public DefaultRole(IComponent aComponent, IInterfaceModel anInterfaceModel)
		{
			this.interfaceModel = anInterfaceModel;
			this.component = aComponent;
			this.name = "Role";
		}
	}
}
