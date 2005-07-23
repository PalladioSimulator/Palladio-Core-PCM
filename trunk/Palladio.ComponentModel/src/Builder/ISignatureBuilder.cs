using System;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelEntities;

namespace Palladio.ComponentModel.Builder
{
	/// <summary>
	/// ISignatureBuilder. Builds ISignatures.
	/// </summary>
	/// <remarks>
	/// <p>This builder interface contains all non model-level specifical methods of a signature.</p>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.19  2005/07/23 18:59:57  joemal
	/// IType now is implemented in external object. Plugins for serializer are created.
	///
	/// Revision 1.18  2005/06/05 10:36:34  joemal
	/// - replace the entities by the ids
	/// - components now can be added to more than one container
	///
	/// Revision 1.17  2005/05/27 10:30:12  kelsaka
	/// - updated some documentation
	///
	/// Revision 1.16  2005/05/25 19:44:54  kelsaka
	/// - optimized usings
	/// - builders are now returning identifiers again
	///
	/// Revision 1.15  2005/04/20 21:02:35  kelsaka
	/// - added first methods for constraints
	///
	/// Revision 1.14  2005/04/20 18:55:13  kelsaka
	/// - removed unused builders for parameters and types
	///
	/// Revision 1.13  2005/04/20 18:27:45  kelsaka
	/// - made classes internal
	/// - removed unused init-methods
	/// - use of InternalEntityIdentifier for creating new Identifiers
	///
	/// Revision 1.12  2005/04/20 13:26:43  kelsaka
	/// - added new Init-method implementation
	///
	/// Revision 1.11  2005/04/15 08:29:46  kelsaka
	/// - fixed errors on xml-comments
	///
	/// Revision 1.10  2005/04/13 20:24:08  kelsaka
	/// - added enitity methods
	///
	/// Revision 1.9  2005/04/13 17:36:51  kelsaka
	/// - completed signature builder
	///
	/// Revision 1.8  2005/04/13 17:06:02  kelsaka
	/// - added further support for building signatures
	///
	/// Revision 1.7  2005/04/13 09:27:17  kelsaka
	/// - added builders (including interfaces) for types and parameters of signatures.
	///
	/// Revision 1.6  2005/04/12 18:08:35  kelsaka
	/// - added events to builders
	///
	/// Revision 1.5  2005/04/12 12:32:39  kelsaka
	/// - removed property to access typed IDs directly from the builders
	/// - renamed the property from 'SignaturID' to 'SignatureID' in ISignature
	///
	/// Revision 1.4  2005/04/09 12:23:20  kelsaka
	/// - added documentation
	///
	/// Revision 1.3  2005/04/08 16:50:31  kelsaka
	/// - added interface builder implementation
	///
	/// Revision 1.2  2005/04/08 15:40:06  kelsaka
	/// - added SignatureBuilder
	/// - fixed bug: some new entities were not added to component model
	///
	/// Revision 1.1  2005/04/06 19:06:59  kelsaka
	/// - added new builder interfaces to support the levels of the component model
	/// - added basic set of methods to interfaces
	///
	/// </pre>
	/// </remarks>
	public interface ISignatureBuilder : IEntityBuilder
	{
		#region Methods

		/// <summary>
		/// Sets the return type of the actual signature.
		/// </summary>
		/// <param name="type">The given type is used as return type.</param>
		/// <exception cref="Exceptions.TypeNotFoundException">Thrown if the given string is not
		/// a valid type-name.</exception>
		void SetReturnType(IType type);

		/// <summary>
		/// called to set "void" es return type.
		/// </summary>
		void SetVoidReturnType();

		/// <summary>
		/// Appends a new parameter to the end of the parameter list of the signature.
		/// The <see cref="ParameterModifierEnum"/> is set to <see cref="ParameterModifierEnum.NONE"/>
		/// by default.
		/// </summary>
		/// <param name="type">The type of the new parameter</param>
		/// <param name="name">The new parameters name.</param>
		void AppendParameter(IType type, string name);

		/// <summary>
		/// Appends a new parameter to the end of the parameter list of the signature.
		/// </summary>
		/// <param name="type">The type of the new parameter</param>
		/// <param name="name">The new parameters name.</param>
		/// <param name="modifier">The modifier (<see cref="ParameterModifierEnum"/> like "out"
		/// or "ref") of the actual parameter.</param>
		void AppendParameter(IType type, string name, ParameterModifierEnum modifier);

		/// <summary>
		/// Clears the list of parameters. Afterwards the signature contains no more parameters.
		/// </summary>
		/// <remarks>
		/// Currently parameters do not have IDs. As parameters might occur multiple times it can
		/// not be determined which parameter is meant to delete. So always the whole list has to
		/// be deleted.
		/// </remarks>
		void ClearParameterList();

		/// <summary>
		/// Adds the given exception to the signature.
		/// </summary>
		/// <param name="type">The exception to add. It has to be a valid
		/// <see cref="Exception"/>.</param>
		/// <exception cref="Palladio.ComponentModel.Exceptions.TypeNotValidException">Thrown if the created
		/// type is not an exception (sub-) type.</exception>
		void AddException(IType type);

		/// <summary>
		/// Removes the given exception from the signature.
		/// </summary>
		/// <param name="exception">The exception to remove.</param>
		void RemoveException(IType exception);

		#endregion

		#region Properties

		/// <summary>
		/// Accesses the created instance.
		/// </summary>
		ISignature Signature
		{
			get;
		}

		/// <summary>
		/// Accesses the identifier of the actual instance.
		/// </summary>
		ISignatureIdentifier SignatureId
		{
			get;
		}

		#endregion
	}
}
