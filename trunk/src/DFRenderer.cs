using System;
using System.Collections;
using System.ComponentModel;
using System.Drawing;
using System.Windows.Forms;
using MathNet.Numerics;
using Palladio.FiniteStateMachines;
using Palladio.Math;
using Palladio.Reliability.Attributes;
using Palladio.Reliability.ExecutionTime;
using Palladio.Math.Fourier;
using Palladio.Math.Functions;
using Palladio.Reliability.Paths;
using Palladio.Reliability.Tests;
using Palladio.Reliability.TypedCollections;

namespace Palladio.Reliability.Visualisation
{
	/// <summary>
	/// Zusammenfassung für Form1.
	/// </summary>
	public class DFRenderer : Form
	{
		private Label topLabel;
		private Panel renderPanel;
		private Button runButton;

		/// <summary>
		/// Erforderliche Designervariable.
		/// </summary>
		private Container components = null;

		private Button calcButton;
		private Button expButton;
		private Button clearButton;

		private FunctionRenderer renderer;
		private Button testButton;
		private Button trellisButton;
		private Button bruteForceButton;
		private IFiniteStateMachine fsm;

		public DFRenderer()
		{
			InitializeComponent();
			fsm = TestBuilder.CreateTestMarkovModel3();
			renderer = new FunctionRenderer(renderPanel.CreateGraphics());
			renderer.Right = renderPanel.Size.Width;
			renderer.Bottom = renderPanel.Size.Height;
			renderer.XMax = 25;
			renderer.Accuracy = 0.001f;
		}

		/// <summary>
		/// Die verwendeten Ressourcen bereinigen.
		/// </summary>
		protected override void Dispose(bool disposing)
		{
			if (disposing)
			{
				if (components != null)
				{
					components.Dispose();
				}
			}
			base.Dispose(disposing);
		}

		#region Vom Windows Form-Designer generierter Code

