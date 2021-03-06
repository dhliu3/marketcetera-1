package org.marketcetera.symbol;

import org.marketcetera.trade.Instrument;
import org.marketcetera.util.misc.ClassVersion;

/* $License$ */

/**
 * Provides symbol resolution services.
 *
 * @author <a href="mailto:colin@marketcetera.com">Colin DuPlantis</a>
 * @version $Id: SymbolResolverService.java 16901 2014-05-11 16:14:11Z colin $
 * @since 2.4.0
 */
@ClassVersion("$Id: SymbolResolverService.java 16901 2014-05-11 16:14:11Z colin $")
public interface SymbolResolverService
{
    /**
     * Resolves the given symbol to an <code>Instrument</code>.
     *
     * @param inSymbol a <code>String</code> value
     * @return an <code>Instrument</code> or <code>null</code> if the symbol could not be resolved
     */
    public Instrument resolveSymbol(String inSymbol);
}
