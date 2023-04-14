package coe692.lab5.freelancer.business;

import javax.net.ssl.SSLException;
import java.io.IOException;
import io.kubemq.sdk.basic.ServerAddressNotSuppliedException;
import io.kubemq.sdk.event.Event;
import io.kubemq.sdk.tools.Converter;

public class Messaging {

    public static void sendmessage(String message) throws IOException {
        String channelName = "freelancer_channel";
        String clientID = "freelancer-subscriber";
        String kubeMQAddress = System.getenv("kubeMQAddress");

        io.kubemq.sdk.event.Channel channel
                = new io.kubemq.sdk.event.Channel(channelName, clientID, false, kubeMQAddress);

        channel.setStore(true);
        Event event = new Event();
        event.setBody(Converter.ToByteArray(message));
        event.setEventId("event-Store-");

        try {
            channel.SendEvent(event);
        } catch (SSLException e) {
            System.out.printf("SSLException: %s", e.getMessage());
            e.printStackTrace();
        } catch (ServerAddressNotSuppliedException e) {
            System.out.printf("ServerAddressNotSuppliedException: %s", e.getMessage());
            e.printStackTrace();
        }
    }
}
