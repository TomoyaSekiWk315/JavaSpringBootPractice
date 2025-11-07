package com.udemy.spring2item.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.udemy.spring2item.model.Item;

@Service
public class ItemService {
	
	List<Item> allItems = Arrays.asList(
			new Item("10001","ネックレス","ジュエリー"),
			new Item("10002","パーカー","ファッション"),
			new Item("10003","フェイスクリーム","ビューティー"),
			new Item("10004","サプリメント","ヘルス"),
			new Item("10005","ブルーベリー","フード"));

	// すべてのアイテムを取得
	 public List<Item> getAllItems(){
		 return allItems;
	 }

	 // 特定アイテムの取得
	 public Item getItem(String itemId){
		 for(int i=0; i < allItems.size(); i++) {
			  if( allItems.get(i).getItemId().equals(itemId)) {
				  return (Item)allItems.get(i);
			  }
		 }
		 return null;
	 }

}
