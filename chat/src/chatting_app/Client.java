package chatting_app;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.io.DataInputStream;
import java.io.*;
import java.net.*;
import java.util.Calendar;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.util.*;
import java.text.*;
public class Client  implements ActionListener
{
	JTextField text;
	static JPanel a1;
	static Box vertical=Box.createVerticalBox();
	static DataOutputStream dout;
	static JFrame f=new JFrame();
	public Client() 
	{
		f.setLayout(null);
		JPanel p1=new JPanel();
		p1.setBackground(new Color(169,169,169));
		p1.setBounds(0, 0, 450, 70);
		p1.setLayout(null);
		f.add(p1);
		ImageIcon l1=new ImageIcon(ClassLoader.getSystemResource("icons/3.png"));
		Image l2=l1.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
		ImageIcon l3=new ImageIcon(l2);
		JLabel back=new JLabel(l3);
		back.setBounds(5, 20, 25, 25);
		p1.add(back);
		back.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me)
			{
				//setVisible(false);
				System.exit(0);
			}
		});
		
		ImageIcon l4=new ImageIcon(ClassLoader.getSystemResource("icons/2.png"));
		Image l5=l4.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		ImageIcon l6=new ImageIcon(l5);
		JLabel profile=new JLabel(l6);
		profile.setBounds(40, 10, 50, 50);
		p1.add(profile);
		
		ImageIcon l7=new ImageIcon(ClassLoader.getSystemResource("icons/video.png"));
		Image l8=l7.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
		ImageIcon l9=new ImageIcon(l8);
		JLabel video=new JLabel(l9);
		video.setBounds(300, 20, 30, 30);
		p1.add(video);
		
		ImageIcon l10=new ImageIcon(ClassLoader.getSystemResource("icons/phone.png"));
		Image l11=l10.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
		ImageIcon l12=new ImageIcon(l11);
		JLabel phone=new JLabel(l12);
		phone.setBounds(360, 20, 35, 30);
		p1.add(phone);
		

		ImageIcon l13=new ImageIcon(ClassLoader.getSystemResource("icons/3icon.png"));
		Image l14=l13.getImage().getScaledInstance(10, 25, Image.SCALE_DEFAULT);
		ImageIcon l15=new ImageIcon(l14);
		JLabel morevert=new JLabel(l15);
		morevert.setBounds(420, 20, 10, 25);
		p1.add(morevert);
		
		JLabel name=new JLabel("Jack");
		name.setFont(new Font("SAN_SARIF", Font.BOLD , 20));
		name.setBounds(110,15,100,18);
		name.setForeground(Color.white);
		p1.add(name);
		
		JLabel status=new JLabel("Active Now");
		status.setFont(new Font("SAN_SARIF", Font.BOLD , 12));
		status.setBounds(110,35,100,18);
		status.setForeground(Color.white);
		p1.add(status);
		 
		 a1=new JPanel();
		a1.setBounds(5, 75, 440, 570);
		f.add(a1);
		
		 text=new JTextField();
		text.setBounds(5, 655, 310, 40);
		text.setFont(new Font("SAN_SARIF",Font.PLAIN,20));
		f.add(text);
		
		JButton send= new JButton("Send");
		send.setBounds(320, 655, 123, 40);
		send.setBackground(new Color(7,94,84));
		send.setForeground(Color.white);
		send.addActionListener(this);
		send.setFont(new Font("SAN_SARIF",Font.PLAIN,20));
		f.add(send);
		
		f.setSize(450, 700);
		f.setLocation(200, 50);
		f.setUndecorated(true);
		f.getContentPane().setBackground(Color.white);
		f.setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		try
		{
		String out=text.getText();
		JPanel p2=formatLabel(out);
		a1.setLayout(new BorderLayout());
		JPanel right=new JPanel(new BorderLayout());
		right.add(p2, BorderLayout.LINE_END);
		vertical.add(right);
		vertical.add(Box.createHorizontalStrut(15));
		a1.add(vertical, BorderLayout.PAGE_START);
		dout.writeUTF(out);
		text.setText("");
		f.repaint();
		f.invalidate(); 
		f.validate();
		}
		catch(Exception e)
		{
			e.printStackTrace(); 
		}
    }
	public static JPanel formatLabel(String out)
	{
		JPanel panel =new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		JLabel output=new JLabel("<html><p style=\"width:150px\">"+out+"</p></html>");
		output.setFont(new Font("Tahoma", Font.PLAIN, 16));
		output.setBackground(new Color(37,211,102));
		output.setOpaque(true);
		output.setBorder(new EmptyBorder(15,15,15,50));
		panel.add(output);	
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat sdf=new SimpleDateFormat("HH:MM");
		JLabel time=new JLabel();
		time.setText(sdf.format(cal.getTime()));
		panel.add(time);
		return panel;
	}
public static void main(String []args)
{
	new Client();
	try {
		Socket s=new Socket("127.0.0.1",1009); // local host, port number
		DataInputStream din=new DataInputStream(s.getInputStream()); //for receive messages
		 dout=new DataOutputStream(s.getOutputStream()); // for sending messages
		 while(true)
			{  
			 a1.setLayout(new BorderLayout());
				String msg=din.readUTF(); // for reading messages
				JPanel panel=formatLabel(msg);
				JPanel left=new JPanel(new BorderLayout());
				left.add(panel,BorderLayout.LINE_START); // display message to left side
				vertical.add(left);
				vertical.add(Box.createVerticalStrut(15));
				a1.add(vertical,BorderLayout.PAGE_START);
				f.validate();
			}
	} 
	catch (Exception e) 
	{
		e.printStackTrace();
	}
}
}

