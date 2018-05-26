package leetcode.problems;

public class Solution4 {

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int nums1Start = -1;
		int nums1End = nums1.length - 1;
		int nums2Start = -1;
		int nums2End = nums2.length - 1;
		int totalLength = nums1.length + nums2.length;
		if (totalLength == 0) {
			return 0;
		}
		while (true) {
			if (totalLength == 1) {
				if(nums1Start < nums1End){
					return nums1[++nums1Start];
				}else{
					return nums2[++nums2Start];
				}
			}

			if (totalLength == 2) {
				if(nums1Start == nums1End){
					return (Double.valueOf(nums2[++nums2Start])+Double.valueOf(nums2[++nums2Start]))/2;
				}
				if(nums2Start == nums2End){
					return (Double.valueOf(nums1[++nums1Start])+Double.valueOf(nums1[++nums1Start]))/2;
				}
				return (Double.valueOf(nums1[++nums1Start])+Double.valueOf(nums2[++nums2Start]))/2;
			}

			totalLength--;
			totalLength--;
			if(nums1Start == nums1End){
				nums2Start++;
				nums2End--;
				continue;
			}
			if(nums2Start == nums2End){
				nums1Start++;
				nums1End--;
				continue;
			}
			if(nums1[nums1Start + 1] < nums2[nums2Start+1]){
				nums1Start++;
			}else{
				nums2Start++;
			}
			if(nums1Start==nums1End){
				nums2End--;
				continue;
			}
			if(nums2Start==nums2End){
				nums1End--;
				continue;
			}
			if(nums1[nums1End] < nums2[nums2End]){
				nums2End--;
			}else{
				nums1End--;
			}
		}

	}

}
