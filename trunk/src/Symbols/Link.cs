using System;
using System.Drawing;

using Syncfusion.Windows.Forms.Diagram;

namespace Palladio.Editor.Plugins.StaticView.Symbols
{
	/// <summary>
	/// Zusammenfassung für Link.
	/// </summary>
	public class Link : Syncfusion.Windows.Forms.Diagram.Link
	{
		private object _tag;

		public Link(PointF[] pts)
			: base(Link.Shapes.Polyline, pts)
		{
			this.LineStyle.DashStyle = System.Drawing.Drawing2D.DashStyle.Dot;
			this.LineStyle.LineWidth = 1;
			this.EditStyle.AllowMove = false;
			this.EditStyle.AllowResize = false;
			this.EditStyle.AllowVertexEdit = true;
		}

		public object Tag
		{
			get
			{
				return this._tag;
			}
			set
			{
				this._tag = value;
			}
		}
	}
}
