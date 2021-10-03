def furthestValidPair(nums):
    """"     
    max(k), k = |i-j| == |A-A[j]|

    应该这样做，把array转化成 A【i】-i和A【i】+i，
    相当于寻找A【i】-i==A【j】-j或者A【i】+i==A【j】+j的最大值，
    search array用hash table记录重复的最大值就好了。

    我们假设i<j，那么我们有如下两种情况：
    j-i = a[j]-a[i]
    j-i = a[i]-a[j]
    移项得：     a[i]-i = a[j] - j or a[i]+i = a[j]+j
    """
    res = 0
    table1 = defaultdict(list)
    table2 = defaultdict(list)

    for i, v in enumerate(nums):
        a = v-i
        table1[a].append(i)
        if len(table1[a]) > 1:
            res = max(res, table1[a][-1]-table1[a][0])
        b = v+i
        table2[b].append(i)
        if len(table2[b]) > 1:
            res = max(res, table2[-1]-table2[0])

    return res
