using System.Runtime.InteropServices;

internal class InterestCalculator
{
    public static float principle; //The initial sum of money.
    public static float rate; //In a regular percentage (non decimal).
    public static float timespan; // Timespan in years.
    public static float interest; //The amount of interest earned.
    public static bool hasP, hasR, hasT, hasI;

    public static bool prompting = true;


    private static void Main(string[] args)
    {
        int listIndex = 0;

        while(prompting)
        {
            switch(listIndex)
            {
                case 0:
                    Console.WriteLine("What's the principle (P), if not known; enter 0");
                    principle = float.Parse(Console.ReadLine());

                    if(principle == 0)
                    {
                        Console.WriteLine("Principle unknown.");
                        listIndex = 1;
                    }
                    else if(principle > 0)
                    {
                        hasP = true;
                        listIndex = 1;
                    }
                    break;
                case 1:
                    Console.WriteLine("What's the interest rate (I), if not known; enter 0");
                    rate = float.Parse(Console.ReadLine());

                    if (rate == 0)
                    {
                        Console.WriteLine("Rate unknown.");
                        listIndex = 2;
                    }
                    else if (rate > 0)
                    {
                        if (rate > 1)//If you entered a value that's not a decimal percentage.
                        {
                            rate = rate / 100;
                        }

                        hasR = true;
                        listIndex = 2;
                    }
                    break;
                case 2:
                    Console.WriteLine("What's the timespan in years (T), or a fraction, if not known; enter 0");
                    timespan = float.Parse(Console.ReadLine());

                    if (timespan == 0)
                    {
                        Console.WriteLine("Timespan unknown.");
                        listIndex = 3;
                    }
                    else if (timespan > 0)
                    {
                        hasT = true;
                        listIndex = 3;
                    }
                    break;
                case 3:
                    Console.WriteLine("What is the final interest amount (I), if not known; enter 0");
                    interest = float.Parse(Console.ReadLine());

                    if (interest == 0)
                    {
                        Console.WriteLine("Interest unknown.");
                        prompting = false;
                    }
                    else if (interest > 0)
                    {
                        hasI = true;
                        prompting = false;
                    }
                    break;

            }
        }

        if (!prompting)
        {
            if (hasP && hasR && hasT)
            {
                Console.WriteLine("Solving for Interest");

                Console.WriteLine("Interest is - " + SolveForInterest(principle, rate, timespan));
                Console.WriteLine("Total amount to be paid is - " + (principle + SolveForInterest(principle, rate, timespan)));
            }
            else if (hasR && hasT && hasI)
            {
                Console.WriteLine("Solving for Principle");

                Console.WriteLine("Principle is - " + SolveForPrinciple(rate, timespan, interest));
            }
            else if (hasR && hasI && hasP)
            {
                Console.WriteLine("Solving for Time");

                Console.WriteLine("Timespan is - " + SolveForTime(rate, interest, principle) + " in years.");
            }
            else if (hasI && hasP && hasT)
            {
                Console.WriteLine("Solving for Rate");

                Console.WriteLine("Rate is - " + SolveForRate(interest, principle, timespan));
            }
        }
    }


    public static float SolveForInterest(float p, float r, float t)
    {
        float i = (p * r * t);
        return i;
    }

    public static float SolveForPrinciple(float r, float t, float i)
    {
        float p = i / r * t;
        return p;
    }

    public static float SolveForTime(float r, float i, float p)
    {
        float t = i / p * r;
        return t;
    }

    public static float SolveForRate(float i, float p, float t)
    {
        float r = i / p * t;
        return r;
    }
}