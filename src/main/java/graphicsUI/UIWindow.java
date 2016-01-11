package graphicsUI;

import java.awt.BorderLayout;
import java.util.Timer;

import javax.swing.JFrame;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UIWindow extends JFrame {
	Timer refreshTimer = new Timer();
	private RunTimeData runtimeData;

	public UIWindow(RunTimeData runtimeData) {
		this.runtimeData = runtimeData;

		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Cargo Loader");
		setResizable(false);

		add(new CargoSpaceMenu(this.runtimeData), BorderLayout.SOUTH);
		add(new RunAlgorithmsMenu(this.runtimeData), BorderLayout.WEST);
		final CargoSetWeightsPanel centerPanel = new CargoSetWeightsPanel(this.runtimeData);
		add(centerPanel, BorderLayout.CENTER);
		add(new CargoSetsMenu(this.runtimeData, centerPanel), BorderLayout.NORTH);

		setVisible(true);

		// Timer refreshTimer = new Timer();
		// TimerTask refreshRate = new TimerTask() {
		//
		// @Override
		// public void run() {
		// centerPanel.repaint();
		//
		// }
		// };
		// refreshTimer.schedule(refreshRate, 0, 16);
		//
		//

}
}
	


