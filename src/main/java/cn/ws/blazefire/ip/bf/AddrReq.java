package cn.ws.blazefire.ip.bf;

import lombok.Data;

@Data
public class AddrReq {
    private String username;
    private String userKey;
    private String shortCountry;
    private Integer number;
}
