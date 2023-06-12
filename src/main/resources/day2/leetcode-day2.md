# leetcode-day2

1. *删除有序数组中的重复项* *II*(https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/solution/shan-chu-pai-xu-shu-zu-zhong-de-zhong-fu-yec2/)

   解题思路：**slow-2数组元素和fast当前指向数组元素是否相等，slow-2即可替代cout计数**

   * true，fast++
   * false，slow++，并将slow指向元素赋值为fast指向元素

   ```java
   if (nums.length <= 2) {
       return nums.length;
   }
   // 慢指针-2和fast指针指向元素是否相等
   int slow = 2;
   int fast = 2;
   while (fast < nums.length) {
       if (nums[slow - 2] != nums[fast]) {
           nums[slow] = nums[fast];
           slow++;
       }
       fast++;
   }
   return slow;
   ```

2. 多数元素（https://leetcode.cn/problems/majority-element/solution/3chong-fang-fa-by-gfu-2/）

   ```java
   // count计数相同++，不同--
   // 投票法
   int result = nums[0];
   int count = 0;
   for (int num : nums) {
       if (result == num) {
           count++;
       } else {
           count--;
       }
       if (count < 0) {
           count = 1;
           result = num;
       }
   }
   return result;
   ```

3. 买卖股票的最佳时机（https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/?envType=study-plan-v2&envId=top-interview-150）

   ![image-20230612214721123.png](..%2Fimages%2Fimage-20230612214721123.png)

   ```java
   // 根据数组可以得到如上图坐标只需要找到坐标中最小值以及相对最小值的最大值
   // 最小值即为当前值和初始值元素相比，最大值则是当前最大值和当前遍历元素-最小值
   if (prices.length <= 1) {
       return 0;
   }
   int min = prices[0];
   int max = 0;
   for (int price : prices) {
       min = Math.min(min, price);
       max = Math.max(max, price - min);
   }
   return max;
   ```

   
