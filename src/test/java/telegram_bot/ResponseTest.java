package telegram_bot;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ru.kobatejib.telegram.bot.bittrex.dto.Response;
import ru.kobatejib.telegram.bot.bittrex.dto.Summary;
import ru.kobatejib.telegram.bot.bittrex.dto.Ticker;

public class ResponseTest {

	@Test
	public void testSummary() {
		String gsonStr = "{\"success\":true,\"message\":\"\",\"result\":["
				+ "{\"MarketName\":\"BTC-1ST\",\"High\":0.00007449,\"Low\":0.00005600,\"Volume\":959420.33112246,\"Last\":0.00005873,\"BaseVolume\":60.83581233,\"TimeStamp\":\"2017-10-10T08:23:36.47\",\"Bid\":0.00005835,\"Ask\":0.00005873,\"OpenBuyOrders\":136,\"OpenSellOrders\":5927,\"PrevDay\":0.00006545,\"Created\":\"2017-06-06T01:22:35.727\"},"
				+ "{\"MarketName\":\"BTC-2GIVE\",\"High\":0.00000127,\"Low\":0.00000099,\"Volume\":10510925.57092366,\"Last\":0.00000101,\"BaseVolume\":11.62346220,\"TimeStamp\":\"2017-10-10T08:22:41.08\",\"Bid\":0.00000101,\"Ask\":0.00000104,\"OpenBuyOrders\":150,\"OpenSellOrders\":2345,\"PrevDay\":0.00000102,\"Created\":\"2016-05-16T06:44:15.287\"}]}";
		Gson gson = new Gson();
		Type listType = new TypeToken<Response<List<Summary>>>(){}.getType();
		Response<List<Summary>> responseSummaries = gson.fromJson(gsonStr, listType);
		List<Summary> summaries = new ArrayList<Summary>();
		Summary summaryOne = new Summary();
		summaryOne.setMarketName("BTC-1ST");
		summaryOne.setHigh(0.00007449F);
		summaryOne.setLow(0.00005600F);
		summaryOne.setVolume(959420.33112246F);
		summaryOne.setLast(0.00005873F);
		summaryOne.setBaseVolume(60.83581233F);
		summaryOne.setTimeStamp("2017-10-10T08:23:36.47");
		summaryOne.setBid(0.00005835F);
		summaryOne.setAsk(0.00005873F);
		summaryOne.setOpenBuyOrders(136);
		summaryOne.setOpenSellOrders(5927);
		summaryOne.setPrevDay(0.00006545F);
		summaryOne.setCreated("2017-06-06T01:22:35.727");
	
		summaries.add(summaryOne);
		Summary summaryTwo = new Summary();
		summaryTwo.setMarketName("BTC-2GIVE");
		summaryTwo.setHigh(0.00000127F);
		summaryTwo.setLow(0.00000099F);
		summaryTwo.setVolume(10510925.57092366F);
		summaryTwo.setLast(0.00000101F);
		summaryTwo.setBaseVolume(11.62346220F);
		summaryTwo.setTimeStamp("2017-10-10T08:22:41.08");
		summaryTwo.setBid(0.00000101F);
		summaryTwo.setAsk(0.00000104F);
		summaryTwo.setOpenBuyOrders(150);
		summaryTwo.setOpenSellOrders(2345);
		summaryTwo.setPrevDay(0.00000102F);
		summaryTwo.setCreated("2016-05-16T06:44:15.287");
		summaries.add(summaryTwo);
		assertEquals(responseSummaries.getResult(), summaries);
		System.out.println(responseSummaries);
	}

	@Test
	public void testTicker() {
		String gsonStr = "{\"success\" : true,	\"message\" : \"\",	\"result\" : {\"Bid\" : 2.05670368,	\"Ask\" : 3.35579531, \"Last\" : 3.35579531}}";
		Type listType = new TypeToken<Response<Ticker>>(){}.getType();
		Gson gson = new Gson();
		Response<Ticker> responseSummaries = gson.fromJson(gsonStr, listType);
		Ticker ticker = new Ticker();
		ticker.setAsk(3.35579531F);
		ticker.setBid(2.05670368F);
		ticker.setLast(3.35579531F);
		assertEquals(responseSummaries.getResult(), ticker);
		System.out.println(responseSummaries);
	}
}
