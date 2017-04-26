package zw.co.tndangana.web.configuration;

import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.string.StringValue;

/**
 *
 * @author Tonderai Ndangana 21/04/2016
 */
public class SimulationPageParametersUtil {

    public final static String demoID = "demoId";
    public final static String PAGE = "page";
    public final static String SEARCH = "search";
    public final static String ID = "id";

    private SimulationPageParametersUtil() {
    }

    public static Long extractId(PageParameters parameters, String IdName) {
        StringValue idStringValue = parameters.get(IdName);
        Long id = null;
        if (idStringValue != null) {

            try {
                id = Long.valueOf(idStringValue.toString());

            } catch (NumberFormatException ex) {
                id = null;
            }
        }
        return id;
    }

    public static Long extractId(PageParameters parameters) {
        return extractId(parameters, ID);
    }

    public static Long extractDemoId(PageParameters parameters, String IdName) {
        StringValue idStringValue = parameters.get(IdName);
        Long demoId = null;
        if (idStringValue != null) {

            try {
                demoId = Long.valueOf(idStringValue.toString());

            } catch (NumberFormatException ex) {
                demoId = null;
            }
        }
        return demoId;
    }

    public static Long extractDemoId(PageParameters parameters) {
        return extractDemoId(parameters, demoID);
    }
}
