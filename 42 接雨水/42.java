
/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 示例:
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 */

class Solution {
     public int trap(int[] height) {
        if(height.length<=2){
            return 0;
        }
        int maxIndex=0, maxValue = 0;
        int res = 0;
        // ²éÕÒ×î¸ßµã
        for(int i=0;i<height.length;i++){
            if(height[i]>=maxValue){
                maxValue = height[i];
                maxIndex = i;
            }
        }

        // ·Ö±ð´ÓÁ½±ßÏòÖÐ¼ä×î¸ßµã
        int curRoot = height[0];
        for(int i =0;i<maxIndex;i++){
            if(curRoot<height[i]){
                curRoot = height[i];
            }else{
                res += curRoot-height[i];
            }
        }
         
        curRoot = height[height.length-1];
        for(int i=height.length-1;i>maxIndex;i--){
            if(curRoot<height[i]){
                curRoot = height[i];
            }else{
                res += curRoot-height[i];
            }
        }

        return res;
     }
}