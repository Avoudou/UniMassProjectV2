package runnables;

import graphicsUI.RunTimeData;
import graphicsUI.UIWindow;

public class MainLauncherV1 {
	public static void main(String[] args) {
		UIWindow runWindow = new UIWindow(new RunTimeData());
		runWindow.getContentPane().repaint();

	}
}
