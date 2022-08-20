package com.gmail.rotoyutoriapp.either

object EitherFunctions {

  def contains[B1, B2](either: Either[B1, B2])(elem: B2): Boolean = {
    either match {
      case Right(value) if value == elem => true
      case _ => false
    }
  }

  def exists[B1, B2](either: Either[B1, B2])(existsFunction: B2 => Boolean): Boolean = {
    either match {
      case Right(value) => existsFunction(value)
      case _ => false
    }
  }

  def swap[B1, B2](either: Either[B1, B2]): Either[B2, B1] = {
    either match {
      case Left(value) => Right(value)
      case Right(value) => Left(value)
    }
  }

  def filterOrElse[A, B2](either: Either[A, B2])(
    filterOrElseFunction: B2 => Boolean, zero: A
  ): Either[A, B2] = {
    either match {
      case Right(value) if filterOrElseFunction(value) =>
        Right(value)
      case Left(value) =>
        Left(value)
      case _ => Left(zero)
    }
  }

}
