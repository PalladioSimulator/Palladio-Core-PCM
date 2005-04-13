using System;
using Palladio.ComponentModel.Builder.DefaultBuilder.TypeLevelBuilder;
using Palladio.ComponentModel.Builder.TypeLevelBuilder;
using Palladio.ComponentModel.Exceptions;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelDataManagement;
using Palladio.ComponentModel.ModelEntities;
using Palladio.ComponentModel.ModelEventManagement;

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
	/// Revision 1.5  2005/04/13 09:27:17  kelsaka
	/// - added builders (including interfaces) for types and parameters of signatures.
	///
	/// Revision 1.4  2005/04/12 18:08:35  kelsaka
	/// - added events to builders
	///
	/// Revision 1.3  2005/04/12 12:32:39  kelsaka
	/// - removed property to access typed IDs directly from the builders
	/// - renamed the property from 'SignaturID' to 'SignatureID' in ISignature
	///
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

		/// <summary>
		/// Sets the return type of the actual signature. The return type is newly created.
		/// </summary>
		/// <param name="name">The name of the return-type. It has to be a valid
		/// <see cref="ITypeTypeLevelBuilder"/>-name. This means that the type needs to exist.</param>
		/// <returns>A <see cref="TypeNotFoundException"/> for the new type.</returns>
		/// <exception cref="IType">Thrown if the given string is not
		/// a valid type-name.</exception>
		public ITypeTypeLevelBuilder SetReturnType (string name)
		{
			IType type = EntityFactory.CreateType(name);
			this.signature.ReturnType = type;
			return new DefaultTypeTypeLevelBuilder(lowLevelBuilder, type);
		}

		/// <summary>
		/// Sets the return type of the actual signature.
		/// </summary>
		/// <param name="type">The given type is used as return type.</param>
		public void SetReturnType (IType type)
		{
			this.signature.ReturnType = type;
		}

		/// <summary>
		/// Sets the return type to <see cref="void"/> (void).
		/// </summary>
		public void SetReturnTypeVoid ()
		{
			this.signature.ReturnType = EntityFactory.CreateType(typeof(void));
		}

		/// <summary>
		/// Appends a new parameter to end of the parameter list of the signature.
		/// </summary>
		/// <param name="name">The new parameters name.</param>
		/// <returns>A <see cref="IParameterTypeLevelBuilder"/> for the newly created
		/// parameter.</returns>
		public IParameterTypeLevelBuilder AppendParameter (string name)
		{
			throw new NotImplementedException ();
		}

		/// <summary>
		/// Clears the list of parameters. Afterwards the signature contains no more parameters.
		/// </summary>
		/// <remarks>
		/// Currently parameters do not have IDs. As parameters might occur multiple times it can
		/// not be determined which parameter is meant to delete. So always the whole list has to
		/// be deleted.
		/// </remarks>
		public void ClearParameterList ()
		{
			throw new NotImplementedException ();
		}

		/// <summary>
		/// Adds a new exception with the given name to the unordered list of exceptions.
		/// Exceptions can only occur once in the list.
		/// </summary>
		/// <param name="name">The type-name of the new exception. It has to be a valid
		/// <see cref="IType"/>-name and a <see cref="Exception"/>.</param>
		/// <returns>A <see cref="ITypeTypeLevelBuilder"/> for the new exception.</returns>
		public ITypeTypeLevelBuilder AddException (string name)
		{
			throw new NotImplementedException ();
		}

		/// <summary>
		/// Adds the given exception to the signature.
		/// </summary>
		/// <param name="type">The exception to add. It has to be a valid
		/// <see cref="Exception"/>.</param>
		public void AddException (IType type)
		{
			throw new NotImplementedException ();
		}

		/// <summary>
		/// Removes the given exception from the signature.
		/// </summary>
		/// <param name="exception">The exception to remove.</param>
		public void RemoveException (IType exception)
		{
			throw new NotImplementedException ();
		}

		#endregion

		#region Properties

		/// <summary>
		/// Accesses the created instance.
		/// </summary>
		public ISignature Signature
		{
			get { return this.signature; }
		}

		#endregion

		/// <summary>
		/// The name of the entity
		/// </summary>
		public string Name
		{
			get { throw new NotImplementedException (); }
			set { throw new NotImplementedException (); }
		}

		/// <summary>
		/// has to be fired when the name is changed
		/// </summary>
		public event StaticAttributeChangedEventHandler NameChangedEvent;
	}
}
