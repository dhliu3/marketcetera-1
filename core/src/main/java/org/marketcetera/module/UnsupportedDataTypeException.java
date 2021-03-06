package org.marketcetera.module;

import org.marketcetera.util.log.I18NBoundMessage;
import org.marketcetera.util.misc.ClassVersion;

/* $License$ */
/**
 * Thrown when a module receives data that it
 * doesn't know how to handle.
 *
 * @author anshul@marketcetera.com
 * @version $Id: UnsupportedDataTypeException.java 16154 2012-07-14 16:34:05Z colin $
 * @since 1.0.0
 */
@ClassVersion("$Id: UnsupportedDataTypeException.java 16154 2012-07-14 16:34:05Z colin $")  //$NON-NLS-1$
public class UnsupportedDataTypeException extends ReceiveDataException {
    private static final long serialVersionUID = -1731701511521781335L;

    /**
     * Creates an instance.
     *
     * @param inMessage the error message.
     */
    public UnsupportedDataTypeException(I18NBoundMessage inMessage) {
        super(inMessage);
    }
}
