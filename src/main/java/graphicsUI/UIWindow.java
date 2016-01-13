package graphicsUI;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UIWindow extends JFrame {

	private RunTimeData runtimeData;
	private CentralPanel centralPanel;

	public UIWindow(RunTimeData runtimeData) {
		this.runtimeData = runtimeData;

		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Cargo Loader");
		setResizable(false);

		add(new CargoSpaceMenu(this.runtimeData), BorderLayout.SOUTH);
		add(new RunAlgorithmsMenu(this.runtimeData, this), BorderLayout.WEST);

		add(new CargoSetsMenu(this.runtimeData, this), BorderLayout.NORTH);
		setCentralPanel();

		setVisible(true);

	}

	public void setCentralPanel() {
		centralPanel = new CentralPanel(runtimeData, this);
		add(centralPanel, BorderLayout.CENTER);

	}

	public void disposeCentralPanel() {
		this.remove(centralPanel);
	}

	public void setOutInfo() {
		centralPanel.setOutInfoText();
	}

}
