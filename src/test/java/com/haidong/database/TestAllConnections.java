package com.haidong.database;
import org.bson.Document;
import org.junit.Test;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class TestAllConnections {
	
	//测试mongoDb
	@Test
	public void test1(){
	      try{   
	       // 连接到 mongodb 服务
	         MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
	         // 连接到数据库
	         MongoDatabase mongoDatabase = mongoClient.getDatabase("test");
	         MongoCollection<Document> collection = mongoDatabase.getCollection("myTeset");
//	         Document document = new Document("title", "MongoDB").  
//	                 append("description", "database").  
//	                 append("likes", 100).  
//	                 append("by", "Fly"); 
//	         collection.insertOne(document);
	         FindIterable<Document> find = collection.find();
	         MongoCursor<Document> iterator = find.iterator();
	         while(iterator.hasNext()){
	        	 System.out.println(iterator.next());
	         }
	         System.out.println(collection.count());
	       System.out.println("Connect to database successfully");
	        
	      }catch(Exception e){
	        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	     }
	}
}
