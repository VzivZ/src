package leetcode.arraydemo;

import java.util.*;

/**
 * @ClassName BestStrategy
 * @Description
 * @Author HeZhe
 * @Date 2018/9/21 10:28
 */
public class BestStrategy {
	public static int [] advantageCount(int[] A,int[] B) {
		int[] sortedA = A.clone();
		Arrays.sort(sortedA);

		int[] sortedB = B.clone();
		Arrays.sort(sortedB);
		Map<Integer,Deque<Integer>> assigned = new HashMap<>();
		for(int b : B){
			assigned.put(b,new LinkedList<>());
		}
		Deque<Integer> remaining = new LinkedList<>();
		int j = 0;
		for(int a : sortedA){
			if(a>sortedB[j]){
				assigned.get(sortedB[j++]).add(a);
			}else {
				remaining.add(a);
			}
		}
		int[] ans = new int[B.length];
		for(int i = 0;i<B.length;++i){
			if (assigned.get(B[i]).size() > 0)
				ans[i] = assigned.get(B[i]).pop();
			else
				ans[i] = remaining.pop();
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] A ={12,24,8,32};
		int[] B ={13,25,32,11};
		int[] C = advantageCount(A,B);
		for(int c : C) {
			System.out.print(c + " ");
		}
	}
}
