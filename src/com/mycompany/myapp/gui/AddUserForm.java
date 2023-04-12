/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.entities.User;
import com.mycompany.myapp.services.ServiceUser;

/**
 *
 * @author Ousse
 */
public class AddUserForm extends Form{
    public AddUserForm(Form previous){
    setTitle("Add new User");
    setLayout(BoxLayout.y());
    
    TextField uNom=new TextField("","user name");
    TextField uPrenom=new TextField("","user Lastname");
    Button btnValider = new Button("ajouter user");
    
    btnValider.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent evt){
        if (uNom.getText().length()==0||uPrenom.getText().length()==0){
        Dialog.show("Alert","Please fill all fields",new Command ("OK"));
        
        }else{
            try{
        User u= new User (uNom.getText(),uPrenom.getText());
            if(new ServiceUser().addUser(u))
                Dialog.show("Success","connection accepted",new Command("Ok"));
            else{
                Dialog.show("EROOR","Server failed",new Command("Ok"));
            }
                
            }catch(Exception e){}
        
            }
        
        
    }
    });
    
    
    addAll(uNom,uPrenom,btnValider);
    
    
    
    
    
    getToolbar().addMaterialCommandToLeftBar("",FontImage.MATERIAL_ARROW_BACK,e->previous.showBack());
    }
    
}
