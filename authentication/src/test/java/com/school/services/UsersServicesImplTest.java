package com.school.service;

import com.school.models.dao.Users;
import com.school.models.dto.UsersDto;
import com.school.repository.UsersRepository;
import com.school.services.UsersServices;
import com.school.services.impl.UsersServicesImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class UsersServicesImplTest {

    @InjectMocks
    UsersServicesImpl usersService;

    @Mock
    UsersRepository usersRepository;

    @Test
    void deleteUsersTest() throws Exception {

        HttpServletRequest httpServletRequest = Mockito.mock(HttpServletRequest.class);
        HttpSession httpSession = Mockito.mock(HttpSession.class);
        UsersDto usersDto = new UsersDto();
        usersDto.setId(101l);
        usersDto.setEmailId("89vishnu.s@gmail.com");
        Users users = new Users();
        users.setEmailId("89vishnu.s@gmail.com");
        when(usersRepository.findByEmailId("89vishnu.s@gmail.com")).thenReturn(users);
        Users users1 = usersService.deleteUsers(usersDto, httpSession, httpServletRequest);
        assertEquals("89vishnu.s@gmail.com", usersDto.getEmailId());

    }

    @Test
    void savingUsersException() throws Exception {
        Method method = UsersServicesImpl.class.getDeclaredMethod("savingUsers",
                Users.class, Users.class);
        method.setAccessible(true);
        Users users = new Users();
        users.setEmailId("89vishnu.s@gmai.com");
        users.setPassword("1234");
        users.setFirstName("Vishnu");
        users.setFirstName("S");
        users.setPhoneNumber("12344556");
        Assertions.assertThrows(
                Exception.class,
                () -> {
                    method.invoke(usersService, users, users);
                });
    }

    @Test
    void savingUsers() throws Exception {
        Method method = UsersServicesImpl.class.getDeclaredMethod("savingUsers",
                Users.class, Users.class);
        method.setAccessible(true);
        Users users = new Users();
        users.setEmailId("89vishnu.s@gmai.com");
        users.setPassword("1234");
        users.setFirstName("Vishnu");
        users.setFirstName("S");
        users.setPhoneNumber("12344556");
        Assertions.assertThrows(
                Exception.class,
                () -> {
                    method.invoke(usersService, users, null);
                });
    }

}
