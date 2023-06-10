# LeetCode-day1

1. 合并有序数组（https://leetcode.cn/problems/merge-sorted-array/?envType=study-plan-v2&envId=top-interview-150）

   * 正向双指针

     ```java
     		int p1 = 0;
             int p2 = 0;
             int cur = 0;
             int[] result = new int[m + n];
             while (p1 < m || p2 < n) {
                 // nums1 指针达到边界插nums2
                 if (p1 == m) {
                     result[cur] = nums2[p2++];
                 } else if (p2 == n) {
                     // nums2 指针达到边界插nums1
                     result[cur] = nums1[p1++];
                 } else if (nums1[p1] < nums2[p2]) {
                     result[cur] = nums1[p1++];
                 } else {
                     result[cur] = nums2[p2++];
                 }
                 cur++;
             }
             for (int i = 0; i < result.length; i++) {
                 nums1[i] = result[i];
             }
     ```

   * 逆向双指针

     ```java
     public static void merge3(int[] nums1, int m, int[] nums2, int n) {
             int p1 = m - 1;
             int p2 = n - 1;
             int tail = m + n - 1;
             int cur;
             // 两个指针任一到0后即可结束
             while (p1 >= 0 || p2 >= 0) {
                 if (p1 == -1) {
                     cur = nums2[p2--];
                 } else if (p2 == -1) {
                     cur = nums1[p1--];
                 } else if (nums1[p1] > nums2[p2]) {
                     cur = nums1[p1--];
                 } else {
                     cur = nums2[p2--];
                 }
                 nums1[tail--] = cur;
             }
         }
     ```

     

2. 移除元素（https://leetcode.cn/problems/remove-element/?envType=study-plan-v2&envId=top-interview-150）

   ```java
   // 双指针：p1指针指向数组头，p2指针指向数组尾部
           int p1 = 0;
           int p2 = nums.length - 1;
           int count = 0;
           while (p1 <= p2) {
               if (nums[p2] == val) {
                   p2--;
                   count++;
                   continue;
               }
               if (nums[p1] == val) {
                   nums[p1] = nums[p2];
                   nums[p2] = val;
                   p2--;
                   count++;
               }
               p1++;
           }
           return nums.length - count;
   ```

3. 移除重复元素（https://leetcode.cn/problems/remove-duplicates-from-sorted-array/?envType=study-plan-v2&envId=top-interview-150）

   ```java
   public static int removeDuplicates(int[] nums) {
           // 移除重复元素，即将不重复元素移动到左边
           if (nums == null || nums.length == 0) {
               return 0;
           }
           int p1 = 0;
           int p2 = 1;
           while (p2 < nums.length) {
               if (nums[p1] != nums[p2]) {
                   nums[p1 + 1] = nums[p2];
                   p1++;
               }
               p2++;
           }
           return p1 + 1;
       }
   ```

   