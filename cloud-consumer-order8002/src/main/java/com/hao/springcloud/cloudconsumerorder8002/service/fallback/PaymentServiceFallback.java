package com.hao.springcloud.cloudconsumerorder8002.service.fallback;

import com.hao.cloudapicommons.bean.Payment;
import com.hao.springcloud.cloudconsumerorder8002.service.PaymentService;
import org.springframework.stereotype.Service;

public class PaymentServiceFallback implements  PaymentService{



        @Override
        public String paymentInfo_TimeOut(Integer id) {
            return "兜底方法----paymentInfo_TimeOut";
        }

        @Override
        public Payment getPayMent001(long id) {
            return null;
        }

        @Override
        public String run3s() {
            return "兜底方法----run3s";
        }

}
