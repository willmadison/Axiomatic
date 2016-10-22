package com.willmadison.rules.conditions

import com.willmadison.rules.Condition
import com.willmadison.rules.Reader

class SimpleValueCondition(var reader: Reader, val operator: Operator = Operator.EQUALS) : Condition() {
    var value: Any? = null

    override fun evaluateCondition(o: Any): Boolean {
        when (operator) {
            Operator.EQUALS -> TODO()
            Operator.EXISTS -> {
                return reader.read(o) != null
            }
            Operator.LESS_THAN -> TODO()
            Operator.GREATER_THAN -> TODO()
            Operator.LESS_THAN_EQ -> TODO()
            Operator.GREATER_THAN_EQ -> TODO()
            Operator.IN -> TODO()
            Operator.CONTAINS -> TODO()
        }
    }


}