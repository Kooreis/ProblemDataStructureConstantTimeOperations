Here is a Python solution using a combination of a list and a dictionary to achieve constant time complexity for insert, delete, search, and getRandom operations.

```python
import random

class RandomizedSet:

    def __init__(self):
        self.dict = {}
        self.list = []

    def insert(self, val):
        if val not in self.dict:
            self.dict[val] = len(self.list)
            self.list.append(val)
            return True
        return False

    def delete(self, val):
        if val in self.dict:
            last_element, idx = self.list[-1], self.dict[val]
            self.list[idx], self.dict[last_element] = last_element, idx
            self.list.pop()
            del self.dict[val]
            return True
        return False

    def search(self, val):
        return val in self.dict

    def getRandom(self):
        return self.list[random.randint(0, len(self.list) - 1)]


# Testing the RandomizedSet class
random_set = RandomizedSet()

# Inserting elements
print(random_set.insert(1))  # True
print(random_set.insert(2))  # True
print(random_set.insert(3))  # True
print(random_set.insert(1))  # False, 1 already exists in the set

# Deleting elements
print(random_set.delete(2))  # True
print(random_set.delete(2))  # False, 2 does not exist in the set

# Searching for elements
print(random_set.search(1))  # True
print(random_set.search(2))  # False

# Getting a random element
print(random_set.getRandom())  # Returns 1 or 3
```

This solution uses a dictionary to store the values as keys and their indices in the list as values. The list is used to store the values. This allows for constant time complexity for insert, delete, and search operations. The getRandom operation also has constant time complexity because it uses the built-in random function to get a random index and then returns the value at that index in the list.