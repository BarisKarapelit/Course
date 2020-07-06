using System;
using System.Collections.Generic;
using System.Text.RegularExpressions;

namespace final_assignment
{
class Program
{


    static void Main(string[] args)
    {

        Console.WriteLine("the maxmium sum is : {0}", func(0, 0));
        Console.ReadLine();
    }

    //function to read the string that contain the numbers
    static public string read()
    {
        const string x = @"     215
                               193 124
                              117 237 442
                            218 935 347 235
                          320 804 522 417 345
                        229 601 723 835 133 124
                      248 202 277 433 207 263 257
                    359 464 504 528 516 716 871 182
                  461 441 426 656 863 560 380 171 923
                 381 348 573 533 447 632 387 176 975 449
               223 711 445 645 245 543 931 532 937 541 444
             330 131 333 928 377 733 017 778 839 168 197 197
            131 171 522 137 217 224 291 413 528 520 227 229 928
          223 626 034 683 839 053 627 310 713 999 629 817 410 121
        924 622 911 233 325 139 721 218 253 223 107 233 230 124 233";

        return x;
    }

    //function to convert the string text into list of list<int>
    static public List<List<int>> ConvertSArrngToListOfIntList(string str)
    {
        //calculate the number of rows inside the string
        int Rows = 1;
        foreach (var item in str)
        {
            if (item == '\n') Rows++;
        }
        //create an array by line characters
        string[] arr = str.Split('\n');
        List<List<int>> b = new List<List<int>>();
        for (int i = 0; i < Rows; i++)
        {

            MatchCollection mc = Regex.Matches(arr[i], @"\d{3}");
            List<int> aa = new List<int>();
            foreach (Match item in mc)
            {
                int y = int.Parse(item.Value);
                aa.Add(y);
            }

            b.Insert(i, aa);
        }
        //complete every row to 15 values by adding zero
        for (int i = 0; i < Rows; i++)
        {
            if (b[i].Count <= Rows)
            {
                for (int j = i + 1; j < Rows; j++)
                {
                    b[i].Add(0);
                }

            }

        }

        return b;
    }
    //function to check if the number is prime or not and return boolean value
    static public bool PrimeChecker(int num)
    {
        if (num == 0 || num == 1)
        {
            return false;
        }
        else
        {
            for (int a = 2; a <= (int)Math.Floor(Math.Sqrt(num)); a++)
            {
                if (num % a == 0)
                {

                    return false;
                }

            }
            return true;
        }
    }
    private static int func(int x, int y)
    {
        List<List<int>> arrlist = ConvertSArrngToListOfIntList(read());
        if (x >= arrlist.Count)
            return 0;
        int self = arrlist[x][y];
        if (PrimeChecker(self))
            return 0;
        else

            return self + Math.Max(func(x + 1, y), func(x + 1, y + 1));
    }



}
 }