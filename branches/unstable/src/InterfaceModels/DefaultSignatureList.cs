using System;
using System.Collections;

using Palladio.ComponentModel;
using Palladio.Identifier;
using Palladio.Utils.Collections;



namespace Palladio.ComponentModel.InterfaceModels
{
	/// <summary>
	/// Zusammenfassung für DefaultSignatureList.
	/// todo: Möglicherweise als hashmap mit id als key
	/// </summary>
	internal class DefaultSignatureList : ISignatureList , ICloneable
	{
		#region Properties
		/// <summary>
		/// The number of signature in this list
		/// </summary>
		public int Count
		{
			get
			{
				return signatures.Count;
			}
		}
		
		/// <summary>
		/// Indexer to access the sigantures easily.
		/// </summary>
		public ISignature this[int index]
		{
			get { return (ISignature) signatures[index]; }
		}

		#endregion
		
		#region Methods
		
		/// <summary>
		/// Adds an array of signatures to the interface.
		/// </summary>
		/// <param name="aSigArray">Signatures to add.</param>
		public void AddSignatures( params ISignature[] aSigArray )
		{
			foreach (ISignature s in aSigArray)
			{
				if (SignatureListChangeEvent != null)
					SignatureListChangeEvent(this,new SignatureListChangeEventArgs(s, ChangeTimeEnum.BEFORE,ChangeTypeEnum.ADD));
			}
			signatures.AddRange(aSigArray);
			foreach (ISignature s in aSigArray)
			{
				if (SignatureListChangeEvent != null)
					SignatureListChangeEvent(this,new SignatureListChangeEventArgs(s, ChangeTimeEnum.AFTER,ChangeTypeEnum.ADD));
			}
		}

		/// <summary>
		/// Deletes a set of signatures from the interface.
		/// </summary>
		/// <param name="aSigArray">Signatures to delete.</param>
		public void DeleteSignatures( params ISignature[] aSigArray )
		{
			foreach (ISignature s in aSigArray)
			{
				if (SignatureListChangeEvent != null)
					SignatureListChangeEvent(this,new SignatureListChangeEventArgs(s, ChangeTimeEnum.BEFORE,ChangeTypeEnum.DELETE));
			}
			foreach (ISignature sig in aSigArray)
			{
				signatures.Remove(sig);
			}
			foreach (ISignature s in aSigArray)
			{
				if (SignatureListChangeEvent != null)
					SignatureListChangeEvent(this,new SignatureListChangeEventArgs(s, ChangeTimeEnum.AFTER,ChangeTypeEnum.DELETE));
			}
		}

		public bool ContainsSignature( ISignature aSignature )
		{
			return signatures.Contains(aSignature);
		}

		public bool ContainsSignatureID( IIdentifier aSignatureID )
		{
			foreach (ISignature sig in signatures)
			{
				if (sig.ID.Equals(aSignatureID))
					return true;
			}
			return false;
		}
												 
		public ISignature GetSignaturesByID( IIdentifier aName )
		{
			foreach (ISignature s in signatures)
			{
				if (s.ID.Equals(aName))
                    return s;
			}
			return null;
		}

		public ISignature[] GetSignatures()
		{
			return (ISignature[]) signatures.ToArray(typeof(ISignature));
		}

		public IEnumerator GetEnumerator()
		{
			return signatures.GetEnumerator();
		}

		/// <summary>
		/// Creates a copy of the current instance.
		/// </summary>
		/// <returns>A new object with the same values as the current instance.</returns>
		public object Clone()
		{
			return new DefaultSignatureList(this);
		}

		/// <summary>
		/// This event is raised before and after a change of the signatures in this list
		/// </summary>
		public event SignatureListChangeEventHandler SignatureListChangeEvent;
		
		#endregion

		#region Constructors

		/// <summary>
		/// Creates a SignaturesList.
		/// </summary>
		/// <param name="aSigArray">Signatures contained by the interface.</param>
		public DefaultSignatureList(params ISignature[] aSigArray)
		{
			signatures = new Set();
			AddSignatures(aSigArray);
		}

		/// <summary>
		/// Copy constructor.
		/// </summary>
		/// <param name="aSigList">SignatureList to copy.</param>
		public DefaultSignatureList(DefaultSignatureList aSigList) :
			this(aSigList.GetSignatures() ) {}

		#endregion
		
		#region Data
		
		private Set signatures;
		#endregion
	}
}
