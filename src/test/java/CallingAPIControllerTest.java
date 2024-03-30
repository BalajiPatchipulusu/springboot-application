package com.nagarro.java_mini_assignment_2;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import com.nagarro.java_mini_assignment_2.Controller.CallingAPIController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.nagarro.java_mini_assignment_2.Entity.UserRequest;
import com.nagarro.java_mini_assignment_2.Entity.UserDetailsResponse;
import com.nagarro.java_mini_assignment_2.Response.FinalApiResponse;
import com.nagarro.java_mini_assignment_2.Exception.ErrorMessage;
import com.nagarro.java_mini_assignment_2.Service.RandomUserService;
import com.nagarro.java_mini_assignment_2.Service.UserService;

class CallingAPIControllerTest {

    @Mock
    private RandomUserService randomUserservice;

    @Mock
    private UserService userService;

    @InjectMocks
    private CallingAPIController callingApi;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateUsers_Success() {
        // Mocking
        UserRequest request = new UserRequest(5);
        List<UserDetailsResponse> mockResponse = Arrays.asList(new UserDetailsResponse(), new UserDetailsResponse());

        when(randomUserservice.createUsers(request.getSize())).thenReturn(mockResponse);

        // Execution
        ResponseEntity<?> responseEntity = callingApi.createUsers(request);

        // Assertion
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertTrue(responseEntity.getBody() instanceof List);
        assertEquals(2, ((List<?>) responseEntity.getBody()).size());
    }

    @Test
    void testCreateUsers_Exception() {
        
        UserRequest request = new UserRequest(5);
        when(randomUserservice.createUsers(request.getSize())).thenThrow(new RuntimeException("Test Exception"));

        ResponseEntity<?> responseEntity = callingApi.createUsers(request);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertTrue(responseEntity.getBody() instanceof ErrorMessage);
        assertEquals("page not found, User creation failed", ((ErrorMessage) responseEntity.getBody()).getMessage());
    }

    @Test
    void testGetUsers_Success() {
        String sortType = "Name";
        String sortOrder = "EVEN";
        int limit = 5;
        int offset = 0;

        FinalApiResponse mockResponse = new FinalApiResponse();

        when(userService.getSortedUsers(sortType, sortOrder, limit, offset)).thenReturn(mockResponse);

        ResponseEntity<?> responseEntity = callingApi.getUsers(sortType, sortOrder, limit, offset);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertTrue(responseEntity.getBody() instanceof FinalApiResponse);
    }

    @Test
    void testGetUsers_Exception() {
        String sortType = "Name";
        String sortOrder = "Age";
        int limit = 5;
        int offset = 0;

        when(userService.getSortedUsers(sortType, sortOrder, limit, offset)).thenThrow(new RuntimeException("Test Exception"));

        ResponseEntity<?> responseEntity = callingApi.getUsers(sortType, sortOrder, limit, offset);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertTrue(responseEntity.getBody() instanceof ErrorMessage);
        assertEquals("page not found", ((ErrorMessage) responseEntity.getBody()).getMessage());
    }
}