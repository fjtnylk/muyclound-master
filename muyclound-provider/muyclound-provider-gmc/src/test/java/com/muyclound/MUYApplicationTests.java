package com.muyclound;

import java.util.Map;
import javax.annotation.Resource;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@WebAppConfiguration
public class MUYApplicationTests {
  @Resource
  private WebApplicationContext context;
  @Resource
  protected MockMvc mockMvc;

  @Before
  public void setup() {
    mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
  }

  protected ResultActions post(String url, String content) throws Exception {
    return mockMvc
        .perform(
            MockMvcRequestBuilders
                .post(url)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(content)
                .accept(MediaType.APPLICATION_JSON));
        //.andExpect(MockMvcResultMatchers.status().isOk())
        //.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
        //.andExpect(MockMvcResultMatchers.jsonPath("$.code").value("200"))
        //.andExpect(MockMvcResultMatchers.jsonPath("$.message").value("ok"))
        //.andExpect(MockMvcResultMatchers.jsonPath("$.response.is_success").value(true));
  }

  protected void get(String url, Map<String, Object> parameters) throws Exception {
    mockMvc
        .perform(
            MockMvcRequestBuilders
                .get(url)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .param("", "")
                .accept(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(MockMvcResultMatchers.jsonPath("$.code").value("200"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("ok"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.response.is_success").value(true));
  }
}
