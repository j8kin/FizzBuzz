# FizzBuzz
The initial version of Task is not contain information that this Task should implement multi-thread version of algorithm that is why it is possible to write something like this:
```
public fuzzbuzz() {
  for (int i = 0; i < 100; i++) {
    if ((i % 3 == 0) && (i % 5 == 0)) {
      System.out.println("FizzBuzz");
    }
    else if (i % 3 == 0) {
      System.out.println("Fizz");
    }
    else if (i % 5 == 0) {
      System.out.println("Fizz");
    }
    else {
      System.out.println(i);
    }
  }
}
```

But I know this Task and that is why implement multi-thread version.
=============================
Initial description:
Напишите программу, которая выводит на экран числа от 1 до 100. При этом вместо чисел,
кратных 3, программа должна выводить слово Fizz, а вместо чисел, кратных 5 — слово Buzz.
Если число кратно 15, то программа должна выводить слово FizzBuzz.
Для 15 выводим FizzBuzz, а не FizzBuzzFizzBuzz.
