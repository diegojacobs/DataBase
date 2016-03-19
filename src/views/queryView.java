package views;

import java.awt.EventQueue;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class queryView {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					queryView window = new queryView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public queryView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mnNewMenu.add(mntmOpen);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.setEnabled(false);
		mnNewMenu.add(mntmSave);
		
		JMenu mnNewMenu_1 = new JMenu("Edit");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmCut = new JMenuItem("Cut");
		mnNewMenu_1.add(mntmCut);
		
		JMenuItem mntmCopy = new JMenuItem("Copy");
		mnNewMenu_1.add(mntmCopy);
		
		JMenuItem mntmPaste = new JMenuItem("Paste");
		mnNewMenu_1.add(mntmPaste);
		
		JMenu mnQuery = new JMenu("Query");
		menuBar.add(mnQuery);
		
		JMenuItem mntmRun = new JMenuItem("Run");
		mnQuery.add(mntmRun);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		frame.getContentPane().add(toolBar, BorderLayout.NORTH);
		
		
		
		JButton btnOpenFile = new JButton("Open File");
		btnOpenFile.setToolTipText("Open File");
		try{
			Image img = ImageIO.read(getClass().getClassLoader().getResource("resources/images/2openButton.png"));
			btnOpenFile.setIcon(new ImageIcon(img));
			btnOpenFile.setText("");
			Border emptyBorder = BorderFactory.createEmptyBorder();
			btnOpenFile.setBorder(emptyBorder);
		} catch (Exception e){
			System.out.println("Error in resources/images/2openButton.png");
		}
		toolBar.add(btnOpenFile);
		
		JButton btnSave = new JButton("Save");
		btnSave.setEnabled(false);
		btnSave.setToolTipText("Save");
		try{
			Image img = ImageIO.read(getClass().getClassLoader().getResource("resources/images/3saveButton.png"));
			btnSave.setIcon(new ImageIcon(img));
			btnSave.setText("");
			Border emptyBorder = BorderFactory.createEmptyBorder();
			btnSave.setBorder(emptyBorder);
		} catch (Exception e){
			System.out.println("Error in resources/images/3saveButton.png");
		}
		toolBar.add(btnSave);
		
		JButton btnCut = new JButton("Cut");
		btnCut.setToolTipText("Cut");
		try{
			Image img = ImageIO.read(getClass().getClassLoader().getResource("resources/images/4cutButton.png"));
			btnCut.setIcon(new ImageIcon(img));
			btnCut.setText("");
			Border emptyBorder = BorderFactory.createEmptyBorder();
			btnCut.setBorder(emptyBorder);
		} catch (Exception e){
			System.out.println("Error in resources/images/4cutButton.png");
		}
		toolBar.add(btnCut);
		
		JButton btnCopy = new JButton("Copy");
		btnCopy.setToolTipText("Copy");
		try{
			Image img = ImageIO.read(getClass().getClassLoader().getResource("resources/images/5copyButton.png"));
			btnCopy.setIcon(new ImageIcon(img));
			btnCopy.setText("");
			Border emptyBorder = BorderFactory.createEmptyBorder();
			btnCopy.setBorder(emptyBorder);
		} catch (Exception e){
			System.out.println("Error in resources/images/5copyButton.png");
		}
		toolBar.add(btnCopy);
		
		JButton btnPaste = new JButton("Paste");
		btnPaste.setToolTipText("Paste");
		try{
			Image img = ImageIO.read(getClass().getClassLoader().getResource("resources/images/6pasteButton.png"));
			btnPaste.setIcon(new ImageIcon(img));
			btnPaste.setText("");
			Border emptyBorder = BorderFactory.createEmptyBorder();
			btnPaste.setBorder(emptyBorder);
		} catch (Exception e){
			System.out.println("Error in resources/images/6pasteButton.png");
		}
		toolBar.add(btnPaste);
		
		JButton btnRun = new JButton("Run");
		btnRun.setToolTipText("Run");
		try{
			Image img = ImageIO.read(getClass().getClassLoader().getResource("resources/images/1playButton.png"));
			btnRun.setIcon(new ImageIcon(img));
			btnRun.setText("");
			Border emptyBorder = BorderFactory.createEmptyBorder();
			btnRun.setBorder(emptyBorder);
		} catch (Exception e){
			System.out.println("Error in resources/images/1playButton.png");
		}
		toolBar.add(btnRun);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.5);
		splitPane.setContinuousLayout(true);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		frame.getContentPane().add(splitPane, BorderLayout.CENTER);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		splitPane.setLeftComponent(tabbedPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		tabbedPane.addTab("SQL Editor", null, scrollPane_1, null);
		
		JTextArea textArea = new JTextArea();
		textArea.setTabSize(4);
		scrollPane_1.setViewportView(textArea);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		splitPane.setRightComponent(tabbedPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane_1.addTab("Data Output", null, scrollPane, null);
		
	}

}
