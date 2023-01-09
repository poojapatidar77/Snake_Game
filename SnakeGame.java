import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.*;

class Fdemo extends JFrame
{
	Fdemo()
	{
		JPdemo jp=new JPdemo();
		add(jp);
	}
	class JPdemo extends JPanel  implements ActionListener,KeyListener
	{
		int x[]=new int[100];
		int y[]=new int[100];
		boolean right=true,left=false,up=false,down=false;
		int dots=5;
		int h=0;
		int time=500;
		int r1,r2;
		int count=0;;
		boolean start_game=false;
		JPdemo()
		{
			x[0]=120;
			x[1]=100;
			x[2]=80;
			x[3]=60;
			x[4]=40;
			y[0]=100;
			y[1]=100;
			y[2]=100;
			y[3]=100;
			y[4]=100;
			
			Font f=new Font("",Font.BOLD,30);
            setBackground(Color.black);
              Timer t=new Timer(700,this);
               t.start();
			   setFocusable(true);
              addKeyListener(this);			   
                randomdemo();			   
        }
		void randomdemo()
		{
			r1=(int)Math.round(Math.random()*40+1);
			r1*=20;
			r2=(int)Math.round(Math.random()*40+1);
			r2*=20;
			
		}
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
		 g.setColor(Color.red);
			g.fillRect(r1,r2,20,20);
		 g.setColor(Color.green);
			for(int i=0;i<dots;i++)
			{ 
				if(i==0)
				{
			     g.fillRect(x[i],y[i],20,20);
				}
				else
				{
			     g.drawRect(x[i],y[i],20,20);
				}
                  g.drawRect(0,0,900,900);				
			     
		 g.setColor(Color.white);
		Font f=new Font("",Font.BOLD,20);
		g.setFont(f);
		g.drawString("Score Board",50,20);
		g.drawString("Score  "+count,50,40); }
		}
		public void actionPerformed(ActionEvent e)
		{
		   if(x[0]==r1 && y[0]==r2)
		   { 
			   dots++;
              count++;			 
			// if(count%5==0)time+=50;
			 randomdemo();
		   }
		  if(x[0]<=0 || y[0]<=0 || x[0]>=900 ||y[0]>=900)
		  {
			  start_game=false;
			  Font f=new Font("",Font.BOLD,80);
			  JLabel lb=new JLabel("Game Over");
			  lb.setBounds(300,400,500,100);
			  lb.setFont(f);
			  add(lb);
		  }
		  for(int i=1;i<dots;i++)
		  {
			  if(x[0]==x[i]&&y[0]==y[i])
			  {
			  start_game=false;
			  Font f=new Font("",Font.BOLD,80);
			  JLabel lb=new JLabel("Game Over");
			  lb.setBounds(300,400,500,100);
			  lb.setFont(f);
			  add(lb);
			  }
		  }
		  if(start_game)
		   {			   
			for(int i=dots;i>0;i--)
			{ 
				x[i]=x[i-1];
				y[i]=y[i-1];
				
			}
			if(right )
			{
			x[0]=x[0]+20;
			}
			if(left)
			{
			x[0]=x[0]-20;
			}
			if(up)
			{
			y[0]=y[0]-20;
			}
		   if(down)
		   {
			y[0]=y[0]+20; 
		   }
			if(x[0]==x[2]&&y[0]==y[2])
			{
				if(left)
				{
				y[0]+=20;
				x[0]+=20;
				}
				if(right)
				{
					y[0]+=20;
					x[0]-=20;
				}
			}
			if(x[0]==x[2]&&y[0]==y[2])
			{	
			if(up)
				{
					x[0]+=20;
					y[0]+=20;
				}
				if(down)
				{
					x[0]+=20;
					y[0]-=20;
				}
			}
		   }
			repaint();
		}
		public void keyPressed(KeyEvent e)
		{
		   start_game=true;
		   if(e.getKeyCode()==KeyEvent.VK_ENTER)
		   {
			   start_game=false;
		   }
		   if(e.getKeyCode()==KeyEvent.VK_RIGHT)
		   { 
	         right=true;
			 left=false;
			 up=false;
			 down=false;
		   }
		   if(e.getKeyCode()==KeyEvent.VK_LEFT)
		   { 
	         right=false;
			 left=true;
			 up=false;
			 down=false;
		   }
		   if(e.getKeyCode()==KeyEvent.VK_UP)
		   { 
	         right=false;
			 left=false;
			 up=true;
			 down=false;
		   }
		   if(e.getKeyCode()==KeyEvent.VK_DOWN)
		   { 
	         right=false;
			 left=false;
			 up=false;
			 down=true;
		   }
		   
		}
		public void keyReleased(KeyEvent e)
		{
		}
		public void keyTyped(KeyEvent e)
		{
		}
		  
	}
}
class demo
{
	public static void main(String ar[])
	{
		Fdemo f=new Fdemo();
		f.setVisible(true);
		f.setSize(900,900);
		f.setLocation(100,100);
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
	}
}

