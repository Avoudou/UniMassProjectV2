package graphicsUI;

import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PrintOutputInfo extends JPanel {
	private RunTimeData runtimeData;
	private JTextArea outInfo = new JTextArea("output info : ");

	public PrintOutputInfo(RunTimeData runtimeData) {
		this.runtimeData = runtimeData;
		add(outInfo);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// g.drawString(runtimeData.getOutputInfo(), 10, 10);
		outInfo.setBounds(40, 20, 400, 100);

	}

	public void setOutinfo(String info) {

		System.out.println(runtimeData);
		System.out.println(runtimeData.getOutputInfo());
		outInfo.setText(runtimeData.getOutputInfo());

	}

}
