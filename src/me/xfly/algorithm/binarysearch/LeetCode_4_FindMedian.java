package me.xfly.algorithm.binarysearch;

public class LeetCode_4_FindMedian {

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;

        //两个数组长度和如果为偶数，则中位数是中间两个数的平均值，因此要找到两个数
        int mid1 = (length1 + length2 + 1) / 2;
        int mid2 = (length1 + length2 + 2) / 2;

        return (findKthSmallestNum(nums1, 0, length1 - 1, nums2, 0, length2 - 1, mid1) + findKthSmallestNum(nums1, 0, length1 - 1, nums2, 0, length2 - 1, mid2)) / 2.0d;
    }

    public static double findKthSmallestNum(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        //注意此处不是数组长度，而是可用数据的个数
        int length1 = end1 - start1 + 1;
        int length2 = end2 - start2 + 1;

        //统一转换成第一额数组长度比第二个数组短，方便后续操作
        if (length1 > length2) {
            return findKthSmallestNum(nums2, start2, end2, nums1, start1, end1, k);
        }

        //一个数组为空或所有数据都被用到，直接从另一个返回
        if (length1 == 0) {
            return nums2[start2 + k - 1];
        }

        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }

        //每个数组取 k/2 个数对比，小的那边全部淘汰
        int index1 = start1 + Math.min(length1, k / 2) - 1;
        int index2 = start2 + Math.min(length2, k / 2) - 1;

        if (nums1[index1] < nums2[index2]) {
            //输的那边全部淘汰，因此下次的起始 index 为 index1 + 1
            //k 为 k 减去淘汰的个数 （index1 - start1）+ 1, 比如 index1 = 1，start1 = 1，实际是淘汰一个，所以要加一
            return findKthSmallestNum(nums1, index1 + 1, end1, nums2, start2, end2, k - (index1 - start1 + 1));
        } else {
            return findKthSmallestNum(nums1, start1, end1, nums2, index2 + 1, end2, k - (index2 - start2 + 1));
        }
    }
}
