using System;
using System.Collections;
using Palladio.Attributes;
using Palladio.Utils.Collections;

namespace Palladio.ComponentModel.Connections
{
	/// <summary>
	/// </summary>
	internal abstract class AbstractConnection : IConnection
	{

		#region Properties

		/// <summary>
		/// A list of attributes attached this component. 
		/// </summary>
		public IAttributeHash Attributes 
		{ 
			get { return attributes; }
		}

		public AttachedInterface FirstInterface
		{
			get { return firstInterface; }
			set { firstInterface = value; }
		}

		public AttachedInterface SecondInterface
		{
			get { return secondInterface;}
			set { secondInterface = value; }
		}

		#endregion

		#region Methods

		/// <summary>
		/// Creates a copy of the current instance.
		/// </summary>
		/// <returns>A new object with the same values as the current instance.</returns>
		public abstract object Clone();

		public override bool Equals(object obj)
		{
			if (!(obj is AbstractConnection)) return false;
			if ((object)this == obj) return true;
			AbstractConnection myConnection = (AbstractConnection)obj;
			return (
				firstInterface.Equals(myConnection.firstInterface) &&
				secondInterface.Equals(myConnection.secondInterface)
			);
		}

		public override int GetHashCode()
		{
			return (
				secondInterface.GetHashCode() ^
				secondInterface.GetHashCode()
			);
		}



		#endregion

		#region Constructors

		protected AbstractConnection(IAttributeHash anAttHash)
		{
			attributes = (IAttributeHash)anAttHash.Clone();
		}

		protected AbstractConnection(IAttributeHash anAttHash, AttachedInterface aFirstIface, AttachedInterface aSecondIface) : this (anAttHash)
		{
			firstInterface = aFirstIface;
			secondInterface = aSecondIface;
		}

		protected AbstractConnection(AbstractConnection aConnection) : 
			this (aConnection.Attributes, aConnection.FirstInterface, aConnection.SecondInterface)
		{
		}


		#endregion

		#region Data

		protected AttachedInterface firstInterface;
		protected AttachedInterface secondInterface;
		private IAttributeHash attributes;
		#endregion
	}
}