package me.xfly.algorithm.binarysearch;

public class LeetCode_4_FindMedian {

    public static void main(String[] args) {
        int[] nums1 = {2, 3, 4};
        int[] nums2 = {1, 3, 5};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int mLength = nums1.length;
        int nLength = nums2.length;
        int left = (mLength + nLength + 1) / 2;
        int right = (mLength + nLength + 2) / 2;
        return (findKthSmallestNum(nums1, 0, mLength - 1, nums2, 0, nLength - 1, left) +
                findKthSmallestNum(nums1, 0, mLength - 1, nums2, 0, nLength - 1, right)) / 2.0d;
    }

    private static double findKthSmallestNum(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        //实际长度是尾标减去首标加一
        int mLength = end1 - start1 + 1;
        int nLength = end2 - start2 + 1;

        //调整统一把短的数组放在前面
        if (mLength > nLength) {
            return findKthSmallestNum(nums2, start2, end2, nums1, start1, end1, k);
        }

        //如果短的数组已经到头，直接返回长的那个
        if (mLength == 0) {
            return nums2[start2 + k - 1];
        }

        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }

        //找出两个数组的前 k/2 位对比，如果一个小于另一个，则移除全部数据
        int index1 = start1 + Math.min(mLength, k / 2) - 1;
        int index2 = start2 + Math.min(nLength, k / 2) - 1;

        if (nums1[index1] < nums2[index2]) {
            return findKthSmallestNum(nums1, index1 + 1, end1, nums2, start2, end2, k - (index1 - start1 + 1));

        } else {
            return findKthSmallestNum(nums1, start1, end1, nums2, index2 + 1, end2, k - (index2 - start2 + 1));
        }
    }
}
