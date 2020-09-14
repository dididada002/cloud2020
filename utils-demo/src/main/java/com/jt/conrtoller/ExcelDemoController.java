package com.jt.conrtoller;

import com.jt.entity.vo.excel.UserVO;
import com.jt.service.IExcelService;
import com.jt.utils.EasyExcelUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author: jingteng
 * @date: 2020/9/14 22:02
 */
@RestController
@RequestMapping("/excel")
@Slf4j
public class ExcelDemoController {

    @Autowired
    private IExcelService iExcelService;

    /**
     * 上传excel并解析
     * @param file
     * @return
     */
    @PostMapping("/read")
    public Object uploadExcel(@RequestParam("file")MultipartFile file){
        return EasyExcelUtil.readExcel(file, new UserVO());
    }

}
