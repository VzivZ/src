package leetcode.arraydemo;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName RestoreIpAddr
 * @Description 复原IP地址 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * 示例:
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 * @Author VzivZ
 * @Date 2019/1/25 13:14
 */
public class RestoreIpAddr {
	public List<String> restoreIpAddresses(String s) {
		List<String> res = new ArrayList<String>();
		helper(s, 0, "", res);
		return res;
	}

	public void helper(String s, int n, String out, List<String> res) {
		if (n == 4) {
			if (s.isEmpty()) res.add(out);
			return;
		}
		for (int k = 1; k < 4; ++k) {
			if (s.length() < k) break;
			int val = Integer.parseInt(s.substring(0, k));
			if (val > 255 || k != String.valueOf(val).length()) continue;
			helper(s.substring(k), n + 1, out + s.substring(0, k) + (n == 3 ? "" : "."), res);
		}
	}

	//暴力法
	public List<String> restoreIpAddresses2(String s) {
		List<String> res = new ArrayList<>();
		for (int a = 1; a < 4; ++a)
			for (int b = 1; b < 4; ++b)
				for (int c = 1; c < 4; ++c)
					for (int d = 1; d < 4; ++d)
						if (a + b + c + d == s.length()) {
							int A = Integer.parseInt(s.substring(0, a));
							int B = Integer.parseInt(s.substring(a, a + b));
							int C = Integer.parseInt(s.substring(a + b, a + b + c));
							int D = Integer.parseInt(s.substring(a + b + c));
							if (A <= 255 && B <= 255 && C <= 255 && D <= 255) {
								String t = String.valueOf(A) + "." + String.valueOf(B) + "." + String.valueOf(C) + "." + String.valueOf(D);
								if (t.length() == s.length() + 3)
									res.add(t);
							}
						}
		return res;
	}
}
