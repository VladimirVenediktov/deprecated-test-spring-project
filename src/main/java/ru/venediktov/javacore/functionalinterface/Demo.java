package ru.venediktov.javacore.functionalinterface;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Функциональный интерфейс — это интерфейс, который содержит ровно один абстрактный метод,
 * то есть описание метода без тела.
 */
public class Demo {


  public static void main(String[] args) {

    //Predicate<T> проверяет соблюдение некоторого условия
    Predicate<Integer> isPositiveNumber = x -> x > 0;
    System.out.println(isPositiveNumber.test(5));

    //Supplier<T> не принимает никаких аргументов, но должен возвращать объект типа T
    Supplier<Double> getRandomNumber = Math::random;
    System.out.println(getRandomNumber.get());

    //Function<T,R> представляет функцию перехода от объекта типа T к объекту типа R:
    Function<Integer, String> convertIntToString = x -> Integer.toString(x);
    System.out.println(convertIntToString.apply(777));

    //свой функциональный интерфейс
    Operationable operation = (x, y) -> x+y;
    System.out.println(operation.calculate(4,5));
  }

}

@FunctionalInterface
interface Operationable {
  int calculate(int a, int b);
}
