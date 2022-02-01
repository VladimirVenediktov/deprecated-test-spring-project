package ru.venediktov.javacore.datastructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import lombok.SneakyThrows;

public class Demo {

  @SneakyThrows
  public static void main(String[] args) {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Введите размер списка");
    String strCount = reader.readLine();
    int count = 0;
    try {
      count = Integer.parseInt(strCount);
    } catch (NumberFormatException e) {
      e.printStackTrace();
      return;
    }

    System.out.println("ArrayList:");
    insertIntoList(new ArrayList<>(), count);

    LinkedList<Integer> linkedList = new LinkedList<>();
    System.out.println("LinkedList (for):");
    insertIntoList(linkedList, count);

    System.out.println("LinkedList (iterator):");
    insertIntoLinkedListByIterator(linkedList);
  }

  public static void insertIntoList(List<Integer> list, int count) {
    long start = System.currentTimeMillis();
    for (int i = 0; i < count; i++) {
      //list.add(0, 1); //если вставлять только в 0-й элемент, то LinkedList выиграет
      list.add(i, new Random().nextInt());// а для такого случая уже лучше использовать итератор для быстродействия
    }
    long end = System.currentTimeMillis();
    System.out.println(String.format("Элементы добавлены за %d мс", end - start));
  }

  //проходим и сеттим новые значения в LinkedList через итератор
  public static void insertIntoLinkedListByIterator(List<Integer> linkedList) {
    long start = System.currentTimeMillis();
    ListIterator<Integer> iterator = linkedList.listIterator();
    while (iterator.hasNext()) {
      iterator.next();
      iterator.set(new Random().nextInt());
      //linkedList.add(4);//нельзя так, ConcurrentModificationException
    }
    long end = System.currentTimeMillis();
    System.out.println(String.format("Элементы добавлены за %d мс", end - start));
  }

}
