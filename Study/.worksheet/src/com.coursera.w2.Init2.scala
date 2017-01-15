package com.coursera.w2

import math.abs

object Init2 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(147); 

  def sumInts(a: Int, b: Int): Int = {
    if (a > b) 0 else a + sumInts(a + 1, b)
  };System.out.println("""sumInts: (a: Int, b: Int)Int""");$skip(18); val res$0 = 

  sumInts(3, 2);System.out.println("""res0: Int = """ + $show(res$0));$skip(71); 

  def cube(x: Int): Int = {
    println(x * x * x)
    x * x * x
  };System.out.println("""cube: (x: Int)Int""");$skip(97); 

  def sumCubes(a: Int, b: Int): Int = {
    if (a > b) 0 else cube(a) + sumCubes(a + 1, b)
  };System.out.println("""sumCubes: (a: Int, b: Int)Int""");$skip(19); val res$1 = 

  sumCubes(1, 2);System.out.println("""res1: Int = """ + $show(res$1));$skip(175); 

  def sum(f: Int => Int)(a: Int, b: Int): Int = {
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc
      else loop(a + 1, f(a) + acc)
    }

    loop(a, 0)
  };System.out.println("""sum: (f: Int => Int)(a: Int, b: Int)Int""");$skip(26); val res$2 = 

  sum(x => x * x)(3, 5);System.out.println("""res2: Int = """ + $show(res$2));$skip(43); 

  def test1(x: Int, y: Int): Int = x * x;System.out.println("""test1: (x: Int, y: Int)Int""");$skip(49); 

  def test2(x: => Int, y: => Int): Int = x * x;System.out.println("""test2: (x: => Int, y: => Int)Int""");$skip(74); 

  //call by value, call by name

  def bar(x: Int, y: => Int): Int = 1;System.out.println("""bar: (x: Int, y: => Int)Int""");$skip(27); 

  def loop(): Int = loop;System.out.println("""loop: ()Int""");$skip(17); val res$3 = 

  bar(1, loop);System.out.println("""res3: Int = """ + $show(res$3));$skip(50); 
  //bar(loop, 1) //死循环

  val tolerance = 0.0001;System.out.println("""tolerance  : Double = """ + $show(tolerance ));$skip(81); 
  def isCloseEnough(x: Double, y: Double) =
    abs((x - y) / x) / x < tolerance;System.out.println("""isCloseEnough: (x: Double, y: Double)Boolean""");$skip(267); 

  def fixedPoint(f: Double => Double)(firstGuess: Double) = {
    def iterate(guess: Double): Double = {
    println("guess = " + guess)
      val next = f(guess)
      if (isCloseEnough(guess, next)) next
      else iterate(next)
    }
    iterate(firstGuess)
  };System.out.println("""fixedPoint: (f: Double => Double)(firstGuess: Double)Double""");$skip(34); val res$4 = 

  fixedPoint(x => 1 + x / 2)(1);System.out.println("""res4: Double = """ + $show(res$4));$skip(50); 
  
  def sqrt(x:Double) = fixedPoint(y => x/y)(1);System.out.println("""sqrt: (x: Double)Double""");$skip(10); val res$5 = 
  sqrt(2);System.out.println("""res5: Double = """ + $show(res$5))}
}
