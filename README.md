#As of now,simulation is fixed by 5.
#I've also fixed lane to 0 to 3, as there was no mention of min_lane or max_lane input.

Sample input:
4
1 2 5 10
2 1 10 15
3 3 15 30
1 5 2 10 

first line: number of cars;
next 4 line: [lane] [position] [speed] [max_speed]


output will be like this:
Initially:
Position [x=1, y=2]
Position [x=2, y=1]
Position [x=3, y=3]
Position [x=1, y=5]
Iteration: 1
Position [x=1, y=7]
Position [x=2, y=11]
Position [x=3, y=18]
Position [x=2, y=15]
Iteration: 2
Position [x=1, y=12]
Position [x=2, y=21]
Position [x=3, y=33]
Position [x=1, y=25]
Iteration: 3
Position [x=2, y=22]
Position [x=2, y=31]
Position [x=3, y=48]
Position [x=1, y=27]
Iteration: 4
Position [x=1, y=32]
Position [x=2, y=41]
Position [x=3, y=63]
Position [x=2, y=37]
Iteration: 5
Position [x=1, y=37]
Position [x=2, y=51]
Position [x=3, y=78]
Position [x=3, y=47]