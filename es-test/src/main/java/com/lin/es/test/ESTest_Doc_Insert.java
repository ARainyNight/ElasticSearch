package com.lin.es.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.elasticsearch.common.xcontent.XContentType;

/**
 * @author lindaoxiong
 * @date 2021/12/29 19:51
 * @apiNote  插入数据
 */
public class ESTest_Doc_Insert {
    public static void main(String[] args) throws Exception {
        RestHighLevelClient esClient = null;
        try {
            //创建ES客户端
            esClient = new RestHighLevelClient(
                    RestClient.builder(new HttpHost("localhost",9200,"http"))
            );
           
            //插入数据
            IndexRequest request = new IndexRequest();
            request.index("user").id("1001");
            
            User user = new User();
            user.setName("张三");
            user.setAge(30);
            user.setSex("男");
            
            //向ES插入数据，必须将数据转换为JSON格式
            ObjectMapper mapper = new ObjectMapper();
            String userJson = mapper.writeValueAsString(user);
            request.source(userJson, XContentType.JSON);

            IndexResponse response = esClient.index(request, RequestOptions.DEFAULT);

            System.out.println(response.getResult());

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭ES客户端
            esClient.close();
        }
    }
}
