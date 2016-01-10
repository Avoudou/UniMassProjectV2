package graphicsUI;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import lombok.AllArgsConstructor;
@AllArgsConstructor
public class ImagePanel extends JPanel {
	private ImageIcon image= new ImageIcon();
	
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image.getImage(), 0,0, 300,300, null);
	

}
}