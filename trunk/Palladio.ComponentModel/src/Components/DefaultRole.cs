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
	/// Revision 1.1  2005/02/21 13:52:55  joemal
	/// initial import
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
