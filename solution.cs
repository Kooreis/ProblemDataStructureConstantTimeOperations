Here is a C# console application that implements a data structure supporting insert, delete, search, and getRandom operations in constant time. This is achieved by using a combination of a Dictionary and a List.

```C#
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

    public bool Insert(int val)
    {
        if (dict.ContainsKey(val))
        {
            return false;
        }

        dict.Add(val, list.Count);
        list.Add(val);
        return true;
    }

    public bool Remove(int val)
    {
        if (!dict.ContainsKey(val))
        {
            return false;
        }

        int lastElement = list[list.Count - 1];
        int index = dict[val];
        list[index] = lastElement;
        dict[lastElement] = index;
        list.RemoveAt(list.Count - 1);
        dict.Remove(val);
        return true;
    }

    public int GetRandom()
    {
        return list[rand.Next(list.Count)];
    }
}

class Program
{
    static void Main(string[] args)
    {
        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.Insert(1);
        randomizedSet.Remove(2);
        randomizedSet.Insert(2);
        Console.WriteLine(randomizedSet.GetRandom());
    }
}
```
This code creates a class `RandomizedSet` that uses a `Dictionary` to store the values and their corresponding indices in the `List`. The `List` is used to store the values. This allows for constant time insert, delete, and search operations. The `GetRandom` method uses the `Random` class to generate a random index and return the value at that index in the `List`, which is also a constant time operation.