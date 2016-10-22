package com.willmadison.rules

import org.apache.commons.jxpath.JXPathContext
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class JXPathReader(var path: String? = null) : Reader {
    val logger: Logger = LoggerFactory.getLogger(javaClass)

    override fun read(o: Any?): Any? {
        return if (o != null && path != null) {
            val context = JXPathContext.newContext(o)

            try {
                val nodes = context.selectNodes(path)
                if (nodes.size > 0) nodes else null
            } catch(e: Exception) {
                logger.warn("encountered an exception attempting to select the following path: {}", path, e)
                null
            }
        } else {
            null
        }
    }
}