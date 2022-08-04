import org.apache.commons.cli.*;

import java.io.PrintWriter;

import static java.lang.System.out;

public class CLI {
    public static void main(String[] args) {
        CommandLineParser parser = new BasicParser();
        Options options = new Options();
        options.addOption("w","whatsNew",true,"Here you read new updates of the application");
        options.addOption("c","contact",true,"Here you contact to customer care");
        options.addOption("h","help",true,"Shows Help option");

        OptionGroup optionGroup = new OptionGroup();
        optionGroup.addOption(new Option("b",false,"byte quote"));
        optionGroup.addOption(new Option("n",true,"num quote"));
        options.addOptionGroup(optionGroup);

        try{
            CommandLine commandLine = parser.parse(options,args);
          /*  System.out.println(commandLine.getOptionValue("a"));
            System.out.println(commandLine.getOptionValue("b"));*/

         /*   if (commandLine.hasOption("w"))
            {*/
                HelpFormatter formatter = new HelpFormatter();
                formatter.printUsage(new PrintWriter(out),80,"app",options);
                formatter.printHelp("*** Help Option ***", options);
          //  }
        }catch (ParseException e)
        {
            e.printStackTrace();
        }
    }
}
