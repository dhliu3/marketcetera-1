package org.marketcetera.core.resourcepool;

import org.marketcetera.util.misc.ClassVersion;
import org.springframework.context.Lifecycle;

/* $License$ */

/**
 * Provides access to a group of similar resources.
 *
 * @author <a href="mailto:colin@marketcetera.com">Colin DuPlantis</a>
 * @version $Id: ResourcePool.java 16901 2014-05-11 16:14:11Z colin $
 * @since 2.4.0
 */
@ClassVersion("$Id: ResourcePool.java 16901 2014-05-11 16:14:11Z colin $")
public interface ResourcePool<ResourceClazz extends Resource<ResourceAllocationHintClazz>,ResourceAllocationHintClazz>
        extends Lifecycle
{
    /**
     * Gets the resource pool status.
     *
     * @return a <code>ResourcePoolStatus</code> value
     */
    ResourcePoolStatus getStatus();
    /**
     * Gets a resource from the pool with no allocation hint.
     *
     * <p>The caller must {@link #returnResource(Resource) return} allocated
     * resources after use.
     * 
     * @return a <code>ResourceClazz</code> value
     * @throws IllegalArgumentException if no resource is available
     */
    ResourceClazz getResource();
    /**
     * Gets a resource from the pool with the given allocation hint.
     *
     * <p>The caller must {@link #returnResource(Resource) return} allocated
     * resources after use.
     *
     * @return a <code>ResourceClazz</code> value
     * @throws IllegalArgumentException if no resource is available
     */
    ResourceClazz getResource(ResourceAllocationHintClazz inHint);
    /**
     * Returns an allocated resource to the resource pool.
     *
     * <p>If the resource is not returned to the pool, it will not be
     * allocated for future use.
     *
     * @param inResource a <code>ResourceClazz</code> value
     */
    void returnResource(ResourceClazz inResource);
}
