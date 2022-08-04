import org.apache.commons.cli.*;

import java.io.PrintWriter;

public class CLI2
{

    private static final Option ADD = new Option("a","addition", false,"Add two number");
    private static final Option SUB = new Option("s","subtraction", false,"sub two number");
    private static final Option MUL = new Option("m","multiplication", false,"mul two number");
    private static final Option DIV = new Option("d","division", false,"div two number");

    private static void printHelp(Options options)
    {
        HelpFormatter formatter =  new HelpFormatter();
        PrintWriter pw = new PrintWriter(System.out);
        pw.println("Which type of help you required " + Math.class.getPackage().getImplementationVersion());
        pw.println();
        formatter.printUsage(pw, 100, "  Select one help   ");
        formatter.printOptions(pw,100,options,2,5);
        pw.close();
    }

    public static void main(String[] args)
    {
        CommandLineParser clp = new DefaultParser();

        Options options = new Options();
        options.addOption(ADD);
        options.addOption(SUB);
        options.addOption(MUL);
        options.addOption(DIV);

        try {
            CommandLine cl = clp.parse(options, args);
            int a =0;
            int b=0;

try {
     a = Integer.parseInt(cl.getArgList().get(0));
     b = Integer.parseInt(cl.getArgList().get(1));
}catch (Exception e)
{
    e.printStackTrace();
}
            if (cl.hasOption(ADD.getLongOpt())) {
                System.out.println(a+b);
            } else if (cl.hasOption(SUB.getLongOpt()))
            {
                System.out.println(a-b);
            } else if (cl.hasOption(MUL.getLongOpt()))
            {
                System.out.println(a*b);
            } else if (cl.hasOption(DIV.getLongOpt()))
            {
                System.out.println(a/b);
            }else {
                printHelp( options);
            }
        }catch (Exception e )
        {
            e.printStackTrace();
        }
    }
}
