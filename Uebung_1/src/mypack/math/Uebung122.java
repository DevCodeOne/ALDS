package mypack.math;

public class Uebung122 
{
	public static void main(String[] args) 
	{
		// Erzeugung von c1 mit dem 2. Konstruktor
		ComplexNumber c1 = new ComplexNumber(3.0, 5.0);
		
		// Erzeugung von c2 mit dem Standard-Konstruktor
		// anschließend Werte mit den set-Methoden setzen
		ComplexNumber c2 = new ComplexNumber();
		c2.setReal(8.0);
		c2.setImg(4.0);
		
		// tmp ist eine Kopie von c1
		ComplexNumber tmp = new ComplexNumber(c1);
		// alternativ: 
		//ComplexNumber tmp = c1.copy(); 
		
		// tmp + c2
		tmp.div(c2);
		System.out.println("c1 / c2 = " + tmp.getReal() + " + i*" + tmp.getImg());
		
		// tmp zurücksetzen
		tmp = c1.copy();
		
		// tmp - c2;
		//TBD
		
		// tmp * c2;
		//TBD
		
		
		// tmp / c2;
		//TBD
		
		// C1 negiert
		//TBD

		// andere Funktionalitäten von ComplexNumer
		//...
	}
}
