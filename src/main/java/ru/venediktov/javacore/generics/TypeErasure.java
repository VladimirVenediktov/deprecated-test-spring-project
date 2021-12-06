package ru.venediktov.javacore.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Информация о типе параметра в generic стирается после компиляции
 */
public class TypeErasure<T> {

  private T value1;

  public void printValues() {
    System.out.println(value1);
  }

  public static <T> TypeErasure<T> createAndAddValue(Object o1) {
    TypeErasure<T> result = new TypeErasure<>();
    result.value1 = (T) o1;
    return result;
  }

  public static void main(String[] args) {
    // example 1
    Double d = 22.111;
    TypeErasure<Integer> test = createAndAddValue(d); // во время компиляции это стало TypeErasure<Object> test
    test.printValues();

    // example 2
    List<String> strings = new ArrayList<>();
    List<Integer> numbers = new ArrayList<>();

    System.out.println(strings.getClass());
    System.out.println(strings.getClass() == numbers.getClass()); // true
  }

}
