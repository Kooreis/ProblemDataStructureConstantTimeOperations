using System;
using System.Collections.Generic;

public class RandomizedSet
{
    private Dictionary<int, int> dict;
    private List<int> list;
    private Random rand;

    public RandomizedSet()
    {
        dict = new Dictionary<int, int>();
        list = new List<int>();
        rand = new Random();
    }
}