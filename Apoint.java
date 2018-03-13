

public class Apoint{
	public double x;
	public double y;
	
	
	public Apoint(double xa, double ya){
		x=xa;
		y=ya;
	}
	
	
	public String toString(){
		return "le point : ["+x+","+y+"]";
	}
	
	//distance entre le point courant et un autre point
	
	
	public double distance(Apoint autre){
		
		return Math.sqrt(((this.x-autre.x)*(this.x-autre.x))+((this.y-autre.y)*(this.y-autre.y)));
		
	}
}
