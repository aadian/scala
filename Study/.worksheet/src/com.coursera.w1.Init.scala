package com.coursera.w1

object Init{;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(127); 

  def sumInts(a: Int, b: Int): Int = {
    if (a > b) 0 else a + sumInts(a + 1, b)
  };System.out.println("""sumInts: (a: Int, b: Int)Int""");$skip(18); val res$0 = 

  sumInts(3, 2);System.out.println("""res0: Int = """ + $show(res$0));$skip(72); 
 
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
  };System.out.println("""sum: (f: Int => Int)(a: Int, b: Int)Int""");$skip(24); val res$2 = 
  
  sum(x=> x*x)(3,5);System.out.println("""res2: Int = """ + $show(res$2));$skip(41); 
  
  def test1(x:Int, y:Int):Int = x * x;System.out.println("""test1: (x: Int, y: Int)Int""");$skip(49); 
  
  def test2(x: => Int, y: => Int):Int = x * x;System.out.println("""test2: (x: => Int, y: => Int)Int""");$skip(78); 
  
  //call by value, call by name
  
  def bar(x : Int, y: => Int) : Int = 1;System.out.println("""bar: (x: Int, y: => Int)Int""");$skip(29); 
  
  def loop() : Int = loop;System.out.println("""loop: ()Int""");$skip(19); val res$3 = 
  
  bar( 1, loop);System.out.println("""res3: Int = """ + $show(res$3));$skip(99); 
  //bar(loop, 1) //死循环
  
  def factorial(n: Int) : Int =
  if( n <=0) 1
  else n * factorial(n-1);System.out.println("""factorial: (n: Int)Int""");$skip(18); val res$4 = 
  
  factorial(3)
  
  @annotation.tailrec;System.out.println("""res4: Int = """ + $show(res$4));$skip(103); 
  def factorial(n : Int, m:Int): Int =
  if(n<=0)m
  else factorial(n-1, m*n);System.out.println("""factorial: (n: Int, m: Int)Int""");$skip(20); val res$5 = 
  
  factorial(5,1);System.out.println("""res5: Int = """ + $show(res$5))}
  
  
}
