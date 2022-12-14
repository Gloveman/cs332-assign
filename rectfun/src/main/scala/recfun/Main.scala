package recfun
import common._

object Main {
  def main(args: Array[String]) {
    /*
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
     */
    println(countChange(301,List(5,10,20,50,100,200,500)) == 0)

  }


  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if(r==0||c==0)
      1
    else if(r==c)
      1
    else
      pascal(c,r-1)+pascal(c-1,r-1)



  }


  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    val end= chars.indexOf(')')
    if (end == -1)
      !chars.contains('(')
    else {
      val start = chars.slice(0,end).lastIndexOf('(')
      if (start == -1) {
        false
      }
      else
      balance(chars.slice(0,start):::chars.slice(end+1,chars.length))
    }
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    /*
    coins.foreach{
      x=>
      if(money-x>0)
        countChange(money-x,coins)
      else if (money-x==0)
    }*/
    if (money<0)
      0
    else if (money == 0)
      1
    else {
      var sum = 0
      for(coin<-coins)
        sum+=countChange(money-coin,coins)
      sum
    }
  }
}
