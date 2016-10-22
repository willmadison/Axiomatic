package com.willmadison.rules

abstract class Condition : RuleElement {
    protected var affirmative: RuleElement? = null
    protected var negative: RuleElement? = null

    abstract fun evaluateCondition(o: Any): Boolean

    override fun evaluate(o: Any): Boolean {
         if (evaluateCondition(o)) {
            return if (affirmative != null) affirmative!!.evaluate(o) else true
         } else {
            return if (negative != null) negative!!.evaluate(o) else false
         }
    }

    enum class Operator(val symbol: String) {
        EQUALS("=="),
        EXISTS("exists"),
        LESS_THAN("<"),
        GREATER_THAN(">"),
        IN("in"),
        CONTAINS("contains");

        override fun toString(): String {
            return symbol
        }
    }

}