package br.com.demos.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class HostInfo {
    
  

    public static String getHostName() {

        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {

            e.printStackTrace();
        }
        return null;
    }

    public static String getHostAddress() {

        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {

            e.printStackTrace();
        }
        return null;
    }

    public static String getCanonicalHostName() {

        try {
            return InetAddress.getLocalHost().getCanonicalHostName();
        } catch (UnknownHostException e) {

            e.printStackTrace();
        }
        return null;
    }
}
