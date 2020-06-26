package com.hao.springcloud.cloudconsumerorder8002.controller;

import com.hao.springcloud.cloudconsumerorder8002.utils.ExcelUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApiIgnore
@Api(tags = "Excel处理类")
@RestController
@Slf4j
public class ExcelController {


    @ApiOperation(value = "adf-value",notes ="上传Excel-notes" )
    @PostMapping("/uploadExcel")
    public Map<String,Object> uploadExcel(HttpServletRequest request) throws IOException {

        MultipartHttpServletRequest mpRequest = (MultipartHttpServletRequest) request;


        MultipartFile file = mpRequest.getFile("file");

        String originalFilename = file.getOriginalFilename();
        log.info("上传excel:"+originalFilename);

        Map<String,Object> map = new HashMap<>();

        if (file.isEmpty()) {
            map.put("masge","文件不能为空");
            return map;
        }
        InputStream inputStream = null;

        try {
             inputStream = file.getInputStream();

            List<List<Object>> list = ExcelUtils.excelToShopIdList(inputStream, originalFilename);

            for (int i = 0; i < list.size(); i++) {
                List<Object> lo = list.get(i);

                System.out.println(lo);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {

            if(inputStream!=null)
            inputStream.close();

        }


        map.put("masge","成功！");

        return map;
    }




}
