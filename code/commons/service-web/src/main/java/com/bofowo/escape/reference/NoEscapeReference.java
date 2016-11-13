package com.bofowo.escape.reference;

import org.apache.oro.text.perl.MalformedPerl5PatternException;
import org.apache.oro.text.perl.Perl5Util;
import org.apache.velocity.app.event.ReferenceInsertionEventHandler;
import org.apache.velocity.runtime.RuntimeServices;
import org.apache.velocity.util.RuntimeServicesAware;
import org.apache.velocity.util.StringUtils;

public abstract class NoEscapeReference implements ReferenceInsertionEventHandler, RuntimeServicesAware {

    private Perl5Util perl = new Perl5Util();

    private RuntimeServices rs;

    private String matchRegExp = null;

    /**
     * Escape the given text.  Override this in a subclass to do the actual
     * escaping.
     *
     * @param text the text to escape
     * @return the escaped text
     */
    protected abstract String escape(Object text);

    /**
     * Specify the configuration attribute that specifies the
     * regular expression.  Ideally should be in a form
     * <pre><code>eventhandler.escape.XYZ.match</code></pre>
     *
     * <p>where <code>XYZ</code> is the type of escaping being done.
     * @return configuration attribute
     */
    protected abstract String getMatchAttribute();

    /**
     * Escape the provided text if it matches the configured regular expression.
     *
     * @param reference
     * @param value
     * @return Escaped text.
     */
    @Override
    public Object referenceInsert(String reference, Object value) {
        if (value == null) {
            return value;
        }

        if (matchRegExp == null) {
            return escape(value);
        }

        else if (!perl.match(matchRegExp, reference)) {
            return escape(value);
        }

        else {
            return value;
        }
    }

    /**
     * Called automatically when event cartridge is initialized.
     *
     * @param rs instance of RuntimeServices
     */
    @Override
    public void setRuntimeServices(RuntimeServices rs) {
        this.rs = rs;

        /**
         * Get the regular expression pattern.
         */
        matchRegExp = StringUtils.nullTrim(rs.getConfiguration().getString(getMatchAttribute()));
        if ((matchRegExp != null) && (matchRegExp.length() == 0)) {
            matchRegExp = null;
        }

        /**
         * Test the regular expression for a well formed pattern
         */
        if (matchRegExp != null) {
            try {
                perl.match(matchRegExp, "");
            } catch (MalformedPerl5PatternException E) {
                rs.getLog().error("Invalid regular expression '" + matchRegExp + "'.  No escaping will be performed.",
                        E);
                matchRegExp = null;
            }
        }

    }

    /**
     * Retrieve a reference to RuntimeServices.  Use this for checking additional
     * configuration properties.
     *
     * @return The current runtime services object.
     */
    protected RuntimeServices getRuntimeServices() {
        return rs;
    }

}
