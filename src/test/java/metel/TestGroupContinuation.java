package metel;

import java.util.ArrayList;
import java.util.List;

public class TestGroupContinuation {
	public static List<List<Integer>> groupContinuation(int [] arr){
		List<List<Integer>> groups = new ArrayList<>(); 
		List<Integer> continuations = new ArrayList<>();
		for (int i =0;i<arr.length;i++) {{
			int v = arr[i];
			if(i==arr.length-1){
				continuations.add(v);
				groups.add(continuations);
				continue;
			}
			int u = arr[i+1];
			if(u-v==1){
				continuations.add(v);
			}else{
				continuations.add(v);
				groups.add(continuations);
				continuations = new ArrayList<>();
			}
		}
	}
		return groups;
	}
	public static void main(String[] args) {
//		int [] arr = {1,2,3,5,6,8,9};
//		List<List<Integer>> groups = groupContinuation(arr);
//		System.out.println(groups);
		for (String string : args) {
			System.out.println(string);
		}
	}
}
