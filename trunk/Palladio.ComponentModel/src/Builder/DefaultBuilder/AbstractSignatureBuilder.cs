using System;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelDataManagement;
using Palladio.ComponentModel.ModelEntities;

namespace Palladio.ComponentModel.Builder.DefaultBuilder
{
	/// <summary>
	/// Abstract implementation of the Signature builder - methods that are available at all levels.
	/// <summary>
	/// 
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2005/04/09 12:23:20  kelsaka
	/// - added documentation
	///
	/// Revision 1.1  2005/04/08 15:40:06  kelsaka
	/// - added SignatureBuilder
	/// - fixed bug: some new entities were not added to component model
	///
	/// </pre>
	/// </remarks>
	public abstract class AbstractSignatureBuilder : ISignatureBuilder
	{
		#region data

		private ILowLevelBuilder lowLevelBuilder;
		private ISignature signature;

		#endregion

		#region methods

		/// <summary>
		/// Initializes the Builder. Has to be called by implementing members at construction time.
		/// </summary>
		/// <param name="lowLevelBuilder">The model data management.</param>
		/// <param name="signature">The signature to build.</param>
		public void Init(ILowLevelBuilder lowLevelBuilder, ISignature signature)
		{
			this.lowLevelBuilder = lowLevelBuilder;
			this.signature = signature;
		}

		#endregion

		#region Properties

		/// <summary>
		/// Returns the <see cref="ISignatureIdentifier"/> of the actual interface.
		/// </summary>
		public ISignatureIdentifier SignatureID
		{
			get { return signature.SignaturID; }
		}

		/// <summary>
		/// Accesses the created instance.
		/// </summary>
		public ISignature Signature
		{
			get { return this.signature; }
		}

		#endregion
	}
}
