package shared;



import client.Client;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.jetbrains.annotations.Nullable;
import shared.antlr4.pattern.PatternLexer;
import shared.antlr4.pattern.PatternParser;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Enumeration;
import java.util.Objects;




public class Utils {

    /**
     *
     * @param ipAddress
     * @param port
     * @param retrials
     * @return true if collnection has been established
     */
    static synchronized public boolean waitConnection(String ipAddress, int port, @Nullable Integer retrials) {

        if (retrials == null) {
            retrials = 50;
        }

        for (int i = 0; i < retrials ; i++) {

            try {
                Runtime runtime = Runtime.getRuntime();
                Process proc = runtime.exec("nc -vz "+ ipAddress + " " + port);

                String result = new String(proc.getErrorStream().readAllBytes());
                result = result + new String(proc.getInputStream().readAllBytes());

                if (result.contains("succeeded") || result.contains("Connected")) {
                    return true;
                } else {
                    Utils.class.wait(500);
                }

            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }


        }


        return false;
    }


    public static final int computeResponsibleWorkerFor(String vertex, int numWorkers) {
        return vertex.hashCode() % numWorkers;
    }


    public static PatternParser getParser(String fName){
        PatternParser patternParser=null;


        try {
            CharStream input= CharStreams.fromFileName(fName);
            PatternLexer lexer= new PatternLexer(input);
            CommonTokenStream tokens= new CommonTokenStream(lexer);
            patternParser=new PatternParser(tokens);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return patternParser;
    }



    public static int countLines(String filename) throws IOException {
        int noOfLines = 1;
        try (FileChannel channel = FileChannel.open(Paths.get(filename), StandardOpenOption.READ)) {
            ByteBuffer byteBuffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
            while (byteBuffer.hasRemaining()) {
                byte currentByte = byteBuffer.get();
                if (currentByte == '\n')
                    noOfLines++;
            }
        }
        return noOfLines;
    }



    public static String getLocalIP() {

        try {
            InetAddress candidateAddress = null;
            // Iterate all NICs (network interface cards)...
            for (Enumeration ifaces = NetworkInterface.getNetworkInterfaces(); ifaces.hasMoreElements();) {
                NetworkInterface iface = (NetworkInterface) ifaces.nextElement();
                // Iterate all IP addresses assigned to each card...
                for (Enumeration inetAddrs = iface.getInetAddresses(); inetAddrs.hasMoreElements();) {
                    InetAddress inetAddr = (InetAddress) inetAddrs.nextElement();
                    if (!inetAddr.isLoopbackAddress()) {

                        if (inetAddr.isSiteLocalAddress()) {
                            // Found non-loopback site-local address. Return it immediately...
                            return inetAddr.getHostAddress();
                        }
                        else if (candidateAddress == null) {
                            // Found non-loopback address, but not necessarily site-local.
                            // Store it as a candidate to be returned if site-local address is not subsequently found...
                            candidateAddress = inetAddr;
                            // Note that we don't repeatedly assign non-loopback non-site-local addresses as candidates,
                            // only the first. For subsequent iterations, candidate will be non-null.
                        }
                    }
                }
            }
            if (candidateAddress != null) {
                // We did not find a site-local address, but we found some other non-loopback address.
                // Server might have a non-site-local address assigned to its NIC (or it might be running
                // IPv6 which deprecates the "site-local" concept).
                // Return this non-loopback candidate address...
                return candidateAddress.getHostAddress();
            }
            // At this point, we did not find a non-loopback address.
            // Fall back to returning whatever InetAddress.getLocalHost() returns...
            InetAddress jdkSuppliedAddress = InetAddress.getLocalHost();
            if (jdkSuppliedAddress == null) {
                return null;
            }
            return jdkSuppliedAddress.getHostAddress();
        }
        catch (Exception e) {
            return null;
        }
    }






    public static String getJarFolder() {
        try {
            return new File(Utils.class.getProtectionDomain().getCodeSource().getLocation().toURI()).toPath().getParent().toString() + File.separator;
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }




    /**
     * look in resources or in folder containing jar
     * @return
     */
    public static String getAkkaConfPath(String file) {

        String protocol = Utils.class.getResource("").getProtocol();
        if(Objects.equals(protocol, "jar")){
            // run in jar
            return Paths.get(getJarFolder(), file).toString();
        } else if(Objects.equals(protocol, "file")) {
            // run in ide
            return Client.class.getResource("/" + file).getPath();
        }
        else throw new RuntimeException("not ide nor jar detected...");
    }



}
