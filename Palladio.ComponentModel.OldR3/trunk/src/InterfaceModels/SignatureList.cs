using System;
using System.Collections;
using Palladio.Utils.Collections;
using Palladio.Attributes;
using Palladio.ComponentModel.Exceptions;
using ReflectionBasedVisitor;

namespace Palladio.ComponentModel.InterfaceModels 
{
	/// <summary>
	/// A SignatureList is the simplest form of an IInterfaceModel, just
	/// containing a set of signatures.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.6  2004/05/24 15:20:44  sliver
	/// added cvs log
	///
	/// </pre>
	/// </remarks>
	internal class SignatureList : ISignatureList 
	{
		#region Properties
		
		/// <summary>
		/// Signatures of the interface.
		/// </summary>
		public ISignature[] Signatures 
		{
			get
			{
				return (ISignature[]) signatures.ToArray(typeof(ISignature));
			}
		}

		/// <summary>
		/// Indexer to access the sigantures easily.
		/// </summary>
		public ISignature this[int index]
		{
			get { return (ISignature) signatures[index]; }
		}

		/// <summary>
		/// A list of attributes attached an object. 
		/// </summary>
		public IAttributeHash Attributes 
		{ 
			get { return attributes; }
		}

		/// <summary>
		/// Local unique identifier of the interface model.
		/// </summary>
		public string RoleID 
		{ 
			get{ return roleID; }
			set{ roleID = value; }
		}

		#endregion
		
		#region Methods
		
		/// <summary>
		/// Adds an array of signatures to the interface.
		/// </summary>
		/// <param name="aSigArray">Signatures to add.</param>
		public void AddSignatures( params ISignature[] aSigArray )
		{
			foreach(ISignature sig in aSigArray)
				if ((this.RoleID != "") && (sig.RoleID != this.RoleID))
					throw new RoleIDMissmatchException(sig.RoleID,this.RoleID);
			signatures.AddRange(aSigArray);
		}

		/// <summary>
		/// Deletes a set of signatures from the interface.
		/// </summary>
		/// <param name="aSigArray">Signatures to delete.</param>
		public void DeleteSignatures( params ISignature[] aSigArray )
		{
			foreach (ISignature sig in aSigArray)
			{
				signatures.Remove(sig);
			}
		}

		public bool ContainsSignature( ISignature aSignature )
		{
			return signatures.Contains(aSignature);
		}

		public ISignature[] GetSignaturesByName( string aName )
		{
			ArrayList result = new ArrayList();
			foreach (ISignature s in signatures)
			{
				if (s.Name.Equals(aName))
					result.Add(s);
			}
			return (ISignature[])result.ToArray(typeof(ISignature));
		}

		
		/// <summary>
		/// This method is called by the <see cref="ReflectionBasedVisitor"/> to allow data
		/// structure driven visiting of the structure.<br></br>
		/// Leave this method's body empty if you don't need data structure driven visiting.
		/// </summary>
		/// <param name="visitor">The visitor to accept</param>
		public void AcceptVisitor (IVisitor visitor)
		{
		}

		/// <summary>
		/// Creates a copy of the current instance.
		/// </summary>
		/// <returns>A new object with the same values as the current instance.</returns>
		public object Clone()
		{
			return new SignatureList(this);
		}
		
		/// <summary>
		/// The Equals method determines whether the specified 
		/// System.Object is equal to the current System.Object.
		/// </summary>
		/// <param name="obj">Contains the Object to compare with 
		/// the current object.</param>
		/// <returns>Returns true if the specified object is equal 
		/// to the current objector or false if the obejcts 
		/// are not equal.</returns>
		public override bool Equals(object obj)
		{
			if (obj is SignatureList)
			{
				SignatureList sigList = (SignatureList)obj;
				return (
					sigList.roleID.Equals(this.roleID) &&
					sigList.signatures.Equals(this.signatures)
				);
			}
			return false;
		}

		/// <summary>
		/// The GetHashCode method serves as a hash function 
		/// for a particular type, suitable for use in hashing 
		/// algorithms and data structures like a hash table.
		/// </summary>
		/// <returns>A hash value for the current object.</returns>
		public override int GetHashCode()
		{
			return roleID.GetHashCode ();
		}

		/// <summary>
		/// Retrieves a string representation of the object.
		/// </summary>
		/// <returns>String representation of the object.</returns>
		public override string ToString()
		{
			return roleID;
		}

		#endregion

		#region Constructors

		/// <summary>
		/// Creates a SignaturesList.
		/// </summary>
		/// <param name="aRoleID">Unique identifier.</param>
		/// <param name="anAttHash">Attributes.</param>
		/// <param name="aSigArray">Signatures contained by the interface.</param>
		public SignatureList(IAttributeHash anAttHash, string aRoleID, params ISignature[] aSigArray)
		{
			roleID = aRoleID;
			attributes = anAttHash;
			signatures = new Set();
			AddSignatures(aSigArray);
		}

		/// <summary>
		/// Copy constructor.
		/// </summary>
		/// <param name="aSigList">SignatureList to copy.</param>
		public SignatureList(SignatureList aSigList) :
			this( aSigList.Attributes, aSigList.RoleID, aSigList.Signatures ) {}

		#endregion
		
		#region Data
		
		private IAttributeHash attributes;
		private Set signatures;
		private string roleID;
		
		#endregion
	}
}
