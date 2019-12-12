import scala.collection.immutable.HashSet
import scala.collection.mutable

//z.1
def repeat[A](xs: List[A], lys: LazyList[Int]):LazyList[A] = {
  def helper(xss: List[A], lyss: LazyList[Int]): LazyList[A] = (xss, lyss) match {
    case (_, LazyList()) => LazyList()
    case (Nil, _) => LazyList()
    case (_ :: t1,LazyList.cons(0, t2)) => helper(t1, t2)
    case (h1 :: _, LazyList.cons(h2, t2)) => h1 #:: helper(xss, (h2 - 1)#::t2)

  }
  if(lys.length >= xs.size) helper(xs, lys)
  else {
    println("First set is too small")
    LazyList()
  }
}
repeat(List(1,2,3), LazyList(0,3,1,4)).toList


def repeat2[A](xs: mutable.LinkedHashSet[A], lys: List[Int]):LazyList[A] = {
  def helper(xss: mutable.LinkedHashSet[A], lyss: List[Int]): LazyList[A] = {
    if(xss.isEmpty || lyss == Nil) LazyList()
    else if(lyss.head == 0) {
      helper(xss.tail, lyss.tail)
    }else xss.head #:: helper(xss, (lyss.head - 1) :: lyss.tail)
  }
 if(lys.length >= xs.size) helper(xs, lys)
 else {
   println("First set is too small")
   LazyList()
 }
}
repeat2(mutable.LinkedHashSet(1,1,3,4,5,3), List(2,3,4,2,2,4,2)).toList

