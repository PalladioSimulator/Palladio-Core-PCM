using System;
using System.Collections;
using Palladio.Utils.Collections;

namespace Palladio.ComponentModel 
{
	/// <summary>
	/// A SignatureList is the simplest form of an IInterfaceModel, just
	/// containing a set of signatures.
	/// </summary>
	public interface ISignatureList : IInterfaceModel
	{
		#region Properties

		/// <summary>
		/// A list of ISignature objects.
		/// </summary>
		ISignature[] SignatureList 
		{
			get;
		}

		void AddSignatures( params ISignature[] aSig );

		void DeleteSignatures( params ISignature[] aSig );

		#endregion
	}
}
