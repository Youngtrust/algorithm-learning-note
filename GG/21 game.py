"""
21点又名黑杰克（英文：Blackjack），起源于法国，已流传到世界各地。
21点，是一种使用扑克牌玩的赌博游戏。亦是唯一一种在赌埸中可以在概率中战胜庄家的一种赌博游戏。
———来自好搜百科
我们定义21点的规则如下，和原始规则稍微不一样。
牌点数如下：
A 2 3 4 5 6 7 8 9 10 J Q K
A当成1点
JQK全部当成10点。
我们假设赌场准备了很多副牌，也就是可以假设每次摸到每张牌的概率是一样的。
玩家有两个人，分别为庄家和闲家。
一开始两人都拿两张牌，两个人都可以看到对方的牌。
闲家先操作，每次可以叫牌或者停止叫牌。
如果叫牌，从牌堆中拿一张牌，一旦叫牌后手牌超过21点，直接判输，称为“爆点”，否则一直叫牌直到停止叫牌，轮到庄家。
轮到庄家后，跟闲家一样的叫牌或停止叫牌，一旦爆点也是直接判输。
如果没有爆点，谁点数大就谁赢，点数一样判平。
给你两家的牌，如果闲家胜率>50%输出”YES”，否则输出”NO”
哦，对了，每个人都是绝顶聪明的。

Input
第一行一个数Test(Test<=100000)。表示数据组数。
下面每组数据，一个4字符字符串,前两个字符表示闲家的牌，后两张表示庄家的。
（用T表示10）
Output
对于每组数据输出”YES”或者”NO”,表示闲家是否有50%以上的胜率。
Sample Input
1
TTT9
Sample Output
YES

用dp[0][i][j]表示闲家当前点数为i，庄家当前点数为j，
闲家叫牌时闲家获胜的最大几率（闲家要最大化自身赢率），则得到转移方程
dp[0][i][j]=max{dp[0][i][j],(dp[0][i+1][j]+…+dp[0][i+9][j]+4*dp[0][i+10][j])/13}

用dp[1][i][j]表示闲家当前点数为i，庄家当前点数为j，
庄家叫牌时闲家获胜的最小几率（庄家要最小化闲家赢率），则得到转移方程
dp[1][i][j]=min{dp[1][i][j],(dp[1][i][j+1]+…+dp[1][i][j+9]+4*dp[1][i][j+10])/13}

两个分别用记忆化搜索即可
————————————————
\Blackjack is a two player card game whose rules are as follows:

The player and then the dealer are each given two cards.
The player can then "hit", or ask for arbitrarily many additional cards, 
so as his or her total does not exceed 21.

The dealer must then hit if his or her total is 16 or lower, otherwise pass.
Finally, the two compare totals, 
and the one with the greatest sum not exceeding 21 is the winner.

For this problem, we simplify the card values to be as follows: 
each card between 2 and 10 counts as their face value, 
face cards count as 10, and aces(A) count as 1.

Given perfect knowledge of the sequence of cards in the deck, 
implement a blackjack solver that maximizes the player's score 
(that is, wins minus losses).
"""

import random


class Deck:
    def __init__(self, seed=None):
        self.cards = [i for i in range(1, 10)] * 4 + [10] * 16
        random.seed(seed)
        random.shuffle(self.cards)

    def deal(self, start, n):
        return self.cards[start:start + n]


class Player:
    def __init__(self, hand):
        self.hand = hand
        self.total = 0

    def deal(self, cards):
        self.hand.extend(cards)
        self.total = sum(self.hand)


def cmp(x, y):
    return (x > y) - (x < y)


def play(deck, start, scores):
    player = Player(deck.deal(start, 2))
    dealer = Player(deck.deal(start + 2, 2))
    results = []

    for i in range(49 - start):
        count = start + 4
        player.deal(deck.deal(count, i))
        count += i

        if player.total > 21:
            results.append((-1, count))
            break

        while dealer.total < 17 and count < 52:
            dealer.deal(deck.deal(count, 1))
            count += 1
        if dealer.total > 21:
            results.append((1, count))
        else:
            results.append((cmp(player.total, dealer.total), count))

    options = []
    for score, next_start in results:
        options.append(score +
                       scores[next_start] if next_start <= 48 else score)
    scores[start] = max(options)


def blackjack(seed=None):
    deck = Deck(seed)
    scores = [0 for _ in range(52)]

    for start in range(48, -1, -1):
        play(deck, start, scores)

    return scores[0]
