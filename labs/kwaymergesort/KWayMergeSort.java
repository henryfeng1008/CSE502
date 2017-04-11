package kwaymergesort;

import timing.Ticker;

public class KWayMergeSort {
	
	/**
	 * 
	 * @param K some positive power of 2.
	 * @param input an array of unsorted integers.  Its size is either 1, or some other power of 2 that is at least K
	 * @param ticker call .tick() on this to account for the work you do
	 * @return
	 */
	public static Integer[] kwaymergesort(int K, Integer[] input, Ticker ticker) {
		int n = input.length;
		
		//
		// FIXME
		// Following just copies the input as the answer
		//
		// You must replace the loop below with code that performs
		// a K-way merge sort, placing the result in ans
		//
		// The web page for this assignment provides more detail.
		//
		// Use the ticker as you normally would, to account for
		// the operations taken to perform the K-way merge sort.
		//
		Integer[] ans = new Integer[n];
		Integer[][] temp = new Integer[K][n/K];
		Integer[][] temp1 = new Integer[K][n/K];
		Integer[][] divided = new Integer[K][n/K];
		
		if (n == 1){
			return input;
		}
		
			divided = divide(input, K, ticker);
			for (int j = 0; j < K; j++){
				temp[j] = kwaymergesort(K, divided[j], ticker);
			}
		ans = merge(temp, ticker);
		return ans;
		}		


static Integer[] merge(Integer[][] a,Ticker ticker ){
		int n = a.length;
		int m = a[0].length;
		Integer[] ans = new Integer[n*m];
		ticker.tick(3);
		if (n==1){
			return a[0];
			}
		else{
		Integer[][] temp1 = new Integer[n/2][2*m];
		int i = 0;
		ticker.tick(2);
		while(i < n/2){
			temp1[i]= sortandmerge(a[2*i],a[2*i+1], ticker);
			i++;
			ticker.tick(2);
			}
		ans = merge(temp1, ticker);
		ticker.tick();
		return ans;
		}
	}
	
	
static Integer[][] divide(Integer[] input, int k, Ticker ticker){
	int n = input.length;
	Integer[][] divide = new Integer[k][n/k];
	int row = -1;
	ticker.tick(3);
		for (int i = 0; i < n; i++){
			if ((i%(n/k))==0){
				row++;
				ticker.tick();
			}
			divide[row][i-row*(n/k)] = input[i];
			ticker.tick();
			}
	return divide;
	}



public static Integer[] sortandmerge(Integer[] sort1, Integer[] sort2,Ticker ticker){
	int n = sort1.length;
	Integer[] sorted = new Integer[2*n];
	int i=0,j=0,time=0;
	ticker.tick(5);
		while(i<n && j<n){
			if (sort1[i] <= sort2[j]){
				sorted[time] = sort1[i];
				i++;
				time++;
				ticker.tick(3);
				}
			else{
				sorted[time] = sort2[j];
				j++;
				time++;
				ticker.tick(3);
				}	
		}
	if(i==n && j<n){
		while(j<n){
			sorted[time] = sort2[j];
			time++;j++;
			ticker.tick(3);
		}
		return sorted;
	}
	
	else if(j==n && i<n){
		while(i<n){
			sorted[time] = sort1[i];
			time++;i++;ticker.tick(3);
		}
		return sorted;
	}
	else{
		return sorted;
	}
	
}
}		
