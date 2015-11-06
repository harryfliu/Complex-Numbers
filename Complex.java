public class Complex{

	private double x;
	private double y;
	
	//constructor
	public Complex(double re, double im){
		x= re;
		y= im;
	}
	
	//set variables
	public void setReal(double val){
		val = x;
		return;
	}
	
	public void setIm(double val1){
		val1 = y;
		return;
	}
	
	//no argument constructor
	public Complex() 
	{
		x=0.0;
		y=0.0;
	}
	
	//magnitude
	public double magnitude(){
	double temp= Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
	return(temp);
	}
	
	//get variables
	public double getReal(){
		return(x);
	}
	
	public double getImg(){
		return(y);
	}
	
	//copy constructor
	public Complex(Complex W){
		this(W.getReal(), W.getImg());
		return;
	}
	
		//toString method
	public String toString() {
        if (y == 0) return (x + "");
        if (x == 0) return (y + "i");
        if (y <  0) return (x + " - " + (-y) + "i");
        return (x + " + " + y + "i");
	}
	
	//conjugate static
	public static Complex conj(Complex V){
		return(new Complex(V.getReal(), V.getImg() *(-1)));
	}
	
	//conjugate nonstatic
	public Complex conjugate(){
		Complex end= new Complex();
		end.setReal= x;
		end.setImg= (y*(-1));
		return(end);
	}
	
	//angle
	public double angle(){
		double ang= Math.atan2(y/x);
		return(ang);
	}
	
	//add static
	public static Complex addComplex(Complex V, Complex W){
		return(new Complex((V.getReal()+W.getReal()),(V.getImg()+W.getImg())));
	}
	
	//add nonstatic
	public Complex add(Complex W){
		Complex end= new Complex();
		end.setReal= x+W.getReal();
		end.setImg= y+W.getImg();
		return(end);
	}
	
	//subtract static
	public static Complex subComplex(Complex V, Complex W){
		return (new Complex((V.getReal()-W.getReal()),(V.getImg()-W.getImg())));
	}
	
	//subtract nonstatic
	public Complex subtract(Complex W){
		Complex end= new Complex();
		end.setReal= x-W.getReal();
		end.setImg= y-W.getImg();
		return(end);
	}
	
	//multiply
	public static Complex multiplyComplex(Complex V, Complex W){
		double realsub= (V.getReal()*W.getReal())-(V.getImg()*W.getImg());
		double imgadd= (V.getReal()*W.getImg())+(V.getImg()*W.getReal());
		Complex last= new Complex(realsub,imgadd);
		return(last);
	}
	
	//divide
	public static Complex divideComplex(Complex V, Complex W){
		if(W.getReal()==0 && W.getImg()==0)
			return(null);
		
		else{
			double r1= V.getReal()*W.getReal();
			double r2= V.getImg()*W.getImg();
			double i1= V.getReal()*(-W.getImg());
			double i2= V.getImg()*W.getReal();
			double rsub= r1-r2;
			double iadd= i1+i2;
			double breal1= W.getReal()*W.getReal();
			double breal2= W.getImg()*W.getImg();
			double badd= breal1+breal2;
			double part1= rsub/badd;
			double part2= iadd/badd;
			Complex divlast= new Complex(part1, part2);
			return(divlast);
		}
	}
		
	//nth power
	public double power(){
		double magnit= Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
		double theta= Math.atan2(y/x);
		double e= Math.pow(Math.E, (n*theta));
		double power= Math.pow(magnit, n) * e;
		return(power);
	}
	
	//polar form
	public static Complex polarComplex(Complex V){
		double magn= Math.sqrt(Math.pow(V.getReal(),2)+ Math.pow(V.getImg(),2));
		double thet= Math.atan2((V.getImg()/V.getReal()));
		Arraylist polar= new Arraylist();
		polar.add(magn);
		polar.add(thet);
		return(polar);
	}
	
	//nth root
	public double root(){
		int n= 1;
		System.out.println("Enter the k less than n-1, greater than 0= ");
		int k= in.nextInt();
		System.out.println("Enter the nth root= ");
		int times= in.nextInt();
		double magnitu= Math.sqrt(Math.pow(x,2)+ Math.pow(y,2));
		double array[]= new double[times]
		for(int i= 0; i<times; i++){
		double r= Math.pow((magnitu),(1/n));
        double t= Math.cos((((Math.atan2(y/x))/2)+(2*k*Math.PI))/n);
		double s= Math.sin((((Math.atan2(y/x))/2)+(2*k*Math.PI))/n);
		double root= (t+s)*r;
		array[i]= root;
		n++;
		}
        return (array);
	}
}
