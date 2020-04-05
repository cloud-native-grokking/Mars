package com.cloudnative.grokking.mars.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.cloudnative.grokking.mars.SpringbootSkeleton;

import java.net.URI;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author vietdv272
 */
@RunWith(SpringRunner.class)
@WebMvcTest(SampleController.class)
@ContextConfiguration(classes= SpringbootSkeleton.class)
public class SampleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testPingPong() throws Exception {
        // GIVEN
        String url = "/ping";

        // WHEN
        mockMvc.perform(get(new URI(url)))
                .andDo(print())
                // THEN
                .andExpect(status().isOk())
                .andExpect(content().string(is("pong")));
    }

}
