package me.tomassetti;

import com.beust.jcommander.Parameter;

class CommandLineOptions {

    @Parameter(names = "--debug")
    boolean debug = false;

    @Parameter(names = {"--service-port"})
    Integer servicePort = 4567;

    @Parameter(names = {"--database"})
    String database = "blog";

    @Parameter(names = {"--db-host"})
    String dbHost = "192.168.99.100";

    @Parameter(names = {"--db-username"})
    String dbUsername = "sa";

    @Parameter(names = {"--db-password"})
    String dbPassword = "password";

    @Parameter(names = {"--db-port"})
    Integer dbPort = 5432;
}
