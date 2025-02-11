package array;

public class kthmaxmin {

//use sorting or mean max heap O(nlogn)
//partition method best O(n)	
// also known as quick select

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 8, 3, 7, 2, 6, 9, 5, 4, 21 };
		int k = 4; // means k+1 smallest element
		// pass last element as pivot
		int p = partition(arr, 0, arr.length - 1, arr[arr.length - 1]);
		while (p != k) {
			if (p > k) {
				p = partition(arr, 0, p - 1, arr[p - 1]);
			} else if (p < k) {
				p = partition(arr, p + 1, arr.length - 1, arr[arr.length - 1]);
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		System.out.println("kth smallest - > " + arr[p]);

		quicksort(arr, 0, arr.length - 1);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

	}

	// 0 - i-1 < p
	// i - j-1 >=p
	// j - end --> unknown

	public static int partition(int[] arr, int start, int end, int pivot) {
		int i = start, j = start;
		// we have to check for unknown area
		while (j <= end) {
			if (arr[j] > pivot) {
				j++;
			} else {
				// swap i and j values
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j++;
			}
		}

		return i - 1;
	}

	public static void quicksort(int[] arr, int start, int end) {
		if (start >= end) {
			return;
		}
		int p = partition(arr, start, end, arr[end]);
		quicksort(arr, start, p - 1);
		quicksort(arr, p + 1, end);
	}
	
	//this is the other efficient method using priority queue
	//adding elements in pq. After adding Kth element, start removing 1 element from pq before adding (k+1)th element
	//by this we will get pq containing k largest elements of array.. Then return the peek value of pq
	//By Shubham Aggarwal @shubham242k
	public static int KthMaximum(int[] arr,int k){
		 PriorityQueue<Integer> pq = new PriorityQueue<>();
      
	      for(int i = 0;i<n;i++){
		  if(i<k){
		     pq.add(a[i]);
		  }else{ 
		      if(a[i]>pq.peek()){
			   pq.remove();
			   pq.add(a[i]);
		      }
		  }

	      }

	      return pq.peek();

	}

}

// one More easy way to solve this Question using Set

public class hello {

	public static void main(String[] args) {
	
	int arr[]= {10,5,4,8,2,2,4,3,1,2,5};
	kmin(arr, 3);
	}
	
	public static void kmin(int a[],int target)
	{
		Set<Integer> ss= new HashSet<Integer>();
		for(int i=0;i<a.length;i++)
		{
			ss.add(a[i]);
		}
		ss.toArray();
		List<Integer> list = new ArrayList<Integer>(ss);
		System.out.println(list.get(target-1));
	}
	
	

}

