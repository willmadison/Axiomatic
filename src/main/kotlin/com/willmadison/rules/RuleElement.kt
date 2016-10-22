package com.willmadison.rules

interface RuleElement {
    fun evaluate(o: Any): Boolean
}