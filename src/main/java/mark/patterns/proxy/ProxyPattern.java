package mark.patterns.proxy;

import java.util.ArrayList;

interface Connection {
    void connectTo(String hostName);
}

class RealConnection implements Connection{
    @Override
    public void connectTo(String hostName) {
        System.out.println("Connecting to "+ hostName);
    }
}


class ProxyConnection implements Connection{
    private final Connection connection = new RealConnection();
    ArrayList<String> listUnreachable;
    static ArrayList<String> log;

    ProxyConnection(){
        listUnreachable = new ArrayList<>();
        log = new ArrayList<>();
        listUnreachable.add("ServerPC".toLowerCase());
        listUnreachable.add("ClientPC1".toLowerCase());
        listUnreachable.add("ClientPC2".toLowerCase());
        listUnreachable.add("CustomerPC10".toLowerCase());
    }

    public static void displayLog(){
        System.out.println("-----------");
        System.out.println("Access Denied for connections to:");
        for (String l: log){
            System.out.println(l);
        }
        System.out.println("-----------");
    }

    @Override
    public void connectTo(String hostName){
        if(listUnreachable.contains(hostName.toLowerCase())){
            log.add(hostName);
            System.out.println("Access Denied");
            return;
        }
        connection.connectTo(hostName);
    }

}

public class ProxyPattern{

    public static void main (String[] args){
        Connection connection = new ProxyConnection();
        connection.connectTo("Manager01");
        connection.connectTo("CustomerPC10");
        connection.connectTo("CustomerPC10");
        connection.connectTo("PC1");
        connection.connectTo("PC15");
        connection.connectTo("CustomerPC10");

        ProxyConnection.displayLog();
    }
}
