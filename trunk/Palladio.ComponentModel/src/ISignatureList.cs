using System;
using System.Collections;

using Palladio.Identifier;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// A SignatureList contains a set of signatures
	/// and provides several methods to query them.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2005/02/24 20:13:06  joemal
	/// remove serilization and equals methods
	///
	/// Revision 1.1  2005/02/21 13:50:51  joemal
	/// initial import
	///
	///
	/// </pre>
	/// </remarks>
	public interface ISignatureList : IEnumerable,ICloneable
	{
		#region Properties

		/// <summary>
		/// The number of signature in this list
		/// </summary>
		int Count
		{
			get;
		}
		
		/// <summary>
		/// Indexer to access the signatures easily.
		/// </summary>
		ISignature this[int index]
		{
			get;
		}

		#endregion

		#region methods

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
		
		/// <summary>
		/// Query the list for a certain signature
		/// </summary>
		/// <param name="aSignature">The signature which is searched</param>
		/// <returns>True if the queried signature is in the list</returns>
		bool ContainsSignature( ISignature aSignature );

		/// <summary>
		/// Query the list for a certain signature ID
		/// </summary>
		/// <param name="aSignatureID">The signature ID which is searched</param>
		/// <returns>True if the queried signature ID is in the list</returns>
		bool ContainsSignatureID( IIdentifier aSignatureID );
		
		/// <summary>
		/// Get the signature matching to given id
		/// </summary>
		/// <param name="id">id of the searched signature</param>
		/// <returns>The signature that belong to the given id. If no matching signature can be found,
		/// null is returned.</returns>
		ISignature GetSignaturesByID( IIdentifier id );

		/// <summary>
		/// Returns the complete set of signatures belonging to this signature list
		/// </summary>
		/// <returns>A complete set of signatures belonging to this signature list</returns>
		ISignature[] GetSignatures();
		
		/// <summary>
		/// This event is raised before and after a change of the signatures in this list
		/// </summary>
		event SignatureListChangeEventHandler SignatureListChangeEvent;

		#endregion
	}
}
