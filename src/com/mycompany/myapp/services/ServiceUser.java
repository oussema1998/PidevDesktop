/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myapp.services;

import com.mycompany.myapp.entities.User;
import com.mycompany.myapp.utils.Statics;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;

/**
 *
 * @author Ousse
 */
public class ServiceUser {
    public boolean resultOK;
    public boolean addUser(User u){
        String url =Statics.BASE_URL+"/users/"+u.getNom()+"/"+u.getPrenom();
        ConnectionRequest req = new ConnectionRequest(url);
         req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
               resultOK  = req.getResponseCode() == 200; //Code HTTP 200 OK
               
            } 
        });
         NetworkManager.getInstance().addToQueueAndWait(req);
    return resultOK;
    }
    
}
