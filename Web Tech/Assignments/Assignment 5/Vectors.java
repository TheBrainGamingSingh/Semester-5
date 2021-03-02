import java.io.*;

class Vectors{
	private double[] v;
	private int n;
	Vectors(int dim){
		n = dim;
		v = new double[n];
	}
	Vectors(double ele[],int dim){
		n = dim;
		v = new double[n];
		int i;
		for(i = 0 ; i < n ; i++ ){
			v[i] = ele[i];
		}
	}

	int max(int a , int b){
		return a > b ? a : b;
	}

	int min(int a , int b){
		return a < b ? a : b;
	}

	public Vectors add(Vectors v1,Vectors v2){
		int size  = max(v1.n,v2.n);
		Vectors add_ob = new Vectors(size);
		for(int i = 0 ;i < size; i++) {
			add_ob.v[i] = v1.v[i] + v2.v[i];
		}
		return add_ob;
	}

	public Vectors dot_prod(Vectors v1, Vectors v2){
		int size = min(v1.n,v2.n);
		Vectors dot_ob = new Vectors(size);
		for(int i = 0 ; i < size ; i++){
			dot_ob.v[i] = v1.v[i] * v2.v[i];
		}
		return dot_ob;
	}

	public Vectors scalar_multi(Vectors v1,int sc){

		Vectors scal_ob = new Vectors(v1.n);
		for (int i = 0 ; i < v1.n ;i++) {
			scal_ob.v[i] = v1.v[i] * sc;
		}
		return scal_ob;
	}
	public double magni(Vectors v1){

		double mag = 0.0;
		for(int i = 0 ; i < v1.n ; i++)
			mag = mag + v1.v[i]*v1.v[i];
		
		mag = Math.sqrt(mag);
		return mag;
	}
	public Vectors direction(Vectors v1){

		Vectors dir_ob = new Vectors(v1.n);
		double mag = magni(v1);

		for (int i = 0 ; i < v1.n ;i++)
			dir_ob.v[i] = v1.v[i]/mag;

		return dir_ob;
	}
	
	public static void main(String[] args){
		double a1[] = {3.0,4.0};
		
		Vectors v1 = new Vectors(a1,2);
		Vectors v2 = new Vectors(a1,2);
		Vectors v3 = v1.add(v1,v2);
		Vectors v4 = v1.dot_prod(v1,v2);
		Vectors v5 = v1.scalar_multi(v1,4);
		
		double x = v1.magni(v1);
		
		Vectors v6 = v1.direction(v1);
		
		System.out.println(v3.v[0]);
		System.out.println(v4.v[0]);
		System.out.println(v5.v[0]);
		System.out.println(x);
		System.out.println(v6.v[0]);
	}
}