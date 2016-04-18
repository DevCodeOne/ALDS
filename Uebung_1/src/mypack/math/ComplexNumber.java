package mypack.math;

public class ComplexNumber 
{
	/**
	* real and imaginary part
	*/
	protected double a, b;
	
	/**
	* constructor, default
	*/
	public ComplexNumber() { }
	
	/**
	* constructor
	* @param x real part
	* @param y imaginary part
	*/
	public ComplexNumber(double x, double y) {
		this.a = x;
		this.b = y;
	}	
	 
	/**
	* constructor
	* @param a another ComplexNumber
	*/
	public ComplexNumber(ComplexNumber a) {
		this.a = a.a; 
		this.b = a.b;
	}

	public String toString() {
		return a + " + " + b + " * i";
	}
	
	/**
	* adds another complex number
	* @param a another ComplexNumber
	*/
	public void add(ComplexNumber a) {
		this.a += a.a; 
		this.b += a.b;
	
	}
	/**
	* subtracts another complex number
	* @param a another ComplexNumber
	* (a+i*b) - (c+i*d) = (a-c) + i*(b-d)
	*/
	public void sub(ComplexNumber a) {
		this.a -= a.a; 
		this.b -= a.b;
	}
	
	/**
	* multiplies another complex number
	* @param a another ComplexNumber
	* (a+i*b) * (c+i*d) = (a*c - b*d) + i*(a*d + b*c)
	*/
	public void mul(ComplexNumber a) {
		double olda = this.a; 
		double oldb = this.b;
		
		this.a = olda * a.a - oldb * a.b;
		this.b = olda * a.b + oldb * a.a;
	}
	
	/**
	* divides by another complex number
	* @param a another ComplexNumber
	*   ((a*c) + (b*d)) / (c^2 + d^2)
	* + ((b*c) - (a*d))  / (c^2 + d^2))*i
	*/
	public void div(ComplexNumber a) {
		double olda = this.a; 
		double oldb = this.b;
		
		this.a = (olda * a.a + oldb * a.b) / (a.a * a.a + a.b * a.b);
		this.b = (oldb * a.a - olda * a.b) / (a.a * a.a + a.b * a.b);
	}
	
	/**
	* negates this complex number
	*
	*/
	public void neg() {
		this.a *= -1;
		this.b *= -1;
	}
	
	/**
	* calculates squared absolute value <BR>
	* (sum of squared real part and squared imaginary part)
	* @return squared absolute value
	*/
	public double absSquare() { return a * a + b * b; }	
	 
	/**
	* calculates absolute value <BR>
	* (root of sum of squared real part and
	* squared imaginary part)
	* @return absolute value
	*/
	public double abs() { return Math.sqrt(absSquare()); }
	
	/**
	* access function; get real part
	* @return real part
	*/
	public double getReal() { return a; }
	
	/**
	* access function; get imaginary part
	* @return imaginary part
	*/
	public double getImg() { return b; }
	
	/**
	* access function; set real part
	* @param x new real part
	*/
	public void setReal(double x) { this.a = x; }
	
	/**
	* access function; set imaginary part
	* @param y new imaginary part
	*/
	public void setImg(double y) { this.b = y; }
	
	/**
	* calculates conjugate complex and
	* returns a corresponding new object
	* @return new ComplexNumber with conjugate complex
	*/
	public ComplexNumber con() { return new ComplexNumber(a, -b); }
	
	/**
	* copy constructor
	* @return copy of this ComplexNumber
	*/
	public ComplexNumber copy() { return new ComplexNumber(a, b); }	
}