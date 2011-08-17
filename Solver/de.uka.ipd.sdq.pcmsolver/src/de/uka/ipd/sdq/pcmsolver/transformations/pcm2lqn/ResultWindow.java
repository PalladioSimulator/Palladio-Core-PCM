package de.uka.ipd.sdq.pcmsolver.transformations.pcm2lqn;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ResultWindow {

	JFrame frame;

	public ResultWindow(String text) {
		JTextArea textArea = new JTextArea(5, 20);
		textArea.setEditable(false);
		textArea.setText(text);

		Font font = new Font("Monospaced", Font.PLAIN, 12);
		textArea.setFont(font);

		JScrollPane scrollPane = new JScrollPane(textArea,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		frame = new JFrame("LQN Output");
		frame.getContentPane().add(scrollPane);
		frame.setExtendedState(frame.getExtendedState() | frame.MAXIMIZED_BOTH);

		
//		frame.setSize(800, 600);
//		frame.setLocation(
//				(Toolkit.getDefaultToolkit().getScreenSize().width - frame
//						.getSize().width) / 2, (Toolkit.getDefaultToolkit()
//						.getScreenSize().height - frame.getSize().height) / 2);
	}

	public void open() {
		frame.setVisible(true);
	}
}
