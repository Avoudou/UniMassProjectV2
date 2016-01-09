package graphicsUI;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import lombok.Getter;
import lombok.Setter;
import databases.CargoData;
import objectDefinitions.CargoSpaceIndividual;

@Getter
@Setter
public class UIWindow extends JFrame{
	
	private RunTimeData runtimeData;
	
	public UIWindow(RunTimeData runtimeData) {
		this.runtimeData=runtimeData;

		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Cargo Loader");
		setResizable(false);

		
		add(new CargoSpaceMenu(this.runtimeData), BorderLayout.SOUTH);
		add(new RunAlgorithmsMenu(this.runtimeData), BorderLayout.WEST);
		add(new CargoSetsMenu(this.runtimeData),BorderLayout.NORTH);

		setVisible(true);

	}
	
	
	
	

}
