import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.*;


public class Sea {	
	
	public static void main(String[] args) throws ClassNotFoundException, IOException{		
		MyFrame frame = new MyFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("����");			
		frame.show();
}}
class MyFrame extends JFrame {	
	public MyFrame() {
		setSize(1280,730);
		MyPanel panel = new MyPanel();
		Container pane = getContentPane();
		pane.add(panel);
		//Cursor c1 = Toolkit.getDefaultToolkit().createCustomCursor((new ImageIcon(new byte[0])).getImage(), new Point(0,0),	"custom");
		//pane.setCursor(c1);
}}
class MyPanel extends JPanel {
	Draw draw = new Draw();
	Player player = new Player();
	Rectangle key=new Rectangle(500,50,220,35);
	int x,y;//������
	MyPanel(){				
		addMouseMotionListener( new MyMouse());
		addMouseListener( new MyMouse());
		System.out.println("�2 �����������");
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		setBackground(new Color(120,220,255));
		//������
		//g.fillOval(x, y, 10, 10);//
		//������
		g.drawRoundRect(500,50,220,35,10,10);
		g.drawString("���������� �������: "+player.getClickCount(), 540, 70);
		
	}
	public class MyMouse extends MouseAdapter implements MouseMotionListener{				  				
		   
		public void mousePressed(MouseEvent event){					
				if(key.contains(event.getPoint())){player.click();draw.rePaint();}						
																	
					}		

		public void mouseDragged(MouseEvent e) {
			//System.out.println(e.getX());
			
		}

		public void mouseMoved(MouseEvent e) {
			x=e.getX();
			y=e.getY();
			
		}
		
	}
	/**
	* Created by Andrej on 15.02.2016.
	*/
	 class Draw {
	   Graphics2D graphics;

	   /*public Draw(Graphics2D g){
	       graphics = g;
	   }*/

	   public void rePaint(){
		   repaint();
	   }
	}
}


/**
* Created by Andrej on 15.02.2016.
*/
 class Player {
   	private int clickCount, energy, lvl;
	private Collection<Power> powers;

	public void update(){
		energy++;//переделать под формулу
	}

   public int getClickCount(){
       return clickCount;
   }

   public boolean click(){
       clickCount++;
       return true;
   }

}