package onlinerBy;

import logging.CustomLogger;
import org.apache.commons.cli.*;
import org.apache.logging.log4j.Level;

public class OptionsChecker {
    public CommandLine check(String[] args){
        Options options = new Options();

        Option searchConfig = new Option("c", "searchConfig", true, "file with search configuration ");
        searchConfig.setRequired(true);
        options.addOption(searchConfig);

        Option searchType = new Option("t", "searchType", true, "type of search");
        searchType.setRequired(true);
        options.addOption(searchType);

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd = null;

        try {
            cmd = parser.parse(options, args);
            CustomLogger.logger.log(Level.DEBUG, "Command line arguments has been checked");
        } catch (ParseException e) {
            CustomLogger.logger.log(Level.ERROR, "Mandatory option doesn't exist");
            System.out.println(e.getMessage());
            formatter.printHelp("utility-name", options);

            System.exit(1);
        }

        return cmd;
    }
}
