package com.ssafy.happyhouse.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.Like;
import com.ssafy.happyhouse.model.User;
import com.ssafy.happyhouse.repo.UserRepo;


@Service
public class UserServiceImpl implements UserService {
  
   @Autowired
   private UserRepo repo;
   
   @Override
   public int registerUser(User user) throws Exception {
      // TODO Auto-generated method stub
      return repo.insertUser(user);
   }

   @Override
   public User login(Map<String, String> map) throws Exception {
      // TODO Auto-generated method stub
      if(map.get("user_id") == null || map.get("user_password") == null) {
         return null;
      }
      return repo.login(map);
   }

   @Override
   public User getUser(String user_id) throws Exception {
      // TODO Auto-generated method stub
	   return repo.getUser(user_id);
   }

   @Override
   public User modifyUser(User user, User origin) throws Exception {
      // TODO Auto-generated method stub
	   if(user.getUser_password() == null) {
		   user.setUser_password(origin.getUser_password());
	   }else if(user.getUser_name() == null) {
		   user.setUser_name(origin.getUser_name());
	   }else if(user.getUser_phone_number() == null) {
		   user.setUser_phone_number(origin.getUser_phone_number());
	   }else if(user.getUser_email() == null) {
		   user.setUser_email(origin.getUser_email());
	   }
	   if(repo.updateUser(user) > 0) {
		   return user;
	   }else
		   return null;
   }

   @Override
   public int deleteUser(String user_id) throws Exception {
	   return repo.deleteUser(user_id);
   }


	@Override
	public String findPw(Map<String, String> map) throws Exception {
	//	System.out.println(map.get("userName"));
		return repo.findPw(map);
	}
   
}
