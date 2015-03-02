
/**
 * Given n non-negative integers a1, a2, ..., an, 
 * where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two endpoints 
 * of line i is at (i, ai) and (i, 0). Find two lines, 
 * which together with x-axis forms a container, 
 * such that the container contains the most water.
 * 
 * Note: You may not slant the container.
 */

package medium011.containerWithMostWater;

public class Solution {
	public int maxArea(int[] height) {
		if(height == null || height.length == 0) return 0;
		int area = 0;
		int left = 0;
		int right = height.length-1;

		while(right>left){
			int h = Math.min(height[right],height[left]);
			area = Math.max(area, h*(right-left));
			if(h == height[right]) right--;
			else left++;
		}
		return area;
	}
}
