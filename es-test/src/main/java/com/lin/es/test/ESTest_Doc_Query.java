package com.lin.es.test;

import org.apache.http.HttpHost;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortOrder;

/**
 * @author lindaoxiong
 * @date 2021/12/29 19:51
 * @apiNote  查询数据
 */
public class ESTest_Doc_Query {
    public static void main(String[] args) throws Exception {
        RestHighLevelClient esClient = null;
        try {
            //创建ES客户端
            esClient = new RestHighLevelClient(
                    RestClient.builder(new HttpHost("localhost",9200,"http"))
            );
           
            //1.查询索引中全部的数据
//            SearchRequest request = new SearchRequest();
//            request.indices("user");
//
//            SearchSourceBuilder query = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//            request.source(query);
//
//            SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
//            SearchHits hits = response.getHits();
//
//            System.out.println(hits.getTotalHits());
//            System.out.println(response.getTook());
//
//            for (SearchHit hit : hits){
//                System.out.println(hit.getSourceAsString());
//            }
            
            //2.条件查询  termQuery
//            SearchRequest request = new SearchRequest();
//            request.indices("user");
//
//            SearchSourceBuilder query = new SearchSourceBuilder().query(QueryBuilders.termQuery("age","30"));
//            request.source(query);
//
//            SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
//            SearchHits hits = response.getHits();
//
//            System.out.println(hits.getTotalHits());
//            System.out.println(response.getTook());
//
//            for (SearchHit hit : hits){
//                System.out.println(hit.getSourceAsString());
//            }
            
            //3.分页查询
//            SearchRequest request = new SearchRequest();
//            request.indices("user");
//
//            SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//            //（当前页码-1）*每页显示数据条数
//            builder.from(2);
//            builder.size(3);
//            request.source(builder);
//            
//            SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
//            SearchHits hits = response.getHits();
//
//            System.out.println(hits.getTotalHits());
//            System.out.println(response.getTook());
//
//            for (SearchHit hit : hits){
//                System.out.println(hit.getSourceAsString());
//            }
            
            //4.查询排序
//            SearchRequest request = new SearchRequest();
//            request.indices("user");
//
//            SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//            builder.sort("age", SortOrder.DESC);
//            request.source(builder);
//
//            SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
//            SearchHits hits = response.getHits();
//
//            System.out.println(hits.getTotalHits());
//            System.out.println(response.getTook());
//
//            for (SearchHit hit : hits){
//                System.out.println(hit.getSourceAsString());
//            }
            
            //5.过滤字段
//            SearchRequest request = new SearchRequest();
//            request.indices("user");
//
//            SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//            //排除某个字段
//            String[] excludes = {"age"};
//            //包含某个字段
//            String[] includes = {};
//            builder.fetchSource(includes,excludes);
//            
//            request.source(builder);
//
//            SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
//            SearchHits hits = response.getHits();
//
//            System.out.println(hits.getTotalHits());
//            System.out.println(response.getTook());
//
//            for (SearchHit hit : hits){
//                System.out.println(hit.getSourceAsString());
//            }
            
            //6.组合查询
//            SearchRequest request = new SearchRequest();
//            request.indices("user");
//
//            SearchSourceBuilder builder = new SearchSourceBuilder();
//            BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
//
////            boolQueryBuilder.must(QueryBuilders.matchQuery("age","30"));
////            boolQueryBuilder.must(QueryBuilders.matchQuery("sex","男"));
////            boolQueryBuilder.mustNot(QueryBuilders.matchQuery("sex","男"));
//            boolQueryBuilder.should(QueryBuilders.matchQuery("age","30"));
//            boolQueryBuilder.should(QueryBuilders.matchQuery("age","40"));
//
//            builder.query(boolQueryBuilder);
//            request.source(builder);
//
//            SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
//            SearchHits hits = response.getHits();
//
//            System.out.println(hits.getTotalHits());
//            System.out.println(response.getTook());
//
//            for (SearchHit hit : hits){
//                System.out.println(hit.getSourceAsString());
//            }

            //7.范围查询
//            SearchRequest request = new SearchRequest();
//            request.indices("user");
//
//            SearchSourceBuilder builder = new SearchSourceBuilder();
//            RangeQueryBuilder rangeQuery = QueryBuilders.rangeQuery("age");
//            rangeQuery.gte("30");
//            rangeQuery.lt("50");
//            
//            builder.query(rangeQuery);
//            request.source(builder);
//
//            SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
//            SearchHits hits = response.getHits();
//
//            System.out.println(hits.getTotalHits());
//            System.out.println(response.getTook());
//
//            for (SearchHit hit : hits){
//                System.out.println(hit.getSourceAsString());
//            }

            //8.模糊查询
//            SearchRequest request = new SearchRequest();
//            request.indices("user");
//
//            SearchSourceBuilder builder = new SearchSourceBuilder();
//            //Fuzziness.ONE表示差一个字左右也可以
//            FuzzyQueryBuilder fuzziness = QueryBuilders.fuzzyQuery("name", "王五").fuzziness(Fuzziness.ONE);
//
//
//            builder.query(fuzziness);
//            request.source(builder);
//
//            SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
//            SearchHits hits = response.getHits();
//
//            System.out.println(hits.getTotalHits());
//            System.out.println(response.getTook());
//
//            for (SearchHit hit : hits){
//                System.out.println(hit.getSourceAsString());
//            }

            //9.高亮查询
//            SearchRequest request = new SearchRequest();
//            request.indices("user");
//
//            SearchSourceBuilder builder = new SearchSourceBuilder();
//            MatchPhraseQueryBuilder matchPhraseQueryBuilder = QueryBuilders.matchPhraseQuery("name", "王五");
//
//            HighlightBuilder highlightBuilder = new HighlightBuilder();
//            highlightBuilder.preTags("<font color='red'>");
//            highlightBuilder.postTags("</font>");
//            highlightBuilder.field("name");
//
//            builder.highlighter(highlightBuilder);
//            builder.query(matchPhraseQueryBuilder);
//
//            request.source(builder);
//            SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
//            SearchHits hits = response.getHits();
//
//            System.out.println(hits.getTotalHits());
//            System.out.println(response.getTook());
//
//            for (SearchHit hit : hits){
//                System.out.println(hit.getSourceAsString());
//            }
            
            //10.聚合查询
//            SearchRequest request = new SearchRequest();
//            request.indices("user");
//
//            SearchSourceBuilder builder = new SearchSourceBuilder();
//            AggregationBuilder aggregationBuilder = AggregationBuilders.max("maxAge").field("age");
//            builder.aggregation(aggregationBuilder);
//            request.source(builder);
//            SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
//            SearchHits hits = response.getHits();
// 
//            System.out.println(hits.getTotalHits());
//            System.out.println(response.getTook());
//
//            for (SearchHit hit : hits){
//                System.out.println(hit.getSourceAsString());
//            }
            
            //11.分组查询
            SearchRequest request = new SearchRequest();
            request.indices("user");

            SearchSourceBuilder builder = new SearchSourceBuilder();
            AggregationBuilder aggregationBuilder = AggregationBuilders.terms("ageGroup").field("age");
            builder.aggregation(aggregationBuilder);
            request.source(builder);
            SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
            SearchHits hits = response.getHits();

            System.out.println(hits.getTotalHits());
            System.out.println(response.getTook());

            for (SearchHit hit : hits){
                System.out.println(hit.getSourceAsString());
            }
            
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭ES客户端
            esClient.close();
        }
    }
}
