// 
// Palladio Interface
// $Id$
//
using System;
using Palladio.Identifier;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// Summary description for IRole.
	/// </summary>
	/// <remarks><pre>
	/// $Log$
	/// Revision 1.1  2004/06/02 14:50:24  sbecker
	/// Initial Import after a major rework
	///
	///
	/// </pre></remarks>
	public interface IRole : IIdentifiable, ICloneable
	{
		IInterfaceModel Interface
		{
			get;
		}
	}
}
