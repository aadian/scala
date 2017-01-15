package com.coursera.w1

object execise1 {

  def main(args: Array[String]) = {
    //println(pascal(2,4))

    println(balance("I told him (that it’s not (yet) done). (But he wasn’t listening)"))
    
    println(countChange(4,List.apply(1,2)))
  }

  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || c == r) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  def balance(chars: String): Boolean = {
    def isMatch(chars: String, count: Int): Boolean = {
      if (count < 0) false
      else if (chars.isEmpty) count == 0
      else if (chars.head == '(') {
        isMatch(chars.tail, count + 1)
      } else if (chars.head == ')') {
        isMatch(chars.tail, count - 1)
      } else {
        isMatch(chars.tail, count)
      }
    }

    isMatch(chars, 0)
  }

  def countChange(money: Int, coins: List[Int]): Int = {

    if (money == 0) 1
    else if (coins.isEmpty) 0
    else if (money < 0) 0
    else
      countChange(money, coins.tail) + countChange(money - coins.head, coins)

  }

}