package zw.co.tndangana.web.pages.security;



import zw.co.tndangana.business.domain.Role;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Locale;

public class GeneralUtils implements Serializable {

    public static String getRoles(Role... roles) throws Exception {
        if ((roles == null) || (roles.length < 1)) {
            throw new Exception("Roles can not be empty");
        }

        String strRoles = "";
        int i = 0;
        int n = roles.length - 1;

        for (Role role : roles) {
            strRoles += role.toString();

            if (i < n) {
                strRoles += ",";
            }

            i++;
        }

        return strRoles;
    }

    public static String formatDecimalAsCurrency(BigDecimal numberToFormat) {
        return DecimalFormat.getCurrencyInstance(Locale.US).format(numberToFormat);
    }

}
