using System.Collections;
using System.Drawing;
using Palladio.Reliability.Functions;

namespace Palladio.Reliability.Visualisation
{
	/// <summary>
	/// </summary>
	public class FunctionRenderer
	{
		private Graphics graphics;

		/// <summary>
		/// key - label:string
		/// value - FunctionInfo
		/// </summary>
		private Hashtable functionInfo;

		private double xMax, xMin, yMax, yMin;
		private int top, left, bottom, right;
		private Color background;
		private float accuracy;
		private int coordinateWidth;
		private Font font;
		private float coordinateDetail;

		public Graphics Graphics
		{
			get { return graphics; }
			set { graphics = value; }
		}

		public int CoordinateWidth
		{
			get { return coordinateWidth; }
			set { coordinateWidth = value; }
		}

		public float CoordinateDetail
		{
			get { return coordinateDetail; }
			set { coordinateDetail = value; }
		}

		public Font Font
		{
			get { return font; }
			set { font = value; }
		}

		public float Accuracy
		{
			get { return accuracy; }
			set { accuracy = value; }
		}

		public int Width
		{
			get { return System.Math.Abs(Right - Left); }
		}

		public int Height
		{
			get { return System.Math.Abs(Bottom - Top); }
		}

		public int Top
		{
			get { return top; }
			set { top = value; }
		}

		public int Left
		{
			get { return left; }
			set { left = value; }
		}

		public int Bottom
		{
			get { return bottom; }
			set { bottom = value; }
		}

		public int Right
		{
			get { return right; }
			set { right = value; }
		}

		public int InnerWidth
		{
			get { return InnerRight - InnerLeft; }
		}

		public int InnerHeight
		{
			get { return InnerBottom - InnerTop; }
		}

		public int InnerRight
		{
			get { return Right - CoordinateWidth; }
		}

		public int InnerLeft
		{
			get { return Left + CoordinateWidth; }
		}

		public int InnerTop
		{
			get { return Top + CoordinateWidth; }
		}

		public int InnerBottom
		{
			get { return Bottom - CoordinateWidth; }
		}

		public Color Background
		{
			get { return background; }
			set { background = value; }
		}

		public double Domain
		{
			get { return System.Math.Abs(XMax - XMin); }
		}

		public double Image
		{
			get { return System.Math.Abs(YMax - YMin); }
		}

		public double XMax
		{
			get { return xMax; }
			set { xMax = value; }
		}

		public double XMin
		{
			get { return xMin; }
			set { xMin = value; }
		}

		public double YMax
		{
			get { return yMax; }
			set { yMax = value; }
		}

		public double YMin
		{
			get { return yMin; }
			set { yMin = value; }
		}

		public void AddFunction(IRealFunction function, Pen pen, string label)
		{
			FunctionInfo funcInfo = new FunctionInfo();
			funcInfo.Function = function;
			funcInfo.Pen = pen;
			funcInfo.Label = label;
			functionInfo.Remove(label);
			functionInfo.Add(label, funcInfo);
		}

		public void RemoveAll()
		{
			functionInfo.Clear();
		}

		public void RemoveFunction(string label)
		{
			functionInfo.Remove(label);
		}

		public void Draw()
		{
			graphics.Clear(background);
			DrawCoordinates();
			DrawLegend();
			foreach (FunctionInfo info in functionInfo.Values)
			{
				DrawFunction(info);
			}
		}

		public FunctionRenderer( Graphics graphics)
		{
			this.graphics = graphics;
			this.functionInfo = new Hashtable();
			xMin = 0;
			yMin = 0;
			xMax = 10;
			yMax = 1;
			top = 0;
			left = 0;
			right = 640;
			bottom = 480;
			background = Color.White;
			accuracy = 0.01f;
			coordinateWidth = 50;
			font = new Font("Arial", 9);
			coordinateDetail = 0.2f;
		}

		private void DrawLegend()
		{
			float fontOffset = font.GetHeight(graphics)/2;
			float xPos = InnerLeft + 4f/5f*InnerWidth;
			float yPos = InnerTop + 1f/20f*InnerHeight;
			float lineLength = 20;
			float distance = 5;
			foreach (FunctionInfo info in functionInfo.Values)
			{
				graphics.DrawLine(info.Pen, xPos, yPos + fontOffset, xPos + lineLength, yPos + fontOffset);
				graphics.DrawString(info.Label, font, Brushes.Black, xPos + lineLength + distance, yPos);
				yPos += 3*fontOffset;
			}
		}

		private void DrawFunction(FunctionInfo info)
		{
			float xValInc = (float) Domain*Accuracy;
			float xPosInc = InnerWidth*Accuracy;
			float yPosInc = InnerHeight/(float) Image;

			float yPosOld = 0;
			float yPos = (float) info.Function[xMin]*yPosInc;
			float xPos = InnerLeft + xPosInc; // start at position x+1
			float x = (float) XMin + xValInc;

			while (xPos < InnerRight + 0.1) // +0.1 added to tolerate some rounding error.
			{
				yPosOld = yPos;
				yPos = (float) info.Function[x]*yPosInc;
				graphics.DrawLine(info.Pen, xPos - xPosInc, InnerBottom - yPosOld, xPos, InnerBottom - yPos);
				x += xValInc;
				xPos += xPosInc;
			}
		}

		private void DrawCoordinates()
		{
			StringFormat drawFormat = new StringFormat();
			float fontOffset = font.GetHeight(graphics)/2;

			Pen pen = Pens.Black;
			float lineLength = 6;
			float distance = 3;
			float xValInc = coordinateDetail*(float) Domain;
			float yValInc = coordinateDetail*(float) Image;
			float xPosInc = coordinateDetail*InnerWidth;
			float yPosInc = coordinateDetail*InnerHeight;
			float xVal = (float) XMin;
			float yVal = (float) YMin;
			float xPos = InnerLeft;
			float yPos = InnerBottom;

			float coordPos = 0;

			while (coordPos < 1.01)
			{
				graphics.DrawLine(pen, xPos, InnerBottom, xPos, InnerBottom + lineLength);
				graphics.DrawLine(pen, InnerLeft, yPos, InnerLeft - lineLength, yPos);

				drawFormat.Alignment = StringAlignment.Center;
				graphics.DrawString(System.Math.Round(xVal,2).ToString(), font, Brushes.Black, xPos, InnerBottom + lineLength + distance, drawFormat);
				drawFormat.Alignment = StringAlignment.Far;
				graphics.DrawString(System.Math.Round(yVal,2).ToString(), font, Brushes.Black, InnerLeft - lineLength - distance, yPos - fontOffset, drawFormat);

				xPos += xPosInc;
				yPos -= yPosInc;
				xVal += xValInc;
				yVal += yValInc;
				coordPos += coordinateDetail;
			}
			graphics.DrawLine(pen, InnerLeft, InnerTop, InnerLeft, InnerBottom);
			graphics.DrawLine(pen, InnerLeft, InnerBottom, InnerRight, InnerBottom);
		}

		private struct FunctionInfo
		{
			private IRealFunction function;
			private Pen pen;
			private string label;

			public IRealFunction Function
			{
				get { return function; }
				set { function = value; }
			}

			public Pen Pen
			{
				get { return pen; }
				set { pen = value; }
			}

			public string Label
			{
				get { return label; }
				set { label = value; }
			}
		}
	}
}