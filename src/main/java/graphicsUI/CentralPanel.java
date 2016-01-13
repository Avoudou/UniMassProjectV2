package graphicsUI;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class CentralPanel extends JPanel {
	private RunTimeData runtimeData;
	private UIWindow aUIWindow;
	private PrintOutputInfo printOutInfo = new PrintOutputInfo(runtimeData);
	private CargoSetWeightsPanel setWeights;

	public CentralPanel(RunTimeData runtimeData, UIWindow aUIWindow) {
		this.aUIWindow = aUIWindow;
		this.runtimeData = runtimeData;
		this.printOutInfo = new PrintOutputInfo(runtimeData);
		this.setWeights = new CargoSetWeightsPanel(runtimeData);
		setLayout(new GridLayout(4, 1));
		add(new CargoSetCustomPanel(runtimeData));
		add(setWeights);
		add(printOutInfo);

	}

	public void setOutInfoText() {
		printOutInfo.setOutinfo(runtimeData.getOutputInfo());

	}

}
