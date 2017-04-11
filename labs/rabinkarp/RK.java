package rabinkarp;

public class RK {
	
	//
	// Be sure to look at the write up for this assignment
	//  so that you get full credit by satisfying all
	//  of its requirements
	//
	private int m;
	private char[] query ;
	private int i = 0;
	private int s = 0;
	/**
	 * Rabin-Karp string matching for a window of the specified size
	 * @param m size of the window
	 */
	public RK(int m) {
		this.query = new char[m];
		this.m=m;
	}
	

	/**
	 * Compute the rolling hash for the previous m-1 characters with d appended.
	 * @param d the next character in the target string
	 * @return
	 */
	public int nextCh(char d) {
		int c;
		c = query[i%m];
		query[i%m] = d;
		s = (31*s - pow(31, m)*c + d + pow(31, m)*511)%511;
		i++;
		return s;
	}
	
	public int pow(int a, int b){
		int ans =1;
		for (int j=0;j<b;j++){
			ans = (ans*a)%511;
		}
		return ans;
	}
	
}