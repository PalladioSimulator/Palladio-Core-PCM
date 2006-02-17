using System;
using Palladio.ComponentModel.Identifier;

namespace Palladio.ComponentModel.ModelEntities
{
	/// <summary>
	/// IType is defines general type used by signatures to specify the parameters, the return type and the exceptions.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.3  2005/07/23 18:59:57  joemal
	/// IType now is implemented in external object. Plugins for serializer are created.
	///
	/// Revision 1.2  2005/04/14 08:19:28  kelsaka
	/// - added new Equals semantic for IType
	/// - added new GetType-method for IType
	///
	/// Revision 1.1  2005/03/15 12:31:23  joemal
	/// initial class creation
	///
	///
	/// </pre>
	/// </remarks>
	public interface IType
	{
		/// <summary>
		/// returns the id of the type. This id is unique for an implementation of IType.
		/// </summary>
		ITypeIdentifier TypeID
		{
			get;
		}

		/// <summary>
		/// returns the name of the type
		/// </summary>
		string Name
		{
			get;
		}
	}
}
