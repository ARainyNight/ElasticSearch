package com.lin.es.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

/**
 * @author lindaoxiong
 * @date 2021/12/29 19:51
 * @apiNote  批量插入数据
 */
public class ESTest_Doc_Insert_Batch {
    public static void main(String[] args) throws Exception {
        RestHighLevelClient esClient = null;
        try {
            //创建ES客户端
            esClient = new RestHighLevelClient(
                    RestClient.builder(new HttpHost("localhost",9200,"http"))
            );
           
            //批量插入数据
            BulkRequest request = new BulkRequest();

            
            request.add(new IndexRequest().index("user").id("1001").source(XContentType.JSON, "name", "张三","age","30","sex","男"));
            request.add(new IndexRequest().index("user").id("1002").source(XContentType.JSON, "name", "李四","age","30","sex","女"));
            request.add(new IndexRequest().index("user").id("1003").source(XContentType.JSON, "name", "王五","age","40","sex","男"));
            request.add(new IndexRequest().index("user").id("1004").source(XContentType.JSON, "name", "王五1","age","40","sex","女"));
            request.add(new IndexRequest().index("user").id("1005").source(XContentType.JSON, "name", "王五2","age","50","sex","男"));
            request.add(new IndexRequest().index("user").id("1006").source(XContentType.JSON, "name", "王五3","age","50","sex","男"));
            BulkResponse response = esClient.bulk(request, RequestOptions.DEFAULT);
            System.out.println(response.getTook());
            System.out.println(response.getItems());

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭ES客户端
            esClient.close();
        }
    }
}
