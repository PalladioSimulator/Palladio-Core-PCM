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
		
		#endregion

		#region Constructors

		/// <summary>
		/// Creates a SignaturesList.
		/// </summary>
		/// <param name="aRoleID">Unique identifier.</param>
		/// <param name="anAttHash">Attributes.</param>
		/// <param name="aSigArray">Signatures contained by the interface.</param>
		public SignatureList(string aRoleID, IAttributeHash anAttHash, params ISignature[] aSigArray)
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
			this( aSigList.RoleID, aSigList.Attributes, aSigList.Signatures ) {}

		#endregion
		
		#region Data
		
		private IAttributeHash attributes;
		private Set signatures;
		private string roleID;
		
		#endregion
	}
}
