package leetcode.problems;

public class Solution3 {

	public int lengthOfLongestSubstring(String s) {

		byte[] b = s.getBytes();
		byte[] tmp = new byte[b.length];
		int tmpSize = 0;
		int skipIndex = 0;
		int length = 0;

		for (int i = 0; i < b.length; i++) {
			if (existSameByte(tmp, b[i], skipIndex, tmpSize)) {
				length = length > tmpSize - skipIndex ? length : tmpSize - skipIndex;
				for (int j = skipIndex; j < tmpSize; j++) {
					if (tmp[j] == b[i]) {
						tmp[j] = 0;
						skipIndex = j + 1;
						tmp[tmpSize++] = b[i];
						break;
					}
					tmp[j] = 0;
				}
			} else {
				tmp[tmpSize++] = b[i];
			}
		}
		length = length > tmpSize - skipIndex ? length : tmpSize - skipIndex;
		return length;
	}

	private boolean existSameByte(byte[] bs, byte b, int skipIndex, int tmpSize) {
		for (int k = skipIndex; k < tmpSize; k++) {
			if (bs[k] == b) {
				return true;
			}
		}
		return false;
	}

}
