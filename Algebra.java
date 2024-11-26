// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	/**
	 * @param args
	 */
	public static void main(String args[]) {
	    // // Tests some of the operations
	    // System.out.println(plus(2,3));  // 2 + 3 = 5
		// System.out.println(plus((-2),(-3)));  // -2 + -3 = -5
		// System.out.println(plus((-2),(3)));  // -2 + 3 = 1
		// System.out.println(plus((2),(-3)));  // 2 + -3 = -1
	    // System.out.println(minus(7,2));  // 7 - 2 = 5
		// System.out.println(minus((-7),(-2)));  // -7 - -2 = -5
		// System.out.println(minus((-7),2));  // -7 - 2 = -9
		// System.out.println(minus((7),(-2)));  // 7 - -2 = 9
 		//System.out.println(times(3,4));  // 3 * 4 = 12
		 //System.out.println(times((-3),(-4)));  // -3 * -4 = 12
		 //System.out.println(times((-3),4));  // -3 * 4 = -12
		 //System.out.println(times(3,(-4)));  // 3 *-4 = -12
   		//System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   	//System.out.println(pow(5,3));      // 5^3 = 125
	   //System.out.println(pow(-5,3));      // 5^3 = -125
   	//System.out.println(pow(3,2));      // 3^2 = 9
	   //System.out.println(pow(0,5));  // 0^5 = 0
	   //System.out.println(pow(1,5));  // 1^5 = 1
	   //System.out.println(pow(5,0));  // 5^0 = 1
   		 //System.out.println(div(12,3));   // 12 / 3 = 4    
   		//System.out.println(div(5,5));    // 5 / 5   = 1
   		//System.out.println(div(25,7));   // 25 / 7 = 3.571
		   //System.out.println(div(0,7));   // 0 / 7 = 0
		   //System.out.println(div(25,0));   // 25 / 0 = 0
		   //System.out.println(div(25,25));   // 25 / 25 = 1
		   System.out.println(mod(0,3));  // 0 % 3 = 0  
		   System.out.println(mod(20,1));  // 20 % 1 = 0  
   		System.out.println(mod(20,5));   // 20 % 5 = 0
   		System.out.println(mod(10,3));  // 10 % 3 = 1  
		
   		// System.out.println(sqrt(36));
		// System.out.println(sqrt(263169));
   		// System.out.println(sqrt(76123));
	}  

	public static int negativeToPoitive(int x ) {

	return(minus( 0,x));
	}

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int sum = 0;
     // x1 and x2 > 0
		if (x1 >= 0 && x2 >= 0) {
			 sum = x1;
			for (int i = 0; i < x2; i++) {
				sum++;
			}
			return sum;
		}
		 // x1 and x2 < 0
		if (x1 <= 0 && x2 <= 0) { 
			sum = x1;
			for (int i = 0; i > x2; i--) { 
				sum--;
			}
			return sum;
		}
		 // x1 < 0 and x2 > 0
		if (x1 < 0 && x2 >0) { 
			sum = x1;
			for (int i = 0; i < x2; i++) { 
				sum++;
			}
			return sum;
		}
		 // x1 > 0 and x2 < 0
		 if (x1 > 0 && x2 < 0) { 
			sum = x1;
			for (int i = 0; i > x2; i--) { 
				sum--;
			}
			return sum;
		}
		return sum;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int difference = 0;
		   // x1 and x2 > 0
		   if (x1 >= 0 && x2 >= 0) {
			difference = x1;
		   for (int i = 0; i < x2; i++) {
			difference--;
		   }
		   return difference;
	   }
	    // x1 and x2 < 0
		if (x1 <= 0 && x2 <= 0) { 
			difference = x1;
			for (int i = 0; i > x2; i--) { 
				difference++;
			}
			return difference;
		}
		 // x1 < 0 and x2 > 0
		 if (x1 < 0 && x2 >0) { 
			difference = x1;
			for (int i = 0; i < x2; i++) { 
				difference--;
			}
			return difference;
		}
		if (x1 > 0 && x2 < 0) { 
			difference = x1;
			for (int i = 0; i > x2; i--) { 
				difference++;
			}
			return difference;
		}
		return difference;
	}

	// Returns x1 * x2 
	public static int times(int x1, int x2) {
int multiplier= x1;
boolean isPositive= true;
    if (x1 == 0 || x2 == 0) {
        return 0; 
    }
	if(x1<0){
		x1=negativeToPoitive(x1);
		isPositive=!isPositive;
		multiplier= x1;
	}
	if(x2<0){
		x2=negativeToPoitive(x2);
		isPositive=!isPositive;
	}
	for(int i = 1; i < x2; i++){
		
		multiplier=plus(multiplier, x1);
	}if (isPositive) {
		return multiplier;
		
	}else{
		return minus(0,multiplier);
	}
}

	

// Returns x^n (for n >= 0)
public static int pow(int x, int n) {

    if (x == 0) { 
        return 0; 
    }
    if (n == 0) { 
        return 1; 
    }
    if (x == 1) { 
        return 1; 
    }
    int holding = 1; 
    for (int i = 0; i < n; i++) {
        holding = times(holding, x); 
    }

    return holding; 
}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int result= 0;
		boolean isNegative = false;
    if (x1 == 0 || x2 == 0) {
        return 0; 
    }
	if (x2 == 1) {
        return 0; 
    }
	if (x1 == x2)  {
        return 1; 
    }
	
    if (x1 < 0) {
        x1 = negativeToPoitive(x1); 
        isNegative = !isNegative; 
    }
    if (x2 < 0) {
        x2 = negativeToPoitive(x2); 
        isNegative = !isNegative;   
    }

    while (x1 >= x2) {
        x1 = plus(x1, negativeToPoitive(x2)); 
        result = plus(result, 1);         
    }
    return isNegative ? plus(0, negativeToPoitive(result)) : result;
	
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
	
		if (x1 == 0) {
			return 0; }
		if (x2 == 1) {
			return 0;
		}
			boolean isNegative = x1 < 0; 
		if (x1 < 0) {
			x1 = negativeToPoitive(x1); 
		}
		if (x2 < 0) {
			x2 = negativeToPoitive(x2);
		}
	
	
		while (x1 >= x2) {
			x1 = plus(x1, negativeToPoitive(x2)); 
		}
	
	
		return isNegative ? plus(0, negativeToPoitive(x1)) : x1;

	}
	
	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		// Replace the following statement with your code
		return 0;
	}	  	  
}