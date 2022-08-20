package com.gmail.rotoyutoriapp.list

import scala.annotation.tailrec

object ListFunctions {

  @tailrec
  def foreach[U](list: List[U])(foreachFunction: U => Unit): Unit = {
    list match {
      case ::(head, next) =>
        foreachFunction(head)
        foreach(next)(foreachFunction)
      case Nil =>
    }
  }

  def map[U, A](list: List[U])(mapFunction: U => A): List[A] = {
    list match {
      case ::(head, next) =>
        val headValue = mapFunction(head)
        val mappedList = map(next)(mapFunction)
        headValue +: mappedList
      case Nil => Nil
    }
  }

  def flatMap[U, A](list: List[U])(flatMapFunction: U => List[A]): List[A] = {
    list match {
      case ::(head, next) =>
        val flatMappedValue = flatMap(next)(flatMapFunction)
        flatMapFunction(head) ++ flatMappedValue
      case Nil => Nil
    }
  }

  @tailrec
  def find[A](list: List[A])(findFunction: A => Boolean): Option[A] = {
    list match {
      case ::(head, next) =>
        if (findFunction(head)) Some(head)
        else find(next)(findFunction)
      case Nil => None
    }
  }

  def filter[A](list: List[A])(filterFunction: A => Boolean): List[A] = {
    list match {
      case ::(head, next) =>
        val filteredNextList = filter(next)(filterFunction)
        if (filterFunction(head)) head +: filteredNextList
        else filteredNextList
      case Nil => Nil
    }
  }

}