		/// <summary>
		/// Erforderliche Methode für die Designerunterstützung. 
		/// Der Inhalt der Methode darf nicht mit dem Code-Editor geändert werden.
		/// </summary>
		private void InitializeComponent()
		{
			this.renderPanel = new Panel();
			this.topLabel = new Label();
			this.runButton = new Button();
			this.calcButton = new Button();
			this.expButton = new Button();
			this.clearButton = new Button();
			this.testButton = new Button();
			this.trellisButton = new Button();
			this.bruteForceButton = new Button();
			this.SuspendLayout();
			// 
			// renderPanel
			// 
			this.renderPanel.Anchor = ((AnchorStyles) ((((AnchorStyles.Top | AnchorStyles.Bottom)
				| AnchorStyles.Left)
				| AnchorStyles.Right)));
			this.renderPanel.BackColor = SystemColors.ControlLightLight;
			this.renderPanel.Location = new Point(8, 40);
			this.renderPanel.Name = "renderPanel";
			this.renderPanel.Size = new Size(952, 640);
			this.renderPanel.TabIndex = 0;
			this.renderPanel.Paint += new PaintEventHandler(this.renderPanel_Paint);
			// 
			// topLabel
			// 
			this.topLabel.Anchor = ((AnchorStyles) (((AnchorStyles.Top | AnchorStyles.Left)
				| AnchorStyles.Right)));
			this.topLabel.BackColor = SystemColors.ControlDark;
			this.topLabel.Font = new Font("Microsoft Sans Serif", 7.8F, FontStyle.Bold, GraphicsUnit.Point, ((Byte) (0)));
			this.topLabel.Location = new Point(8, 8);
			this.topLabel.Name = "topLabel";
			this.topLabel.Size = new Size(952, 23);
			this.topLabel.TabIndex = 1;
			this.topLabel.Text = "Density Function";
			this.topLabel.TextAlign = ContentAlignment.MiddleLeft;
			// 
			// runButton
			// 
			this.runButton.Anchor = ((AnchorStyles) ((AnchorStyles.Bottom | AnchorStyles.Right)));
			this.runButton.Location = new Point(864, 696);
			this.runButton.Name = "runButton";
			this.runButton.Size = new Size(96, 32);
			this.runButton.TabIndex = 2;
			this.runButton.Text = "Run";
			this.runButton.Click += new EventHandler(this.runButton_Click);
			// 
			// calcButton
			// 
			this.calcButton.Anchor = ((AnchorStyles) ((AnchorStyles.Bottom | AnchorStyles.Right)));
			this.calcButton.Location = new Point(760, 696);
			this.calcButton.Name = "calcButton";
			this.calcButton.Size = new Size(96, 32);
			this.calcButton.TabIndex = 3;
			this.calcButton.Text = "Calculate";
			this.calcButton.Click += new EventHandler(this.calcButton_Click);
			// 
			// expButton
			// 
			this.expButton.Anchor = ((AnchorStyles) ((AnchorStyles.Bottom | AnchorStyles.Right)));
			this.expButton.Location = new Point(640, 696);
			this.expButton.Name = "expButton";
			this.expButton.Size = new Size(112, 32);
			this.expButton.TabIndex = 4;
			this.expButton.Text = "Exp Distribution";
			this.expButton.Click += new EventHandler(this.expButton_Click);
			// 
			// clearButton
			// 
			this.clearButton.Anchor = ((AnchorStyles) ((AnchorStyles.Bottom | AnchorStyles.Left)));
			this.clearButton.Location = new Point(16, 696);
			this.clearButton.Name = "clearButton";
			this.clearButton.Size = new Size(96, 32);
			this.clearButton.TabIndex = 5;
			this.clearButton.Text = "Clear";
			this.clearButton.Click += new EventHandler(this.clearButton_Click);
			// 
			// testButton
			// 
			this.testButton.Anchor = ((AnchorStyles) ((AnchorStyles.Bottom | AnchorStyles.Right)));
			this.testButton.Location = new Point(536, 696);
			this.testButton.Name = "testButton";
			this.testButton.Size = new Size(96, 32);
			this.testButton.TabIndex = 6;
			this.testButton.Text = "Test";
			this.testButton.Click += new EventHandler(this.testButton_Click);
			// 
			// trellisButton
			// 
			this.trellisButton.Location = new Point(424, 696);
			this.trellisButton.Name = "trellisButton";
			this.trellisButton.Size = new Size(104, 32);
			this.trellisButton.TabIndex = 7;
			this.trellisButton.Text = "Trellis";
			this.trellisButton.Click += new EventHandler(this.trellisButton_Click);
			// 
			// bruteForceButton
			// 
			this.bruteForceButton.Location = new Point(320, 696);
			this.bruteForceButton.Name = "bruteForceButton";
			this.bruteForceButton.Size = new Size(96, 32);
			this.bruteForceButton.TabIndex = 8;
			this.bruteForceButton.Text = "Brute Force";
			this.bruteForceButton.Click += new EventHandler(this.bruteForceButton_Click);
			// 
			// DFRenderer
			// 
			this.AutoScaleBaseSize = new Size(6, 15);
			this.ClientSize = new Size(968, 736);
			this.Controls.Add(this.bruteForceButton);
			this.Controls.Add(this.trellisButton);
			this.Controls.Add(this.testButton);
			this.Controls.Add(this.clearButton);
			this.Controls.Add(this.expButton);
			this.Controls.Add(this.calcButton);
			this.Controls.Add(this.runButton);
			this.Controls.Add(this.topLabel);
			this.Controls.Add(this.renderPanel);
			this.Name = "DFRenderer";
			this.Text = "DFRenderer";
			this.Resize += new EventHandler(this.DFRenderer_Resize);
			this.Load += new EventHandler(this.DFRenderer_Load);
			this.ResumeLayout(false);

		}

		#endregion

		/// <summary>
		/// Der Haupteinstiegspunkt für die Anwendung.
		/// </summary>
		[STAThread]
		private static void Main()
		{
			Application.Run(new DFRenderer());
		}


		private struct StateInfo
		{
			private IState state;
			private IFunction densityFunction;
			private double p;

			public IState State
			{
				get { return state; }
				set { state = value; }
			}

			public IFunction DensityFunction
			{
				get { return densityFunction; }
				set { densityFunction = value; }
			}

			public double P
			{
				get { return p; }
				set { p = value; }
			}

