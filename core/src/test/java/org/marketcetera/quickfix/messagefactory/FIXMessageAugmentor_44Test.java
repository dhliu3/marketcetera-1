package org.marketcetera.quickfix.messagefactory;

import org.marketcetera.core.ClassVersion;
import org.marketcetera.core.MarketceteraTestSuite;
import junit.framework.TestCase;
import junit.framework.Test;

/**
 * @author toli
 * @version $Id: FIXMessageAugmentor_44Test.java 16154 2012-07-14 16:34:05Z colin $
 */

@ClassVersion("$Id: FIXMessageAugmentor_44Test.java 16154 2012-07-14 16:34:05Z colin $") //$NON-NLS-1$
public class FIXMessageAugmentor_44Test extends TestCase {
    public FIXMessageAugmentor_44Test(String inName) {
        super(inName);
    }

    public static Test suite() {
        return new MarketceteraTestSuite(FIXMessageAugmentor_44Test.class);
    }

    public void testCountTT_applicableTypes() throws Exception {
        assertEquals(44, new FIXMessageAugmentor_44().getApplicableMsgTypes().size());
    }

}
