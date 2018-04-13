// Copyright (C) 2011-2012 the original author or authors.
// See the LICENCE.txt file distributed with this work for additional
// information regarding copyright ownership.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

object main{
  def main(args: Array[String]): Unit ={
    val calc = new Calc
    val result1 = calc.sum(Seq(1,2,3))
    println("sum:result = " + result1.toString() )

    val result2 = calc.div(3,6)
    println("div:result = " + result2.toString())

    val result3 = calc.isPrime(5)
    println("isPrime:result = " + result3.toString())
  }
}

class Calc {

  /** 整数の配列を取得し、それらを出し合わせた整数を返す
    *
    * Int の最大を上回った際にはオーバーフローする
    */
  def sum(seq: Seq[Int]): Int = seq.foldLeft(0)(_ + _)

  /** 整数を2つ受け取り、分子を分母で割った浮動小数点の値を返す
    *
    * 0で割ろうとした際には実行時例外が投げられる
    */
  def div(numerator: Int, denominator: Int): Double = {
    if(denominator == 0) throw new ArithmeticException("/ by zero")
    numerator.toDouble / denominator.toDouble
  }

  /** 整数値を一つ受け取り、その値が素数であるかどうかのブール値を返す */
  def isPrime(n: Int): Boolean = {
    if(n < 2) false else !((2 to Math.sqrt(n).toInt) exists(n % _ == 0))
  }
}
