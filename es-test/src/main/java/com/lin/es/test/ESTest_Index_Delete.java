package com.lin.es.test;

import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;

/**
 * @author lindaoxiong
 * @date 2021/12/29 19:51
 * @apiNote  删除索引
 */
public class ESTest_Index_Delete {
    public static void main(String[] args) throws Exception {
        RestHighLevelClient esClient = null;
        try {
            //创建ES客户端
            esClient = new RestHighLevelClient(
                    RestClient.builder(new HttpHost("localhost",9200,"http"))
            );
            //查询索引
            DeleteIndexRequest request = new DeleteIndexRequest("User");
            AcknowledgedResponse response = esClient.indices().delete(request, RequestOptions.DEFAULT);

            //响应状态
            System.out.println(response.isAcknowledged());
           
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭ES客户端
            esClient.close();
        }
    }
}
