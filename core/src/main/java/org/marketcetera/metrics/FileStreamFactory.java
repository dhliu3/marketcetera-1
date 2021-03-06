package org.marketcetera.metrics;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import org.marketcetera.util.misc.ClassVersion;

/**
 * A factory that summarizes the output onto files created via
 * {@link java.io.File#createTempFile(String, String)}.
 * <p>
 * The files have names matching the pattern
 * <code>thread_name-metrics*.csv</code>, where <i>thread_name</i> is the
 * name of the thread as supplied to {@link #getStream(String)} method.
 *
 * @author anshul@marketcetera.com
 * @version $Id: FileStreamFactory.java 16841 2014-02-20 19:59:04Z colin $
 * @since 2.0.0
 */
@ClassVersion("$Id: FileStreamFactory.java 16841 2014-02-20 19:59:04Z colin $")
class FileStreamFactory implements PrintStreamFactory {
    /**
     * The singleton instance.
     */
    public static final FileStreamFactory INSTANCE = new FileStreamFactory();

    @Override
    public PrintStream getStream(String inName) throws IOException {
        File f = File.createTempFile(inName + "-metrics",  //$NON-NLS-1$
                ".csv");  //$NON-NLS-1$
        Messages.LOG_CREATED_METRICS_FILE.info(this, inName,
                f.getAbsolutePath());
        return new PrintStream(f);
    }

    @Override
    public void done(PrintStream inStream) throws IOException {
        inStream.close();
    }

    /**
     * Prevent instantiation of this class.
     */
    private FileStreamFactory() {
    }
}
