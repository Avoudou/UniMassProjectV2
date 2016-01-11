package graphicsUI;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class CentralPanel extends JPanel {
	private RunTimeData runtimeData;
	private UIWindow aUIWindow;

	public CentralPanel(RunTimeData runtimeData, UIWindow aUIWindow) {
		this.aUIWindow = aUIWindow;
		this.runtimeData = runtimeData;
		setLayout(new BorderLayout(3, 1));
		add(new CargoSetCustomPanel(runtimeData), 0);
		add(new CargoSetWeightsPanel(runtimeData), 1);

	}

}
