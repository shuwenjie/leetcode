package leetcode.problems;

public class Solution8 {
	public int myAtoi(String str) {
		byte[] bytes = str.getBytes();
		String target = "";
		for (byte b : bytes) {
			if (target.length() == 0) {
				if (b == 32) {
					continue;
				}
				if (b == 45 || b == 43) {
					target += new String(new byte[] { b });
					continue;
				}
				if (b > 47 && b < 58) {
					target += new String(new byte[] { b });
					continue;
				}
				return 0;

			}

			if (b > 47 && b < 58) {
				target += new String(new byte[] { b });
				continue;
			}
			break;

		}
		if (target.equals("") || target.equals("-") || target.equals("+")) {
			return 0;
		}
		boolean isF = false;
		if (target.startsWith("+")) {
			target = target.substring(1);
		}
		if (target.startsWith("-")) {
			target = target.substring(1);
			isF = true;
		}
		while (target.startsWith("0")) {
			target = target.substring(1);
		}
		if (target.length() == 0) {
			return 0;
		}
		if (target.length() > 10) {
			return isF ? Integer.MIN_VALUE : Integer.MAX_VALUE;
		}
		if (target.length() == 10 && Integer.parseInt(target.substring(0, 9)) > 214748364) {
			return isF ? Integer.MIN_VALUE : Integer.MAX_VALUE;
		}
		if (isF && target.length() == 10 && target.substring(0, 9).equals("214748364")
				&& Integer.parseInt(target.substring(9)) > 8) {
			return Integer.MIN_VALUE;
		}
		if (!isF && target.length() == 10 && target.substring(0, 9).equals("214748364")
				&& Integer.parseInt(target.substring(9)) > 7) {
			return Integer.MAX_VALUE;
		}
		target = isF ? "-" + target : target;
		int result = Integer.parseInt(target);

		return result;
	}

	public static void main(String[] args) {
		// System.out.println("+".getBytes()[0]);
		// byte b = 49;
		// System.out.println(new String(new byte[] { b }));
		System.out.println(new Solution8().myAtoi("0-1"));
	}

}
