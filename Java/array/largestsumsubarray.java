package array;

public class largestsumsubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { -2, -3, 4, -1, -2, 1, 5, -3 };
		sumsubarray(arr);

	}

	public static void sumsubarray(int[] arr) {
		int maxend = arr[0];
		int max = Integer.MIN_VALUE;
		for (int i = 1; i < arr.length; i++) {

			if (arr[i] > maxend + arr[i]) {
				maxend = arr[i];
			} else {
				maxend = maxend + arr[i];
			}
			if (max < maxend) {
				max = maxend;
			}
		}

		System.out.println(max);
	}
	
// 	Another way 
	int maxSubarraySum(int arr[], int n){
        
        // Your code here
        int max = arr[0];
        int cur = arr[0];
        for(int i=1;i<n;i++)
        {
            if(cur < 0)
            {
                cur = arr[i];
            }
                else
                {
                    cur += arr[i];
                }
            
            if(cur >= max)
            {
                max=cur;
            }
            
        }
        return max;
    }


}
