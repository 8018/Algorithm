package me.xfly.algorithm.binarysearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {10, 10, 10, 10, 10, 11, 18};
        int target = 10;
        System.out.println(findFirstTarget(nums, target, 0, nums.length - 1));
    }

    static int binarySearchByTraverse(int[] nums,int target){
        int left = 0,right = nums.length-1;
        if (left > right) {
            return -1;
        }

        while (left <= right){
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    static int findTarget(int[] nums, int target, int l, int r) {
        if (l > r) {
            return -1;
        }
        if (l == r && nums[l] != target) {
            return -1;
        }
        int m = (l + r) / 2;
        if (nums[m] == target) {
            return m;
        }
        if (nums[m] > target) {
            return findTarget(nums, target, l, m - 1);
        }
        if (nums[m] < target) {
            return findTarget(nums, target, m + 1, r);
        }
        return -1;
    }

    static int findFirstTarget(int[] nums, int target, int l, int r) {
        if (l > r) {
            return -1;
        }

        if (l == r && nums[l] != target) {
            return -1;
        }

        int m = (l + r) / 2;
        if (nums[m] == target) {
            if (m - 1 >= l && nums[m - 1] == target) {
                return findFirstTarget(nums, target, l, m - 1);
            }
            return m;
        }
        if (nums[m] > target) {
            return findFirstTarget(nums, target, l, m - 1);
        }
        if (nums[m] < target) {
            return findFirstTarget(nums, target, m + 1, r);
        }
        return -1;
    }

    static int findLastTarget(int[] nums, int target, int l, int r) {
        if (l > r) {
            return -1;
        }

        if (l == r && nums[l] != target) {
            return -1;
        }

        int m = (l + r) / 2;
        if (nums[m] == target) {
            if (m + 1 <= r && nums[m + 1] == target) {
                return findLastTarget(nums, target, m + 1, r);
            }
            return m;
        } else if (nums[m] > target) {
            return findLastTarget(nums, target, l, m - 1);
        } else {
            return findLastTarget(nums, target, m + 1, r);
        }
    }
}
