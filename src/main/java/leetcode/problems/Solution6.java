package leetcode.problems;

public class Solution6 {

	public String convert(String s, int numRows) {
		if (numRows == 1) {
			return s;
		}
		if (numRows == 2) {
			byte[] bytes = s.getBytes();
			byte[] result = new byte[bytes.length];
			int j = 0;
			for (int i = 0; i < bytes.length; i = i + 2) {
				result[j++] = bytes[i];
			}
			for (int i = 1; i < bytes.length; i = i + 2) {
				result[j++] = bytes[i];
			}
			return new String(result);
		}
		byte[] bytes = s.getBytes();
		byte[][] br = new byte[numRows][s.length()];
		int sideLineNum = numRows;
		int column = 0;
		for (int i = 0; i < bytes.length; i++) {
			int remainder = column % (numRows - 1);
			if (remainder == 0) {
				if (sideLineNum > 0) {
					br[numRows - sideLineNum--][column] = bytes[i];
					if (sideLineNum == 0) {
						column++;
					}
				}
				continue;
			}
			br[numRows - remainder - 1][column++] = bytes[i];
			if (remainder + 2 == numRows) {
				sideLineNum = numRows;
			}

		}
		byte[] result = new byte[bytes.length];
		int i = 0;
		for (byte[] row : br) {
			for (byte b : row) {
				if (b != 0) {
					result[i++] = b;
				}

			}
		}

		return new String(result);
	}

}
