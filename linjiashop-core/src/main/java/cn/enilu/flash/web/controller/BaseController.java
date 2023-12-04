package cn.enilu.flash.web.controller;


import cn.enilu.flash.security.JwtUtil;
import cn.enilu.flash.utils.HttpUtil;
import cn.enilu.flash.utils.JsonUtil;
import cn.enilu.flash.utils.StringUtil;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLDecoder;

/**
 * 基础controller
 *
 * @author enilu
 * @version 2018-07-25
 */
public class BaseController {
    protected static Logger logger = LoggerFactory.getLogger(BaseController.class);
    public Long getIdUser( ) {
        String token = HttpUtil.getRequest().getHeader("Authorization");

        Long idUser = JwtUtil.getUserId(token);
        if (idUser == null) {
            throw new RuntimeException("用户不存在");
        }
        return idUser;
    }
    /**
     * 根据token获取用户id，如果不存在则抛出异常
     *
     * @param request
     * @return
     */
    public Long getIdUser(HttpServletRequest request) {
        String token = request.getHeader("Authorization");

        Long idUser = JwtUtil.getUserId(token);
        if (idUser == null) {
            throw new RuntimeException("用户不存在");
        }
        return idUser;
    }

    /**
     * 获取客户端token
     *
     * @param request
     * @return
     */
    public String getToken(HttpServletRequest request) {
        return request.getHeader("Authorization");
    }

    public String getToken() {
        return HttpUtil.getRequest().getHeader("Authorization");
    }

    /**
     * 获取前端传递过来的json字符串<br>
     * 如果前端使用axios的data方式传参则使用改方法接收参数
     *
     * @return
     */
    public String getjsonReq() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(HttpUtil.getRequest().getInputStream()));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);

            }
            br.close();
            if (sb.length() < 1) {
                return "";
            }
            String reqBody = URLDecoder.decode(sb.toString(), "UTF-8");
            reqBody = reqBody.substring(reqBody.indexOf("{"));
            return reqBody;

        } catch (IOException e) {

            logger.error("获取json参数错误！{}", e.getMessage());

            return "";

        }

    }

    public <T> T getFromJson(Class<T> klass) {
        String jsonStr = getjsonReq();
        if (StringUtil.isEmpty(jsonStr)) {
            return null;
        }
        return JsonUtil.fromJson(klass,jsonStr);
    }
    public String detectOS(HttpServletRequest req) {
        if (req != null) {
            UserAgent userAgent = UserAgent.parseUserAgentString(req.getHeader("User-Agent"));
            OperatingSystem os = userAgent.getOperatingSystem();
            return os.getName();
        }
        return null;
    }

}
