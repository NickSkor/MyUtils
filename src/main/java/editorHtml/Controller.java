package editorHtml;

import javax.swing.*;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;

public class Controller {
	private View view;
	private HTMLDocument document;
	private File currentFile;

	public Controller(View view) {
		this.view = view;
	}

	public HTMLDocument getDocument() {
		return document;
	}

	public void setDocument(HTMLDocument document) {
		this.document = document;
	}

	public void resetDocument() {
		if (document != null)
			document.removeUndoableEditListener(view.getUndoListener());
		document = (HTMLDocument) new HTMLEditorKit().createDefaultDocument();
		document.addUndoableEditListener(view.getUndoListener());
		view.update();
	}

	public void setPlainText(String text) {
		try {
			resetDocument();
			StringReader stringReader = new StringReader(text);
			new HTMLEditorKit().read(stringReader, document, 0);
		} catch (Exception e) {
			ExceptionHandler.log(e);
		}

	}

	public String getPlainText() {
		try {
			StringWriter writer = new StringWriter();
			new HTMLEditorKit().write(writer, document, 0, document.getLength());
			return writer.toString();
		} catch (Exception e) {
			ExceptionHandler.log(e);
		}
		return null;
	}

	public void init() {
		createNewDocument();
	}

	public void createNewDocument() {
		view.selectHtmlTab();
		resetDocument();
		view.setTitle("HTML редактор");
		view.resetUndo();
		currentFile = null;
	}

	public void openDocument() {
		try {
			view.selectHtmlTab();
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setFileFilter(new HTMLFileFilter());
			if (fileChooser.showOpenDialog(view) == JFileChooser.APPROVE_OPTION) {
				currentFile=fileChooser.getSelectedFile();
				resetDocument();
				view.setTitle(currentFile.getName());
				FileReader reader = new FileReader(currentFile);
				new HTMLEditorKit().read(reader, document, 0);
				view.resetUndo();
			}

		} catch (Exception e) {
			ExceptionHandler.log(e);
		}
	}

	public void saveDocument() {
		try {
			view.selectHtmlTab();
			if (currentFile==null) {
				saveDocumentAs();
			} else {
				view.setTitle(currentFile.getName());
				FileWriter writer = new FileWriter(currentFile);
				new HTMLEditorKit().write(writer, document, 0, document.getLength());
			}
		} catch (Exception e) {
			ExceptionHandler.log(e);
		}
	}

	public void saveDocumentAs() {
		try {
			view.selectHtmlTab();
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setFileFilter(new HTMLFileFilter());
			if (fileChooser.showSaveDialog(view) == JFileChooser.APPROVE_OPTION) {
				currentFile=fileChooser.getSelectedFile();
				view.setTitle(currentFile.getName());
				FileWriter writer = new FileWriter(currentFile);
				new HTMLEditorKit().write(writer, document, 0, document.getLength());
			}

		} catch (Exception e) {
			ExceptionHandler.log(e);
		}
	}

	public void exit() {
		System.exit(0);
	}

	public static void main(String[] args) {
		View viewNew = new View();
		Controller controller = new Controller(viewNew);
		viewNew.setController(controller);
		viewNew.init();
		controller.init();
	}
}
