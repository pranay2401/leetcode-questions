import java.util.*;
import java.lang.*;
import java.io.*;

https://www.codechef.com/learn/course/greedy-algorithms/LIGRDSA01/problems/XYSTRP
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner scanner = new Scanner(System.in);

		int t = scanner.nextInt();
		scanner.nextLine();

		while (t-- > 0) {
		    String str = scanner.nextLine();
		    System.out.println(getPairs(str));
		}

	}

	private static int getPairs(String str) {
	    if (str == null || str.length() <= 1) {
	        return 0;
	    }

	    int i = 0;
	    int pairs = 0;
	    while (i < str.length()-1) {
	        if ((str.charAt(i) == 'x' && str.charAt(i+1) == 'y') ||
	            (str.charAt(i) == 'y' && str.charAt(i+1) == 'x')) {
	            pairs++;
	            i += 2;
	        } else {
	            i++;
	        }
	    }

	    return pairs;
	}
}
