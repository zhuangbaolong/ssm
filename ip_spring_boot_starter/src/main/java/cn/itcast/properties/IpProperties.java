package cn.itcast.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component("IpProperties")
@ConfigurationProperties(prefix = "tools.ip")
public class IpProperties {
    /**
     * 日志显示周期
     */
    private Long cycle = 5L;

    /**
     * 是否周期内重置数据
     */
    private Boolean cycleReset = false;

    /**
     * 日志输出模式： detail:详细模式，只输出日志内容，不输出IP地址和端口号；simple:简单模式，只输出IP地址和端口号，不输出日志
     */
    private String mode = LogModel.DETAIL.value;

    public enum LogModel{
        DETAIL("detail"),
        SIMPLE("simple");
        private String value;
        LogModel(String value){
            this.value = value;
        }
        public String getValue(){
            return this.value;
        }
    }

    public Long getCycle() {
        return cycle;
    }

    public void setCycle(Long cycle) {
        this.cycle = cycle;
    }

    public Boolean getCycleReset() {
        return cycleReset;
    }

    public void setCycleReset(Boolean cycleReset) {
        this.cycleReset = cycleReset;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}
