package telegram_bot;

import com.google.gson.Gson;

import ru.kobatejib.telegram.bot.bittrex.dto.Response;

public class ResponseTest {

	public static void main(String[] args) {
		String gsonStr = "{\"success\":true,\"message\":\"\",\"result\":[{\"MarketName\":\"BTC-1ST\",\"High\":0.00007449,\"Low\":0.00005600,\"Volume\":959420.33112246,\"Last\":0.00005873,\"BaseVolume\":60.83581233,\"TimeStamp\":\"2017-10-10T08:23:36.47\",\"Bid\":0.00005835,\"Ask\":0.00005873,\"OpenBuyOrders\":136,\"OpenSellOrders\":5927,\"PrevDay\":0.00006545,\"Created\":\"2017-06-06T01:22:35.727\"},{\"MarketName\":\"BTC-2GIVE\",\"High\":0.00000127,\"Low\":0.00000099,\"Volume\":10510925.57092366,\"Last\":0.00000101,\"BaseVolume\":11.62346220,\"TimeStamp\":\"2017-10-10T08:22:41.08\",\"Bid\":0.00000101,\"Ask\":0.00000104,\"OpenBuyOrders\":150,\"OpenSellOrders\":2345,\"PrevDay\":0.00000102,\"Created\":\"2016-05-16T06:44:15.287\"}]}";Gson gson = new Gson();
		Response responseSummaries = gson.fromJson(gsonStr, Response.class);
		System.out.println(responseSummaries);
	}
}
