package com.lin.es.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

/**
 * @author lindaoxiong
 * @date 2021/12/29 19:51
 * @apiNote  局部更新-更新文档
 */
public class ESTest_Doc_Update {
    public static void main(String[] args) throws Exception {
        RestHighLevelClient esClient = null;
        try {
            //创建ES客户端
            esClient = new RestHighLevelClient(
                    RestClient.builder(new HttpHost("localhost",9200,"http"))
            );
           
            //插入数据
            UpdateRequest request = new UpdateRequest();
            request.index("user").id("1001");
            request.doc(XContentType.JSON,"sex","女");
            
            UpdateResponse response = esClient.update(request, RequestOptions.DEFAULT);

            System.out.println(response.getResult());

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭ES客户端
            esClient.close();
        }
    }
}
