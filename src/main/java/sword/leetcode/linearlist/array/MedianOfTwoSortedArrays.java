package sword.leetcode.linearlist.array;

/**
 * @program: draft
 * @description:
 * Median of Two Sorted Arrays:
 * There are two sorted arrays A and B of size m and n respectively[adv.分别的,独自的]. Find the median of the two sorted
 * arrays. The overall[全部的] run time complexity should be O(log(m + n)).
 *
 * Solution:
 * 这是一道非常经典的题。这题更通用的形式是，给定两个已经排序好的数组，找到两者所有元素中第k大的元素。
 * O(m +n)的解法比较直观，直接merge 两个数组，然后求第k大的元素。
 * 不过我们仅仅需要第k大的元素，是不需要“排序”这么昂贵的操作的。可以用一个计数器，记录当前已经找到第m大的元素了。
 * 同时我们使用两个指针 pA和 pB，分别指向A和B数组的第一个元素，使用类似于merge sort的原理，
 * 如果数组A当前元素小，那么pA++，同时 m++;
 * 如果数组B当前元素小，那么 pB++，同时 m++。
 * 最终当m等于k的时候，就得到了我们的答案，O(k)时间,O(1)空间。但是，当k很接近m | n的时候，这个方法还是O(m | n)的。
 * 有没有更好的方案呢?
 * 我们可以考虑从k入手。如果我们每次都能够删除一个一定在第k大元素之前的元素，那么我们需要进行k次。
 * 但是如果每次我们都删除一半呢?由于A和B都是有序的，我们应该充分利用这里面的信息，类似于二分查找，也是充分利用了"有序"。
 * 假设A和B的元素个数都大于k/2，我们将A的第k/2个元素(即A[k/2-1])和B的第k/2个元素(即B[k/2-1])进行比较，
 * 有以下三种情况(为了简化这里先假设k为偶数，所得到的结论对于k是奇数也是成立的):
 * - A[k/2-1] == B[k/2-1]
 * - A[k/2-1] > B[k/2-1]
 * - A[k/2-1] < B[k/2-1]
 * 如果A[k/2-1] < B[k/2-1]，意味着A[o]到A[k/2-1]的肯定在AuB的top k元素的范围内，换句话说，A[k/2-1]不可能大于AuB的第k大元素。留给读者证明。
 * 因此，我们可以放心的删除A数组的这k/2个元素。同理，当A[k/2-1] >B[k/2-1]时，可以删除B数组的k/2个元素。
 * 当A[k/2-1] == B[k/2-1]时，说明找到了第k大的元素，直接返回A[k/2-1]或B[k/2-1]即可。
 * 因此，我们可以写一个递归函数。那么函数什么时候应该终止呢?
 * - 当A或B是空时，直接返回B[k-1]或A[k-1];
 * - 当k=1是，返回min(A[o]，B[0]);
 * - 当A[k/2-1] -= B[k/2-1]时，返回A[k/2-1]或B[k/2-1]
 * @author: atong
 * @create: 2021-01-17 14:01
 */
public class MedianOfTwoSortedArrays {
}

































