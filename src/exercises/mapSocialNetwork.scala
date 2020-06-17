package exercises

object mapSocialNetwork extends App {
  /*
  Social networking site
  - add - remove - friend - unfriend
  - no. of friends -person with most friends - person with no friends - mutual connection
   */

  //we could use List for list of friends, but Set will give us unique values
  def add(network: Map[String, Set[String]], sPerson: String): Map[String, Set[String]] = {
    network + (sPerson -> Set())
  }

  def remove(network: Map[String, Set[String]], sPerson: String): Map[String, Set[String]] = {
   def removeAux (friendList : Set[String], networkAcc : Map [String, Set[String]]) : Map[String, Set[String]] =
     if (friendList.isEmpty) networkAcc
    else removeAux(friendList.tail,unfriend(networkAcc, friendList.head, sPerson))

    val removedFromFriendlist = removeAux(network(sPerson),network)
    removedFromFriendlist - sPerson
  }


  def friend(network: Map[String, Set[String]], personA: String, personB: String): Map[String, Set[String]] = {
    val friendA = network(personA)
    val friendB = network(personB)

    network + (personA -> (friendA + personB)) + (personB -> (friendB + personA))
  }

  def unfriend(network: Map[String, Set[String]], personA: String, personB: String): Map[String, Set[String]] = {
    val friendA = network(personA)
    val friendB = network(personB)

    network + (personA -> (friendA - personB)) + (personB -> (friendB - personA))
  }

  val emptyNetwork : Map[String,Set[String]] = Map()
  val network = add(add(emptyNetwork,"Bob"), "Mary") //add(emptyNetwork, "Mary")
  println(network)

  println(friend(network, "Mary" , "Bob"))

  //println(unfriend(network,"Mary" , "Bob"))

  println(remove(network,"Bob"))


  val newNetwork = add(add(add(emptyNetwork,"Mary"),"Jim"),"Bob")
  val jimBob = friend(newNetwork,"Jim", "Bob")
  val testNet = friend(jimBob,"Bob" , "Mary")
  println(testNet)

  def nFriends (network : Map[String, Set[String]], sPerson: String) : Int =
    if (!network.contains(sPerson)) 0
    else network(sPerson).size

  println(nFriends(testNet,"Bob"))

  def mostFriends(network : Map[String, Set[String]]) : String =
    network.maxBy(pair => pair._2.size)._1

  println(mostFriends(testNet))

  def nPeopleWithNoFriends(network : Map[String, Set[String]]) : Int =
    network.filterKeys(person => network(person).isEmpty).size //or use count function, pair => pair._2..IsEmpty

  println(nPeopleWithNoFriends(testNet))

  //a has friends c,d
  //b has friends f,d
  //finding connection between a and b
  //b = target
  //discoveredPeople = friendsOfa + a
  def socialConnection (network : Map [String, Set[String]],a :String, b: String) = {
    def bfsAux(target : String, consideredPeople : Set[String], discoveredPeople : Set[String]) : Boolean ={
      if (discoveredPeople.isEmpty) false
      else {
        val person = discoveredPeople.head
        if (person == target) true
        else if (consideredPeople.contains(person)) bfsAux(target,consideredPeople,discoveredPeople.tail)
        else bfsAux(target,consideredPeople + person, discoveredPeople.tail ++ network(person))
      }
    }
    bfsAux(b,Set(),network(a) + a)
  }
  println(socialConnection(testNet,"Mary","Jim"))
}