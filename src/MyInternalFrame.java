
/*
 * @Author Jaroslaw Pogoda
 * Descripion:Creates inner frames from JMenuBar options for sorting  array
 */
import java.awt.BorderLayout;
import java.io.BufferedWriter;
import java.io.IOException;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

class MyInternalFrame extends JInternalFrame {
	
	int size=0;
	protected int[] arr;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static int xPosition = 300;
	static int yPosition = 0;
	public MyInternalFrame(int size2, Initialize c, String s,BufferedWriter in, int openFrameCount)throws IOException {		
		super("IFrame #" + (openFrameCount=openFrameCount+1)+s, true, // resizable
				true, // closable
				true, // maximizable
				true);// iconifiable
		setSize(300, 300);
		int minus=1;
		if(openFrameCount>=5){
			yPosition=300;
			minus=5;
		}
		// Set the window's location.
		setLocation(xPosition * (openFrameCount-minus), yPosition
				);
		JTextArea text=new JTextArea();
		JScrollPane scrollPane = new JScrollPane(text);
		text= setTextRand(size2,c,s,in);
		add(text,BorderLayout.NORTH);	
		JScrollPane scrollbar = new JScrollPane(text);
		add(scrollbar,BorderLayout.SOUTH);
	}
	public JTextArea setTextRand(int size,Initialize c, String s,BufferedWriter in) throws IOException{
		JTextArea text= new JTextArea();
		int v=1,h=0;
		int[] array = {0};
		String s2="",s3="";
		switch(s){
			case  "Selection Sort": array=c.getSSort(c.getArray());
					break;
			case  "Insertion Sort": array=c.getISort(c.getArray());
					break;
			case "Heap Sort": array=c.getHSort(c.getArray());
					break;
			case "Quick Sort": array=c.getQSort(c.getArray());
					break;
			case "Random Array": array=c.getArray();
					break;
		}
		text.append("First fifty digits of "+s+" are:\n");
		s2+="First fifty digits of "+s+" are:\n";
		for(int num=0;num<50;num++){
			
			text.append(array[num]+", ");
			s2+=array[num]+", ";
			if(num+1==7*v){
				v++;
				text.append("\n");
			}
		}
		text.append("\n Last five digits are:\n");
		s3+="\n Last five digits are:\n";
		for(int num2=array.length-5;num2<array.length;num2++){
			text.append(array[num2]+", ");
			s3+=array[num2]+", ";
		}
		in.append(s2);
		in.newLine();
		in.append(s3);
		in.newLine();
		text.setEditable(false);
		return text;
	}
	public void setSize(int s){
		size=s;
	}
	public int[] getArray(){
		return arr;
	}
}