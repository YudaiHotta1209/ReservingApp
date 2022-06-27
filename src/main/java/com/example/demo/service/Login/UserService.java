package com.example.demo.service.Login;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Login.User;
import com.example.demo.mapper.Register.UserMapper;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class UserService {

	private final UserMapper userMapper;
	private final PasswordEncoder passwordEncoder;

	//全件取得処理
	@PreAuthorize("hasAuthority('ADMIN')")
	public List<User> findAll() {
		return userMapper.findAll();
	}
	
	//登録処理
	@PreAuthorize("hasAuthority('ADMIN')")
	public void create(String username, String password, String authority) {
		var encodedPassword = passwordEncoder.encode(password);
		userMapper.insert(username, encodedPassword, authority);
	}

}
