* In order to sort keys of a java hashmap you need to use a TreeSet which is a
concrete implementation of a SortedSet

```java
HashMap<String, Integer> map = new HashMap<>();
SortedSet<String> keys = new TreeSet<>(map.getKeys());
```

* You can also pass in your own comparator (which can be a lambda) to help
with weird object comparisons

```java
Comparator<String> comparator = (String o1, String o2) -> {
    if o1.size() > o2.size() return 1;
}
SortedSet<String> keys = new TreeSet<>(comparator);
```

* Or you can use the Comparator.comparing method
```java
Comparator<MyClass> comparator = Comparator.comparing(MyClass::getAge)

```