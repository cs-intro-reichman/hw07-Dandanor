/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

	public static void main(String[] args) {
		StdDraw.setCanvasSize(512,512);
		StdDraw.setScale(0,1);

		//// Uncomment the first code block to test the curve function.
		//// Uncomment the second code block to test the snowflake function.
		//// Uncomment only one block in each test, and remember to compile
		//// the class whenever you change the test.

        
		// Tests the curve function:
		// Gets n, x1, y1, x2, y2,
		// and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
		//curve(Integer.parseInt(args[0]),
			  //Double.parseDouble(args[1]), Double.parseDouble(args[2]), 
		      //Double.parseDouble(args[3]), Double.parseDouble(args[4]));
		

		
		// Tests the snowflake function:
		// Gets n, and draws a Koch snowflake of n edges in the standard canvass.
		snowFlake(Integer.parseInt(args[0]));
		
	}

	/** Gets n, x1, y1, x2, y2,
     *  and draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
	public static void curve(int n, double x1, double y1, double x2, double y2) {
		if(n==0){ //base
			return;
		}
		StdDraw.line(x1, y1, x2, y2);
		StdDraw.setPenColor(StdDraw.WHITE); //remove middle part
		StdDraw.setPenRadius(0.00385); //not part of the instructions, but made the white pen slightly thicker so the black lines won't show through as much.
		double p3x = ((Math.sqrt(3)/6)*(y1-y2)+0.5*(x1+x2));
		double p3y = ((Math.sqrt(3)/6)*(x2-x1)+0.5*(y1+y2));
		double p1x = (x2-x1)/3 +x1;
		double p1y = (y2-y1)/3 +y1;
		double p2x = p1x + (x2-x1)/3;
		double p2y = p1y+(y2-y1)/3;
		StdDraw.line(p1x,p1y,p2x,p2y);
		StdDraw.setPenColor(StdDraw.BLACK); //draw triangle
		StdDraw.setPenRadius(); //reset pen radius
		StdDraw.line(p1x,p1y,p3x,p3y);
		StdDraw.line(p3x,p3y,p2x,p2y);

		//recursive part
		curve(n-1,x1,y1,p1x,p1y);
		curve(n-1,p1x,p1y,p3x,p3y);
		curve(n-1,p3x,p3y,p2x,p2y);
		curve(n-1,p2x,p2y,x2,y2);
	}

    /** Gets n, and draws a Koch snowflake of n edges in the standard canvass. */
	public static void snowFlake(int n) {
		// A little tweak that makes the drawing look better
		StdDraw.setYscale(0, 1.1);
		StdDraw.setXscale(0, 1.1);
		// Draws a Koch snowflake of depth n
		//// Write the rest of your code below.
		double p1x = 0.1;
		double p1y = 0.8;
		double p3x = 1;
		double p3y = 0.8;
		double p2x = 0.55;
		double p2y = 0.02;
		curve(n,p1x,p1y,p3x,p3y);
		curve(n,p2x,p2y,p1x,p1y);
		curve(n,p3x,p3y,p2x,p2y);
	}
}
