// 
// Palladio Interface
// $Id$
//
using System;
using Palladio.Identifier;
using Palladio.FiniteStateMachines;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// A service specification consists of an interface ID and a signature ID.
	/// </summary>
	/// <remarks><pre>
	/// $Log$
	/// Revision 1.1.2.1  2004/11/16 13:37:47  uffi
	/// Initial commit of the 2.0 version of the component model. BETA!!! See the techreport (to be updated) for details.
	/// Documentation needs fixing. Some unittests fail.
	///
	/// Revision 1.5  2004/09/02 12:50:05  uffi
	/// Added XML Serialization and Deserialization functionality
	///
	/// Revision 1.4  2004/06/09 12:36:30  sbecker
	/// Fixed documentation and renamed IExternalSignature
	///
	/// Revision 1.3  2004/06/03 14:37:28  sbecker
	/// Added the possibility to attach auxiliary specifications to a basic component
	///
	/// Revision 1.2  2004/06/02 19:41:31  sbecker
	/// Fixed docu
	///
	/// Revision 1.1  2004/06/02 14:50:24  sbecker
	/// Initial Import after a major rework
	///
	///
	/// </pre></remarks>
	public interface IService : ICloneable, IMatchable, ISerializable, IIdentifiable
	{
		/// <summary>
		/// The signature
		/// </summary>
		ISignature Signature
		{
			get;
		}

		/// <summary>
		/// The external role used to identify the signature uniquely
		/// </summary>
		IInterfaceModel Interface
		{
			get;
		}
	}
}
