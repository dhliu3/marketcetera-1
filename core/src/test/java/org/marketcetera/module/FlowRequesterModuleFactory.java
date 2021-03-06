package org.marketcetera.module;

import org.marketcetera.util.misc.ClassVersion;

/* $License$ */
/**
 * A Factory that creates modules that are capable of
 * requesting data flows.
 *
 * @author anshul@marketcetera.com
 */
@ClassVersion("$Id: FlowRequesterModuleFactory.java 16154 2012-07-14 16:34:05Z colin $")
public class FlowRequesterModuleFactory
        extends ModuleFactory {
    public FlowRequesterModule create(Object... parameters)
            throws ModuleCreationException {
        return new FlowRequesterModule((ModuleURN)parameters[0]);
    }
    public FlowRequesterModuleFactory() {
        super(PROVIDER_URN, TestMessages.FLOW_REQUESTER_PROVIDER,
                true, false, ModuleURN.class);
    }

    static final ModuleURN PROVIDER_URN = new ModuleURN("metc:flow:single");
}