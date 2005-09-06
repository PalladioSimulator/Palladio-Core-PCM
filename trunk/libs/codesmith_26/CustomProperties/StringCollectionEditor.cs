//------------------------------------------------------------------------------
//
// Copyright (c) 2002-2004 Eric J. Smith.  All rights reserved.
// 
// The terms of use for this software are contained in the file
// named sourcelicense.txt, which can be found in the root of this distribution.
// By using this software in any fashion, you are agreeing to be bound by the
// terms of this license.
// 
// You must not remove this notice, or any other, from this software.
//
//------------------------------------------------------------------------------

using System;
using System.ComponentModel;
using System.Windows.Forms;
using System.Windows.Forms.Design;
using System.Drawing.Design;

namespace CodeSmith.CustomProperties
{
	public class StringCollectionEditor : UITypeEditor
	{
		private IWindowsFormsEditorService editorService = null;
		private StringCollectionEditorUI _stringCollectionEditorUI = null;
		
		public StringCollectionEditor(): base()
		{
		}
		
		public override object EditValue(ITypeDescriptorContext context, IServiceProvider provider, object value) 
		{
			if (provider != null)
			{
				editorService = (IWindowsFormsEditorService)provider.GetService(typeof(IWindowsFormsEditorService));
				if (editorService != null) 
				{
					if (_stringCollectionEditorUI == null) _stringCollectionEditorUI = new StringCollectionEditorUI();
					_stringCollectionEditorUI.Start(editorService, value);
					editorService.ShowDialog(_stringCollectionEditorUI);
					if (_stringCollectionEditorUI.DialogResult == DialogResult.OK)
					{
						value = _stringCollectionEditorUI.StringCollection;
					}
					_stringCollectionEditorUI.End();
				}
			}
			
			return value;
		}
		
		public override UITypeEditorEditStyle GetEditStyle(ITypeDescriptorContext context) 
		{
			return UITypeEditorEditStyle.Modal;
		}
	}
}
