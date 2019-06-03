package editorHtml;


import editorHtml.listeners.FrameListener;
import editorHtml.listeners.TabbedPaneChangeListener;
import editorHtml.listeners.UndoListener;

import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {

	private Controller controller;
	private JTabbedPane tabbedPane = new JTabbedPane();
	private JTextPane htmlTextPane = new JTextPane();
	private JEditorPane plainTextPane = new JEditorPane();
	private UndoManager undoManager = new UndoManager();
	private UndoListener undoListener = new UndoListener(undoManager);

	public View() throws HeadlessException {

		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e) {
			ExceptionHandler.log(e);
		}
	}

	public UndoListener getUndoListener() {
		return undoListener;
	}

	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

	public void init() {
		initGui();
		FrameListener listener = new FrameListener(this);
		addWindowListener(listener);

		setVisible(true);
	}

	public void initMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		MenuHelper.initFileMenu(this, menuBar);
		MenuHelper.initEditMenu(this, menuBar);
		MenuHelper.initStyleMenu(this, menuBar);
		MenuHelper.initAlignMenu(this, menuBar);
		MenuHelper.initColorMenu(this, menuBar);
		MenuHelper.initFontMenu(this, menuBar);
		MenuHelper.initHelpMenu(this, menuBar);
		getContentPane().add(menuBar, BorderLayout.NORTH);

	}

	public void initEditor() {
		htmlTextPane.setContentType("text/html");
		JScrollPane scrollPane = new JScrollPane(htmlTextPane);
		tabbedPane.add("HTML", scrollPane);
		JScrollPane scrollPane1 = new JScrollPane(plainTextPane);
		tabbedPane.add("Текст", scrollPane1);
		tabbedPane.setPreferredSize(new Dimension(100, 100));
		TabbedPaneChangeListener changeListener = new TabbedPaneChangeListener(this);
		tabbedPane.addChangeListener(changeListener);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
	}

	public void initGui() {
		initMenuBar();
		initEditor();
		pack();
	}

	public void selectedTabChanged() {
		if (tabbedPane.getSelectedIndex() == 0) {
			controller.setPlainText(plainTextPane.getText());
		} else if (tabbedPane.getSelectedIndex() == 1) {
			plainTextPane.setText(controller.getPlainText());
		}
		resetUndo();
	}

	public void selectHtmlTab() {
		tabbedPane.setSelectedIndex(0);
		resetUndo();
	}

	public void update() {
		htmlTextPane.setDocument(controller.getDocument());
	}

	public void showAbout() {
		JOptionPane.showMessageDialog(this, "@ Автор - Скоробагатый Николай", "О программе", JOptionPane.INFORMATION_MESSAGE);
	}

	public void exit() {
		controller.exit();
	}

	public boolean canUndo() {
		return undoManager.canUndo();
	}

	public boolean canRedo() {
		return undoManager.canRedo();
	}

	public void resetUndo() {
		undoManager.discardAllEdits();
	}

	public void undo() {
		try {
			undoManager.undo();
		} catch (Exception e) {
			ExceptionHandler.log(e);
		}

	}

	public void redo() {
		try {
			undoManager.redo();
		} catch (Exception e) {
			ExceptionHandler.log(e);
		}
	}

	public boolean isHtmlTabSelected() {
		if (tabbedPane.getSelectedIndex() == 0)
			return true;
		else
			return false;
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		String command = actionEvent.getActionCommand();
		switch (command) {
			case "Новый":
				controller.createNewDocument();
				break;
			case "Открыть":
				controller.openDocument();
				break;
			case "Сохранить":
				controller.saveDocument();
				break;
			case "Сохранить как...":
				controller.saveDocumentAs();
				break;
			case "Выход":
				controller.exit();
				break;
			case "О программе":
				showAbout();
				break;
		}
	}
}
