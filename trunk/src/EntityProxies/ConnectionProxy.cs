using System;

using Palladio.ComponentModel;

namespace Palladio.Editor.Common.EntityProxies
{
	/// <summary>
	/// Zusammenfassung für ConnectionProxy.
	/// </summary>
	public abstract class ConnectionProxy : EntityProxy
	{
		public ConnectionProxy(CommandHandler cmdHandler, IConnection conn, AttributeProvider attrProv)
			: base(cmdHandler, conn, attrProv)
		{

		}
	}
}
