
/*
 * @Author Jaroslaw Pogoda
 * Description: creates outer Frame to sort functions
 */
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.IOException;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
public class Frame extends JFrame{
	private JDesktopPane jdpDesktop;
	MyInternalFrame frame;
	static int openFrameCount=0;
	static int y=0;
	public Frame(int sizes, BufferedWriter in,int[][] r) throws IOException{
		super("Random Number Jaroslaw Pogoda");
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int inset=50;
		setBounds(inset, inset, screenSize.width - inset * 2,screenSize.height - inset * 2);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				r[0][y]=Sort.getSwork();
				r[1][y]=Sort.getIwork();
				r[2][y]=Sort.getQwork();
				r[3][y++]=Sort.getHwork();
				try {
					
					in.append(Sort.intoAFile(sizes));
					
					in.newLine();
					in.newLine();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Sort.zeroWork();
				MyInternalFrame.yPosition=0;
				openFrameCount=0;
			}
		});
		jdpDesktop = new JDesktopPane();
		setContentPane(jdpDesktop);
		Initialize c= new Initialize(sizes);
		setJMenuBar(createMenuBar(sizes,c,in));
		jdpDesktop.putClientProperty("JDesktopPane.dragMode", "outline");
		setVisible(true);
		

	}
	
	private JMenuBar createMenuBar(int size,Initialize c, BufferedWriter in) {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Frame");
		menu.setMnemonic(KeyEvent.VK_N);
		JMenuItem menuItem = new JMenuItem("Random Array");
		menuItem.setMnemonic(KeyEvent.VK_N);
		menuItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand()=="Random Array"){
						try {
							createFrame(size,c,"Random Array",in);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				}
			}
			
		});
		JMenuItem menuItem1 = new JMenuItem("Insertion Sort Array");
		menuItem1.setMnemonic(KeyEvent.VK_0);
		menuItem1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand()=="Insertion Sort Array"){
						try {
							createFrame(size,c,"Insertion Sort",in);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				}
			}
		});
		JMenuItem menuItem2 = new JMenuItem("Selection Sort Array");
		menuItem2.setMnemonic(KeyEvent.VK_0);
		menuItem2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand()=="Selection Sort Array"){
						try {
							createFrame(size,c,"Selection Sort",in);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				}
			}
		});
		JMenuItem menuItem3 = new JMenuItem("Heap Sort Array");
		menuItem3.setMnemonic(KeyEvent.VK_0);
		menuItem3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand()=="Heap Sort Array"){
						try {
							createFrame(size,c,"Heap Sort",in);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				}
			}
		});
		JMenuItem menuItem4 = new JMenuItem("Quick Sort Array");
		menuItem4.setMnemonic(KeyEvent.VK_0);
		menuItem4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand()=="Quick Sort Array"){
						try {
							createFrame(size,c,"Quick Sort",in);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				}
			}
		});
		JMenuItem menuItem5 = new JMenuItem("Run allSort Array");
		menuItem5.setMnemonic(KeyEvent.VK_N);
		menuItem5.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand()=="Run allSort Array"){
						try {
							
							createFrame(size,c,"Random Array",in);
							createFrame(size,c,"Insertion Sort",in);
							createFrame(size,c,"Selection Sort",in);
							createFrame(size,c,"Heap Sort",in);
							createFrame(size,c,"Quick Sort",in);
							
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				}
			}
			
		});
		menu.add(menuItem5);
		menu.add(menuItem);
		menu.add(menuItem4);
		menu.add(menuItem3);
		menu.add(menuItem1);
		menu.add(menuItem2);
		menuBar.add(menu);
		return menuBar;
	}
	private void createFrame(int size,Initialize c, String s, BufferedWriter in) throws IOException{
		frame = new MyInternalFrame(size,c,s,in,openFrameCount++);
		
		frame.setVisible(true);
		// Every JInternalFrame must be added to content pane using JDesktopPane
		jdpDesktop.add(frame);
		try {
			frame.setSelected(true);
		} catch (java.beans.PropertyVetoException e) {
		}
	}
	public int[] getArray(){
		return frame.getArray();
	}
	
}
