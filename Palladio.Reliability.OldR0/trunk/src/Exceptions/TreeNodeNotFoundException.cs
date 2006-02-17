/*
 * Created by SharpDevelop.
 * User: sliver
 * Date: 02.07.2004
 * Time: 11:13
 * 
 */

using System;
using Palladio.Identifier;

namespace Palladio.Reliability.Exceptions
{
	/// <summary>
	/// Description of TreeNodeNotFoundException.	
	/// </summary>
	public class TreeNodeNotFoundException : ApplicationException
	{
		public TreeNodeNotFoundException(IIdentifier id) : base("Node '" + id + "' could not be found!")
		{
		}
	}
}