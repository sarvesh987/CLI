import org.apache.commons.cli.*;

public class Check {
    public static void main(String[] args) throws Exception {
        Options options = new Options();
        options.addOption("p", "port", true, "Server Port to connect to");
        options.addOption("?", "help", true, "Usage");
        HelpFormatter formatter = new HelpFormatter();

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, args);

        if (cmd.hasOption("?")) {
            formatter.printHelp("PingClient", options, true);
            return;
        }

        int port = Integer.parseInt(cmd.getOptionValue("p", "8080"));

        System.out.println(String.format("Starting server on port: %d", port));
       // new PingServer(port).run();
        System.out.println("Stopping server...");
    }
}
