package leetcode.problems;

public class Solution5 {

	class Entity {
		private byte c;
		private int count;
		private Entity left;
		private Entity right;

		public Entity(byte c) {
			this.c = c;
			count = 1;
		}

		public byte getC() {
			return c;
		}

		public String toString() {
			byte[] b = new byte[this.count];
			for (int i = 0; i < this.count; i++) {
				b[i] = this.c;
			}
			return new String(b);
		}

		public int getCount() {
			return count;
		}

		public void addCount() {
			this.count++;
		}

		public Entity getLeft() {
			return left;
		}

		public void setLeft(Entity left) {
			this.left = left;
		}

		public Entity getRight() {
			return right;
		}

		public void setRight(Entity right) {
			this.right = right;
		}

	}

	private String tryAppend(String result, Entity left, Entity right) {
		if (null == result) {
			result = left.toString();
			result = tryAppend(result, left.getLeft(), right.getRight());
			return result;
		}
		if (null == left || null == right || left.getC() != right.getC()) {
			return result;
		}
		if (left.getCount() != right.getCount()) {
			String tmp = left.getCount() > right.getCount() ? right.toString() : left.toString();
			result = tmp + result + tmp;
			return result;
		}
		String tmp = left.toString();
		result = tmp + result + tmp;
		result = tryAppend(result, left.getLeft(), right.getRight());

		return result;
	}

	public String longestPalindrome(String s) {
		byte[] bytes = s.getBytes();
		Entity first = null;
		Entity current = null;
		for (byte b : bytes) {
			if (first == null) {
				first = new Entity(b);
				current = first;
				continue;
			}
			if (b == current.getC()) {
				current.addCount();
				continue;
			}
			Entity next = new Entity(b);
			current.setRight(next);
			next.setLeft(current);
			current = next;
		}
		Entity test = first;
		String result = "";
		while (test != null) {
			String tmp = tryAppend(null, test, test);
			if (tmp.length() > result.length()) {
				result = tmp;
			}
			test = test.right;

		}
		return result;
	}

}
