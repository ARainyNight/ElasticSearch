package com.lin.es.test;

import org.apache.http.HttpHost;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

/**
 * @author lindaoxiong
 * @date 2021/12/29 19:51
 * @apiNote  查询文档
 */
public class ESTest_Doc_Search {
    public static void main(String[] args) throws Exception {
        RestHighLevelClient esClient = null;
        try {
            //创建ES客户端
            esClient = new RestHighLevelClient(
                    RestClient.builder(new HttpHost("localhost",9200,"http"))
            );
           
            //查询数据
            GetRequest request = new GetRequest();
            request.index("user").id("1001");
            GetResponse response = esClient.get(request, RequestOptions.DEFAULT);

            System.out.println(response.getSourceAsString());

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭ES客户端
            esClient.close();
        }
    }
}
