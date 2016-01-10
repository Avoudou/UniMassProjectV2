package graphicsUI;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import lombok.AllArgsConstructor;

public class CargoSetImagePanel extends JPanel {
	private ImageIcon image= new ImageIcon("Textures/CargoSample.jpg");
	
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(image.getImage(), 75,0, 125,125, null);
		g.drawImage(image.getImage(), 200,0, 125,125, null);
		g.drawImage(image.getImage(),325,0, 125,125, null);
	

}
}