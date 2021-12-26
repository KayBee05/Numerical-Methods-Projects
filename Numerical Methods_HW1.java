
//Programming HW 1

public class HW1 {
    //Let's try using 10^-3 as our TOL (Tolerance or the level of error
    // which is acceptable) like it says in the document. We can write is as 1/1000 or 0.001.
    //But to keep this accurate, we can go with 0.001 similar to float/decimal point/double
    private static final double TOL = 0.001;

    //We will do double for this section.
    //We can write out our equation here: x^2 - 56 = 0
    public static double f(double x) {
        //Since x^2 is a very simple exponent form of x * x, we can simply write it as: (x*x) - 56 to return the value
        // or maybe use math.pow() for the fun of it.
        return ((Math.pow(x, 2)) - 56);
    }

    //Let's go for float type. Same procedure as above, only different in data type.
    public static float f(float x) {
        return (float) ((Math.pow(x, 2)) - 56);
        }
    //Okay so we have our x^2 - 56 = 0 established in both float and double.
     //Let's make the bisection method in double type.
    public static double bisection(double a, double b) {
        if(f(a) * f(b) >= 0) {
            //In the Bisection Method, the primary principle behind it is the Intermediate Value Theorem.
            //IVT implies that when f(a) * f(b) < 0 , then it means we have a point on that particular interval.
            // where it is greater than a and less than b such that f(point) = 0. Thus, there is a solution.
            System.out.println("Since your f(a) * f(b) is greater than equal to 0, no solutions are found.");
        }
        double p = a;

        // The while loop will run and stops when the absolute difference between b and a is greater than or equal to our TOL
        while(Math.abs(b - a) >= TOL) {
            //Now use the bisection method formula where a+b gets divided by 2. The method works to divide
            //the interval into two halves, hence we need to divide (a+b) by 2.
            //The Bisection Method will keep cut the interval in halves until the resulting interval is extremely small.
            p = (a + b) / 2;

            // If f(p) or in other words the full value of our result
            if(f(p) == 0) {
                return p;
                }

            //changed the end point b to obtain a smaller interval that still contains a root
            else if(f(p) * f(a) < 0) {
                b = p;
                }

            //  changed the end point a to obtain a smaller interval that still contains a root
            else {
                a = p;
                }
            }
        // Return the approximated result of root
        return p;
        }

    // Now let's try the bisection method in float.
    public static float bisection(float a, float b) {
        //In the Bisection Method, the primary principle behind it is the Intermediate Value Theorem.
        //IVT implies that when f(a) * f(b) < 0 , then it means we have a point
        // where it is greater than a and less than b such that f(point) = 0. Thus, there is a solution.
        if( f(a) * f(b) >= 0) {
            System.out.println("Since your f(a) * f(b) is greater than equal to 0, no solutions are found. ");
            }
            float p = a;

        // The while loop will run until the absolute difference using math.abs() between
        // b and a is greater than or equal to the TOL since formula states |p0 - p| >= TOL
        while(Math.abs( b - a) >= TOL) {
            p = (a + b) / 2f; //f is needed since float value for 2

            // If value of function f(x) is zero then that means our p is a root
            if(f(p) == 0) {
                return p;
                }

            else if(f(p) * f(a) < 0) {
                b = p;
                }

            else {
                a = p;
                }
             }
        return p;
        }


     //Double type for Newton;s Method.
     //Because Newton's method involves derivatives,we need to use the power rule here to find
     // the derivative of function f(x) = x^2 - 56. So f'(x) = 2x
    public static double function_derivative(double x) {
        return 2 * x;
        }

    //Now time for float type of Newton's method
    public static float function_derivative(float x) {
        return 2 * x;
        }

    //Now we can write the formula as double for the Newton's Method.
    //Formula basically goes as finding the derivative of the main function then dividing it from the same function.
    //  Xn+1 = Xn = f(x)/f'(x) as long as f'(Xn) is not equal to 0.
    public static double newton(double x) {
        double p = f(x) / function_derivative(x);

        //Again, we use the while loop with the math.abs() >= TOL
        while (Math.abs(p) >= TOL) {
            //So for newton, we need to divide the function's derivative from the main function we are looking at.
            p = f(x) / function_derivative(x);

            //Then through the iteration, the root will be given.
            //refer to the initial estimate within the newton's method. With every iteration, the root needs to be
            //changed.
            x = x - p;
            }
        // Return our output root
        return x;
        }

    //Let's finish up the float version for newton.
    //The procedure is basically the same but with float values.
    public static float newton(float x) {
        float p = f(x) / function_derivative(x);

        while(Math.abs(p) >= TOL) {
            p = f(x) / function_derivative(x);
            x = x - p;
            }

        return x;
        }

    public static void main(String[] args) {
        //Now we have our main/driver code. For this, we will just simply print out all the code.
        //and we will label everything accordingly.
        //Let's label the Bisection Method here.
        System.out.println("\nBisection Method: \n");
        //Label each Question to avoid confusion
        //Q #1
        System.out.println(" 1) try a = 0, b = 10 ");
        //Keep everything in double.
        double double_a = 0, double_b = 10;
        System.out.println("Double type root = " + bisection(double_a , double_b));
        //Keep everything in float.
        float float_a = 0, float_b = 10;
        System.out.println("Float type root = " + bisection(float_a, float_b));
        System.out.println();

        //Q #2
        System.out.println("2) try a = 7, b = 8");
        double_a = 7; double_b = 8;
        System.out.println("Double type root = " + bisection(double_a, double_b));
        float_a = 7; float_b = 8;
        System.out.println("Float type root = " + bisection(float_a, float_b));
        System.out.println();

        //Q #3
        System.out.println("3) try a = 0, b = -10");
        double_a = 0; double_b = -10;
        System.out.println("Double type root = " + bisection(double_a, double_b));
        float_a = 0; float_b = -10;
        System.out.println("Float type root = " + bisection(float_a, float_b));
        System.out.println();

        //Q #4
        System.out.println("4) try a = -8, b = -7");
        double_a = -8;  double_b = -7;
        System.out.println("Double type root = " + bisection( double_a,  double_b));
        float_a = -8;  float_b = -7;
        System.out.println("Float type root = " + bisection( float_a,  float_b));

        // Next section is Newton's method
        System.out.println("\nNewton's Method: \n");

        //Q #1
        System.out.println("1) try x0 = 7");
        double double_x = 7;
        System.out.println("Double type root = " + newton(double_x));
        float float_x = 7;
        System.out.println("Float type root = " + newton(float_x));
        System.out.println();

        //Q #2
        System.out.println("2) try x0 = -7");
        double_x = -7;
        System.out.println("Double type root = " + newton(double_x));
        float_x = -7;
        System.out.println("Float type root = " + newton(float_x));
        System.out.println();

        //Q #3
        //This particular case is different since you can't use 0s
        //Thus roots will come out to be invalid.
        System.out.println("3) try x0 = 0");
        double_x = 0;
        System.out.println("Double type root = " + newton(double_x));
        float_x = 0;
        System.out.println("Float type root = " + newton(float_x));
        }
    }
