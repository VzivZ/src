package leetcode.tencent.stringorarray;

import java.util.Stack;

/**
 * @ClassName BracketsValid
 * @Description 有效括号
 * @Author HeZhe
 * @Date 2018/10/29 14:03
 */
public class BracketsValid {
	public static boolean isValid(String s) {
		if(s.isEmpty()){
			return true;
		}
		Stack<Character> stack = new Stack<>();
		char[] chars = s.toCharArray();
		for(int i = 0;i<chars.length;i++){
			if(chars[i] == '{'){
				stack.push('}');
			}else if(chars[i] == '['){
				stack.push(']');
			}else if(chars[i] == '('){
				stack.push(')');
			}else if(stack.isEmpty()||chars[i]!=stack.pop()){
				return false;
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		System.out.println(isValid("()[]{]"));
	}
}
