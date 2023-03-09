principle = 0
rate = 0
timespan = 0
interest = 0

hasP = False
hasR = False
hasT = False
hasI = False

menuIndex = 0
prompting = True


def SolveForInterest(p, r, t):
    return p * r * t


def SolveForRate(i, p, t):
    return i / p * t


def SolveForTime(r, i, p):
    return i / p * r


def SolveForPrinciple(r, t, i):
    return i / r * t


def FinalCalc():
    print("\n------------------------------")
    if hasP and hasR and hasT:
        print("Solving for Interest")
        print("Interest is - " + str(SolveForInterest(principle, rate, timespan)))
        print("Total amount to be paid is - " + str(principle + SolveForInterest(principle, rate, timespan)))
    elif hasR and hasT and hasI:
        print("Solving for Principle")
        print("Principle is - " + str(SolveForPrinciple(rate, timespan, interest)))
    elif hasR and hasI and hasP:
        print("Solving for Time")
        print("Timespan is - " + str(SolveForTime(rate, interest, principle)) + " in years.")
    elif hasI and hasP and hasT:
        print("Solving for Rate")
        print("Rate is - " + str(SolveForRate(interest, principle, timespan)))
    else:
        print("Couldn't solve, only 1 variable can be missing.")
    print("------------------------------")


while prompting:
    match menuIndex:
        case 0:
            print("What's the principle (P), if not known; enter 0")
            principle = float(input())
            if principle > 0:
                hasP = True
            menuIndex = 1
        case 1:
            print("What's the interest rate (I), if not known; enter 0")
            rate = float(input())
            if rate > 0:
                hasR = True
                if rate > 1:
                    rate = rate / 100
            menuIndex = 2
        case 2:
            print("What's the timespan in years (T), or a fraction, if not known; enter 0")
            timespan = float(input())
            if timespan > 0:
                hasT = True
            menuIndex = 3
        case 3:
            print("What is the final interest amount (I), if not known; enter 0")
            interest = float(input())
            if interest > 0:
                hasI = True
            FinalCalc()
            prompting = False
