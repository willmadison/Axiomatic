package com.willmadison.discounts

import com.willmadison.rules.RuleElement
import com.willmadison.store.Cart

class Discount(val rule: RuleElement? = null, var applicator: ((Cart) -> Cart)? = null) {

    fun isApplicable(cart: Cart): Boolean {
        if (rule == null) {
            return false
        }

        return rule.evaluate(cart)
    }
}