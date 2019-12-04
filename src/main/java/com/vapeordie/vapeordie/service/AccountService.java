package com.vapeordie.vapeordie.service;

import com.vapeordie.vapeordie.model.Role;
import com.vapeordie.vapeordie.model.User;

public interface AccountService {
  public User saveUser (User user) ;
  public Role saveRole (Role role) ;
 public    User loadUserByEmail ( String email) ;
  public   void addRoleToUser (String Email , String roleName) ;
}
