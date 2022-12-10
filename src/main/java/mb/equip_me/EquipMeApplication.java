package mb.equip_me;

import mb.equip_me.services.user.UserServer;
import mb.equip_me.services.registration.RegistrationServer;
import mb.equip_me.services.web.WebServer;

public class EquipMeApplication {

    public static final String NO_VALUE = "NO-VALUE";

    public static void main(String[] args) {

        String serverName = NO_VALUE;
        String port = null;
        System.setProperty(RegistrationServer.REGISTRATION_SERVER_HOSTNAME, "localhost");

        for (String arg : args) {
            if (arg.startsWith("--"))
                continue;

            if (serverName.equals(NO_VALUE))
                serverName = arg;
            else if (port == null)
                port = arg;
            else {
                System.out.println("Unexpected argument: " + arg);
                return;
            }
        }

        if (serverName == NO_VALUE) {
            return;
        }

        if (port != null)
            System.setProperty("server.port", port);

        if(serverName.equals("registration")) {
            RegistrationServer.main(args);
        } else if (serverName.equals("user")) {
            UserServer.main(args);
        } else if (serverName.equals("web")) {
            WebServer.main(args);
        } else {
            System.out.println("Unknown server type: " + serverName);
        }
    }
}
