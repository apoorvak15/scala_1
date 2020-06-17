package exercises

object OOBasicsExc extends App {
  val author = new writer("Apoorva","Kulkarni" , 1991)
  println("Author full name: " + author.getFullName)

  val anotherAuthor = new writer("Abhiraj","Patankar",1990)

  val novel = new novel("My novel" , 2019, author)
  /*
  println("Author age: " + novel.getAuthorAge())
  println("Author name is same or not" + novel.getAuthorName(author))
  println("Another author name same or not: " + novel.getAuthorName(anotherAuthor))
   */


  val counter = new Counter
  counter.inc.print
  counter.dec.print
  counter.inc.inc.inc.print
  counter.dec.dec.dec.dec.dec.print

  counter.inc(2).print
  counter.dec(3).print



}

class writer (fName: String, lName: String, val birthYear : Int){
  def getFullName : String = s"$fName $lName"
}

class novel(name : String, YOrelease : Int, author: writer){
  def getAuthorAge() : Int = YOrelease - author.birthYear
  def getAuthorName(author : writer) = author == this.author
  def newCopy(yearOfCopy : Int) : novel = new novel(name,yearOfCopy, author)
}

class Counter(count : Int = 0){
 def currentCount = count // this is same as declaring count as val in argument section

  def inc() = new Counter(count + 1) // immutability, very imp
  def dec () = {
    println("decrementing") //** This will not be printed if we dec by n , hence ses dec function for n
    new Counter(count - 1)
  }

  def inc(n : Int) = new Counter(count + n)
  def dec(n : Int) = {
    if (n <= 0) this
    else inc.inc(n-1)

  }
  def print = println(count)

  //when we want to log , when a val is incremented or decremented, refer to ** statements for dec method
}