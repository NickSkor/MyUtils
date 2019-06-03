package editorHtml.listeners;


import editorHtml.View;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;

public class TextEditMenuListener implements MenuListener {
	private View view;

	public TextEditMenuListener(View view) {
		this.view = view;
	}

	@Override
	public void menuSelected(MenuEvent menuEvent) {
		JMenu menu = (JMenu) menuEvent.getSource();

		Component[] list = menu.getMenuComponents();
		for (Component comp : list)
			comp.setEnabled(view.isHtmlTabSelected());


	}

	@Override
	public void menuDeselected(MenuEvent menuEvent) {

	}

	@Override
	public void menuCanceled(MenuEvent menuEvent) {

	}
}
