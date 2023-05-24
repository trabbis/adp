package com.adp.change.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.adp.change.model.Coin;

@Repository
public class CoinsRepo {

	//TODO better use LinkedHashMap (concurrent linked hashmap)
	//Collections.synchronizedMap(new LinkedHashMap());
	//for more easy to configurable
	private List<Coin> lists = new ArrayList<Coin>();
	
	public CoinsRepo() {
		lists.add(new Coin("c25", 100, 0.25d));
		lists.add(new Coin("c10", 100, 0.10d));
		lists.add(new Coin("c05", 100, 0.05d));
		lists.add(new Coin("c01", 100, 0.01d));
	}
	
	
	public List<Coin> getCoins() {
		return lists;
	}

	public Optional<Coin> getCoin(String code) {
		Coin coin = null;
		for(Coin c: lists) {
			if (c.getCode().equalsIgnoreCase(code)) {
				coin = c;
				break;
			}
		}
		return Optional.of(coin);
		
	}
	public Coin updateCoin(Coin newCoin) {
		Coin updateCoin = null;
		for(Coin coin: lists) {
			if (coin.getCode().equalsIgnoreCase(newCoin.getCode())) {
				coin.setCount(newCoin.getCount());
				updateCoin = coin;
				break;
			}
		}
		return updateCoin;
	}
	
}
