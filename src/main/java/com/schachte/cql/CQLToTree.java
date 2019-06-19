package com.schachte.cql;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


import org.apache.commons.lang.StringEscapeUtils;
import org.geotools.filter.text.cql2.CQLException;
import org.geotools.filter.text.ecql.ECQL;
import org.geotools.filter.v1_0.capabilities.OGCConfiguration;
import org.geotools.xml.Configuration;
import org.geotools.xml.Encoder;
import org.opengis.filter.Filter;

/**
 * Utility tool to enable logging of cql into it's XML tree counterpart
 */
public class CQLToTree {
    public static void main(String[] args) throws IOException {
        System.out.println("                                                                                                                         \n" +
                " ,-----. ,-----.   ,--.         ,--.             ,------.,--.,--.  ,--.                    ,--.   ,--.,--.   ,--.,--.    \n" +
                "'  .--./'  .-.  '  |  |       ,-'  '-. ,---.     |  .---'`--'|  |,-'  '-. ,---. ,--.--.     \\  `.'  / |   `.'   ||  |    \n" +
                "|  |    |  | |  |  |  |       '-.  .-'| .-. |    |  `--, ,--.|  |'-.  .-'| .-. :|  .--'      .'    \\  |  |'.'|  ||  |    \n" +
                "'  '--'\\'  '-'  '-.|  '--.      |  |  ' '-' '    |  |`   |  ||  |  |  |  \\   --.|  |        /  .'.  \\ |  |   |  ||  '--. \n" +
                " `-----' `-----'--'`-----'      `--'   `---'     `--'    `--'`--'  `--'   `----'`--'       '--'   '--'`--'   `--'`-----' \n" +
                "                                                                                                                         ");
        System.out.println("\nView Forms Examples here: https://bit.ly/2Zyssw8");
        System.out.println("View Forms Utility Usage here: https://bit.ly/2Fljomq\n");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        Configuration configuration = new OGCConfiguration();
        Encoder encoder = new org.geotools.xml.Encoder(
                configuration);
        encoder.setIndenting(true);

        while (!(line = reader.readLine()).isEmpty()) {
            line = StringEscapeUtils.unescapeJava(line);
            try {
                Filter filter = ECQL.toFilter(line);
                encoder.encode(filter, org.geotools.filter.v1_0.OGC.Filter, System.out);
            } catch (CQLException e) {
                System.out.println("The input CQL is invalid");
            }
        }
    }
}
