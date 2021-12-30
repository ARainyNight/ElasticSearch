package com.lin.es.test;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;

/**
 * @author lindaoxiong
 * @date 2021/12/29 19:51
 * @apiNote  创建索引
 */
public class ESTest_Index_Create {
    public static void main(String[] args) throws Exception {
        RestHighLevelClient esClient = null;
        try {
            //创建ES客户端
            esClient = new RestHighLevelClient(
                    RestClient.builder(new HttpHost("localhost",9200,"http"))
            );
            //创建索引
            CreateIndexRequest request = new CreateIndexRequest("User");
            CreateIndexResponse createIndexResponse = esClient.indices().create(request, RequestOptions.DEFAULT);

            //响应状态
            boolean acknowledged = createIndexResponse.isAcknowledged();
            System.out.println("索引操作"+acknowledged);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭ES客户端
            esClient.close();
        }
    }
}
