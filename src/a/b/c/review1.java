package a.b.c;

public class review1 {

	public static void main(String args[]){
	int a[]=new int[3];
	int b[]=new int[]{3,4,5,6,7};
	a[0]=1;
	a[1]=2;
	a[2]=3;
	for(int i=0;i<a.length;i++)
	{
		System.out.print("a : "+ a[i]+ " ");
	}
	System.out.println();
	for(int i=0;i<b.length;i++)
	{
		System.out.print("b : " + b[i]+ " ");
	}
	}
}
