package test;
import com.project.utils.AppUtils;

import junit.framework.TestCase;
import response.Hotel;
import response.HotelsResponse;

public class ResponseTest extends TestCase {
  
    AppUtils appUtils = new AppUtils();
    public void testIfResponse() {
        String testUrl="https://offersvc.expedia.com/offers/v2/getOffers?scenario=deal-finder&page=foo&uid=foo&productType=Hotel";
        HotelsResponse response = appUtils.getHotelsOffers(testUrl);
        assertNotNull(response);
        assertTrue(response.getOffers().getHotels().get(0) instanceof Hotel);
    }
    
}
