package com.bofowo.escape.reference;

import org.apache.commons.lang.StringEscapeUtils;

/**
 * Escape all HTML entities.
 */
public class NoEscapeHtmlReference extends NoEscapeReference {

    /**
     * Escape all HTML entities.
     *
     * @param text
     * @return An escaped String.
     */
    @Override
    protected String escape(Object text) {
        return StringEscapeUtils.escapeHtml(text.toString());
    }

    /**
     * @return attribute "eventhandler.noescape.html.match"
     */
    @Override
    protected String getMatchAttribute() {
        return "eventhandler.noescape.html.match";
    }

}
