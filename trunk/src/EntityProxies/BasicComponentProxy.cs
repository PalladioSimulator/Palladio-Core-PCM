#region Universität Oldenburg
//////////////////////////////////////////////////////////////////////////
//	Universität Oldenburg
//	Department für Informatik, Software Engineering
//	-----------------------------------------------------------------
//	Master-Arbeit "Entwicklung eines Editors für die modellgetriebene
//	Konstruktion komponentenbasierter Software-Architekturen"
//	Autor: Matthias Uflacker, 2004
//	eMail: matthias.uflacker@informatik.uni-oldenburg.de
//////////////////////////////////////////////////////////////////////////
#endregion

using System;
using System.ComponentModel;

using Palladio.Identifier; 
using Palladio.ComponentModel;

namespace Palladio.Editor.Common.EntityProxies
{
	/// <summary>
	/// Zusammenfassung für BasicComponentProxy.
	/// </summary>
	public class BasicComponentProxy : ComponentProxy
	{
		protected new IBasicComponent _component;

		public BasicComponentProxy(IBasicComponent component, CommandHandler cmdHandler, RoleProxy[] provided, RoleProxy[] required)
			: base(component, cmdHandler, provided, required)
		{
			this._component = component;

		}
	}
}
