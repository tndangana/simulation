package zw.co.tndangana.business.configuration;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

import java.util.Locale;

/**
 *
 * @author Daniel Nkhoma
 */
public class CustomNamingStrategy extends PhysicalNamingStrategyStandardImpl {

    private static final String PLURAL_SUFFIX = "s";

    public static final CustomNamingStrategy INSTANCE = new CustomNamingStrategy();

    @Override
    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {
        return new Identifier(addUnderscores(transformToPluralForm(name.getText())), name.isQuoted());
    }

    @Override
    public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment context) {
        return new Identifier(addUnderscores(name.getText()), name.isQuoted());
    }

    private String transformToPluralForm(String tableNameInSingularForm) {

        tableNameInSingularForm = replaceLast(tableNameInSingularForm, "y", "ies");

        tableNameInSingularForm = replaceLast(tableNameInSingularForm, "x", "xes");

        tableNameInSingularForm = replaceLast(tableNameInSingularForm, "s", "ses");

        tableNameInSingularForm = replaceLast(tableNameInSingularForm, "h", "hes");

        StringBuilder pluralForm = new StringBuilder();
        pluralForm.append(tableNameInSingularForm);

        if (!tableNameInSingularForm.toLowerCase().endsWith("s")) {
            pluralForm.append(PLURAL_SUFFIX);
        }

        return pluralForm.toString();
    }

    private String replaceLast(String tableName, String oldLastString, String newLastString) {
        if (tableName.toLowerCase().endsWith(oldLastString.toLowerCase())) {
            int length = tableName.length();
            tableName = tableName.substring(0, length - 1) + newLastString.toLowerCase();
        }
        return tableName;
    }

    protected static String addUnderscores(String name) {
        final StringBuilder buf = new StringBuilder(name.replace('.', '_'));
        for (int i = 1; i < buf.length() - 1; i++) {
            if (Character.isLowerCase(buf.charAt(i - 1))
                    && Character.isUpperCase(buf.charAt(i))
                    && Character.isLowerCase(buf.charAt(i + 1))) {
                buf.insert(i++, '_');
            }
        }
        return buf.toString().toLowerCase(Locale.ROOT);
    }

}
