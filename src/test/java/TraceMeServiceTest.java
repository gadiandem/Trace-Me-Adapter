import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.traceme.api.config.ApplicationConfig;
import com.traceme.api.model.finalise.request.FinaliseRequest;
import com.traceme.api.model.finalise.response.FinaliseResponse;
import com.traceme.api.model.premium.request.PremiumRequest;
import com.traceme.api.model.premium.response.PremiumResponse;
import com.traceme.api.model.purchase.request.PurchaseRequest;
import com.traceme.api.model.purchase.response.PurchaseResponse;
import com.traceme.api.service.TraceMeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class, loader = AnnotationConfigContextLoader.class)
public class TraceMeServiceTest {
    private TraceMeService traceMeService;

    @Autowired
    public void setTraceMeService(TraceMeService traceMeService) {
        this.traceMeService = traceMeService;
    }

    @Before
    public void setUp() {
        // run before test method
    }

    @Test
    public void testPremiumApi() {
        String data = "{\n" +
                "    \"agency_id\": \"481\",\n" +
                "    \"agency_code\": \"g05F7Mbn\",\n" +
                "    \"product_id\": \"trace_me\",\n" +
                "    \"journey_id\": \"single\",\n" +
                "    \"start_date\": \"2021-07-10\",\n" +
                "    \"end_date\": \"2021-07-12\",\n" +
                "    \"luggage_count\": 2\n" +
                "}";
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
        PremiumRequest request = gson.fromJson(data, PremiumRequest.class);

        PremiumResponse response = traceMeService.premium(request);
        assertNotNull(response);
    }

    @Test
    public void testFinaliseApi() {
        String data = "{\n" +
                "    \"agency_id\": \"481\",\n" +
                "    \"agency_code\": \"g05F7Mbn\",\n" +
                "    \"quote_id\": \"52847\",\n" +
                "    \"scheme_id\": \"429\",\n" +
                "    \"title_customer\": \"Mr\",\n" +
                "    \"first_name_customer\": \"dennis\",\n" +
                "    \"last_name_customer\": \"Bloggs\",\n" +
                "    \"email\": \"gadiandem19.tl@gmail.com\",\n" +
                "    \"mobile\": \"0358964922\"\n" +
                "}";
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
        FinaliseRequest request = gson.fromJson(data, FinaliseRequest.class);

        FinaliseResponse response = traceMeService.finalise(request);
        assertNotNull(response);
    }

    @Test
    public void testPurchaseApi() {
        String data = "{\n" +
                "    \"agency_id\": \"481\",\n" +
                "    \"agency_code\": \"g05F7Mbn\",\n" +
                "    \"policy_id\": \"22040\"\n" +
                "}";
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
        PurchaseRequest request = gson.fromJson(data, PurchaseRequest.class);

        PurchaseResponse response = traceMeService.purchase(request);
        assertNotNull(response);
    }

}
