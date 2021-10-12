package com.dnslin.dnslin_api.service;

import cn.hutool.core.date.DateUtil;
import com.dnslin.dnslin_api.entity.Cdkey;
import com.dnslin.dnslin_api.exception.AppException;
import com.dnslin.dnslin_api.result.ResponseEnum;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

@Service
public class ReadzipfileService {
    @Resource(name = "JdkRedisTemplate")
    private RedisTemplate redisTemplate;

    private final CloseableHttpClient httpclient = HttpClients.createDefault();


    private final Logger logger = LoggerFactory.getLogger(getClass());

    /*
     *
     *功能描述
     * @author dnslin
     * @date 从URL获取文件
     * @param
     * @return
     */
    public String getTheFileFromTheURL() {
        String url = "https://idea.medeming.com/a/jihuoma1.zip";
        String fileName = url.substring(url.lastIndexOf('/'), url.length());
        File theFileObject = new File("/root/" + fileName);
        try {
            HttpGet httpget = new HttpGet(url);
            HttpResponse response = httpclient.execute(httpget);
            HttpEntity entity = response.getEntity();
            InputStream in = entity.getContent();
            FileOutputStream fout = new FileOutputStream(theFileObject);
            int i = -1;
            byte[] tmp = new byte[1024];
            while ((i = in.read(tmp)) != -1) {
                fout.write(tmp, 0, i);
                //注意这里如果用OutputStream.write(buff)的话，图片会失真
            }
            fout.flush();
            fout.close();
            in.close();
            return fileName;
        } catch (IOException e) {
            new AppException(ResponseEnum.SK_BUSY);

        } catch (UnsupportedOperationException e) {
            new AppException(ResponseEnum.LIST_ERROR);
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                new AppException(ResponseEnum.SK_BUSY);
            }
        }
        return fileName;
    }

    /*
     *
     *功能描述
     * @author dnslin
     * @date 读取zip文件并且存入对象 放到list中
     * @param
     * @return
     */
    public List<Cdkey> readTheFile(String fileName)  {


        ArrayList<Cdkey> cdkeys = new ArrayList<>();

        //获取文件输入流
        try {
            FileInputStream input = new FileInputStream("/root/" + fileName);

            //获取ZIP输入流(一定要指定字符集Charset.forName("GBK")否则会报java.lang.IllegalArgumentException: MALFORMED)
            ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(input), StandardCharsets.UTF_8);

            //定义ZipEntry置为null,避免由于重复调用zipInputStream.getNextEntry造成的不必要的问题
            ZipEntry ze = null;
            int i = 0;
            //循环遍历
            while ((ze = zipInputStream.getNextEntry()) != null) {
                System.out.println("文件名：" + ze.getName() + " 文件大小：" + ze.getSize() + " bytes");
                System.out.println("文件内容：");
                //读取
                BufferedReader br = new BufferedReader(new InputStreamReader(zipInputStream, StandardCharsets.UTF_8));
                String line;
                String now = DateUtil.today();
                //内容不为空，输出
                while ((line = br.readLine()) != null) {
                    System.out.println(i++);
                    Cdkey cdkey = new Cdkey();
                    cdkey.setId(i);
                    cdkey.setDate(now);
                    cdkey.setRemark(ze.getName());
                    cdkey.setKey(line);
                    cdkeys.add(cdkey);
                }
                System.out.println(cdkeys);
            }
            //一定记得关闭流
            zipInputStream.closeEntry();
            input.close();
            depositedInTheRedis(cdkeys);
        } catch (IOException e) {
            new AppException(ResponseEnum.SK_BUSY);
        }
        return cdkeys;
    }

    /*
     *
     *功能描述
     * @author dnslin
     * @date 将list存入redis中
     * @param
     * @return
     */
    public void depositedInTheRedis(List<Cdkey> cdkeys) {
        if (cdkeys.size() != 0 && cdkeys != null) {
            redisTemplate.opsForHash().put("theIdeaActivationCode", DateUtil.today(), cdkeys);
        }
        if (redisTemplate.opsForHash().get("theIdeaActivationCode", DateUtil.today()) != null) {
            logger.debug("添加成功");
        } else {
            logger.debug("添加失败");

        }
    }
    /*
    *
     *功能描述 
     * @author dnslin
     * @date 从缓存中拿取数据
     * @param  
     * @return 
     */
    public List<Cdkey> getItFromTheCache() {
        Object theIdeaActivationCode = redisTemplate.opsForHash().get("theIdeaActivationCode", DateUtil.today());
        List<Cdkey> list = (List<Cdkey>) theIdeaActivationCode;
        return list;
    }


}