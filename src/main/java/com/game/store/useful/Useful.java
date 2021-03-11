package com.game.store.useful;

public class Useful {

	public static Double roundsValue(Double round) {
		Double formattedRoundsValue = Math.round(round * 100.0) / 100.0;
		return formattedRoundsValue;
	}

}
