using System;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.Windows.Forms;
using log4net;

namespace Palladio.Editor.Common.EntityProxies.UITypeEditors.Dialogs
{
	/// <summary>
	/// Zusammenfassung für EntityProxyCollectionForm.
	/// </summary>
	public abstract class EntityProxyCollectionForm : System.Windows.Forms.Form
	{
		protected override void OnLoad(System.EventArgs e)
		{
			base.OnLoad (e);
			EntityProxyCollectionFormRegistrar.RegisterForm(this);
		}


		protected override void OnClosed(System.EventArgs e)
		{
			base.OnClosed (e);
			EntityProxyCollectionFormRegistrar.UnregisterForm(this);
		}

		public abstract EntityProxy Proxy{ get; set; }
	}

	public class EntityProxyCollectionFormRegistrar
	{
		/// <summary>
		/// log4net logging service</summary>
		private static readonly ILog log = LogManager.GetLogger(typeof(EntityProxyCollectionFormRegistrar));

		private static Hashtable _forms = new Hashtable();

		public static void RegisterForm(EntityProxyCollectionForm form)
		{
			_forms[form.Proxy] = form;
		}

		public static void UnregisterForm(EntityProxyCollectionForm form)
		{
			_forms.Remove(form.Proxy);
		}

		public static bool UpdateProxyInForm(EntityProxy oldProxy, EntityProxy newProxy)
		{
			if (!_forms.ContainsKey(oldProxy))
				return false;
			EntityProxyCollectionForm form = _forms[oldProxy] as EntityProxyCollectionForm;
			form.Proxy = newProxy;
			_forms.Remove(oldProxy);
			_forms[newProxy] = form;
			return true;
		}
	}
}
