// 
// Palladio Interface
// $Id$
//
using System;

namespace Palladio.DeploymentModel
{
	/// <summary>
	/// </summary>
	public interface IElementConnection
	{
		ICharacterisedElement Source { get; set; }
		ICharacterisedElement Destination { get; set; }
	}
}
