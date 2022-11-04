package test;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class GUIDataFIle extends JFrame implements ActionListener{
	//build the attribute of the graphics
	private JButton readFileBut=new JButton("Click to read from file");
	private JButton writeFileBut=new JButton("Click to write file");
	private JTextField readFileName=new JTextField("Input the file name to read",15);
	private JTextField writeFile=new JTextField("Input the name of file to write",15);
	private JTextArea readedFile=new JTextArea(10,15);
	private JTextArea wroteFile=new JTextArea(10,15);
	private File myFile;
	//construct the frame 
	public GUIDataFIle() {
		getContentPane().setLayout(new FlowLayout());
		getContentPane().add(readFileName);
		getContentPane().add(writeFile);
		getContentPane().add(readFileBut);
		getContentPane().add(writeFileBut);
		getContentPane().add(readedFile);
		getContentPane().add(wroteFile);
		//create the actionlistener
		readFileBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				try { 
					//get the filename from input box.
					String rfileName=readFileName.getText();
					//read file
					myFile=new File("/Users/tangyuwei/Downloads/"+rfileName);
					try (Scanner myReader = new Scanner(myFile)) {
						int i=0;
						//limit the number of lines to 5;
						while(i<5) {
							String data=myReader.nextLine();
							//add \n to split the data 
							readedFile.append(data+"\n");
							i++;
						}
					} 
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		//another action listener of write button
		writeFileBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				try {
					String wfileName=writeFile.getText();
					BufferedWriter myWriter=new BufferedWriter(new FileWriter("/Users/tangyuwei/Downloads/"+wfileName));
					Scanner read = new Scanner(myFile);
					//add split \n 
					read=read.useDelimiter("\n");
					int i=0;
					while(i<5) {
						String string=read.next();
						wroteFile.append(string+"\n");
						i++;
					}
					//write the file from reader to new file
					while(read.hasNext()) {
					myWriter.write(read.next());
					myWriter.newLine();
					}
					myWriter.flush();
					myWriter.close();
					
					
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}	
		});	}
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//		
//		try { 
//			String rfileName=readFileName.getText();
//			myFile=new File("/Users/tangyuwei/Downloads/"+rfileName);
//			try (Scanner myReader = new Scanner(myFile)) {
//				int i=0;
//				while(i<5) {
//					String data=myReader.nextLine();
//					readedFile.append(data+"\n");
//					i++;
//				}
//			} 
//		} catch (FileNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		try {
//			String wfileName=writeFile.getText();
//			FileWriter myWriter=new FileWriter("/Users/tangyuwei/Downloads/"+wfileName);
//			Scanner read = new Scanner(myFile);
//			while(read.hasNext()) {
//			myWriter.write(read.next());
//			}
//			myWriter.close();
//				int i=0;
//				while(i<5) {
//					String data=read.nextLine();
//					wroteFile.append(data+"\n");
//					i++;
//				}
//			
//			
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
//}
		
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GUIDataFIle c=new GUIDataFIle();
		c.setSize(400, 400);
		c.setVisible(true);
		c.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
	}

}
