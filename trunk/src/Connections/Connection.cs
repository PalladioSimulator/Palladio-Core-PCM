using System;
using System.Collections;
using Palladio.Attributes;
using Palladio.Utils.Collections;

namespace Palladio.ComponentModel.Connections
{
	/// <summary>
	/// </summary>
	internal abstract class Connection : IConnection
	{

		#region Properties

		/// <summary>
		/// A list of attributes attached this component. 
		/// </summary>
		public IAttributeHash Attributes 
		{ 
			get { return attributes; }
		}

		public AttachedInterface SingleInterface
		{
			get { return singleInterface; }
			set { singleInterface = value; }
		}

		public AttachedInterface[] MultipleInterfaces
		{
			get { return (AttachedInterface[]) multipleInterfaces.ToArray(typeof(AttachedInterface));}
			set { multipleInterfaces = new Vector(value); }
		}

		#endregion

		#region Methods

		/// <summary>
		/// Creates a copy of the current instance.
		/// </summary>
		/// <returns>A new object with the same values as the current instance.</returns>
		public abstract object Clone();

		public void AddInterfaces(params AttachedInterface[] anInterfaceArray)
		{
			multipleInterfaces.AddRange(anInterfaceArray);
		}

		public void AddInterface(string aRoleID, IComponent aComponent)
		{
			AddInterfaces( new AttachedInterface(aRoleID, aComponent) );
		}

		public void DeleteInterfaces(params AttachedInterface[] anInterfaceArray)
		{
			foreach (AttachedInterface iface in anInterfaceArray)
			{
				multipleInterfaces.Remove(iface);
			}
		}

		public void DeleteInterface(string aRoleID, IComponent aComponent)
		{
			DeleteInterfaces( new AttachedInterface(aRoleID, aComponent) );
		}

		public override bool Equals(object obj)
		{
			if (!(obj is Connection)) return false;
			if ((object)this == obj) return true;
			Connection myConnection = (Connection)obj;
			return (
				( singleInterface.Equals(myConnection.singleInterface) ) &&
				( multipleInterfaces != null ? multipleInterfaces.Equals(myConnection.multipleInterfaces) : myConnection.multipleInterfaces == null) 
			);
		}

		public override int GetHashCode()
		{
			return (
				( singleInterface.GetHashCode() ) ^
				( multipleInterfaces != null ? multipleInterfaces.GetHashCode() : 0) 
			);
		}



		#endregion

		#region Constructors

		protected Connection(IAttributeHash anAttHash)
		{
			attributes = (IAttributeHash)anAttHash.Clone();
		}

		protected Connection(Connection aConnection) : this (aConnection.Attributes)
		{
			singleInterface = aConnection.singleInterface;
			multipleInterfaces = new Vector(aConnection.MultipleInterfaces);
		}

		#endregion

		#region Data

		protected AttachedInterface singleInterface;
		protected Vector multipleInterfaces;
		private IAttributeHash attributes;
		#endregion
	}
}