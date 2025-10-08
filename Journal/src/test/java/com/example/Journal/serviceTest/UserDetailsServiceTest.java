//package com.example.Journal.serviceTest;
//
//
//import com.example.Journal.Entity.UserEntry;
//import com.example.Journal.Repository.UserRepository;
//import com.example.Journal.Service.UserDetailsServiceImpl;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.*;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.ArrayList;
//
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.mockito.Mockito.when;
//
//public class UserDetailsServiceTest {
//
//    @InjectMocks
//    private UserDetailsServiceImpl userDetailsService;
//
//    @Mock
//     private UserRepository userRepository;
//
//    @BeforeEach
//    void setup(){
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    public void loadByUsernameTest(){
//        when(userRepository.findByUserName(ArgumentMatchers.anyString()))
//                .thenReturn((UserEntry) User.builder().username("Ankit Singh").password("abdsgyeka").roles(String.valueOf(new ArrayList<>())).build());
//        UserDetails User = userDetailsService.loadUserByUsername("Ankit Singh");
//        assertNotNull(User);
//    }
//}
