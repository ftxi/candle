package upgraded;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class candle extends JFrame implements KeyListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static void main(String args[])
	{
		new candle();
	}
	
	candle()
	{
		this.setTitle("candle");
		this.addKeyListener(this);
		this.setSize(40+2*half_window_size, 40+2*half_window_size);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	//double delta = 0.15;
	double delta2 = 0.15;
	int unit = 60;
	int maxt = 160;
	int half_window_size = 360;
	
	double sin(double x)
	{
		return Math.sin(x);
	}
	double cos(double x)
	{
		return 2*Math.cos(x);
	}
	
	double r(double phi)
	{
		return -3*Math.exp(-3*Math.pow(phi-Math.PI/2,4))/Math.sqrt(2*Math.PI);
	}
	
	double x(double t)
	{
		return Math.PI/4*(sin(t)+sin(3*t)/3+sin(5*t)/5+sin(7*t)/7+sin(9*t)/9+
				sin(11*t)/11+sin(13*t)/13+sin(15*t)/15+sin(17*t)/17);
	}
	double y(double t)
	{
		return cos(t)+1;
	}
	
	double x2(double t)
	{
		return cos(t/60)*r(t/60)/3;
	}
	
	double y2(double t)
	{
		return -sin(t/60)*r(t/60)-3.2+0.05*sin(t);
	}
	
	int resize(double r)
	{
		return (int) (r*unit+half_window_size+20);
	}
	/*
	String status1 = "started.", status2 = "", status3 = "";
	void showStatus(String msg)
	{
		status3 = status2;
		status2 = status1;
		status1 = msg;
	}
	*/
	public void paint(Graphics g)
	{
		g.setColor(Color.white);
		g.fillRect(20, 20, 2*half_window_size, 2*half_window_size);
		/*
		g.setColor(Color.lightGray);
		g.drawLine(20+half_window_size, 20, 20+half_window_size, 20+2*half_window_size);
		g.drawLine(20, 20+half_window_size, 20+2*half_window_size, 20+half_window_size);
		for(int r = unit; r < half_window_size; r+=unit)
		{
			g.drawLine(20+half_window_size + r, 18+half_window_size, 20+half_window_size + r, 22+half_window_size);
			g.drawLine(20+half_window_size - r, 18+half_window_size, 20+half_window_size - r, 22+half_window_size);
			g.drawLine(18+half_window_size, 20+half_window_size + r, 22+half_window_size, 20+half_window_size + r);
			g.drawLine(18+half_window_size, 20+half_window_size - r, 22+half_window_size, 20+half_window_size - r);
		}*/
		//axies
		
		double x, y, _x = x(0), _y = y(0);
		for(double t = delta2; t < maxt; t+=delta2)
		{
			//g.setColor(new Color((int)(35+10*Math.cos(t)),(int)(118+10*Math.cos(t)),(int)(28+10*Math.cos(t))));
			g.setColor(Color.lightGray);
			x = x(t);
			y = y(t);
			g.drawLine(resize(_x), resize(_y), resize(x), resize(y));
			_x = x;
			_y = y;
		}
		
		g.setColor(Color.RED);
		_x = x2(0);
		_y = y2(0);
		for(double d = 2.5; d < 20; d+=0.3)
			for(double t = d; t < maxt; t+=d)
			{
				g.setColor(new Color(255,(int)(d*6)+128, 128));
				//g.setColor(new Color((int)(35+10*Math.cos(t)),(int)(118+10*Math.cos(t)),(int)(28+10*Math.cos(t))));
				x = x2(t);
				y = y2(t);
				g.drawLine((int)(resize(_x*(20-d)/16)), (int)(resize(_y)*(100-d)/80),
						(int)(resize(x*(20-d)/16)), (int)(resize(y)*(100-d)/80));
				_x = x;
				_y = y;
			}
		/*
		g.setFont(new Font("dialog", 10, 10));
		g.setXORMode(Color.darkGray);
		g.drawString(status1, 20, this.getHeight()-20);
		g.setXORMode(Color.gray);
		g.drawString(status2, 20, this.getHeight()-35);
		g.setXORMode(Color.lightGray);
		g.drawString(status3, 20, this.getHeight()-50);
		g.setPaintMode();
		*/
	}
	@Override
	public void keyTyped(KeyEvent e) 
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent ke) 
	{
		//int key = ke.getKeyCode();
		/*
		switch(key)
		{
		case KeyEvent.VK_EQUALS:
			half_window_size += 10;
			this.setSize(40+2*half_window_size, 40+2*half_window_size);
			break;

		case KeyEvent.VK_MINUS:
			if(half_window_size>60)
				half_window_size -= 10;
			this.setSize(40+2*half_window_size, 40+2*half_window_size);
			break;
			
		case KeyEvent.VK_COMMA:
			if(unit>3)
				unit -= 2;
			break;
			
		case KeyEvent.VK_PERIOD:
			unit += 2;
			break;
			
		case KeyEvent.VK_SEMICOLON:
			delta *= Math.sqrt(Math.sqrt(2));
			showStatus("delta = "+delta);
			break;
			
		case KeyEvent.VK_QUOTE:
			if(delta>0.001)
				delta /= Math.sqrt(Math.sqrt(2));
			showStatus("delta = "+delta);
			break;
		}
		*/
		repaint();
	}
	@Override
	public void keyReleased(KeyEvent e) 
	{
		// TODO Auto-generated method stub
		
	}
}
