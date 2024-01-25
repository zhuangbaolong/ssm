package cn.itcast.service;

import cn.itcast.properties.IpProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

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
        System.out.println("===============================" + ip);
        //2.根据ip地址从map取值，并递增。
        Integer count = ipCountMap.get(ip);
        if (count == null) {
            ipCountMap.put(ip, 1);
        } else {
            ipCountMap.put(ip, ipCountMap.get(ip) + 1);
        }
    }

    @Autowired
    private IpProperties ipProperties;

    //spring内置定时：1.打开开关；2.设置corn
    @Scheduled(cron = "0/#{IpProperties.cycle} * * * * ?")
    public void print() {
        if (ipProperties.getMode().equals(IpProperties.LogModel.DETAIL.getValue())) {
            System.out.println("ip访问监控");
            System.out.println("+-----ip-address-----+--num--+");
            for (Map.Entry<String, Integer> entry : ipCountMap.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();
                System.out.println(String.format("|%18s   |%5d   |", key, value));
            }
            System.out.println("+--------------------+--------+");

        } else if (ipProperties.getMode().equals(IpProperties.LogModel.SIMPLE.getValue())) {
            System.out.println("ip访问监控");
            System.out.println("+-----ip-address-----+");
            for (String key : ipCountMap.keySet()) {
                System.out.println(String.format("|%18s   |", key));
            }
            System.out.println("+--------------------+");
        }

        if (ipProperties.getCycleReset()) {
            ipCountMap.clear();
        }
    }

    public static void main(String[] args) {
        new IpCountService().print();
    }
}
