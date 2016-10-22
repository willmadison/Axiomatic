package com.willmadison.rules.conditions

import com.willmadison.rules.Condition
import com.willmadison.rules.Reader
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class SimpleValueCondition(var reader: Reader, val operator: Operator = Operator.EQUALS) : Condition() {
    private val logger: Logger = LoggerFactory.getLogger(javaClass)

    var value: Any? = null

    override fun evaluateCondition(o: Any): Boolean {
        when (operator) {
            Operator.EQUALS -> {
                return if (value != null && reader.read(o) != null) {
                    reader.read(o) == value
                } else {
                    false
                }
            }
            Operator.EXISTS -> {
                return reader.read(o) != null
            }
            Operator.LESS_THAN -> TODO()
            Operator.GREATER_THAN -> {
                return if (value != null && reader.read(o) != null) {
                    compare(reader.read(o)!!, value as Any, operator)
                } else {
                    false
                }
            }
            Operator.IN -> TODO()
            Operator.CONTAINS -> TODO()
        }
    }

    private fun compare(left: Any, right: Any, operator: Operator): Boolean {
        return if (left is Comparable<*> && right is Comparable<*>) {
            when {
                left is String && right is String -> {
                    val comparison = left.compareTo(right)

                    when (operator) {
                        Condition.Operator.LESS_THAN -> comparison < 0
                        Condition.Operator.GREATER_THAN -> comparison > 0
                        else -> false
                    }
                }
                left is Float && right is Float -> {
                    val comparison = left.compareTo(right)

                    when (operator) {
                        Condition.Operator.LESS_THAN -> comparison < 0
                        Condition.Operator.GREATER_THAN -> comparison > 0
                        else -> false
                    }
                }
                left is Double && right is Double -> {
                    val comparison = left.compareTo(right)

                    when (operator) {
                        Condition.Operator.LESS_THAN -> comparison < 0
                        Condition.Operator.GREATER_THAN -> comparison > 0
                        else -> false
                    }
                }
                left is Int && right is Int -> {
                    val comparison = left.compareTo(right)

                    when (operator) {
                        Condition.Operator.LESS_THAN -> comparison < 0
                        Condition.Operator.GREATER_THAN -> comparison > 0
                        else -> false
                    }
                }
                else -> {
                    logger.info("couldn't successfully compare the given value...")
                    logger.info("Left Class: {}, Right Class: {}", left.javaClass, right.javaClass)
                    false
                }
            }
        } else false
    }


}