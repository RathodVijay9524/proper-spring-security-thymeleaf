package com.vijay.service;

import com.vijay.dtos.UserDto;
import com.vijay.model.Role;
import com.vijay.model.User;
import com.vijay.repo.RoleRepository;
import com.vijay.repo.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipal;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Value("${normal.role.id}")
    private String normalRoleId;

    @Override
    public UserDto addUser(UserDto userDto) {
        User user=new User();
        BeanUtils.copyProperties(userDto,user);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        Role role= roleRepository.findById(normalRoleId).get();
        user.getRoles().add(role);
        User savedUSer= userRepository.save(user);
        BeanUtils.copyProperties(savedUSer,userDto);
        return userDto;
    }






}