			public StateInfo(IState state, IFunction densityFunction, double p)
			{
				this.state = state;
				this.densityFunction = densityFunction;
				this.p = p;
			}
		}

//		private Complex[] ToComplex(double[] data)
//		{
//			Complex[] cdata = new Complex[data.Length];
//			for (int i=0; i<data.Length; i++)
//			{
//				cdata[i] = Complex.FromRealImaginary(data[i], 0);
//			}
//			return cdata;
//		}
//
		private void runButton_Click(object sender, EventArgs e)
		{
			MathTools.DiscreteFunctions.SamplingRate = 0.1;
			MathTools.DiscreteFunctions.XMax = 25;
			IDiscreteFunction f = MathTools.DiscreteFunctions.ExponentialDistribution(1) as IDiscreteFunction;
			
			Complex[] fd = MathTools.SimpleFourierTransform.ForwardFromReal(f.Data);

			for (int i = 0; i < fd.Length; i++)
			{
				fd[i] =  fd[i] * fd[i];
			}

			Complex[] d = MathTools.SimpleFourierTransform.Backward(fd);

			for (int i = 0; i < d.Length; i++)
			{
				f.Data[i] = d[i].Real * 0.1;
			}
			renderer.AddFunction(f,Pens.Blue,"Fourier - Convolution");

			IFunction g = MathTools.DiscreteFunctions.ExponentialDistribution(1.0);
			g = g.Convolution(g);
			renderer.AddFunction(g,Pens.Red,"Plain - Convolution");
			renderer.Draw();

		}

//
//		private double[] ToDouble(Complex[] cdata)
//		{
//			double[] data = new double[cdata.Length];
//			for(int i=0; i<cdata.Length; i++)
//			{
//				data[i] = cdata[i].Real;
//			}
//			return data;
//		}


		private void calcButton_Click(object sender, EventArgs e)
		{
			IFsmElement time = TimeOperations.FSMExecutionTime(fsm);
			IFunction g = time.TimeDensityFunction;
			renderer.AddFunction(g, Pens.Blue, "Calculated");
			renderer.Draw();
		}

		private void renderPanel_Paint(object sender, PaintEventArgs e)
		{
			renderer.Draw();
		}

		private void DFRenderer_Resize(object sender, EventArgs e)
		{
			renderer.Graphics = renderPanel.CreateGraphics();
			renderer.Right = renderPanel.Size.Width;
			renderer.Bottom = renderPanel.Size.Height;
			renderer.Draw();
		}

		private void expButton_Click(object sender, EventArgs e)
		{
			MathTools.DiscreteFunctions.SamplingRate = 0.01;
			MathTools.DiscreteFunctions.XMax = 20;
			IFunction f = MathTools.DiscreteFunctions.ExponentialDistribution(1.0);
			//IFunction F = f.Integral();
//			IFunction g = f.Convolution(f);
//			IFunction G = g.Integral();

			renderer.AddFunction(f, Pens.Green, "Exp Distribution");
//			renderer.AddFunction(F, Pens.Green, "Integral Exp");
//			renderer.AddFunction(g, Pens.Blue, "Convolution");
//			renderer.AddFunction(G, Pens.Blue, "Integral Conv");
			renderer.Draw();
		}

		private void clearButton_Click(object sender, EventArgs e)
		{
			renderer.RemoveAll();
			renderer.Draw();
		}

		private void DFRenderer_Load(object sender, EventArgs e)
		{
		}

		private void testButton_Click(object sender, EventArgs e)
		{
			IFSMPaths paths = new FSMPaths(fsm);
			IPathElement fp = TimeOperations.PathExecutionTime(paths.FinalPaths[0]);
			IPathElement[] cp = new IPathElement[2];
			cp[0] = TimeOperations.PathExecutionTime(paths.CyclicPaths[0]);
			cp[1] = TimeOperations.PathExecutionTime(paths.CyclicPaths[1]);
			IExecutionElement innerCycle;

			if (fp.Path.Overlaps(cp[0].Path))
			{
				ICyclicElement cycle = TimeOperations.Cycle(cp[1]);
				innerCycle = TimeOperations.Sum(cp[0], TimeOperations.Sequence(cp[0], cycle, cycle.Probability)); // / cycle.Probability ));
				innerCycle.TimeDensityFunction.Scale(cp[0].Probability);
			}
			else
			{
				ICyclicElement cycle = TimeOperations.Cycle(cp[0]);
				innerCycle = TimeOperations.Sum(cp[1], TimeOperations.Sequence(cp[1], cycle, 1)); // / cycle.Probability ));
				innerCycle.TimeDensityFunction.Scale(cp[1].Probability);
			}

			renderer.AddFunction(innerCycle.TimeDensityFunction, Pens.Black, "inner");

			IExecutionElement total = TimeOperations.Sum(fp, TimeOperations.Sequence(fp, TimeOperations.Cycle(innerCycle), 1.0));
			total.TimeDensityFunction.Scale(fp.Probability);


			renderer.AddFunction(total.TimeDensityFunction, Pens.Blue, "Cycles on cycles");
			renderer.Draw();
		}

