package com.willmadison.rules

import com.willmadison.rules.conditions.SimpleValueCondition

interface RuleElement {
    fun evaluate(o: Any): Boolean
}

fun buyNRule(buy: Number, sku: String): RuleElement {
    return SimpleValueCondition(JXPathReader("items[sku='$sku' and quantity > $buy]"), Condition.Operator.EXISTS)

}