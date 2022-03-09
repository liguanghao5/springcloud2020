package com.hao.cloudsentinel8100.myBlockHand;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestBlockHand {


    /**
     * 注意:这个兜底的方法必须是 static 静态的方法
     * @param exception
     * @return
     */
    public static String blo_getG(BlockException exception){

        log.info("我是限流兜底的方法loc_getG");
        return "loc_getG";
    }
}
