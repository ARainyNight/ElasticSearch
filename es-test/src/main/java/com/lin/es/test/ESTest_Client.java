package com.lin.es.test;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.transport.TransportClient;

import java.io.IOException;

/**
 * @author lindaoxiong
 * @date 2021/12/29 19:51
 * @apiNote
 */
public class ESTest_Client {
    public static void main(String[] args) throws Exception {
        //创建ES客户端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))
        );
        
        //关闭ES客户端
        esClient.close();
    }
}
