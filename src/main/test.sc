import org.omg.CORBA.Current

import scala.annotation.tailrec

//pascal tree
def pascalTree(row:Int,col:Int):Int={
    if(col>row)
        0
    else
    factorial(row) / ( factorial(row-col) * factorial(col) )
}

pascalTree(6,5)


//calculate change



//@tailRec ???
def recursiveChange(change:Int, coins:List[Int]): Int ={
  if(change ==0 ){//lo logre
    1
  } else if (change < 0){//me pase
    0
  }else{// me falta
    var s = 0
    var result = 0
    while(s<coins.length){
      result+= recursiveChange(change- coins.slice(s,coins.length)(0), coins.slice(s,coins.length))
      s+=1
    }
  result
  }
}


recursiveChange(7,List(1,2,3,5))


def abs(a:Int):Int={
  if(a<0)
    a* -1
  else
    a
}

abs(-3)

//factorial
def factorial(n:Int):Int = {
  if (n == 0)
    1
  else {
    n * factorial(n - 1)
  }
}

//Suma de Factoriales
def sumFactorial(a:Int,b:Int):Int={
  if(a>b)
    0
  else
    factorial(a) + sumFactorial(a+1,b)
}

//return cube
def cubes(a:Int):Int=a*a*a

//suma de cubos
def sumCubes(a:Int,b:Int):Int={
  if(a>b)
    0
  else
    cubes(a)+sumCubes(a+1,b)
}

sumFactorial(2,5)
sumCubes(2,5)


def sum(f:Int =>Int,a:Int,b:Int):Int={
  if(a>b)
    0
  else
    f(a)+sum(f,a+1,b)
}
//anonymous function (a:Int =>a)
sum (a=>a,2,3)


def prod(f:Int =>Int, a:Int, b:Int):Int={
  if(a>b)
    1
  else
    f(a)*prod(f,a+1,b)
}

def prodAnon(a:Int) = prod(a=>a,1,a)

prodAnon(3)


def neutro(c:(Int,Int)=>Int,a:Int,b:Int,f:Int=>Int,neutral:Int):Int={
  if(a>b)
    neutral
  else
   c(f,neutro(c,a+1,b,f,neutral))
}

def sumoGeneral(f:Int => Int)(a:Int,b:Int):Int = {
  if(a>b)0
  else
    f(a)+sumoGeneral(f)(a+1,b)
}

sumoGeneral(x=>x)(1,2)
sumoGeneral(x=>x*x*x)(1,2)

def prodGeneral( f: Int => Int)( a:Int, b:Int): Int =
  if ( a > b ) 1 else f(a) * prodGeneral(f)(a+1, b)


def f(n:Int):Int ={
    if (n == 0){
      return
    }
    else{
        println("Hello World\n")
        f(n-1)
    }
}
f(5)

//returns odd numbers
def f(n:List[Int],cont:Int):List[Int] = {
  if(n.isEmpty)
    List()
  else {
    if (cont % 2==0) {
      f(n.tail,cont+1)
    } else
      n.head::f(n.tail,cont+1)

  }
}

f(List(1,2,3,4,5,6),0)


def swap(s:String,n:Int):String = {
  if(n<=s.length()){
    if(n%2 ==0){
      //dont swap
      swap(s,n+1)
    }
    else {
      //swap
      swap(s.head.toString().concat(s.tail.tail.concat(s.tail.tail)), n + 1)
    }
  }
  return s
}

swap("works",0)

def f(num:Int,arr:List[Int]):List[Int] = {
 return arr.flatMap(e => List.fill(num)(e))
}

f(2,List(1,2,3,4))



def f(delim:Int,arr:List[Int]):List[Int] = {
  return arr.filter(a => a<=delim)
}

f(3,List(1,2,3,4))


def f(arr:List[Int]):List[Int] = {
  return arr.zipWithIndex.filter(a =>a._2%2==0).map(a => a._1)
}

f(List(1,2,3,4,5,6,7))



def f(num:Int) : List[Int] = {
  return List.fill(num)(num)
}

f(2)



def f(arr:List[Int]):Int ={
  arr.filter(a=>a%2!=0).sum
}



def f(arr:List[Int]):Int ={
  arr.map(a=>1).sum
}

f(List(1,2,3,4,5))




def f(arr:List[Int]):List[Int] = {
  return arr.map(a => if(a<0) a*(-1)else a)
}


f(List(-1,2,3,-5,7,-10))


def factorial(n:Int):Int = {
  if (n==0)
    1
  else
    n*factorial(n-1)
}
def series(term:Int,expansion:Int,accum:Float):Float={
  if(expansion==0)
    accum
  else
    accum+series(term,expansion-1,(math.pow(term,expansion)/factorial(expansion)).toFloat)
}
def f(num:Int,arr:List[Int]):List[Float]={
  return arr.map(a=>series(num,a,1))
}


def f(target:Int, current:Int, accum:Int):Int = {
  if(target==current)
    accum+1
  else
    return accum + (target, current+1 , accum )
}



trait List[A]{
    def isEmpty:Boolean
    def head:A
    def tail:List[A]
    def getNth(n:Int):A =
}

class Nil[T] extends List[T]{
    def isEmpty = true
    def head = throw new NoSuchElementException("Nil.head")
    def tail = throw new NoSuchElementException("Nil.head")
}

class Cons[T](val head:T,val tail:List[T]) extends List[T]{
    def isEmpty = false
}