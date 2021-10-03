"""
There is a hotel with n rooms. 
The rooms are represented by a 2D integer array rooms where 
rooms[i] = [roomIdi, sizei] denotes that there is a room with room number roomIdi and size equal to sizei. 
Each roomIdi is guaranteed to be unique.

You are also given k queries in a 2D array queries where queries[j] = [preferredj, minSizej]. 
The answer to the jth query is the room number id of a room such that:

The room has a size of at least minSizej, and
abs(id - preferredj) is minimized, where abs(x) is the absolute value of x.



Input: rooms = [[2,2],[1,2],[3,2]], queries = [[3,1],[3,3],[5,2]]
Output: [3,-1,3]
Explanation: The answers to the queries are as follows:
Query = [3,1]: Room number 3 is the closest as abs(3 - 3) = 0, and its size of 2 is at least 1. The answer is 3.
Query = [3,3]: There are no rooms with a size of at least 3, so the answer is -1.
Query = [5,2]: Room number 3 is the closest as abs(3 - 5) = 2, and its size of 2 is at least 2. The answer is 3.


The idea of this problem is to sort our rooms and queries by time and 
start with biggest times and keep sorted list aval for avaliable rooms: 

such that we can choose from. Imagine, 
that we have rooms with sizes [7, 6, 3, 2, 1] and queries with sizes [5, 3, 1]. 
Then on the first step we see query with size 5 and avaliable rooms we have are [7, 6]. 
Then we look at query 3 and now we have avaliable rooms [7, 6, 3]. 
Finally, we look at query 1 and now avaliable rooms are [7, 6, 3, 2, 1].

However we need to return closest index among all avaliable rooms, 
so we need to keep our avaliable rooms sorted with id. 
If fact, we put tuple (id, size) into our sorted list.

Also we use two pointers approach: 
p1 is responsible for rooms R and 
p2 is responsible for queries Q. 
If R[p1][0] >= Q[p2][0], it means that we can add one more room to aval, so we do it and update p1. 
If we can not do it, it means we already saturated aval, so we look at it. 
If it is empty, we must return -1, we do not have any candidates. 
If it is not empty, we use binary search: 
    there can be at most 3 (in fact 2) candidates for the nearest index: we chose the best of them.

Complexity
Let n be number of rooms and q is number of queries. 
Then we have time complexity O(n log n + q log n) to sort our data and 
then we have n+q iterations in our 2 pointers approach, where each time we use either add or bisect operation with complexity O(log n). 
So, total time complexity is O(n log n + q log q + q log n). Space complexity is O(n + q).
"""
from sortedcontainers import SortedList


class Solution:
    def closestRoom(self, rooms, queries):
        R = sorted([(j, i) for i, j in rooms])[::-1]
        Q = sorted((k, j, i) for i, (j, k) in enumerate(queries))[::-1]

        # Example -
        # >>> a = '1234'
        # >>> a[::-1]
        # '4321'
        n, q = len(R), len(Q)
        # p1 is responsible for rooms R and p2 is responsible for queries Q.
        p1, p2, aval, ans = 0, 0, SortedList(), [-1]*q

        while p1 <= n and p2 < q:

            if p1 < n and R[p1][0] >= Q[p2][0]:
                # it means that we can add one more room to aval, so we do it and update p1.
                aval.add(R[p1][1])
                p1 += 1
            else:
                # If we can not do it, it means we already saturated aval, so we look at it.
                if len(aval) != 0:
                    preferred, ind = Q[p2][1], Q[p2][2]
                    i = aval.bisect(preferred)
                    # use binary search:
                    cands = []
                    if i > 0:
                        cands.append(aval[i-1])
                    if i < len(aval):
                        cands.append(aval[i])
                    # there can be at most 3 (in fact 2) candidates for the nearest index: we chose the best of them.
                    ans[ind] = min(cands, key=lambda x: abs(x - preferred))

                p2 += 1

        return ans
