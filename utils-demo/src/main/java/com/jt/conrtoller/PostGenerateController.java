package com.jt.conrtoller;

import com.jt.service.IPostGenerateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author: jingteng
 * @date: 2020/9/14 21:24
 */
@RestController
@RequestMapping("/img")
@Slf4j
public class PostGenerateController {

    @Autowired
    private IPostGenerateService iPostGenerateService;

    /**
     * 测试生成海报
     */
    @GetMapping("/test/generate")
    public void testGenerateImg() throws IOException {
        iPostGenerateService.testGeneratePost();
    }

}
