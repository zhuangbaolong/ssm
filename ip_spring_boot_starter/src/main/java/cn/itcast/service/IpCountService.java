package cn.itcast.service;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class IpCountService {
    private Map<String, Integer> ipCountMap = new HashMap<>();

    @Autowired
    private HttpServletRequest httpServletRequest;

    public void count() {
        //每次调用当前操作，记录当前访问的ip，然后累加访问次数。
        //1.获取当前操作的ip地址
        String ip = httpServletRequest.getRemoteAddr();
        //2.根据ip地址从map取值，并递增。
        Integer count = ipCountMap.get(ip);
        if (count == null){
            ipCountMap.put(ip,1);
        }else {
            ipCountMap.put(ip, ipCountMap.get(ip) + 1);
        }
    }
}
