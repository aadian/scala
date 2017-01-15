

object  HelloWorld {
  /* 这是一个 Scala 程序
    * 这是一行注释
    * 这里演示了多行注释
    */
  def main(args: Array[String]) {
    // 输出 Hello World
    // 这是一个单行注释
    //println("Hello, world!")

    val greetStrings: Array[String] = new Array[String](3)
    greetStrings(0) = "Hello"
    greetStrings(1) = ", "
    greetStrings(2) = "world!\n"
    
    
    for (i <- 0 to 2)
      print(greetStrings(i))
      
    }
}