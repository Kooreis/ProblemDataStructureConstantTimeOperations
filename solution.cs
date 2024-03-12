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