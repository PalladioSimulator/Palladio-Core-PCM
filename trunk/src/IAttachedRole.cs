// 
// Palladio Interface
// $Id$
//
using System;
using Palladio.Identifier;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// Summary description for IAttachedInterface.
	/// </summary>
	/// <remarks><pre>
	/// $Log$
	/// Revision 1.1  2004/06/02 14:50:24  sbecker
	/// Initial Import after a major rework
	///
	///
	/// </pre></remarks>
	public interface IAttachedRole
	{
		IIdentifier RoleID
		{
			get;
		}

		IIdentifier ComponentID
		{
			get;
		}

		IComponent Component
		{
			get;
		}

		IRole Role
		{
			get;
		}
	}
}
