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
	/// Revision 1.2  2004/06/02 15:41:13  sbecker
	/// Fixed Compiler Warnings
	///
	/// Revision 1.1  2004/06/02 14:50:24  sbecker
	/// Initial Import after a major rework
	///
	///
	/// </pre></remarks>
	public class DefaultRole : IRole
	{
		protected IInterfaceModel interfaceModel;
		protected IIdentifier myID;

		public IInterfaceModel Interface
		{
			get
			{
				return interfaceModel;
			}
		}

		public IIdentifier ID
		{
			get
			{
				return myID;
			}
		}

		public object Clone()
		{
			return new DefaultRole((IIdentifier)myID.Clone(),(IInterfaceModel)interfaceModel.Clone());
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
			return (
				myID.GetHashCode() ^
				interfaceModel.GetHashCode()
				);
		}

		/// <summary>
		/// Desciption of the constructor
		/// </summary>
		public DefaultRole(IIdentifier anID, IInterfaceModel anInterfaceModel)
		{
			this.interfaceModel = anInterfaceModel;
			this.myID = anID;
		}
	}
}
