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
using System.Drawing.Design;

using Palladio.Editor.Common.EntityProxies;

namespace Palladio.Editor.Common.EntityProxies.UITypeEditors
{
	/// <summary>
	/// Zusammenfassung für CompositeComponentProxyCollectionEditor.
	/// </summary>
	public class ComponentProxyCollectionTypeEditor : UITypeEditor
	{
		public override object EditValue(System.ComponentModel.ITypeDescriptorContext context, IServiceProvider provider, object value)
		{
			Dialogs.ComponentProxyCollectionForm dialog = null;
			if ( context.PropertyDescriptor.DisplayName.Equals("CompositeComponents") )
				dialog = new Dialogs.ComponentProxyCollectionForm(context.Instance as CompositeComponentProxy, false);
			else if ( context.PropertyDescriptor.DisplayName.Equals("BasicComponents") )
				dialog = new Dialogs.ComponentProxyCollectionForm(context.Instance as CompositeComponentProxy, true);
			else
				return value;
			dialog.ShowDialog();
			return value;
		}

		public override UITypeEditorEditStyle GetEditStyle(System.ComponentModel.ITypeDescriptorContext context)
		{
			return UITypeEditorEditStyle.Modal;
		}

	}
}
