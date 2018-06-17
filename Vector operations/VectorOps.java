/**
 * Assignment #5.
 * This program solves Vector problems of the user's choice..
 * 
 * Author: Michael Lau (mlau10@ucsc.edu) 
 *          
 */


import java.util.Scanner;
 
public class VectorOps {
     static int choice, x, x2, y, y2, scale;
     static String cont = ""; 
     static Scanner input = new Scanner(System.in);
     static Scanner input2 = new Scanner(System.in);
     
    public static void main(String[] args) {
    	do { // do loop so user can continue
		/* all the available methods */
        System.out.println("What would you like to solve for?");
        System.out.println("1. Sum of two vectors");
        System.out.println("2. Difference of two vectors");
        System.out.println("3. Magnitude of a vector");
        System.out.println("4. Scalar Product of a vector");
        System.out.println("5. Dot Product of two vector");
        System.out.println("6. Angle between two vectors");
        choice = input.nextInt();
 
        switch(choice) {
            case 1: { // sum of 2 vectors
                Input2();
                Vector foo = new Vector(x,x2);
                Vector bar = new Vector(y,y2);
                System.out.println(Vector.Add(foo,bar));
                break;
            }
            case 2: { // difference of 2 vectors
                Input2();
                Vector foo = new Vector(x,x2);
                Vector bar = new Vector(y,y2);
                System.out.println(Vector.Sub(foo, bar));
                break;
            }
            case 3: { // magnitude of 2 vectors
                Input1();
                System.out.println(Vector.Magnitude(new Vector(x,x2)));
                break;
            }
            case 4: { // scalar product of a vector
                Input1();
                System.out.println("Enter new Scale");
                scale = input2.nextInt();
                System.out.println(Vector.Scalar(new Vector(x,x2), scale));
                break;
            }
            case 5: { // dot product of 2 vectors
                Input2();
                Vector foo = new Vector(x,x2);
                Vector bar = new Vector(y,y2);
                System.out.println(Vector.Dot(foo, bar));
                break;
            }
            case 6: { // angle between 2 vectors
                Input2();
                Vector foo = new Vector(x,x2);
                Vector bar = new Vector(y,y2);
                System.out.println(Vector.Angle(foo, bar));
                break;
            }

        }
       	System.out.println("Continue? (y/n)");
       	cont = input.next();
    	}  	while(cont.equals("y")); // does loop as long as user types 'y'
 
    }
 // Input1() to save lines
    public static void Input1(){
        System.out.println("Enter first vector");
        x = input2.nextInt();
        x2 = input2.nextInt();
    }
 // Input2() to save lines
    public static void Input2(){
        Input1();
        System.out.println("Enter second vector");
        y = input2.nextInt();
        y2 = input2.nextInt();
    }
}
 /* Vector class */
class Vector {
    private int x;
    private int y;
 
    public Vector(int a, int b){
        this.x = a;
        this.y = b;
    }
 // add method
    public static Vector Add(Vector a, Vector b){
        return new Vector(a.x + b.x, a.y + b.y);
    }
 // difference method
    public static Vector Sub(Vector a, Vector b){
        return new Vector(Math.abs(a.x - b.x),Math.abs(a.y - b.y));
    }
 // magnitude method
    public static double Magnitude(Vector a){
        return Math.sqrt(Math.pow(a.x, 2) + Math.pow(a.y, 2));
    }
 // scalar method
    public static Vector Scalar(Vector a, int scale){
        return new Vector(a.x * scale, a.y * scale);
    }
 // dot method
    public static double Dot(Vector a, Vector b){
        return (a.x * b.x) + (a.y * b.y) ;
    }
 // angle between method
    public static double Angle(Vector a, Vector b){
        double upper = Dot(a, b);
        double lower = Magnitude(a) * Magnitude(b);
        double c = upper / lower;
        return Math.acos(c);
    }
 // how the string will be printed
    @Override
    public String toString() {
        return "<"+ x +", "+ y +'>';
    }
}

