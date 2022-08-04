import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

import java.io.PrintWriter;
import java.io.StringWriter;


import static org.testng.Assert.assertEquals;
import static org.testng.reporters.XMLStringBuffer.EOL;


public class Test {

    @org.testng.annotations.Test
    public void testPrintSortedUsageWithNullComparator()
    {
        Options opts = new Options();
        opts.addOption(new Option("c", "first"));
        opts.addOption(new Option("b", "second"));
        opts.addOption(new Option("a", "third"));

        HelpFormatter helpFormatter = new HelpFormatter();
        helpFormatter.setOptionComparator(null);
        StringWriter out = new StringWriter();
        helpFormatter.printUsage(new PrintWriter(out), 80, "app", opts);
        assertEquals("usage: app [-c] [-b] [-a]"+ EOL, out.toString());
    }


}
