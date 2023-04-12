/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;

/**
 *
 * @author Ousse
 */
public class HomeForm extends Form {
   Form current;
    public HomeForm(){
        current=this;
setTitle("Home");
setLayout(BoxLayout.y());   
add (new Label("choose an Option"));
Button btnAddUser = new Button ("Add User");
Button btnListUser = new Button ("Users List");

btnAddUser.addActionListener(e->new AddUserForm(current).show());
btnListUser.addActionListener(e->new ListUsersForm(current).show());

addAll(btnAddUser,btnListUser);


}
    
}