		private void trellisButton_Click(object sender, EventArgs e)
		{
			double pTotal = 0.0;
			long numPaths = 0;
			long level = 0;
			double pConfidence = 0.99;
			IFunction dfTotal = null;

			StateTimeTable currentTimes = new StateTimeTable();
			currentTimes[fsm.StartState] = TimeOperations.StateExecutionTime(fsm.StartState);

			while (pTotal <= pConfidence)
			{
				StateTimeTable nextTimes = new StateTimeTable();
				foreach (IState state in currentTimes.Keys)
				{
					if (fsm.IsFinalState(state))
					{
						pTotal += currentTimes[state].Probability;
						if (dfTotal == null)
							dfTotal = currentTimes[state].TimeDensityFunction;
						else
							dfTotal.Add(currentTimes[state].TimeDensityFunction);

						renderer.AddFunction(dfTotal, Pens.Blue, "Trellis");
						renderer.Draw();

						Console.WriteLine(++numPaths + "\t" + pTotal + "\tProb:\t" + currentTimes[state].Probability);
					}
					else
					{
						foreach (ITransition transition in fsm.GetOutgoingTransitions(state))
						{
							IState destState = transition.DestinationState;
							double probability = ProbabilityAttribute.GetAttribute(transition).Probability;

							if (nextTimes[destState] == null)
								nextTimes[destState] = currentTimes[state].Scale(probability);
							else
								nextTimes[destState] = TimeOperations.Sum(nextTimes[destState], currentTimes[state].Scale(probability));
						}
					}
				}

				foreach (IState state in fsm.States)
				{
					if (nextTimes[state] != null)
					{
						IExecutionElement stateTime = TimeOperations.StateExecutionTime(state);
						nextTimes[state] = TimeOperations.Sequence(nextTimes[state], stateTime, 1.0);
					}
				}
				currentTimes = nextTimes;
				Console.WriteLine("Level:\t" + ++level + "\tStackSize:\t" + currentTimes.Count);
			}
			IFunction F = dfTotal.Integral();
			renderer.AddFunction(F, Pens.Blue, "Integral");
			renderer.Draw();
		}

		private struct StateTime
		{
			public IState State;
			public IExecutionElement Time;

			public StateTime(IState state, IExecutionElement time)
			{
				State = state;
				Time = time;
			}
		}

		private void bruteForceButton_Click(object sender, EventArgs e)
		{
			Stack currentStates = new Stack();
			StateTime st = new StateTime(fsm.StartState, TimeOperations.StateExecutionTime(fsm.StartState));
			currentStates.Push(st);
			double pTotal = 0.0;
			long numPaths = 0;
			long level = 0;
			double pConfidence = 0.95;
			IFunction dfTotal = null;

			while (pTotal <= pConfidence)
			{
				Stack nextStates = new Stack();
				foreach (StateTime time in currentStates)
				{
					foreach (ITransition transition in fsm.GetOutgoingTransitions(time.State))
					{
						StateTime nextTime = new StateTime(
							transition.DestinationState,
							TimeOperations.Sequence(
								time.Time,
								TimeOperations.StateExecutionTime(transition.DestinationState),
								ProbabilityAttribute.GetAttribute(transition).Probability
								)
							);

						if (fsm.IsFinalState(nextTime.State))
						{
							pTotal += nextTime.Time.Probability;
							nextTime.Time.TimeDensityFunction.Scale(nextTime.Time.Probability);
							if (dfTotal == null)
								dfTotal = nextTime.Time.TimeDensityFunction;
							else
								dfTotal.Add(nextTime.Time.TimeDensityFunction);

							renderer.AddFunction(dfTotal, Pens.Green, "Brute Force, new");
							renderer.Draw();

							Console.WriteLine(++numPaths + "\t" + pTotal + "\tProb:\t" + nextTime.Time.Probability);
							if (pTotal > pConfidence)
								break;
						}
						else
						{
							nextStates.Push(nextTime);
						}
					}
					if (pTotal > pConfidence)
						break;
				}
				currentStates = nextStates;
				Console.WriteLine("Level:\t" + ++level + "\tStackSize:\t" + currentStates.Count);
			}
			IFunction F = dfTotal.Integral();
			renderer.AddFunction(F, Pens.Green, "BF - Integral");
			renderer.Draw();
		}
	}
}