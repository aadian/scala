package com.coursera.w1

import math.abs

object Init{

  def sumInts(a: Int, b: Int): Int = {
    if (a > b) 0 else a + sumInts(a + 1, b)
  }

  sumInts(3, 2)
 
  def cube(x: Int): Int = {
    println(x * x * x)
    x * x * x
  }

  def sumCubes(a: Int, b: Int): Int = {
    if (a > b) 0 else cube(a) + sumCubes(a + 1, b)
  }

  sumCubes(1, 2)

  def sum(f: Int => Int)(a: Int, b: Int): Int = {
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc
      else loop(a + 1, f(a) + acc)
    }

    loop(a, 0)
  }
  
  sum(x=> x*x)(3,5)
  
  def test1(x:Int, y:Int):Int = x * x
  
  def test2(x: => Int, y: => Int):Int = x * x
  
  //call by value, call by name
  
  def bar(x : Int, y: => Int) : Int = 1
  
  def loop() : Int = loop
  
  bar( 1, loop)
  //bar(loop, 1) //死循环
  
  def factorial(n: Int) : Int =
  if( n <=0) 1
  else n * factorial(n-1)
  
  factorial(3)
  
  @annotation.tailrec
  def factorial(n : Int, m:Int): Int =
  if(n<=0)m
  else factorial(n-1, m*n)
  
  factorial(5,1)
  
  val tolerance = 0.0001
  def isCloseEnough(x:Double, y:Double) =
   abs((x-y)/x)/x < tolerance
   
  def fixedPoint(f:Double => Double)(firstGuess:Double)={
  	def iterate(guess:Double):Double={
  		val next = f(guess)
  		if(isCloseEnough(guess,next)) next
  		else iterate(next)
  		}
  		iterate(firstGuess)
  	}
  
  
  fixedPoint(x => 1 + x/2)(1)
}