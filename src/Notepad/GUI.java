package Notepad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.plaf.basic.BasicMenuItemUI;

class GUI implements ActionListener{

	JFrame window;
	
	//text area
	JTextArea textArea;
	JScrollPane scrollBar;
	
	boolean wordWrapOn=false;
	
	//top menu bar
	JMenuBar menuBar;
	JMenu menuFile,menuEdit,menuFormat,menuColor;
	
	//file menu
	JMenuItem itemNew,itemOpen,itemSave,itemSaveAs,itemExit;
	
	//format menu
	JMenuItem itemWrap,itemfontArial,itemfontCSMS,itemfontTNR,
	itemFontSize8,itemFontSize12,itemFontSize16,itemFontSize20,itemFontSize24;
	
	JMenu menuFont,menuFontSize;
	
	//Color memu
	JMenuItem itemColor1,itemColor2,itemColor3;
	
	
	//craete object of function_file class
	Function_File file=new Function_File(this);
	
	//create object of format class
	Format format=new Format(this);
	
	//create object of color class
	FColor color=new FColor(this);
	
	public static void main(String[] args) {

		new GUI();

	}
	public GUI() {

		createWindow();
		createTextArea();
		createMenuBar();
		createMenuItem();
		createFormatMenu();
		createColorMenu();
		window.setVisible(true);
		
		format.selectedFont="Arial";
		
		color.changeColor("White");
		
		format.createFont(16);
		format.wordWrap();
		

	}
	public void createWindow() {

		window=new JFrame("Notepad");
		window.setSize(800,600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void createTextArea()
	{

		textArea=new JTextArea();

		scrollBar=new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		//remove border of scroll bar
		scrollBar.setBorder(BorderFactory.createEmptyBorder());

		window.add(scrollBar);
		//window.add(textArea);					

	}
	public void createMenuBar()
	{
		menuBar=new JMenuBar();
		window.setJMenuBar(menuBar);

		//create menu button
		//1.file button
		menuFile=new JMenu("File");
		menuBar.add(menuFile);

		//2.edit button
		menuEdit=new JMenu("Edit");
		menuBar.add(menuEdit);

		//3.format button
		menuFormat=new JMenu("Format");
		menuBar.add(menuFormat);

		//4.color button
		menuColor=new JMenu("Color");
		menuBar.add(menuColor);
	}
	
	
	//add all items in menu button
	public void createMenuItem()
	{
		itemNew=new JMenuItem("New");
		
		itemNew.addActionListener(this);
		itemNew.setActionCommand("New");
		menuFile.add(itemNew);
		
		itemOpen=new JMenuItem("Open");
		itemOpen.addActionListener(this);
		itemOpen.setActionCommand("Open");
		menuFile.add(itemOpen);
		
		itemSave=new JMenuItem("Save");
		itemSave.addActionListener(this);
		itemSave.setActionCommand("Save");
		menuFile.add(itemSave);
		
		itemSaveAs=new JMenuItem("SaveAs");
		itemSaveAs.addActionListener(this);
		itemSaveAs.setActionCommand("SaveAs");
		menuFile.add(itemSaveAs);
		
		itemExit=new JMenuItem("Exit");
		
		itemExit.addActionListener(this);
		itemExit.setActionCommand("Exit");
		menuFile.add(itemExit);
	}
	
	
	//format menu
	public void createFormatMenu(){
		
		itemWrap=new JMenuItem("Word Wrap :off");
		itemWrap.addActionListener(this);
		itemWrap.setActionCommand("Word Wrap");
		menuFormat.add(itemWrap);
		
		
		menuFont=new JMenu("Font");
		menuFormat.add(menuFont);
		
		itemfontArial=new JMenuItem("Arial");//Comic Sans MS
		itemfontArial.addActionListener(this);
		itemfontArial.setActionCommand("Arial");
		menuFont.add(itemfontArial);
		
		itemfontCSMS=new JMenuItem("Comic Sans MS");
		itemfontCSMS.addActionListener(this);
		itemfontCSMS.setActionCommand("Comic Sans MS");
		menuFont.add(itemfontCSMS);
		
		
		itemfontTNR=new JMenuItem("Times New Roman");//Times New Roman
		itemfontTNR.addActionListener(this);
		itemfontTNR.setActionCommand("Times New Roman");
		menuFont.add(itemfontTNR);
		
		menuFontSize=new JMenu("Font Size");
		menuFormat.add(menuFontSize);
		
		
		itemFontSize8=new JMenuItem("8");
		itemFontSize8.addActionListener(this);
		itemFontSize8.setActionCommand("Size8");
		menuFontSize.add(itemFontSize8);
		
		
		itemFontSize12=new JMenuItem("12");
		itemFontSize12.addActionListener(this);
		itemFontSize12.setActionCommand("Size12");
		menuFontSize.add(itemFontSize12);
		
		
		itemFontSize16=new JMenuItem("16");
		itemFontSize16.addActionListener(this);
		itemFontSize16.setActionCommand("Size16");
		menuFontSize.add(itemFontSize16);
		
		
		itemFontSize20=new JMenuItem("20");
		itemFontSize20.addActionListener(this);
		itemFontSize20.setActionCommand("Size20");
		menuFontSize.add(itemFontSize20);
		
		
		itemFontSize24=new JMenuItem("24");
		itemFontSize24.addActionListener(this);
		itemFontSize24.setActionCommand("Size24");
		menuFontSize.add(itemFontSize24);
				
		
	}
	
	
	//for color menu
	public void createColorMenu() {
		
		itemColor1=new JMenuItem("White");
		itemColor1.addActionListener(this);
		itemColor1.setActionCommand("White");
		menuColor.add(itemColor1);
		
		itemColor2=new JMenuItem("Blue");
		itemColor2.addActionListener(this);
		itemColor2.setActionCommand("Blue");
		menuColor.add(itemColor2);
		
		
		itemColor3=new JMenuItem("Black");
		itemColor3.addActionListener(this);
		itemColor3.setActionCommand("Black");
		menuColor.add(itemColor3);
		
		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String command=e.getActionCommand();
		switch(command){
		case "New":file.newFile();break;
		
		case "Open":file.openFile();break;
		
		case "SaveAs":file.saveAs();break;
		
		case "Save":file.save();break;
		
		case "Exit":file.exit();break;
		
		case "Word Wrap":format.wordWrap();break;
		
		case "Arial":format.setFont(command);break;
		case "Comic Sans MS":format.setFont(command);break;
		case "Times New Roman":format.setFont(command);break;
		
		case "Size8":format.createFont(8);break;
		case "Size12":format.createFont(12);break;
		case "Size16":format.createFont(16);break;
		case "Size20":format.createFont(20);break;
		case "Size24":format.createFont(24);break;
		
		
		case "White":color.changeColor(command);break;
		case "Blue":color.changeColor(command);break;
		case "Black":color.changeColor(command);break;
		


		
		}
		
		
		
	}
		
	}




