package com.coursera.w2

import math.abs

object Init2 {

  def sumInts(a: Int, b: Int): Int = {
    if (a > b) 0 else a + sumInts(a + 1, b)
  }                                               //> sumInts: (a: Int, b: Int)Int

  sumInts(3, 2)                                   //> res0: Int = 0

  def cube(x: Int): Int = {
    println(x * x * x)
    x * x * x
  }                                               //> cube: (x: Int)Int

  def sumCubes(a: Int, b: Int): Int = {
    if (a > b) 0 else cube(a) + sumCubes(a + 1, b)
  }                                               //> sumCubes: (a: Int, b: Int)Int

  sumCubes(1, 2)                                  //> 1
                                                  //| 8
                                                  //| res1: Int = 9

  def sum(f: Int => Int)(a: Int, b: Int): Int = {
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc
      else loop(a + 1, f(a) + acc)
    }

    loop(a, 0)
  }                                               //> sum: (f: Int => Int)(a: Int, b: Int)Int

  sum(x => x * x)(3, 5)                           //> res2: Int = 50

  def test1(x: Int, y: Int): Int = x * x          //> test1: (x: Int, y: Int)Int

  def test2(x: => Int, y: => Int): Int = x * x    //> test2: (x: => Int, y: => Int)Int

  //call by value, call by name

  def bar(x: Int, y: => Int): Int = 1             //> bar: (x: Int, y: => Int)Int

  def loop(): Int = loop                          //> loop: ()Int

  bar(1, loop)                                    //> res3: Int = 1
  //bar(loop, 1) //死循环

  val tolerance = 0.0001                          //> tolerance  : Double = 1.0E-4
  def isCloseEnough(x: Double, y: Double) =
    abs((x - y) / x) / x < tolerance              //> isCloseEnough: (x: Double, y: Double)Boolean

  def fixedPoint(f: Double => Double)(firstGuess: Double) = {
    def iterate(guess: Double): Double = {
      val next = f(guess)
      if (isCloseEnough(guess, next)) next
      else iterate(next)
    }
    iterate(firstGuess)
  }                                               //> fixedPoint: (f: Double => Double)(firstGuess: Double)Double

  fixedPoint(x => 1 + x / 2)(1)                   //> res4: Double = 1.999755859375
}