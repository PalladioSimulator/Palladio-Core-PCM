using System;
using System.Collections;
using ReflectionBasedVisitor;
using Palladio.Attributes;

namespace Palladio.ComponentModel.Connections
{
	/// <summary>
	/// Connects the RequiresInterface of one component to the ProvidesInterfaces
	/// of another.
	/// </summary>
	internal class DefaultBinding : DefaultConnection, IBinding
	{
		public DefaultBinding(IAttributeHash anAttHash, IAttachedRole aFirstIface, IAttachedRole aSecondIface) : base(anAttHash,aFirstIface,aSecondIface) {}
	}
}
