package com.willmadison.rules.conditions

import com.willmadison.rules.Condition
import com.willmadison.rules.JXPathReader
import com.willmadison.store.exampleCart
import org.junit.Test

import org.junit.Assert.*

class SimpleValueConditionTest {
    @Test
    fun evaluateCondition_existence() {
        val condition = SimpleValueCondition(JXPathReader("items[sku='dummySku']"), Condition.Operator.EXISTS)
        assertTrue(condition.evaluateCondition(exampleCart()))
    }

}