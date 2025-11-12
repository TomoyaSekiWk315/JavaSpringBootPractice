package com.udemy.spring2item.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.udemy.spring2item.model.Item;

@Service
public class ItemService {
	
	List<Item> allItems = new ArrayList<> (Arrays.asList(
			new Item("10001","ネックレス","ジュエリー"),
			new Item("10002","パーカー","ファッション"),
			new Item("10003","フェイスクリーム","ビューティー"),
			new Item("10004","サプリメント","ヘルス"),
			new Item("10005","ブルーベリー","フード")));

	// すべてのアイテムを取得
	
	@Cacheable("getItems")
	 public List<Item> getAllItems(){
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		 return allItems;
	 }

	 // 特定アイテムの取得
	@Cacheable(value="getItem",key="#p0")
	 public Item getItem(String itemId){
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		 for(int i=0; i < allItems.size(); i++) {
			  if( allItems.get(i).getItemId().equals(itemId)) {
				  return (Item)allItems.get(i);
			  }
		 }
		 return null;
	 }
	 
	 @CacheEvict(value="getItems",allEntries=true)
	 public void addItem(Item item) {
		 allItems.add(item);
	 }
	 
	 @Caching(evict = {
			 @CacheEvict(value="getItem",key="#p0"),
			 @CacheEvict(value="getItems",allEntries=true)
	 })
	 public void updateItem(String itemId,Item item) {
		 for(int i=0 ; i<allItems.size(); i++) {
			 if(allItems.get(i).getItemId().equals(itemId)) {
				 allItems.set(i,item);
			 }
		 }
	 }
	 @Caching(evict = {
			 @CacheEvict(value="getItem",key="#p0"),
			 @CacheEvict(value="getItems",allEntries=true)
	 })
	 public void deleteItem(String itemId) {
		 allItems.removeIf(i -> i.getItemId().equals(itemId));
	 }

}
