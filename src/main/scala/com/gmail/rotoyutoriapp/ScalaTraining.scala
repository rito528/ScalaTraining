package com.gmail.rotoyutoriapp

import com.gmail.rotoyutoriapp.either.EitherFunctions

object ScalaTraining {

  def main(array: Array[String]): Unit = {
    println(EitherFunctions.filterOrElse(Right(12))(_ > 10, -1))
    println(EitherFunctions.filterOrElse(Right(7))(_ > 10, -1))
    println(EitherFunctions.filterOrElse(Left(7))(_ => false, -1))
  }

}
