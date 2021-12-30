package com.lin.es.test;

import org.apache.http.HttpHost;
import org.elasticsearch.action.get.GetRequestBuilder;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;

/**
 * @author lindaoxiong
 * @date 2021/12/29 19:51
 * @apiNote  查询索引
 */
public class ESTest_Index_Search {
    public static void main(String[] args) throws Exception {
        RestHighLevelClient esClient = null;
        try {
            //创建ES客户端
            esClient = new RestHighLevelClient(
                    RestClient.builder(new HttpHost("localhost",9200,"http"))
            );
            //查询索引
            GetIndexRequest request = new GetIndexRequest("shopping");
            GetIndexResponse getIndexResponse = esClient.indices().get(request, RequestOptions.DEFAULT);
            
            //响应状态
            System.out.println(getIndexResponse.getAliases());
            System.out.println(getIndexResponse.getMappings());
            System.out.println(getIndexResponse.getSettings());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭ES客户端
            esClient.close();
        }
    }
}
