package Notepad;

import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;

public class Function_File {

	//Create object of class
	GUI gui;
	
	
	String FileName;
	String FileAddress;
	
	
	
	
	public Function_File(GUI gui)
	{
		this.gui=gui;
		
	}
	
	public void newFile()
	{
		//get access of text area
		gui.textArea.setText("");
		gui.window.setTitle("NewFile");
		
		//FileName=null;
		//FileAddress=null;
	}
	
	//For Open file
	public void openFile()
	{
		FileDialog fd=new FileDialog(gui.window,"Open",FileDialog.LOAD);
		fd.setVisible(true);
		
		if(fd.getFile()!=null)
		{
			FileName=fd.getFile();
			FileAddress=fd.getDirectory();
			gui.window.setTitle(FileName);
			
		}
		
		System.out.println("print file address and name :" +FileAddress+FileName);
		
		try {
			
			
			//read file function
			BufferedReader br=new BufferedReader(new FileReader(FileAddress+FileName));
			gui.textArea.setText("");
			String line=null;
			
			while((line=br.readLine())!=null)
			{
				gui.textArea.append(line +"\n");
			}
			br.close();
			
		}
		catch(Exception e)
		{
			
			System.out.println("file not open");
			
		}
	}
	
	public void save()
	{
		if(FileName==null)
		{
			saveAs();
		}
		else
		{
			try {
				FileWriter fw=new FileWriter(FileAddress+FileName);
				fw.write(gui.textArea.getText());
				gui.window.setTitle(FileName);
				fw.close();
				
			}
			catch(Exception e) {
				
				System.out.println("file does not save");
				
			}
		}
		
	}
	
	public void saveAs()
	{
		FileDialog fd=new FileDialog(gui.window,"Save",FileDialog.SAVE);
		fd.setVisible(true);
		
		if(fd.getFile()!=null)
		{
			FileName=fd.getFile();
			FileAddress=fd.getDirectory();
			gui.window.setTitle(FileName);
		}
		try {
			FileWriter fw=new FileWriter(FileAddress+FileName);
			fw.write(gui.textArea.getText());
			fw.close();
		}
		catch(Exception e){
			
			System.out.println("file does not save");
		}
		
	}
	
	public void exit() {
		
		System.exit(0);
	}
	
	
	

}
