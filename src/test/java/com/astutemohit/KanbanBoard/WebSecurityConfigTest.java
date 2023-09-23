//package com.astutemohit.KanbanBoard;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@RunWith(SpringRunner.class)
//public class WebSecurityConfigTest {
//
//    @Autowired
//    private WebApplicationContext webApplicationContext;
//
//    private MockMvc mockMvc;
//
//    @BeforeEach
//    public void setUp() {
//        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
//    }
//    @Test
//    @WithMockUser(username = "user", roles = "USER") // Simulate a user with USER role
//    public void testUserAccessToTaskEndpoint() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/task"))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//    }
//
//    @Test
//    @WithMockUser(username = "admin", roles = "ADMIN") // Simulate an admin user
//    public void testAdminAccessToPanelEndpoint() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/panel"))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//    }
//
//
//}
