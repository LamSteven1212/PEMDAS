import java.util.ArrayList;
import java.util.Stack;

public class Subsets {
	

	public static void main(String[] args) {
		
		
		Stack<Integer> stack = new Stack<Integer>();
		ArrayList<ArrayList<Integer>> result = new ArrayList<>(16);
		int[] arr = {1,2,3,4};
		
		for(int i = 0 ; i < arr.length ; i++) {
			int pushed = arr[i];
			stack.push(pushed);
		}
		result.add(new ArrayList<Integer>());
		
		while(!stack.isEmpty()) {
			int element = stack.pop();
			ArrayList<ArrayList<Integer>> pushedSubsets = new ArrayList<ArrayList<Integer>>();
			ArrayList<Integer> subset = new ArrayList<Integer>();
			for(int j = 0 ; j < result.size() ; j++) {
				subset = result.get(j);
				subset.add(element);
				pushedSubsets.add(subset);
			}
			result.addAll(pushedSubsets);
			pushedSubsets.clear();
		}
		

		System.out.println(result.toString());
		
		
	}

}
