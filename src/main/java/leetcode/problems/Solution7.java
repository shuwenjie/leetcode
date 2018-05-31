package leetcode.problems;

public class Solution7 {

	public int reverse(int x) {
		if (0 == x) {
			return 0;

		}

		boolean isF = x < 0 ? true : false;
		String xs = String.valueOf(x);
		if (isF) {
			xs = xs.substring(1);
		}
		byte[] xsb = xs.getBytes();
		byte[] rxsb = new byte[xsb.length];
		int j = 0;
		boolean isHead = true;
		for (int i = xsb.length - 1; i >= 0; i--) {
			if (isHead && 48 == xsb[i]) {
				continue;
			}
			if (isHead) {
				rxsb = new byte[i + 1];
				isHead = false;
			}
			rxsb[j++] = xsb[i];
		}

		String rxs = new String(rxsb);
		if (rxs.length() > 10) {
			return 0;
		}
		if (isF) {
			if (rxs.length() == 10 && Integer.parseInt(rxs.substring(0, 9)) > 214748364) {
				return 0;
			}
			if (rxs.length() == 10 && rxs.substring(0, 9).equals("214748364")
					&& Integer.parseInt(rxs.substring(9)) > 8) {
				return 0;
			}
			rxs = (isF ? "-" : "") + rxs;
			Integer rx = Integer.parseInt(rxs);
			return rx;
		}
		if (rxs.length() == 10 && Integer.parseInt(rxs.substring(0, 9)) > 214748364) {
			return 0;
		}
		if (rxs.length() == 10 && rxs.substring(0, 9).equals("214748364") && Integer.parseInt(rxs.substring(9)) > 7) {
			return 0;
		}

		Integer rx = Integer.parseInt(rxs);
		return rx;
	}

}
