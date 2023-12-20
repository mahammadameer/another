package pack1;

import java.applet.AppletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main 
{
public static void main(String[] args)
{
	ApplicationContext contest=new ClassPathXmlApplicationContext("sample (1).xml");
	Employee e1=(Employee) contest.getBean("emp", Employee.class);
	System.out.println(e1);
}
}
