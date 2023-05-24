package com.adp.change.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adp.change.exceptions.InvalidBillException;
import com.adp.change.exceptions.NotEnoughCoinsException;
import com.adp.change.model.Changes;
import com.adp.change.model.Coins;
import com.adp.change.repo.CoinsRepo;

@Service
public class CoinsService {

	@Autowired
	private CoinsRepo repo;
	
	public Changes checkingAvailableConins(Integer bill) throws InvalidBillException {
		
		List<Integer> validBill = Arrays.asList(1,2,5,10, 20,50,100);
		//Optional<Integer>
		if (!validBill.contains(bill)) {
			throw new InvalidBillException("invalid bill");
		}
		
		
		Double c01CurrentValue = 0d;
		Double c05CurrentValue = 0d;
		Double c10CurrentValue = 0d;
		Double c25CurrentValue = 0d;
		
		Integer c01Count = 0;
		Integer c05Count = 0;
		Integer c10Count = 0;
		Integer c25Count = 0;

		Changes changes = new Changes();
		Double billValue = bill * 1d;
		
		
		List<Coins> coins = repo.getCoins();
		for (Coins c : coins) {
			if (c.getName().equalsIgnoreCase("c01")) {
				c01Count = c.getCount();
				c01CurrentValue = c.getTotalValue();
			} else if (c.getName().equalsIgnoreCase("c05")) {
				c05Count = c.getCount();
				c05CurrentValue = c.getTotalValue();
			} else if (c.getName().equalsIgnoreCase("c10")) {
				c10Count = c.getCount();
				c10CurrentValue = c.getTotalValue();
			} else if (c.getName().equalsIgnoreCase("c25")) {
				c25CurrentValue = c.getTotalValue();
				c25Count = c.getCount();
			}
		}
		

		Double maxCount = 0d;
		
		for (Coins c : coins) {
			if (billValue > 0 && c.getName().equalsIgnoreCase("c01")) {
				maxCount = billValue / c.getCoinValue();
				if (maxCount > c01Count) {
					changes.getC01Cents().setCount(c01Count);
					c.setCount(c.getCount() - c01Count);
					billValue = billValue - c01CurrentValue;
				} else {
					changes.getC01Cents().setCount(maxCount.intValue());
					c.setCount(c.getCount() - maxCount.intValue());
					billValue = billValue - maxCount * c.getCoinValue();
				}
			} else if (billValue > 0 && c.getName().equalsIgnoreCase("c05")) {
				maxCount = billValue / c.getCoinValue();
				if (maxCount > c05Count) {
					changes.getC05Cents().setCount(c05Count);
					c.setCount(c.getCount() - c05Count);
					billValue = billValue - c05CurrentValue;
				} else {
					changes.getC05Cents().setCount(maxCount.intValue());
					c.setCount(c.getCount() - maxCount.intValue());
					billValue = billValue - maxCount * c.getCoinValue();
				}

			} else if (billValue > 0 && c.getName().equalsIgnoreCase("c10")) {
				maxCount = billValue / c.getCoinValue();
				if (maxCount > c10Count) {
					changes.getC10Cents().setCount(c10Count);
					c.setCount(c.getCount() - c10Count);
					billValue = billValue - c10CurrentValue;
				} else {
					changes.getC10Cents().setCount(maxCount.intValue());
					c.setCount(c.getCount() - maxCount.intValue());
					billValue = billValue - maxCount * c.getCoinValue();
				}
			} else if (billValue > 0 && c.getName().equalsIgnoreCase("c25")) {
				if (billValue > 0 && c25CurrentValue > 0d) {
					maxCount = billValue / c.getCoinValue();
					if (maxCount > c25Count) {
						changes.getC25Cents().setCount(c25Count);
						c.setCount(c.getCount() - c25Count);
						billValue = billValue - c25CurrentValue;
					} else {
						changes.getC25Cents().setCount(maxCount.intValue());
						c.setCount(c.getCount() - maxCount.intValue());
						billValue = billValue - maxCount * c.getCoinValue();
					}
				}
			}
		}
		
		if (billValue > 0.0d) {
			throw new NotEnoughCoinsException("not enough coins");
		}
		return changes;
		
		
	}
	
}
