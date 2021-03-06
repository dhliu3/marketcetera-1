import org.marketcetera.strategy.java.Strategy;
import org.marketcetera.test.StrategyB;

/* $License$ */

/**
 * Strategy which depends on another strategy to compile. 
 *
 * @author <a href="mailto:colin@marketcetera.com">Colin DuPlantis</a>
 * @version $Id: StrategyA.java 16154 2012-07-14 16:34:05Z colin $
 * @since 2.1.0
 */
public class StrategyA
        extends Strategy
{
    private static final StrategyB strategyB = new StrategyB();
    /* (non-Javadoc)
     * @see org.marketcetera.strategy.java.Strategy#onStart()
     */
    @Override
    public void onStart()
    {
        setProperty("onStart",
                    Long.toString(System.currentTimeMillis()));
    }
}
