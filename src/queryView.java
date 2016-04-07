//package views;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import views.*;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.KeyStroke;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;
import javax.swing.text.PlainDocument;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Utilities;
import javax.swing.tree.TreePath;
import javax.swing.undo.UndoManager;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class queryView extends JFrame implements ActionListener{

	
	//private JFrame frame;
	JMenuItem mntmOpen, mntmSave, mntmSaveAs, mntmUndo, mntmRedo, mntmRun, mntmComment, mntmPrueba;
	JButton btnOpenFile, btnSave, btnRun, btnUndo, btnRedo, btnDelete;
	//JTextArea textArea;
	JTextPane textArea, dataOutputArea, dataReadArea;
	JTextField status, dataBaseUse;
	JSplitPane splitPane1;
	JTabbedPane tabbedPane;
	
	TextLineNumber tln;
	UndoManager manager;
	JFileChooser fc;
	File file;
	SimpleTree explorer;
	
	MyVisitor<Object> semantic_checker = new MyVisitor();
	
	String commentSeq = "//", textStr = "";
	int caretLine = 1, caretColumn = 1;
	
	

	/**
	 * Launch the application.
	 *
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					queryView window = new queryView();
					//window.frame.setVisible(true);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

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
		//frame = new JFrame();
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight();
		this.setBounds(100, 100, (width/2), (height/2));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		fc = new JFileChooser();
		
		manager = new UndoManager();
		
		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		mntmOpen = new JMenuItem("Open");
		//mntmOpen.setMnemonic(KeyEvent.VK_O);
		KeyStroke keyStrokeToOpen = KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK);
		mntmOpen.setAccelerator(keyStrokeToOpen);
		mntmOpen.addActionListener(this);
		
		
		mnNewMenu.add(mntmOpen);
		
		mntmSave = new JMenuItem("Save");
		KeyStroke keyStrokeToSave = KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK);
		mntmSave.setAccelerator(keyStrokeToSave);
		mntmSave.addActionListener(this);
		//mntmSave.setEnabled(false);
		mnNewMenu.add(mntmSave);
		
		mntmSaveAs = new JMenuItem("Save As");
		mntmSaveAs.addActionListener(this);
		//mntmSave.setEnabled(false);
		mnNewMenu.add(mntmSaveAs);
		
		JMenu mnNewMenu_1 = new JMenu("Edit");
		menuBar.add(mnNewMenu_1);
		
		mntmUndo = new JMenuItem("Undo");
		//mntmCut.setText("Cut");
		KeyStroke keyStrokeToUndo = KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_DOWN_MASK);
		mntmUndo.setAccelerator(keyStrokeToUndo);
		mntmUndo.addActionListener(this);
		mnNewMenu_1.add(mntmUndo);
		
		mntmRedo = new JMenuItem("Redo");
		//mntmCut.setText("Cut");
		KeyStroke keyStrokeToRedo = KeyStroke.getKeyStroke(KeyEvent.VK_Y, KeyEvent.CTRL_DOWN_MASK);
		mntmRedo.setAccelerator(keyStrokeToRedo);
		mntmRedo.addActionListener(this);
		mnNewMenu_1.add(mntmRedo);
		
		
		JMenuItem mntmCut = new JMenuItem(new DefaultEditorKit.CutAction());
		mntmCut.setText("Cut");
		KeyStroke keyStrokeToCut = KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK);
		mntmCut.setAccelerator(keyStrokeToCut);
		mnNewMenu_1.add(mntmCut);
		
		JMenuItem mntmCopy = new JMenuItem(new DefaultEditorKit.CopyAction());
		mntmCopy.setText("Copy");
		KeyStroke keyStrokeToCopy = KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK);
		mntmCopy.setAccelerator(keyStrokeToCopy);
		mnNewMenu_1.add(mntmCopy);
		
		JMenuItem mntmPaste = new JMenuItem(new DefaultEditorKit.PasteAction());
		mntmPaste.setText("Paste");
		KeyStroke keyStrokeToPaste = KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_DOWN_MASK);
		mntmPaste.setAccelerator(keyStrokeToPaste);
		mnNewMenu_1.add(mntmPaste);
		
		JMenu mnQuery = new JMenu("Query");
		menuBar.add(mnQuery);
		
		mntmRun = new JMenuItem("Run");
		mntmRun.addActionListener(this);
		KeyStroke keyStrokeToRun = KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0);
		mntmRun.setAccelerator(keyStrokeToRun);
		mnQuery.add(mntmRun);
		
		mntmComment = new JMenuItem("Comment Section");
		mntmComment.addActionListener(this);
		KeyStroke keyStrokeToComment = KeyStroke.getKeyStroke(KeyEvent.VK_1, KeyEvent.CTRL_DOWN_MASK);
		mntmComment.setAccelerator(keyStrokeToComment);
		mnQuery.add(mntmComment);
		
		mntmPrueba = new JMenuItem("Prueba");
		mntmPrueba.addActionListener(this);
		//KeyStroke keyStrokeToPrueba = KeyStroke.getKeyStroke(KeyEvent.VK_1, KeyEvent.CTRL_DOWN_MASK);
		//mntmPrueba.setAccelerator(keyStrokeToPrueba);
		//mnQuery.add(mntmPrueba);
		
		this.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		this.getContentPane().add(toolBar, BorderLayout.NORTH);
		
		status = new JTextField();
		status.setEditable(false);;
		this.add(status, BorderLayout.SOUTH);
		
		
		
		
		btnOpenFile = new JButton("Open File");
		btnOpenFile.setToolTipText("Open File");
		btnOpenFile.addActionListener(this);
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
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(this);
		//btnSave.setEnabled(false);
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
		
		JButton btnCut = new JButton(new DefaultEditorKit.CutAction());
		btnCut.setText("Cut");
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
		
		JButton btnCopy = new JButton(new DefaultEditorKit.CopyAction());
		btnCopy.setText("Copy");
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
		
		JButton btnPaste = new JButton(new DefaultEditorKit.PasteAction());
		btnPaste.setText("Paste");
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
		
		btnUndo = new JButton("Undo");
		btnUndo.addActionListener(this);
		btnUndo.setToolTipText("Undo");
		try{
			Image img = ImageIO.read(getClass().getClassLoader().getResource("resources/images/7undoButton.png"));
			btnUndo.setIcon(new ImageIcon(img));
			btnUndo.setText("");
			Border emptyBorder = BorderFactory.createEmptyBorder();
			btnUndo.setBorder(emptyBorder);
		} catch (Exception e){
			System.out.println("Error in resources/images/7undoButton.png");
		}
		toolBar.add(btnUndo);
		
		btnRedo = new JButton("Redo");
		btnRedo.addActionListener(this);
		btnRedo.setToolTipText("Redo");
		try{
			Image img = ImageIO.read(getClass().getClassLoader().getResource("resources/images/8redoButton.png"));
			btnRedo.setIcon(new ImageIcon(img));
			btnRedo.setText("");
			Border emptyBorder = BorderFactory.createEmptyBorder();
			btnRedo.setBorder(emptyBorder);
		} catch (Exception e){
			System.out.println("Error in resources/images/8redoButton.png");
		}
		toolBar.add(btnRedo);
		
		btnRun = new JButton("Run");
		btnRun.addActionListener(this);
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
		
		btnDelete = new JButton("Delete All");
		btnDelete.addActionListener(this);
		btnDelete.setToolTipText("Delete All");
		toolBar.add(btnDelete);
		
		dataBaseUse = new JTextField();
		dataBaseUse.setEditable(false);
		dataBaseUse.setText("Database: ");
		toolBar.add(dataBaseUse);
		
		
		splitPane1 = new JSplitPane();
		splitPane1.setResizeWeight(0.2);
		splitPane1.setContinuousLayout(true);
		splitPane1.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		this.getContentPane().add(splitPane1, BorderLayout.CENTER);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.5);
		splitPane.setContinuousLayout(true);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		
		splitPane1.setRightComponent(splitPane);
		explorer = new SimpleTree();
		addTreeSelection(explorer.getTree());
		splitPane1.setLeftComponent(explorer);
		//this.getContentPane().add(splitPane, BorderLayout.CENTER);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		splitPane.setLeftComponent(tabbedPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		tabbedPane.addTab("SQL Editor", null, scrollPane_1, null);
		
		
		
		//textArea = new JTextArea();
		textArea = new JTextPane();
		//textArea.setTabSize(4);
		
		textArea.setDocument(new SqlDocument());
		textArea.getDocument().addUndoableEditListener(manager);
		
		tln = new TextLineNumber(textArea);
		
		scrollPane_1.setViewportView(textArea);
		scrollPane_1.setRowHeaderView(tln);
		
		setCaretListener(textArea);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		splitPane.setRightComponent(tabbedPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane_1.addTab("Data Output", null, scrollPane, null);
		
		//textArea = new JTextArea();
		dataOutputArea = new JTextPane();
		//textArea.setTabSize(4);
		
		dataOutputArea.setEditable(false);
		//textArea.setDocument(new SqlDocument());
		//textArea.getDocument().addUndoableEditListener(manager);
		
		//tln = new TextLineNumber(textArea);
		
		scrollPane.setViewportView(dataOutputArea);
		//scrollPane_1.setRowHeaderView(tln);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		tabbedPane_1.addTab("Data Read", null, scrollPane_2, null);
		
		//textArea = new JTextArea();
		dataReadArea = new JTextPane();
		//textArea.setTabSize(4);
		
		dataReadArea.setEditable(false);
		dataReadArea.setDocument(new SqlDocument());
		//textArea.getDocument().addUndoableEditListener(manager);
		
		//tln = new TextLineNumber(textArea);
		
		scrollPane_2.setViewportView(dataReadArea);
		//scrollPane_1.setRowHeaderView(tln);
		
		Font font0 = new Font("Arial", Font.BOLD, height/60);
		changeFont(this,font0);
		
		Font font1 = new Font("Consolas", Font.PLAIN, height/60);
		dataOutputArea.setFont(font1);
		dataReadArea.setFont(font1);
		textArea.setFont(font1);
		
	}
	
	public void addNewTab(File file){
		try{
			String path = file.getAbsolutePath();
			String name = file.getName();
			FileInputStream fis = new FileInputStream(path);
			BufferedReader br = new BufferedReader(new FileReader(path));
			
			//JScrollPane scrollPane_1 = new JScrollPane();
			
			//JTable table = null;
			//JScrollPane scrollPane_1 = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			//tabbedPane.add(scrollPane_1);
			
			if (br.readLine() != null)
			{
				ObjectInputStream in = new ObjectInputStream(fis);
				Object obj = in.readObject();
				if (obj instanceof Table){
					Path currentRelativePath = Paths.get("");
					String dataPath = currentRelativePath.toAbsolutePath().toString() + "\\data\\";
					FileInputStream fis1 = new FileInputStream(dataPath+"dbs.bin");
					BufferedReader br1 = new BufferedReader(new FileReader(dataPath+"dbs.bin"));
					DataBases dataBases = null;
					if (br1.readLine() != null)
					{
						ObjectInputStream in1 = new ObjectInputStream(fis1);
						dataBases = (DataBases)in1.readObject();
						//fis.close();
						in1.close();
					}
					fis1.close();
					br1.close();
					if (dataBases != null){
						//name 
						String dataBaseName = file.getParentFile().getName();
						
						DataBase dataBase = null;
						
						for (int i = 0; i < dataBases.getDataBases().size(); i++){
							if (dataBases.getDataBases().get(i).getName().equals(dataBaseName)){
								dataBase = dataBases.getDataBases().get(i);
							}
						}
						
						if (dataBase != null){
							
							Table dataBaseTable = dataBase.getTable(name.substring(0, name.length()-4));//quito .bin
							//System.out.println(dataBaseTable);
							if (dataBaseTable != null)
								addNewTab(dataBaseTable);
								//table = createNewTable(dataBaseTable);
						}
						
						//System.out.println(dataBaseTable);
						
					}
					
				}else if (obj instanceof DataBases){
					DataBases dataBases = (DataBases)obj;
					addNewTab(dataBases);
					//table = createNewTable(dataBases);
					//System.out.println(dataBases);
				}
					
				
				in.close();
				
				
			}
			br.close();
			fis.close();
			
			/*if (table != null) scrollPane_1.setViewportView(table);
			//if (tabbedPane.indexOfComponent(scrollPane_1) == -1)
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				tabbedPane.setTabComponentAt(tabbedPane.indexOfComponent(scrollPane_1), getTitlePanel(tabbedPane,(Component)scrollPane_1,name));
			
			//System.out.println(dataBases);
			*/
			
			
		} catch (Exception e){
			//e.printStackTrace();
			System.out.println(e.toString());
		}
	}
	
	public void addNewTab(DataBases dataBases){
		String name = "dbs.bin";
		JTable table = null;
		JScrollPane scrollPane_1 = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		//JScrollPane scrollPane_1 = new JScrollPane();
		
		
		table = createNewTable(dataBases);	
		if (table != null){
			LineNumberTableRowHeader tableLineNumber = new LineNumberTableRowHeader(scrollPane_1,table);
			scrollPane_1.setRowHeaderView(tableLineNumber);
			scrollPane_1.setViewportView(table);
			//if (tabbedPane.indexOfComponent(scrollPane_1) == -1)
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			tabbedPane.add(scrollPane_1);
			tabbedPane.setTabComponentAt(tabbedPane.indexOfComponent(scrollPane_1), getTitlePanel(tabbedPane,(Component)scrollPane_1,name));
			tabbedPane.setSelectedIndex(tabbedPane.getComponentCount()-2);
		}
	}
	
	public void addNewTab(Table tableObj){
		String name = tableObj.getName();
		JTable table = null;
		JScrollPane scrollPane_1 = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		//JScrollPane scrollPane_1 = new JScrollPane();
		
		
		table = createNewTable(tableObj);
		if (table != null){
			LineNumberTableRowHeader tableLineNumber = new LineNumberTableRowHeader(scrollPane_1,table);
			//tableLineNumber.setBackground(Color.LIGHT_GRAY);
			scrollPane_1.setRowHeaderView(tableLineNumber);
			scrollPane_1.setViewportView(table);
			//if (tabbedPane.indexOfComponent(scrollPane_1) == -1)
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			tabbedPane.add(scrollPane_1);
			tabbedPane.setTabComponentAt(tabbedPane.indexOfComponent(scrollPane_1), getTitlePanel(tabbedPane,(Component)scrollPane_1,name));
			tabbedPane.setSelectedIndex(tabbedPane.getComponentCount()-2);
		}
	}
	
	public JTable createNewTable(Table table){
		ArrayList<String> nombres = new ArrayList();
		ArrayList<Atributo> atributos = table.getAtributos();
		for (Atributo at: atributos){
			nombres.add(at.getId());
		}
		
		Object [] columnNames = nombres.toArray();
		
		
		
		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
		for (ArrayList<String> tupla: table.getData()){
			//System.out.println("tupla: "+tupla);
			Object[] objs = (Object[]) tupla.toArray();
			//if (objs.length > 0)
				tableModel.addRow(objs);
			
		}
		//System.out.println("Ya llego a crear la tabla");
		//if (tableModel.getRowCount()>0){
			JTable nTable = new JTable(tableModel);
			nTable.setEnabled(false);
			return nTable;
		//}
		//return null;
	}
	
	public JTable createNewTable(DataBases dataBases){
		String [] columnNames = {"Database","Table Number"};
		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
		for (DataBase st: dataBases.getDataBases()){
			Object[] objs = {st.getName(), st.getTables().size()};
			//if (objs.length > 0)
				tableModel.addRow(objs);
		}
		//if (tableModel.getRowCount()>0){
			JTable nTable = new JTable(tableModel);
			nTable.setEnabled(false);
			return nTable;
		//}
		//return null;
	}
	
	public void addTreeSelection(JTree tree){
		tree.addTreeSelectionListener(new TreeSelectionListener(){
			public void valueChanged(TreeSelectionEvent event){
				File file = (File) tree.getLastSelectedPathComponent();
				addNewTab(file);
			}
		});
	}
	
	
	public JPanel getTitlePanel(final JTabbedPane tabbedPane, final Component panel, String title){
		JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
		titlePanel.setOpaque(false);
		JLabel titleLbl = new JLabel(title);
		titleLbl.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
		titlePanel.add(titleLbl);
		JButton closeButton = new JButton("x");
	 
		Border emptyBorder = BorderFactory.createEmptyBorder();
		closeButton.setBorder(emptyBorder);
		//closeButton.setOpaque(true);

		closeButton.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				tabbedPane.remove(panel);
			}
		});
		titlePanel.add(closeButton);

		return titlePanel;
	}
	
	
	public void changeFont ( Component component, Font font )
	{
		
	    component.setFont ( font );
	    //System.out.println(component.getName());
	    if ( component instanceof Container )
	    {
	        for ( Component child : ( ( Container ) component ).getComponents () )
	        {
	            changeFont ( child, font );
	        }
	    }
	}
	
	private void setCaretListener(JTextPane editor){
		 // Add a caretListener to the editor. This is an anonymous class because it is inline and has no specific name.
        editor.addCaretListener(new CaretListener() {
            // Each time the caret is moved, it will trigger the listener and its method caretUpdate.
            // It will then pass the event to the update method including the source of the event (which is our textarea control)
            public void caretUpdate(CaretEvent e) {
                //JTextArea editArea = (JTextArea)e.getSource();
            	//JTextPane editArea = (JTextPane)e.getSource();

                // Lets start with some default values for the line and column.
                

                // We create a try catch to catch any exceptions. We will simply ignore such an error for our demonstration.
                try {
                    // First we find the position of the caret. This is the number of where the caret is in relation to the start of the JTextArea
                    // in the upper left corner. We use this position to find offset values (eg what line we are on for the given position as well as
                    // what position that line starts on.
                    //int caretpos = e.getCaretPosition();
                    
                    //(caretpos == 0) ? 1:0;
                    
                    
                    caretLine = getRow(e.getDot(),(JTextComponent)e.getSource());
                    //caretLine = editArea.getLineOfOffset(caretpos);

                    // We subtract the offset of where our line starts from the overall caret position.
                    // So lets say that we are on line 5 and that line starts at caret position 100, if our caret position is currently 106
                    // we know that we must be on column 6 of line 5.
                    caretColumn = getColumn(e.getDot(), (JTextComponent)e.getSource())-1;
                    //caretColumn = caretpos - editArea.getLineStartOffset(caretLine);

                    // We have to add one here because line numbers start at 0 for getLineOfOffset and we want it to start at 1 for display.
                    //caretLine += 1;
                }
                catch(Exception ex) { }

                // Once we know the position of the line and the column, pass it to a helper function for updating the status bar.
                updateStatus(caretLine, caretColumn);
            }
        });
			
		
	}
	
	public int getRow(int pos, JTextComponent editor) {
        int rn = (pos==0) ? 1 : 0;
        try {
            int offs=pos;
            while( offs>0) {
                offs=Utilities.getRowStart(editor, offs)-1;
                rn++;
            }
        } catch (BadLocationException e) {
            e.printStackTrace();
            
        }
        return rn;
	}

    public int getColumn(int pos, JTextComponent editor) {
        try {
            return pos-Utilities.getRowStart(editor, pos)+1;
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
        return 1;
    }
	
	private void updateStatus(int linenumber,int columnnumber){
		status.setText("Line: " + linenumber + " Column: " + columnnumber);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmOpen ||
				e.getSource() == btnOpenFile){
			open();
	        
		}else if (e.getSource() == mntmSave ||
				e.getSource() == btnSave){
			save();
		}else if (e.getSource() == mntmSaveAs){
			saveAs();
			explorer.reload();
		}else if (e.getSource() == mntmUndo ||
				e.getSource() == btnUndo){
			undo();
		}else if (e.getSource() == mntmRedo ||
				e.getSource() == btnRedo){
			redo();
		}else if (e.getSource() == mntmRun ||
				e.getSource() == btnRun){
			run();
			explorer.reload();
		}else if (e.getSource() == mntmComment){
			comment();
		}else if (e.getSource() == mntmPrueba){
			addNewTab(new File("C:/"));
		}else if (e.getSource() == btnDelete){
			textArea.setText("");
		}
		
	}
	
	public void open(){
		int returnVal = fc.showOpenDialog(this);
        
        if (returnVal == JFileChooser.APPROVE_OPTION){
        	file = fc.getSelectedFile();
        	mntmSave.setEnabled(true);
        	btnSave.setEnabled(true);
        	try{
        		/*FileReader readFile = new FileReader(file.getAbsolutePath());
        		BufferedReader br = new BufferedReader(readFile);
        		textArea.setText("");
        		String newTxt = "";
        		String currentLine;
        		while ((currentLine = br.readLine()) != null){
        			//textArea.append(currentLine+"\n");
        			newTxt += currentLine+"\n";
        		}*/
        		Scanner scanner = new Scanner(file);
        		String newTxt = "";
        		while (scanner.hasNextLine()){
        			newTxt += scanner.nextLine()+"\n";
        		}
        		SqlDocument doc = new SqlDocument();
        		textArea.setDocument(new DefaultStyledDocument());
        		doc.insertString(0, newTxt, null);
        		
        		textArea.setDocument(doc);
        		//System.out.println(newTxt);
        		scanner.close();
        		//br.close();
        	} catch (Exception e){
        		//e.printStackTrace();
        		System.out.println("Error opening file");
        	}
        	
        
        	//System.out.println(file.getAbsolutePath());
        } else {
        	//JOptionPane.showMessageDialog(null,"\nNo se ha encontrado el archivo","ADVERTENCIA!!!",JOptionPane.WARNING_MESSAGE);
        }
	}
	
	public void save(){
		if (file != null){
			System.out.println("Archivo salvado en "+file.getAbsolutePath());
			try{
				PrintWriter writer = new PrintWriter(file.getAbsolutePath(), "UTF-8");
				writer.print(textArea.getText());
				writer.close();
			}catch (Exception e ){
				System.out.println("Error saving file");
			}
			
		}else{
			saveAs();
		}
	}
	
	public void saveAs(){
		int returnVal = fc.showSaveDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = fc.getSelectedFile();
            try{
				PrintWriter writer = new PrintWriter(file.getAbsolutePath(), "UTF-8");
				writer.print(textArea.getText());
				writer.close();
			}catch (Exception e ){
				System.out.println("Error saving file");
			}
            
            System.out.println(file.getAbsolutePath());
            //This is where a real application would save the file.
            //log.append("Saving: " + file.getName() + "." + newline);
        } else {
            //log.append("Save command cancelled by user." + newline);
        }
	}
	
	public void undo(){
		try{
			manager.undo();
		}catch (Exception e){
			//to do
		}
	}
	
	
	public void redo(){
		try{
			manager.redo();
		}catch (Exception e){
			//to do
		}
	}
	
	public void comment(){
		String text = textArea.getText(), newTxt = "";
		try{
			int caretpos = textArea.getCaretPosition();
			
			
			int lineCount = 1;
			int i = 0;
			boolean condition = true;
			while (condition){
				if (lineCount == caretLine){//if we reach the same line as the caret
					
					if (text.length()>0){
						if (text.length() >= i+commentSeq.length()){//if there is a chance of '//' presence
							String subst = text.substring(i,i+commentSeq.length());
							if (subst.equals(commentSeq)){
								newTxt = text.substring(0,i) + text.substring(i+commentSeq.length());
								
							}else{
								newTxt = text.substring(0,i)+ commentSeq + text.substring(i);
							}
						}else{
							newTxt = text.substring(0,i)+ commentSeq + text.substring(i);
						}
						
					}else{
						newTxt = commentSeq + text;
					}
					i = text.length()-1;//to evaluate text.charAt even if we dont need it
				}
				if (text.length()>0)
				if (text.charAt(i) == '\n'){//if it's a new line
					lineCount++;
				}
				i++;
				condition = i < text.length();
			}
			textArea.setText(newTxt);
			textArea.setCaretPosition(caretpos);
			
			
		} catch (Exception e){
			textArea.setText(text);
			//System.out.println(e);
		}
		
	}
	
	public void run(){
		try{
			
			dataOutputArea.setText("...");
			textStr = textArea.getSelectedText();
			if (textStr == null)
				textStr = textArea.getText();//
			
			// Create DataBase
			long startTime = System.nanoTime();
	    	ANTLRInputStream input = new ANTLRInputStream(textStr);
	    	
	    	/*
    	    create database antros;
    	    use database antros;
			create table baronRojo (nombre int, dpi char(10), edad char(4), constraint pk primary KEY (nombre, dpi));
			create table baronRojoCayala (nombre int, dpi char(10), CONSTRAINT pk PRIMARY KEY(nombre, dpi), CONSTRAINT fk FOREIGN KEY(nombre) REFERENCES baronRojo (nombre, dpi), CONSTRAINT fk2 FOREIGN KEY(dpi) REFERENCES baronRojo (edad), CONSTRAINT ch CHECK(nombre > dpi) );
			create table baronRojoXela (id int, constraint fk foreign key(id) references baronRojoCayala (nombre) );
			alter table baronRojo add column fecha date constraint fk foreign key (nombre) references baronRojoXela (id);
	    	 */
    	
	    	// Create Table
	    	//ANTLRInputStream input = new ANTLRInputStream("use database prueba; create table baronRojo (nombre int, dpi char(10), edad char(4), constraint pk primary KEY (nombre, dpi));");
	    	
	    	// Create Table con Constraints
	        //ANTLRInputStream input = new ANTLRInputStream("use database prueba; create table baronRojoCayala (nombre int, dpi char(10), CONSTRAINT pk PRIMARY KEY(nombre, dpi), CONSTRAINT fk FOREIGN KEY(nombre) REFERENCES baronRojo (nombre, dpi), CONSTRAINT fk2 FOREIGN KEY(dpi) REFERENCES baronRojo (edad), CONSTRAINT ch CHECK(nombre > dpi) );");  	
	   	
	    	// Rename Table
	    	//ANTLRInputStream input = new ANTLRInputStream("use database prueba; alter table baronRojo rename to baronAzul;");
    	
	        sqlLexer lexer = new sqlLexer(input);
	        
	        CommonTokenStream tokens = new CommonTokenStream(lexer);
	
	        sqlParser parser = new sqlParser(tokens);
	        
	        //errores sintacticos
	        parser.removeErrorListeners();
	        parser.addErrorListener(DescriptiveErrorListener.INSTANCE);
	        
	        ParseTree tree = parser.sql2003Parser(); // begin parsing at rule 'sql2003Parser'
	        
	        if (!DescriptiveErrorListener.errors.isEmpty()){
	        	dataOutputArea.setText(DescriptiveErrorListener.errors);
	        	DescriptiveErrorListener.errors = "";
	        	return ;
	        }
	        
	        
	        Object obj = (Object)semantic_checker.visit(tree);
	        semantic_checker.guardarDBs();
	        
	        if (semantic_checker.getActual().getName().isEmpty()){
	        	dataBaseUse.setText("Database: ");
	        }else{
	        	dataBaseUse.setText("Database: "+semantic_checker.getActual().getName());
	        }

	        long estimatedTime = System.nanoTime()-startTime;
	        if (obj instanceof DataBases){
	        	DataBases dbs = (DataBases) obj;
	        	addNewTab(dbs);
	        }else if (obj instanceof Table){
	        	Table tb = (Table) obj;
	        	addNewTab(tb);
	        }	        
	        
	        if (!semantic_checker.erroresToString().isEmpty())
	        	dataOutputArea.setText(semantic_checker.erroresToString()+"\n"+calculateTime(estimatedTime));
	        else
	        	dataOutputArea.setText(semantic_checker.toStringMessages() + "\n" + "Terminado"+"\n"+calculateTime(estimatedTime));
	        dataReadArea.setText(textStr);
	        semantic_checker.resetValues();
	        //splitPane1.setLeftComponent(new SimpleTree());
		} catch (Exception e){
			dataReadArea.setText("Unexpected error: " + e.getStackTrace().toString());
		}
		
	}
	
	public String calculateTime(long nanoTime){
		String str = "Estimated time: ";
		long hr, min, sec, msec, nsec, time = 0;
		if ((hr = TimeUnit.NANOSECONDS.toHours(nanoTime))>0){
			str += ""+hr+"hr ";
			time = time+hr*60;
		}
		if ((min = TimeUnit.NANOSECONDS.toMinutes(nanoTime))>0){
			min = min-time;
			str += ""+min+"min ";
			time = (time + min)*60;
		}
		if ((sec = TimeUnit.NANOSECONDS.toSeconds(nanoTime))>0){
			sec = sec-time;
			str += ""+sec+"s ";
			time = (time + sec)*1000;
		}
		if ((msec = TimeUnit.NANOSECONDS.toMillis(nanoTime))>0){
			msec = msec-time;
			str += ""+msec+"ms ";
			time = (time + msec)*1000000;
		}
		if ((nsec = TimeUnit.NANOSECONDS.toNanos(nanoTime))>0)
			nsec = nsec-time;
			str += ""+nsec+"ns ";
			
		return str;
	}
	
	public String getTextStr(){
		return textStr;
	}

}
