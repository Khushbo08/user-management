package com.user.service;

import com.user.model.User;
import com.user.repository.UserRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddUser() {
        User user = new User(1L, "JohnDoe", "johndoe@example.com");
        when(userRepository.save(user)).thenReturn(user);
        User savedUser = userService.addUser(user);
        assertEquals(user, savedUser);
    }

    @Test
    public void testGetAllUsers() {
        when(userRepository.findAll()).thenReturn(Collections.emptyList());
        assertEquals(Collections.emptyList(), userService.getAllUser());
    }

    @Test
    public void testGetUser() throws Exception {
        User user = new User(1L, "JohnDoe", "johndoe@example.com");
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        assertEquals(user, userService.getUser(1L));
    }

    @Test
    public void testDeleteUser() {
        doNothing().when(userRepository).deleteById(1L);
        assertEquals(true, userService.deleteUser(1L));
    }

    @Test
    public void testUpdateUser() {
        User user = new User(1L, "JohnDoe", "johndoe@example.com");
        when(userRepository.save(user)).thenReturn(user);
        assertEquals(user, userService.updateUser(1L, user));
    }
}
