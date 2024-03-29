/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组?[0,1,2,4,5,6,7]?可能变为?[4,5,6,7,0,1,2]?)。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回?-1?。
 * 你可以假设数组中不存在重复的元素。
 * 你的算法时间复杂度必须是?O(log?n
 * 示例 1:
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 *
 * 示例 2:
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1

 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 */

class Solution {
    public int search(int[] nums, int target) {
        
        return binarySearch(nums, 0, nums.length - 1, target);
    }
    
    int binarySearch(int[] nums, int left, int right, int target) {
        if (left > right) return -1;
        
        int mid = (left + right) / 2;
        
        if (nums[mid] == target) return mid;
        
        if (nums[mid] < nums[right]) {// 右边有序
            if (target > nums[mid] && target <= nums[right]) {  // 目标在右边
                return binarySearch(nums, mid + 1, right, target);
            }
            else {  // 目标在左边
                return binarySearch(nums, left, mid - 1, target);
            }
        }
        else {  //左边有序
            if (target < nums[mid] && target >= nums[left]) {  // 目标在左边
                return binarySearch(nums, left, mid - 1, target);
            }
            else {  // 目标在右边
                return binarySearch(nums, mid + 1, right, target);
            }
        }
    }
}