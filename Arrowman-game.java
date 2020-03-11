import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Demo implements ActionListener
{
	JFrame fr;
	JLabel lar,lb1,lb2,lb3,lb4,lam,lal,lhl;
	Timer t1,t2,t3,t4,t5,tbr1,tbr2,tbr3,tbr4;
	ImageIcon icgb,icbb,icar,icam,ichl,icsb;
	JButton bshoot,bta,bexit;
	int i=10,j=700,k=700,l=700,m=700,y1=0,y2=0,y3=0,y4=0,xp=0;
	int count1=0,count2=0,count3=0,count4=0,arcount=6,cwin=0;

	public Demo()
	{
		fr = new JFrame("Arrow Man Game");
		fr.getContentPane().setBackground(Color.WHITE); 
		icgb = new ImageIcon("Images/Balloon.png");
		icar = new ImageIcon("Images/Arrow.png");
		icbb = new ImageIcon("Images/Bechara.png");
		icam = new ImageIcon("Images/Arrowman.jpg");
		ichl = new ImageIcon("Images/Line.png");
		icsb = new ImageIcon("Images/shootballoon.png");

		Font ft = new Font("Showcard Gothic",Font.BOLD,28);

	//Labels
		lar = new JLabel();   	//Arrow
		lar.setIcon(icar);
		lb1 = new JLabel();	//Balloon1
		lb1.setIcon(icgb);
		lb2 = new JLabel();	//Balloon2
		lb2.setIcon(icgb);
		lb3 = new JLabel();	//Balloon3
		lb3.setIcon(icgb);
		lb4 = new JLabel();	//Balloon4
		lb4.setIcon(icgb);
		lal = new JLabel("6 ARROW(S) left !");	//Arrows Left
		lal.setBounds(15,20,300,30);lal.setFont(ft);

		lam = new JLabel(); 	 //ArrowMan
		lam.setIcon(icam);
		lam.setBounds(5,60,250,138);

		lhl = new JLabel(); 	 //Horizintal Line
		lhl.setIcon(ichl);
		lhl.setBounds(1,52,13000,6);

	//Buttons
		bshoot = new JButton("Shoot");
		bshoot.setIcon(icsb);
		bshoot.setBounds(10,400,90,100);
		bshoot.addActionListener(this);

		bta = new JButton("Restart");
		bta.setBounds(10,550,100,30);
		bta.addActionListener(this);

		bexit = new JButton("EXIT");
		bexit.setBounds(10,600,100,30);
		bexit.addActionListener(this);


	//ballon 1	
		ActionListener act1 = new ActionListener()
		{
			public void actionPerformed(ActionEvent ac)
			{
				if(j>50)
				{
					lb1.setBounds(400,j,60,60);
					j-=20;
				}
				if(j<50)
				j=700;
			}
		};
		t1 = new Timer(300,act1);

	//balloon 2	
		ActionListener act2 = new ActionListener()
		{
			public void actionPerformed(ActionEvent ac)
			{
				if(k>50)
				{
					lb2.setBounds(600,k,60,60);
					k-=20;
				}
				if(k<50)
				k=700;
			}
		};
		t2 = new Timer(250,act2);

	//balloon 3	
		ActionListener act3 = new ActionListener()
		{
			public void actionPerformed(ActionEvent ac)
			{
				if(l>50)
				{
					lb3.setBounds(800,l,60,60);
					l-=20;
				}
				if(l<50)
				l=700;
			}
		};
		t3 = new Timer(200,act3);

	//balloon 4
		ActionListener act4 = new ActionListener()
		{
			public void actionPerformed(ActionEvent ac)
			{
				if(m>50)
				{
					lb4.setBounds(1000,m,60,60);
					m-=20;
				}
				if(m<50)
				m=700;
			}
		};
		t4 = new Timer(150,act4);
		
	//Frame setting
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		fr.setLayout(null);
		fr.add(lhl);
		fr.add(lam);
		fr.add(lar);
		fr.add(bshoot);
		fr.add(bta);
		fr.add(bexit);
		fr.add(lb1);
		fr.add(lb2);
		fr.add(lb3);
		fr.add(lb4);
		fr.add(lal);
		fr.setSize(1100,700);
		fr.setVisible(true);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JOptionPane.showMessageDialog(fr,"You will get 6 Arrows to hit the balloons. Best of Luck!");
	}


//Arrow Method
	public void arrow()
	{ 	
		i=20;
		bshoot.setEnabled(false);
		ActionListener acta = new ActionListener()
		{
			public void actionPerformed(ActionEvent ac)
			{
				lar.setBounds(i,105,300,50);
				i+=40;
				y1 = lb1.getY();
				y2 = lb2.getY();
				y3 = lb3.getY();
				y4 = lb4.getY();
				xp = lar.getX();
				
				if((y1<=155 && y1>=105)&&(xp>=280 && xp<=340))
				{
					count1++;
					lb1.setIcon(icbb);
					tbr1 = new Timer(350,new ActionListener(){public void actionPerformed(ActionEvent act){lb1.setBounds(400,j,60,60);j+=10;}});
					t1.stop();
					tbr1.start();
					if(count4>0 && count2>0 && count3>0)
					{
						JOptionPane.showMessageDialog(fr,"You Won the GAME!!");
						cwin++;
					}
				}
				if((y2<=155 && y2>=105)&&(xp>=480 && xp<=540))
				{
					count2++;
					lb2.setIcon(icbb);
					tbr2 = new Timer(350,new ActionListener(){public void actionPerformed(ActionEvent act){lb2.setBounds(600,k,60,60);k+=10;}});
					t2.stop();
					tbr2.start();
					if(count1>0 && count4>0 && count3>0)
					{
						JOptionPane.showMessageDialog(fr,"You Won the GAME!!");
						cwin++;
					}
				} 
				if((y3<=155 && y3>=105)&&(xp>=680 && xp<=740))
				{
					count3++;
					lb3.setIcon(icbb);
					tbr3 = new Timer(350,new ActionListener(){public void actionPerformed(ActionEvent act){lb3.setBounds(800,l,60,60);l+=10;}});
					t3.stop();
					tbr3.start();
					if(count1>0 && count2>0 && count4>0)
					{
						JOptionPane.showMessageDialog(fr,"You Won the GAME!!");
						cwin++;
					}
				} 
				if((y4<=155 && y4>=105)&&(xp>=880 && xp<=940))
				{
					count4++;
					lb4.setIcon(icbb);
					tbr4 = new Timer(350,new ActionListener(){public void actionPerformed(ActionEvent act){lb4.setBounds(1000,m,60,60);m+=10;}});
					t4.stop();
					tbr4.start();
					if(count1>0 && count2>0 && count3>0)
					{
						JOptionPane.showMessageDialog(fr,"You Won the GAME!!");
						cwin++;
					}
				} 
				if(xp>1130 && cwin==0)
				{
					t5.stop();
					if(arcount>1)
					{
						arcount--;
						bshoot.setEnabled(true);
						lal.setText(arcount+" ARROW(S) left !");
					}
					else
					{
						bshoot.setEnabled(false);
						lal.setText("GAME OVER !");
						JOptionPane.showMessageDialog(fr,"Better Luck Next Time!");
					}
				}
			}
		};
		t5 = new Timer(50,acta);
		t5.start();			
	}

//Shoot Method
	public void actionPerformed(ActionEvent act)
	{
		if(act.getSource()==bshoot)
		{	
			arrow();
		}
		if(act.getSource()==bta)
		{	
			new Demo();
		}
		if(act.getSource()==bexit)
		{	
			System.exit(0);
		}
	}
	
//Main
	public static void main(String[] args)
	{
		new Demo();
	}                                                                                                    
}
