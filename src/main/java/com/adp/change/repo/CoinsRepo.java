package com.adp.change.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.adp.change.model.Coins;

@Repository
public class CoinsRepo {

	private List<Coins> lists = new ArrayList<Coins>();
	
	public CoinsRepo() {
		lists.add(new Coins("c25", 100, 0.25d));
		lists.add(new Coins("c10", 100, 0.10d));
		lists.add(new Coins("c05", 100, 0.05d));
		lists.add(new Coins("c01", 100, 0.01d));
	}
	
	
	public List<Coins> getCoins() {
		return lists;
	}
	
	
}
