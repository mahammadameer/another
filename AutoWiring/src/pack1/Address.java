package pack1;

public class Address 
{
public String city;
public int pin;
public String getCity()
{
	return city;
}
public void setCity(String city)
{
	this.city = city;
}
public int getPin()
{
	return pin;
}
public void setPin(int pin) 
{
	this.pin = pin;
}
@Override
public String toString() {
	return "Address [city=" + city + ", pin=" + pin + "]";
}

}
