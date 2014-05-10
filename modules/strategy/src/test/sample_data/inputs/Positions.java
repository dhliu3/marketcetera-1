import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

import org.marketcetera.core.position.PositionKey;
import org.marketcetera.strategy.java.Strategy;
import org.marketcetera.trade.Equity;
import org.marketcetera.trade.Option;
import org.marketcetera.trade.Currency;
import org.marketcetera.trade.OptionType;

/* $License$ */

/**
 * Tests the position-related API of the Strategy API.
 *
 * @author <a href="mailto:colin@marketcetera.com">Colin DuPlantis</a>
 * @version $Id: Positions.java 16460 2013-01-21 21:55:10Z colin $
 * @since 2.0.0
 */
public class Positions
        extends Strategy
{
    /* (non-Javadoc)
     * @see org.marketcetera.strategy.java.Strategy#onStart()
     */
    @Override
    public void onStart()
    {
        doGetPositionAsOf(true);
        doGetAllPositionsAsOf(true);
        doGetOptionPositionAsOf(true);
        doGetAllOptionPositionsAsOf(true);
        doGetCurrencyPositionAsOf(true);    
        doGetAllCurrencyPositionsAsOf(true);
        doGetOptionPositionsAsOf(true);
        doGetUnderlying(true);
        doGetOptionRoots(true);
    }
    /* (non-Javadoc)
     * @see org.marketcetera.strategy.java.Strategy#onStop()
     */
    @Override
    public void onStop()
    {
        doGetPositionAsOf(false);
        doGetAllPositionsAsOf(false);
        doGetOptionPositionAsOf(false);
        doGetAllOptionPositionsAsOf(false);
        doGetCurrencyPositionAsOf(false);        
        doGetAllCurrencyPositionsAsOf(false);
        doGetOptionPositionsAsOf(false);
        doGetUnderlying(false);
        doGetOptionRoots(false);
    }
    /**
     * Executes {@link #getPositionAsOf(java.util.Date, String)}.
     */
    private void doGetPositionAsOf(boolean duringStart)
    {
        String symbol = getProperty("symbol");
        String dateString = getProperty("date");
        Date date;
        if(dateString == null) {
            date = null;
        } else {
            date = new Date(Long.parseLong(dateString));
        }
        BigDecimal result = getPositionAsOf(date,
                                            symbol);
        String resultString;
        if(result == null) {
            resultString = null;
        } else {
            resultString = result.toString();
        }
        if(duringStart) {
            setProperty("positionAsOf",
                        resultString);
        } else {
            setProperty("positionAsOfDuringStop",
                        resultString);
        }
    }
    /**
     * Executes {@link #getCurrencyPositionAsOf(java.util.Date, String)}.
     */
    private void doGetCurrencyPositionAsOf(boolean duringStart)
    {
        String symbol = getProperty("symbol");
        String dateString = getProperty("date");
        Date date;
        if(dateString == null) {
            date = null;
        } else {
            date = new Date(Long.parseLong(dateString));
        }
        BigDecimal result = getCurrencyPositionAsOf(date,
                                            symbol);
        String resultString;
        if(result == null) {
            resultString = null;
        } else {
            resultString = result.toString();
        }
        if(duringStart) {
            setProperty("currencyPositionAsOf",
                        resultString);
        } else {
            setProperty("currencyPositionAsOfDuringStop",
                        resultString);
        }
    }
    
    /**
     * Executes {@link #getAllPositionsAsOf(java.util.Date)}.
     */
    private void doGetAllPositionsAsOf(boolean duringStart)
    {
        String dateString = getProperty("date");
        Date date;
        if(dateString == null) {
            date = null;
        } else {
            date = new Date(Long.parseLong(dateString));
        }
        Map<PositionKey<Equity>,BigDecimal> result = getAllPositionsAsOf(date);
        String resultString;
        if(result == null) {
            resultString = null;
        } else {
            resultString = result.toString();
        }
        if(duringStart) {
            setProperty("allPositionsAsOf",
                        resultString);
        } else {
            setProperty("allPositionsAsOfDuringStop",
                        resultString);
        }
    }
    /**
     * Executes {@link #getAllCurrencyPositionsAsOf(java.util.Date)}.
     */
    private void doGetAllCurrencyPositionsAsOf(boolean duringStart)
    {
        String dateString = getProperty("date");
        Date date;
        if(dateString == null) {
            date = null;
        } else {
            date = new Date(Long.parseLong(dateString));
        }
        Map<PositionKey<Currency>,BigDecimal> result = getAllCurrencyPositionsAsOf(date);
        String resultString;
        if(result == null) {
            resultString = null;
        } else {
            resultString = result.toString();
        }
        if(duringStart) {
            setProperty("allCurrencyPositionsAsOf",
                        resultString);
        } else {
            setProperty("allCurrencyPositionsAsOfDuringStop",
                        resultString);
        }
    }
    
    
    /**
     * Executes {@link #getOptionPositionAsOf(java.util.Date, String, String, java.math.BigDecimal, org.marketcetera.trade.OptionType)}
     */
    private void doGetOptionPositionAsOf(boolean duringStart)
    {
        String optionRoot = getProperty("optionRoot");
        String expiry = getProperty("expiry");
        String strikePriceString = getProperty("strikePrice");
        BigDecimal strikePrice = null;
        if(strikePriceString != null) {
            strikePrice = new BigDecimal(strikePriceString);
        }
        String optionTypeString = getProperty("optionType");
        OptionType optionType = null;
        if(optionTypeString != null) {
            optionType = OptionType.valueOf(optionTypeString);
        }
        String dateString = getProperty("date");
        Date date = null;
        if(dateString != null) {
            date = new Date(Long.parseLong(dateString));
        }
        BigDecimal result = getOptionPositionAsOf(date,
                                                  optionRoot,
                                                  expiry,
                                                  strikePrice,
                                                  optionType);
        String resultString;
        if(result == null) {
            resultString = null;
        } else {
            resultString = result.toString();
        }
        if(duringStart) {
            setProperty("optionPositionAsOf",
                        resultString);
        } else {
            setProperty("optionPositionAsOfDuringStop",
                        resultString);
        }
    }
    /**
     * Executes {@link #getAllOptionPositionsAsOf(java.util.Date)}.
     */
    private void doGetAllOptionPositionsAsOf(boolean duringStart)
    {
        String dateString = getProperty("date");
        Date date;
        if(dateString == null) {
            date = null;
        } else {
            date = new Date(Long.parseLong(dateString));
        }
        Map<PositionKey<Option>,BigDecimal> result = getAllOptionPositionsAsOf(date);
        String resultString;
        if(result == null) {
            resultString = null;
        } else {
            resultString = result.toString();
        }
        if(duringStart) {
            setProperty("allOptionPositionsAsOf",
                        resultString);
        } else {
            setProperty("allOptionPositionsAsOfDuringStop",
                        resultString);
        }
    }
    /**
     * Executes {@link #getOptionPositionsAsOf(java.util.Date, String...)}.
     */
    private void doGetOptionPositionsAsOf(boolean duringStart)
    {
        String optionRootsString = getProperty("optionRoots");
        String[] optionRoots = null;
        if(optionRootsString != null &&
                !optionRootsString.isEmpty()) {
            optionRoots = optionRootsString.split(",");
        }
        String dateString = getProperty("date");
        Date date = null;
        if(dateString != null) {
            date = new Date(Long.parseLong(dateString));
        }
        Map<PositionKey<Option>,BigDecimal> result;
        if(getParameter("nullOptionRoot") != null) {
            result = getOptionPositionsAsOf(date,
                                            new String[] { optionRootsString, null } );
        } else if(getParameter("emptyOptionRoot") != null) {
            result = getOptionPositionsAsOf(date,
                                            new String[] { optionRootsString, "" } );
        } else {
            result = getOptionPositionsAsOf(date,
                                            optionRoots);
        }
        String resultString;
        if(result == null) {
            resultString = null;
        } else {
            resultString = result.toString();
        }
        if(duringStart) {
            setProperty("optionPositionsAsOf",
                        resultString);
        } else {
            setProperty("optionPositionsAsOfDuringStop",
                        resultString);
        }
    }
    /**
     * Executes {@link #getUnderlying(String)}. 
     */
    private void doGetUnderlying(boolean duringStart)
    {
        String optionRoot = getProperty("optionRoot");
        String result = getUnderlying(optionRoot);
        String resultString;
        if(result == null) {
            resultString = null;
        } else {
            resultString = result.toString();
        }
        if(duringStart) {
            setProperty("underlying",
                        resultString);
        } else {
            setProperty("underlyingDuringStop",
                        resultString);
        }
    }
    /**
     * Executes {@link #getOptionRoots(String)}.
     */
    private void doGetOptionRoots(boolean duringStart)
    {
        String underlyingSymbol = getProperty("underlyingSymbol");
        Collection<String> result = getOptionRoots(underlyingSymbol);
        String resultString;
        if(result == null) {
            resultString = null;
        } else {
            resultString = result.toString();
        }
        if(duringStart) {
            setProperty("optionRoots",
                        resultString);
        } else {
            setProperty("optionRootsDuringStop",
                        resultString);
        }
    }
}
