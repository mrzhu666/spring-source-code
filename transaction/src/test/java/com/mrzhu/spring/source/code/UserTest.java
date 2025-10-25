package com.mrzhu.spring.source.code;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.util.Assert;

import java.util.List;

@Slf4j
@SpringBootTest(classes = TransactionApplication.class)
@ActiveProfiles("test")
public class UserTest {
    

    
    @Test
    public void testSelectList() {
    }
    
}
