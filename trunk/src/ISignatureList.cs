using System;
using System.Collections;
using Palladio.Utils.Collections;

namespace Palladio.ComponentModel 
{
	/// <summary>
	/// A SignatureList is  an InterfaceModel just
	/// containing a set of signatures.
	/// </summary>
	public interface ISignatureList : IInterfaceModel
	{
		#region Properties

		/// <summary>
		/// Signatures of the interface.
		/// </summary>
		ISignature[] Signatures
		{
			get;
		}
		
		/// <summary>
		/// Indexer to access the sigantures easily.
		/// </summary>
		ISignature this[int index]
		{
			get;
		}

		/// <summary>
		/// Adds an array of signatures to the interface.
		/// </summary>
		/// <param name="aSigArray">Signatures to add.</param>
		void AddSignatures( params ISignature[] aSigArray );

		/// <summary>
		/// Deletes a set of signatures from the interface.
		/// </summary>
		/// <param name="aSigArray">Signatures to delete.</param>
		void DeleteSignatures( params ISignature[] aSigArray );

		#endregion
	}
}
