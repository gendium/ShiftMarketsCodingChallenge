/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.challenge.websocket;
import java.io.IOException;
import javax.enterprise.context.ApplicationScoped;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.JsonObject;
import javax.json.spi.JsonProvider;
import javax.websocket.Session;
import org.challenge.model.Symbol;
/**
 *
 * @author GenDium
 */
@ApplicationScoped
public class SessionHandler {
    private final Set<Session> sessions = new HashSet<>();
    private final Symbol symbol = new Symbol();
    
    
    public Symbol getSymbol()
    {
        return this.symbol;
    }
    
    
public void addSession(Session session){
    sessions.add(session);
    JsonObject addMessage = createAddMessage(symbol);
    sendToSession(session, addMessage);
    
}

public void checkCC(String symbol)
{
    this.symbol.setNameAndValue(symbol);
    //create message
    JsonObject addMessage = createAddMessage(this.symbol);
    //sendtoallconnectionsessions
    sendToAllConnectedSessions(addMessage);
}

public void removeSession(Session session){
    sessions.remove(session);
}

    private JsonObject createAddMessage(Symbol symbol){
        JsonProvider provider = JsonProvider.provider();
        JsonObject addMessage = provider.createObjectBuilder()
                .add("action", "check")
                .add("symbol", symbol.getName())
                .add("value", symbol.getValue())
                .build();
        return addMessage;
    }
    

    private void sendToAllConnectedSessions(JsonObject message) {
        for (Session session : sessions) {
            sendToSession(session, message);
        }
    }

    private void sendToSession(Session session, JsonObject message) {
         try {
            session.getBasicRemote().sendText(message.toString());
        } catch (IOException ex) {
            sessions.remove(session);
            Logger.getLogger(SessionHandler.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
}
