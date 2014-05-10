package org.marketcetera.photon.views;

import org.marketcetera.photon.commons.databinding.ITypedObservableValue;
import org.marketcetera.photon.ui.databinding.EquityObservable;
import org.marketcetera.trade.Instrument;
import org.marketcetera.util.misc.ClassVersion;

/**
 * The model of a stock order ticket.
 * 
 * @author gmiller
 * @author <a href="mailto:colin@marketcetera.com">Colin DuPlantis</a>
 * @author <a href="mailto:will@marketcetera.com">Will Horn</a>
 * @version $Id: StockOrderTicketModel.java 16154 2012-07-14 16:34:05Z colin $
 * @since 0.6.0
 */
@ClassVersion("$Id: StockOrderTicketModel.java 16154 2012-07-14 16:34:05Z colin $")
public class StockOrderTicketModel extends OrderTicketModel {

    private final ITypedObservableValue<String> mSymbol;
    
    /**
     * Constructor.
     */
    public StockOrderTicketModel() {
        ITypedObservableValue<Instrument> instrument = getOrderObservable().observeInstrument();
        mSymbol = new EquityObservable(instrument).observeSymbol();
    }
    
    @Override
    public ITypedObservableValue<String> getSymbol() {
        return mSymbol;
    }
}
