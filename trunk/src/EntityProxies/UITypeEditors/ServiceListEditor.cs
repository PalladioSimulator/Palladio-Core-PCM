using System;
using System.Drawing.Design;

using Palladio.Editor.Common.EntityProxies;

namespace Palladio.Editor.Common.EntityProxies.UITypeEditors
{
	/// <summary>
	/// Zusammenfassung für ServiceListEditor.
	/// </summary>
	public class ServiceListEditor : UITypeEditor
	{
		public override object EditValue(System.ComponentModel.ITypeDescriptorContext context, IServiceProvider provider, object value)
		{
			Dialogs.ServiceListEditorForm dialog = new Dialogs.ServiceListEditorForm(context.Instance as ServiceEffectSpecificationProxy);
			dialog.ShowDialog();
			return value;
		}

		public override UITypeEditorEditStyle GetEditStyle(System.ComponentModel.ITypeDescriptorContext context)
		{
			return UITypeEditorEditStyle.Modal;
		}
	}
}
