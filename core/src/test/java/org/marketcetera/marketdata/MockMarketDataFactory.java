package org.marketcetera.marketdata;

import org.marketcetera.core.CoreException;
import org.marketcetera.marketdata.IFeedComponent.FeedType;

/**
 * Test implementation of {@link IMarketDataFeedFactory}.
 *
 * @author <a href="mailto:colin@marketcetera.com">Colin DuPlantis</a>
 * @version $Id: MockMarketDataFactory.java 16154 2012-07-14 16:34:05Z colin $
 * @since 0.5.0
 */
public enum MockMarketDataFactory
        implements IMarketDataFeedFactory<MockMarketDataFeed, MockMarketDataFeedCredentials>
{
    INSTANCE;
    private AbstractMarketDataFeedFactory<MockMarketDataFeed, MockMarketDataFeedCredentials> mInnerFactory =
            new AbstractMarketDataFeedFactory<MockMarketDataFeed, MockMarketDataFeedCredentials>() {
        private static final String PROVIDER = "TEST"; //$NON-NLS-1$

        public String getProviderName()
        {
            return PROVIDER;
        }

        public MockMarketDataFeed getMarketDataFeed()
                throws CoreException
        {
            return new MockMarketDataFeed(FeedType.SIMULATED);
        }                
    };
    public String getProviderName()
    {
        return mInnerFactory.getProviderName();
    }
    /* (non-Javadoc)
     * @see org.marketcetera.marketdata.IMarketDataFeedFactory#getMarketDataFeed()
     */
    @Override
    public MockMarketDataFeed getMarketDataFeed()
            throws CoreException
    {
        return mInnerFactory.getMarketDataFeed();
    }            
}
