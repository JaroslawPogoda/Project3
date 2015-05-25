
/*
 * @Author Jaroslaw Pogoda
 * Description: Chose size frame
 */
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class sizeFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	static BufferedWriter in;
	public sizeFrame(String[] args,int[][] qh) throws IOException{
		super("Choose Size Jaroslaw Pogoda");
		in = new BufferedWriter(new FileWriter("OutputFile_Jaroslaw_Pogoda_Assignment3.txt"));
		setLocation(400,400);
		setSize(528,200);
		JTextArea kl=new JTextArea();
		kl.append(" Please Choose size of the Array:\n Please close program to see entire result.\n Program Created by Jaroslaw Pogoda");
		JButton b50 = new JButton("Size of     " + 50);
		JPanel content= new JPanel();
		content.setLayout(new BoxLayout(content, BoxLayout.LINE_AXIS));
		kl.setEditable(false);
		setLayout(new GridLayout(2,1));
		add(kl);
		content.add(b50);
		JButton b250 = new JButton("Size of   " + 250);
		JButton b1000 = new JButton("Size of " + 1000);
		JButton b2500 = new JButton("Size of " + 2500);
		JButton b5000 = new JButton("Size of " + 5000);
		content.add(b250);
		content.add(b1000);
		content.add(b2500);
		content.add(b5000);
		add(content);
		b50.setMnemonic(KeyEvent.VK_M);
		b50.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
					Frame frame= new Frame(50,in,qh);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		b250.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
					Frame frame= new Frame(250,in,qh);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		b1000.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
					Frame frame= new Frame(1000,in,qh);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		b2500.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
					Frame frame= new Frame(2500,in,qh);
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		b5000.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			
					try {
						Frame frame= new Frame(5000,in,qh);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				
			}
		});
		addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				
				try {
					in.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Runtime runtime = Runtime.getRuntime();
			    try {
			     Process process =runtime.exec("cmd /c OutputFile_Jaroslaw_Pogoda_Assignment3.txt");
			    } catch (IOException e3) {
			     // TODO Auto-generated catch block
			     e3.printStackTrace();
			    }
			    Main.launch(Main.class, args);
			    
			 System.exit(0); 
			}
			
		});
		setVisible(true);
	}
	
}
