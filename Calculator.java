import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
class SimpleCalci extends JFrame implements ActionListener
{
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bp,bm,bd,bmul,beq,bc,bdot;
	JTextField t1;
	String s0="";
	String s1="";
	String s2="";
	SimpleCalci()
	{
		t1=new JTextField();
		t1.setBounds(20,20,200,25);
		this.add(t1);
		b1=new JButton("1");
		b1.setBounds(15,55,45,25);
		this.add(b1);
		b2=new JButton("2");
		b2.setBounds(70,55,45,25);
		this.add(b2);
		b3=new JButton("3");
		b3.setBounds(125,55,45,25);
		this.add(b3);
		bp=new JButton("+");
		bp.setBounds(180,55,45,25);
		this.add(bp);
		b4=new JButton("4");
		b4.setBounds(15,90,45,25);
		this.add(b4);
		b5=new JButton("5");
		b5.setBounds(70,90,45,25);
		this.add(b5);
		b6=new JButton("6");
		b6.setBounds(125,90,45,25);
		this.add(b6);
		bm=new JButton("-");
		bm.setBounds(180,90,45,25);
		this.add(bm);
		b7=new JButton("7");
		b7.setBounds(15,125,45,25);
		this.add(b7);
		b8=new JButton("8");
		b8.setBounds(70,125,45,25);
		this.add(b8);
		b9=new JButton("9");
		b9.setBounds(125,125,45,25);
		this.add(b9);
		bmul=new JButton("*");
		bmul.setBounds(180,125,45,25);
		this.add(bmul);
		bc=new JButton("C");
		bc.setBounds(15,160,45,25);
		this.add(bc);
		b0=new JButton("0");
		b0.setBounds(70,160,45,25);
		this.add(b0);
		bdot=new JButton(".");
		bdot.setBounds(125,160,45,25);
		this.add(bdot);
		bd=new JButton("/");
		bd.setBounds(180,160,45,25);
		this.add(bd);
		beq=new JButton("=");
		beq.setBounds(95,190,45,25);
		this.add(beq);
		t1.setEditable(false);
		b0.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		bp.addActionListener(this);
		bm.addActionListener(this);
		bmul.addActionListener(this);
		bd.addActionListener(this);
		beq.addActionListener(this);
		bdot.addActionListener(this);
		bc.addActionListener(this);
		this.setResizable(false);
		this.setLayout(null);
		this.setSize(250,250);
		this.setTitle("Simple Calculator");
		this.getContentPane().setBackground( Color.gray );
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter(){
		public void windowClosing(WindowEvent e)
		{
			dispose();
		}
		});
	}
	public void actionPerformed(ActionEvent ae)
	{	
	      try{
		String s=ae.getActionCommand();
		if(s.charAt(0)>='0'&&s.charAt(0)<='9'||s.charAt(0)=='.')
		{
			if(!s1.equals(""))
			{
				s2=s2+s;
			}
			else
			{
				s0=s0+s;
			}
			t1.setText(s0+s1+s2);
		}
		else if(ae.getSource()==bc)
		{
			
			s0=s1=s2="";
			t1.setText(s0+s1+s2);
		}
		else if(s.charAt(0)=='=')
		{
			double result;
			if(s1.equals("+"))
			{
				result=(Double.parseDouble(s0)+Double.parseDouble(s2));
			}
			else if(s1.equals("-"))
			{
				result=(Double.parseDouble(s0)-Double.parseDouble(s2));
			}
			else if(s1.equals("*"))
			{
				result=(Double.parseDouble(s0)*Double.parseDouble(s2));
			}
			else
			{
				result=(Double.parseDouble(s0)-Double.parseDouble(s2));
			}
			t1.setText(s0+s1+s2+"="+result);
			s0=Double.toString(result);
			s1=s2="";
		}
		else
		{
			if(s1.equals("")||s2.equals(""))
			{
				s1=s;
			}
			else
			{
				double result;
				if(s1.equals("+"))
				{
					result=(Double.parseDouble(s0)+Double.parseDouble(s2));
				}
				else if(s1.equals("-"))
				{
					result=(Double.parseDouble(s0)-Double.parseDouble(s2));
				}
				else if(s1.equals("*"))
				{
					result=(Double.parseDouble(s0)*Double.parseDouble(s2));
				}
				else
				{
					result=(Double.parseDouble(s0)-Double.parseDouble(s2));
				}
				s0=Double.toString(result);
				s1=s;
				s2="";
			}
			t1.setText(s0+s1+s2);
		}
	       }
	       catch(Exception e)
                          {
		System.out.println(""+e);
	       }
	}
}
class Calculator
{
	public static void main(String[] args)
	{
		SimpleCalci c=new SimpleCalci();
	}
}