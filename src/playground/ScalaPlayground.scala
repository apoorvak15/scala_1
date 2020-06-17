package playground

import scala.annotation.tailrec

object ScalaPlayground extends App {
  def sum (lb: Int, ub: Int) : Int = {
    @tailrec
    def helper(num : Int, acc: Int) : Int = {
      if (num > ub) acc
      else {
        if (num % 2 != 0) helper(num+1,acc)
        else helper(num+1,acc + num*num)
      }
    }
    helper(lb,0)
  }

  //print(sum(1,100))


  val aList = (1 to 5).toList
  println(aList.filter(x => x % 2 == 0).map(x => x * x).sum)

}
