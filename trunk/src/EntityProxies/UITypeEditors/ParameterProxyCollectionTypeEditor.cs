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
	/// Zusammenfassung für ParameterProxyCollectionTypeEditor.
	/// </summary>
	public class ParameterProxyCollectionTypeEditor : UITypeEditor
	{
		public override object EditValue(System.ComponentModel.ITypeDescriptorContext context, IServiceProvider provider, object value)
		{
			SignatureProxy sigProxy = context.Instance as SignatureProxy;
			Dialogs.ParameterProxyCollectionForm dialog = new Dialogs.ParameterProxyCollectionForm(sigProxy);
			dialog.ShowDialog();
			return value;
		}

		public override UITypeEditorEditStyle GetEditStyle(System.ComponentModel.ITypeDescriptorContext context)
		{
			return UITypeEditorEditStyle.Modal;
		}

	}
}
