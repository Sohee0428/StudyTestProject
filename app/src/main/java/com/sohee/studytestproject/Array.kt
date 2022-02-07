package com.sohee.studytestproject

class Array

    val list = listOf(5, 6, 9, 10, 1, 3, 2)

    val list1 = list.sorted()
    val list2 = list.sortedByDescending { it }

fun main() {
    println(list1)
    println(list2)
}

